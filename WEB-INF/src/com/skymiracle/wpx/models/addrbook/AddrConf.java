package com.skymiracle.wpx.models.addrbook;

import static com.skymiracle.wpx.Singletons.$AddrConf;

import com.skymiracle.mdo4.KeyNotExistException;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;

// 这个类似乎没用 ？？？

public class AddrConf extends WpxMdo<AddrConf> {

	public AddrConf() {
		super($AddrConf);
	}

	public AddrConf(String id) {
		this();
		this.id = id;
	}

	public static final int LockedSource_NONE = 0;
	public static final int LockedSource_USER = 10;

	private String id;

	private int lockedSource = LockedSource_NONE;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLockedSource() {
		return lockedSource;
	}

	public void setLockedSource(int lockedSource) {
		this.lockedSource = lockedSource;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "id" };
	}

	@Override
	public String table() {
		return "tb_addressbook_AddrConf";
	}

	public static class X extends WpxMdo_X<AddrConf> {
		public X() {
			super(AddrConf.class);
		}

		public void setAddrConf(AddrConf addrConf) throws AppException,
				Exception {
			AddrConf originalAddrConf = new AddrConf(addrConf.getId());
			if (originalAddrConf.exists()) {
				originalAddrConf.load();
			} else {
				addrConf.create();
			}
			addrConf.setId(null);
			originalAddrConf.update(addrConf.toMdoMap());
		}

		public AddrConf getAddrConf(String id) throws AppException, Exception {
			AddrConf addrConf = new AddrConf(id);
			if (!addrConf.exists())
				addrConf.create();

			return addrConf;
		}
	}

}
