package com.skymiracle.wpx.models.log;

import static com.skymiracle.wpx.Singletons.$MailLog;

import com.skymiracle.mdo5.Mdo_X;
import com.skymiracle.server.tcpServer.mailServer.queue.MailLogger;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxUuidMdo;

public class MailLog extends WpxUuidMdo<MailLog> {

	public MailLog() {
		super($MailLog);
	}

	@Title("发送时间")
	private String sendTime;

	public static final String MAILTYPE_D = "DELIVER";
	public static final String MAILTYPE_R = "RELAY";
	@Title("类型")
	private String mailType;

	@Title("发信人")
	private String mailFrom;

	@Title("收信人")
	private String rcptTo;

	@Title("邮件大小")
	private long size;

	public static final String RESULT_S = "S";
	public static final String RESULT_F = "F";
	@Title("结果")
	private String result;

	@Title("原因")
	private String cause;

	@Title("备注")
	private String remark;

	@Override
	public String table() {
		return "tb_mail_log";
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getRcptTo() {
		return rcptTo;
	}

	public void setRcptTo(String rcptTo) {
		this.rcptTo = rcptTo;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static class X extends Mdo_X<MailLog> implements MailLogger {

		public void save(String sendTime, String mailType, String mailFrom,
				String rcptTo, long size, String result, String cause,
				String remark) {
			MailLog mailLog = new MailLog();
			mailLog.setSendTime(sendTime);
			mailLog.setMailType(mailType);
			mailLog.setMailFrom(mailFrom);
			mailLog.setRcptTo(rcptTo);
			mailLog.setSize(size);
			mailLog.setResult(result);
			mailLog.setCause(cause);
			mailLog.setRemark(remark);
			try {
				mailLog.create();
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
