package com.skymiracle.wpx.models.ipcontrol;

import static com.skymiracle.wpx.Singletons.$IpFilterItem;

import java.util.List;

import com.skymiracle.server.tcpServer.IpFilterListener.ChangedEvent;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;

public class IpFilterItem extends WpxMdo<IpFilterItem> {

	private static int changeType;

	private String ip;

	public IpFilterItem() {
		super($IpFilterItem);
	}

	public IpFilterItem(String ip, boolean isAllow) {
		this();
		this.ip = ip;
		changeType = checkChangeType(isAllow);
	}

	public static int checkChangeType(boolean isAllow) {
		if (isAllow)
			return ChangedEvent.CHANGE_TYPE_ALLOW;
		else
			return ChangedEvent.CHANGE_TYPE_REJECT;
	}

	public int getChangeType() {
		return changeType;
	}

	public void setChangeType(int changeType) {
		IpFilterItem.changeType = changeType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "ip" };
	}

	@Override
	public String table() {
		return "tb_ipFilterItem";
	}

	public static class X extends WpxMdo_X<IpFilterItem> {
		public X() {
			super(IpFilterItem.class);
		}
		
		public List<IpFilterItem> getIpFilterItem(int changeType) throws AppException, Exception {
			return find("changeType", changeType);
		}
	}

}
