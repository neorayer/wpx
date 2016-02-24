package com.skymiracle.wpx.models;

import static com.skymiracle.wpx.Singletons.*;

import com.skymiracle.mdo5.Mdo_X;

public abstract class WpxMdo_X<T extends WpxMdo<T>> extends Mdo_X<T>{

	public WpxMdo_X(Class<T> mdoClass) {
		super(mdoClass, appStore);
	}
	
}
