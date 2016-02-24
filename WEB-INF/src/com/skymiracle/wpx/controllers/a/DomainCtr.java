package com.skymiracle.wpx.controllers.a;

import java.io.File;
import java.util.List;

import com.skymiracle.mdo5.MdoMap;
import com.skymiracle.mdo5.PagedList;
import com.skymiracle.sor.SorRequest;
import com.skymiracle.sor.annotation.Layout;
import com.skymiracle.sor.annotation.Sessioned;
import com.skymiracle.sor.exception.AppException;
import com.skymiracle.sor.render.PageRenderer;
import com.skymiracle.util.Charset;
import com.skymiracle.weather.google.GoogleWeather;
import com.skymiracle.wpx.models.domain.*;
import com.skymiracle.wpx.models.log.SysLog;
import com.skymiracle.wpx.models.user.User;
import com.skymiracle.wpx.util.ByteTools;
import com.skymiracle.wpx.models.bmsandnds85.*;

import static com.skymiracle.wpx.Singletons.*;

@Sessioned
public class DomainCtr extends Ctr {

	@Layout("NOT")
	public void main() {
	}

	@Layout("NOT")
	public void domains() throws AppException, Exception {
		r.putMap("domainsize", $Domain.getSize());
		r.putMap("defaultboxsize", $Domain.getDefaultboxsize());
		r.putMap("userMax", $Domain.getUserMax());
		r.putMap("attachmentSize", $Domain.getAttachmentSize());
		r.putMap("userLicenseCount", $Domain.getLicenser()
				.getUsersLicenseCount());
		r.putMap("leftLicenseCount", $Domain.getAllUserLicenseLeft());
		r.putMap("cityCodes", GoogleWeather.getInstance().getCityCodesMap());
	}

	public void list() throws AppException, Exception {

		List<Domain> list = actor.listDomains($("sortby", "dc"), $b("sortup",
				true), $i("pagenum", 1), $i("perpagecount", 15));

		for (Domain domain : list) {
			domain.setSizeLocate(ByteTools.byteToM(domain.getSizeLocate()));
			domain.setSize(ByteTools.byteToM(domain.getSize()));
			domain.setDefaultboxsize(ByteTools.byteToM(domain
					.getDefaultboxsize()));
			domain.setAttachmentSize(ByteTools.byteToM(domain
					.getAttachmentSize()));
		}

		if (list instanceof PagedList) {
			r.putColl((PagedList<Domain>) list);
		} else
			r.putColl(list);
	}

	public void add() throws AppException, Exception {
		Domain domain = $M(Domain.class);
		domain.setSizeLocate(ByteTools.mToByte(domain.getSizeLocate()));
		domain.setSize(ByteTools.mToByte(domain.getSize()));
		domain.setDefaultboxsize(ByteTools.mToByte(domain.getDefaultboxsize()));
		domain.setAttachmentSize(ByteTools.mToByte(domain.getAttachmentSize()));

		actor.addDomain(domain);

		domain.setSizeLocate(ByteTools.byteToM(domain.getSizeLocate()));
		domain.setSize(ByteTools.byteToM(domain.getSize()));
		domain.setDefaultboxsize(ByteTools.byteToM(domain.getDefaultboxsize()));
		domain.setAttachmentSize(ByteTools.byteToM(domain.getAttachmentSize()));

		r.setMdo(domain);
	}

	public void del() throws AppException, Exception {
		if ($$("dc").length > 1)
			throw new AppException("请选择一条记录！");

		Domain domain = $M(Domain.class);
		actor.delDomain(domain);
	}

