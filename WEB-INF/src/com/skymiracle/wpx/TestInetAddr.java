package com.skymiracle.wpx;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddr {
	public static void main(String[] args) throws UnknownHostException {
		{
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			System.out.println(addr);
			System.out.println("isAnyLocalAddress : " + addr.isAnyLocalAddress());
			System.out.println("isLinkLocalAddress : " + addr.isLinkLocalAddress());
			System.out.println("isLoopbackAddress : " + addr.isLoopbackAddress());
			System.out.println("isMulticastAddress : " + addr.isMulticastAddress());
			System.out.println("isSiteLocalAddress : " + addr.isSiteLocalAddress());
			System.out.println("getHostAddress : " + addr.getHostAddress());
		}
		
		System.out.println();
		System.out.println();
		
		{
			InetAddress addr = InetAddress.getByName("192.168.1.188");
			System.out.println(addr);
			System.out.println("isAnyLocalAddress : " + addr.isAnyLocalAddress());
			System.out.println("isLinkLocalAddress : " + addr.isLinkLocalAddress());
			System.out.println("isLoopbackAddress : " + addr.isLoopbackAddress());
			System.out.println("isMulticastAddress : " + addr.isMulticastAddress());
			System.out.println("isSiteLocalAddress : " + addr.isSiteLocalAddress());
			System.out.println("getHostAddress : " + addr.getHostAddress());
		}
		
		System.out.println();
		System.out.println();
		
		{
			InetAddress addr = InetAddress.getByName("http://mail.163.com");
			System.out.println(addr);
			System.out.println("isAnyLocalAddress : " + addr.isAnyLocalAddress());
			System.out.println("isLinkLocalAddress : " + addr.isLinkLocalAddress());
			System.out.println("isLoopbackAddress : " + addr.isLoopbackAddress());
			System.out.println("isMulticastAddress : " + addr.isMulticastAddress());
			System.out.println("isSiteLocalAddress : " + addr.isSiteLocalAddress());
			System.out.println("getHostAddress : " + addr.getHostAddress());
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("getLocalHost : " + InetAddress.getLocalHost());
	}
}
