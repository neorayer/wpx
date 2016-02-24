package com.skymiracle.wpx.uia_ws.authtoken;

import static com.skymiracle.wpx.uia_ws.InitWs.UiaApp;
import static com.skymiracle.wpx.uia_ws.InitWs.WSClient;

import org.json.JSONObject;

import com.skymiracle.wpx.uia_ws.InitWs;
import com.skymiracle.wpx.uia_ws.UIABusiness;
import com.skymiracle.wpx.uia_ws.UiaAccountInfo;
import com.skymiracle.sor.exception.AppException;

public class AuthToken extends UIABusiness {

	private UiaAccountInfo uiaAccount = new UiaAccountInfo();

	public AuthToken(String mail, String token) throws Exception {
		// accountId示例： xxxx@jhsoho.com
		String[] arr = mail.split("@");
		if (arr.length != 2) {
			throw new AppException("邮箱格式错误. mail=" + mail);
		}

		String uid = arr[0];
		String appid = arr[1];

		// 准备数据
		fillData("uid", uid);
		fillData("appid", appid);
		fillData("token", token);

		// 把数据装入模板
		loadTemplate(InitWs.Template_AuthToken);
	}

	public void afterRequest() throws Exception {
		if (text == null)
			return;

		JSONObject json = new JSONObject(text);
		uiaAccount.setUid(json.getString("uid"));
		uiaAccount.setAppid(json.getString("appid"));
		uiaAccount.setPassword(json.getString("password"));
		uiaAccount.setDetail(json.getString("detail"));
		uiaAccount.setToken(json.getString("token"));
		uiaAccount.setLasttime(json.getString("lasttime"));
		uiaAccount.setLastip(json.getString("lastip"));
		uiaAccount.setCreatedatetime(json.getString("createdatetime"));
	}

	public UiaAccountInfo getUiaAccount() {
		return uiaAccount;
	}

	@Override
	protected String invoke() {
		return WSClient.accountAuthTocken(paramXml);
	}

	public static void main(String[] args) throws AppException, Exception {
		String accountId = "tianliang@jhsoho.com";
		String token = "MjAxMC0wOS0yOCAyMjo0NToyMDo6Ojo2MC4xOTEuMjQ5LjIxNg==";

		new AuthToken(accountId, token).request();
	}
}
