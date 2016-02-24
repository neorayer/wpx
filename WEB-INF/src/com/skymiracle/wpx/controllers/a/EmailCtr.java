package com.skymiracle.wpx.controllers.a;

import static com.skymiracle.wpx.Singletons.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.skymiracle.http.HttpUploader.TempUpFile;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.mime.MimeCreater;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.util.UUID;
import com.skymiracle.util.UsernameWithDomain;
import com.skymiracle.wpx.models.admin.Admin;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.log.SysLog;
import com.skymiracle.wpx.models.mail.BatchGroup;
import com.skymiracle.wpx.models.mail.BatchGroupCondition;
import com.skymiracle.wpx.models.mail.TimerMail;
import com.skymiracle.wpx.models.user.Dept;
import com.skymiracle.wpx.models.user.User;

@Sessioned
public class EmailCtr extends Ctr {

	@Layout("NOT")
	public void main() {
	}

	@Layout("NOT")
	public void batch() {
	}

	@Layout("NOT")
	public void sendBatch() throws AppException, Exception {
		if(is_get) {
			r.putMap("domains", actor.listDomains());
			r.putMap("groups", listBatchGroupNoPaged());
			r.putMap("deplist", $Dept.getSafeDepts(new MdoMap()));
		}
	}
	
	public void deptTree() throws AppException, Exception {
		String dc = $("dc", "");
		MdoMap mm = new MdoMap();
		mm.put("domain", dc);
		r.setJson($Dept.getDeptTreeMapJSON(mm));
	}
	
	public void searchUsersByDc() throws AppException, Exception {
		String dc = $("dc", "");
		String ou = $("ou" , "");
		MdoMap mm = new MdoMap();
		if(!dc.equals(""))
			mm.put("dc", dc);
		if(!ou.equals(""))
			mm.put("ou", ou);
		
		r.putColl($User.find(mm, null));
	}
	
	public void searchUsersByGroup() throws AppException, Exception {
		String groupuuid = $("groupuuid");
		BatchGroup group = new BatchGroup(groupuuid);
		group.load();
		
		r.putColl($User.find(new MdoMap(), group.getCdn().toString()));
	}

	public void listbatch() throws AppException, Exception {
		MdoMap mm = new MdoMap();
		mm.put("type", TimerMail.MAIL_TYPE_BATCH);
		if(!Admin.TYPE_SUPER.equals(actor.getRoleID())) {
			mm.put("creator", actor.getUniqueId());
		}
		List<TimerMail> list = $TimerMail.find(mm, "time", false);
		r.putColl(list);
	}

	public void delbatch() throws AppException, Exception {
		String[] uuids = $$("uuid");
		for (String uuid : uuids) {
			TimerMail tm = new TimerMail(uuid);
			tm.delete();
			SysLog.width(actor).delBatch();
		}
	}

	// 添加群发邮件
	@Layout("NOT")
	public void addbatch() throws AppException, Exception {
		if (!is_get) {
			createMail();
			SysLog.width(actor).addBatch();
			r.setJs("parent.addbatchCallBack();");
		}
	}

	private void createMail() throws AppException, Exception {
		List<TempUpFile> tempUpFiles = $$TFile();

//		String domain = $("domain");
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
			mc.addAttachment(f.getTmpUpPath(), filename, f.getOrginalName());
		}

		mc.setFrom("postmaster", fromEmail);
		mc.setCharset("UTF-8");
		mc.setSubject(subject);
		mc.setPlainContent(getPlainFromHtml(content));
		mc.setContent(content);
		mc.setPriority($i("priority", 3));

		Calendar calendar = Calendar.getInstance();
		if ($("mail_timerchk") != null) {
			int mon = Integer.parseInt($("timermon")) - 1;
			int day = Integer.parseInt($("timerday"));
			int hour = Integer.parseInt($("timerh"));
			int min = Integer.parseInt($("timermin"));
			int year = Integer.parseInt($("timeryear"));
			calendar.set(year, mon, day, hour, min);
		}
		// long time = calendar.getTimeInMillis();
		String time = CalendarUtil.getFormat(calendar.getTimeInMillis(),
				"yyyy-MM-dd HH:mm:ss");

		String mailUUID = new UUID().toShortString();
		String mimeFilePath = $TimerMail.batchMailDir + mailUUID;
		File mimeFile = new File(mimeFilePath);
		if (mimeFile.exists())
			mimeFile.delete();
		mc.saveToFile(mimeFilePath);

		TimerMail tm = new TimerMail();
		tm.setMailUuid(new UUID().toShortString());
		tm.setMailPath(mimeFilePath);
		tm.setTime(time);
		tm.setType(TimerMail.MAIL_TYPE_BATCH);
		tm.setState(TimerMail.MAIL_STATE_NEW);
		tm.setTitle(subject);
		tm.setRcpts(new StringBuffer($("rcpt")));
		tm.setCreator(actor.getUniqueId());
//		tm.setDomain(domain);
//		if (null != ou && !ou.equals(""))
//			tm.setOu(ou);

