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
<td align="left" id="title_Font1">多域管理员</td>
<td align="right" id="title_Font2"></td></tr></table>
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
			'roomnumber':{title: '可管理的域数量', validate: VF_onlyNum},
			'size':{title: '可管理的用户数', validate: VF_onlyNum},
			'sizelocate':{title: '可管理的容量(M)', validate: VF_onlyNum},
			'status': {title: '状态', ftype: "Hash",optionMap: {'open': '开通',  'pause': "暂停"},defaultValue:"open"}
	}

	var tableProps = {
	subjects: ["uid", "roomnumber","size","sizelocate","status"],
	isCheckbox : true
}

var dataSourceProps = {
	listURL: "../admin/listMultiDomainAdmin.json",
	addURL: "../admin/addMultiDomainAdmin.json",
	modURL: "../admin/modMultiDomainAdmin.json",
	delURL: "../admin/delMultiDomainAdmin.json"
}

var addMultiDomainAdminWinProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 500,
	height:309,
	subjects: ["uid", "userpassword", "roomnumber","size","sizelocate","status"],
	isForgetDataStructKey: true
}

var modMultiDomainAdminProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 500,
	height:309,
	subjects: ["userpassword", "roomnumber","size","sizelocate","status"]
}

function main(){
	var ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);
	var btnsBar = SkyDNA.Element.createButtonsBar(_G("toolsBlock"));
	var addBtn = btnsBar.addButton("添加");
	var modBtn = btnsBar.addButton("修改");
	var rfBtn = btnsBar.addButton("刷新");
	var delBtn = btnsBar.addButton("删除",delAdmin);
	var modwin = ds.bindMod(modBtn,modMultiDomainAdminProps);
	var addwin = ds.bindAdd(addBtn,addMultiDomainAdminWinProps);
	ds.createDataTable(_G("tableBlock"), tableProps);
	ds.bindRefresh(rfBtn);
	//ds.bindDel(delBtn);
	ds.remoteListData();
	
	function delAdmin(){
		if(!confirm('您确认要删除所选数据？')){
			return;
		}
		var deluids = ds.getSelectedDatas();
		var uids="";
		deluids.each(function(data) {
			uids +="&uid=" + data.uid;
		});
		var  url = dataSourceProps.delURL + "?" +uids;
		SkyDNA.Ajax.doRequest(url);
		ds.remoteListData();
	}
}

main();
</script>
</html>
