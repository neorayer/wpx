package com.skymiracle.wpx.models.portal;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skymiracle.mdo4.DaoAttrSet;
import com.skymiracle.mdo4.DaoService;
import com.skymiracle.mdo4.KeyNotExistException;
import com.skymiracle.wpx.models.user.User;
import com.skymiracle.auth.*;

public class PortalService extends DaoService{
	
	private String logoutRedirectTo = "";

	private String homePageUrl = "/wpx/pguser/vi/portal/";
	
	private AuthMail authMail;

	public String getLogoutRedirectTo() {
		return logoutRedirectTo;
	}

	public void setLogoutRedirectTo(String logoutRedirectTo) {
		this.logoutRedirectTo = logoutRedirectTo;
	}

	public String getHomePageUrl() {
		return homePageUrl;
	}

	public void setHomePageUrl(String homePageUrl) {
		this.homePageUrl = homePageUrl;
	}

	public AuthMail getAuthMail() {
		return authMail;
	}

	public void setAuthMail(AuthMail authMail) {
		this.authMail = authMail;
	}

//	public User doLogin(String username, String domain, String password,
//			String remoteIP, HttpSession session) {
//
//		User user = doLogin(username, domain, password, remoteIP);
//		if (user != null) {
//			session.setAttribute("user", user);
//		}
//		return user;
//	}
//
//	public User doLogin(String username, String domain, String password,
//			String remoteIP) {
//		User user = (User) authMail.authMail(username, domain, password, "WEB",
//				remoteIP);
//		return user;
//	}
//
//	public void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.getSession().removeAttribute("user");
//		if (this.logoutRedirectTo != null && this.logoutRedirectTo.length() != 0)
//			response.sendRedirect(this.logoutRedirectTo);
//		else
//			response.sendRedirect("../../vi/portal/login.jsp");
//	}
//
//	public void gotoHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		response.sendRedirect(this.homePageUrl);
//	}
//
	public String[] getUserApps(User user) {
		// TODO Auto-generated method stub
		List<String> userApps = new LinkedList<String>();
		userApps.add("mail");
		userApps.add("addrbook");
		userApps.add("netdisk");
		userApps.add("bookmark");
		userApps.add("album");
		return userApps.toArray(new String[0]);
	}
//
//	public void chgPassword(String oldPass, String newPass)
//			throws WpxServiceException {
//		try {
//			authMail.chgPassword(user.getUid(), user.getDc(), oldPass, newPass);
//		} catch (Exception e) {
//			throw new WpxServiceException(e);
//		}
//	}
//
//	public User doLoginI(String username, String domain, String remoteIP,
//			HttpSession session) {
//		User user = null;
//		try {
//			user = (User) this.getMailUser(username, domain);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		if (user.getUuid() != null) {
//			session.setAttribute("user", user);
//		}
//		return user;
//	}
//	
//
//	public MailUser getMailUser(String uid, String dc) throws Exception{
//		User user = new User(dc, uid);
//		try {
//			daoStorage.loadDao(user);
//			if(user.getUuid() == null){
//				List<UserAlias> aliasList = null;
//				DaoAttrSet das = new DaoAttrSet();
//				das.put("dc", dc);
//				das.put("uid", uid);
//				aliasList = daoStorage.getDaos(UserAlias.class, das);
//				for (int i = 0; i < aliasList.size(); i++) {
//					String mailNames =aliasList.get(i).getAliasedObjectName().substring(0, aliasList.get(i).getAliasedObjectName().indexOf("@"));
//					getMailUser(mailNames, dc);
//					MailUser mailUser1 = getMailUser(mailNames, dc);
//					if(mailUser1 != null)user.setUid(mailUser1.getUid());
//				}
//			}
//			return user;
//		} catch (KeyNotExistException e) {
//
//			List<UserAlias> aliasList = null;
//			DaoAttrSet das = new DaoAttrSet();
//			das.put("dc", dc);
//			das.put("uid", uid);
//			aliasList = daoStorage.getDaos(UserAlias.class, das);
//			for (int i = 0; i < aliasList.size(); i++) {
//				String mailNames =aliasList.get(i).getAliasedObjectName().substring(0, aliasList.get(i).getAliasedObjectName().indexOf("@"));
//				User user1 = new User(dc, mailNames);	
//				daoStorage.loadDao(user1);
//				if(user1 != null) return user1;
//			}
//		
//			Domain domain = new Domain(dc);
//			if (daoStorage.existDao(domain))
//				user.setStorageLocation(Authable.LOCATION_EXCEPTION);
//			else
//				user.setStorageLocation(Authable.LOCATION_FOREIGN);
//			return user;
//		}
//	}
}
