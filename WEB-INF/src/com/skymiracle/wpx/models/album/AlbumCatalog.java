package com.skymiracle.wpx.models.album;

public class AlbumCatalog extends PersistenceObject {

	private String name;
	
	private String description;
	
	private String createDate;

	private String updateDate;

	public AlbumCatalog() {
		super();
	}
	@Override
	public String table() {
		return "tb_album_AlbumCatalog";
	}
	public AlbumCatalog(String uuid) {
		super(uuid);
	}
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
