package com.skymiracle.wpx.models.addrbook.importers;

import java.util.HashMap;
import java.util.Map;

import com.skymiracle.wpx.models.addrbook.AddrImporter;

public class OutlookAddrImporter extends AddrImporter {
	private static Map<String, String> fieldMap = new HashMap<String, String>();

//	private final static String[] LABELS_OUTLOOK = new String[] { "名", "姓",
//		"姓名", "昵称", "电子邮件地址", "移动电话", "个人网页", "性别", "生日", "MSN", "QQ",
//		"公司", "部门", "职务", "业务网页", "公司所在国家/地区", "公司所在省/自治区", "公司所在城市",
//		"公司所在街道", "公司所在地的邮政编码", "业务电话", "业务电话2", "业务传真", "办公地点",
//		"住宅所在国家/地区", "住宅所在省/自治区", "住宅所在城市", "住宅所在街道", "住宅所在地的邮政编码", "住宅电话",
//		"住宅传真", "附注" };
	static {
		fieldMap.put("名", "GivenName");
		fieldMap.put("姓", "Sn");
		fieldMap.put("姓名", "DisplayName");

		fieldMap.put("昵称", "RDN");
		fieldMap.put("电子邮件地址", "Mail");
		fieldMap.put("移动电话", "Mobile");
		fieldMap.put("手机", "Mobile");
		fieldMap.put("个人网页", "Web");
		fieldMap.put("个人主页", "Web");
		fieldMap.put("性别", "Sex");
		fieldMap.put("生日", "Birthday");
		fieldMap.put("MSN", "Msn");
		fieldMap.put("QQ", "Oicq");
		fieldMap.put("公司", "Company");
		fieldMap.put("部门", "Ou");
		fieldMap.put("职务", "Title");
		fieldMap.put("职位", "Title");
		fieldMap.put("业务网页", "URL");
		fieldMap.put("公司网页", "URL");
		fieldMap.put("公司所在国家/地区", "C");
		fieldMap.put("公司所在国家", "C");
		fieldMap.put("公司所在省/自治区", "St");
		fieldMap.put("公司所在省", "St");
		fieldMap.put("公司所在城市", "L");
		fieldMap.put("公司所在市", "L");
		fieldMap.put("公司所在街道", "PostalAddress");
		fieldMap.put("公司所在地的邮政编码", "PostalCode");
		fieldMap.put("公司所在地邮政编码", "PostalCode");
		fieldMap.put("业务电话", "Phone");
		fieldMap.put("办公电话1", "Phone");
		fieldMap.put("业务电话2", "Telephonenumber");
		fieldMap.put("办公电话2", "Telephonenumber");
		fieldMap.put("业务传真", "Facsimiletelephonenumber");
		fieldMap.put("公司传真", "Facsimiletelephonenumber");
		fieldMap.put("办公地点", "PhysicalDeliveryOfficeName");
		fieldMap.put("住宅所在国家/地区", "Pc");
		fieldMap.put("家庭所在国家", "Pc");
		fieldMap.put("住宅所在省/自治区", "Pst");
		fieldMap.put("家庭所在省", "Pst");
		fieldMap.put("住宅所在城市", "Pl");
		fieldMap.put("家庭所在市", "Pl");
		fieldMap.put("住宅所在街道", "Ppa");
		fieldMap.put("家庭所在街道", "Ppa");
		fieldMap.put("住宅所在地的邮政编码", "Ppc");
		fieldMap.put("家庭所在地邮政编码", "Ppc");
		fieldMap.put("住宅电话", "HomePhone");
		fieldMap.put("家庭电话1", "HomePhone");
		fieldMap.put("住宅传真", "Pfax");
		fieldMap.put("家庭传真", "Pfax");
		fieldMap.put("附注", "Remark");
	}
	
	@Override
	protected String getFieldnameFromLabel(String label) {
		return fieldMap.get(label).toLowerCase();
	}

}
