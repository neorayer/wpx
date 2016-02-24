package com.skymiracle.wpx.models.ipcontrol;

import static com.skymiracle.wpx.Singletons.$IpSegiment;

import java.util.List;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.Mdo.Title;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.IpFilter;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;

@Title("IP网段")
public class IpSegiment extends WpxUuidMdo<IpSegiment> {

	@Title("起始IP地址")
	private String fromip;

	@Title("结束IP地址")
	private String toip;

	@Title("域")
	private String dc;

	@Title("黑白名单类型")
	private int type;
	@Title("白名单")
	public static int IP_ALLOW = 0;
	@Title("黑名单")
	public static int IP_REJECT = 10;
	
	@Title("用户使用类型")
	private String useType;
	@Title("邮件用户")
	public static String UseType_user = "user";
	@Title("管理员")
	public static String UseType_admin = "admin";
	
	public IpSegiment() {
		super($IpSegiment);
	}

	public IpSegiment(String uuid) {
		this();
		this.setUuid(uuid);
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getFromip() {
		return fromip;
	}

	public void setFromip(String fromip) {
		this.fromip = fromip;
	}

	public String getToip() {
		return toip;
	}

	public void setToip(String toip) {
		this.toip = toip;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String table() {
		return "tb_ipsegment";
	}

	@Override
	public String[] keyNames() {
		return new String[] { "uuid" };
	}

	public static class X extends WpxMdo_X<IpSegiment> {
		public X() {
			super(IpSegiment.class);
		}
		
		public boolean checkIpAccess(String remoteIp, String dc, String useType) throws AppException, Exception {
			if (remoteIp.equalsIgnoreCase("127.0.0.1"))
				return true;

			MdoMap mdoMap = new MdoMap();
			mdoMap.put("useType", useType);
			mdoMap.put("type", IpSegiment.IP_ALLOW);
			if(dc!=null && !dc.equals(""))
				mdoMap.put("dc", dc);
			
			List<IpSegiment> whileIPs = $IpSegiment.find(mdoMap, null);
			for (IpSegiment ipSegiment : whileIPs) {
				if (IpFilter.ipFilter(remoteIp, ipSegiment.getFromip(), ipSegiment
						.getToip()))
					return true;
			}

			mdoMap.put("type", IpSegiment.IP_REJECT);
			List<IpSegiment> blackIPs = $IpSegiment.find(mdoMap, null);
			for (IpSegiment ipSegiment : blackIPs) {
				if (IpFilter.ipFilter(remoteIp, ipSegiment.getFromip(), ipSegiment
						.getToip()))
					return false;
			}

			return true;
		}
	}

	
}
