package com.skymiracle.wpx.controllers.u;

import javax.servlet.http.Cookie;

import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.NotExistException;
import com.skymiracle.sor.controller.WebController;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.sor.render.JsonRenderer;
import com.skymiracle.wpx.models.domain.Domain;
import com.skymiracle.wpx.models.user.User;
import com.skymiracle.wpx.uia_ws.UiaAccountInfo;
import com.skymiracle.wpx.uia_ws.authtoken.AuthToken;

public class Ctr extends WebController<User> {

	protected boolean isSynUia = false;

	protected static final String uiaTokenKey = "UIATOKEN";

	@Override
	protected void afterActorLogout() throws AppException {
		page().redirectTo("login.html");
	}

	@Override
	public void dealWithNoSession() {
		if (renderer.isPageRenderer()) {
			page().redirectTo("login.html?timeout=true");
		}else if(JsonRenderer.class.isAssignableFrom(renderer.getClass())) {
			try {
				((JsonRenderer)renderer).render(new AppException("timeout"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	public String getActorId() {
		String actorId = super.getActorId();

		if (actorId != null)
			return actorId;

		if (!isSynUia)
			return null;
		
		// 从UIA中取得信息
		String token = null;
		try {
			// 取得cookie信息
			Cookie cookie = request.findCookie("uia_param");
			if (cookie == null)
				return null;

			// 解析cookie信息
			String uia_param = cookie.getValue();
			delCookie("uia_param");
			uia_param = java.net.URLDecoder.decode(uia_param, "utf-8");
			String[] arr = uia_param.split("::::");
			if (arr.length != 2)
				return null;
			actorId = arr[0];
			token = arr[1];
			Logger.debug("UIA LOGIN: Uid=" + actorId + ", Token=" + token);

			// 分解用户邮箱
			String[] ss = actorId.split("@");
			if (ss.length != 2) {
				return null;
			}
			// 检测是否存在
			Domain domain = new Domain(ss[1]);
			if (!domain.exists()) {
				return null;
			}

			// 检测用户是否存在
			User user = new User(ss[1], ss[0]);
			if (user.exists()) {
				return actorId;
			}
			// 用户不存在
			AuthToken authToken = new AuthToken(actorId, token);
			authToken.request();
			UiaAccountInfo uiaAccount = authToken.getUiaAccount();
			user.setUserPassword(uiaAccount.getPassword());
			user.create();
			storeUIAToken(token);
			
			return actorId;
		} catch (Exception e) {
			return null;
		}
	}

	protected void storeUIAToken(String uiaToken) {
		putSession(uiaTokenKey, uiaToken);
	}

	protected String getUIAToken() {
		return (String) getSession(uiaTokenKey);
	}

	@Override
	public User getActorFromId() throws AppException, Exception {
		String[] ss = this.actorId.split("@");
		User user = new User(ss[1], ss[0]);
		try {
			user.load();
			actorLogin(user.toEmail());
			return user;
		} catch (NotExistException e) {
			return null;
		}

	}

	@Override
	protected String getTheme() throws AppException {
		return "163";
	}

}
