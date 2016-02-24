package com.skymiracle.wpx.models.album;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import com.skymiracle.image.SkyImage;
import com.skymiracle.image.SkyImageImpl;
import com.skymiracle.logger.Logger;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.IPubDocAccessor;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.StorageAccessorFactory;
import com.skymiracle.util.FileTools;
import com.skymiracle.io.*;

public class PictureIoCmdStorageImpl implements PictureIO {

	private String storageName = "album";

	private StorageAccessorFactory saFactory;

	private String location;

	private String cacheDirPath = "/tmp/";

	public StorageAccessorFactory getSaFactory() {
		return saFactory;
	}

	public void setSaFactory(StorageAccessorFactory saFactory) {
		this.saFactory = saFactory;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void copyFile(String pictureUUID, String folderUUID, String newUUID,
			String ext) throws IOException {
		// TODO Auto-generated method stub

	}

	public void deleteFile(String uuid, int thumb, int angle, String ext)	throws Exception  {
		String fname = getPictureName(uuid, 0, 0, ext);
		IPubDocAccessor accessor = saFactory.getPubDocStorageAccessor(
				storageName, location);
		accessor.deleteFile(new String[]{fname});
	}

	public void outFile(Picture picture, int thumb, OutputStream outputStream)
			throws Exception {
		File file = getPictureFile(picture.getUuid(), thumb, picture.getCurAngle(), picture.getExt());
		StreamPipe.fileToOutput(file, outputStream, true);
	}

	public void savePictureFile(Picture picture, File pictureFile)
			throws Exception {
		String fname = getPictureName(picture.getUuid(), 0, 0, picture.getExt());
		IPubDocAccessor accessor = saFactory.getPubDocStorageAccessor(
				storageName, location);
		accessor.storFile(pictureFile, fname, false);
	}

	private String getPictureName(String uuid, int thumb, int angle, String ext) {
		return new File(uuid + "___" + thumb + "___" + angle + "." + ext)
				.getName();
	}

	private String getPicturePath(String uuid, int thumb, int angle, String ext) {
		return new File(this.cacheDirPath, getPictureName(uuid, thumb, angle,
				ext)).getAbsolutePath();
	}

	private File getPictureFile(String uuid, int thumb, int angle, String ext)
			throws Exception {
		String realPath = getPicturePath(uuid, thumb, angle, ext);

		if (thumb == 0 && angle == 0)
			return new File(realPath);
		else {
			File file = new File(realPath);
			if (file.exists())
				return file;

			IPubDocAccessor accessor = saFactory
					.getPubDocStorageAccessor(storageName, location);
			String fname = getPictureName(uuid, 0, 0, ext);
			File realFile = accessor.retrFile(fname);
			String orgPath = getPicturePath(uuid, 0, 0, ext);
			FileTools.moveFile(realFile, new File(orgPath));
			
			SkyImage skyImage = new SkyImageImpl(orgPath);
			if (thumb != 0) {
				skyImage.scale(thumb, true);
				Logger.debug("Image scaled...");
			}
			skyImage.regRotate(angle);
			Logger.debug("Image rotate...");
			skyImage.saveAs(realPath, SkyImage.FORMAT_JPG);
			return new File(realPath);
		}
	}
	
	private File getPictureFile2(String uuid, int thumb, int angle, String ext)
		throws Exception {
		String realPath = getPicturePath(uuid, thumb, angle, ext);

			File file = new File(realPath);
			if (file.exists())
				return file;
		
			IPubDocAccessor accessor = saFactory
					.getPubDocStorageAccessor(storageName, location);
			String fname = getPictureName(uuid, 0, 0, ext);
			File realFile = accessor.retrFile(fname);
			String orgPath = getPicturePath(uuid, 0, 0, ext);
			FileTools.moveFile(realFile, new File(orgPath));
			
			SkyImage skyImage = new SkyImageImpl(orgPath);
			if (thumb != 0) {
				skyImage.scale(thumb, true);
				Logger.debug("Image scaled...");
			}
			skyImage.regRotate(angle);
			Logger.debug("Image rotate...");
			skyImage.saveAs(realPath, SkyImage.FORMAT_JPG);
			return new File(realPath);
	}
	
	public File getFile(Picture picture, int thumb) throws Exception {
		File file = getPictureFile2(picture.getUuid(), thumb, picture.getCurAngle(), picture.getExt());
		return file;
	}
}
