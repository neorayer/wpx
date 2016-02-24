package com.skymiracle.wpx.models.ipcontrol;

import java.util.*;

import static com.skymiracle.wpx.Singletons.*;
import com.skymiracle.logger.Logger;
import com.skymiracle.server.tcpServer.IpFilterListener;

public class RdbmsIpFilterListener extends IpFilterListener {

	public Event checkEvent() {
		ChangedEvent changeEvent = new ChangedEvent();
		try {
			int changeType = $IpFilterChange.getIpFilterChange();
			switch (changeType) {
			case ChangedEvent.CHANGE_TYPE_ALLOW:
				// get allowIpMap
				$IpFilterChange.initIpFilterChange();
				changeEvent.setType(ChangedEvent.CHANGE_TYPE_ALLOW);
				changeEvent.setAllowMap(getMap(ChangedEvent.CHANGE_TYPE_ALLOW));
				break;
			case ChangedEvent.CHANGE_TYPE_REJECT:
				// get rejectIpMap
				$IpFilterChange.initIpFilterChange();
				changeEvent.setType(ChangedEvent.CHANGE_TYPE_REJECT);
				changeEvent
						.setRejectMap(getMap(ChangedEvent.CHANGE_TYPE_REJECT));
				break;
			case ChangedEvent.CHANGE_TYPE_ALL:
				// getAllow&RejectMap
				$IpFilterChange.initIpFilterChange();
				changeEvent.setType(ChangedEvent.CHANGE_TYPE_ALL);
				changeEvent.setAllowMap(getMap(ChangedEvent.CHANGE_TYPE_ALLOW));
				changeEvent
						.setRejectMap(getMap(ChangedEvent.CHANGE_TYPE_REJECT));
				break;
			default:
				return null;
			}
		} catch (Exception e) {
			Logger.error("", e);
		}
		return changeEvent;
	}

	private Map<String, String> getMap(int changeType) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			List<IpFilterItem> list = null;
			if (changeType == ChangedEvent.CHANGE_TYPE_ALLOW)
				list = $IpFilterItem.getIpFilterItem(changeType);
			else if (changeType == ChangedEvent.CHANGE_TYPE_REJECT)
				list = $IpFilterItem.getIpFilterItem(changeType);

			for (IpFilterItem ipitem : list)
				map.put(ipitem.getIp(), ipitem.getIp());
			return map;
		} catch (Exception e) {
			Logger.error("", e);
			return null;
		}

	}

	public void initStart() {
		try {
			$IpFilterChange.addIpFilterChanged(ChangedEvent.CHANGE_TYPE_ALL);
		} catch (Exception e) {
			Logger.error("", e);
		}
	}

}
