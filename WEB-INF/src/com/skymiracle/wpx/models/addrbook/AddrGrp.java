package com.skymiracle.wpx.models.addrbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.skymiracle.csv.Csv;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.Mdo.Title;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;
import com.skymiracle.wpx.models.domain.Domain;

import static com.skymiracle.wpx.Singletons.*;

@Title("私人通迅录组")
public class AddrGrp extends WpxUuidMdo<AddrGrp>{

	@Title("组名")
	public String groupName;

	@Title("所有人")
	public String owner;

	public String parentUUID;

	@Title("描述")
	public String description;

	@Title("")
	public String spell;
	
	public String symbol;
	
	@Title("联系人数")
	public long count = 0;
	
	public AddrGrp() {
		super($AddrGrp);
	}
	
	public AddrGrp(String uuid) {
		this();
		setUuid(uuid);
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getParentUUID() {
		return parentUUID;
	}

	public void setParentUUID(String parentUUID) {
		this.parentUUID = parentUUID;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
//	public long getCount() throws AppException, Exception {
//		return $AddrPsn.count("groupId", uuid);
//		
//	}
	@Override
	public String table() {
		return "tb_addressbook_group";
	}

	@Override
	public void delete() throws AppException, Exception {
		$AddrPsn.find("groupid", uuid).delete();
		$AddrGrp.find("parentuuid", uuid).delete();
		super.delete();
	}
	

	public MList<AddrGrp> getParents() throws AppException, Exception {
		MList<AddrGrp> grps = new MList<AddrGrp>();

		AddrGrp curGrp = this;
		for(int i=0; i< 50; i++) {
			AddrGrp parent = curGrp.getParent();
			if (parent == null)
				break;
			grps.addFirst(parent);
			curGrp = parent;
		}
		
		return grps;
	}
	
	public AddrGrp getParent() throws AppException, Exception {
		if (parentUUID == null || parentUUID.length() == 0)
			return null;
		return new AddrGrp(parentUUID).load();
	}
	
	public void decCount() throws AppException, Exception {
		this.load();
		if(count-1>=0)
			this.update("count", count-1);
	}
	public void incCount() throws AppException, Exception {
		this.load();
		this.update("count", count+1);
	}
	
	public static class X extends WpxMdo_X<AddrGrp> {

		public X() {
			super(AddrGrp.class);
		}
		
		//导出数据
		public File exportCSV(File file, String charset) throws AppException, Exception {
			String[] labels = new String[]{
				"ID","组名","所有人"
			};
			
			Csv csv = new Csv(file.getAbsolutePath(), labels, charset);
			for(AddrGrp grp : this.findAll()){
				String[] values = new String[]{
					grp.uuid,
					grp.groupName,
					grp.owner
				};
				csv.insert(values);
			}
			return file;
		}
		
		public void importGrps(File csvFile)throws AppException, Exception {
			Csv csv = new Csv(csvFile.getAbsolutePath(),"UTF-8");
			ArrayList<String[]> lines = csv.getLineList();
		
			for (String[] values : lines) {
				if(values.length != 3)
					continue;
				int i = 1;
				try{
					AddrGrp grp = new AddrGrp(values[0]);
					//组名
					String groupName = values[1];
					grp.setGroupName(groupName);
					//所有人
					String owner = values[2];
					grp.setOwner(owner);
					
					// 
//					grp.setParentUUID(values[3]);
					
					//
//					grp.setDescription(values[4]);
					
					
					//插入操作
					if(!grp.exists())
						grp.create();
					
				}catch (Exception e) {
					Logger.error("import AddrGrp error : " + values[0]+","+ values[1]+"  " + e.getMessage());
					continue;
				}
				i++;
				
				if(i%500==0)
					Thread.sleep(3000);
			}
		}

		
		public void resetAll() throws AppException, Exception {
			for (AddrGrp grp: this.findAll()) {
				grp.reset();
			}
		}
	}

	public void reset() throws AppException, Exception {
		update("count", $AddrPsn.count("groupId", this.uuid));
	}

}
