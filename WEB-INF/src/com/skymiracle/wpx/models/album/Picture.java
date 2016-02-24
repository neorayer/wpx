package com.skymiracle.wpx.models.album;

public class Picture extends AlbumElement {

	private String folderUUID;

	private String catalogUUID;
	
	private String ext;
	
	private int width;
	
	private int height;
	
	private long byteSize;
	
	private String maker;
	
	private String model;
	
	private String iso;
	
	private String shutterSpeed;
	
	private String dateTimeDigitized;
	
	private String aperture;
	
	private String focalLength;

	private int curAngle = 0;
	
	public int getCurAngle() {
		return curAngle;
	}

	public void setCurAngle(int curAngle) {
		this.curAngle = curAngle;
	}

	public String getAperture() {
		return aperture;
	}

	public void setAperture(String aperture) {
		this.aperture = aperture;
	}

	public String getDateTimeDigitized() {
		return dateTimeDigitized;
	}

	public void setDateTimeDigitized(String dateTimeDigitized) {
		this.dateTimeDigitized = dateTimeDigitized;
	}

	public String getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(String focalLength) {
		this.focalLength = focalLength;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getShutterSpeed() {
		return shutterSpeed;
	}

	public void setShutterSpeed(String shutterSpeed) {
		this.shutterSpeed = shutterSpeed;
	}

	public Picture() {
		super();
	}
	
	public Picture(String uuid) {
		super(uuid);
	}
	
	public String getFolderUUID() {
		return folderUUID;
	}

	public void setFolderUUID(String folderUUID) {
		this.folderUUID = folderUUID;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public long getByteSize() {
		return byteSize;
	}

	public void setByteSize(long byteSize) {
		this.byteSize = byteSize;
	}

	public String getCatalogUUID() {
		return catalogUUID;
	}

	public void setCatalogUUID(String catalogUUID) {
		this.catalogUUID = catalogUUID;
	}
	@Override
	public String table() {
		return "tb_album_Picture";
	}
	
}
