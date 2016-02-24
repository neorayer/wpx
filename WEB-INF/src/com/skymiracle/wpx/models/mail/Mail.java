package com.skymiracle.wpx.models.mail;

import static com.skymiracle.wpx.Singletons.*;

import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import com.skymiracle.client.tcpClient.smtpClient.SmtpClient;
import com.skymiracle.client.tcpClient.smtpClient.SmtpSendResult;
import com.skymiracle.client.tcpClient.smtpClient.SmtpSendResult.ResultItem;
import com.skymiracle.fileBox.MailBoxLsItem;
import com.skymiracle.io.PlainFile;
import com.skymiracle.io.TextFile;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.mime.Mime;
import com.skymiracle.mime.MimeCreater;
import com.skymiracle.mime.MimeReader;
import com.skymiracle.mime.MimeReaderCachedImpl;
import com.skymiracle.mime.RichMailAddress;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.StorageAccessorFactory;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.IMailAccessor;
import com.skymiracle.server.tcpServer.mailServer.AutoMailMaker;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.util.FileTools;
import com.skymiracle.util.Rfc2047Codec;
import com.skymiracle.util.StringUtils;
import com.skymiracle.wpx.models.user.User;

public class Mail extends MailBoxLsItem {

	public MailFolder folder;

	public Mail(MailFolder folder, String uuid) {
		super();
		this.folder = folder;
		setUuid(uuid);
	}

	public MailFolder getFolder() {
		return folder;
	}

	public void setFolder(MailFolder folder) {
		this.folder = folder;
	}

	@Override
	public String[] keyNames() {
		return null;
	}

	@Override
	public String table() {
		return null;
	}

	/** ************************************ */
	public static class X {

		private StorageAccessorFactory saFactory;
		private MimeReader mimeReader;
		private SmtpClient smtpClient = new SmtpClient();

		public void setSmtpClient(SmtpClient smtpClient) {
			this.smtpClient = smtpClient;
		}

		public void setSaFactory(StorageAccessorFactory saFactory) {
			this.saFactory = saFactory;
		}

		public void setMimeReader(MimeReader mimeReader) {
			this.mimeReader = mimeReader;
		}

		private IMailAccessor UMA(User user) throws AppException,
				Exception {
			return saFactory.getUserStorageMailAccessor(user.getUid(), user
					.getDc(), user.getStorageLocation());
		}

		private IMailAccessor UMA(MailFolder f) throws AppException,
				Exception {
			return UMA(f.owner);
		}

		private List<MailBoxLsItem> findAll(MailFolder f, String sortBy,
				boolean isUp) throws Exception {
			List<MailBoxLsItem> items = findAll(f);
			sortMails(items, sortBy, isUp);
			return items;
		}

		private List<MailBoxLsItem> findAll(MailFolder f) throws Exception {
			return UMA(f).mailLsMail(f.getId());
		}

		private List<MailBoxLsItem> find(MailFolder f, String keyword) throws Exception {
			List<MailBoxLsItem> items = findAll(f);

			keyword = keyword.trim();
			if (keyword == null || keyword.equals(""))
				return items;
			// Fix for compatible old version

			List<MailBoxLsItem> resItems = new LinkedList<MailBoxLsItem>();

			for (MailBoxLsItem item : items) {
				if (item.getSubject().indexOf(keyword) != -1) {
					resItems.add(item);
					continue;
				} else if (item.getTo().trim().indexOf(keyword) != -1) {
					resItems.add(item);
					continue;
				} else {
					RichMailAddress rma = new RichMailAddress(item.getFrom());
					if (rma.getMailAddress().indexOf(keyword) != -1)
						resItems.add(item);
				}

			}
			return resItems;
		}

		private List<MailBoxLsItem> find(MailFolder f, String condition,
				String keyword) throws Exception {
			
			List<MailBoxLsItem> items = findAll(f);
			keyword = keyword.trim();
			
			boolean hasCondition = (condition != null && !condition.equals(""));
			boolean hasKeyword = (keyword != null && !keyword.equals(""));
			if (!hasCondition && !hasKeyword)
				return items;

			//解析条件
			String target = null;
			String op = null;
			if(hasCondition){
				String[] ss = condition.split("\\|");
				target = ss[0];
				op = ss[1];
			}
			
			List<MailBoxLsItem> resItems = new LinkedList<MailBoxLsItem>();

			for (MailBoxLsItem item : items) {
				if(hasKeyword){
					if (item.getSubject().indexOf(keyword) != -1) {
						resItems.add(item);
						continue;
					} else if (item.getTo().trim().indexOf(keyword) != -1) {
						resItems.add(item);
						continue;
					} else {
						RichMailAddress rma = new RichMailAddress(item.getFrom());
						if (rma.getMailAddress().indexOf(keyword) != -1)
							resItems.add(item);
						continue;
					}
				}
				if(hasCondition){
					//TODO 暂时只开通了是否已读
					if (target.equals("read")) {
						if (op.equals("true") && !item.getReaded()){
							resItems.add(item);
							continue;
						}else if(op.equals("false") && item.getReaded()){
							resItems.add(item);
							continue;
						}
					}
				}
				
			}
			return resItems;
		}

