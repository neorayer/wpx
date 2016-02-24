<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<script type="text/javascript" src="/DNA/jsDNA/calendar/calendar.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/calendar/calendar-zh.js"></script>
<link href="/DNA/jsDNA/calendar/skin/theme.css" type="text/css" rel="stylesheet" />

<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/log.css" type="text/css" rel="stylesheet">
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/log.png', sizingMethod='crop');
}
</style>
<![endif]-->
</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock"> 
<table border=0 width="100%" height="100%" cellspacing="0"><tr> 
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1">邮件日志</td>
<td align="right" id="title_Font2"></td>
</tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="userTableBlock" class="tableBlock" align="center">
</div>
</body>

<script language="javascript"> 
	var date = new Date();
	var beginTime = date.print("%Y/%m/%d 00:00:00");
	var endTime = date.print("%Y/%m/%d %H:%M:%S");

	var dataStruct = {
		sendtime: {title: "发送时间"},
		mailtype: {title: "类型",ftype: "Hash", optionMap: {"DELIVER": "发信", "RELAY": "收信"}},
		mailfrom: {title: "发信人"},
		rcptto: {title: "收信人"},
		size: {title: "大小"},
		result: {title: "结果",ftype: "Hash", optionMap: {"S": "成功", "F": "失败", "": "不限"}},
		cause: {title: "原因"},
		remark: {title: "备注"},
		fromtime: {title: "起始时间", defaultValue: beginTime, ftype: "DateTime",validate:VF_noEmpty},
		totime:{title: "终止时间", defaultValue: endTime, ftype: "DateTime",validate:VF_noEmpty}
	};
	
	var dataSourceProps = {
		listURL: "../log/listmaillog.json"
	}
	
	var tablepros = {
		subjects: ["mailtype", "result", "sendtime","mailfrom","rcptto","size","cause","remark"],
		isCheckbox: true
	};
	
	var	ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
	
	var srchWinProps = {
		subjects: ["mailtype", "result", "mailfrom", "rcptto", "fromtime", "totime"],
		title:"发送信件日志查询",
		width: 400,
		height:247,
		formURL: "../log/listmaillog.json"
	}

	function main() {
		with(SkyDNA.Element.createButtonsBar(_G("toolsBlock"))) {
			ds.bindSearch(addButton("发送信件日志查询"), srchWinProps);
			ds.createPageBar(_G("toolsBlock"), "pagenum","perpagecount",{countPerPage:15});
			ds.createDataTable(_G("userTableBlock"), tablepros);
			ds.remoteListData();
		}
		
	}	

	main();
</script>
</html>
