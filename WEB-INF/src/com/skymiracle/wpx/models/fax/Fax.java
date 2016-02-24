package com.skymiracle.wpx.models.fax;

import static com.skymiracle.wpx.Singletons.$Fax;

import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;

public class Fax extends WpxMdo<Fax> {
	public Fax() {
		super($Fax);
	}
	
	public String id;
	
	public String mail;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public Fax(String id) {
		this();
		this.id = id;
	}

	
	@Override
	public String[] keyNames() {
		return new String[]{"id"};
	}

	@Override
	public String table() {
		return "tb_fax";
	}
	public static class X extends WpxMdo_X<Fax> {

		public X() {
			super(Fax.class);
		}
		
	}


}
