package com.skymiracle.wpx.models.bmsandnds85;

import java.util.List;

import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.bookmark.BmFolder;
import com.skymiracle.wpx.models.bookmark.BmItem;
import static com.skymiracle.wpx.Singletons.*;

// 网络书签记录
public class BmRecord extends UserRecord {

	public BmRecord(String domain, String user) {
		super(domain, user, "bookmark");
	}

	@Override
	public void create0() throws Exception {
		if(isdir) {
			createDir(this.name);
		}
		else {
			BmFolder forder = null;
			if(this.dir != null) {
				forder = createDir(this.dir);
			}
			
			BmItem bi = new BmItem();
			if(forder != null)
				bi.setFolderUUID(forder.getUuid());
			bi.setName(this.name);
			bi.setUrl(this.memo);
			bi.setOwner(uid + "@" + domain);
			
			if($BmItem.count("owner, name, folderUUID", bi.getOwner(), bi.getName(), bi.getFolderUUID()) > 0)
				return;
			
			// 插入操作
			bi.create();
		}
		
	}

	private BmFolder createDir(String name) throws AppException, Exception {
		BmFolder folder = new BmFolder();
		folder.setName(name);
		folder.setOwner(uid + "@" + domain);
		List<BmFolder> forders = $BmFolder.find("owner,name", folder.getOwner(), name);
		if(forders.size() > 0)
			return forders.get(0);
		
		return folder.create();
	}

}
