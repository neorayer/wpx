package com.skymiracle.wpx.models.admin;

import static com.skymiracle.wpx.Singletons.*;

import java.util.List;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.mdo5.Mdo.Title;
import com.skymiracle.server.tcpServer.antiCracker.ACClient;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.Base64Sky;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.log.SysLog;
import com.skymiracle.wpx.models.mail.BatchGroup;
import com.skymiracle.wpx.models.mail.TimerMail;

@Title("超级管理员")
public class SuperAdmin extends Admin<SuperAdmin> {
	
	ACClient acClient = new ACClient();

	public SuperAdmin() {
		super($SuperAdmin);
	}

	public SuperAdmin(String uid) {
		this();
		this.uid = uid;
	}

	@Override
	public String table() {
		return "tb_superAdmin";
	}

	public static class X extends Admin.X<SuperAdmin> {
		public X() {
			super(SuperAdmin.class);
		}
	}
	@Override
	public String getDc() {
		// nothing todo
		return null;
	}

	@Override
	public String getRoleID() {
		return Admin.TYPE_SUPER;
	}

	public Domain addDomain(Domain domain) throws AppException, Exception {
		domain.create();

		// LOG
		SysLog.width(this).addDomain(domain.getDc());

		return domain;
	}

	public void delDomain(Domain domain) throws AppException, Exception {
		domain.load();
		domain.delete();

		// LOG
		SysLog.width(this).deleteDomain(domain.getDc());
	}
	
	public List<Domain> listDomains(String sortby, boolean isasc, int pagenum, int perpagecount) throws AppException, Exception{
		return $Domain.findPaged(new MdoMap(), null, sortby, isasc, pagenum, perpagecount);
	}
	
	public List<Domain> listDomains() throws AppException, Exception {
		return $Domain.findAll();
	}

	@Override
	public String getUniqueId() throws AppException, Exception {
		return getRoleID() + Admin.SEP_UNIQUE_ID + uid;
	}

	public List<TimerMail> listTimerMail(MdoMap mm) throws AppException, Exception {
		return $TimerMail.find(mm, "time", false);
	}
	
	public List<String> listAc() throws AppException, Exception{
		List<String> ips = acClient.getBannedIPs();
		return ips;
	}
	
	public void delAc(String[] ips) throws AppException, Exception {
		acClient.deleteIPs(ips);
	}
	
}
