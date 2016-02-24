package com.skymiracle.wpx.controllers.a;

import java.util.List;

import com.skymiracle.auth.Password;
import com.skymiracle.logger.Logger;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.Base64Sky;
import com.skymiracle.util.UUID;
import com.skymiracle.validate.ValidateException;
import com.skymiracle.wpx.models.admin.DomainAdmin;
import com.skymiracle.wpx.models.domain.*;
import com.skymiracle.wpx.models.log.SysLog;
import com.skymiracle.wpx.models.mail.MailFolder;
import com.skymiracle.wpx.models.user.*;
import com.skymiracle.wpx.util.ByteTools;

import static com.skymiracle.wpx.Singletons.*;

@Sessioned
public class UserCtr extends Ctr {

	// 精确查询
	private static final int Search_Exact = 1;

	// 模糊查询
	private static final int Search_Vague = 1;

	@Layout("NOT")
	public void main() {
	}

	@Layout("NOT")
	public void left() throws AppException, Exception {
		List<Domain> domains = actor.listDomains();
		r.putMap("domains", domains);
	}

	@Layout("NOT")
	public void grpUsers() throws AppException, Exception {
		String dc = $("dc");
		r.putColl($GrpUser.find("dc", dc));
	}

	public void grpMembers() throws AppException, Exception {
		String grpUid = $("parent_uid");
		GrpUser grpUser = new GrpUser($("dc"), grpUid).load();
		r.putColl(grpUser.getMembers());
	}

	public void grpMemberAdd() throws AppException, Exception {
		String grpUid = $("parent_uid");
		String memberUid = $("uid").trim();
		String dc = $("dc");
		GrpUserMember member = new GrpUserMember(dc, grpUid, memberUid)
				.create();
		r.setMdo(member.getUser());
	}

	public void grpMemberDel() throws AppException, Exception {
		String grpUid = $("parent_uid");
		String[] memberUids = $$("uid");
		String dc = $("dc");
		for (String memberUid : memberUids)
			new GrpUserMember(dc, grpUid, memberUid).delete();
	}

	public void grpMemberAddFromDept() throws AppException, Exception {
		String grpUid = $("grpuid");
		String dc = $("dc");
		String ou = $("ou");

		Dept dept = new Dept(dc, ou).load();
		MList<User> users = dept.getAllUsers();
		for (User user : users) {
			GrpUserMember member = new GrpUserMember(dc, grpUid, user.getUid());
			member.createIfNotExist();
		}
	}

	public void grpMemberAddAll() throws AppException, Exception {
		String grpUid = $("grpuid");
		String dc = $("dc");

		MList<User> users = $User.find("dc", dc);
		for (User user : users) {
			GrpUserMember member = new GrpUserMember(dc, grpUid, user.getUid());
			member.createIfNotExist();
		}
	}

	public void grpMemberAddNoDept() throws AppException, Exception {
		String grpUid = $("grpuid");
		String dc = $("dc");

		MList<User> users = $User.find("dc", dc);
		for (User user : users) {
			if (user.getOu() == null || user.getOu().length() == 0) {
				GrpUserMember member = new GrpUserMember(dc, grpUid,
						user.getUid());
				member.createIfNotExist();
			}
		}
	}

	public void grpUserAdd() throws AppException, Exception {
		GrpUser grpUser = $M(GrpUser.class);
		r.setMdo(grpUser.create());
	}

	public void grpUserMod() throws AppException, Exception {
		GrpUser grpUser = $M(GrpUser.class).load();
		MdoMap modify = new MdoMap();
		modify.put("name", $("name"));

		grpUser.update(modify);

		r.setMdo(grpUser.load());
	}

	public void grpUserDel() throws AppException, Exception {
		GrpUser grpUser = $M(GrpUser.class);
		grpUser.delete();
	}

	@Layout("NOT")
	public void domainUsers() throws AppException, Exception {
		String dc = $("dc");
		String depou = $("depou", "");

		Domain domain = new Domain(dc).load();

		r.putMap("dc", dc);
		r.putMap("depou", depou);
		r.putMap("attsize", ByteTools.byteToM(domain.attachmentSize));
		r.putMap("userstoragesize", ByteTools.byteToM(domain.defaultboxsize));

		// 存储服务器IP
		r.putMap("storageIP", mbapConfiger.getHost());
		// 存储服务器Port
		r.putMap("storagePort", mbapConfiger.getPort());

		// 最大发送人数
		r.putMap("defaultusermaxcc", smtpConfiger.getDefaultUserMaxCc());
		// 最大邮件大小
		r.putMap("messagesize",
				ByteTools.byteToM(smtpConfiger.getMaxMessageSize()));

		MdoMap mm = new MdoMap();
		mm.put("domain", dc);

		r.putMap("deptTreeStr", $Dept.getDeptTreeMapJSON(mm).toString());
		r.putMap("deplist", $Dept.getSafeDepts(mm));
	}

