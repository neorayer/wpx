package com.skymiracle.wpx.controllers.u;

import static com.skymiracle.wpx.Singletons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.util.Base64Sky;
import com.skymiracle.util.StringUtils;
import com.skymiracle.wpx.models.mail.MailInk;
import com.skymiracle.wpx.models.user.Skin;
import com.skymiracle.wpx.models.user.User;

@Sessioned
public class OptionCtr extends Ctr{
	@Layout("NOT")
	public void main(){
		r.putMap("module", $("module", "personInfo"));
	}

	@Layout("NOT")
	public void personInfo() throws AppException, Exception{
		if(!is_get){
			MdoMap mdoMap =$MM(User.class); 
			mdoMap.put("displayName", $("displayName"));
			actor.update(mdoMap);
		}
	}
	@Layout("NOT")
	public void password() throws AppException, Exception{
		if(!is_get){
			String pass = $("newPass").trim();
			String pass2 = $("newPass2").trim();

			String oldPass = $("oldPass");
			String oldPass1 = Base64Sky.encodeToPassword(oldPass,"UTF-8");
			
			if (!actor.auth("userpassword", oldPass) && !actor.auth("userpassword", oldPass1))
				throw new AppException("原密码认证错误！");
			if (pass.length() == 0)
				throw new AppException("新密码不能为空！");
			if (!pass.equals(pass2))
				throw new AppException("新密码与确认密码不相同！");

			actor.update("userpassword", Base64Sky.encodeToPassword(pass.trim(),"UTF-8"));
			
		}
	}
	
	@Layout("NOT")
	public void space() throws AppException, Exception{
		if(!is_get){
			long size = actor.getSize();

			String newSpacealert = $("newSpaceAlert");
			newSpacealert = newSpacealert.replace('%', ' ');
			newSpacealert = newSpacealert.trim();

			long newSpacealertL = 0;
			try {
				newSpacealertL = Long.parseLong(newSpacealert);
			} catch (Exception e) {
				throw new AppException("数据类型错误");
			}
			long v = 0L;
			String sizetype = $("sizetype");
			if (sizetype.equals("isclose"))
				v = 0L;
			else if (sizetype.equals("isper"))
				v = newSpacealertL * size / 100;
			else if (sizetype.equals("issize"))
				v = newSpacealertL * 1024 * 1024;
			if (v > size)
				throw new AppException("超出范围，请重新设定");
			actor.update("spacealert", v);
			
		}

		long spaceAlert = actor.getSpaceAlert();
		long size = actor.getSize();
		String sizePercent = "00";
		if (size > 0) {
			sizePercent = ((spaceAlert * 100 / size) + "");
		}
		long spaceAlertM = spaceAlert / 1024 / 1024;
		long sizeM = size / 1024 / 1024;
		r.putMap("sizePercent", sizePercent);
		r.putMap("spaceAlertM", spaceAlertM);
		r.putMap("sizeM", sizeM);
		
	}
	@Layout("NOT")
	public void sign() throws AppException, Exception{
		if(!is_get){
			MailInk ink = $M(MailInk.class);
			if(!ink.getUuid().equals("") && ink!=null){
				ink.update("name,ink", $("name"), $("ink"));
			}else{
				ink.setUuid(UUID.randomUUID().toString());
				ink.setOwner(actor.toEmail());
				ink.create();
			}
			r.setJs("parent.iTabClicked('sign');");
		}else{
			String uuid = $("uuid", null);
			if(uuid != null)
				r.putMap("link", $M(MailInk.class).load());
			r.putMap("inks", $MailInk.find("owner", actor.toEmail()));
		}
	}
	
	@Layout("NOT")
	public void sign_del() throws AppException, Exception {
		$M(MailInk.class).delete();
	}
	@Layout("NOT")
	public void sign_edit() throws AppException, Exception {
		r.putMap("link", $M(MailInk.class).load());
	}
	
	
	//自动回复
	@Layout("NOT")
	public void restore() throws AppException, Exception {
		if(!is_get){
			actor.update("autoreplyswitch, autoreplycontent", $("autoreplyswitch"),
					$("autoreplycontent"));
			r.setJs("parent.iTabClicked('restore');parent.tipMsg('自动回复修改成功');");
		}else {
			actor.load();
			r.putMap("autoreplyswitch", actor.getAutoreplyswitch());
			r.putMap("autoreplycontent", actor.getAutoreplycontent());
		}
	}
	
	//邮件转发
	@Layout("NOT")
	public void forward() {
		
	}
	
	//邮件转发
	@Layout("NOT")
	public void forwardset() throws AppException, Exception{
		actor.update("forward", $i("forward", 0));
	}
	
	//邮件转发删除
	@Layout("NOT")
	public void forwarddel() throws AppException, Exception{
		if(is_get)
			return;
		
		String fmail = $("fmail", "");
		if(fmail.equals(""))
			return;
		String[] aa = actor.getForwardaddr();
		List<String> list = new ArrayList<String>();
		for(String a: aa) {
			if(a.equals(fmail))
				continue;
			list.add(a);
		}	
		
		MdoMap mm = new MdoMap();
		mm.put("forwardaddr", list.toArray(new String[0]));
		actor.update(mm);	
	}
	
