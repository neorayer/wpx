package com.skymiracle.wpx.models.addrbook;

import java.util.ArrayList;

import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.sor.exception.AppException;

public abstract class AddrImporter {

	public MList<AddrPsn> getPsns(String[] labels, ArrayList<String[]> lines) throws AppException, Exception {
		MList<AddrPsn> psns = new MList<AddrPsn>();
		for(String[] values: lines) {
			AddrPsn psn = new AddrPsn();
			for(int i=0; i<labels.length; i++) {
				try {
				String name = getFieldnameFromLabel(labels[i]);
				if (name == null)
					throw new RuntimeException("无法识别列　" + labels[i]);
				String v = values[i];
					psn.fieldValue(name, v);
				} catch (Exception e) {
					Logger.warn("", e);
				}
			}
			psns.add(psn);
		}
		
		return psns;
	}

	protected abstract String getFieldnameFromLabel(String label);
}
