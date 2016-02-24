package com.skymiracle.wpx.models.album;

public class Folder extends AlbumElement {

	
	private String parentUUID;

	private String coverPictureUUID;

	public Folder() {
		super();
	}
	@Override
	public String table() {
		return "tb_album_Folder";
	}
	public Folder(String uuid) {
		super(uuid);
	}
	public String getParentUUID() {
		return parentUUID;
	}

	public void setParentUUID(String parentUUID) {
		this.parentUUID = parentUUID;
	}

	public String getCoverPictureUUID() {
		return coverPictureUUID;
	}

	public void setCoverPictureUUID(String coverPictureUUID) {
		this.coverPictureUUID = coverPictureUUID;
	}

	
}
