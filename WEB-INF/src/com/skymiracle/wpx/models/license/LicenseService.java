package com.skymiracle.wpx.models.license;

public class LicenseService {

	private Licenser licenser = new SimpleFileLicenser();
	
	public LicenseService() {
	}

	public Licenser getLicenser() {
		return licenser;
	}

	public void setLicenser(Licenser licenser) {
		this.licenser = licenser;
	}
	
	public long loadUsersLicenseCount() {
		licenser.load();
		return licenser.getUsersLicenseCount();
	}
	
}
