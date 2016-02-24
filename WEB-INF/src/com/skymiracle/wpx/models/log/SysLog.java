package com.skymiracle.wpx.models.log;

import static com.skymiracle.wpx.Singletons.*;

import com.skymiracle.logger.Logger;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;
import com.skymiracle.wpx.models.admin.Admin;
import com.skymiracle.wpx.models.ipcontrol.IpSegiment;
import com.skymiracle.wpx.models.user.User;

public class SysLog extends WpxUuidMdo<SysLog> {
	public SysLog() {
		super($SysLog);
	}

	@Title("账号")
	private String account;

	@Title("明细")
	private String opdetail;

	public static enum OpType {
		login, add, delete, modify, logout
	}

	@Title("操作类型")
	private OpType optype;

	@Title("角色")
	private String role;

	private String time;

	private String domain;

	private String ip;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOpdetail() {
		return opdetail;
	}

	public void setOpdetail(String opdetail) {
		this.opdetail = opdetail;
	}

	public OpType getOptype() {
		return optype;
	}

	public void setOptype(OpType optype) {
		this.optype = optype;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "uuid" };
	}

	@Override
	public String table() {
		return "tb_manager_log";
	}

	public SysLog create() {
		try {
			return super.create();
		} catch (Exception e) {
			Logger.warn(opdetail, e);
			return null;
		}
	}

	public void op4Add() {
		this.optype = OpType.add;
		this.create();
	}

	public void op4Del() {
		this.optype = OpType.delete;
		this.create();
	}

	public void op4Mod() {
		this.optype = OpType.modify;
		this.create();
	}

	public void op4Login() {
		this.optype = OpType.login;
		this.create();
	}

	public void op4Logout() {
		this.optype = OpType.logout;
		this.create();
	}

	public static SysLog width(Admin<? extends Admin<?>> admin) {
		SysLog sysLog = new SysLog();
		sysLog.setAccount(admin.getUid());
		sysLog.setDomain(admin.getDc());
		sysLog.setRole(admin.getRoleID());
		sysLog.setTime(CalendarUtil.getLocalDateTime("yyyy-MM-dd HH:mm:ss"));
		sysLog.setIp(admin.ip);

		return sysLog;
	}

	public void addAbManager(String uid, String dc) {
		this.opdetail = "增加域" + dc + "的地址本管理员" + uid + "的操作";
		op4Add();
	}

	public void addAddr(String mail, String domain) {
		this.opdetail = "对域" + domain + "的地址本增加邮箱地址" + mail + "的操作";
		op4Add();
	}

	public void addAliasUser(String account, String domain, String alias) {
		this.opdetail = "对用户" + account + "@" + domain + "的增加别名" + alias + "操作";
		op4Add();
	}

	public void addAliasDomain(String domain, String alias) {
		this.opdetail = "对域" + domain + " 增加别名" + alias + "操作";
		op4Add();
	}

	public void addDepartment(String domain, String department) {
		this.opdetail = "对域" + domain + "的增加部门" + department + "操作";
		op4Add();
	}

	public void addDomain(String domain) {
		this.opdetail = "进行添加域" + domain + "的操作";
		op4Add();
	}

	public void addSuperAdmin(String account) {
		this.opdetail = "进行添加超级管理员" + account + "的操作";
		op4Add();
	}

	public void addDomainManager(String uid, String dc) {
		this.opdetail = "增加域" + dc + "的域管理员" + uid + "的操作";
		op4Add();
	}

	public void addGroup(String name, String domain) {
		this.opdetail = "对域" + domain + "的地址本增加组" + name + "操作";
		op4Add();
	}

	public void addMultiDomain(String dc) {
		this.opdetail = "多域管理员" + account + "进行添加域" + dc + "的操作";
		op4Add();
	}

	public void addMultiManager(String uid) {
		this.opdetail = "增加多域管理员" + uid + "的操作";
		op4Add();
	}

	public void addSuperManager(String account) {
		this.opdetail = "增加超级管理员" + account + "的操作";
		op4Add();
	}

	public void addToAddrUser(String account, String domain) {
		this.opdetail = "对用户" + account + "@" + domain + "的加入地址本操作";
		op4Add();
	}

	public void addUser(String uid, String dc) {
		this.opdetail = "增加用户" + uid + "@" + dc + "的操作";
		op4Add();
	}

	public void closeFunctionUser(String account, String domain, String function) {
		this.opdetail = "关闭用户" + account + "@" + domain + "的" + function
				+ "功能的操作";
		op4Mod();
	}

	public void closeUser(String account, String domain) {
		this.opdetail = "关闭用户" + account + "@" + domain + "的操作";
		op4Mod();
	}

	public void delAbManager(String account, String domain) {
		this.opdetail = "删除域" + domain + "的地址本管理员" + account + "的操作";
		op4Del();
	}

	public void delSuperAdmin(String uid) {
		this.opdetail = "删除超级管理员" + uid + "的操作";
		op4Del();
	}

	public void delInforAdmin(String[] accounts) {
		for (String account : accounts) {
			this.opdetail = "删除预览管理员" + account + "的操作";
			op4Del();
		}
	}

	public void delEbillAdmin(String[] accounts) {
		for (String account : accounts) {
			this.opdetail = "删除账单管理员" + account + "的操作";
			op4Del();
		}
	}

	public void delAliasUser(String account, String domain, String[] aliases) {
		for (String alias : aliases) {
			this.opdetail = "对用户" + account + "@" + domain + "的删除别名" + alias
					+ "操作";
			op4Del();
		}
	}

	public void delAliasDomain(String domain, String alias) {
		this.opdetail = "对域" + domain + "的删除别名" + alias + "操作";
		op4Del();
	}

	public void delDepartment(String domain, String department) {
		this.opdetail = "对域" + domain + "的删除部门" + department + "操作";
		op4Del();
	}

	public void delDomainManager(String uid, String dc) {
		this.opdetail = "删除域" + dc + "的域管理员" + uid + "的操作";
		op4Del();

	}

	public void deleteDomain(String domain) {
		this.opdetail = "进行删除域" + domain + "的操作";
		op4Del();
	}

	// public void delGroup(String uuid, String domain) {
	// try {
	// SysLog sysLog = new SysLog();
	// sysLog.setOptype(SysLog.OP_DEL);
	// Group group = new GroupImpl(uuid);
	// group.persistentLoad();
	// String detail;
	// if (group.getDescription() != null)
	// detail = "对域" + domain + "的组" + group.getDescription()
	// + "(uuid:" + uuid + ")的删除操作";
	// else
	// detail = "对域" + domain + "的组(uuid:" + uuid + ")的删除操作";
	// sysLog.setOpdetail(detail);
	// this.addDao(sysLog);
	// } catch (Exception e) {
	// logger.error("delGroup", e);
	// }
	// }

	public void delMultiManager(String uid) {
		this.opdetail = "删除多域管理员" + uid + "的操作";
		op4Del();
	}

	public void delMultiDomain(String account, String dc) {
		this.opdetail = "多域管理员" + account + "进行删除域" + dc + "的操作";
		op4Del();
	}

	// public void delSuperManager(String account) {
	// try {
	// SysLog sysLog = new SysLog();
	// sysLog.setDomain(domain);
	// sysLog.setOptype(SysLog.OP_DEL);
	// String detail = "删除超级管理员" + account + "的操作";
	// sysLog.setOpdetail(detail);
	// this.addDao(sysLog);
	// } catch (Exception e) {
	// logger.error("delSuperManager", e);
	// }
	// }

	public void delUser(String uid, String dc) {
		this.opdetail = "删除用户" + uid + "@" + dc + "的操作";
		op4Del();
	}

	public void login() {
		this.opdetail = "登录";
		op4Login();
	}

	public void login(String account) {
		this.opdetail = "管理员" + account + "登陆";
		;
		op4Login();
	}

	public void logout(String account) {
		this.opdetail = "管理员" + account + "退出";
		op4Logout();
	}

	public void modAbManager(String account, String domain) {
		this.opdetail = "修改域" + domain + "的地址本管理员" + account + "的操作";
		op4Mod();
	}

	// public void modAddr(String uuid, String domain) {
	// try {
	// SysLog sysLog = new SysLog();
	// sysLog.setOptype(OpType.modify);
	// Person person = new PersonImpl(uuid);
	// person.persistentLoad();
	// String detail;
	// if (person.getDisplayName() != null)
	// detail = "对域" + domain + "的地址本" + person.getDisplayName()
	// + "(uuid:" + uuid + ")的修改操作";
	// else
	// detail = "对域" + domain + "的地址本(uuid:" + uuid + ")的修改操作";
	// sysLog.setOpdetail(detail);
	// this.addDao(sysLog);
	// } catch (Exception e) {
	// logger.error("modAddr", e);
	// }
	// }

	public void modBirthday() {
		this.opdetail = "修改生日邮件";
		op4Mod();
	}

	public void modConfig() {
		this.opdetail = "修改了配置文件";
		op4Mod();
	}

	public void modDepartment(String domain, String department) {
		this.opdetail = "对域" + domain + "的修改部门" + department + "操作";
		op4Mod();
	}

	public void modDomain(String domain) {
		this.opdetail = "进行修改域" + domain + "的操作";
		op4Mod();
	}

	public void modDomainManager(String uid, String dc) {
		this.opdetail = "修改域" + dc + "的域管理员" + uid + "的操作";
		op4Mod();
	}

	public void modSuperAdmin(String account) {
		this.opdetail = "修改超级管理员" + account + "的操作";
		op4Mod();
	}

	// public void modGroup(String uuid, String domain) {
	// try {
	// SysLog sysLog = new SysLog();
	// sysLog.setOptype(OpType.modify);
	// Group group = new GroupImpl(uuid);
	// group.persistentLoad();
	// String detail;
	// if (group.getDescription() != null)
	// detail = "对域" + domain + "的组" + group.getDescription()
	// + "(uuid:" + uuid + ")的修改操作";
	// else
	// detail = "对域" + domain + "的组(uuid:" + uuid + ")的修改操作";
	// sysLog.setOpdetail(detail);
	// this.addDao(sysLog);
	// } catch (Exception e) {
	// logger.error("modGroup", e);
	// }
	// }

	public void modIp() {
		this.opdetail = "修改ip访问控制";
		op4Mod();
	}

	public void modMultiManager(String account) {
		this.opdetail = "修改多域管理员" + account + "的操作";
		op4Mod();
	}

	public void modSuperManager(String account) {
		this.opdetail = "修改超级管理员" + account + "的操作";
		op4Mod();
	}

	public void modUser(String uid, String dc) {
		this.opdetail = "修改用户" + uid + "@" + dc + "的操作";
		op4Mod();
	}

	public void modUserMoveDept(String uid, String dc) {
		this.opdetail = "修改用户" + uid + "@" + dc + "移动部门的操作";
		op4Mod();
	}

	public void modUserAddrBookStatus(String uid, String dc, String ishide) {
		this.opdetail = "修改用户" + uid + "@" + dc + "的"
				+ (User.HIDE.equals(ishide) ? "隐藏地址薄" : "显示地址薄") + "的操作";
		op4Mod();
	}

	public void modUserStatus(String uid, String dc, String status) {
		this.opdetail = "修改用户" + uid + "@" + dc + "的" + status + "状态的操作";
		op4Mod();
	}

	public void addNotice() {
		this.opdetail = "发布公告";
		op4Add();

	}

	public void addBatch() {
		this.opdetail = "群发邮件";
		op4Add();
	}

	public void modNotice() {
		this.opdetail = "修改公告";
		op4Mod();

	}

	public void delNotice() {
		this.opdetail = "删除公告";
		op4Del();
	}

	public void delBatch() {
		this.opdetail = "删除群发";
		op4Del();
	}

	public void openFunctionUser(String account, String domain, String function) {
		this.opdetail = "开启用户" + account + "@" + domain + "的" + function
				+ "功能的操作";
		op4Mod();
	}

	public void openUser(String account, String domain) {
		this.opdetail = "开启用户" + account + "@" + domain + "的操作";
		op4Mod();
	}

	public void pauseUser(String account, String domain) {
		this.opdetail = "暂停用户" + account + "@" + domain + "的操作";
		op4Mod();
	}

	public void transferDomain(String domain) {
		this.opdetail = "进行域" + domain + "的导入地址本操作";
		op4Mod();
	}

	public void transferTodbDomain(String domain) {
		this.opdetail = "进行域" + domain + "的导入数据库操作";
		op4Mod();
	}

	public void uploadLdif() {
		this.opdetail = "上传了ldif文件";
		op4Add();
	}

	public void addAllowIp(String ip) {
		this.opdetail = "添加允许IP地址：" + ip;
		op4Add();
	}

	public void addRejectIp(String ip) {
		this.opdetail = "添加拒绝IP地址：" + ip;
		op4Add();
	}

	public void addwpxadminBlackIP(String formip, String toip) {
		this.opdetail = "添加黑IP地址：从" + formip + "到" + toip;
		op4Add();
	}

	public void addwpxadminWhiteIP(String formip, String toip) {
		this.opdetail = "添加白IP地址：从" + formip + "到" + toip;
		op4Add();
	}

	public void addregisterBlackIP(String formip, String toip) {
		this.opdetail = "添加注册黑IP地址：从" + formip + "到" + toip;
		op4Add();
	}

	public void addregisterWhiteIP(String formip, String toip) {
		this.opdetail = "添加注册白IP地址：从" + formip + "到" + toip;
		op4Add();
	}

	public void delAllowIp(String[] ips) {
		for (String ip : ips) {
			this.opdetail = "删除允许IP地址：" + ip;
			op4Del();
		}

	}

	public void delRejectIp(String[] ips) {
		for (String ip : ips) {
			this.opdetail = "删除拒绝IP地址：" + ip;
			op4Del();
		}
	}

	public void delwpxadminBlackIP(String[] uuids) {
		for (String uuid : uuids) {
			this.opdetail = "删除黑IP地址：" + uuid;
			op4Del();
		}
	}

	public void delwpxadminWhiteIP(String[] uuids) {
		for (String uuid : uuids) {
			this.opdetail = "删除白IP地址：" + uuid;
			op4Del();
		}
	}

	public void delregisterBlackIP(String[] uuids) {
		for (String uuid : uuids) {
			this.opdetail = "删除注册黑IP地址：" + uuid;
			op4Del();
		}
	}

	public void delregisterWhiteIP(String[] uuids) {
		for (String uuid : uuids) {
			this.opdetail = "删除注册白IP地址：" + uuid;
			op4Del();
		}
	}

	public static class X extends WpxMdo_X<SysLog> {

		public X() {
			super(SysLog.class);
		}
	}

	public void addIpCtr(int type, String userType, String fromIp, String toIp) {
		this.opdetail = "添加";
		if(userType.equals(IpSegiment.UseType_user))
			this.opdetail+="注册端的";
		if(userType.equals(IpSegiment.UseType_admin))
			this.opdetail+="管理端的";
		
		if(type == IpSegiment.IP_ALLOW)
			this.opdetail+="白IP";
		if(type == IpSegiment.IP_REJECT)
			this.opdetail+="黑IP";
		
		opdetail += " 地址：从" + fromIp + " 至 " + toIp;

		op4Add();
	}

	public void delIpCtr(int type, String userType, String fromIp, String toIp) {
		this.opdetail = "删除";
		
		if(userType.equals(IpSegiment.UseType_user))
			this.opdetail+="注册端的";
		if(userType.equals(IpSegiment.UseType_admin))
			this.opdetail+="管理端的";
		
		if(type == IpSegiment.IP_ALLOW)
			this.opdetail+="白IP";
		if(type == IpSegiment.IP_REJECT)
			this.opdetail+="黑IP";
		
		opdetail += " 地址：从" + fromIp + " 至 " + toIp;
		
		op4Del();
	}

}
