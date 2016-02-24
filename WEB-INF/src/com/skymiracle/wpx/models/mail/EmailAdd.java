package com.skymiracle.wpx.models.mail;

import com.skymiracle.mime.RichMailAddress;

public class EmailAdd {
	private String dispname;
	
	private String emaddr;
	
	private RichMailAddress getRichMailAddress(String emadd){
		return new RichMailAddress(emadd);
	}
	
	public EmailAdd(String src){
		RichMailAddress r =  getRichMailAddress(src);
		String emStr = r.getMailAddress();
		dispname = r.getDisplayName();
		emaddr = emStr;
	}

	public String getDispname() {
		return dispname;
	}

	public String getEmaddr() {
		return emaddr;
	}

	public void setDispname(String dispname) {
		this.dispname = dispname;
	}

	public void setEmaddr(String emaddr) {
		this.emaddr = emaddr;
	}
	
	
}
