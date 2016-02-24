package com.skymiracle.wpx.models.bmsandnds85;

import com.skymiracle.logger.Logger;
import com.skymiracle.wpx.models.user.User;

public abstract class UserRecord {
	protected String domain;

	protected String uid;

	// 目录
	protected String dir;

	// BOOKMARK | NETDISK
	protected String type;

	protected String name;

	public boolean isdir = false;

	public long size;

	// netdisk filepath or bookmark url
	public String memo;

	protected User user;

	public UserRecord(String domain, String uid, String type) {
		this.domain = domain;
		this.type = type;
		this.uid = uid;
	}

	public String toString() {
		return "[" + type.toUpperCase() + "]" + (isdir ? "[DIR]" : "") + "\t"
				+ uid + "@" + domain + "\t\t" + dir + "\t\t" + name
				+ (memo != null ? "\t\t" + memo : "");
	}

	public void create() throws Exception {
		user = new User(this.domain, this.uid);
		if (!user.exists()) {
			Logger.debug("user not exist. domain= " + this.domain + ", uid = " + this.uid);
			return;
		}
		user.load();

		create0();
	}

	public abstract void create0() throws Exception;
}
