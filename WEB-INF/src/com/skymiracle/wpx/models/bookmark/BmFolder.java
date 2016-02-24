package com.skymiracle.wpx.models.bookmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.skymiracle.csv.Csv;
import com.skymiracle.io.StreamPipe;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.user.User;

import static com.skymiracle.wpx.Singletons.*;

/**
 * 书签文件夹
 */
public class BmFolder extends WpxMdo<BmFolder> {

	public String uuid = UUID.randomUUID().toString();
	
	public String parentUUID;
	
	// 文件夹名
	public String name;
	
	// 描述
	public String description;
	
	public String publictag; // private / public
	
	// 用户
	public String owner;

	public BmFolder() {
		super($BmFolder);
	}

	public BmFolder(String uuid) {
		this();
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getParentUUID() {
		return parentUUID;
	}

	public void setParentUUID(String parentUUID) {
		this.parentUUID = parentUUID;
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

	public String getPublictag() {
		return publictag;
	}

	public void setPublictag(String publictag) {
		this.publictag = publictag;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String table() {
		return "tb_bookmark_Folder";
	}

	@Override
	public String[] keyNames() {
		return new String[] { "uuid" };
	}

	@Override
	public void delete() throws AppException, Exception {
		$BmItem.find("folderuuid", this.uuid).delete();
		$BmFolder.find("parentuuid", this.uuid).delete();
		super.delete();
	}
	
	public MList<BmItem> getItems() throws AppException, Exception {
		return $BmItem.find("folderuuid", this.uuid);
	}
	
	public MList<BmFolder> getSubs() throws AppException, Exception {
		return $BmFolder.find("parentuuid", this.uuid);
	}

	public String toHtml() throws AppException, Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("<DT><H3 FOLDED>" + name + "</H3>");
		sb.append("<DL><p>");
		for (BmItem item : getItems()) 
			sb.append(item.toHtml());
		for (BmFolder folder : getSubs()) 
			sb.append(folder.toHtml());
		
		sb.append("</DL><p>");
		return sb.toString();
	}


	public static class X extends WpxMdo_X<BmFolder> {

		public X() {
			super(BmFolder.class);
		}

		//客户端导出
		public void export(User owner, String folderUUID, File file) throws AppException, Exception {

			StringBuffer sb = new StringBuffer();
			sb.append("<!DOCTYPE NETSCAPE-Bookmark-file-1>\r\n"
					+ "<!-- This is an automatically generated file."
					+ "It will be read and overwritten. Do Not Edit! -->\r\n"
					+ "<TITLE>Bookmarks</TITLE>\r\n" + "<H1>Bookmarks</H1>\r\n"
					+ "<DL><p>\r\n");
			if (folderUUID.equals("")) {
				for(BmFolder folder: $BmFolder.find("owner, uuid", owner.toEmail(), "")) {
					sb.append(folder.load().toHtml());
				}
			}else {
				sb.append(new BmFolder(folderUUID).load().toHtml());
			}
			
			sb.append("</DL><p>");
			StreamPipe.stringToFile(sb.toString(),file, "UTF-8");
		}

		//客户端导入
		public void imports(File file, User actor, String folderuuid) throws AppException, Exception {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(read);
			String data = null;
			boolean firstLine = true;
			List<String> bookmarkTextList = new ArrayList<String>();
			while ((data = br.readLine()) != null) {
				if (firstLine && !data.startsWith("<!DOCTYPE NETSCAPE-Bookmark-file-1>")) {
					firstLine = false;
				}
				bookmarkTextList.add(data);
			}
	
			List addList = parseBookmark(bookmarkTextList, actor, folderuuid);
			if (addList != null) {
				for (Object o : addList) {
					if (o instanceof BmFolder) {
						((BmFolder)o).create();
					} else if (o instanceof BmItem) {
						((BmItem)o).create();
					}
				}
			}
			
		}
		
		private Element makeElement(String elementText) {
			Element element = null;
			Document document = DocumentHelper.createDocument();
			String xml = document.asXML();
			xml += "<bookmarks>";
			xml += elementText;
			xml += "</bookmarks>";
			try {
				document = DocumentHelper.parseText(xml);
				Element root = document.getRootElement();
				for (Iterator i = root.elementIterator(); i.hasNext();) {
					element = (Element) i.next();
				}
			} catch (Exception ex) {
				return null;
			}

			return element;
		}
		
		private List parseBookmark(List<String> bookmarkTextList, User actor, String folderuuid) {
			List addList = new ArrayList();
			List<String> parentFolderUUIDList = new ArrayList<String>();
			parentFolderUUIDList.add(folderuuid);
			for (String data : bookmarkTextList) {
				String strContent = data.trim();
				try {
					if (strContent.startsWith("<DT>")) {
						strContent = strContent.substring("<DT>".length());
						strContent = strContent.replaceAll("&", "@!@");
						if (strContent.startsWith("<A")) {
							Element element = makeElement(strContent);
							if(element!=null){
								Attribute attr = element.attribute("HREF");
		
								BmItem item = new BmItem();
								item.setUrl(attr.getValue().replaceAll("@!@", "&"));
								item.setName(element.getText().replaceAll("@!@", "&"));
								item.setFolderUUID(folderuuid);
								item.setOwner(actor.toEmail());
								//TODO
								addList.add(item);
							}
						} else if (strContent.startsWith("<H3")) {
							strContent = strContent.replaceAll("FOLDED", "FOLDED=\"true\"");
							Element element = makeElement(strContent);
							if(element!=null){
								BmFolder folder = new BmFolder();
								folder.setName(element.getText().replaceAll("@!@", "&"));
								folder.setOwner(actor.toEmail());
								//TODO
								addList.add(folder);
								
								folderuuid = folder.getUuid();
								parentFolderUUIDList.add(folderuuid);
							}
						}

					} else if (strContent.startsWith("</DL>")) {
						if (parentFolderUUIDList.size() > 1) {
							parentFolderUUIDList.remove(parentFolderUUIDList.size() - 1);
							folderuuid = parentFolderUUIDList.get(parentFolderUUIDList.size() - 1);
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					 System.out.println(strContent);
					return null;
				}
			}

			return addList;
		}
		//数据导入
		public void importBmForders(File csvFile) throws AppException, Exception  {
			Csv csv = new Csv(csvFile.getAbsolutePath(),"UTF-8");
			ArrayList<String[]> lines = csv.getLineList();
		
			for (String[] values : lines) {
				if(values.length != 3)
					continue;
				int i = 1;
				try{
					BmFolder bf = new BmFolder();
					bf.setName(values[0]);
					bf.setDescription(values[1]);
					bf.setOwner(values[2]);
					
					//插入操作
					bf.create();
					
				}catch (Exception e) {
					Logger.error("import BmFolder error : " + values[0]+","+ values[2]+"   " + e.getMessage());
					continue;
				}
				i++;
				
				if(i%500==0)
					Thread.sleep(3000);
			}
		}

		public File exportCSV(File file, String charset) throws AppException, Exception {
			String[] labels = new String[]{
				"组名","描述","所有人"
			};
			
			Csv csv = new Csv(file.getAbsolutePath(), labels, charset);
			for(BmFolder bf : this.findAll()){
				String[] values = new String[]{
					bf.name,
					bf.description,
					bf.owner
				};
				
				csv.insert(values);
			}
			return file;
		}

	}
}
