package com.skymiracle.wpx.controllers.u;

import static com.skymiracle.wpx.Singletons.*;

import java.util.UUID;

import com.skymiracle.fileBox.MailBoxLsItem;
import com.skymiracle.mdo5.MList;
import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.sor.render.PageRenderer;
import com.skymiracle.util.StringUtils;
import com.skymiracle.wpx.models.addrbook.AddrGrp;
import com.skymiracle.wpx.models.addrbook.AddrPsn;

@Sessioned
public class PersonAddrCtr extends Ctr{
	@Layout("NOT")
	public void main() throws AppException, Exception{
		r.putMap("allGroupCount", $AddrGrp.count("owner", actor.toEmail()));
		r.putMap("allPersonCount", $AddrPsn.count("owner", actor.toEmail()));
		r.putMap("nogroupPersonCount", $AddrPsn.count("owner,groupId", actor.toEmail(), ""));
		
		groups();
		
		addrs();
	}
	
	@Layout("NOT")
	public void groups() throws AppException, Exception {
		r.putMap("grps", $AddrGrp.find("owner,groupname+", actor.toEmail(), null));
	}
	
	@Layout("NOT")
	public void addrs() throws AppException, Exception {
		String groupid = $("groupid", "");
		r.putMap("groupid", groupid);
		
		
		int pageNum = $i("pageNum", 1);
		int countPerPage = 10;
		String sortBy = $("sortBy", "displayName");
		boolean isUp = $b("isUp", true);
		r.putMap("sortBy", sortBy);
		r.putMap("isUp", isUp);
		
		String linkPreifx = "personAddr/main.html?groupid="+groupid + "&sortBy=" + sortBy + "&isUp=" + isUp;
		
		String keyword = $("keyword", "");
		keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
		if (!keyword.equals("") ) {
			linkPreifx += "&keyword="+keyword;
		}
		StringBuffer sb =new StringBuffer("owner ='"+actor.getMail()+"' ");
		if(groupid.equals("nogroup")){
			sb.append("and groupId ='' ");
			
			AddrGrp grp = new AddrGrp();
			grp.setCount($AddrPsn.count("owner, groupId", actor.getMail(), ""));
			grp.setGroupName("未分组");
			r.putMap("group", grp);
		}
		else if(!groupid.equals("")){
			sb.append("and groupId = '" + groupid +"' ");
			
			r.putMap("group", new AddrGrp(groupid).load());
		}else {
			AddrGrp grp = new AddrGrp();
			grp.setGroupName("所有");
			grp.setCount($AddrPsn.count("owner", actor.getMail()));
			r.putMap("group", grp);
		}
		keyword = keyword.trim();
		if (keyword != null && !keyword.equals("")){
			sb.append("and ( ");
			sb.append("displayname like '%"+keyword+"%' ");
			sb.append("or mail like '%"+keyword+"%' ");
			sb.append("or company like '%"+keyword+"%' ");
			sb.append("or mobile like '%"+keyword+"%' ");
			sb.append(")");
		}
		r.putMap("condition", "");
		
		// TODO 哎，为了中文排序， 用了mysql 特有的convert函数
		PagedList<AddrPsn> psns = $AddrPsn.findPaged(new MdoMap(), sb.toString(), " convert(" + sortBy + " using gb2312)", isUp, pageNum, countPerPage);
		psns.setLinkPrefix(linkPreifx);
		r.putMap("_keyword", keyword);
		r.putMap("psns", psns);
		r.putMap("pageBarTdsHTML", psns.getTextBarHTML());
	}
	
	@Layout("NOT")
	public void getTos() throws AppException, Exception {
		String []uuids = $$("uuid");
		StringBuffer tos = new StringBuffer();
		for (String uuid: uuids) {
			AddrPsn psn = new AddrPsn(uuid);
			psn.load();
			tos.append("\""+psn.getDisplayName()+"\"<"+psn.getMail()+">,");
		}
		r.putMap("tos", tos.toString());
	}
	
	@Layout("NOT")
	public void getGroupToMails()throws AppException, Exception {
		MList<AddrPsn> psns =$AddrPsn.find("groupId,owner", $("groupid", ""), actor.getMail());
		StringBuffer tomails = new StringBuffer();
		for (AddrPsn psn: psns) {
			tomails.append("\""+psn.getDisplayName()+"\"<"+psn.getMail()+">,");
		}
		r.putMap("tomails", tomails.toString());
	}
	
	@Layout("NOT")
	public void moveTo() throws AppException, Exception {
		String uuids[] = $$("uuid");
		$AddrPsn.moveTo(uuids, $("groupid", ""));
	}
	
	@Layout("NOT")
	public void del() throws AppException, Exception {
		String uuids[] = $$("uuid");
		$AddrPsn.del(uuids);
	}
	
	@Layout("NOT")
	public void addGroup() throws AppException, Exception {
		if(!is_get){
			String groupName = $("groupName");
			AddrGrp grp = new AddrGrp();
			grp.setGroupName(groupName);
			grp.setOwner(actor.getMail());
			grp.create();
			r.putMap("groupid", grp.getUuid());
		}
	}
	
	@Layout("NOT")
	public void editGroup() throws AppException, Exception {
		String groupid = $("groupid");
		AddrGrp grp = new AddrGrp(groupid);
		if(!is_get){
			grp.setUuid(groupid);
			MdoMap mdoMap =new MdoMap();
			mdoMap.put("groupName", $("groupName"));
			grp.update(mdoMap);
		}
		r.putMap("groupid", groupid);
		r.putMap("grp", grp.load());
	}
	
	@Layout("NOT")
	public void delGroup() throws AppException, Exception {
		new AddrGrp($("groupid")).delete();
	}
	
	@Layout("NOT")
	public void contactForm() throws AppException, Exception {
		String type = $("type");
		String groupid = $("groupid", "");
		
		//添加
		if(type.equals("add")){
			if (!is_get) {
				AddrPsn psn = $M(AddrPsn.class);
				psn.setOwner(actor.getMail());
				psn.setUuid(UUID.randomUUID().toString());
				psn.setGroupId(groupid);
				psn.setOwner(actor.getMail());
				psn.create();
			}else {
				r.putMap("isDetail", false);
			}
		}
		//修改
		else if(type.equals("mod")){
			if(!is_get){
				MdoMap psn = new MdoMap();
				psn.put("uuid", $("uuid"));
				$AddrPsn.update($MM(AddrPsn.class), psn);
			}else{
				AddrPsn psn = new AddrPsn($("uuid")).load();
				r.putMap("psn", psn);
				r.putMap("isDetail", false);
			}
		}
		else if(type.equals("view")){
			AddrPsn psn = new AddrPsn($("uuid")).load();
			r.putMap("psn", psn);
			r.putMap("isDetail", true);
		}
		r.putMap("groupid", groupid);
		r.putMap("type", type);
	}
	
	//显示树的用户节点
	@Layout("NOT")
	public void getNotes() throws AppException, Exception {
		r.putMap("person_psns", $AddrPsn.find("groupId,owner", $("groupid", ""), actor.getMail()));
	}

	//	加入私人通讯录
	@Layout("NOT")
	public void addAddr() throws AppException, Exception {
		String groupids[] = $$("groupId");
		AddrPsn psn = new AddrPsn();
		String name = new String($("name", ""));
		psn.setDisplayName(name);
		psn.setMail($("mail"));
		psn.setOwner(actor.getMail());
		psn.setPhone($("phone"));
		
		for(String groupid : groupids){
			psn.setUuid(UUID.randomUUID().toString());
			psn.setGroupId(groupid);
			psn.create();
		}
	}
}
