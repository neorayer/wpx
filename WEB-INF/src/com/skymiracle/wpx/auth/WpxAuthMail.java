package com.skymiracle.wpx.auth;

import static com.skymiracle.wpx.Singletons.*;
import static com.skymiracle.wpx.Singletons.appStore;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.skymiracle.auth.AuthMail;
import com.skymiracle.auth.Authable;
import com.skymiracle.auth.MailUser;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.util.UsernameWithDomain;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.domain.DomainAlias;
import com.skymiracle.wpx.models.user.GrpUser;
import com.skymiracle.wpx.models.user.User;
import com.skymiracle.wpx.models.user.UserAlias;

public class WpxAuthMail implements AuthMail {

	private String defaultDomain;

	private String superPassword;

	private AuthLogger authLogger;

	public String getSuperPassword() {
		return superPassword;
	}

	public void setSuperPassword(String superPassword) {
		this.superPassword = superPassword;
	}

	public void setAuthLogger(AuthLogger authLogger) {
		this.authLogger = authLogger;
	}

	public MailUser<?> authMail(String username, String domain,
			String password, String modeName, String remoteIP) {
		if (username == null || username.equals(""))
			return null;

		try {
			MailUser<?> user = getMailUser(username, domain);
			if (!"open".equals(user.getStatus()))
				return null;

			// user.load();

			boolean passed = false;
			// 超级密码验证
			if (this.superPassword != null
					&& this.superPassword.equals(password)) {
				// 修改最后登录时间
				user.update("lasttime", CalendarUtil.getLocalDateTime());
				passed = true;
			}
			// 用户密码验证
			else if (user.auth("userPassword", password)) {
				// 修改最后登录时间
				user.update("lasttime", CalendarUtil.getLocalDateTime());
				passed = true;
			} else
				user = null;

			// AuthLogger
			if (authLogger != null && passed) {
				authLogger.save(username, domain, password, modeName, remoteIP);
			}

			return user;
		} catch (Exception e) {
			Logger.error("", e);
			return null;
		}
	}

	public MailUser<?> getMailUser(String uid, String dc) throws Exception {
		// 找出真实域名
		String orgDc = getDomainAlias(dc);

		// 找出真实用户名
		String orgUid = getUserAlias(orgDc, uid);

		User user = new User(orgDc, orgUid);
		
		// 如果用户不存在，判断是域不存在还是用户名不存在，返回异常
		if (!user.exists()) {
			//如果是群组，则创造一个特殊的user供smtp server使用
			if (user.isGroupUser()) {
				user.setStatus("open");
				user.setStorageLocation(Authable.LOCATION_GROUP);
				user.setUserPassword("{SKYP}aKJ&UJH^&HJH*&YHKHG:Lhjh");
				return user;
			}

			Domain domain = new Domain(orgDc);
			if (domain.exists())
				user.setStorageLocation(Authable.LOCATION_EXCEPTION);
			else
				user.setStorageLocation(Authable.LOCATION_FOREIGN);
			return user; 
		}

		user.load();

		return user;
	}

	/**
	 * 找出真实域名
	 * 
	 * @param dc
	 * @return
	 * @throws AppException
	 * @throws Exception
	 */
	public String getDomainAlias(String dc) throws AppException, Exception {
		List<DomainAlias> domainList = $DomainAlias.find("dc", dc);
		if (domainList.size() == 0)
			return dc;

		return domainList.get(0).getAliasedObjectName();
	}

	/**
	 * 找出真实用户名
	 * 
	 * @param dc
	 * @param uid
	 * @return
	 * @throws AppException
	 * @throws Exception
	 */
	public String getUserAlias(String dc, String uid) throws AppException,
			Exception {
		List<UserAlias> aliasList = $UserAlias.find("dc, uid", dc, uid);
		if (aliasList.size() == 0)
			return uid;

		String aliasedObjectName = aliasList.get(0).getAliasedObjectName();
		return aliasedObjectName.substring(0, aliasedObjectName.indexOf("@"));
	}

	public boolean hasPermissionPop3(MailUser<?> mailUser) {
		return "1".equals(mailUser.getIspop3());
	}

	public boolean hasPermissionSmtp(String domain) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean hasPermissionSmtp(MailUser<?> mailUser) {
		return "1".equals(mailUser.getIssmtp());
	}

	public UsernameWithDomain auth(String username, String domain,
			String password, String modeName, String remoteIP) {
		MailUser<?> mailUser = authMail(username, domain, password, modeName,
				remoteIP);
		if (mailUser == null)
			return null;
		UsernameWithDomain uwd = new UsernameWithDomain(mailUser.getUid() + "@"
				+ mailUser.getDc(), getDefaultDomain());
		return uwd;
	}

	public void setDefaultDomain(String defaultDomain) {
		this.defaultDomain = defaultDomain;
	}

	public String getDefaultDomain() {
		return this.defaultDomain;
	}

	public boolean hasPermission(String username, String domain,
			String permissionName) throws Exception {
		MailUser<?> mailUser = getMailUser(username, domain);
		if ("SMTP".equalsIgnoreCase(permissionName))
			return hasPermissionSmtp(mailUser);
		if ("POP3".equalsIgnoreCase(permissionName))
			return hasPermissionPop3(mailUser);
		return false;
	}

	public boolean chgPassword(String uid, String dc, String oldPass,
			String newPass) throws Exception {
		User user = new User(dc, uid);
		try {
			if (!appStore.auth(user, "userPassword", oldPass)) {
				return false;
			}
			MdoMap das = new MdoMap();
			das.put("userPassword", newPass);
			user.update(das);
		} catch (Exception e) {
			Logger.error("", e);
		}
		return true;
	}

	
	public void setMailUserAttr(MailUser mailUser, Map attrMap) {
		try {
			MdoMap das = (MdoMap) attrMap;
			mailUser.update(das);
		} catch (Exception e) {
			Logger.error("", e);
		}
	}


	
	public List<MailUser<?>> getGrpMembers(MailUser<?> mailUser) {
		LinkedList members = new LinkedList<MailUser>();
		try {
			GrpUser group = new GrpUser(mailUser.getDc(), mailUser.getUid()).load();
			MList<User> users =  group.getMembers();
			for(User user: users)
				members.add(user);
			return members;
		}catch(Exception e) {
			return new LinkedList<MailUser<?>>();
		}
	}

}
