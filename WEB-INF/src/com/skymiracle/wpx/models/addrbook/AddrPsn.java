package com.skymiracle.wpx.models.addrbook;


import static com.skymiracle.wpx.Singletons.*;
import static com.skymiracle.wpx.Singletons.$Domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.skymiracle.csv.Csv;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.Mdo.Title;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.Charset;
import com.skymiracle.util.StringUtils;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import com.skymiracle.wpx.models.WpxUuidMdo;
import com.skymiracle.wpx.models.addrbook.importers.FoxmailAddrImporter;
import com.skymiracle.wpx.models.addrbook.importers.OutlookAddrImporter;
import com.skymiracle.wpx.models.addrbook.importers.WpxAddrImporter;
import com.skymiracle.wpx.models.user.User;

@Title("私人通迅录")
public class AddrPsn extends WpxUuidMdo<AddrPsn>{
	
	@Title("邮件地址")
	private String mail;
	
	private String comeGo;
	
	@Title("所有人")
	private String owner;

	@Title("组ID")
	private String groupId;	//NONE

	private String sn;

	private String givenName;

	@Title("真实姓名")
	private String displayName;

	@Title("真实姓名拼音")
	private String spell;

	private String cn;

	private String initials;

	private String RDN;

	private String c;

	private String co;

	private String st;

	private String l;

	private String postalAddress;

	private String postalCode;

	@Title("单位名称")
	private String company;

	@Title("部门名称")
	private String ou;

	private String o;	//NUNE

	private String employeeid;

	@Title("职务")
	private String title;

	private String physicalDeliveryOfficeName;

	private String URL;

	@Title("电话")
	private String telephonenumber;

	@Title("电话")
	private String phone;

	private String facsimiletelephonenumber;

	private String homePhone;

	@Title("手机")
	private String mobile;

	private String pager;

	private String web;

	private String msn;

	private String oicq;

	private String pc;

	private String pst;

	private String pl;

	private String ppa;

	private String ppc;

	private String pfax;

	private String remark;

	private String sex;

	private String birthday;
	
	@Title("等级")
	private int rank; //NONE
	
	public static final String OPERATION_ADD = "add";
	
	public static final String OPERATION_MOD = "mod";
	
	public static final String OPERATION_DETAIL = "detail";

	public String getComeGo() {
		return comeGo;
	}

	public void setComeGo(String comeGo) {
		this.comeGo = comeGo;
	}

	public AddrPsn(){
		super($AddrPsn);
	}
	