	//
	public void users() throws AppException, Exception {
		String depou = $("depou", "");
		String dc = $("dc");
		String sortBy = $("sortby", "sortNum");
		boolean isAsc = $b("sortup", true);
		MdoMap mm = $MM(User.class);
		mm.put("dc", dc);
		StringBuffer filter = new StringBuffer();
		if (!depou.equals("")) {
			filter.append("ou = '" + depou + "'");
			List<String> childrenOus = $Dept.findChildrenOus(depou);
			for (String cou : childrenOus)
				filter.append(" or ou = '" + cou + "'");

			filter.insert(0, "(");
			filter.append(")");
		}
		PagedList<User> list = $User.findPaged(mm, filter.toString(), sortBy,
				isAsc, $i("pagenum", 1), $i("perpagecount", 15));
		for (User user : list) {
			// if(user.getUserPassword().indexOf("{skyenc}")!=-1){
			// user.setUserPassword(Base64Sky.decodePassword(user.getUserPassword().substring(8)));
			// }
			user.setSize(ByteTools.byteToM(user.getSize()));
			user.setMessageSize(ByteTools.byteToM(user.getMessageSize()));
		}
		r.putColl(list);
	}

	public void user_add() throws AppException, Exception {
		User user = $M(User.class);

		// 密码加密
		user.setUserPassword(Base64Sky.encodeToPassword(user.getUserPassword(),
				"UTF-8"));

		user.setMessageSize(ByteTools.mToByte(user.getMessageSize()));
		user.setSize(ByteTools.mToByte(user.getSize()));
		user.setSpaceAlert(user.getSize() * 9 / 10);
		user.setUuid(new UUID().toShortString());
		user.setMail(user.getUid() + "@" + user.getDc());
		String depou = $("depou", "");
		if (!depou.equals("")) {
			user.setOu(depou);
		}

		user.create();
		SysLog.width(actor).addUser(user.getUid(), user.getDc());

		user.setMessageSize(ByteTools.byteToM(user.getMessageSize()));
		user.setSize(ByteTools.byteToM(user.getSize()));

		r.setMdo(user);
	}

	public void users_del() throws AppException, Exception {
		String dc = $("dc");
		String[] uids = $$("uid");
		for (String uid : uids) {
			User user = new User(dc, uid);
			user.delete();
			SysLog.width(actor).delUser(uid, dc);
		}
	}

	public void user_mod() throws AppException, Exception {
		MdoMap mdoMap = $MM(User.class);
		if ($has("size"))
			mdoMap.put("size", ByteTools.mToByte($l("size")));
		if ($has("messagesize"))
			mdoMap.put("messageSize", ByteTools.mToByte($l("messagesize")));
		// 密码加密
		String userpassword = $("userpassword", "");
		if (!userpassword.equals("") && !new Password(userpassword).isCrypt()) {
			mdoMap.put("userpassword",
					Base64Sky.encodeToPassword(userpassword, "UTF-8"));
		}

		User user = new User($("dc"), $("uid")).update(mdoMap);
		SysLog.width(actor).modUser(user.getUid(), user.getDc());

		user.load();

		user.setMessageSize(ByteTools.byteToM(user.getMessageSize()));
		user.setSize(ByteTools.byteToM(user.getSize()));
		// if(user.getUserPassword().indexOf("{skyenc}")!=-1){
		// user.setUserPassword(Base64Sky.decodePassword(user.getUserPassword().substring(8)));
		// }

		r.setMdo(user);
	}

