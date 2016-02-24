package com.skymiracle.wpx;

import java.io.IOException;
import java.util.ArrayList;

import com.skymiracle.csv.Csv;

public class TestLineSp {
	public static void main(String[] args) throws IOException {
//		Csv csv = new Csv(
//				"C:\\Documents and Settings\\tianliang\\桌面\\cache.csv", "utf-8");
//		ArrayList<String[]> lines = csv.getLineList();
//		for (String[] line : lines) {
//			String s = join(line, ",");
//			System.out.println(s);
//		}
		
		String a = "虏芒脢脭脫脢录镁脤氓";
		System.out.println(new String(a.getBytes("gbk"), "utf-8"));
	}

//	public static String join(String[] ss, String sep) {
//		int len = ss.length;
//		if (len == 0)
//			return "";
//		StringBuffer sb = new StringBuffer();
//		int i = 0;
//		for (String s : ss) {
//			if(s.indexOf("\r\n") > -1)
//				s = s.replaceAll("\r\n", "");
//			sb.append(s);
//			if (++i < len) 
//				sb.append(sep);
//		}
//		return sb.toString();
//	}
}