		public List<MailBoxLsItem> findNew(MailFolder f, int count)
				throws AppException, Exception {
			List<MailBoxLsItem> newItems = new LinkedList<MailBoxLsItem>();
			List<MailBoxLsItem> items = findAll(f, "lastModified", false);
			int i = 0;
			for (MailBoxLsItem item : items) {
				newItems.add(item);
				if (++i >= count)
					break;
			}
			return newItems;
		}

		public PagedList<MailBoxLsItem> findPaged(MailFolder f, String sortBy,
				boolean isUp, int pageNum, int countPerPage, String linkPreifx,
				String condition, String keyword) throws AppException,
				Exception {

			List<MailBoxLsItem> items = find(f, condition, keyword);
//			List<MailBoxLsItem> items = find(f, keyword);
			sortMails(items, sortBy, isUp);
			int beginNum = countPerPage * (pageNum - 1);
			int endNum = beginNum + countPerPage;
			int itemsSize = items.size();
			endNum = itemsSize < endNum ? itemsSize : endNum;

			PagedList<MailBoxLsItem> resItems = new PagedList<MailBoxLsItem>(
					pageNum, countPerPage, itemsSize, linkPreifx);
			int i = -1;
			int newCount = 0;
			for (MailBoxLsItem item : items) {
				i++;
				if (!item.getReaded())
					newCount++;
				if (i < beginNum)
					continue;
				if (i >= endNum)
					continue;
				resItems.add(item);
			}
			resItems.attr("newCount", newCount);
			return resItems;
		}

		private void sortMails(List<MailBoxLsItem> items, final String sortBy,
				final boolean isUp) {
			Collections.sort(items, new Comparator<MailBoxLsItem>() {

				public int compare(MailBoxLsItem o1, MailBoxLsItem o2) {
					try {
						Object v1 = o1.fieldValue(sortBy);
						Object v2 = o2.fieldValue(sortBy);
						if(v1 instanceof String)
							return Collator.getInstance(Locale.CHINA).compare(v1, v2) * (isUp ? 1 : -1);
						if (v1 instanceof Comparable)
							return ((Comparable) v1).compareTo(v2)
									* (isUp ? 1 : -1);
						return 0;
					} catch (Exception e) {
						Logger.error("", e);
					}
					return 0;
				}
			});

		}

		public Mime getMime(MailFolder f, String uuid) throws AppException,
				Exception {
			File file = new File(this.getMailPath(f, uuid));
			return this.mimeReader.loadMime(file, uuid);
		}

		public String getMailPath(MailFolder f, String uuid)
				throws AppException, Exception {
			return UMA(f).mailRetr(f.getId(), uuid);
		}

		public String submit(User sender, File mimeFile, MimeCreater mc,
				boolean isSend, boolean isSaveDraft, boolean isSaveSent,
				boolean isTimerSend, String sendTime) throws AppException,
				Exception {
			String uuid = UUID.randomUUID().toString();
			String path = mimeFile.getAbsolutePath();

			if (isSaveDraft) {
				UMA(sender).mailStor("draft", uuid, path, false);
			}

			if (isSaveSent) {
				UMA(sender).mailStor("sent", uuid, path, false);
			}

			if (isTimerSend) {
				String mailUuid = UUID.randomUUID().toString();
				File file = new File($TimerMail.batchMailDir + mailUuid);
				FileTools.copyFile(mimeFile, file);
				
				TimerMail tm = new TimerMail();
				tm.setMailUuid(mailUuid);
				tm.setMailPath(file.getAbsolutePath());
				tm.setTime(sendTime);
				tm.setType(TimerMail.MAIL_TYPE_TIMER);
				tm.setTitle("timer mail");
//				tm.setDomain("");
//				tm.setOu("");
				tm.setState(TimerMail.MAIL_STATE_NEW);
				tm.create();
			}

			if (isSend) {
				//复制一份邮件
				File copyFile = new File(path+"_copy");
				FileTools.copyFile(mimeFile, copyFile);
				
				List<String> dataLines = new ArrayList<String>();
				// 如果SMTP服务器跟WEB端在同一台机子， 只传送mimeFile的文件路径
				if("127.0.0.1".equals(smtpClient.getSmtpHost())) {
					dataLines.add(path);
				}
				else {
					// TODO 此处把“UTF－8”作为文件编码方式，可能会有影响
					dataLines = PlainFile.readLines(mimeFile, "UTF-8");;
					mimeFile.delete();
				}
				smtpClient.setFromEmail(sender.toEmail());
				SmtpSendResult sendRes = smtpClient.sendWithRoute(mc.getRcpts(), dataLines);
				List<ResultItem> errItems = sendRes.getResultItems(ResultItem.TYPE_HARD_ERR);
				// 发送失败， 产生一条日志
				if(errItems.size() > 0) {
					String sendTime1 = CalendarUtil.getLocalDateTime("yyyy-MM-dd HH:mm:ss");
					String tos = StringUtils.join(mc.getRcpts(), ",");
					String errorMsg = errItems.get(0).getMsg();
					$MailLog.save(sendTime1, "DELIVER", sender.toEmail(), tos, mimeFile.length(), "F", errorMsg, sender.getDc());
				}
				
				for (ResultItem errItem : errItems) {
					//系统邮件
					//bounceMail(sender, errItem.getMsg(), errItem.getToEmail(), mc, dataLines);
					bounceMail(sender, errItem.getMsg(), errItem.getToEmail(), copyFile);
				}
				
				copyFile.delete();
			}
			return uuid;
			
		}
		
