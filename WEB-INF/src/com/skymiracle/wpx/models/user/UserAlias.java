package com.skymiracle.wpx.models.user;

import java.io.File;
import java.util.ArrayList;

import com.skymiracle.csv.Csv;
import com.skymiracle.logger.Logger;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.addrbook.AddrGrp;

import static com.skymiracle.wpx.Singletons.*;

public class UserAlias extends WpxMdo<UserAlias> {

	@Title("别名")
	public String uid;

	@Title("域名")
	public String dc;

	@Title("别名对象")
	public String aliasedObjectName;

	public String getAliasedObjectName() {
		return aliasedObjectName;
	}

	public UserAlias() {
		super($UserAlias);
	}

	public UserAlias(String dc, String uid) {
		this();
		setDc(dc);
		setUid(uid);
	}

	public void setAliasedObjectName(String aliasedObjectName) {
		this.aliasedObjectName = aliasedObjectName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String[] keyNames() {
		return new String[] { "uid", "dc" };
	}

	@Override
	public String table() {
		return "tb_userAlias";
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public UserAlias create() throws AppException, Exception {
		new User(dc, uid).throwExists();
		// 检查：群组用户存在
		new GrpUser(dc, uid).throwExists();

		return super.create();
	}

	public static class X extends WpxMdo_X<UserAlias> {

		public X() {
			super(UserAlias.class);
		}

		//数据导入
		public void importPsns(File csvFile) throws AppException, Exception  {
			Csv csv = new Csv(csvFile.getAbsolutePath(),"UTF-8");
			ArrayList<String[]> lines = csv.getLineList();
		
			for (String[] values : lines) {
				if(values.length != 3)
					continue;
				int i = 1;
				try{
					UserAlias alias = new UserAlias();
					alias.setUid(values[0]);
					alias.setDc(values[1]);
					alias.setAliasedObjectName(values[2]);
					
					//插入操作
					alias.create();
					
				}catch (Exception e) {
					Logger.error("import UserAlias error : " + values[0]+","+ values[0]+"   " + e.getMessage());
					continue;
				}
				i++;
				
				if(i%500==0)
					Thread.sleep(3000);
			}
		}

		public File exportCSV(File file, String charset) throws AppException, Exception {
			String[] labels = new String[]{
				"别名","域名","别名对象"
			};
			
			Csv csv = new Csv(file.getAbsolutePath(), labels, charset);
			for(UserAlias alias : this.findAll()){
				String[] values = new String[]{
					alias.uid,
					alias.dc,
					alias.aliasedObjectName
				};
				
				csv.insert(values);
			}
			return file;
		}

	}

}
