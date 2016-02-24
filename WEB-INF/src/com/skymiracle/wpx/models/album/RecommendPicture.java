package com.skymiracle.wpx.models.album;

public class RecommendPicture extends PersistenceObject {

	private String pictureUUID;
	
	private String catalogUUID;
	@Override
	public String table() {
		return "tb_album_RecommendPicture";
	}
	public String getCatalogUUID() {
		return catalogUUID;
	}

	public void setCatalogUUID(String catalogUUID) {
		this.catalogUUID = catalogUUID;
	}

	public String getPictureUUID() {
		return pictureUUID;
	}

	public void setPictureUUID(String pictureUUID) {
		this.pictureUUID = pictureUUID;
	}
		
}
