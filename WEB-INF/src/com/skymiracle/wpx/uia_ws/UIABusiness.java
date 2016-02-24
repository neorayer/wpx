package com.skymiracle.wpx.uia_ws;

import static com.skymiracle.wpx.uia_ws.InitWs.FreeMarkerCfg;
import static com.skymiracle.wpx.uia_ws.InitWs.UiaApp;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.skymiracle.sor.exception.AppException;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public abstract class UIABusiness {

	protected Template t;

	protected String paramXml;

	protected String code;

	protected String text;

	protected Map<String, Object> root = new HashMap<String, Object>();

	public void request() throws Exception {
		// 执行调用
		String resultXml = invoke();
		// 解析返回值
		Document document = DocumentHelper.parseText(resultXml);
		Element root = document.getRootElement();

		// code
		Node node = root.selectSingleNode("code");
		if (node == null)
			throw new AppException("返回结果错误. Reason: 没有code节点");
		code = node.getText();

		// text
		node = root.selectSingleNode("text");
		if (node == null)
			throw new AppException("返回结果错误. Reason: 没有text节点");
		text = node.getText();

		if (!"250".equals(code)) {
			throw new AppException(text);
		}

		// 请求后
		afterRequest();
	}

	protected void loadTemplate(String templateName) throws Exception {
		this.t = InitWs.getTemplate(templateName);
		if (this.t == null) {
			throw new IOException("UIA WS参数模板载入失败! templateName = "
					+ templateName);
		}

		// 合并数据和模板
		merge();
	}

	protected void merge() throws TemplateException, IOException {
		root.put("APP_ID", UiaApp.getId());
		root.put("APP_PASSWORD", UiaApp.getPassword());

		StringWriter sw = new StringWriter();
		t.process(root, sw);
		paramXml = sw.toString();
		sw.close();
	}

	protected void fillData(String key, Object value) {
		root.put(key, value);
	}

	protected void afterRequest() throws Exception {
		// do nothing 该方法可覆盖
	}

	protected abstract String invoke();

}