	public void userStatus_mod() throws AppException, Exception {
		String status = $("status", "");
		String ishide = $("ishide", "");
		String[] uids = $$("uid");
		String dc = $("dc");

		if (!status.equals("")) {
			if (!User.isValidStatus(status))
				throw new AppException("不能修改状态。 原因： 状态值错误");
			for (String uid : uids) {
				User user = new User(dc, uid);
				if (user.exists()) {
					user.load();
					if ((user.getStatus()).equals(status))
						continue;

					MdoMap mm = new MdoMap();
					mm.put("status", status);
					user.update(mm);
					SysLog.width(actor).modUserStatus(uid, dc, status);
				}
			}
		} else if (!ishide.equals("")) {
			if (!User.HIDE.equals(ishide) && !User.SHOW.equals(ishide))
				throw new AppException("不能修改用户地址簿状态。 原因： 状态值错误");
			for (String uid : uids) {
				User user = new User(dc, uid);
				if (user.exists()) {
					user.load();
					if ((user.getIsHide() + "").equals(ishide))
						continue;
					MdoMap mm = new MdoMap();
					mm.put("ishide", ishide);
					user.update(mm);
					SysLog.width(actor).modUserAddrBookStatus(uid, dc, ishide);
				}
			}
		}
	}

	public void moveUser() throws AppException, Exception {
		String dc = $("dc");
		String ou = $("ou");
		String[] uids = $$("uid");

		for (String uid : uids) {
			User user = new User(dc, uid);
			MdoMap mm = new MdoMap();
			mm.put("ou", ou);
			user.update(mm);
			SysLog.width(actor).modUser(uid, dc);
		}
	}

	public void aliases() throws AppException, Exception {
		r.putColl($UserAlias.find("aliasedobjectname", $("aliasedobjectname")));
	}

	public void alias_add() throws AppException, Exception {
		UserAlias userAlias = new UserAlias();
		userAlias.uid = $("aliasUid");
		userAlias.dc = $("dc");
		userAlias.aliasedObjectName = $("uid") + '@' + $("dc");

		r.setMdo(userAlias.create());
	}

	public void aliases_del() throws AppException, Exception {
		$$M(UserAlias.class, "dc", "uid").delete();
	}

	public void users_search() throws AppException, Exception {

		String dc = $("dc");
		int findtype = $i("findtype", Search_Exact);
		String elementName = $("search");
		String elementValue = $("textvalue", "");

		System.out.println($$("pagenum").length);
		if ($$("pagenum").length > 0 && !elementValue.equals("")) {
			// TODO ？？？ 此处把参数转为GB2312编码，
			// IE下不会乱码，但是FF下就不行。
			elementValue = new String(elementValue.getBytes("iso8859-1"),
					"utf-8");
		}

		MdoMap mm = new MdoMap();
		mm.put("dc", $("dc"));
		StringBuffer filter = new StringBuffer();
		// 部门
		if ("description".equals(elementName)) {
			if (findtype == Search_Exact) {
				Dept dept = $Dept.getDept(dc, elementValue);
				mm.put("ou", dept.getOu());
			} else {
				List<Dept> depts = $Dept.getSearchDept(dc, elementValue);
				if (depts.size() > 0) {
					filter.append(" ou in (");
					for (Dept dept : depts) {
						filter.append("'").append(dept.getOu()).append("',");
					}
					filter.deleteCharAt(filter.length() - 1);
				}
				filter.append(" )");
			}
		} else {
			if (!elementValue.equals("")) {
				if (findtype == Search_Exact)
					mm.put(elementName, elementValue);
				else {
					filter.append(elementName + " like '%")
							.append(elementValue).append("%'");
				}
			}
		}

		PagedList<User> list = $User.findPaged(mm, filter.toString(),
				"sortNum", true, $i("pagenum", 1), $i("perpagecount", 15));
		for (User user : list) {
			// if(user.getUserPassword().indexOf("{skyenc}")!=-1){
			// user.setUserPassword(Base64Sky.decodePassword(user.getUserPassword().substring(8)));
			// }
			user.setSize(ByteTools.byteToM(user.getSize()));
			user.setMessageSize(ByteTools.byteToM(user.getMessageSize()));
		}
		r.putColl(list);
		// fillPagedDNA($User, mm, filter.toString(), "sortNum", true);
	}

