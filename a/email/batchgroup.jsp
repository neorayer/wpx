<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/email.css" type="text/css" rel="stylesheet">
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
<td align="left" id="title_Font1">群发组管理</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="userTableBlock" class="tableBlock" align="center">
</div>
</body>
<script language="javascript">
var depDesc = [];
<c:forEach var="dept" items="${deplist}"><c:out value='depDesc["${dept.ou}"] = "${dept.description}";' escapeXml="false"/></c:forEach>

var dataStruct = {
	uuid: {title: "编号", isKey: true},
	name: {title: "名称"},
	cdn: {title:  "条件",ftype: "StringBuffer"}
};

var tablepros = {
	subjects: ["name","cdn"],
	isCheckbox: true
};

var dataSourceProps = {
	listURL: "../email/batchgroups.json",
	delURL: "../email/delbatchgroup.json"
};

var ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);
function main(){
	var btnsBar = SkyDNA.Element.createButtonsBar(_G("toolsBlock"));
	var addBtn = btnsBar.addButton("新建组",addBatchGroup);
	var modBtn = btnsBar.addButton("修改组",modBatchGroup);
	var delBtn = btnsBar.addButton("删除组");
	var vigcBtn = btnsBar.addButton("查看分组用户", viGroupUser);
	rfBtn = btnsBar.addButton("刷新");
	ds.createDataTable(_G("userTableBlock"), tablepros);
	ds.bindDel(delBtn);
	ds.bindRefresh(rfBtn);
	ds.remoteListData();
}

function addBatchGroup() {
	window.parent.frames['contentFrame'].location = "addbatchgroup.html";
}

function modBatchGroup() {
	var uuid = "";
	try{
		uuid = ds.getActiveData().uuid;
		if(uuid == '')
			return;
	}
	catch(e) {
		return;
	}
	window.parent.frames['contentFrame'].location = "addbatchgroup.html?uuid=" + uuid;
}

function viGroupUser() {
	var uuid = ds.getActiveData().uuid;
	var name = ds.getActiveData().name;
	
	userwin = SkyDNA.Element.createPopupWin({title: name + "分组用户",width: 600,height:400});
	var userDsProps = {
		dataStruct : {
			dc: {title: "域名"},
			uid: {title: "帐号" , isKey: true},
			displayname: {title: "姓名"},
			ou:{title:"部门",defaultValue:""}
		},
		listURL: "viUsersByGroup.json?uuid=" + uuid
	};
	var tableProps = {
		subjects: ['dc', "uid","displayname","ou"],
		isCheckbox : false, 
		filter:{
			ou:function(v){
				if(depDesc && depDesc[v])
					return depDesc[v];
				else
					return v;
			}
		}
	}
	var UserDataSource = new SkyDNA.DataSource(null, userDsProps);
	var listCtr = _CC("div", null, userwin.contentDom);
	UserDataSource.createDataTable(listCtr, tableProps);
	UserDataSource.remoteListData();
}

main();
</script>
</html>