	public void forwardadd() throws AppException, Exception {
		String fmail = $("fmail", "");
		if(fmail.equals(""))
			return;
		
		String[] aa = actor.getForwardaddr();
		List<String> list = new ArrayList<String>();
		for(String a: aa) {
			if(a.equals(fmail))
				throw new AppException("该转发邮箱已经存在!");
			list.add(a);
		}
		
		list.add(fmail);
		MdoMap mm = new MdoMap();
		mm.put("forwardaddr", list.toArray(new String[0]));
		actor.update(mm);
	}
	
	//常规设置
	@Layout("NOT")
	public void common() throws AppException, Exception {
		if (!is_get) {
			int mnpp = $i("mnpp");
			if (mnpp <= 0 || mnpp >= 1000)
				throw new AppException("数值超出范围，必须为1~1000内的数字");

			int savenew = $i("savenew");
			actor.update("mnpp, savenew", mnpp, savenew);
		}else {
			int mnpp = actor.getMnpp();
			r.putMap("mnpp", mnpp == 0 ? "20" : mnpp);
		}
		
	}

	//拒收设置
	@Layout("NOT")
	public void reject() throws AppException, Exception {
		r.putMap("rejectDomains", actor.getRejectdomain());
		r.putMap("rejectEmails", actor.getRejectemail());
		r.putMap("rejectSubjects", actor.getRejectesubject());
		String type = $("type", "domain");
		r.putMap("type", type);
	}
	
	public void reject_add()throws AppException, Exception {
		String type = $("type");
		r.putMap("type", type);
		String rejectVal = $("reject", null);
		if(type.equals("domain")){
			List<String> sList = new LinkedList<String>();
			for (String s : actor.getRejectdomain()) {
				if ((s = s.trim()).length() > 0)
					sList.add(s);
			}
			if(rejectVal!=null)
				sList.add(rejectVal);
			MdoMap mdoMap = new MdoMap();
			mdoMap.put("rejectdomain", sList.toArray(new String[0]));
			actor.update(mdoMap);
		}
		
		if(type.equals("email")){
			List<String> sList = new LinkedList<String>();
			for (String s : actor.getRejectemail()) {
				if ((s = s.trim()).length() > 0)
					sList.add(s);
			}
			if(rejectVal!=null)
				sList.add(rejectVal);
			MdoMap mdoMap = new MdoMap();
			mdoMap.put("rejectemail", sList.toArray(new String[0]));
			actor.update(mdoMap);
		}
		
		if(type.equals("subject")){
			List<String> sList = new LinkedList<String>();
			for (String s : actor.getRejectesubject()) {
				if ((s = s.trim()).length() > 0)
					sList.add(s);
			}
			if(rejectVal!=null)
				sList.add(rejectVal);
			MdoMap mdoMap = new MdoMap();
			mdoMap.put("rejectesubject", sList.toArray(new String[0]));
			actor.update(mdoMap);
		}
		
	}
	
	public void reject_del()throws AppException, Exception {
		String type = $("type");
		String rejectVal = $("reject", null);
		MdoMap mdoMap = new MdoMap();
		if(type.equals("domain")){
			List<String> sList = new LinkedList<String>();
			for (String s : actor.getRejectdomain()) {
				if ((s = s.trim()).length() > 0 && !s.equals(rejectVal))
					sList.add(s);
			}
			mdoMap.put("rejectdomain", sList.toArray(new String[0]));
		}
		
		if(type.equals("email")){
			List<String> sList = new LinkedList<String>();
			for (String s : actor.getRejectemail()) {
				if ((s = s.trim()).length() > 0 && !s.equals(rejectVal))
					sList.add(s);
			}
			mdoMap.put("rejectemail", sList.toArray(new String[0]));
		}
		
		if(type.equals("subject")){
			List<String> sList = new LinkedList<String>();
			for (String s : actor.getRejectesubject()) {
				if ((s = s.trim()).length() > 0 && !s.equals(rejectVal))
					sList.add(s);
			}
			mdoMap.put("rejectesubject", sList.toArray(new String[0]));
		}
		actor.update(mdoMap);
		
	}
	
	@Layout("NOT")
	public void skins() {
		List<Skin> skins = new ArrayList<Skin>();
		for(Skin s: $Skin.getSkins().values()) {
			if(!s.getIsShow())
				continue;
			skins.add(s);
		}
		r.putMap("skins", skins);
	}
	
	@Layout("NOT")
	public void skinSet() throws AppException, Exception {
		String id = $("id", "1");
		Skin skin = $Skin.getSkin(id);
		if(skin == null)
			throw new AppException("邮箱没有该皮肤!");
		
		actor.update("skin", id);
		r.putMap("code", skin.getCode());
	}

}
