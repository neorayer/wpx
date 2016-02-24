package com.skymiracle.wpx.controllers.u;

import static com.skymiracle.wpx.Singletons.$AddrGrp;
import static com.skymiracle.wpx.Singletons.$Dept;
import static com.skymiracle.wpx.Singletons.$Domain;
import static com.skymiracle.wpx.Singletons.$User;
import static com.skymiracle.wpx.Singletons.$AddrPsn;
import static com.skymiracle.wpx.Singletons.$Mail;
import static com.skymiracle.wpx.Singletons.$MailFolder;
import static com.skymiracle.wpx.Singletons.$MailInk;
import static com.skymiracle.wpx.Singletons.WpxAuthMail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.skymiracle.fileBox.MailBoxLsItem;
import com.skymiracle.http.HttpUploader.TempUpFile;
import com.skymiracle.json.JSONTools;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.mime.Attachment;
import com.skymiracle.mime.Mime;
import com.skymiracle.mime.MimeCreater;
import com.skymiracle.mime.MimeHeader;
import com.skymiracle.mime.RichMailAddress;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.sor.exception.RenderFailException;
import com.skymiracle.util.Checker;
import com.skymiracle.util.FnsQPCodec;
import com.skymiracle.util.FsHashPath;
import com.skymiracle.util.StringUtils;
import com.skymiracle.wpx.models.addrbook.AddrPsn;
import com.skymiracle.wpx.models.mail.MailFolder;
import com.skymiracle.wpx.models.mail.MailInk;
import com.skymiracle.wpx.models.user.Dept;
import com.skymiracle.wpx.models.user.User;

@Sessioned
public class MailCtr extends Ctr {
	/** ******** Compose ********* */
	@Layout("NOT")
	public void compose() throws AppException, Exception {
		if (this.is_get) {
			vi_compose();
		} else {
			do_compose();
		}
	}

	/**
	 * 请求路径： 写信：mail/compose.html 通讯录快速写信
	 * ：mail/compose.html?act=addr&tos=%22cit%40citynet001.com%22%3Ccit%40citynet001.com%3E%2C%22cnfax%40nc.cn%22%3Ccnfax%40nc.cn%3E%2C
	 * 草稿箱打开邮件：mail/compose.html?act=draft&folderid=draft&uuid=dc4c104f-d775-439d-a51e-57af4cbe936e
	 * 转发：mail/compose.html?act=forward&folderid=inbox&parentuuid=f9b6bba0-3737-4ee7-a0ea-deca32482432
	 * 回复：mail/compose.html?act=reply&folderid=inbox&parentuuid=f9b6bba0-3737-4ee7-a0ea-deca32482432
	 * 全部回复：mail/compose.html?act=replyall&folderid=inbox&parentuuid=f9b6bba0-3737-4ee7-a0ea-deca32482432
	 */
	@Layout("NOT")
	private void vi_compose() throws AppException, Exception {
		// 邮件签名
		MList<MailInk> inks = $MailInk.find("owner", actor.toEmail());
		r.putMap("inks", inks);
		r.putMap("inksJson", JSONTools.getJSONString(inks));

		String act = $("act");
		// 写信
		if (act == null)
			return;

		// 通讯录快速写信
		if (act == "addr") {
			String mailTos = $("tos");
			if (mailTos != null && !"".equals(mailTos))
				mailTos = new String(mailTos.getBytes("iso8859-1"), "UTF-8");

			r.putMap("tos", mailTos);
			return;
		}

		String uuid = $("uuid", null);
		r.putMap("uuid", uuid);
		// 转发和回复的邮件
		String parentuuid = $("parentuuid", null);
		r.putMap("parentuuid", parentuuid);
		if (null != parentuuid) {
			uuid = parentuuid;
		}

		// 如果原邮件uuid为空，返回
		if (uuid == null)
			return;

		// 找出原邮件
		MailFolder f = new MailFolder(actor, $("folderid"));
		Mime mime = $Mail.getMime(f, uuid);
		String subject = mime.getSubject();
		String from = mime.getFrom().toString();
		String tos = StringUtils.join(mime.getTo(), ",");
		String ccs = StringUtils.join(mime.getCc(), ",");
		String content = mime.getContentTextHtml();
		String date = mime.getDate();
		String orig_tos = StringUtils.join(mime.getTo(), "<br/>");

		r.putMap("orig_from", from);
		r.putMap("orig_tos", orig_tos);
		r.putMap("orig_ccs", ccs);
		r.putMap("orig_subject", subject);
		r.putMap("orig_date", date);
		r.putMap("orig_content", content);

		// 是否是打开草稿箱的邮件
		boolean isOpenDraftMail = false;
		// 草稿箱打开邮件
		if (act.equals("draft")) {
			isOpenDraftMail = true;
			// 附件
			r.putMap("attachs", mime.getDownableAttachments());
		}
		// 回复
		else if (act.equals("reply")) {
			tos = from;
			ccs = "";
			subject = "回复:" + subject;
		}
		// 全部回复
		else if (act.equals("replyall")) {
			tos = from + "," + tos;
//			System.out.print(tos);
			subject = "回复:" + subject;
		}
		// 转发
		else if (act.equals("forward")) {
			tos = "";
			ccs = "";
			subject = "转发:" + subject;
			r.putMap("attachs", mime.getDownableAttachments());
		}

		r.putMap("subject", subject);
		r.putMap("tos", tos);
		r.putMap("ccs", ccs);
		r.putMap("content", content);
		
		r.putMap("isOpenDraftMail", isOpenDraftMail);
	}

