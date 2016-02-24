package com.skymiracle.wpx.models.log;

import com.skymiracle.mdo5.Mdo;

public class MailLogStatics extends Mdo<MailLogStatics> {
	private String senderemail;

	private String senderdomain;

	private String count;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getSenderdomain() {
		return senderdomain;
	}

	public void setSenderdomain(String senderdomain) {
		this.senderdomain = senderdomain;
	}

	public String getSenderemail() {
		return senderemail;
	}

	public void setSenderemail(String senderemail) {
		this.senderemail = senderemail;
	}

	@Override
	public String[] keyNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String table() {
		return "tb_maillog";
	}

}
