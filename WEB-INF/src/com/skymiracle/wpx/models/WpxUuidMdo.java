package com.skymiracle.wpx.models;

import com.skymiracle.mdo5.Mdo_X;
import com.skymiracle.util.UUID;

public abstract class WpxUuidMdo<T extends WpxUuidMdo<T>> extends WpxMdo<T>{

	public WpxUuidMdo(Mdo_X<T> mdoX) {
		super(mdoX);
	}

	protected String uuid = new UUID().toShortString();

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public String[] keyNames() {
		return new String[]{"uuid"};
	}
	
}
