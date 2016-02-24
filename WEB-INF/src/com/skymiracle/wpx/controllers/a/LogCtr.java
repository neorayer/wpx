package com.skymiracle.wpx.controllers.a;

import static com.skymiracle.wpx.Singletons.*;

import java.util.List;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.admin.Admin;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.log.MailLog;

@Sessioned
public class LogCtr extends Ctr {

	@Layout("NOT")
	public void main() {
	}

	//管理日志
	@Layout("NOT")
	public void sysLog() throws AppException, Exception {
		r.putMap("domains", actor.listDomains());
	}

	public void listSysLog() throws AppException, Exception {
		String account = $("account", "");
		String domain = $("domain", "");
		String fromtime = $("fromtime", "");
		String totime = $("totime", "");
		String role = $("role", "");

		StringBuffer filter = new StringBuffer("1=1");
		
		if(Admin.TYPE_DOMAIN.equals(actor.getRoleID())) {
			filter.append(" and domain='" + actor.getDc() + "'");
		}
		else if(Admin.TYPE_MULTIDOMAIN.equals(actor.getRoleID())) {
			List<Domain> ds = actor.listDomains();
			if(ds.size() > 0) {
				filter.append("( 1=1 ");
				for(Domain d: actor.listDomains()) {
					filter.append(" and domain='" + d.getDc() + "'");
				}
				filter.append(")");
			}
			else {
				filter.append(" and domain is null ");
			}
		}
		else if(Admin.TYPE_ADDRESSBOOK.equals(actor.getRoleID())) {
			throw new AppException("NO AUTH");
		}
		
		if (fromtime.equals("") || totime.equals("")) {
		} else {
			totime = totime.replaceAll("/", "-");
			fromtime = fromtime.replaceAll("/", "-");
			fromtime = "\'" + fromtime + "\'";
			totime = "\'" + totime + "\'";
			filter.append(" and time>=" + fromtime + " and time<=" + totime);
		}

		MdoMap das = new MdoMap();
		if (!role.equals("")) {
			das.put("role", role);
		}

		if (!account.equalsIgnoreCase("")) {
			das.put("account", account);
		}

		if (!domain.equals("")) {
			das.put("domain", domain);
		}

		fillPagedDNA($SysLog, das, filter.toString(), "time", false);
	}

	//登录日志
	@Layout("NOT")
	public void loginlog() throws AppException, Exception {
		r.putMap("domains", $Domain.findAll());
	}

	public void listLoginLog() throws AppException, Exception {
		String account = $("account", "");
		String domain = $("domain", "");
		String fromtime = $("fromtime", "");
		String totime = $("totime", "");

		String filter = null;
		if (fromtime.equals("") || totime.equals("")) {
		} else {
			totime = totime.replaceAll("/", "-");
			fromtime = fromtime.replaceAll("/", "-");
			fromtime = "\'" + fromtime + "\'";
			totime = "\'" + totime + "\'";
			filter = "time>=" + fromtime + " and time<=" + totime;
		}

		MdoMap das = new MdoMap();
		if (!account.equals("")) {
			das.put("account", account);
		}
		if (!domain.equals("")) {
			das.put("domain", domain);
		}

		fillPagedDNA($AuthLog, das, filter, "time", false);
	}
	
	//邮件日志
	@Layout("NOT")
	public void mailLog() throws AppException, Exception {
	}
	
	public void listmaillog() throws AppException, Exception {
		String mailtype = $("mailtype", "");
		String fromtime = $("fromtime", "");
		String totime = $("totime", "");
		String mailFrom = $("mailfrom", "");
		String rcptTo = $("rcptto", "");
		String result = $("result", "");

		String filter = null;
		if (fromtime.equals("") || totime.equals("")) {
		} else {
			totime = totime.replaceAll("/", "-");
			fromtime = fromtime.replaceAll("/", "-");
			fromtime = "\'" + fromtime + "\'";
			totime = "\'" + totime + "\'";
			filter = "sendtime>=" + fromtime + " and sendtime<=" + totime;
		}

		MdoMap das = new MdoMap();
		
		if(!mailtype.equals("")){
			das.put("mailtype", mailtype);
		}
		
		if (!result.equals("")) {
			das.put("result", result);
		}
		if (!mailFrom.equals("")) {
			filter += " and mailFrom like '%"+ mailFrom +"%'";
//			das.put("mailFrom", mailFrom);
		}
		if (!rcptTo.equals("")) {
			filter += " and rcptTo like '%"+ rcptTo +"%'";
//			das.put("rcptTo", rcptTo);
		}
		fillPagedDNA($MailLog, das, filter, "sendTime", false);	
	}

	@Layout("NOT")
	public void sendMailStat() {
		
	}
}
