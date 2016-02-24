package com.skymiracle.wpx.models.mail;

import com.skymiracle.mdo5.Mdo.Title;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;
import static com.skymiracle.wpx.Singletons.*;

@Title("邮件签名")
public class MailInk extends WpxUuidMdo<MailInk>{


	private StringBuffer ink;

	private String name;

	private String owner;

	public MailInk() {
		super($MailInk);
	}

	public StringBuffer getInk() {
		return ink;
	}

	public void setInk(StringBuffer ink) {
		this.ink = ink;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}


	@Override
	public String table() {
		return "tb_mail_ink";
	}


	public static class X extends WpxMdo_X<MailInk> {

		public X() {
			super(MailInk.class);
		}
		
	}
}
