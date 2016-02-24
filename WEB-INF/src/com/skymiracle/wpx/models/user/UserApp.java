package com.skymiracle.wpx.models.user;

import com.skymiracle.mdo4.*;

public class UserApp extends Dao{

	private String uid;
	
	private String dc;
	
	private String app;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}


	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	@Override
	public String fatherDN(String baseDN) throws NullKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] keyNames() {
		return new String[]{"dc", "uid", "app"};
	}

	@Override
	public String[] objectClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selfDN() throws NullKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String table() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
