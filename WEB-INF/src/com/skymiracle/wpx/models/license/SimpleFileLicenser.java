package com.skymiracle.wpx.models.license;

import java.io.File;
import java.io.IOException;

import com.skymiracle.io.TextFile;
import com.skymiracle.logger.Logger;

public class SimpleFileLicenser implements Licenser {
	
	private long usersLicenseCount = 10;

	private String licensePath =  "/wpx/conf/licence.conf";
	
	/* (non-Javadoc)
	 * @see com.skymiracle.wpx.license.Liscenser#getUsersLicenseCount()
	 */
	public long getUsersLicenseCount() {
		return usersLicenseCount;
	}

	/* (non-Javadoc)
	 * @see com.skymiracle.wpx.license.Liscenser#setUsersLicenseCount(long)
	 */
	public void setUsersLicenseCount(long usersLicenseCount) {
		this.usersLicenseCount = usersLicenseCount;
	}

	/* (non-Javadoc)
	 * @see com.skymiracle.wpx.license.Liscenser#getLicensePath()
	 */
	public String getLicensePath() {
		return licensePath;
	}

	/* (non-Javadoc)
	 * @see com.skymiracle.wpx.license.Liscenser#setLicensePath(java.lang.String)
	 */
	public void setLicensePath(String licensePath) {
		this.licensePath = licensePath;
	}
	
	/* (non-Javadoc)
	 * @see com.skymiracle.wpx.license.Liscenser#init()
	 */
	public void load() {
		try {
			if (!new File(licensePath).exists()) {
				Logger.error("Can not find licensePath " + licensePath + ". Use 10 users licenses only!");
				return;
			}
			String[] strings = TextFile.loadLines(licensePath);
			if (strings.length > 0) {
				String[] strs = strings[0].split("_");
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
		} catch (IOException e) {
			Logger.error("",e);
		}

	}
}
