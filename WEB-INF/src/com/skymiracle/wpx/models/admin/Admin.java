package com.skymiracle.wpx.models.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.Base64Sky;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.mail.BatchGroup;
import com.skymiracle.wpx.models.mail.TimerMail;

public abstract class Admin<T extends Admin<T>> extends WpxMdo<T> {

	public final static String TYPE_ADDRESSBOOK = "addressbook";

	public final static String TYPE_DOMAIN = "domain";

	public final static String TYPE_SUPER = "super";

	public final static String TYPE_MULTIDOMAIN = "multidomain";
	
	public final static String SEP_UNIQUE_ID = ":";

	public final static Map<String, String> roles = new HashMap<String, String>();

	static {
		roles.put(TYPE_SUPER, "超级管理员");
		roles.put(TYPE_MULTIDOMAIN, "多域管理员");
		roles.put(TYPE_DOMAIN, "域管理员");
		roles.put(TYPE_ADDRESSBOOK, "公共地址簿管理员");
	}

	public final static String STATUS_OPEN = "open";

	public final static String STATUS_PAUSE = "pause";

	@Title("用户名")
	protected String uid;

	private String userPassword;

	private String status;

	public String ip;

	public Admin(Admin.X<T> mdoX) {
		super(mdoX);
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "uid" };
	}

	public T create() throws AppException, Exception {
		if(this.exists()){
			throw new AppException("管理员 "+ this.uid +" 已经存在，不可重复添加");
		}
		
		//密码加密
		this.userPassword = Base64Sky.encodeToPassword(this.userPassword,"UTF-8");
		return super.create();
	}
	
	public abstract String getDc();

	public abstract String getRoleID();
	
	public abstract String getUniqueId() throws AppException, Exception;

	public boolean getIsAddressBookRole() {
//		return "AddressbookAdmin".equals(this.getClass().getSimpleName());
		return this.getRoleID().equals(TYPE_ADDRESSBOOK);
	}
	

	public abstract static class X<T extends Admin<T>> extends WpxMdo_X<T> {
		public X(Class<T> mdoClass) {
			super(mdoClass);
		}
	}

	public Domain addDomain(final Domain domain) throws AppException, Exception {
		throw new AppException("Not Impl !");
	}

	public void delDomain(Domain domain) throws AppException, Exception {
		throw new AppException("Not Impl !");
	}

	public List<Domain> listDomains(String sortby, boolean isasc, int pagenum,
			int perpagecount) throws AppException, Exception {
		throw new AppException("Not Impl !");
	}

	public List<Domain> listDomains() throws AppException, Exception {
		throw new AppException("Not Impl !");
	}

	public List<TimerMail> listTimerMail(MdoMap mm) throws AppException, Exception {
		throw new AppException("Not Impl !");
	}
}