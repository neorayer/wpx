package com.skymiracle.wpx.models.license;

import com.skymiracle.util.Md5;

public class SerialNumberChecker {

	public static boolean check(String value, String sn) {
		String df = value.toLowerCase();
		Md5 md5 = new Md5(df);
		md5.processString();
		String s1 = md5.getStringDigest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			sb.append((char) (c1 + 1));
		}

		String realSN = sb.toString().toUpperCase();
		return sn.equals(realSN);
	}
}