	public void modUsersSize() throws AppException, Exception {
		String dc = $("dc");
		String depou = $("depou", "");

		int findtype = $i("findtype", Search_Exact);
		String elementName = $("search");
		String elementValue = $("textvalue", "");
		String sizeoption = $("sizeoption", "");
		int size = $i("size", 0);

		StringBuffer userCondition = new StringBuffer("1=1");
		if (!dc.equals("")) {
			userCondition.append(" and dc = '" + dc + "'");
		}
		if (!depou.equals(""))
			userCondition.append(" and ou = '" + depou + "'");

		if ("description".equals(elementName)) {
			if (findtype == Search_Exact) {
				Dept dept = $Dept.getDept(dc, elementValue);
				userCondition.append(" and ou = '" + dept.getOu() + "'");
			} else {
				List<Dept> depts = $Dept.getSearchDept(dc, elementValue);
				if (depts.size() > 0) {
					userCondition.append(" and ou in (");
					for (Dept dept : depts) {
						userCondition.append("'").append(dept.getOu())
								.append("',");
					}
					userCondition.deleteCharAt(userCondition.length() - 1);
					userCondition.append(" )");
				} else {
					userCondition.append(" and (ou is null)");
				}
			}
		} else if ("size".equals(elementName) && !sizeoption.equals("")) {
			userCondition.append(" and size").append(sizeoption)
					.append(ByteTools.mToByte(elementValue));
		} else {
			if (!elementValue.equals("")) {
				if (findtype == Search_Exact) {
					userCondition.append(" and ").append(elementName)
							.append(" = '").append(elementValue).append("'");
				} else {
					userCondition.append(" and ").append(elementName)
							.append(" like '%").append(elementValue)
							.append("%'");
				}
			}
		}

		Logger.debug("sql condition: " + userCondition);
		MdoMap mm = new MdoMap();
		mm.put("size", ByteTools.mToByte(size));
		$User.update(mm, userCondition);

		PagedList<User> list = $User.findPaged(mm, userCondition.toString(),
				"sortNum", true, $i("pagenum", 1), $i("perpagecount", 15));
		for (User user : list) {
			// if(user.getUserPassword().indexOf("{skyenc}")!=-1){
			// user.setUserPassword(Base64Sky.decodePassword(user.getUserPassword().substring(8)));
			// }
			user.setSize(ByteTools.byteToM(user.getSize()));
			user.setMessageSize(ByteTools.byteToM(user.getMessageSize()));
		}
		r.putColl(list);

		// // 部门
		// if ("description".equals(elementName)) {
		// if (findtype == Search_Exact) {
		// Dept dept = $Dept.getDept(dc, elementValue);
		// filter.append(" ou = '" + dept.getOu() + "'");
		// } else {
		// List<Dept> depts = $Dept.getSearchDept(dc, elementValue);
		// if (depts.size() > 0) {
		// filter.append(" ou in (");
		// for (Dept dept : depts) {
		// filter.append("'").append(dept.getOu()).append("',");
		// }
		// filter.deleteCharAt(filter.length() - 1);
		// filter.append(" )");
		// }
		// }
		// } else {
		// if (!elementValue.equals("")) {
		// if (findtype == Search_Exact) {
		// filter.append(elementName).append(" =
		// '").append(elementValue).append("'");
		// }
		// else {
		// filter.append(elementName).append(" like
		// '%").append(elementValue).append("%'");
		// }
		// }
		// }
		// System.out.println(filter);
		//
		// MList<User> list = $User.find(mm, filter.toString());
		// // for (User user : list) {
		// // user.update("size", ByteTools.mToByte(size));
		// // user.setSize(size);
		// // user.setMessageSize(ByteTools.byteToM(user.getMessageSize()));
		// //
		// // // TODO LOG
		// // }
		//
		// r.putColl(list);
	}

	//
	@Layout("NOT")
	public void domainDept() throws AppException, Exception {
		String dc = $("dc");
		r.putMap("dc", dc);

		MdoMap mm = $MM(Dept.class);
		mm.put("domain", dc);
		String deptTreeStr = $Dept.getDeptTreeMapJSON(mm).toString();
		r.putMap("deptTreeStr", deptTreeStr);
	}

	public void addDept() throws ValidateException, AppException, Exception {
		Dept dept = $M(Dept.class);
		String parent_ou = $("parent_ou", "");
		if (!parent_ou.equals(""))
			dept.setParentOu(parent_ou);
		dept.setOu(new UUID().toShortString());
		dept.setDescription($("description"));
		dept.create();

		SysLog.width(actor).addDepartment(dept.getDomain(),
				dept.getDescription());

		r.setMdo(dept);
	}

	public void delDept() throws AppException, Exception {
		Dept dept = $M(Dept.class);
		dept.load();
		dept.delete();

		SysLog.width(actor).delDepartment(dept.getDomain(),
				dept.getDescription());
	}

