package com.skymiracle.wpx.models.album;

import com.skymiracle.mdo4.DaoStorageException;
import com.skymiracle.mdo4.RdbmsDaoStorage;

public class InitData {

	public static void initData(RdbmsDaoStorage rds, boolean isForce)
			throws DaoStorageException {

		rds.createTableForce(Folder.class, isForce);
		rds.createTableForce(Picture.class, isForce);
		rds.createTableForce(ElementShare.class, isForce);
		rds.createTableForce(AlbumCatalog.class, isForce);
		rds.createTableForce(RecommendFolder.class, isForce);
		rds.createTableForce(RecommendPicture.class, isForce);
		rds.createTableForce(Comment.class, isForce);
	}

}
