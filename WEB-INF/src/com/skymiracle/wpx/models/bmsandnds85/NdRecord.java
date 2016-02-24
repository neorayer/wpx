package com.skymiracle.wpx.models.bmsandnds85;

import static com.skymiracle.wpx.Singletons.$NdFile;
import static com.skymiracle.wpx.Singletons.$NdFolder;

import java.io.File;

import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.netdisk.NdFolder;

//网络U盘记录
public class NdRecord extends UserRecord {

	public NdRecord(String domain, String user) {
		super(domain, user, "netdisk");
	}

	@Override
	public void create0() throws Exception {
		if (isdir) {
			createDir(this.name);
		} else {
			NdFolder folder = null;
			if (dir != null) {
				folder = createDir(dir);
			}

			File file = new File(this.memo);
			if (!file.exists() || file.isDirectory())
				return;
			$NdFile.add(user, folder.getUuid(), file, this.name);
		}
	}

	private NdFolder createDir(String name) throws AppException, Exception {
		NdFolder folder = new NdFolder();
		folder.setParentUuid("/");
		folder.setName(name);
		return $NdFolder.add(user, folder);
	}

}
