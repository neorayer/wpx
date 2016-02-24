package com.skymiracle.wpx.models.conf;

public class SMTPConfiger {
	// 名称
	private String name;
	// 端口
	private int port;
	// 最大连接数
	private long maxConn;
	// 连接超时时间
	private long cmdTimeoutSeconds;
	// 白名单文件地址
	private String allowIpPath = "/wpx/conf/allow.ip";
	// 单名单文件地址
	private String rejectIpPath = "/wpx/conf/reject.ip";
	// 是否自动开始
	private String autoStart;
	// 最大连接频率
	private long maxConnRate;

	private long maxIpCurConn;
	private boolean connRecord = false;
	// 是否有连接频率限制
	private boolean connRateLimited = false;
	// 连接频率检测周期
	private long connRateSeconds;
	// 是否Helo命令检测
	private boolean heloCheck = false;
	// 是否做验证
	private boolean forceAuth = false;

	private String whiteHeloNamePath = "/wpx/conf/white.heloname";
	// 验证实现类名
	private String authClassImpl;

	private String mailBoxClassImpl;
	private String bounceTmplPath = "/wpx/tmpl/bounce.eml";
	// 最大发送人数
	private long defaultUserMaxCc;

	// 最大邮件大小
	private long maxMessageSize;

	public String getAllowIpPath() {
		return allowIpPath;
	}

	public void setAllowIpPath(String allowIpPath) {
		this.allowIpPath = allowIpPath;
	}

	public String getAuthClassImpl() {
		return authClassImpl;
	}

	public void setAuthClassImpl(String authClassImpl) {
		this.authClassImpl = authClassImpl;
	}

	public String getAutoStart() {
		return autoStart;
	}

	public void setAutoStart(String autoStart) {
		this.autoStart = autoStart;
	}

	public String getBounceTmplPath() {
		return bounceTmplPath;
	}

	public void setBounceTmplPath(String bounceTmplPath) {
		this.bounceTmplPath = bounceTmplPath;
	}

	public long getCmdTimeoutSeconds() {
		return cmdTimeoutSeconds;
	}

	public void setCmdTimeoutSeconds(long cmdTimeoutSeconds) {
		this.cmdTimeoutSeconds = cmdTimeoutSeconds;
	}

	public boolean isConnRateLimited() {
		return connRateLimited;
	}

	public void setConnRateLimited(boolean connRateLimited) {
		this.connRateLimited = connRateLimited;
	}

	public long getConnRateSeconds() {
		return connRateSeconds;
	}

	public void setConnRateSeconds(long connRateSeconds) {
		this.connRateSeconds = connRateSeconds;
	}

	public boolean isConnRecord() {
		return connRecord;
	}

	public void setConnRecord(boolean connRecord) {
		this.connRecord = connRecord;
	}

	public long getDefaultUserMaxCc() {
		return defaultUserMaxCc;
	}

	public void setDefaultUserMaxCc(long defaultUserMaxCc) {
		this.defaultUserMaxCc = defaultUserMaxCc;
	}

	public boolean isForceAuth() {
		return forceAuth;
	}

	public void setForceAuth(boolean forceAuth) {
		this.forceAuth = forceAuth;
	}

	public boolean isHeloCheck() {
		return heloCheck;
	}

	public void setHeloCheck(boolean heloCheck) {
		this.heloCheck = heloCheck;
	}

	public String getMailBoxClassImpl() {
		return mailBoxClassImpl;
	}

	public void setMailBoxClassImpl(String mailBoxClassImpl) {
		this.mailBoxClassImpl = mailBoxClassImpl;
	}

	public long getMaxConn() {
		return maxConn;
	}

	public void setMaxConn(long maxConn) {
		this.maxConn = maxConn;
	}

	public long getMaxConnRate() {
		return maxConnRate;
	}

	public void setMaxConnRate(long maxConnRate) {
		this.maxConnRate = maxConnRate;
	}

	public long getMaxIpCurConn() {
		return maxIpCurConn;
	}

	public void setMaxIpCurConn(long maxIpCurConn) {
		this.maxIpCurConn = maxIpCurConn;
	}

	public long getMaxMessageSize() {
		return maxMessageSize;
	}

	public void setMaxMessageSize(long maxMessageSize) {
		this.maxMessageSize = maxMessageSize;
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

	public String getRejectIpPath() {
		return rejectIpPath;
	}

	public void setRejectIpPath(String rejectIpPath) {
		this.rejectIpPath = rejectIpPath;
	}

	public String getWhiteHeloNamePath() {
		return whiteHeloNamePath;
	}

	public void setWhiteHeloNamePath(String whiteHeloNamePath) {
		this.whiteHeloNamePath = whiteHeloNamePath;
	}
}
