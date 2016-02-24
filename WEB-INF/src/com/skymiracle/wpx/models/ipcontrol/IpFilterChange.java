package com.skymiracle.wpx.models.ipcontrol;

import static com.skymiracle.wpx.Singletons.$IpFilterChange;
import static com.skymiracle.wpx.Singletons.$IpFilterItem;

import java.util.List;

import com.skymiracle.server.tcpServer.IpFilterListener.ChangedEvent;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;

public class IpFilterChange extends WpxUuidMdo<IpFilterChange> {

	private int changeType;

	// private String filterItem;

	public IpFilterChange() {
		super($IpFilterChange);
	}

	public IpFilterChange(int changeType) {
		this();
		this.changeType = changeType;
	}

	public int getChangeType() {
		return changeType;
	}

	public void setChangeType(int changeType) {
		this.changeType = changeType;
	}

	@Override
	public String table() {
		return "tb_ipFilterChange";
	}
	


	public static class X extends WpxMdo_X<IpFilterChange> {
		public X() {
			super(IpFilterChange.class);
		}
		
		public int getIpFilterChange() throws AppException, Exception {
			int changeType = ChangedEvent.CHANGE_TYPE_NONE;

			List<IpFilterChange> list = findAll();
			if (list.size() == 0)
				return ChangedEvent.CHANGE_TYPE_NONE;
			else {
				boolean findAllow = false, findReject = false;
				for (IpFilterChange ipfc : list) {
					switch (ipfc.getChangeType()) {
					case ChangedEvent.CHANGE_TYPE_ALLOW:
						if (findReject)
							return ChangedEvent.CHANGE_TYPE_ALL;
						findAllow = true;
						break;
					case ChangedEvent.CHANGE_TYPE_REJECT:
						if (findAllow)
							return ChangedEvent.CHANGE_TYPE_ALL;
						findReject = true;
						break;
					case ChangedEvent.CHANGE_TYPE_ALL:
						return ChangedEvent.CHANGE_TYPE_ALL;
					}
				}
				if (findAllow && findReject)
					return ChangedEvent.CHANGE_TYPE_ALL;
				if (findAllow)
					return ChangedEvent.CHANGE_TYPE_ALLOW;
				if (findReject)
					return ChangedEvent.CHANGE_TYPE_REJECT;
			}

			return changeType;
		}

		public void initIpFilterChange() throws AppException, Exception {
			deleteAll();
		}
		
		public void addIpFilterChanged(int changeType) throws AppException, Exception {
			IpFilterChange ipfc = new IpFilterChange(changeType);
			ipfc.create();
		}


	}

}
