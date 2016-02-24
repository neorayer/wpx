package com.skymiracle.wpx.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Web {

	public static void main(String[] args) throws IOException {
		int port = 8888; // 侦听端口
		// 建立连接
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("web: start..............");
			// 输入数据的读取
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(in.readLine());
			//写入数据
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			String str = stdin.readLine();
			out.print(str);
			System.out.println("web: end..............");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