	public void mod() throws AppException, Exception {
		Domain domain = $M(Domain.class);
		MdoMap mm = $MM(Domain.class);
		mm.put("size", ByteTools.mToByte(domain.getSize()));
		mm.put("defaultboxsize", ByteTools.mToByte(domain.getDefaultboxsize()));
		mm.put("attachmentsize", ByteTools.mToByte(domain.getAttachmentSize()));
		domain.update(mm);
		domain.load();

		domain.setSizeLocate(ByteTools.byteToM(domain.getSizeLocate()));
		domain.setSize(ByteTools.byteToM(domain.getSize()));
		domain.setDefaultboxsize(ByteTools.byteToM(domain.getDefaultboxsize()));
		domain.setAttachmentSize(ByteTools.byteToM(domain.getAttachmentSize()));

		r.setMdo(domain);
	}

	public void aliases() throws AppException, Exception {
		r.putColl($DomainAlias
				.find("aliasedObjectName", $("aliasedobjectname")));
	}

	public void alias_add() throws AppException, Exception {
		DomainAlias alias = $M(DomainAlias.class).create();
		SysLog.width(actor).addAliasDomain(alias.getAliasedObjectName(),
				alias.getDc());
	}

	public void aliases_del() throws AppException, Exception {
		List<DomainAlias> list = $$M(DomainAlias.class, "dc");
		for (DomainAlias alias : list) {
			alias.load();
			alias.delete();
			SysLog.width(actor).delAliasDomain(alias.getAliasedObjectName(),
					alias.getDc());
		}
	}

	public void search() throws AppException, Exception {
		String filter = "dc LIKE '%" + $("dc") + "%'";
		if ($has("pagenum")) {
			fillPagedDNA($Domain, null, filter);
		} else {
			r.putColl($Domain.find(null, filter));
		}
	}

	@Layout("NOT")
	public void sysStyle() {
	}

	@Layout("NOT")
	public void style() {
		String dc = $("dc", "");
		r.putMap("dc", dc);
		r.putMap("domain", $("type", "domain"));
		r.putMap("logoPath", $Domain.getLogoPath(SorRequest.Project_Real_Path, dc));
	}

	public void sysStyle_upload() throws AppException, Exception {
		String dc = $("dc", "");
		$Domain.modSysLogoImg($File(), SorRequest.Project_Real_Path, dc);
		page().redirectTo("a/domain/style.html?type="+$("type", "domain")+"&dc"+dc);
	}
	
	//导出域数据
	public void domainsCSV() throws AppException, Exception {
		// TODO 此处角色没有考虑
		File file = createTempFile();
		//$Domain.findAll().exportCSV(file, Domain.class, "UTF-8");
		$Domain.exportCSV(file, "UTF-8");
		r.putFile(file, "子邮局列表.csv");
	}
	
