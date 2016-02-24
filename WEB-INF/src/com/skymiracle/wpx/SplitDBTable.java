package com.skymiracle.wpx;

import java.util.Date;

import com.skymiracle.util.CalendarUtil;

public class SplitDBTable {

	private String separator = "_";

	public static enum Type {
		Non, Day, Month, Year
	}

	private Type type = Type.Non;

	public SplitDBTable() {
	}

	public SplitDBTable(Type type) {
		this.type = type;
	}

	public SplitDBTable(Type type, String separator) {
		this.type = type;
		this.separator = separator;
	}

	public String select(String besename) {
		if (Type.Non == type) {
			return besename;
		} else if (Type.Day == type) {
			String t = CalendarUtil.dateToString(new Date(), "yyMMdd");
			return besename + separator + t;
		} else if (Type.Month == type) {
			String t = CalendarUtil.dateToString(new Date(), "yyMM");
			return besename + separator + t;
		} else if (Type.Year == type) {
			String t = CalendarUtil.dateToString(new Date(), "yy");
			return besename + separator + t;
		} else
			return besename;
	}

	public static void main(String[] args) {
		{
			SplitDBTable sdb = new SplitDBTable(Type.Non);
			System.out.println("Non: " + sdb.select("test_db"));
		}
		{
			SplitDBTable sdb = new SplitDBTable(Type.Day);
			System.out.println("Day: " + sdb.select("test_db"));
		}
		{
			SplitDBTable sdb = new SplitDBTable(Type.Month);
			System.out.println("Month: " + sdb.select("test_db"));
		}
		{
			SplitDBTable sdb = new SplitDBTable(Type.Year);
			System.out.println("Year: " + sdb.select("test_db"));
		}

	}
}
