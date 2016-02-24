package com.skymiracle.wpx.models.admin;

import static com.skymiracle.wpx.Singletons.$DomainAdmin;

import java.util.List;

import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.Mdo.Title;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.domain.Domain;

@Title("域管理员")
public class DomainAdmin extends Admin<DomainAdmin> {

	private String dc;

	public DomainAdmin() {
		super($DomainAdmin);
	}

	public DomainAdmin(String uid) {
		this();
		this.uid = uid;
	}

	public DomainAdmin(String uid, String dc) {
		this(uid);
		this.dc = dc;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	@Override
	public String table() {
		return "tb_domainAdmin";
	}

	@Override
	public String[] keyNames() {
		return new String[] { "uid", "dc" };
	}

	public static class X extends Admin.X<DomainAdmin> {
		public X() {
			super(DomainAdmin.class);
		}

	}

	@Override
	public String getRoleID() {
		return Admin.TYPE_DOMAIN;
	}
	
	public List<Domain> listDomains() throws AppException, Exception {
		List<Domain> list = new MList<Domain>();
		Domain domain = new Domain(dc).load();
		list.add(domain);
		return list;
	}

	@Override
	public String getUniqueId() throws AppException, Exception {
		return getRoleID() + Admin.SEP_UNIQUE_ID + uid + "@" + dc;
	}


}
