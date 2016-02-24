package com.skymiracle.wpx.uia_ws.signin;

import static com.skymiracle.wpx.uia_ws.InitWs.WSClient;

import com.skymiracle.wpx.models.user.User;
import com.skymiracle.wpx.uia_ws.InitWs;
import com.skymiracle.wpx.uia_ws.UIABusiness;

public class UserSignIn extends UIABusiness {

	public UserSignIn(User user) throws Exception {
		// 准备数据
		fillData("user", user);

		// 把数据装入模板
		loadTemplate(InitWs.Template_UserSignIn);
	}

	@Override
	protected String invoke() {
		return WSClient.accountSignIn(paramXml);
	}

	public static void main(String[] args) throws Exception {
		User user = new User("jhsoho.com", "tianliang");
		user.setUserPassword("111111");

		new UserSignIn(user).request();
	}  
    
} 
