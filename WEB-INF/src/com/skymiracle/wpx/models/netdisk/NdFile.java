package com.skymiracle.wpx.models.netdisk;

import java.io.File;
import java.util.List;

import com.skymiracle.fileBox.FileBoxLsItem;
import com.skymiracle.mdo5.Mdo;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.mime.MimeReader;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.StorageAccessorFactory;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.IDocAccessor;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.IMailAccessor;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.FnsQPCodec;
import com.skymiracle.wpx.models.user.User;
import com.skymiracle.wpx.util.ByteTools;

/**
 * 网络U盘
 */
public class NdFile {

	public static class X {
		private StorageAccessorFactory saFactory;

		public X(StorageAccessorFactory saFactory) {
			this.saFactory = saFactory;
		}

		private IDocAccessor UDA(User user) throws AppException,
				Exception {
			return saFactory.getUserStorageDocAccessor(user.getUid(), user
					.getDc(), user.getStorageLocation());
		}

		public List<FileBoxLsItem> findAll(User user, String folderPath)
				throws AppException, Exception {
			List<FileBoxLsItem> items = UDA(user).docLsFile(folderPath);
			for (FileBoxLsItem item : items) {
				item
						.setFileName(FnsQPCodec.decode(item.getFileName(),
								"UTF-8"));
				long size = item.getSize();
				if(size < 1024)
					item.setCurrentSize(size+"B");
				else if(size < 1024*1024)
					item.setCurrentSize(ByteTools.getByteToK(item.getSize())+"K");
				else
					item.setCurrentSize(ByteTools.getByteToM(item.getSize())+"M");
			}
			return items;
		}

		public void del(User user, String[] uuids) throws AppException,
				Exception {
			UDA(user).docDelFiles(uuids);
		}

		public void add(User user, String folderPath, File file, String fname)
				throws AppException, Exception {
			fname = FnsQPCodec.encode(fname, "UTF-8");
			UDA(user).docStorFile(folderPath, fname, file.getAbsolutePath(),
					true);
		}

		public void moveFiles(User user, String[] uuids, String targetFolderPath)
				throws AppException, Exception {
			UDA(user).docMoveFilesTo(uuids, targetFolderPath);

		}

		public File getFile(User user, String uuid)throws AppException, Exception {
			File file = new File(uuid);
			String path = UDA(user)
					.docRetrFile(file.getParentFile().getPath(), file.getName());
			return new File(path);
		}
	}

}
