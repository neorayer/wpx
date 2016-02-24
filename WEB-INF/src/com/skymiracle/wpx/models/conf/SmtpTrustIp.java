package com.skymiracle.wpx.models.conf;

import static com.skymiracle.wpx.Singletons.$SmtpTrustIp;

import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;

public class SmtpTrustIp extends WpxMdo<SmtpTrustIp> {

	public SmtpTrustIp() {
		super($SmtpTrustIp);
	}
	
	public SmtpTrustIp(String ip) {
		this();
		this.ip = ip;
	}

	private String ip;

	private String description;

	private String createTime;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public SmtpTrustIp create() throws AppException, Exception {
		this.createTime = CalendarUtil.getLocalDateTime();
		return super.create();
	}

	@Override
	public String[] keyNames() {
		return new String[] { "ip" };
	}

	@Override
	public String table() {
		return "tb_smtpTrushIp";
	}

	public static class X extends WpxMdo_X<SmtpTrustIp> {

		public X() {
			super(SmtpTrustIp.class);
		}

	}

}
