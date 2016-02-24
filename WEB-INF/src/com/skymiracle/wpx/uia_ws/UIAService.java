package com.skymiracle.wpx.uia_ws;

import javax.jws.WebService;

/**
 * WebService接口定义类.
 * 
 * 使用@WebService将接口中的所有方法输出为Web Service. 可用annotation对设置方法、参数和返回值在WSDL中的定义.
 */
@WebService
public interface UIAService {

	public String accountSignIn(String xml);

	public String accountLogin(String xml);

	public String accountAuthTocken(String xml);

	public String updateAccountDetail(String xml);

	public String updateAccountPassword(String xml);

	public String deleteAccount(String xml);

	public String getAppSystems(String xml);

}
