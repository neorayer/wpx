package com.skymiracle.wpx;

import static com.skymiracle.wpx.Singletons.*;
import static com.skymiracle.wpx.Singletons.beanFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.skymiracle.logger.Logger;
import com.skymiracle.logger.LoggerConf;
import com.skymiracle.server.listener.ListenerServer;
import com.skymiracle.server.tcpServer.cmdStorageServer.CmdStorageServer;
import com.skymiracle.server.tcpServer.mailServer.Pop3.Pop3Server;
import com.skymiracle.server.tcpServer.mailServer.Smtp.SmtpServer;
import com.skymiracle.wpx.models.conf.SmtpTrustIp;

public class Starter {

	public static void main(String[] args) throws Exception {
		LoggerConf loggerConf = (LoggerConf) beanFactory.getBean("Logger");
		Logger.setLoggerConf(loggerConf);
		// Pop3Logger
		Pop3Server pop3Server = (Pop3Server) beanFactory.getBean("Pop3Server");
		// SmtpServer
		final SmtpServer smtpServer = (SmtpServer) beanFactory
				.getBean("SmtpServer");
		// StorageServer

		TimerTask timeTask = new TimerTask() {
			public void run() {
				List<SmtpTrustIp> stips = null;
				try {
					stips = $SmtpTrustIp.findAll();
				} catch (Exception e) {
					stips = new LinkedList<SmtpTrustIp>();
				}
				smtpServer.cleanupSmtpTrustIP();
				for (SmtpTrustIp stip : stips)
					smtpServer.addSmtpTrustIP(stip.getIp());
			}
		};
//		Timer timer = new Timer();
//		timer.schedule(timeTask, 0, 5000);

		CmdStorageServer storageServer = (CmdStorageServer) beanFactory
				.getBean("StorageServer");

		// IpFilterServer
		ListenerServer ipFilterListenerServer = (ListenerServer) beanFactory
				.getBean("IpFilterListenerServer");
		ipFilterListenerServer.start();


		pop3Server.start();
		storageServer.start();
		smtpServer.start();

		//群发邮件
		$TimerMail.start();
	}

}
