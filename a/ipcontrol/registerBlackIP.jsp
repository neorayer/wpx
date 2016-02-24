<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/ipcontrol.css" type="text/css" rel="stylesheet" />
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/ipcontrol.png', sizingMethod='crop');
}
</style>
<![endif]-->
</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1">注册端IP黑名单</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="domainTableBlock" class="tableBlock"></div>
</body>
<script type="text/javascript">
function cr(){
	var dataStruts = {
		fromip: {title: "起始IP地址",validate:VF_isIP},
		toip:{title: "结束IP地址",validate:VF_isIP},
		dc:{title: "域名地址", ftype: "Hash", optionMap: {"":"所有域",<c:forEach var="domain" items="${domains}" varStatus="status">"<c:out value="${domain.dc}"/>":"<c:out value="${domain.dc}"/>"<c:if test="${!status.last}">,</c:if></c:forEach>}},
		uuid: {title: "UUID", isKey: true}
		}
	
	var addIPWinProps = {
	width: 400,
	height:247,
	isForgetDataStructKey: true,
	subjects: ["fromip","toip","dc"]
}

	var dataSourceProps = {
		listURL: "../ipcontrol/listregisterBlackIP.json",
		addURL: "../ipcontrol/addregisterBlackIP.json"
	}

	var dataTableProps = {
		isCheckbox: true,
		subjects: ["fromip","toip","dc"]
	}

	var butBar = SkyDNA.Element.createButtonsBar(_G("toolsBlock"));
	var addBtn = butBar.addButton("添加IP");
	var delbtn = butBar.addButton("删除IP" , delip);
	var dataSource = new SkyDNA.DataSource(dataStruts,dataSourceProps);
	dataSource.createDataTable(_G("domainTableBlock"), dataTableProps);
	
	dataSource.bindAdd(addBtn,addIPWinProps);
	//dataSource.bindDel(delbtn);
	dataSource.remoteListData();
	
	function delip(){
		if(!confirm('您确认要删除所选数据？')){
			return;
		}
		
		var delIP = dataSource.getSelectedDatas();
		var uuids="";
		delIP.each(function(data) {
			uuids += "&uuid=" + data.uuid;
		});
		var url = "../ipcontrol/delregisterBlackIP.json?" + uuids;
		SkyDNA.Ajax.doRequest(url);
		dataSource.remoteListData();
	}
}

cr();
</script>
</html>