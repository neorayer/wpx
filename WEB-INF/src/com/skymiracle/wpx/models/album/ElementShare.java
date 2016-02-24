package com.skymiracle.wpx.models.album;

public class ElementShare extends PersistenceObject {

	private String publicElementID;
	private String publicElementType;
	private String publicUsers;
	private String token;
	@Override
	public String table() {
		return "tb_album_ElementShare";
	}
	public String getPublicElementID() {
		return publicElementID;
	}
	public void setPublicElementID(String publicElementID) {
		this.publicElementID = publicElementID;
	}
	public String getPublicElementType() {
		return publicElementType;
	}
	public void setPublicElementType(String publicElementType) {
		this.publicElementType = publicElementType;
	}
	public String getPublicUsers() {
		return publicUsers;
	}
	public void setPublicUsers(String publicUsers) {
		this.publicUsers = publicUsers;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String[] keyNames() {		
		return new String[] {"publicElementID", "publicElementType"};
	}
		
}