	public AddrPsn(String uuid){
		this();
		setUuid(uuid);
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
		try {
			setSpell(Charset.utf8ToPinyin(displayName));
		} catch (IOException e) {
			Logger.warn("", e);
			setSpell(displayName);
		}
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getFacsimiletelephonenumber() {
		return facsimiletelephonenumber;
	}

	public void setFacsimiletelephonenumber(String facsimiletelephonenumber) {
		this.facsimiletelephonenumber = facsimiletelephonenumber;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		this.o = o;
	}

	public String getOicq() {
		return oicq;
	}

	public void setOicq(String oicq) {
		this.oicq = oicq;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getPfax() {
		return pfax;
	}

	public void setPfax(String pfax) {
		this.pfax = pfax;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhysicalDeliveryOfficeName() {
		return physicalDeliveryOfficeName;
	}

	public void setPhysicalDeliveryOfficeName(String physicalDeliveryOfficeName) {
		this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPpa() {
		return ppa;
	}

	public void setPpa(String ppa) {
		this.ppa = ppa;
	}

	public String getPpc() {
		return ppc;
	}

	public void setPpc(String ppc) {
		this.ppc = ppc;
	}

	public String getPst() {
		return pst;
	}

	public void setPst(String pst) {
		this.pst = pst;
	}

	public String getRDN() {
		return RDN;
	}

	public void setRDN(String rdn) {
		RDN = rdn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getTelephonenumber() {
		return telephonenumber;
	}

	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String url) {
		URL = url;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Override
	public String table() {
		return "tb_addressbook_person";
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void moveTo(AddrGrp addrGrp) throws AppException, Exception {
		update("groupid", addrGrp.getUuid());
	}
	
	public AddrPsn create() throws AppException, Exception {
		if($AddrPsn.count("groupId, owner, mail", groupId, owner, mail)>0)
			throw new AppException("该邮件地址已存在！");
		
		super.create();
		if(groupId !=null && !groupId.equals(""))
			new AddrGrp(groupId).incCount();
		
		return this;
	}
	
	public static class  X extends WpxMdo_X<AddrPsn> {

		public X() {
			super(AddrPsn.class);
		}

		public void importCsv(User owner, File file, String groupId) throws AppException, Exception {
			Csv csv = new  Csv(file.getAbsolutePath(),  "GBK");
			csv.load();
			String[] labels = csv.getLabels();
			ArrayList<String[]> lines = csv.getLineList();
			AddrImporter importer = new WpxAddrImporter();
			if (StringUtils.isIncluded(labels, "公司所在地的邮政编码"))
				importer = new OutlookAddrImporter();
			else if (StringUtils.isIncluded(labels, "家庭传真"))
				importer = new FoxmailAddrImporter();
			
			MList<AddrPsn> psns = new MList<AddrPsn>();
			for(AddrPsn psn: importer.getPsns(labels, lines)) {
				if (maybeExists(owner, groupId, psn.displayName, psn.mail))
					continue;
				psn.setOwner(owner.toEmail());
				psn.setGroupId(groupId);
				psn.setUuid(UUID.randomUUID().toString());
				psns.add(psn);
			}
			psns.createIfNotExist();
		}
		
		public boolean maybeExists(User owner, String groupid, String displayName, String mail) throws AppException, Exception {
			MdoMap mdoMap =new MdoMap();
			mdoMap.put("owner", owner.toEmail());
			mdoMap.put("groupid", groupid);
			mdoMap.put("displayname", displayName);
			mdoMap.put("mail", mail);
			return this.count(mdoMap) > 0;
		}

		public void moveTo(String[] uuids, String groupid) throws AppException, Exception {
			for(String uuid :uuids){
				AddrPsn psn =new AddrPsn(uuid).load();
				String oldou = psn.getGroupId();
				
				psn.update("groupId", groupid);
				new AddrGrp(groupid).incCount();

				if(oldou!=null && !oldou.equals(""))
					new AddrGrp(oldou).decCount();
				
			}
		}

		public void del(String[] uuids) throws AppException, Exception {
			for(String uuid :uuids){
				AddrPsn psn =new AddrPsn(uuid).load();
				if(psn.getGroupId()!=null && !psn.getGroupId().equals(""))
					new AddrGrp(psn.getGroupId()).decCount();
				psn.delete();
			}
		}

		//导入数据
		public void importPsns(File csvFile)throws AppException, Exception {
			Csv csv = new Csv(csvFile.getAbsolutePath(),"UTF-8");
			ArrayList<String[]> lines = csv.getLineList();
		
			for (String[] values : lines) {
				if(values.length != 9)
					continue;
				int i = 1;
				try{
					AddrPsn psn = new AddrPsn();
					//组名
					psn.setGroupId(values[0]);
					psn.setOwner(values[1]);
					psn.setMail(values[2]);
					psn.setDisplayName(values[3]);
					psn.setCompany(values[4]);
					psn.setOu(values[5]);
					psn.setTitle(values[6]);
					psn.setPhone(values[7]);
					psn.setMobile(values[8]);
					
					//插入操作
					psn.insert();
					
				}catch (Exception e) {
					Logger.error("import AddrPsn error : " + values[0]+","+ values[1]+"   " + e.getMessage());
					continue;
				}
				i++;
				
				if(i%500==0)
					Thread.sleep(3000);
			}
			
			//进行部门数据统计
			$AddrGrp.resetAll();
		}

		public File exportCSV(File file, String charset) throws AppException, Exception {
			String[] labels = new String[]{
				"组ID","所有人","邮件地址","真实姓名","单位名称","部门名称","职务","电话","手机"
			};
				
			Csv csv = new Csv(file.getAbsolutePath(), labels, charset);
			for(AddrPsn psn : this.findAll()){
				String[] values = new String[]{
					psn.groupId,
					psn.owner,
					psn.mail,
					psn.displayName,
					psn.company,
					psn.ou,
					psn.title,
					psn.phone,
					psn.mobile
				};
				csv.insert(values);
			}
			return file;
		}
		
	}
	//导入时插入操作
	public void insert() throws AppException, Exception {
		if($AddrPsn.count("groupId, owner, mail", groupId, owner, mail)>0)
			throw new AppException("该邮件地址已存在！");
		
		super.create();
	}
}
