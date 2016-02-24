package com.skymiracle.wpx.util;

import java.io.IOException;

import com.skymiracle.util.Md5;

public class SerialNumberBuilder {

	private final static String sp = "zaoshuizaoqijingshenhao!";
	
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out.println("java SerialNumberBuilder $superpassword $value!");
			System.exit(0);
		}
		String superPass = args[0];
		if (!superPass.equals(sp)) {
			System.out.println("Superpassword is wrong!");
			System.exit(0);
		}
		
		String value = args[1].toLowerCase();
		Md5 md5 = new Md5(value);
		md5.processString();
		String s1 = md5.getStringDigest();
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<s1.length(); i++) {
			char c1 = s1.charAt(i);
			sb.append((char)(c1 + 1));
		}
		System.out.println(s1);
		System.out.println(sb.toString().toUpperCase());
	}
}
