package com.skymiracle.wpx.models.conf;

import com.skymiracle.mdo5.Mdo.Title;

@Title("系统参数")
public class ConfSet {
	@Title("参数名")
	private String keyname;

	@Title("参数值")
	private String value;
	
	@Title("描述")
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
