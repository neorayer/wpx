package com.skymiracle.wpx;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import com.skymiracle.io.TextFile;


public class TestThread {
	
	protected static AtomicInteger threadCount = new AtomicInteger(0);
	
	public static void main(String[] args) throws IOException {
//		String bounceEml = TextFile.loadString("/wpx/timermail/bounce.eml", "\r\n");
//		System.out.println(bounceEml);
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		
//		String content = bounceEml.replace("$FROM$",
//				"\"postmaster\" <postmaster@skymiracle>").replace(
//				"$TO$", "tianliang@skymiracle.com").replace("$MSG_TO$","tinaliang@skymrialc.eomc").replace("$SUBJECT$",
//						"您好").replace("$CONTENT$", "Network is unreachable: connect");
//		System.out.println(content);
		Thread[] reads = new Thread[1000];
		
		for(int i = 0; i< reads.length; i++) {
			Thread read = new Thread() {
				@Override
				public void run() {
					threadCount.addAndGet(-1);
				}
				
				public void start() {
					threadCount.addAndGet(1);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					super.start();
				}
			};
			reads[i] = read;
		}
		
		for(Thread read: reads)
			read.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadCount.get());
		
	}

}

