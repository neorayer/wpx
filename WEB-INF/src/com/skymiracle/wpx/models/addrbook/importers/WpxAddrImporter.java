package com.skymiracle.wpx.models.addrbook.importers;

import com.skymiracle.wpx.models.addrbook.AddrImporter;

public class WpxAddrImporter extends AddrImporter {

	@Override
	protected String getFieldnameFromLabel(String label) {
		return label;
	}

}
