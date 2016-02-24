package com.skymiracle.wpx.models.album;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


public interface PictureIO {

	/**
	 * 
	 * @param picture
	 * @param pictureFile
	 * @throws Exception
	 */
	public void savePictureFile(Picture picture, File pictureFile)
			throws Exception;

	public void copyFile(String pictureUUID, String folderUUID, String newUUID,
			String ext) throws IOException;

	public void deleteFile(String uuid,  int thumb, int angle,String ext) throws Exception;

	public void outFile(Picture picture, int thumb, OutputStream outputStream)
			throws Exception;
	public File getFile(Picture picture, int thumb)throws Exception;
}