		//系统邮件（带附件）
		public void bounceMail(User user, String reason, String toEmail, File attachFile) {
			Logger.info("webmailRebound to=" + user.toEmail() + " o_to=" + toEmail);
			
			String subject ="系统退信";
			String sender = "postmaster@"+ user.getDc();
			String rcptM = user.getUid() + "@" + user.getDc();
			try {
				String bounceEml = TextFile.loadString("/wpx/timermail/bounce.eml", "\r\n");
				String content = bounceEml
					.replace("$FROM$", "\"postmaster\" <" + sender + ">")
					.replace("$TO$", toEmail).replace("$MSG_TO$",toEmail)
					.replace("$SUBJECT$", subject)
					.replace("$CONTENT$", reason)
					.replace("$DATE$", CalendarUtil.getLocalDateTime("yyyy-MM-dd HH:mm"));
				
				//新建一封邮件
				MimeCreater mc = new MimeCreater();
				mc.setFrom("postmaster", sender);
				mc.setTos(new String[]{toEmail});
				mc.setSubject(subject);
				mc.setContent(content);
				mc.addAttachment(attachFile.getPath(), "原邮件.eml", "原邮件.eml");
				
				String tempPath = "/tmp/Bounce_" + UUID.randomUUID().toString();
				File mimeTempFile = new File(tempPath);
				mc.saveToFile(mimeTempFile.getAbsolutePath());
				
				List<String> dataLines = new ArrayList<String>();
				dataLines = PlainFile.readLines(mimeTempFile, "UTF-8");;
				mimeTempFile.delete();
				
				smtpClient.setFromEmail(sender);
				smtpClient.sendWithRoute(rcptM, dataLines);
			} catch (Exception e) {
				Logger.error("", e);
			}

		}
		
		public void bounceMail(User user, String reason, String toEmail, MimeCreater mc,
				List<String> dataLines) {
			Logger.info("webmailRebound to=" + user.toEmail() + " o_to=" + toEmail);
			String rcptM = user.getUid() + "@" + user.getDc();
			String subject = Rfc2047Codec.decode(mc.getSubject());
			try {
				String bounceEml = TextFile.loadString("/wpx/timermail/bounce.eml", "\r\n");
				String content = bounceEml
					.replace("$FROM$", "\"postmaster\" <postmaster@" + user.getDc() + ">")
					.replace("$TO$", toEmail).replace("$MSG_TO$",toEmail)
					.replace("$SUBJECT$", subject)
					.replace("$CONTENT$", reason)
					.replace("$DATE$", CalendarUtil.getLocalDateTime("yyyy-MM-dd HH:mm"));
				List<String> reboundMail = AutoMailMaker.getBounceMail("postmaster@"
						+ user.getDc(), user.toEmail(), toEmail,
						content, reason, dataLines);
				smtpClient.setFromEmail("postmaster@"+ user.getDc());
				smtpClient.sendWithRoute(rcptM, reboundMail);
			} catch (Exception e) {
				Logger.error("", e);
			}

		}

		public void move(MailFolder srcFolder, String[] uuids,
				MailFolder destFolder) throws AppException, Exception {
			UMA(srcFolder.owner).mailMoveMail(srcFolder.getId(), uuids,
					destFolder.getId());
		}

		public void setRead(MailFolder folder, String[] uuids, boolean isRead)
				throws AppException, Exception {
			UMA(folder).mailSetRead(folder.getId(), uuids, isRead);
		}

		public void setReply(MailFolder folder, String[] uuids, boolean reply)
				throws AppException, Exception {
			setRead(folder, uuids, true);
			UMA(folder).mailSetReply(folder.getId(), uuids, reply);
		}

		public void delete(MailFolder folder, String[] uuids)
				throws AppException, Exception {
			UMA(folder).mailDelMail(folder.getId(), uuids);
		}

		public long getSizeUsed(User user) throws AppException, Exception {
			return UMA(user).mailGetStorageSizeUsed();
		}

		public String getCacheRootPath() {
			if(mimeReader.getClass().isAssignableFrom(MimeReaderCachedImpl.class)) {
				return ((MimeReaderCachedImpl) mimeReader).getCacheRootPath();
			}
			return "/wpx/cache/decode";
		}

	}

}
