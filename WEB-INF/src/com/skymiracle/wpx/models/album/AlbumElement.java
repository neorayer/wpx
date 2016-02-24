package com.skymiracle.wpx.models.album;

import com.skymiracle.mdo4.NullKeyException;

public class AlbumElement extends PersistenceObject {

	private String owner;

	private String name;

	private String description;

	private String originalPath;

	private String thumbPath;

	private String createDate;

	private String updateDate;

	private String publicTag;
	
	private long accessCount;

	public long getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(long accessCount) {
		this.accessCount = accessCount;
	}

	public String getPublicTag() {
		return publicTag;
	}

	public void setPublicTag(String publicTag) {
		this.publicTag = publicTag;
	}

	public AlbumElement() {
		super();
	}

	public AlbumElement(String uuid) {
		super(uuid);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public String getOriginalPath() {
		return originalPath;
	}

	public void setOriginalPath(String originalPath) {
		this.originalPath = originalPath;
	}

	public String getThumbPath() {
		return thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath;
	}

	@Override
	public String table() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] objectClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selfDN() throws NullKeyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fatherDN(String baseDN) throws NullKeyException {
		// TODO Auto-generated method stub
		return null;
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