	/**
	 * 自动补全收件人
	 * 
	 * @throws AppException
	 * @throws Exception
	 */
	public void psns() throws AppException, Exception {
		MList<AddrPsn> psns = $AddrPsn.find("owner", actor.toEmail());
		r.putMap("psns", psns);
	}

	/**
	 * 发送邮件
	 */
	public void do_compose() throws AppException, Exception {
		String[] tos = $$s("tos", ",");
		if (tos.length <= 0) {
			throw new AppException("表单没有提交完毕");
		}
		// 是否是自动保存
		boolean isSend = $b("isSend");
		boolean isSaveDraft = $b("isSafeDraft");
		boolean isSaveSent = $b("isSaveSent");
		boolean isTimerSend = $b("isTimerSend");

		int sendHour = $i("sendHour", 0);
		int sendMin = $i("sendMin", 0);
		String sendTime = $("sendDate") + " "
				+ (sendHour < 10 ? "0" + sendHour : sendHour) + ":"
				+ (sendMin < 10 ? "0" + sendMin : sendMin) + ":00";

		MimeCreater mc = new MimeCreater();
		String fromName = StringUtils.or(actor.getDisplayName(), actor
				.toEmail());
		mc.setFrom(fromName, $("mailFrom", actor.toEmail()));
		String defaultDomain = WpxAuthMail.getDefaultDomain();
		mc.setTos(tos, defaultDomain);
		mc.setCcs($$s("ccs", ","), defaultDomain);
		mc.setBccs($$s("bccs", ","), defaultDomain);
		mc.setSubject($("subject"));
		String content = $("content");
		mc.setContent(content);
		mc.setReceipt($b("isReceipt"));
		mc.setPriority($i("priority"));
		mc.setPlainContent(getPlainFromHtml(content));

		String[] attachOnSite = $$("attachOnSite");
		if (attachOnSite == null)
			attachOnSite = new String[0];
		for (String s : attachOnSite) {
			String[] ss = s.split("\\|\\|\\|\\|\\|");
			mc.addAttachment(ss[1], ss[0], ss[0]);
		}
		List<TempUpFile> tempUpFiles = $$TFile();
		long attachmentSize = $Domain.getAttachmentSize();
		for (TempUpFile f : tempUpFiles) {
			File file = new File(f.getTmpUpPath());
			System.out.println("88888888--------"+file.length());
			if (file.length() > attachmentSize * 1024 * 1024)
				throw new AppException("附件大小必须小于" + attachmentSize + "M! 文件名="
						+ f.getOrginalName());

			mc.addAttachment(f.getTmpUpPath(), f.getOrginalName(), f
					.getOrginalName());
		}

		// 如果SMTP服务器跟WEB端在同一台机子，该临时文件不能删除
		File mimeTempFile = createTempFile(false);
		mc.saveToFile(mimeTempFile.getAbsolutePath());

		$Mail.submit(actor, mimeTempFile, mc, isSend, isSaveDraft, isSaveSent,
				isTimerSend, sendTime);

		// 设置已回复
		setReply($("parentuuid", ""), $("folderid", ""));

		// 返回所有收件人的邮件地址（收件人、抄送、密送）
		StringBuffer sb = new StringBuffer();
		for (String to : mc.getRcpts())
			sb.append(to + ",");
		r.setJs("parent.Compose.turnCompose(\'" + sb.toString() + "\');");

	}

