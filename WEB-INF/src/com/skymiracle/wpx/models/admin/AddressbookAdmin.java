package com.skymiracle.wpx.models.admin;

import static com.skymiracle.wpx.Singletons.$AddressbookAdmin;

import java.util.List;

import com.skymiracle.mdo5.MList;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.domain.Domain;

public class AddressbookAdmin extends Admin<AddressbookAdmin> {

	private String dc;

	private String ou;

	private String deptname;

	public AddressbookAdmin() {
		super($AddressbookAdmin);
	}

	public AddressbookAdmin(String uid, String dc) {
		this();
		this.uid = uid;
		this.dc = dc;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	@Override
	public String table() {
		return "tb_addrAdmin";
	}

	public String[] keyNames() {
		return new String[] { "uid", "dc" };
	}

	public static class X extends Admin.X<AddressbookAdmin> {
		public X() {
			super(AddressbookAdmin.class);
		}

	}

	@Override
	public String getRoleID() {
		return Admin.TYPE_ADDRESSBOOK;
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
