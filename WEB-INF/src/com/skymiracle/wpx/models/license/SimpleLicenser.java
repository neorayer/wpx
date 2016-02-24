package com.skymiracle.wpx.models.license;

public class SimpleLicenser implements Licenser {

	private long usersLicenseCount;

	private String sn;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
		load();
	}

	public long getUsersLicenseCount() {
		return usersLicenseCount;
	}

	public void load() {
		String[] strs = sn.split("_");
		if (strs.length == 2 && SerialNumberChecker.check(strs[0], strs[1])) {
			long temp = 0;
			try {
				temp = Long.parseLong(strs[0]);
			} catch (Exception e) {
				temp = 0L;
			}
			usersLicenseCount = temp;
		}

	}

}
