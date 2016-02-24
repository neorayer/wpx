package com.skymiracle.wpx.controllers.u;

import java.io.*;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.bookmark.BmFolder;
import com.skymiracle.wpx.models.bookmark.BmItem;

import static com.skymiracle.wpx.Singletons.*;

@Sessioned
public class BookmarkCtr extends Ctr {
	public void main() throws AppException, Exception {
		r.putMap("allcount", $BmItem.count("owner", actor.getMail()));
		r.putMap("forders", $BmFolder.find("owner", actor.toEmail()));
	}
	
	/** ******** Folder ********* */
	//目录列表
	public void forders() throws AppException, Exception {}
	
	//新增组
	public void addFolder() throws AppException, Exception {
		if(!is_get){
			BmFolder folder = $M(BmFolder.class);
			folder.setOwner(actor.toEmail());
			folder.create();
		}
	}
	
	//删除组
	public void delFolder() throws AppException, Exception {
		$M(BmFolder.class).delete();
	}

	//修改组
	public void modFolder() throws AppException, Exception {
		if(!is_get){
			BmFolder folder = $M(BmFolder.class);
			folder.update($MM(BmFolder.class));
		}else{
			r.putMap("forder", new BmFolder($("folderuuid")).load());
		}
	}
	
	/** ******** Item ********* */
	//书签列表
	public void items() throws AppException, Exception {
		String folderuuid = $("folderuuid", "");
		r.putMap("folderuuid", folderuuid);
		r.putMap("items", $BmItem.find("owner,folderuuid", actor.toEmail(), folderuuid));
	}
	
	//添加书签
	public void addItem() throws AppException, Exception {
		if(!is_get){
			BmItem item = $M(BmItem.class);
			item.setOwner(actor.toEmail());
			item.create();
		}else{
			String folderuuid = $("folderuuid", "");
			r.putMap("folderuuid", folderuuid);
		}
	}
	
	//修改书签
	public void modItem() throws AppException, Exception {
		if(!is_get){
			BmItem item = $M(BmItem.class);
			item.update($MM(BmItem.class));
		}else{
			r.putMap("item", new BmItem($("itemuuid")).load());
		}
	}
	
	//删除书签
	public void delItem() throws AppException, Exception {
		$$M(BmItem.class, "uuid").delete();
	}
	
	//移动书签
	public void moveTo() throws AppException, Exception {
		for (BmItem item :$$M(BmItem.class, "uuid")) {
			item.moveToFolder($("folderuuid"));
		}
	}

	//复制书签
	public void copyTo() throws AppException, Exception {
		for (BmItem item :$$M(BmItem.class, "uuid")) {
			item.load().copyToFolder($("folderuuid"));
		}
	}
	
	/** ******** Import & Export ********* */
	//导出书签
	public void export() throws AppException, Exception {
		File file = createTempFile();
		$BmFolder.export(actor, $("folderuuid"), file);
		r.putFile(file, "bookmarks.html");
	}
	
	//导入书签
	public void importItems() throws AppException, Exception {
		String folderuuid = $("folderuuid");
		if(is_get){
			r.putMap("folderuuid", folderuuid);
		}else{
			$BmFolder.imports($File(), actor, folderuuid);
			r.setJs("parent.Bookmark.openUrl('bookmark/main.html');");
		}
	}
	
}
