package com.skymiracle.wpx.models.conf;

public class MBAPConfgier {
	// 名称
	private String name;
	// 存储IP
	private String host;
	// 存储Port
	private int port;
	// 最大连接数
	private int maxconn;
	// 连接超时时间
	private long cmdtimeoutseconds;
	// 是否自动起动
	private String autostart;
	// 白名单IP文件地址
	private String allowippath;
	// 黑名单IP文件地址
	private String rejectippath;
	// 
	private int hashdepth;

	public String getAllowippath() {
		return allowippath;
	}

	public void setAllowippath(String allowippath) {
		this.allowippath = allowippath;
	}

	public String isAutostart() {
		return autostart;
	}

	public void setAutostart(String autostart) {
		this.autostart = autostart;
	}

	public long getCmdtimeoutseconds() {
		return cmdtimeoutseconds;
	}

	public void setCmdtimeoutseconds(long cmdtimeoutseconds) {
		this.cmdtimeoutseconds = cmdtimeoutseconds;
	}

	public int getHashdepth() {
		return hashdepth;
	}

	public void setHashdepth(int hashdepth) {
		this.hashdepth = hashdepth;
	}

	public int getMaxconn() {
		return maxconn;
	}

	public void setMaxconn(int maxconn) {
		this.maxconn = maxconn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getRejectippath() {
		return rejectippath;
	}

	public void setRejectippath(String rejectippath) {
		this.rejectippath = rejectippath;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
