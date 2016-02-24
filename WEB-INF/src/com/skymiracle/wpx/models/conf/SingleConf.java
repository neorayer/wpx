package com.skymiracle.wpx.models.conf;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.skymiracle.logger.Logger;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import static com.skymiracle.wpx.Singletons.*;

public class SingleConf extends WpxMdo<SingleConf> {

	public SingleConf() {
		super($SingleConf);
	}

	public SingleConf(String keyname) {
		this();
		this.keyname = keyname;
	}

	private String keyname;

	private String value;

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int intValue() {
		return Integer.parseInt(value);
	}

	public boolean boolValue() {
		return Boolean.parseBoolean(value);
	}

	@Override
	public String[] keyNames() {
		return new String[] { "keyname" };
	}

	@Override
	public String table() {
		return "tb_singleconf";
	}

	public static class X extends WpxMdo_X<SingleConf> {
		public final String SCK_startupServerPath = "startupServerPath";
		public final String SCK_shutdownServerPath = "shutdownServerPath";
		public final String SCK_startupWebPath = "startupWebPath";
		public final String SCK_shutdownWebPath = "shutdownWebPath";

		public String[] singleConfKeys = new String[] { SCK_startupServerPath,
				SCK_shutdownServerPath, SCK_startupWebPath, SCK_shutdownWebPath };

		public X() {
			super(SingleConf.class);
		}

		public Map<String, SingleConf> getSingleConfsMap() {
			Map<String, SingleConf> singleConfsMap = new HashMap<String, SingleConf>();
			try {
				List<SingleConf> scs = findAll();
				for (SingleConf sc : scs) {
					singleConfsMap.put(sc.getKeyname(), sc);
				}

				for (String sck : singleConfKeys) {
					SingleConf sc = singleConfsMap.get(sck);
					if (sc == null) {
						sc = new SingleConf();
						sc.setKeyname(sck);
						sc.setValue("");
						sc.create();
						scs.add(sc);
						singleConfsMap.put(sc.getKeyname(), sc);
					}
				}

			} catch (Exception e) {
				Logger.error("", e);
			}
			return singleConfsMap;
		}

		public String getSingleConfValue(String key) {
			Map<String, SingleConf> singleConfsMap = getSingleConfsMap();
			SingleConf sc = singleConfsMap.get(key);
			return sc == null ? "" : sc.getValue();
		}

		public void modSingleConfs(List<SingleConf> singleConfs)
				throws AppException, Exception {
			for (SingleConf sc : singleConfs) {
				sc.update("value", sc.getValue());
			}
		}

		public void restoreScriptPath() throws AppException, Exception {
			List<SingleConf> scs = new LinkedList<SingleConf>();
			{
				SingleConf sc = new SingleConf();
				sc.setKeyname(SCK_startupServerPath);
				sc.setValue("/wpx/bin/startupServer.sh");
				scs.add(sc);
			}
			{
				SingleConf sc = new SingleConf();
				sc.setKeyname(SCK_shutdownServerPath);
				sc.setValue("/wpx/bin/shutdownServer.sh");
				scs.add(sc);
			}
			{
				SingleConf sc = new SingleConf();
				sc.setKeyname(SCK_startupWebPath);
				sc.setValue("/wpx/bin/startupTomcat.sh");
				scs.add(sc);
			}
			{
				SingleConf sc = new SingleConf();
				sc.setKeyname(SCK_shutdownWebPath);
				sc.setValue("/wpx/bin/shutdownTomcat.sh");
				scs.add(sc);
			}
			modSingleConfs(scs);
		}

		public void runScript(String key) throws IOException,
				InterruptedException {
			String script = getSingleConfValue(key);
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(script);
			proc.waitFor();
		}

		public void restartServer() throws IOException, InterruptedException {
			runScript(SCK_shutdownServerPath);
			runScript(SCK_startupServerPath);
		}

		public void restartWeb() throws IOException, InterruptedException {
			runScript(SCK_shutdownWebPath);
			runScript(SCK_startupWebPath);
		}
	}

}
