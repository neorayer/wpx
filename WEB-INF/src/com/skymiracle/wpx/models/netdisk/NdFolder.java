package com.skymiracle.wpx.models.netdisk;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.IDocAccessor;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.StorageAccessorFactory;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.FnsQPCodec;
import com.skymiracle.wpx.models.user.User;

/**
 * 网络U盘文件夹
 */
public class NdFolder {

	private String parentUuid;

	// 文件夹名
	private String name;
	
	public String getUuid() {
		String encName = FnsQPCodec.encode(this.name, "UTF-8");
		return new File(this.parentUuid, encName).getPath();// getAbsolutePath();
	}

	public void setUuid(String uuid) {
		this.parentUuid = new File(uuid).getParentFile().getPath();// getAbsolutePath();
		this.name = new File(FnsQPCodec.decode(uuid, "UTF-8")).getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentUuid() {
		return parentUuid;
	}

	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}

	public static class X {
		private StorageAccessorFactory saFactory;
		
		public X(StorageAccessorFactory saFactory) {
			this.saFactory = saFactory;
		}
		
		public long getSize(User user) throws AppException, Exception{
			return this.UDA(user).docGetStorageSizeUsed();
		}

		private IDocAccessor UDA(User user) throws AppException,
				Exception {
			return saFactory.getUserStorageDocAccessor(user.getUid(), user
					.getDc(), user.getStorageLocation());
		}

		public List<NdFolder> findAll(User user) throws AppException, Exception {
			List<NdFolder> folders = new LinkedList<NdFolder>();
			List<String> paths = UDA(user).docLsFldr("/", true);
			for (String path : paths) {
				NdFolder folder = new NdFolder();
				folder.setUuid(new File(path).getPath());
				folders.add(folder);
			}
			Collections.sort(folders, new Comparator<NdFolder>() {
				public int compare(NdFolder o1, NdFolder o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			return folders;
		}

		public NdFolder add(User user, NdFolder folder) throws AppException,
				Exception {
			// 对文件夹名编码
			String name = FnsQPCodec.encode(folder.getName(), "UTF-8");
			UDA(user).docNewFolder(folder.getParentUuid(), name);
			return folder;
		}

		public void del(User user, NdFolder folder) throws AppException,
		Exception {
			UDA(user).docDelFolder(folder.getUuid());
		}
	}

}