	//导入域数据
	@Layout("NOT")
	public void importDomains() throws AppException, Exception {
		if(!is_get){
			File file = $File();
			if(file.exists())
				$Domain.importDomains(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importDomains.html';");
		}
	}
	@Layout("NOT")
	public void exportDomains() throws AppException, Exception{
		File file = createTempFile();
		$Domain.exportCSV(file, "UTF-8");
		r.putFile(file, "子邮局列表.csv");
	}
	
	//导入部门数据
	@Layout("NOT")
	public void importDepts() throws AppException, Exception {
		if(!is_get){
			File file = $File();
			if(file.exists())
				$Dept.importDepts(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importDepts.html';");
		}
	}
	@Layout("NOT")
	public void exportDepts() throws AppException, Exception{
		File file = createTempFile();
		$Dept.exportCSV(file, "UTF-8");
		r.putFile(file, "部门列表.csv");
	}
	

	//导入用户数据
	@Layout("NOT")
	public void importUsers() throws AppException, Exception {
		if(!is_get){
			File file = $File();
			if(file.exists())
				$User.importUsers(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importUsers.html';");
		}
	}
	@Layout("NOT")
	public void exportUsers() throws AppException, Exception {
		File file = createTempFile();
		$User.exportCSV(file, "UTF-8");
		r.putFile(file, "用户列表.csv");
	}
	
	//导入私人通讯录组
	@Layout("NOT")
	public void importGrpAddrbooks() throws AppException, Exception {
		if(!is_get){
			File file = $File();
			if(file.exists())
				$AddrGrp.importGrps(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importGrpAddrbooks.html';");
		}
	}
	@Layout("NOT")
	public void exportGrpAddrbooks() throws AppException, Exception {
		File file = createTempFile();
		$AddrGrp.exportCSV(file, "UTF-8");
		r.putFile(file, "私人通讯录组列表.csv");
	}
	
	//导入私人通讯录成员
	@Layout("NOT")
	public void importPsnAddrbooks() throws AppException, Exception {
		if(!is_get){
			File file = $File();
			if(file.exists())
				$AddrPsn.importPsns(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importPsnAddrbooks.html';");
		}
	}
	@Layout("NOT")
	public void exportPsnAddrbooks() throws AppException, Exception {
		File file = createTempFile();
		$AddrPsn.exportCSV(file, "UTF-8");
		r.putFile(file, "私人通讯录用户列表.csv");
	}
	
	//导入用户别名
	@Layout("NOT")
	public void importUserAlias() throws AppException, Exception {
		if(!is_get){
			File file = $File();
			if(file.exists())
				$UserAlias.importPsns(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importUserAlias.html';");
		}
	}
	@Layout("NOT")
	public void exportUserAlias() throws AppException, Exception {
		File file = createTempFile();
		$UserAlias.exportCSV(file, "UTF-8");
		r.putFile(file, "用户别名列表.csv");
	}
	
	//导入书签组
	@Layout("NOT")
	public void importBmForders() throws AppException, Exception {
		if(!is_get){
			File file = $File();
			if(file.exists())
				$BmFolder.importBmForders(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importUserAlias.html';");
		}
	}
	@Layout("NOT")
	public void exportBmForders() throws AppException, Exception {
		File file = createTempFile();
		$BmFolder.exportCSV(file, "UTF-8");
		r.putFile(file, "书签组列表.csv");
	}
	
	
	//导入书签
	@Layout("NOT")
	public void importBmItems() throws AppException, Exception {
		if(!is_get){
			File file = $File();
			if(file.exists())
				$BmItem.importBmItems(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importUserAlias.html';");
		}
	}
	@Layout("NOT")
	public void exportBmItems() throws AppException, Exception {
		File file = createTempFile();
		$BmItem.exportCSV(file, "UTF-8");
		r.putFile(file, "书签列表.csv");
	}
	
	// 导入8.5版U盘书签
	@Layout("NOT")
	public void importBmsAndNds() throws AppException, Exception{
		if(!is_get){
			File file = $File();
			if(file.exists())
				BmsAndNdsImport.exec(file);
			r.setJs("alert('导入完成');window.parent.frames['contentFrame'].location='importBmsAndNds.html';");
		}
	}
	
	
	/** ******** 数据整理 **********/
	@Layout("NOT")
	public void resetData()throws AppException, Exception {
		
	}

	@Layout("NOT")
	public void resetDomains()throws AppException, Exception {
		$Domain.resetAll();
		r.setJs("alert('整理完成');window.parent.frames['contentFrame'].location='resetData.html';");
	}
	@Layout("NOT")
	public void resetPsnAddrs()throws AppException, Exception {
		$AddrGrp.resetAll();
		r.setJs("alert('整理完成');window.parent.frames['contentFrame'].location='resetData.html';");
	}
	@Layout("NOT")
	public void resetPubAddrs()throws AppException, Exception {
		$Dept.resetAll();
		r.setJs("alert('整理完成');window.parent.frames['contentFrame'].location='resetData.html';");
	}
	
	@Layout("NOT")
	public void resetUserSpells()throws AppException, Exception {
		List<User> users = $User.findAll();
		for(User user : users) {
			if(user.getDisplayName() == null)
				continue;
			user.update("spell", Charset.utf8ToPinyin(user.getDisplayName()));
		}
			
		r.setJs("alert('整理完成');window.parent.frames['contentFrame'].location='resetData.html';");
	}
	
}
