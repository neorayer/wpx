package com.skymiracle.wpx.models.album;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import com.skymiracle.image.SkyImage;
import com.skymiracle.image.SkyImageImpl;
import com.skymiracle.io.StreamPipe;
import com.skymiracle.logger.Logger;
import com.skymiracle.util.FileTools;

public class PictureIOLocal implements PictureIO {

	private  String rootPath = "/tmp";

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
		File dir = new File(this.rootPath);
		if (!dir.exists())
			dir.mkdirs();
	}

	private String getPicturePath(String uuid, int thumb, int angle, String ext) {
		return new File(this.rootPath , uuid + "___" + thumb + "___" + angle
				+ "." + ext).getAbsolutePath();
	}

	public void savePictureFile(Picture picture, File pictureFile)
			throws Exception {
		// ajuest the type of picture
		String ext = FileTools.getFileExt(pictureFile.getName());

		// save to realpath
		String realPath = getPicturePath(picture.getUuid(), 0, 0, ext);
		StreamPipe.fileToFile(pictureFile, new File(realPath));

	}

	public void copyFile(String pictureUUID, String folderUUID, String newUUID,
			String ext) throws IOException {
		String oldRealPath = getPicturePath(pictureUUID, 0, 0, ext);
		String newRealPath = getPicturePath(newUUID, 0, 0, ext);
		StreamPipe.fileToFile(oldRealPath, newRealPath);
	}

	public void deleteFile(String uuid, int i, int j, String ext) {
		String orgFilePath = getPicturePath(uuid, 0, 0, ext);
		new File(orgFilePath).delete();
	}

	public void outFile(Picture picture, int thumb, OutputStream outputStream) throws Exception {

		File file = getPictureFile(picture.getUuid(), thumb, picture
				.getCurAngle(), picture.getExt());
		StreamPipe.toOutput(file, outputStream, true);

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

			String orgPath =getPicturePath(uuid, 0, 0, ext);
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

	public File getFile(Picture picture, int thumb) throws Exception {
		File file = getPictureFile(picture.getUuid(), thumb, picture.getCurAngle(), picture.getExt());
		return file;
	}
	
}
