<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/admin.css" type="text/css" rel="stylesheet">
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/admin.png', sizingMethod='crop');
}
</style>
<![endif]-->
</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1">公共地址簿管理员</td>
<td align="right" id="title_Font2"></td>
</tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="tableBlock" class="tableBlock" align="center">
</div>
</body>
<script language="javascript">
	
var dataStruct = {
		'uid': {title: '用户名',  isKey: true, validate: VF_username},
		'userpassword': {title: '密码',ftype: "Password",validate: VF_passwd},
		'dc': {title: '管理域',ftype: 'Hash',optionMap: {
			"":""
			<c:forEach var="domain" items="${domains}" varStatus="status">
				<c:if test="${status.first}">,</c:if>
				<c:out value="'${domain.dc}' : '${domain.dc}'" escapeXml="false"/>
				<c:if test="${!status.last}">,</c:if>
			</c:forEach>
		}},
		'deptname': {title: '管理部门'},
		'oudes': {title: "部门名称(点击选择部门)",defaultValue: "点击选择部门"},
		'ou':{title:"部门",defaultValue:"",validate: VF_noEmpty},
		'status': {title: '状态', ftype: "Hash",optionMap: {'open': '开通',  'pause': "暂停"},defaultValue:"open"}
}

var dataSourceProps = {
	listURL: "../admin/addressbookAdmin_list.json",
	addURL: "../admin/addressbookAdmin_add.json",
	modURL: "../admin/addressbookAdmin_mod.json",
	delURL: "../admin/addressbookAdmins_del.json"
}

var tableProps = {
	subjects: ["uid","dc","deptname","status"],
	isCheckbox : true
}



var addAddressbookAdminWinProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 500,
	height:247,
	subjects: ["uid", "userpassword","dc","oudes","ou","status"],
	hiddens: ["ou"],
	isForgetDataStructKey: true
}

var modAddressbookAdminProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 400,
	height:247,
	subjects: ["userpassword","status","dc"],
	hiddens: ["dc"]
}


	
function listDep(ctr){
	SkyDNA.Event.addEvent(ctr,'onclick',function(){
		var dc = document.getElementsByName('dc');			
		var ous = document.getElementsByName('ou');
		var oudecs = document.getElementsByName('oudes');
		if(ous.length<=0) return;
		var pou = ous[0];
		var poudesc = oudecs[0];
		pou.readOnly = true;
		var depwin = null;
			/*
			 *	creatae popwin to list department data tree
			 */
			 SkyDNA.Event.addEvent(poudesc,'onfocus',function(){
			 	depwin = SkyDNA.Element.createPopupWin({title:dc[0].value+'部门列表',width: 350,height:500});
			 				 	
				var deptDsProps = {
					dataStruct : {
						'uuid': {title: "UUID", isKey: true},
						'ou': {title: "部门代号", validate: VF_username},
						'description': {title: "部门名称",validate: VF_noEmpty}
					},
					listURL: "../user/getDepts.json?domain="+dc[0].value
				};
				
				var DeptDataSource = new SkyDNA.DataSource(null, deptDsProps);
	
			 	var treeCtr = _CC("div", null, depwin.contentDom);
				treeCtr.style.overflow = "scroll";
				SkyDNA.Enhance.enhance(treeCtr, "dockable", {dock: 'full'});
				
				var treeView = DeptDataSource.createDataTree(treeCtr, {
						title: "部门", 
						titleArg: 'description',
						onSelected: onDeptSelected.bind(this)
				});
			
			DeptDataSource.remoteListData();
			
			function onDeptSelected(node){
				var ou = node.data?node.data.ou:'';
				//var ou = ou==''?'no':ou;
				var desc = node.data?node.data.description:'';
				pou.value= ou;
				poudesc.value = desc;
				depwin.dispose();
			}
 		});
	  	//SkyDNA.Event.addEvent(pou,'onblur',function(){if(depwin)depwin.dispose();});
	});
	
}
	

function main(){
	var ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);
	var btnsBar = SkyDNA.Element.createButtonsBar(_G("toolsBlock"));
	var addBtn = btnsBar.addButton("添加");
	var modBtn = btnsBar.addButton("修改");
	var rfBtn = btnsBar.addButton("刷新");
	var delBtn = btnsBar.addButton("删除",delAdmin);
	var modwin = ds.bindMod(modBtn,modAddressbookAdminProps);
	var addwin = ds.bindAdd(addBtn,addAddressbookAdminWinProps);
	ds.createDataTable(_G("tableBlock"), tableProps);
	ds.bindRefresh(rfBtn);
	//ds.bindDel(delBtn);
	ds.remoteListData();
	listDep(addBtn);
	
	
	function delAdmin(){
		if(!confirm('您确认要删除所选数据？')){
			return;
		}
	
		var deluids = ds.getSelectedDatas();
		var deldcs = ds.getSelectedDatas();
		var uids="";
		var dcs="";
		deluids.each(function(data) {
			uids +="&uid=" + data.uid;
		});
		deldcs.each(function(data) {
			dcs +="&dc=" + data.dc;
		});
		var  url = dataSourceProps.delURL + "?" +uids+dcs;
		SkyDNA.Ajax.doRequest(url);
		ds.remoteListData();
	}

}
	
main();
</script>
</html>
