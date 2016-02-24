package com.skymiracle.wpx;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.skymiracle.io.TextFile;

public class TestFileSaveAndRead {
	public  static void main(String[] args) throws IOException {
		long begin = System.currentTimeMillis();
		System.out.println("start red...");
		List<String> linesList = null;
		try {
			linesList = TextFile.loadLinesList("D:/a.txt");
			System.out.println(linesList.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("read file times: " + ((System.currentTimeMillis() - begin)));
		
		
		System.out.println("start calc length ...");
		long c = 0;
		for (int i = 0; i < linesList.size(); i++)
			c += (linesList.get(i)).length();
		System.out.println("file length: " + c);
		
		
		begin = System.currentTimeMillis();
		System.out.println("start save...");
		
		File file = new File("D:/a1.txt");
		file.createNewFile();
		TextFile.save("D:/a1.txt", linesList);
		System.out.println("save file times: " + ((System.currentTimeMillis() - begin)));
		
		System.out.println("基本类型：int 二进制位数：" + Integer.SIZE); 
        System.out.println("包装类：java.lang.Integer"); 
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE); 
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE); 
        System.out.println();  
	}
}
