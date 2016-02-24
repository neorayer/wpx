package com.skymiracle.wpx.uia_ws;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skymiracle.logger.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class InitWs {
	public static final Configuration FreeMarkerCfg = new Configuration();
	public static final ApplicationContext context;

	public static final Map<String, Template> templateMap = new HashMap<String, Template>();
	// 注册模板
	public static final String Template_UserSignIn = "UserSignIn";
	// 登录模板
	public static final String Template_UserLogin = "UserLogin";
	// 验证模板
	public static final String Template_AuthToken = "AuthToken";

	static {
		FreeMarkerCfg.setClassForTemplateLoading(UIABusiness.class, "");
		context = new ClassPathXmlApplicationContext("client-beans.xml",
				UIABusiness.class);

		try {
			templateMap.put(Template_UserSignIn,
					loadTemplate("signin/param.ftl"));
			templateMap
					.put(Template_UserLogin, loadTemplate("login/param.ftl"));
			templateMap.put(Template_AuthToken,
					loadTemplate("authtoken/param.ftl"));
		} catch (IOException e) {
			Logger.error("载入WS参数模板失败", e);
		}
	}

	public static Template getTemplate(String templateName) {
		return templateMap.get(templateName);
	}

	private static Template loadTemplate(String ftlRelativePath)
			throws IOException {
		return FreeMarkerCfg.getTemplate(ftlRelativePath, "utf-8");
	}

	public static UIAService WSClient = (UIAService) context.getBean("client");
	public static UiaAppInfo UiaApp = (UiaAppInfo) context.getBean("UiaApp");

}
