package com.skymiracle.wpx.controllers.a;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.IpFilter;
import com.skymiracle.wpx.models.admin.SuperAdmin;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.ipcontrol.IpSegiment;
import com.skymiracle.wpx.models.log.SysLog;

import static com.skymiracle.wpx.Singletons.*;

@Sessioned
public class IpcontrolCtr extends Ctr {

	@Layout("NOT")
	public void main() {
	}

	/** ******** 管理端Ip白名单 **********/
	@Layout("NOT")
	public void adminWhiteIp() {}

	public void listAdminWhiteip() throws AppException, Exception {
		MdoMap mm = $MM(IpSegiment.class);
		mm.put("type", IpSegiment.IP_ALLOW);
		mm.put("useType", IpSegiment.UseType_admin);
		System.out.println($IpSegiment.find(mm, null));
		r.putColl($IpSegiment.find(mm, null));
	}

	public void addAdminWhite() throws AppException, Exception {
		IpSegiment is = $M(IpSegiment.class);
		if (!(IpFilter.ipBigSmall(is.getFromip(), is.getToip()))) {
			throw new AppException("IP地址起始错误");
		}
		is.setType(IpSegiment.IP_ALLOW);
		is.setUseType(IpSegiment.UseType_admin);
		r.setMdo(is.create());

		SysLog.width(actor).addIpCtr(is.getType(), is.getUseType(), is.getFromip(), is.getToip());
	}

	public void delAdminWhiteIP() throws AppException, Exception {
		String[] uuids = $$("uuid");
		for (String uuid : uuids) {
			IpSegiment is = new IpSegiment(uuid).load();
			is.delete();

			SysLog.width(actor).delIpCtr(is.getType(), is.getUseType(), is.getFromip(), is.getToip());
		}
	}

	/** ******** 管理端Ip黑名单 **********/
	@Layout("NOT")
	public void adminBlackIp() {
	}

	public void listAdminBlackIP() throws AppException, Exception {
		MdoMap mm = $MM(IpSegiment.class);
		mm.put("type", IpSegiment.IP_REJECT);
		mm.put("useType", IpSegiment.UseType_admin);
		r.putColl($IpSegiment.find(mm, null));
	}

	public void addAdminBlackIP() throws AppException, Exception {
		IpSegiment is = $M(IpSegiment.class);
		if (!(IpFilter.ipBigSmall(is.getFromip(), is.getToip()))) {
			throw new AppException("IP地址起始错误");
		}
		is.setType(IpSegiment.IP_REJECT);
		is.setUseType(IpSegiment.UseType_admin);
		r.setMdo(is.create());

		SysLog.width(actor).addIpCtr(is.getType(), is.getUseType(), is.getFromip(), is.getToip());
	}

	public void delAdminBlackIP() throws AppException, Exception {
		String[] uuids = $$("uuid");
		for (String uuid : uuids) {
			IpSegiment is = new IpSegiment(uuid).load();
			is.delete();
			
			SysLog.width(actor).delIpCtr(is.getType(), is.getUseType(), is.getFromip(), is.getToip());
		}
	}
	
	/** ******** 注册端Ip白名单 **********/
	@Layout("NOT")
	public void registerWhiteIP() throws AppException, Exception {
		r.putMap("domains", $Domain.findAll());
	}

	public void listregisterWhiteIP() throws AppException, Exception {
		MdoMap mm = $MM(IpSegiment.class);
		mm.put("type", IpSegiment.IP_ALLOW);
		mm.put("useType", IpSegiment.UseType_user);
		r.putColl($IpSegiment.find(mm, null));
	}

	public void addregisterWhiteIP() throws AppException, Exception {
		IpSegiment is = $M(IpSegiment.class);
		if (!(IpFilter.ipBigSmall(is.getFromip(), is.getToip()))) {
			throw new AppException("IP地址起始错误");
		}
		
		is.setType(IpSegiment.IP_ALLOW);
		is.setUseType(IpSegiment.UseType_user);
		r.setMdo(is.create());

		SysLog.width(actor).addIpCtr(is.getType(), is.getUseType(), is.getFromip(), is.getToip());
	}

	public void delregisterWhiteIP() throws AppException, Exception {
		String[] uuids = $$("uuid");
		for (String uuid : uuids) {
			IpSegiment is = new IpSegiment(uuid).load();
			is.delete();
			
			SysLog.width(actor).delIpCtr(is.getType(), is.getUseType(), is.getFromip(), is.getToip());
		}
	}

	/** ******** 注册端Ip黑名单 **********/
	@Layout("NOT")
	public void registerBlackIP() throws AppException, Exception {
		r.putMap("domains", $Domain.findAll());
	}

	public void listregisterBlackIP() throws AppException, Exception {
		MdoMap mm = $MM(IpSegiment.class);
		mm.put("type", IpSegiment.IP_REJECT);
		mm.put("useType", IpSegiment.UseType_user);
		r.putColl($IpSegiment.find(mm, null));
	}

	public void addregisterBlackIP() throws AppException, Exception {
		IpSegiment is = $M(IpSegiment.class);
		if (!(IpFilter.ipBigSmall(is.getFromip(), is.getToip()))) {
			throw new AppException("IP地址起始错误");
		}
		is.setType(IpSegiment.IP_REJECT);
		is.setUseType(IpSegiment.UseType_user);
		r.setMdo(is.create());

		SysLog.width(actor).addIpCtr(is.getType(), is.getUseType(), is.getFromip(), is.getToip());
	}

	public void delregisterBlackIP() throws AppException, Exception {
		String[] uuids = $$("uuid");
		for (String uuid : uuids) {
			IpSegiment is = new IpSegiment(uuid).load();
			is.delete();
			
			SysLog.width(actor).delIpCtr(is.getType(), is.getUseType(), is.getFromip(), is.getToip());
		}
	}
	
	/** ******** SMTP连接ip黑名单 **********/
	
	public void listSmtpRejectIP() throws AppException, Exception {
		SuperAdmin superAdmin = $M(SuperAdmin.class);
		System.out.println(superAdmin.listAc());
		r.putColl(superAdmin.listAc());
	}
	
	public void smtpRejectIP() throws AppException, Exception {
		SuperAdmin superAdmin = $M(SuperAdmin.class);
		System.out.println(superAdmin.listAc());
		r.putColl(superAdmin.listAc());
	}
	
	public void delSmtpRejectIP() throws AppException, Exception {
		SuperAdmin superAdmin = $M(SuperAdmin.class);
		String[] ips = $$("ip");
		for (String ip : ips) {
			System.out.println("ac_admin ip:"+ip);
		}
		superAdmin.delAc(ips);
	}
	
	



}
