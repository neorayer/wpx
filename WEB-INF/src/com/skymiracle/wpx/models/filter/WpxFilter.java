package com.skymiracle.wpx.models.filter;

import static com.skymiracle.wpx.Singletons.$AddrPsn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.server.tcpServer.mailServer.Smtp.AddrFilter;
import com.skymiracle.wpx.models.addrbook.AddrPsn;

public class WpxFilter implements AddrFilter {
	private Map<String, String> map = new HashMap<String, String>();
	private MdoMap das = null;

	public Map<String, String> getFilterMap(String username, String domain)
			throws Exception {
		initMap(username, domain);
		return map;
	}

	private void initMap(String username, String domain) throws Exception {
		if (das == null)
			das = new MdoMap();
		else
			das.clear();
		das.put("owner", username + "@" + domain);

		List<AddrPsn> list = $AddrPsn.find(das, null);
		if (list.size() != 0)
			for (AddrPsn as : list)
				map.put(as.getMail(), "");
	}

}
