package com.skymiracle.wpx.models.mail;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.Mdo;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.MailFolderInfo;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.StorageAccessorFactory;
import com.skymiracle.server.tcpServer.cmdStorageServer.accessor.IMailAccessor;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.FnsQPCodec;
import com.skymiracle.wpx.models.user.User;

import static com.skymiracle.wpx.Singletons.*;
/**
 *	邮件夹
 */
public class MailFolder extends Mdo<MailFolder> {
	
	// 用户
	public User owner;

	// 文件夹名
	private String id;

	// 新邮件数
	public int newCount;

	// 总邮件数
	public int count;

	// 类型（系统/自定义）
	public static enum Type {
		Sys, My
	};

	// 序号
	private int sortTag;

	public MailFolder() {
		super();
	}

	public MailFolder(User owner, String id) {
		super();
		setOwner(owner);
		setId(id);
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		if ("inbox".equals(id))
			return "收件箱";
		else if ("sent".equals(id))
			return "已发送邮件";
		else if ("draft".equals(id))
			return "草稿箱";
		else if ("trash".equals(id))
			return "废件箱";
		else if ("star".equals(id))
			return "已加星标";
		else if ("spam".equals(id))
			return "垃圾邮件";
		return FnsQPCodec.decode(id, "UTF-8");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		setSortTag();
	}

	public Type getType() {
		if (isSysFolder())
			return Type.Sys;
		return Type.My;
	}

	public int getNewCount() {
		return newCount;
	}

	public void setNewCount(int newCount) {
		this.newCount = newCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSortTag() {
		return sortTag;
	}

	public boolean isSysFolder() {
		if ("inbox".equals(id))
			return true;
		else if ("sent".equals(id))
			return true;
		else if ("draft".equals(id))
			return true;
		else if ("trash".equals(id))
			return true;
		else if ("star".equals(id))
			return true;
		else if ("spam".equals(id))
			return true;

		return false;
	}

	private void setSortTag() {
		if (id.equals("inbox")) {
			this.sortTag = 10;
		} else if (id.equals("draft")) {
			this.sortTag = 20;
		} else if (id.equals("spam")) {
			this.sortTag = 50;
		} else if (id.equals("trash")) {
			this.sortTag = 40;
		} else if (id.equals("sent")) {
			this.sortTag = 30;
		} else
			this.sortTag = 100;
	}
	
	public boolean isClearable(){
		 if (id.equals("spam") || id.equals("trash"))
			 return true;
		return false;
	}
	public boolean isViewCount(){
		 if (id.equals("inbox") || this.getType()==Type.My)
			 return true;
		 if (id.equals("spam"))
			 return true;
		return false;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "idxName" };
	}

	@Override
	public String table() {
		return null;
	}

	@Override
	public MailFolder create() throws AppException, Exception {
		$MailFolder.create(this);
		return this;
	}

	@Override
	public void delete() throws AppException, Exception {
		$MailFolder.delete(this);
	}

	public void empty() throws AppException, Exception {
		$MailFolder.empty(this);
	}
	
	@Override
	public MailFolder load() throws AppException, Exception {
		return $MailFolder.load(this);
	}

	// /////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////

	public static class X {
		private StorageAccessorFactory saFactory;

		public X(StorageAccessorFactory saFactory) {
			this.saFactory = saFactory;
		}

		public MailFolder load(MailFolder f) throws AppException, Exception{
			List<MailFolderInfo> items = UMA(f.owner).mailGetFldrInfos();
			for (MailFolderInfo item : items) {
				if (!item.getIdxName().equals(f.id))
					continue;
				f.setCount(item.getCount());
				f.setNewCount(item.getNewCount());
			}
			return f;
		}

		public void create(MailFolder f) throws AppException, Exception {
			UMA(f.owner).mailNewFolder(f.getId());
		}

		public void delete(MailFolder f) throws AppException, Exception {
			empty(f);
			UMA(f.owner).mailDelFolder(f.getId());
		}

		public void empty(MailFolder f) throws AppException, Exception {
			UMA(f.owner).mailEmptyFldr(f.getId());
		}

		private IMailAccessor UMA(User user) throws Exception {
			return saFactory.getUserStorageMailAccessor(user.getUid(), user
					.getDc(), user.getStorageLocation());
		}

		public MList<MailFolder> findAll(User user) throws AppException,
				Exception {
			List<MailFolderInfo> items = UMA(user).mailGetFldrInfos();
			MList<MailFolder> folders = new MList<MailFolder>();
			for (MailFolderInfo item : items) {
				MailFolder f = new MailFolder(user, item.getIdxName());
				f.setCount(item.getCount());
				f.setNewCount(item.getNewCount());
				folders.add(f);
			}

			Collections.sort(folders, new Comparator<MailFolder>() {

				public int compare(MailFolder o1, MailFolder o2) {
					return o1.getSortTag() > o2.getSortTag() ? 1 : -1;
				}
			});
			return folders;
		}

		/**
		 * 从所有邮件夹中找到系统邮件夹
		 * @param all
		 * @return
		 * @throws AppException
		 * @throws Exception
		 */
		public MList<MailFolder> getSys(MList<MailFolder> all)
				throws AppException, Exception {
			MList<MailFolder> folders = new MList<MailFolder>();
			for (MailFolder f : all) {
				if (f.isSysFolder())
					folders.add(f);
			}
			return folders;
		}

		/**
		 * 从所有邮件夹中找到自定义邮件夹
		 * @param all
		 * @return
		 * @throws AppException
		 * @throws Exception
		 */
		public MList<MailFolder> getMy(MList<MailFolder> all)
				throws AppException, Exception {
			MList<MailFolder> folders = new MList<MailFolder>();
			for (MailFolder f : all) {
				if (!f.isSysFolder())
					folders.add(f);
			}
			return folders;
		}

	}
}
