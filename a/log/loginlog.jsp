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
<td align="left" id="title_Font1">登录日志</td>
<td align="right" id="title_Font2"></td></tr></table>
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
		uuid: {title: "uuid", isKey: true},
		account: {title: "帐号"},
		domain: {title: "域",ftype: "Hash",optionMap: {
				"":"",
				<c:forEach var="domain" items="${domains}" varStatus="status">
					<c:out value="'${domain.dc}' : '${domain.dc}'" escapeXml="false"/>
					<c:if test="${!status.last}">,</c:if>
				</c:forEach>
			}
		},
		time: {title: "时间"},
		type: {title: "方式"},
		ip: {title: "IP"},
		fromtime: {title: "起始时间", defaultValue: beginTime, ftype: "DateTime",validate:VF_noEmpty},
		totime:{title: "终止时间", defaultValue: endTime, ftype: "DateTime",validate:VF_noEmpty}
	};
	
	var dataSourceProps = {
		listURL: "../log/listLoginLog.json"
	}
	
	var tablepros = {
		subjects: ["account","domain","time","type","ip"],
		isCheckbox: true
	};
	
	
	var srchWinProps = {
		subjects: ["account", "domain", "fromtime", "totime"],
		title:"登录日志查询",
		width: 400,
		height:247,
		formURL: "../log/listLoginLog.json"
	}

	function main() {
		var ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
		with(SkyDNA.Element.createButtonsBar(_G("toolsBlock"))) {
			ds.bindSearch(addButton("登录日志查询"), srchWinProps);
			ds.createPageBar(_G("toolsBlock"), "pagenum","perpagecount",{countPerPage:15});
			ds.createDataTable(_G("userTableBlock"), tablepros);
			ds.remoteListData();
		}
		
	}

	main();
</script>
</html>
