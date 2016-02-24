package com.skymiracle.wpx.controllers.a;

import static com.skymiracle.wpx.Singletons.$Dept;
import static com.skymiracle.wpx.Singletons.$TimerMail;
import static com.skymiracle.wpx.Singletons.WpxAuthMail;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.skymiracle.http.HttpUploader.TempUpFile;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mime.MimeCreater;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.util.UUID;
import com.skymiracle.util.UsernameWithDomain;
import com.skymiracle.wpx.models.log.SysLog;
import com.skymiracle.wpx.models.mail.TimerMail;

@Sessioned
public class BatchCtr extends Ctr {
	@Layout("NOT")
	public void batch() throws AppException, Exception {
		String dc = $("dc");
		r.putMap("dc", dc);
		r.putMap("depts", $Dept.find("domain", dc));
	}

	public void listbatch() throws AppException, Exception {
		String dc = $("dc", "");
		MdoMap mm = new MdoMap();
		if (!dc.equals(""))
			mm.put("domain", $("dc", ""));
		mm.put("type", TimerMail.MAIL_TYPE_BATCH);
		List<TimerMail> list = $TimerMail.find(mm, "time", false);
		r.putColl(list);
	}

	@Layout("NOT")
	public void sendBatch() throws AppException, Exception {
		String dc = $("dc");
		r.putMap("dc", dc);
	}

	public void delbatch() throws AppException, Exception {
		String[] uuids = $$("uuid");
		for (String uuid : uuids) {
			TimerMail tm = new TimerMail(uuid);
			tm.delete();
			SysLog.width(actor).delBatch();
		}
	}
	//添加群发邮件
	@Layout("NOT")
	public void addbatch() throws AppException, Exception {
		if (!is_get) {
			
			String ous = $("ou", "");
			if(ous.equals(""))
				this.createMail(null);
			else{
				ous = ous.substring(0, ous.length()-1);
				for(String ou : ous.split(";")){
					this.createMail(ou);
				}
			}

			SysLog.width(actor).addBatch();
		}
	}
	private void createMail(String ou) throws AppException, Exception {
		List<TempUpFile> tempUpFiles = $$TFile();

		String domain = $("domain");
		String subject = $("title");
		String content = $("content");
		String fromEmail = new UsernameWithDomain("postmaster", WpxAuthMail
				.getDefaultDomain()).toEmail();

		MimeCreater mc = new MimeCreater();
		String[] attachOnSite = $$("attachOnSite");
		if (attachOnSite == null)
			attachOnSite = new String[0];
		for (String s : attachOnSite) {
			System.out.println(s);
			String[] ss = s.split("\\|\\|\\|\\|\\|");
			mc.addAttachment(ss[1], ss[0], ss[0]);
		}
		for (TempUpFile f : tempUpFiles) {
			String filename = new File(f.getOrginalName()).getName();
			mc.addAttachment(f.getTmpUpPath(), filename, f
							.getOrginalName());
		}
		
	
		mc.setFrom("postmaster", fromEmail);
		mc.setCharset("UTF-8");
		mc.setSubject(subject);
		mc.setPlainContent(getPlainFromHtml(content));
		mc.setContent(content);
		mc.setPriority($i("priority", 3));

		Calendar calendar = Calendar.getInstance();
//		long time = 0l;
		if ($("mail_timerchk") != null) {
			int mon = Integer.parseInt($("timermon")) - 1;
			int day = Integer.parseInt($("timerday"));
			int hour = Integer.parseInt($("timerh"));
			int min = Integer.parseInt($("timermin"));
			int year = Integer.parseInt($("timeryear"));
			calendar.set(year, mon, day, hour, min);
		}
//		time = calendar.getTimeInMillis();
		String time = CalendarUtil.getFormat(calendar.getTimeInMillis(), "yyyy-MM-dd HH:mm:ss");

		String mailUUID = new UUID().toShortString();
		String mimeFilePath = $TimerMail.batchMailDir + mailUUID;
		File mimeFile = new File(mimeFilePath);
		if (mimeFile.exists())
			mimeFile.delete();
		mc.saveToFile(mimeFilePath);

		TimerMail tm = new TimerMail();
		tm.setMailUuid(new UUID().toShortString());
		tm.setMailPath(mimeFilePath);
		tm.setTime(time + "");
		tm.setType(TimerMail.MAIL_TYPE_BATCH);
		tm.setTitle(subject);
//		tm.setDomain(domain);
		tm.setState(TimerMail.MAIL_STATE_NEW);
//		if(null!= ou && !ou.equals(""))
//			tm.setOu(ou);
		
		tm.create();
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

}
