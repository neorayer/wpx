package com.skymiracle.wpx.models.user;

import static com.skymiracle.wpx.Singletons.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skymiracle.auth.MailUser;
import com.skymiracle.csv.Csv;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.Base64Sky;
import com.skymiracle.util.CalendarUtil;
import com.skymiracle.util.Charset;
import com.skymiracle.wpx.models.domain.Domain;

public class User extends MailUser<User> {

	@Title("生日")
	private String birthday;

	private String c;

	private String cn;

	private String co;

	private String company;

	@Title("创建日期")
	private String createDate;

	@Title("姓名")
	private String displayName;

	@Title("工(学)号")
	private String employeeid;

	@Title("其它邮箱")
	private String otheremail;

	@Title("密码问题")
	private String pwdquestion;

	@Title("密码答案")
	private String pwdanswer;

	private String facsimileTelephoneNumber;

	@Title("家庭电话")
	private String homePhone;

	private String initials;

	private String l;

	@Title("")
	private String indexset;

	@Title("系统邮箱")
	private String mail;

	@Title("手机")
	private String mobile;

	@Title("MSN")
	private String msn;

	private String o;

	@Title("QQ")
	private String oicq;

	@Title("部门号")
	private String ou;

	private String pager;

	private String pauseCause;

	private String pauseTime;

	private String pc;

	private String pfax;

	@Title("电话")
	private String Phone;

	private String physicalDeliveryOfficeName;

	private String pl;

	private String postalAddress;

	private String postalCode;

	private String ppa;

	private String ppc;

	private String isproxy;

	private String pst;

	@Title("昵称")
	private String RDN;

	private String remark;

	@Title("性别")
	private String sex;

	@Title("姓")
	private String sn;

	@Title("名")
	private String givenName;

	private String st;

	private String telephoneNumber;

	private String title;

	private String URL;

	private String uuid;

	private String web;

	@Title("类型")
	@Desc("person:个人 | unit:单位")
	private String description;

	private String[] webFunction;

	@Title("管理者")
	private String employeeNumber;

	@Title("姓名拼音")
	private String spell;

	@Title("显示地址簿")
	@Desc("0:隐藏, 1:显示")
	private int isHide;

	@Title("排名")
	private int sortNum = 10000;

	private int groupSend = 0;// 0 代表普通用户，1代表组用户

	private static final String pattern = "yyyy-MM-dd";

	public static final String SAVE_TO_SENT = "1";

	public static final String SHOW = "1";

	public static final String HIDE = "0";

	@Title("上次登录时间")
	private String lasttime;

	@Title("身份证号")
	private String idCard;
	
	@Title("邮箱皮肤")
	private String skin = "1";
	
	public User() {
		super($User);
		SimpleDateFormat sdf = new SimpleDateFormat(User.pattern);
		this.setCreateDate(sdf.format(new Date()));
	}

	public User(String dc, String uid) {
		this();
		setDc(dc);
		setUid(uid);
	}

