package com.skymiracle.wpx.models.user;

public class Node {
	int length;
	String uuid;
	
	public Node(int length,String uuid){
		this.setLength(length);
		this.setUuid(uuid);
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
