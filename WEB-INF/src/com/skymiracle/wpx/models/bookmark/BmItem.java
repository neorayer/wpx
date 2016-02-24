package com.skymiracle.wpx.models.bookmark;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import com.skymiracle.csv.Csv;
import com.skymiracle.logger.Logger;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;

import static com.skymiracle.wpx.Singletons.*;

/**
 * 书签
 */
public class BmItem extends WpxMdo<BmItem> {
	public BmItem() {
		super($BmItem);
	}

	public String uuid = UUID.randomUUID().toString();
	
	// 所在目录UUID，如无目录则为 0长度字符串（不是null)
	public String folderUUID; 
	
	// 书签名
	public String name;
	
	// 描述
	public String description;
	
	// 地址
	public String url;
	
	// 用户
	public String owner;
	
	public BmItem(String uuid){
		this();
		this.uuid = uuid;
	}
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFolderUUID() {
		return folderUUID;
	}

	public void setFolderUUID(String folderUUID) {
		this.folderUUID = folderUUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String table() {
		return "tb_bookmark_Item";
	}

	@Override
	public String[] keyNames() {
		return new String[] { "uuid" };
	}

	public void moveToFolder(String folderUUID) throws AppException, Exception {
		update("folderuuid", folderUUID);
	}

	public String toHtml() {
		return "<DT><A HREF=\"" + url + "\">" + name + "</A>";
	}

	public void copyToFolder(String folderUUID) throws AppException, Exception {
		BmItem newItem = new BmItem();
		copyTo(newItem);
		newItem.setUuid(UUID.randomUUID().toString());
		newItem.setFolderUUID(folderUUID);
		newItem.create();
	}

	public static class X extends WpxMdo_X<BmItem> {

		public X() {
			super(BmItem.class);
		}

		//数据导入
		public void importBmItems(File csvFile) throws AppException, Exception  {
			Csv csv = new Csv(csvFile.getAbsolutePath(),"UTF-8");
			ArrayList<String[]> lines = csv.getLineList();
		
			for (String[] values : lines) {
				if(values.length != 4)
					continue;
				int i = 1;
				try{
					BmItem bi = new BmItem();
					bi.setName(values[0]);
					bi.setDescription(values[1]);
					bi.setUrl(values[2]);
					bi.setOwner(values[3]);
					
					//插入操作
					bi.create();
					
				}catch (Exception e) {
					Logger.error("import BmItem error : " + values[0]+","+ values[3]+"   " + e.getMessage());
					continue;
				}
				i++;
				
				if(i%500==0)
					Thread.sleep(3000);
			}
		}

		public File exportCSV(File file, String charset) throws AppException, Exception {
			String[] labels = new String[]{
				"组名","描述","地址","所有人"
			};
			
			Csv csv = new Csv(file.getAbsolutePath(), labels, charset);
			for(BmItem bi : this.findAll()){
				String[] values = new String[]{
					bi.name,
					bi.description,
					bi.url,
					bi.owner
				};
				
				csv.insert(values);
			}
			return file;
		}



	}

}
