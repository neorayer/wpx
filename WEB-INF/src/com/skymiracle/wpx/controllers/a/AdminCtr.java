package com.skymiracle.wpx.controllers.a;

import static com.skymiracle.wpx.Singletons.$AddressbookAdmin;
import static com.skymiracle.wpx.Singletons.$Domain;
import static com.skymiracle.wpx.Singletons.$DomainAdmin;
import static com.skymiracle.wpx.Singletons.$MultiDomainAdmin;
import static com.skymiracle.wpx.Singletons.$SuperAdmin;

import com.skymiracle.mdo5.MList;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.Base64Sky;
import com.skymiracle.validate.ValidateException;
import com.skymiracle.wpx.models.admin.AddressbookAdmin;
import com.skymiracle.wpx.models.admin.DomainAdmin;
import com.skymiracle.wpx.models.admin.MultiDomainAdmin;
import com.skymiracle.wpx.models.admin.SuperAdmin;
import com.skymiracle.wpx.models.log.SysLog;

@Sessioned
public class AdminCtr extends Ctr {

	@Layout("NOT")
	public void main() {
	}

	// Super Admin
	/** ******** 超级管理员 **********/
	@Layout("NOT")
	public void superAdmins() throws AppException, Exception {

	}

	public void superAdmin_list() throws AppException, Exception {
		MList<SuperAdmin> admins = $SuperAdmin.findAll();
		for(SuperAdmin admin : admins){
			String password = admin.getUserPassword();
			if(password.indexOf("{skyenc}")!=-1){
				admin.setUserPassword(Base64Sky.decodePassword(password.substring(8)));
			}
		}
		r.putColl(admins);
	}

	public void superAdmin_add() throws AppException, Exception {
		SuperAdmin admin = $M(SuperAdmin.class).create();
		SysLog.width(actor).addSuperAdmin(admin.getUid());
		r.setMdo(admin);
	}

	public void superAdmins_del() throws AppException, Exception {
		MList<SuperAdmin> admins = $$M(SuperAdmin.class, "uid");
		for (SuperAdmin admin : admins) {
			admin.delete();
			SysLog.width(actor).delSuperAdmin(admin.getUid());
		}
	}

	public void superAdmin_mod() throws AppException, Exception {
		SuperAdmin admin = $M(SuperAdmin.class);
		admin.update($MM(SuperAdmin.class));
		admin.load();
		SysLog.width(actor).addSuperAdmin(admin.getUid());
		r.setMdo(admin);
	}

	// MultiDomain Admin
	/** ******** 多域管理员 **********/
	@Layout("NOT")
	public void multiDomainAdmins() {

	}

	public void listMultiDomainAdmin() throws AppException, Exception {
		MList<MultiDomainAdmin> admins = $MultiDomainAdmin.findAll();
		for(MultiDomainAdmin admin : admins){
			String password = admin.getUserPassword();
			if(password.indexOf("{skyenc}")!=-1){
				admin.setUserPassword(Base64Sky.decodePassword(password.substring(8)));
			}
		}
		r.putColl(admins);
	}

	public void addMultiDomainAdmin() throws AppException, Exception {
		MultiDomainAdmin admin = $M(MultiDomainAdmin.class).create();
		SysLog.width(actor).addMultiManager(admin.getUid());
		r.setMdo(admin);
	}

	public void modMultiDomainAdmin() throws AppException, Exception {
		MultiDomainAdmin admin = $M(MultiDomainAdmin.class);
		admin.update($MM(MultiDomainAdmin.class));
		admin.load();
		SysLog.width(actor).modMultiManager(admin.getUid());
		r.setMdo(admin);
	}

	public void delMultiDomainAdmin() throws AppException, Exception {
		MList<MultiDomainAdmin> admins = $$M(MultiDomainAdmin.class, "uid");
		for (MultiDomainAdmin admin : admins) {
			admin.delete();
			SysLog.width(actor).delMultiManager(admin.getUid());
		}
	}
	
	//addressbook Admin
	/** ******** 地址簿管理员 **********/
	@Layout("NOT")
	public void addressbookAdmins() throws AppException, Exception {
		
	}

	public void addressbookAdmin_list() throws AppException, Exception {
		MList<AddressbookAdmin> admins = $AddressbookAdmin.findAll();
		for(AddressbookAdmin admin : admins){
			String password = admin.getUserPassword();
			if(password.indexOf("{skyenc}")!=-1){
				admin.setUserPassword(Base64Sky.decodePassword(password.substring(8)));
			}
		}
		r.putColl(admins);
	}

	public void addressbookAdmin_add() throws AppException,
			Exception {
		AddressbookAdmin admin = $M(AddressbookAdmin.class).create();
		SysLog.width(actor).addAbManager(admin.getUid(), admin.getDc());
		r.setMdo(admin);
	}

	public void addressbookAdmin_mod() throws AppException,
			Exception {
		AddressbookAdmin admin = $M(AddressbookAdmin.class);
		admin.update($MM(AddressbookAdmin.class));
		admin.load();
		SysLog.width(actor).modAbManager(admin.getUid(), admin.getDc());
		r.setMdo(admin);
	}

	public void addressbookAdmins_del() throws AppException,
			Exception {
		MList<AddressbookAdmin> admins = $$M(AddressbookAdmin.class, "uid",
				"dc");
		for (AddressbookAdmin admin : admins) {
			admin.delete();
			SysLog.width(actor).delAbManager(admin.getUid(), admin.getDc());
		}
	}

	//domain Admin
	/** ******** 域管理员 **********/
	@Layout("NOT")
	public void domainAdmins() throws AppException, Exception {
		String dc = $("dc", null);
		MList<DomainAdmin> admins = $DomainAdmin.find("dc", dc);
		for(DomainAdmin admin : admins){
			String password = admin.getUserPassword();
			if(password.indexOf("{skyenc}")!=-1){
				admin.setUserPassword(Base64Sky.decodePassword(password.substring(8)));
			}
		}
		r.putColl(admins);
		
		r.putMap("domains", $Domain.findAll());
	}

	public void domainAdmin_add() throws AppException, Exception {
		DomainAdmin admin = $M(DomainAdmin.class).create();
		SysLog.width(actor).addDomainManager(admin.getUid(), admin.getDc());
		r.setMdo(admin);
	}

	public void domainAdmin_mod() throws ValidateException, Exception {
		DomainAdmin admin = $M(DomainAdmin.class);
		admin.update($MM(DomainAdmin.class));
		admin.load();
		SysLog.width(actor).modDomainManager(admin.getUid(), admin.getDc());
		r.setMdo(admin);
	}

	public void domainAdmins_del() throws ValidateException, Exception {
		MList<DomainAdmin> admins = $$M(DomainAdmin.class, "uid", "dc");
		for (DomainAdmin admin : admins) {
			admin.delete();
			SysLog.width(actor).delDomainManager(admin.getUid(), admin.getDc());
		}
	}
}
