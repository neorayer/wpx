package com.skymiracle.wpx.models.conf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import com.skymiracle.wpx.models.conf.ConfSet;

public class ConfUtil {
	//缺省域，默认最大发件人数，日志级别，smtp认证开关, 最大邮件大小(单位：B)
	public static String[] confs =new String[]{"authmail.defaultDomain","smtp.defaultUserMaxCc","logger.level","smtpservice.forceAuth", "smtp.maxMessageSize"};
 	/**
	 * 读取文本文件.
	 * @param path       文件路径
	 */
	public static Map<String, ConfSet> readFile(String path) {
		Map<String, ConfSet> confMap = new TreeMap<String, ConfSet>();
		try {
			File f = new File(path);
			FileReader  r = new FileReader(f);
			BufferedReader br = new BufferedReader(r);
			String read = null;
			while ((read = br.readLine()) != null) {
				for(String key : confs){
					if(read.indexOf(key)!=-1){
						String value = read.substring(read.indexOf("=")+1);
						ConfSet conf =new ConfSet();
						conf.setKeyname(key.trim());
						conf.setValue(value.trim());
						confMap.put(key, conf);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return confMap;
	}
	
	
	/**
	 * 将文件中指定内容的第一行替换为其它内容.
	 * @param path       文件路径
	 * @param oldStr     查找内容
	 * @param replaceStr 替换内容
	 */
	public static void replaceByStr(String path, Map<String, ConfSet> confMap) {
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			StringBuffer buf = new StringBuffer();
			String temp = null;

			while ((temp = br.readLine()) != null) {
				boolean isupdate =false;
				for(String key : confs){
					if(temp.indexOf(key)!=-1){
						// 将修改内容插入
						ConfSet confSet = confMap.get(key);
						buf = buf.append(confSet.getKeyname() + "=" + confSet.getValue());
						isupdate =true;
					}
				}
				if(!isupdate)
					buf = buf.append(temp);
				
				//插入换行
				buf = buf.append(System.getProperty("line.separator"));
			}

			br.close();
			FileOutputStream fos = new FileOutputStream(file);
			PrintWriter pw = new PrintWriter(fos);
			pw.write(buf.toString().toCharArray());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] s) throws IOException {
		String path ="D:/app.props";
		Map<String, ConfSet> map = ConfUtil.readFile(path);
		System.out.println("============================");
		for (ConfSet confSet: map.values()) {
			System.out.println(confSet.getKeyname() + "==" + confSet.getValue());
		}
	}
}
