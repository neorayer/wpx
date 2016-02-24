package com.skymiracle.wpx.controllers.u;

import static com.skymiracle.wpx.Singletons.$AddrPsn;
import static com.skymiracle.wpx.Singletons.$Dept;
import static com.skymiracle.wpx.Singletons.$User;

import java.util.List;

import org.json.JSONObject;

import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.wpx.models.addrbook.AddrGrp;
import com.skymiracle.wpx.models.addrbook.AddrPsn;
import com.skymiracle.wpx.models.user.Dept;
import com.skymiracle.wpx.models.user.User;

@Sessioned
public class PublicAddrCtr extends Ctr{
	@Layout("NOT")
	public void main() throws AppException, Exception{
		r.putMap("allGroupCount", $Dept.count("domain", actor.getDc()));
		r.putMap("allPersonCount", $User.count("dc, status, ishide", actor.getDc(), "open", 1));
			
	}
	
	@Layout("NOT")
	public void depts() throws AppException, Exception {
		r.putMap("allPublicCount", $User.count("dc, status, ishide", actor.getDc(), "open", 1));
		r.putMap("noGroupPublicCount", $User.count("dc,ou, status, ishide", actor.getDc(), "", "open", 1));
		
//		r.putMap("pubs", $Dept.find("domain,parentOu,sortNum+", actor.getDc(), "", null));
		
		MdoMap mm = new MdoMap();
		mm.put("domain", actor.getDc());
		JSONObject jsonobject = $Dept.getDeptTreeMapJSON(mm);
		r.putMap("treejson", jsonobject.toString());
	}
	
	@Layout("NOT")
	public void addrs() throws AppException, Exception {
		String groupid = $("groupid", "");
		r.putMap("groupid", groupid);
		String treeid = $("treeid", "all");
		r.putMap("treeid", treeid);
		
		int pageNum = $i("pageNum", 1);
		int countPerPage = 10;
		String sortBy = $("sortBy", "sortNum");
		boolean isUp = $b("isUp", true);
		r.putMap("sortBy", sortBy);
		r.putMap("isUp", isUp);
		
		String linkPreifx = "publicAddr/addrs.html?groupid="+groupid + "&sortBy=" + sortBy + "&isUp=" + isUp;
		
		String keyword = $("keyword", "");
		keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		if (!keyword.equals("") ) {
			linkPreifx += "&keyword="+keyword;
		}
		StringBuffer sb =new StringBuffer(" dc ='"+actor.getDc()+"' and ishide = 1 ");
		
		if(groupid.equals("nogroup")){
			sb.append("and ou ='' ");
			
			Dept grp = new Dept();
			grp.setDescription("未分组联系人");
			grp.setCount($User.count("dc, ou, status, ishide", actor.getDc(), "", "open", 1));
			r.putMap("group", grp);
		}
		else if(!groupid.equals("") && !groupid.equals("all")){
			sb.append("and (ou = '" + groupid +"' ");
			List<String> childrenOus = $Dept.findChildrenOus(groupid);
			if(childrenOus.size() > 0) {
				for (String cou : childrenOus)
					sb.append(" or ou = '" + cou + "'");
			}
			sb.append(")");
			
			Dept grp = new Dept(actor.getDc(), groupid).load();
			r.putMap("group", grp);
		}
		else{
			Dept grp = new Dept();
			grp.setDescription("所有联系人");
			grp.setCount($User.count("dc, status, ishide", actor.getDc(), "open", 1));
			r.putMap("group", grp);
		}
		
		keyword = keyword.trim();
		if (keyword != null && !keyword.equals("")){
			sb.append("and ( ");
			sb.append("displayName like '%"+keyword+"%' ");
			sb.append("or mail like '%"+keyword+"%' ");
			sb.append("or company like '%"+keyword+"%' ");
			sb.append("or mobile like '%"+keyword+"%' ");
			sb.append(")");
		}
		
		r.putMap("condition", "");
		
		// TODO 哎，为了中文排序， 用了mysql 特有的convert函数
		if(!"sortNum".equals(sortBy))
			sortBy = " convert(" + sortBy + " using gb2312)";
		PagedList<User> users = $User.findPaged(new MdoMap(), sb.toString(), sortBy, isUp, pageNum, countPerPage);
		users.setLinkPrefix(linkPreifx);
		r.putMap("_keyword", keyword);
		r.putMap("users", users);
		r.putMap("pageBarTdsHTML", users.getTextBarHTML());
	}
	
	
	@Layout("NOT")
	public void getTos() throws AppException, Exception {
		String []uuids = $$("uuid");
		StringBuffer tos = new StringBuffer();
		for (String uuid: uuids) {
			User user = $User.find("uuid", uuid).getFirst();
			if(user!=null)
			tos.append("\""+user.getDisplayName()+"\"<"+user.getMail()+">,");
		}
		r.putMap("tos", tos.toString());
	}
	
	
	@Layout("NOT")
	public void getGroupToMails()throws AppException, Exception {
		MList<User> psns = $User.find("ou,dc, status, ishide", $("groupid", ""), actor.getDc(), "open", 1);
		StringBuffer tomails = new StringBuffer();
		for (User psn: psns) {
			tomails.append("\""+psn.getDisplayName()+"\"<"+psn.getMail()+">,");
		}
		r.putMap("tomails", tomails.toString());
	}
	
	
	@Layout("NOT")
	public void contactForm() throws AppException, Exception {
		User user = new User($("dc"), $("uid")).load();
		r.putMap("psn", user);
		r.putMap("isDetail", true);
	}
	
	@Layout("NOT")
	public void copyToPsn() throws AppException, Exception {
		String []uuids = $$("uuid");
		for (String uuid: uuids) {
			User user = $User.find("uuid", uuid).getFirst();
			if(user == null)
				continue;
			AddrPsn psn = new AddrPsn();
			psn.setOwner(actor.toEmail());
			psn.setSpell(user.getDisplayName());
			psn.setDisplayName(user.getDisplayName());
			psn.setGroupId("");
			psn.setMail(user.getMail());
			psn.setOu("");
			psn.setSex(user.getSex());
			psn.create();
		}
	}
	
	@Layout("NOT")
	public void getChildrenNodes() throws AppException, Exception {
		r.putMap("depts", $Dept.find("domain,parentOu,sortNum+", actor.getDc(), $("uuid")));
	}
	
	//显示树的用户节点
	@Layout("NOT")
	public void getNotes() throws AppException, Exception {  
		r.putMap("public_psns", $User.find("ou,dc, status, ishide, sortnum+", $("groupid", ""), actor.getDc(), "open", 1));
	}
}