		tm.create();
	}

	// 解析邮件正文
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

	@Layout("NOT")
	public void batchgroup() throws AppException, Exception {
		r.putMap("deplist", $Dept.getSafeDepts(new MdoMap()));
	}

	public void batchgroups() throws AppException, Exception {
//		String sortBy = $("sortby", "createDateTime");
//		boolean isAsc = $b("sortup", false);
//		StringBuffer buf = new StringBuffer();
//		// 非超级管理员
//		if(!Admin.TYPE_SUPER.equals(actor.getRoleID())) {
//			buf.append("creator='" + actor.getUniqueId() + "'");
//		}
//		PagedList<BatchGroup> list = $BatchGroup.findPaged(new MdoMap(), buf.toString(),
//				sortBy, isAsc, $i("pagenum", 1), $i("perpagecount", 9999));
		r.putColl(listBatchGroupNoPaged());
	}
	
	@Layout("NOT")
	public void addbatchgroup() throws AppException, Exception {
		if(is_get) {
			r.putMap("deplist", $Dept.getSafeDepts(new MdoMap()));
			r.putMap("group", getBatchGroup());
		}
		else {
			BatchGroup group = getBatchGroup();
			group.setName($("name"));
			group.setCreator(actor.getUniqueId());
			List<BatchGroupCondition> cdns = getCDNs();
			StringBuffer sql = buildSQLFromCDNs(cdns);
			buildSQLFromActor(sql);
			group.setCdn(sql);
			
			// 先删除相关组条件
			MdoMap mm = new MdoMap();
			mm.put("groupuuid", group.getUuid());
			$BatchGroupCondition.delete(mm);
			
			for(BatchGroupCondition cdn: cdns) {
				cdn.setGroupuuid(group.getUuid());
				cdn.create();
			}
			
			group.createOrUpdate();
		}
	}
	
	// 预览
	public void previewUsers() throws AppException, Exception {
		List<BatchGroupCondition> cdns = getCDNs();
		StringBuffer sql = buildSQLFromCDNs(cdns);
		buildSQLFromActor(sql);
		r.putColl($User.find(new MdoMap(), sql.toString()));
	}
	
	private BatchGroup getBatchGroup() throws AppException, Exception {
		String uuid = $("uuid", "");
		if(uuid.equals(""))
			return new BatchGroup();
		
		BatchGroup group = new BatchGroup(uuid);
		if(group.exists())
			group.load();
		
		return group;
	}
	
	private List<BatchGroupCondition> getCDNs() throws AppException, Exception {
		String[] filters = $$("filter");
		List<BatchGroupCondition> cdns = new ArrayList<BatchGroupCondition>();
		for(String filter: filters) {
			String[] aa =  filter.split("::::");
			BatchGroupCondition cdn = new BatchGroupCondition();
			cdn.setFilter(aa[0]);
			cdn.setName(aa[1]);
			cdns.add(cdn);
		}
		return cdns;
	}
	
	private StringBuffer buildSQLFromCDNs(List<BatchGroupCondition> cdns) throws AppException, Exception {
		// 组装SQL
		StringBuffer deptsql = new StringBuffer("1=1");
		StringBuffer usersql = new StringBuffer("1=1");
		for(BatchGroupCondition cdn: cdns) {
			if(cdn.getFilter().startsWith("description")) {
				deptsql.append(" and " + cdn.getFilter());
			}else {
				usersql.append(" and " + cdn.getFilter());
			}
		}
		// 把部门名称转换成部门编号， 组装SQL
		if(deptsql.length() > 3) {
			List<Dept> depts = $Dept.find(new MdoMap(), deptsql.toString());
			if(depts.size() > 0) {
				usersql.append(" and ou in (");
				for (Dept dept : depts) {
					usersql.append("'").append(dept.getOu()).append("',");
				}
				usersql.deleteCharAt(usersql.length() - 1);
				usersql.append(")");
			}
			else
				usersql.append(" and (ou is null)");
		}
		return usersql;
	}
	
	public StringBuffer buildSQLFromActor(StringBuffer sql) throws AppException, Exception {
		if(Admin.TYPE_SUPER.equals(actor.getRoleID()))
				return sql;
		// 
		List<Domain> domains = actor.listDomains();
		if(domains.size() == 0) {
			// nothing todo
		}
		else if(domains.size() == 1) {
			sql.append(" and dc = '" + domains.get(0).getDc() + "'");
		}else {
			sql.append(" and dc in (");
			for(Domain domain: domains) {
				sql.append("'").append(domain.getDc()).append("',");
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(")");
		}
		
		return sql;
	}
	
	public void delbatchgroup() throws AppException, Exception {
		String[] uuids = $$("uuid");
		for(String uuid: uuids) {
			BatchGroup group = new BatchGroup(uuid);
			group.delete();
		}
	}
	
	
	public void viUsersByGroup() throws AppException, Exception {
		BatchGroup group = new BatchGroup($("uuid"));
		group.load();
		r.putColl(group.getGroupUsers());
	}
	
	private List<BatchGroup> listBatchGroupNoPaged() throws AppException, Exception {
		MdoMap mm = new MdoMap();
		if(!Admin.TYPE_SUPER.equals(actor.getRoleID())) {
			mm.put("creator", actor.getUniqueId());
		}
		return $BatchGroup.find(mm, "createDateTime", false);
	}
}
