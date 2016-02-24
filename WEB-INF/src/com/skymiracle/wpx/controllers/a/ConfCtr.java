package com.skymiracle.wpx.controllers.a;

import static com.skymiracle.wpx.Singletons.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.skymiracle.client.tcpClient.smtpClient.SmtpSendSession;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.sor.render.PageRenderer;
import com.skymiracle.wpx.Starter;
import com.skymiracle.wpx.models.conf.ConfSet;
import com.skymiracle.wpx.models.conf.ConfUtil;
import com.skymiracle.wpx.models.conf.SingleConf;
import com.skymiracle.wpx.models.conf.SmtpTrustIp;
import com.skymiracle.wpx.util.ByteTools;
import com.skymiracle.wpx.util.ClassPath;
import com.skymiracle.wpx.util.SysMonitor;

@Sessioned
public class ConfCtr extends Ctr {
	@Layout("NOT")
	public void main() {
	}

	@Layout("NOT")
	public void tools() {
	}

	@Layout("NOT")
	public void service() {
		String startupServerPath = $SingleConf
				.getSingleConfValue($SingleConf.SCK_startupServerPath);

		String shutdownServerPath = $SingleConf
				.getSingleConfValue($SingleConf.SCK_shutdownServerPath);

		String startupWebPath = $SingleConf
				.getSingleConfValue($SingleConf.SCK_startupWebPath);

		String shutdownWebPath = $SingleConf
				.getSingleConfValue($SingleConf.SCK_shutdownWebPath);

		r.putMap("SCK_startupServerPath", $SingleConf.SCK_startupServerPath);
		r.putMap("SCK_shutdownServerPath", $SingleConf.SCK_shutdownServerPath);
		r.putMap("SCK_startupWebPath", $SingleConf.SCK_startupWebPath);
		r.putMap("SCK_shutdownWebPath", $SingleConf.SCK_shutdownWebPath);

		r.putMap("startupServerPath", startupServerPath);
		r.putMap("shutdownServerPath", shutdownServerPath);
		r.putMap("startupWebPath", startupWebPath);
		r.putMap("shutdownWebPath", shutdownWebPath);
		
		//监控service是否已经启动
		SmtpSendSession s = new SmtpSendSession("127.0.0.1", 25);
		s.setTimeout(1000);
		try {
			s.open();
			s.helo("localhost");
			s.quit();
			r.putMap("isServiceStart", true);
		}catch (Exception e) {
			e.printStackTrace();
			r.putMap("isServiceStart", false);
		} finally {
			s.close();
		}
		
	}

	public void runScript() throws IOException, InterruptedException {
		String key = $("key");
		$SingleConf.runScript(key);
	}
	
	//同步系统时间
	public void synTime() throws IOException, InterruptedException {
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("/usr/sbin/ntpdate 210.72.145.44");
		proc.waitFor();
	}
	
	public void modScriptPath() throws AppException, Exception {
		Map<String, SingleConf> scMap = $SingleConf.getSingleConfsMap();
		List<SingleConf> scs = new ArrayList<SingleConf>();
		for (SingleConf sc : scMap.values()) {
			String val = $(sc.getKeyname());
			if (val == null)
				continue;
			SingleConf newSc = new SingleConf();
			newSc.setKeyname(sc.getKeyname());
			newSc.setValue(val);
			scs.add(newSc);
		}
		$SingleConf.modSingleConfs(scs);
		page().redirectTo("a/conf/service.html");
	}

	public void restoreScriptPath() throws AppException, Exception {
		$SingleConf.restoreScriptPath();
		page().redirectTo("a/conf/service.html");
	}

	public void restartServer() throws IOException, InterruptedException {
		$SingleConf.restartServer();
	}

	public void restartWeb() throws IOException, InterruptedException {
		$SingleConf.restartWeb();
	}
	
	@Layout("NOT")
	public void modfunc() throws AppException, Exception {
		r.putMap("modFuncs", $ModFunc.getModFuncsMap().values());
	}
	
	public void doModFunc() throws AppException, Exception {
		$ModFunc.chgModFunc($("funcid"), $i("status", 3));
	}
	
	@Layout("NOT")
	public void smtpCluster_add() throws AppException, Exception {
		if(is_get) {
			r.putMap("smtpTrustIps", $SmtpTrustIp.findAll());
		}
		else {
			SmtpTrustIp stip = $M(SmtpTrustIp.class);
			stip.create();
			((PageRenderer) renderer).redirectTo("a/conf/smtpCluster_add.html");
		}
	}
	
	public void smtpCluster_del() throws AppException, Exception {
		SmtpTrustIp stip = new SmtpTrustIp($("ip").trim());
		stip.delete();
		((PageRenderer) renderer).redirectTo("a/conf/smtpCluster_add.html");
	}
	
	//系统监控
	@Layout("NOT")
	public void monitoring() throws AppException, Exception {
		r.putMap("sys", new SysMonitor());
		r.putMap("jvm", Runtime.getRuntime());
		
		//jvm监控
		Runtime runtime = Runtime.getRuntime();
		r.putMap("freeMemory", runtime.freeMemory()+ "K");
		r.putMap("maxMemory", runtime.maxMemory()+ "K");
		r.putMap("totalMemory", runtime.totalMemory()+ "K");
		r.putMap("availableProcessors", runtime.availableProcessors());
		
	}

	//系统参数设置
	@Layout("NOT")
	public void confSerivce() throws AppException, Exception {
		//找到文件的全路径
		String path = ClassPath.getFullPathRelateClass("", Starter.class)+"/app1.props";
		if(is_get){
			Map<String, ConfSet> map = ConfUtil.readFile(path);
			if(map.get("smtp.maxMessageSize") != null) {
				ConfSet confset = map.get("smtp.maxMessageSize");
				confset.setValue(ByteTools.byteToM(Long.parseLong(confset.getValue())) + "");
			}
			r.putMap("confs", map.values());
		}else{
			Map<String, ConfSet> confMap = new TreeMap<String, ConfSet>();
			for(String key:ConfUtil.confs){
				ConfSet confSet =new ConfSet();
				String value = $(key);
				if(value != null && "smtp.maxMessageSize".equals(key)) {
					value = ByteTools.mToByte(value) + "";
				}
				confSet.setKeyname(key);
				confSet.setValue(value);
				confMap.put(key, confSet);
			}
			
			//修改文件
			ConfUtil.replaceByStr(path, confMap);
			
			((PageRenderer) renderer).redirectTo("a/conf/confSerivce.html");
		}
	}
	

}
