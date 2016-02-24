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
<td align="left" id="title_Font1">超级管理员</td>
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
	'status': {title: '状态', ftype: "Hash",optionMap: {'open': '开通',  'pause': "暂停"},defaultValue:"open"}
}

var tableProps = {
	subjects: ["uid", "status"],
	isCheckbox : true
}

var dataSourceProps = {
	listURL: "../admin/superAdmin_list.json",
	addURL: "../admin/superAdmin_add.json",
	modURL: "../admin/superAdmin_mod.json",
	delURL: "../admin/superAdmins_del.json"
}

var addSuperAdminWinProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 400,
	height:247,
	subjects: ["uid", "userpassword", "status"],
	isForgetDataStructKey: true
}

var modSuperAdminProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 400,
	height:247,
	subjects: ["userpassword","status"]
}

function main(){
	var ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);
	var btnsBar = SkyDNA.Element.createButtonsBar(_G("toolsBlock"));
	var addBtn = btnsBar.addButton("添加");
	var modBtn = btnsBar.addButton("修改");
	var rfBtn = btnsBar.addButton("刷新");
	var delBtn = btnsBar.addButton("删除");
	var modwin = ds.bindMod(modBtn,modSuperAdminProps);
	var addwin = ds.bindAdd(addBtn,addSuperAdminWinProps);
	ds.createDataTable(_G("tableBlock"), tableProps);
	ds.bindRefresh(rfBtn);
	ds.bindDel(delBtn);
	ds.remoteListData();
}

main();
</script>
</html>
