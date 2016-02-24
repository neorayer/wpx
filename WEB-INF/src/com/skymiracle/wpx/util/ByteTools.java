package com.skymiracle.wpx.util;

import java.text.DecimalFormat;

public class ByteTools {
	public static long byteToK(long data) {
		long dd = 0;
		try {
			dd = data;
		} catch (NumberFormatException e) {
			dd = 0;
		}
		dd = dd / 1024;
		return dd ;
	}
	
	public static long byteToM(long data) {
		long dd = 0;
		try {
			dd = data;
		} catch (NumberFormatException e) {
			dd = 0;
		}
		dd = dd / 1024 / 1024;
		return dd ;
	}

	public static long mToByte(String data) {
		long dd = Long.parseLong(data);
		return mToByte(dd);
	}

	public static long mToByte(long data) {
		long dd = data;
		dd = dd * 1024 * 1024;
		return dd ;
	}
	
	
	public static double getByteToK(long data) {
		double dd = 0;
		try {
			dd = (double)data;
		} catch (NumberFormatException e) {
			dd = 0;
		}
		dd =(double) Math.round(dd * 100 / 1024 )/100;
		return dd ;
	}
	
	public static double getByteToM(long data) {
		double dd = 0;
		try {
			dd = (double)data;
		} catch (NumberFormatException e) {
			dd = 0;
		}
		dd =(double) Math.round(dd * 100 / 1024 / 1024 )/100;
		return dd ;
	}
	
	public static String getViewSize(long data) {
		double dd = 0;
		try {
			dd = (double)data;
		} catch (NumberFormatException e) {
			dd = 0;
		}

		if (data > 1024 * 1024 * 1024) {
			dd =(double) Math.round(dd * 100 / 1024 / 1024 /1024 )/100;
			return dd + "G";
		} else if (data > 1024 * 1024) {
			dd =(double) Math.round(dd * 100 / 1024 / 1024 )/100;
			return dd + "M";
		} else if (data > 1024) {
			dd =(double) Math.round(dd * 100 / 1024)/100;
			return dd + "K";
		}else {
			dd =(double) Math.round(dd * 100)/100;
			return dd + "B";
		}
	}

	public static void main(String args[]) {
		long dd = 100254821;
		System.out.println(ByteTools.getByteToM(dd));
		System.out.println(ByteTools.getByteToK(dd));
	}
}
