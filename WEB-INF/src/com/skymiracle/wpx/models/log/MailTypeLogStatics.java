package com.skymiracle.wpx.models.log;

import com.skymiracle.mdo5.Mdo;

public class MailTypeLogStatics extends Mdo<MailTypeLogStatics> {
	private String sendtypestr;

	private String senderemail;

	private String datetimestr;

	private String receiverstr;

	public static final String[] mailtypeStr = { "normal", "autoReply",
			"autoFoward", "sendToNative", "sendToForeign", "bounceToNative",
			"bounceToForeign", "forwardToNative", "forwardToForeign", "web",
			"client", "autoReplyToNative", "autoReplyToForeign" };

	public static String[] getMailtypeStr() {
		return mailtypeStr;
	}

	public String getDatetimestr() {
		return datetimestr;
	}

	public void setDatetimestr(String datetimestr) {
		this.datetimestr = datetimestr;
	}

	public String getReceiverstr() {
		return receiverstr;
	}

	public void setReceiverstr(String receiverstr) {
		this.receiverstr = receiverstr;
	}

	public String getSenderemail() {
		return senderemail;
	}

	public void setSenderemail(String senderemail) {
		this.senderemail = senderemail;
	}

	public String getSendtypestr() {
		return sendtypestr;
	}

	public void setSendtypestr(String sendtypestr) {
		this.sendtypestr = sendtypestr;
	}

	@Override
	public String[] keyNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String table() {
		return "tb_mailsendtypelog";
	}

}
