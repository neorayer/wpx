package com.skymiracle.wpx.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service extends Thread{

	public static void main(String[] args) throws IOException {
		int PORT = 8888; // 侦听端口
		// 创建ServerSocket
		ServerSocket serverSocket = new ServerSocket(PORT);
		// 开始循环
		while (true) {
			System.out.println("8888: start....................");
			// 等待连接
			Socket socket = serverSocket.accept();
			// 处理链接的线程类
			ServerThread st = new ServerThread(socket);
			// 启动线程处理
			new Thread(st).start();
			
			System.out.println("8888: end....................");
		}
	}
}