	public void modDept() throws AppException, Exception {
		Dept dept = new Dept($("ou"));
		dept.load();
		MdoMap mm = $MM(Dept.class);
		dept.update(mm);
		SysLog.width(actor).modDepartment(dept.getDomain(),
				dept.getDescription());

		dept.load();
		r.setMdo(dept);
	}

	public void getDepts() throws AppException, Exception {
		String domain = $("domain");
		List<Dept> depts = $Dept.getDepts(domain);
		if (actor.getIsAddressBookRole()) {
			List<Dept> lists = $Dept.getAddrAdmin(actorId, domain);
			depts.addAll(lists);
		}
		r.putColl(depts);
	}

	@Layout("NOT")
	public void domainGrpUsers() throws AppException, Exception {
		MdoMap mm = new MdoMap();
		mm.put("domain", $("dc"));

		r.putMap("deptTreeStr", $Dept.getDeptTreeMapJSON(mm).toString());
		r.putMap("depts", $Dept.getSafeDepts(mm));
	}

	@Layout("NOT")
	public void qUsers() throws AppException, Exception {
		String dc = $("dc");
		String depou = $("depou", "");

		Domain domain = new Domain(dc).load();
		r.putMap("dc", dc);
		r.putMap("depou", depou);

		r.putMap("attsize", ByteTools.byteToM(domain.attachmentSize));
		r.putMap("userstoragesize", ByteTools.byteToM(domain.defaultboxsize));
		// 存储服务器IP
		r.putMap("storageIP", mbapConfiger.getHost());
		// 存储服务器Port
		r.putMap("storagePort", mbapConfiger.getPort());
		// 最大发送人数
		r.putMap("defaultusermaxcc", smtpConfiger.getDefaultUserMaxCc());
		// 最大邮件大小
		r.putMap("messagesize",
				ByteTools.byteToM(smtpConfiger.getMaxMessageSize()));
	}

	public void listqUsers() throws AppException, Exception {
		// MdoMap mm = $MM(User.class);
		// mm.put("groupSend", 1);
		//
		// PagedList<User> list = $User.findPaged(mm, null, $("sortby",
		// "sortNum,uid"), true, $i("pagenum", 1), $i("perpagecount"));
		//
		// for (User user : list) {
		// user.setSize(ByteTools.byteToM(user.getSize()));
		// user.setMessageSize(ByteTools.byteToM(user.getMessageSize()));
		//
		// GroupUser groupuser = new GroupUser(user.getUid(), user.getDc());
		// if (groupuser.exists()) {
		// groupuser.load();
		// // 把组用户临时放在Rejectemail中
		// user.setRejectemail(groupuser.getMails());
		// }
		// }
		// r.putColl(list);

	}

	@Layout("NOT")
	public void addressList() {
		r.putMap("dc", $("dc"));
	}

	// public void getDeptsAndUsers() throws AppException, Exception {
	// String dc = $("dc");
	// String depou = $("ou", "");
	//
	// String ou = "";
	// Dept dept = new Dept(dc, depou);
	// if (dept.exists()) {
	// dept.load();
	// ou = dept.getOu();
	// }
	//
	// List<User> users = $User.getCommonUsersOfDept(dc, depou);
	// List<Dept> depts = $Dept.getDeptlist(dc, ou);
	//
	// // uJo.put("name", user.getDisplayName());
	// // uJo.put("eaddr", actor.toEmail());
	// // uJo.put("groupid", user.getOu());
	//
	// r.putMap("users", users);
	// r.putMap("depts", depts);
	//
	// }

	public void userinfo() throws AppException, Exception {
		String uid = $("uid");
		String dc = $("dc");
		User user = new User(dc, uid).load();
		// 邮件数
		r.putMap("mailCount", new MailFolder(user, "inbox").load().count);

		long spaceMail = $Mail.getSizeUsed(user);
		r.putMap("spaceMailM", ByteTools.getByteToM(spaceMail));

		long spaceNetdisk = $NdFolder.getSize(user);
		r.putMap("spaceNetdiskM", ByteTools.getByteToM(spaceNetdisk));
	}

	// domain admin
	@Layout("NOT")
	public void domainAdmins() throws AppException, Exception {
		String dc = $("dc");
		MList<DomainAdmin> das = $DomainAdmin.find("dc", dc);

		r.putMap("dc", dc);
		r.putColl(das);
	}

}
