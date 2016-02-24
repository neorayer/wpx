package com.skymiracle.wpx.models.album;

public class RecommendFolder extends PersistenceObject {

	private String folderUUID;
	
	private String catalogUUID;
	@Override
	public String table() {
		return "tb_album_RecommendFolder";
	}
	public String getCatalogUUID() {
		return catalogUUID;
	}

	public void setCatalogUUID(String catalogUUID) {
		this.catalogUUID = catalogUUID;
	}

	public String getFolderUUID() {
		return folderUUID;
	}

	public void setFolderUUID(String folderUUID) {
		this.folderUUID = folderUUID;
	}
		
}
