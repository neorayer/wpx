package com.skymiracle.wpx.models.mail;

import static com.skymiracle.wpx.Singletons.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.skymiracle.client.tcpClient.smtpClient.SmtpClient;
import com.skymiracle.io.TextFile;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.Mdo.Title;
import com.skymiracle.mime.Mime;
import com.skymiracle.mime.MimeReader;
import com.skymiracle.mime.MimeReaderCachedImpl;
import com.skymiracle.mime.RichMailAddress;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.util.StringUtils;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;
import com.skymiracle.wpx.models.user.User;

public class TimerMail extends WpxUuidMdo<TimerMail> {

	@Title("邮件文件地址")
	private String mailPath;

	@Title("邮件UUID")
	private String mailUuid;

	@Title("定时发送时间")
	private String time;

	@Title("标题")
	private String title;

	// @Title("域")
	// private String domain;

	public static final String MAIL_STATE_NEW = "new";

	public static final String MAIL_STATE_SENDED = "sended";

	public static final String MAIL_STATE_ERROR = "error";

	public static final String MAIL_DOMAIN_LEVEL = "system";

	@Title("状态")
	@Desc("sended: 已发送 | error: 发送出错 | new : 未发送")
	private String state;

	public static final String MAIL_TYPE_BATCH = "batch";

	public static final String MAIL_TYPE_TIMER = "timer";

	public static final String MAIL_TYPE_ALL = "all";

	private String type;

	private StringBuffer rcpts;

	@Title("创建人")
	private String creator;

	// @Title("部门")
	// private String ou;

	public TimerMail() {
		super($TimerMail);
	}

	public TimerMail(String uuid) {
		this();
		setUuid(uuid);
	}

	public String getMailPath() {
		return mailPath;
	}

	public void setMailPath(String mailPath) {
		this.mailPath = mailPath;
	}

	public String getMailUuid() {
		return mailUuid;
	}

