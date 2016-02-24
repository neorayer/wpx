package com.skymiracle.wpx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.naming.NamingException;

import com.skymiracle.dns.Dns;
import com.skymiracle.io.StreamPipe;
import com.skymiracle.util.Base64;

public class TestWums {
	public static void main(String[] args) throws IOException,
			InterruptedException, NamingException {
		// String arg = "d://wums//中国人-wufax_test.doc";
		// String[] cmds = new String[] { "d://wums//UfaxPrinter.exe", arg };
		// Process process = Runtime.getRuntime().exec(cmds);
		// process.waitFor();
		// InputStream in = process.getInputStream();
		// String a = StreamPipe.inputToString(in, "utf-8", true);
		// System.out.println("a" + a);
		// System.out.println(process.exitValue());

//		String[] aa = Dns.resolveMxOrARecord("mail.163.com");
//		for(String a: aa) {
//			System.out.println(a);
//		}
//		InetAddress myInetAddress;
//		myInetAddress = InetAddress.getByName("mail.edu.com.");
//		System.out.println(myInetAddress);
		
		String uid = "tianliang";
		String pass = "111111";
		System.out.println(Base64.encodeToString(uid, "utf-8"));
		System.out.println(Base64.encodeToString(pass, "utf-8"));
	}

}
