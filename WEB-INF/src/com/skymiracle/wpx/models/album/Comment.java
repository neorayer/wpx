package com.skymiracle.wpx.models.album;

public class Comment extends PersistenceObject {

	
	private String albumElementUUID;

	private String content;
	
	private String author;
	
	private String createDate;

	private String updateDate;

	public Comment() {
		super();
	}
	@Override
	public String table() {
		return "tb_album_Comment";
	}
	public Comment(String uuid) {
		super(uuid);
	}

	public String getAlbumElementUUID() {
		return albumElementUUID;
	}

	public void setAlbumElementUUID(String albumElementUUID) {
		this.albumElementUUID = albumElementUUID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	
}
