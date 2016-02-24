<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/user.png', sizingMethod='crop');
}
</style>
<![endif]-->
</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1"><c:out value='${dc}'/>子邮局管理员</td>
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
	'dc' : {
		title: '域名', 
		isKey: true, 
		ftype: "Hash",
		optionMap: {
			<c:forEach var="dc" items="${domains}" varStatus="status">
				<c:out value='"${dc.dc}": "${dc.dc}"' escapeXml="false"/>
				<c:if test="${!status.last}">,</c:if>
			</c:forEach>
		}
	},
	'userpassword': {title: '密码',ftype: "Password",validate: VF_passwd},
	'status': {title: '状态', ftype: "Hash", optionMap: {'open': '开通', 'pause': '暂停'}}
}


var tableProps = {
	subjects: ["uid", "dc", "status"],
	isCheckbox : true
}

var addAdminWinProps = {
	width: 400,
	height:247,
	subjects: ["uid", "userpassword", "dc", "status"],
	isForgetDataStructKey: true
}

var modAdminWinProps = {
	width: 400,
	height:247,
	subjects: ["userpassword","status"],
	hiddens: ["dc"]
}


var dataSourceProps = {
	listURL: "../admin/domainAdmins.json",
	addURL: "../admin/domainAdmin_add.json",
	modURL: "../admin/domainAdmin_mod.json",
	delURL: "../admin/domainAdmins_del.json"
}
function main() {
	var ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
	
	var btnsBar = SkyDNA.Element.createButtonsBar(_G("toolsBlock"));
	var addBtn = btnsBar.addButton("添加");
	var modBtn = btnsBar.addButton("修改");
	var rfBtn = btnsBar.addButton("刷新");
	var delBtn = btnsBar.addButton("删除");
	
	ds.bindAdd(addBtn,addAdminWinProps);
	ds.bindMod(modBtn,modAdminWinProps);
	ds.bindRefresh(rfBtn);
	ds.bindDel(delBtn);
	
	ds.createDataTable(_G("tableBlock"), tableProps);

	ds.remoteListData();
	
}


main();
</script>
</html>
