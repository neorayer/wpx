package com.skymiracle.wpx.auth;

public interface AuthLogger {

	public void save(String username, String domain, String password,
			String modeName, String remoteIP);

}
