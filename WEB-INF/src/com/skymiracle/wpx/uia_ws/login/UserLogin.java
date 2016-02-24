package com.skymiracle.wpx.uia_ws.login;

import static com.skymiracle.wpx.uia_ws.InitWs.WSClient;

import com.skymiracle.wpx.models.user.User;
import com.skymiracle.wpx.uia_ws.InitWs;
import com.skymiracle.wpx.uia_ws.UIABusiness;
import com.skymiracle.logger.Logger;
import com.skymiracle.sor.exception.AppException;

public class UserLogin extends UIABusiness {

	private String token;

	public UserLogin(User user, String ip) throws Exception {
		// 准备数据
		fillData("user", user);
		fillData("ip", ip);

		// 把数据装入模板
		loadTemplate(InitWs.Template_UserLogin);
	}

	public void afterRequest() throws Exception {
		// 取得令牌
		token = text;
	}

	public String getToken() {
		return token;
	}

	@Override
	protected String invoke() {
		return WSClient.accountLogin(paramXml);
	}

	public static void main(String[] args) throws AppException, Exception {
		Logger.setLevel(Logger.LEVEL_DEBUG);

		User user = new User("jhsoho.com", "tianliang");
		user.setUserPassword("111111");
//		user.load();
		String ip = "60.191.249.216";

		new UserLogin(user, ip).request();
	}

}
