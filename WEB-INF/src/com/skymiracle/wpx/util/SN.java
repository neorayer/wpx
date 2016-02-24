package com.skymiracle.wpx.util;

import com.skymiracle.logger.Logger;

public class SN {
	
	private static Object obj;
	
	private static long lasttime;
	
	private long delay = 5;
	
	static{
		lasttime = System.currentTimeMillis();
		obj = new Object();
	}
	
	public SN() throws Exception{ 
		
		synchronized(obj){	
			boolean flag = false;
			while(!flag){
				long time = System.currentTimeMillis();
				if(time < lasttime + delay){
						Thread.sleep(2);
					continue;
				}else{
					lasttime = time;
					flag = true;
				}
			}
		}
	}

	public static String seriID(){
		return System.currentTimeMillis()+"";
	}
	
	public static String createPassword(){
		String d = Math.random()*10000000+"";
		d = d.substring(0, 6);
		int a = d.indexOf(".");
		if(a!=-1)
			d = d.replace(".","0");
		return d;
	}
	
}
