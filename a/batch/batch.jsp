<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/user.css" type="text/css" rel="stylesheet">
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
<td align="left" id="title_Font1">群发邮件</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="userTableBlock" class="tableBlock" align="center">
</div>


</body>
<script language="javascript">
var dataStruct = {
	uuid: {title: "UUID", isKey: true},
	title: {title: "主题:"},
	content: {title:  "内容",ftype: "StringBuffer"},
	ou: {
		title: "发往部门",
		ftype: "Hash",
		optionMap: {
			"0" : "",
			<c:forEach var="dept" items="${depts}" varStatus="status">
				<c:out value='"${dept.ou}": "${dept.description}"' escapeXml="false"/>
				<c:if test="${!status.last}">,</c:if>
			</c:forEach>
		}
	},
	domain: {title: "发往域",ftype: "Hash",optionMap: {'<c:out value='${dc}'/>' : '<c:out value='${dc}'/>'}},
	time: {title: "发送时间"},
	state: {title: "状态",ftype: 'Hash',optionMap: {"sended" : "已发送","error": "发送出错","new" : "未发送"}}
};


var dataSourceProps = {
	listURL: "../batch/listbatch.json?dc=" + "<c:out value='${dc}'/>",
	delURL: "../batch/delbatch.json"
};


var sendSysBatchWin = {
	width: 700,
	height:432,
	subjects: ["title", "domain","ou","time","content"],
	isForgetDataStructKey: true
};


var tablepros = {
	subjects: ["title","time","domain","ou","state"],
	isCheckbox: true
};

var ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);
function main(){
	var btnsBar = SkyDNA.Element.createButtonsBar(_G("toolsBlock"));
	var sysnotBtn = btnsBar.addButton("发送群发邮件",sendBatch);
	var delBtn = btnsBar.addButton("删除群发邮件");
	rfBtn = btnsBar.addButton("刷新");
//	var birthBtn = btnsBar.addButton("发送生日邮件",sendBirthMail);
	ds.createDataTable(_G("userTableBlock"), tablepros);
	//ds.bindAdd(sysnotBtn,sendSysBatchWin);
	ds.bindRefresh(rfBtn);
	ds.bindDel(delBtn);
	//ds.createPageBar(_G("toolsBlock"),"pagenum","perpagecount",{countPerPage:1});
	
	ds.remoteListData();
}
function sendBatch() {
	window.parent.frames['contentFrame'].location = "sendBatch.html?dc=" +"<c:out value='${dc}'/>";
}

main();
</script>
</html>