	/**
	 * 定时自动保存邮件
	 */
	public void autoSaveDraft() throws AppException, Exception {
		MimeCreater mc = new MimeCreater();
		String fromName = StringUtils.or(actor.getDisplayName(), actor
				.toEmail());
		mc.setFrom(fromName, actor.toEmail());
		String[] tos = $$s("tos", ",");
		String defaultDomain = WpxAuthMail.getDefaultDomain();
		mc.setTos(tos, defaultDomain);
		mc.setSubject($("subject"));
		String content = $("content");
		mc.setContent(content);
		mc.setPlainContent(getPlainFromHtml(content));

		// 如果SMTP服务器跟WEB端在同一台机子，该临时文件不能删除
		File mimeTempFile = createTempFile(false);
		mc.saveToFile(mimeTempFile.getAbsolutePath());

		boolean isSend = false;
		boolean isSaveDraft = true;
		boolean isSaveSent = false;
		boolean isTimerSend = false;
		String sendTime = null;
		String uuid = $Mail.submit(actor, mimeTempFile, mc, isSend,
				isSaveDraft, isSaveSent, isTimerSend, sendTime);

		// 如果已经对该封邮件存过搞，就删除原搞
		String oldUuid = $("uuid", "");
		if (!oldUuid.equals("")) {
			MailFolder f = new MailFolder(actor, "draft");
			$Mail.delete(f, new String[] { oldUuid });
		}

		r.putMap("uuid", uuid);
	}

	/**
	 * 快速回复
	 */
	@Layout("NOT")
	public void fastRestore() throws AppException, Exception {
		// 快速回复内容
		String restore = $("restore");

		// 原邮件
		MailFolder f = new MailFolder(actor, $("folderid"));
		Mime srcmime = $Mail.getMime(f, $("uuid"));
		String subject = srcmime.getSubject();
		RichMailAddress from = srcmime.getFrom();

		// 构建原邮件快速回复邮件体
		String content = getRestoreContent(srcmime, restore);

		MimeCreater mc = new MimeCreater();
		mc.setFrom(actor.getDisplayName(), actor.getMail());
		String defaultDomain = WpxAuthMail.getDefaultDomain();
		mc.setTos(new String[] { from.getMailAddress() }, defaultDomain);
		mc.setSubject("回复：" + subject);
		mc.setContent(content);
		mc.setReceipt(false);
		mc.setPriority(3);
		mc.setPlainContent(getPlainFromHtml(content));
		File mimeTempFile = createTempFile(false);
		mc.saveToFile(mimeTempFile.getAbsolutePath());

		boolean isSend = true;
		boolean isSaveDraft = false;
		boolean isSaveSent = false;
		boolean isTimerSend = false;
		String sendTime = null;
		$Mail.submit(actor, mimeTempFile, mc, isSend, isSaveDraft, isSaveSent,
				isTimerSend, sendTime);

		// 设置已回复
		setReply($("uuid", ""), $("folderid", ""));
	}

