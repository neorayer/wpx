package com.skymiracle.wpx.models;

import com.skymiracle.mdo5.Mdo;
import com.skymiracle.mdo5.Mdo_X;

public abstract class WpxMdo<T extends WpxMdo<T>> extends Mdo<T>{

	public WpxMdo(Mdo_X<T> mdoX) {
		super(mdoX);
	}
}