	@Override
	public String table() {
		return "tb_account";
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
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

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFacsimileTelephoneNumber() {
		return facsimileTelephoneNumber;
	}

	public void setFacsimileTelephoneNumber(String facsimileTelephoneNumber) {
		this.facsimileTelephoneNumber = facsimileTelephoneNumber;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getIndexset() {
		return indexset;
	}

	public void setIndexset(String index) {
		this.indexset = index;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getIsproxy() {
		return isproxy;
	}

	public void setIsproxy(String isproxy) {
		this.isproxy = isproxy;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getMail() {
		if(mail == null)
			mail = toEmail();
		
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

	public String getOtheremail() {
		return otheremail;
	}

	public void setOtheremail(String otheremail) {
		this.otheremail = otheremail;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}

	public String getPager() {
		return pager;
	}

	public void setPager(String pager) {
		this.pager = pager;
	}

	public String getPauseCause() {
		return pauseCause;
	}

	public void setPauseCause(String pauseCause) {
		this.pauseCause = pauseCause;
	}

	public String getPauseTime() {
		return pauseTime;
	}

	public void setPauseTime(String pauseTime) {
		this.pauseTime = pauseTime;
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
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
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

	public String getPwdanswer() {
		return pwdanswer;
	}

	public void setPwdanswer(String pwdanswer) {
		this.pwdanswer = pwdanswer;
	}

	public String getPwdquestion() {
		return pwdquestion;
	}

	public void setPwdquestion(String pwdquestion) {
		this.pwdquestion = pwdquestion;
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

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String[] getWebFunction() {
		return webFunction;
	}

	public void setWebFunction(String[] webFunction) {
		this.webFunction = webFunction;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public int getIsHide() {
		return isHide;
	}

	public void setIsHide(int isHide) {
		this.isHide = isHide;
	}

	public int getGroupSend() {
		return groupSend;
	}

	public void setGroupSend(int q) {
		this.groupSend = q;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public String getOuName() {
		if (this.ou.equals(""))
			return "";
		try {
			Dept dept = new Dept(this.dc, this.ou).load();
			return dept.getDescription();
		} catch (Exception e) {
			return "";
		}
	}

	public User create() throws AppException, Exception {
		//默认设置值
		{
			setDescription("person");
			setIspop3("1");
			setIssmtp("1");
			setIsproxy("0");
			setMaxcc((int)smtpConfiger.getDefaultUserMaxCc());
			setStorageLocation(mbapConfiger.getHost() + ":" + mbapConfiger.getPort());
			setStatus(User.STATUS_OPEN);
		}
		
		
		// 检验用户是否存在
		throwExists();

		// 检查：别名存在
		new UserAlias(dc, uid).throwExists();
		
		// 检查：群组用户存在
		new GrpUser(dc, uid).throwExists();
		
		// 载入：子邮局
		Domain domain = new Domain(dc).load();
		// 检查：子邮局空间
		if (domain.size < (domain.sizeLocate + this.size)) {
			throw new AppException("没有足够的域存储空间可分配");
		} else if (domain.userLocate >= domain.userMax) {
			throw new AppException("没有足够的域用户许可可分配");
		}
		
		//从域中获取缺省值
		{
			//自动保存已发送
			setSavenew(domain.getSavenew());
			if(messageSize <= 0) {
				setMessageSize(smtpConfiger.getMaxMessageSize());
			}
			// 公共通迅录
			try{
				setIsHide(Integer.parseInt(domain.getIsHidePubAddress()));
			}catch(Exception e) {
				setIsHide(0);
			}
		}
		
		// 设置：拼写属性
		String spell = Charset.utf8ToPinyin(displayName == null?toEmail(): displayName);
		setSpell(spell);

		// 部门用户数加1
		if (isDeptCountUpdate()) {
			Dept dept = new Dept(dc, ou);
			if (dept.exists()) {
				dept.countPlus(1);
			}
		}
		
		

		// 创建：自己
		User user =  super.create();
		
		// 修改：子邮局数据
		domain.reset();
		
		return user;
	}
	
	// 是否修改部门人数
	public boolean isDeptCountUpdate() {
		// 用户有部门，且在开通状态下, 且地址簿为显示
		return ou != null && !ou.equals("") && User.STATUS_OPEN.equals(status) && isHide == 1;
	}

	public User update(MdoMap mdoMap) throws AppException, Exception {
		load();
		// 处理：用户空间大小
		if (null != mdoMap.get("size")) {
			Domain domain = new Domain(dc).load();
			long newSize = (Long) mdoMap.get("size");
			long newDomainSizeLocate = domain.sizeLocate + newSize - this.size;
			// 检查：邮局空间
			if (domain.size < newDomainSizeLocate)
				throw new AppException("没有足够的域存储空间可分配");
			// 修改：邮局已分配空间
			domain.update("sizeLocate", newDomainSizeLocate);
		}

		// 设置：拼写属性
		String displayname = (String) mdoMap.get("displayname");
		if (null != displayname) {
			mdoMap.put("spell", Charset.utf8ToPinyin(displayname));
		}

		// 部门用户数变更
		{
			String old_ou = this.ou;
			String new_ou = (String) mdoMap.get("ou");
			String old_status = status;
			String new_status = (String) mdoMap.get("status");
			String old_ishide = this.isHide + "";
			String new_ishide = mdoMap.get("ishide") + "";

			// 部门或状态或地址簿显示必须有一个发生变更。
			if (new_ou != null || new_status != null || new_ishide != null) {
				if (new_ou == null)
					new_ou = old_ou;
				if (new_status == null)
					new_status = old_status;
				if (new_ishide == null)
					new_ishide = old_ishide;

				// 该用户原来有部门
				if (old_ou != null && !old_ou.equals("")) {
					// 且状态为开通，且地址簿为显示, 部门用户数减1
					if(User.STATUS_OPEN.equals(old_status) && "1".equals(old_ishide)) {
						Dept dept = new Dept(dc, old_ou);
						if (dept.exists()) {
							dept.countPlus(-1);
						}
					}
				}
				// 该用户现在有部门
				if (new_ou != null && !new_ou.equals("")) {
					// 且状态为开通，且地址簿为显示， 部门用户数加1
					if(User.STATUS_OPEN.equals(new_status) && "1".equals(new_ishide)) {
						Dept dept = new Dept(dc, new_ou);
						if (dept.exists()) {
							dept.countPlus(1);
						}
					}
				}
			}
		}

		// 修改：自己
		return super.update(mdoMap);
	}

	public void delete() throws AppException, Exception {
		// 载入：自己
		load();
		// 删除：别名
		new UserAlias(dc, uid).delete();
		// 修改：邮局属性
		Domain domain = new Domain(dc).load();
		domain.update("sizeLocate, userLocate", domain.sizeLocate - this.size,
				domain.userLocate - 1);

		// 部门用户数减1
		if (isDeptCountUpdate()) {
			Dept dept = new Dept(dc, ou);
			if (dept.exists()) {
				dept.countPlus(-1);
			}
		}

		// 删除：自己
		super.delete();
	}

	public static boolean isValidStatus(String status) {
		if ("open".equals(status) || "pause".equals(status)
				|| "closed".equals(status))
			return true;
		return false;
	}

	public User authMail(String remoteIP) throws AppException, Exception {
		return (User)WpxAuthMail.authMail(this.uid, this.dc, this.userPassword, User.class.getSimpleName(), remoteIP);
	}
	
	
	public String getDeptName() throws AppException, Exception {
		Dept dept = this.getDept();
		if(dept!=null)
			return dept.getDescription();
		return null;
	}

	public Dept getDept() throws AppException, Exception {
		MList<Dept> depts = $Dept.find("ou,domain", ou, dc);
		if(depts.size()> 0)
			return depts.getFirst();
		return null;
	}
	
	public String getSkinCode() {
		return $Skin.getSkin(skin).getCode();
	}
	

	public static class X extends MailUser.X<User> {
		
		
		public X() {
			super(User.class, appStore);
		}
		
		// 查找部门下的所有用户，包括子部门的用户
		public PagedList<User> getAllUsersByDept(Dept dept, String sortBy, boolean isAsc, int pagenum, int perpagecount) throws AppException, Exception {
			StringBuffer filter = new StringBuffer();
			filter.append("dc = '" + dept.getDomain() + "' and ou = '" + dept.getOu() + "'");
			List<String> childrenOus = $Dept.findChildrenOus(dept.getOu());
			for(String cou: childrenOus)
				filter.append(" or ou = '" + cou + "'");
			
			filter.insert(0, "(");
			filter.append(")");
			
			
			return $User.findPaged(new MdoMap(), filter.toString(), sortBy, isAsc, pagenum, perpagecount);
		}

//		public List<User> getCommonUsersOfDept(String dc, String depou)
//				throws AppException, Exception {
//			List<User> r = new MList<User>();
//			MdoMap das = new MdoMap();
//			das.put("dc", dc);
//			if (!"".equals(depou))
//				das.put("ou", depou);
//			List<User> list = $User.find(das, null, "sortNum", true, 0, 10000);
//			for (User user : list) {
//				if (user.getGroupSend() != 1)
//					r.add(user);
//			}
//			return r;
//		}

		//导出用户
		public File exportCSV(File file, String charset) throws AppException, Exception{
			String[] labels = new String[]{
				"用户名","域名","密码","真实姓名","公司名称","部门名称","性别","职务","大小"
			};
			
			Csv csv = new Csv(file.getAbsolutePath(), labels, charset);
			for(User user : this.findAll()){
				String[] values = new String[]{
					user.uid,
					user.dc,
					user.userPassword,
					user.displayName,
					user.company,
					user.getDeptName(),
					user.sex,
					user.title,
					user.size+""
				};
				csv.insert(values);
			}
			return file;
		}
		
		//导入用户
		public void importUsers(File csvFile) throws AppException, Exception{
			Csv csv = new Csv(csvFile.getAbsolutePath(),"UTF-8");
			ArrayList<String[]> lines = csv.getLineList();
		
			for (String[] values : lines) {
				User user = new User();
				if(values.length != 9)
					continue;
				int i =0 ;
				try {
					//用户名
					String uid = values[0]; 
					user.setUid(uid);
					//域名
					String dc =values[1]; 
					user.setDc(dc);
					//密码
					{
						String password = values[2];
						if(password.indexOf("{")==-1)
							password = Base64Sky.encodeToPassword(password,"UTF-8");
						user.setUserPassword(password);
					}
					//真实姓名
					user.setDisplayName(values[3]);
					//公司名称
					user.setCompany(values[4]);
					//部门名称
					{
						String deptName = values[5];
						MList<Dept> depts = $Dept.find("description,domain", deptName, dc);
						if(depts.size()>0)
							user.setOu(depts.getFirst().getOu());
					}
					//性别
					user.setSex(values[6]);
					//职务
					user.setTitle(values[7]);
					//大小
					user.setSize(Long.parseLong(values[8]));
					
					
					user.create();
					
				}catch (Exception e) {
					Logger.error("import User error :"  + values[0]+","+values[1] + " " + e.getMessage());
					continue;
				}
				i++;
				
				if(i%500==0)
					Thread.sleep(3000);
			}
			
			Thread.sleep(3000);
			//进行域数据统计
			$Domain.resetAll();
			
			Thread.sleep(3000);
			//进行部门数据统计
			$Dept.resetAll();
			
		}

		// 某部门那些显示的用户数
		public long countShowingOfDept(Dept dept)throws AppException, Exception{
			return $User.count("dc, ou, status, ishide", dept.getDomain(),dept.getOu(), "open", 1);
		}
	}


	private boolean hasKnowIsGroupUser = false;
	private boolean isGroupUser = false;
	@Override
	public boolean isGroupUser() throws AppException, Exception {
		if (hasKnowIsGroupUser)
			return isGroupUser;
		
		hasKnowIsGroupUser = true;
		if (this.exists())
			return false;
		
		return new GrpUser(dc, uid).exists();
	}


}