	/**
	 * 构造出快速回复的邮件体
	 * 
	 * @param m
	 * @param restore
	 * @return
	 */
	private String getRestoreContent(Mime m, String restore) {
		MimeHeader header = m.getHeader();
		StringBuffer sb = new StringBuffer();
		sb.append("<p>" + restore + "</p><br>");

		sb
				.append("<div mce_style=\"border-left:2px solid #cccccc;padding:5px;\" style=\"border-left: 2px solid rgb(204, 204, 204); padding: 5px;\">");

		sb
				.append("------------------------------ 原文 ------------------------------ <br>");
		sb.append("	<div>");
		sb.append("<p><b>发件人：</b>" + header.getFrom() + "</p>");
		sb
				.append("<p><b mce_style=\"display: block;float: left;\">收件人：</b><span mce_style=\"display: block;float: left;\">");
		for (RichMailAddress rma : m.getTo()) {
			sb.append(rma.getSrc() + "<br>");
		}
		sb.append("</span></p>");
		sb.append("");
		sb
				.append("<p mce_style=\"clear: both;\" style=\"clear: both;\"><b>标　题：</b>"
						+ header.getSubject() + "</p>");
		sb.append("<p><b>日　期：</b>" + header.getLocalDate() + "</p>");
		sb.append("</div>");
		sb.append("<hr>");
		String content = m.getContentTextHtml();
		boolean isPlain = (content != null && !content.equals(""));

		if (isPlain)
			sb.append("<p>" + content + "</p>");
		else
			sb.append("<p>" + m.getContentTextPlain() + "</p>");

		sb.append("</div>");
		return sb.toString();

	}

	/**
	 * 设置是否回复
	 */
	private void setReply(String uuid, String folderid) throws AppException,
			Exception {
		// 如果该邮件是回复邮件，设置原邮件已回复
		if (!uuid.equals("") && !folderid.equals("")) {
			MailFolder f = new MailFolder(actor, folderid);
			$Mail.setReply(f, new String[] { uuid }, true);
		}
	}

	// 发送完毕页面的通讯录情况
	public void tos() throws AppException, Exception {
		// 私人通讯录组
		r.putMap("grps", $AddrGrp.find("owner", actor.getMail()));

		// 所有收信人的信息
		List<AddrPsn> list = new ArrayList<AddrPsn>();
		String tos[] = $$s("tos", ",");
		for (String to : tos) {
			to = to.replace("'", "\"");
			RichMailAddress rm = new RichMailAddress(to);
			String mail = rm.getMailAddress();
			String displayName = new String(rm.getDisplayName().getBytes(
					"iso8859-1"), "UTF-8");
			if (Checker.isGoodEmailAddress(mail, false)) {
				AddrPsn psn = new AddrPsn();
				psn.setUuid("false");
				if ($AddrPsn.count("owner, mail", actor.getMail(), mail) > 0) {
					psn.setUuid("true");
				}
				psn.setDisplayName(displayName);
				psn.setMail(mail);
				list.add(psn);
			}
		}
		r.putMap("mails", list);
	}

	private String getPlainFromHtml(String input) {
		try {
			Pattern pattern = Pattern.compile("<.*?>");
			Matcher m = pattern.matcher(input);
			StringBuffer sb = new StringBuffer();
			while (m.find()) {
				m.appendReplacement(sb, "");
			}
			m.appendTail(sb);
			return sb.toString().replaceAll("&lt;", "<")
					.replaceAll("&gt;", ">").replaceAll("&amp;", "&")
					.replaceAll("&nbsp;", " ").replaceAll("&quot;", "\"")
					.trim();
		} catch (Exception e) {
			return input;
		}
	}

