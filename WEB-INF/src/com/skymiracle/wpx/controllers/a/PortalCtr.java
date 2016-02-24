package com.skymiracle.wpx.controllers.a;

import static com.skymiracle.wpx.Singletons.*;

import com.skymiracle.sor.ActResult;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.admin.*;
import com.skymiracle.wpx.models.ipcontrol.IpSegiment;


public class PortalCtr extends Ctr {

	@Layout("NOT")
	public void login() throws AppException, Exception {
		if (is_get) {
			r.putMap("domains", $Domain.findAll());
		} else {
			String role = $("admintype");
			String ip = request.getRemoteAddr();
			if (!$IpSegiment.checkIpAccess(ip, null, IpSegiment.UseType_admin)) {
				throw new AppException("登录失败，您的IP被列入了黑名单!");
			}

			String username = $("username");
			String dc = $("dc");

			Admin<?> admin = null;
			if (Admin.TYPE_SUPER.equals(role)) {
				admin = new SuperAdmin(username);
			} else if (Admin.TYPE_DOMAIN.equals(role)) {
				admin = new DomainAdmin(username, dc);
			} else if (Admin.TYPE_MULTIDOMAIN.equals(role)) {
				admin = new MultiDomainAdmin(username);
			} else if (Admin.TYPE_ADDRESSBOOK.equals(role))
				admin = new AddressbookAdmin(username, dc);
			else
				throw new AppException("登录失败, 系统不支持当前角色! role = " + role);

			admin.load();

			if (Admin.STATUS_PAUSE.equals(admin.getStatus()))
				throw new AppException("登录失败，改用户的状态为暂停!");

			String password = $("password", "");
			if(password.equals(""))
				throw new AppException("密码不能为空");
			
			boolean isAuth = admin.auth("userPassword", password);
			if (isAuth) {
				actorLogin(admin.getUid());
				putSession(Role_Key, role);
				putSession(Dc_Key, dc);
			}
			else
				throw new AppException("认证失败");
		}
	}
	
	@Sessioned
	@Layout("NOT")
	public void main() {}
	
	@Sessioned
	@Layout("NOT")
	public void header() {
		r.putMap("admin", actor);
	}

	@Sessioned
	public void vi_home(ActResult actResult) {
	}
	
	@Sessioned
	public void logout() throws AppException  {
		delSession(Role_Key);
		delSession(Dc_Key);
		actorLogout();
	}

}
