package com.skymiracle.wpx.models.domain;

import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import static com.skymiracle.wpx.Singletons.*;

public class DomainAlias extends WpxMdo<DomainAlias> {
	@Title("域别名")
	private String dc;

	@Title("域名")
	private String aliasedObjectName;

	public DomainAlias() {
		super($DomainAlias);
	}

	public DomainAlias(String dc) {
		this();
		setDc(dc);
	}

	@Override
	public String[] keyNames() {
		return new String[] { "dc" };
	}

	@Override
	public String table() {

		return "tb_domainAlias";
	}

	public String getAliasedObjectName() {
		return aliasedObjectName;
	}

	public void setAliasedObjectName(String aliasedObjectName) {
		this.aliasedObjectName = aliasedObjectName;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	@Override
	public DomainAlias create() throws AppException, Exception {
		new Domain(dc).throwExists();
		return super.create();
	}

	public static class X extends WpxMdo_X<DomainAlias> {

		public X() {
			super(DomainAlias.class);
		}
	}

}