	/**
	 * 邮件列表
	 * 
	 * @throws AppException
	 * @throws Exception
	 */
	@Layout("NOT")
	public void mails() throws AppException, Exception {
		MailFolder f = new MailFolder(actor, $("folderid", "inbox"));
		r.putMap("folder", f);

		int pageNum = $i("pageNum", 1);
		// 每页显示多少封邮件
		int countPerPage = actor.getMnpp();
		countPerPage = countPerPage <= 0 ? 10 : countPerPage;
		String sortBy = $("sortBy", "lastModified");
		sortBy = StringUtils.or(sortBy, "lastModified");
		boolean isUp = $b("isUp", false);
		r.putMap("sortBy", sortBy);
		r.putMap("isUp", isUp);

		String condition = $("condition", "");
		String keyword = $("keyword", "").trim();
		keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");

		String linkPreifx = "mail/mails.html?folderid=" + f.getId()
				+ "&condition=" + condition + "&sortBy=" + sortBy + "&isUp="
				+ isUp;
		if (!keyword.equals("")) {
			linkPreifx += "&keyword=" + keyword;
		}

		PagedList<MailBoxLsItem> mails = $Mail.findPaged(f, sortBy, isUp,
				pageNum, countPerPage, linkPreifx, condition, keyword);

		r.putMap("_keyword", keyword);
		r.putMap("mails", mails);
		r.putMap("pageBarTdsHTML", mails.getTextBarHTML());
		r.putMap("newCount", mails.attr("newCount"));
		r.putMap("allCount", mails.getAllCount());
	}

	@Layout("NOT")
	public void folders() throws AppException, Exception {
		MList<MailFolder> allFolders = $MailFolder.findAll(actor);
		MList<MailFolder> sysFolders = $MailFolder.getSys(allFolders);
		MList<MailFolder> myFolders = $MailFolder.getMy(allFolders);

		r.putMap("allFolders", allFolders);
		r.putMap("sysFolders", sysFolders);
		r.putMap("myFolders", myFolders);
	}

	public void mails_move() throws AppException, Exception {
		MailFolder srcFolder = new MailFolder(actor, $("srcFid"));
		MailFolder destFolder = new MailFolder(actor, $("destFid"));

		$Mail.move(srcFolder, $$("uuid"), destFolder);
	}

	public void mails_setRead() throws AppException, Exception {
		MailFolder f = new MailFolder(actor, $("folderid"));
		$Mail.setRead(f, $$("uuid"), $b("read"));
	}

	public void mails_setReplied() throws AppException, Exception {
		MailFolder f = new MailFolder(actor, $("folderid"));
		$Mail.setReply(f, $$("uuid"), $b("reply"));
	}

	public void mails_del() throws AppException, Exception {
		MailFolder f = new MailFolder(actor, $("folderid"));
		$Mail.delete(f, $$("uuid"));
	}

	public void folder_empty() throws AppException, Exception {
		new MailFolder(actor, $("folderid")).empty();
	}

	public void folder_add() throws AppException, Exception {
		String id = FnsQPCodec.encode($("name"), "UTF-8");
		try {
			new MailFolder(actor, id).create();
		} catch (Exception e) {
			throw new AppException(id + "邮件夹添加失败");
		}
	}

	public void folder_del() throws AppException, Exception {
		new MailFolder(actor, $("folderid")).delete();
	}

	@Layout("NOT")
	public void mail() throws AppException, Exception {
		MailFolder f = new MailFolder(actor, $("folderid"));
		// 设置已读
		$Mail.setRead(f, $$("uuid"), true);

		Mime mime = $Mail.getMime(f, $("uuid"));
		r.putMap("mail", mime);
		r.putMap("uuid", $("uuid"));
		r.putMap("folder", f);

		// 邮件附件
		List<Attachment> attachs = mime.getDownableAttachments();
		r.putMap("attachs", attachs);
		r.putMap("attachSize", attachs.size());
		// 此封邮件是否为系统邮件
		boolean isPostmaster = mime.getFrom().getSrc().indexOf("postmaster") != -1;
		r.putMap("isPostmaster", isPostmaster);
	}

	@Layout("NOT")
	public void mailContent() throws AppException, Exception {
		MailFolder f = new MailFolder(actor, $("folderid"));
		r.putMap("mail", $Mail.getMime(f, $("uuid")));
		// r.putMap("folder", f);
	}

	@Layout("NOT")
	public void attachment() throws AppException, Exception {
		String name = new String($("name", "未命名").getBytes("iso8859-1"),
				"UTF-8");
		String cacheRootPath = $Mail.getCacheRootPath();
		if(new String($("path", "")).indexOf("../")!= -1)
			throw new Exception("系统找不到指定的路径");
	
		String path = new FsHashPath(cacheRootPath, $("uuid")).getPath(2)
				+ $("path");
		
		r.putFile(new File(path), name);
	}

