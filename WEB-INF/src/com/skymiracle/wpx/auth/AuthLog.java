package com.skymiracle.wpx.auth;

import static com.skymiracle.wpx.Singletons.$AuthLog;

import java.util.List;

import com.skymiracle.mdo4.DaoAttrSet;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.Mdo_X;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;

public class AuthLog extends WpxUuidMdo<AuthLog> {

	public AuthLog() {
		super($AuthLog);
	}

	private String account;

	private String domain;

	private String time;

	private String type;

	private String ip;

	@Override
	public String table() {
		return "tb_login_log";
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static class X extends Mdo_X<AuthLog> implements AuthLogger {

		public void save(String username, String domain, String password,
				String modeName, String remoteIP) {
			AuthLog authLog = new AuthLog();
			authLog.setAccount(username);
			authLog.setDomain(domain);
			authLog.setIp(remoteIP);
			authLog.setType(modeName);
			authLog.setTime(CalendarUtil
					.getLocalDateTime("yyyy-MM-dd HH:mm:ss"));
			try {
				authLog.create();
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@SuppressWarnings("unchecked")
		public List<AuthLog> getLoginLogs(String account, String domain,
				String fromtime, String totime, int pagenum, int perpagecount)
				throws Exception {
			MdoMap das = new MdoMap();
			if (!account.equalsIgnoreCase("")) {
				das.put("account", account);
			}
			if (!domain.equalsIgnoreCase("")) {
				das.put("domain", domain);
			}
			String filter;
			filter = "time>='" + fromtime + "' and time<='" + totime + "'";
			List<AuthLog> list = this.find(das, filter, "time", true,
					(pagenum - 1) * perpagecount, perpagecount);
			return list;
		}

		@SuppressWarnings("unchecked")
		public long count(String account, String domain, String fromtime,
				String totime) throws Exception {
			MdoMap das = new MdoMap();
			if (!account.equalsIgnoreCase("")) {
				das.put(" account", account);
			}
			if (!domain.equalsIgnoreCase("")) {
				das.put(" domain", domain);
			}
			String filter;
			filter = "time>='" + fromtime + "' and time<='" + totime + "'";
			return this.count(das, filter);
		}

	}

}