	public void setMailUuid(String mailUuid) {
		this.mailUuid = mailUuid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// public String getDomain() {
	// return domain;
	// }
	//
	// public void setDomain(String domain) {
	// this.domain = domain;
	// }

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public StringBuffer getRcpts() {
		return rcpts;
	}

	public void setRcpts(StringBuffer rcpts) {
		this.rcpts = rcpts;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// public String getOu() {
	// return ou;
	// }
	//
	// public void setOu(String ou) {
	// this.ou = ou;
	// }

	@Override
	public String table() {
		return "tb_timerMail";
	}

	public List<String> getRcpt() {
		List<String> rcptList = new ArrayList<String>();
		String[] tos = rcpts.toString().split(";");
		for (String toMail : tos) {
			RichMailAddress rma = new RichMailAddress(toMail);
			rcptList.add(rma.getMailAddress());
		}
		return rcptList;
	}

	public void delete() throws AppException, Exception {
		super.load();
		if (TimerMail.MAIL_TYPE_BATCH.equals(type)
				&& !TimerMail.MAIL_STATE_SENDED.equals(state)) {
			File file = new File(mailPath);
			if (file.exists())
				file.delete();
		}
		super.delete();
	}

	public static class X extends WpxMdo_X<TimerMail> {

		// 群发邮件文件临时目录
		public String batchMailDir = "/wpx/timermail/";

		private long delaytime = 60000;

		private MList<TimerMail> tmlist;

		private MimeReader mr = new MimeReaderCachedImpl();

		private SmtpClient localSmtpClient;

		public void setDelaytime(long delaytime) {
			this.delaytime = delaytime;
		}

		public long getDelaytime() {
			return delaytime;
		}

		public X() {
			super(TimerMail.class);
			File file = new File(batchMailDir);
			if (!file.exists() || !file.isDirectory())
				file.mkdirs();
		}

		public String getBatchMailDir() {
			return batchMailDir;
		}

		public void setBatchMailDir(String batchMailDir) {
			this.batchMailDir = batchMailDir;
		}

		public List<TimerMail> formatTimerMail(List<TimerMail> mailList) {
			return mailList;
		}

		private List<String> getRcpt(Mime mime) {
			List<String> rcptList = new ArrayList<String>();
			List<RichMailAddress> cclist = mime.getBcc();
			for (RichMailAddress rma : cclist)
				rcptList.add(rma.getMailAddress());
			List<RichMailAddress> tolist = mime.getTo();
			for (RichMailAddress rma : tolist)
				rcptList.add(rma.getMailAddress());
			List<RichMailAddress> bclist = mime.getBcc();
			for (RichMailAddress rma : tolist)
				rcptList.add(rma.getMailAddress());
			return rcptList;
		}

		// private List<String> getRcpt(String domain, String ou) throws
		// AppException, Exception {
		// List<String> rcptList = new ArrayList<String>();
		// MdoMap mdoMap = new MdoMap();
		//			
		// if (!ou.equals("") && !domain.equals("")) {
		// mdoMap.put("dc", domain);
		// mdoMap.put("ou", ou);
		// } else if(!domain.equals("")){
		// mdoMap.put("dc", domain);
		// }
		//			
		// MList<User> users = $User.find(mdoMap, null);
		// for (User user : users) {
		// RichMailAddress rma = new RichMailAddress(user.getMail());
		// rcptList.add(rma.getMailAddress());
		// }
		// return rcptList;
		// }

		public void start() {
			while (true) {
				try {
					tmlist = this.find("state", "new");
				} catch (Exception e) {
					Logger.error("TimerService.run", e);
				}
				Mime mime = null;
				for (TimerMail tm : tmlist) {
					long nowtime = System.currentTimeMillis();
					Date tmTime = CalendarUtil.stringToDate(tm.getTime(),
							"yyyy-MM-dd HH:mm:ss");
					if (nowtime < tmTime.getTime())
						continue;
					if (!tm.getState().equals(TimerMail.MAIL_STATE_NEW))
						continue;
					else {
						try {
							File mimeFile = new File(tm.getMailPath());
							mime = mr.loadMime(mimeFile, tm.getMailUuid());
							List<String> rcptlist = new ArrayList<String>();
							ArrayList datalist = TextFile.loadValidLinesList(tm
									.getMailPath());
							String fromEmail = mime.getFrom().getMailAddress();
							localSmtpClient = new SmtpClient();
							localSmtpClient.setFromEmail(fromEmail);
							// 定时邮件
							if (tm.getType().equals(TimerMail.MAIL_TYPE_TIMER)) {
								rcptlist = this.getRcpt(mime);
								this.sendTimerMail(rcptlist, datalist, 500);
								tm.delete();
							}
							// 群发邮件
							else {
								MdoMap mdoMap = new MdoMap();
								try {
									if (tm.getState().equals(
											TimerMail.MAIL_STATE_NEW)) {
										// rcptlist = getRcpt(tm.getDomain(),
										// tm.getOu());
										rcptlist = tm.getRcpt();
										this.sendTimerMail(rcptlist, datalist,
												500);
										mdoMap.put("state",
												TimerMail.MAIL_STATE_SENDED);
									} else
										continue;
								} catch (Exception e) {
									mdoMap.put("state",
											TimerMail.MAIL_STATE_ERROR);
									e.printStackTrace();
								} finally {
									this.update(tm, mdoMap);
								}
							}
							mimeFile.delete();
						} catch (Exception e) {
							Logger.error("TimerService.run", e);
						}
					}
				}
				try {
					Thread.sleep(delaytime);
				} catch (InterruptedException e1) {
					Logger.error("TimerService.run", e1);
				}
			}
		}

		private void sendTimerMail(List<String> rcptlist, ArrayList datalist,
				int maxSend) {
			if (rcptlist.size() > maxSend) {
				List<String> tmpList = new ArrayList<String>();
				for (String rcpt : rcptlist) {
					tmpList.add(rcpt);
					if (tmpList.size() == maxSend) {
						localSmtpClient.sendWithRoute(tmpList, datalist);
						tmpList.clear();
					}
				}
				if (tmpList.size() > 0)
					localSmtpClient.sendWithRoute(tmpList, datalist);
			} else {
				localSmtpClient.sendWithRoute(rcptlist, datalist);
			}

		}

	}

}
