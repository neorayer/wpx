package com.skymiracle.wpx.models.user;

import java.util.HashMap;
import java.util.Map;

public class Skin {
	private String id;

	private String code;

	private String desc;

	private boolean isShow;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static class X {
		private Map<String, Skin> skins = new HashMap<String, Skin>();

		public Skin getSkin(String id) {
			return skins.get(id);
		}

		public Map<String, Skin> getSkins() {
			return skins;
		}

		public void setSkins(Map<String, Skin> skins) {
			this.skins = skins;
		}
	}

	public boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(boolean isShow) {
		this.isShow = isShow;
	}

}
