package com.skymiracle.wpx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.skymiracle.io.StreamPipe;
import com.skymiracle.io.TextFile;

public class Tsts {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		ArrayList<String> list = new ArrayList<String>();
//		ArrayList<String> lines = TextFile.loadLinesList("C:/Documents and Settings/tianliang/桌面/c.csv");
//		for(String line: lines) {
//			list.add(line.substring(0, line.indexOf(",")));
//		}
//		
//		for(String s: list) {
//			System.out.println(s.trim());
//		}
		
		String a = "锟斤拷锟斤拷原锟斤拷";
		System.out.println(new String(a.getBytes("utf-8"), "iso-8859-1"));
		
//		ArrayList<String> lines = TextFile.loadLinesList("C:/Documents and Settings/tianliang/桌面/r.txt");
//		Collections.sort(lines);
//		
//		for(String s: lines) {
//			System.out.println(s.trim());
//		}
		
//		ArrayList<String> rLines = TextFile.loadLinesList("C:/Documents and Settings/tianliang/桌面/r.txt");
//		ArrayList<String> cLines = TextFile.loadLinesList("C:/Documents and Settings/tianliang/桌面/c.txt");
		
	}

}
