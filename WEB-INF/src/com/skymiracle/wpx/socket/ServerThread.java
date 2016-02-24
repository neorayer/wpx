package com.skymiracle.wpx.socket;

/*
 * ServerThread.java
 *
 * Created on 13 November 2006, 16:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread implements Runnable {

	private Socket socket;

	BufferedReader in ;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("run ..............");
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			PrintWriter out = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("inputStream :" + e.getMessage());
		}
		while (true) {
			try {
				String message = in.readLine();
				System.out.println(message);
				if(message.equals("test")){
					System.out.println("sccess");
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}

	

}