	/** ******** reject ********* */
	public void mails_rejectAddress() throws AppException, Exception {
		String mailAddr = $("address");

		ArrayList<String> list = new ArrayList<String>();
		boolean b = true;
		for (String mail : actor.getRejectemail()) {
			if (!mail.equals("") && mail != null)
				list.add(mail);
			if (mail.equals(mailAddr))
				b = false;
		}

		if (b)
			list.add(mailAddr);

		MdoMap mdoMap = new MdoMap();
		mdoMap.put("rejectemail", list.toArray(new String[0]));
		actor.update(mdoMap);
	}

	public void mails_rejectSubject() throws AppException, Exception {
		String mailSubject = $("subject");

		ArrayList<String> list = new ArrayList<String>();
		boolean b = true;
		for (String subject : actor.getRejectesubject()) {
			if (!subject.equals("") && subject != null)
				list.add(subject);
			if (subject.equals(mailSubject))
				b = false;
		}

		if (b)
			list.add(mailSubject);

		MdoMap mdoMap = new MdoMap();
		mdoMap.put("rejectesubject", list.toArray(new String[0]));
		actor.update(mdoMap);
	}

	public void mails_rejectDomain() throws AppException, Exception {
		String mailDomain = $("domain");

		ArrayList<String> list = new ArrayList<String>();
		boolean b = true;
		for (String domain : actor.getRejectdomain()) {
			if (!domain.equals("") && domain != null)
				list.add(domain);
			if (domain.equals(mailDomain))
				b = false;
		}

		if (b)
			list.add(mailDomain);

		MdoMap mdoMap = new MdoMap();
		mdoMap.put("rejectdomain", list.toArray(new String[0]));
		actor.update(mdoMap);
	}

	@Layout("NOT")
	public void mails_download() throws AppException, Exception {
		MailFolder f = new MailFolder(actor, $("folderid"));
		Mime mime = $Mail.getMime(f, $("uuid"));
		File file = new File($Mail.getMailPath(f, $("uuid")));
		String mailName = (mime.getSubject().equals("") ? "无主题" : mime
				.getSubject())
				+ ".eml";
		r.putFile(file, mailName);
	}

	@Layout("NOT")
	public void addrbooks() throws AppException, Exception {

	}

	/**
	 * 写信界面私人通讯录
	 * 
	 */
	@Layout("NOT")
	public void personAddr() throws AppException, Exception {
		r.putMap("person_grps", $AddrGrp.find("owner,groupname+", actor
				.toEmail(), null));
		// 未分组的人数
		r.putMap("person_ngCount", $AddrPsn.count("owner, groupId", actor
				.getMail(), ""));
	}

	// 加入私人通讯录
	@Layout("NOT")
	public void addPersonAddr() throws AppException, Exception {
		String mail = $("mail");
		AddrPsn psn = new AddrPsn();
		psn.setMail(mail);
		psn.setDisplayName(mail);
		psn.setOwner(actor.getMail());
		psn.setUuid(UUID.randomUUID().toString());
		psn.create();
	}

	/**
	 * 写信界面公共通讯录
	 * 
	 */
	@Layout("NOT")
	public void publicAddr() throws AppException, Exception {
		List<Dept> list = $Dept.find("domain,parentOu,sortNum+", actor.getDc(),
				"");
		r.putMap("public_grps", list);
		// 未分组的人数
		r.putMap("public_ngCount", $User.count("dc,ou, status, ishide", actor
				.getDc(), "", "open", 1));
	}

	@Layout("NOT")
	@Sessioned
	public void stat() throws AppException, Exception {
		String mail = $("mail", "");
		if (mail.equals(""))
			return;
		String[] args = mail.split("@");
		if (args.length != 2)
			return;
		User user = new User(args[1], args[0]);
		if (!user.exists())
			return;
		user.load();

		// 收件箱
		MailFolder inbox = new MailFolder(user, "inbox").load();
		// 未读邮件
		r.putMap("newcount", inbox.getNewCount());
		r.putMap("allcount", inbox.getCount());
	}
}
