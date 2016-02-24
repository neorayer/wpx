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
<td align="left" id="title_Font1">管理日志</td>
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
		account: {title: "帐号"},
		
		<c:choose>
			<c:when test="${'super' eq ACTOR.roleID}">
				role: {title: "角色",ftype: "Hash",optionMap: {"": "", "super" : "超级管理员","multidomain" : "多域管理员","domain" : "域管理员","addressbook" : "公共地址本管理员"}},
			</c:when>
			<c:when test="${'multidomain' eq ACTOR.roleID}">
				role: {title: "角色",ftype: "Hash",optionMap: {"": "", "multidomain" : "多域管理员","domain" : "域管理员","addressbook" : "公共地址本管理员"}},
			</c:when>
			<c:when test="${'domain' eq ACTOR.roleID}">
				role: {title: "角色",ftype: "Hash",optionMap: {"domain" : "域管理员"}},
			</c:when>
		</c:choose>
		
		<c:choose>
			<c:when test="${'domain' eq ACTOR.roleID}">
				domain: {title: "域", ftype: "Hidden", defaultValue: "1111"},
			</c:when>
			<c:otherwise>
				domain: {title: "管理域",ftype: "Hash",optionMap: {
						"":""
						<c:forEach var="domain" items="${domains}" varStatus="status">
							<c:if test="${status.first}">,</c:if>
							<c:out value="'${domain.dc}' : '${domain.dc}'" escapeXml="false"/>
							<c:if test="${!status.last}">,</c:if>
						</c:forEach>
					}
				},
			</c:otherwise>
		</c:choose>	

		
		
		
		optype: {title: "操作类型"},
		opdetail: {title: "操作信息"},
		time: {title: "时间"},
		ip: {title: "登录IP"} ,
		fromtime: {title: "起始时间", defaultValue: beginTime, ftype: "DateTime",validate:VF_noEmpty},
		totime:{title: "终止时间", defaultValue: endTime, ftype: "DateTime",validate:VF_noEmpty}
	};
	
	var dataSourceProps = {
		listURL: "../log/listSysLog.json"
	}
	
	var tablepros = {
		subjects: ["account","role","domain","optype","opdetail","time","ip"],
		isCheckbox: true
	};
	
	
	var srchWinProps = {
		subjects: ["role", "domain", "account", "fromtime", "totime"],
		title:"管理日志查找",
		width: 400,
		height:247,
		formURL: "../log/listSysLog.json"
	}

	function main() {
		var	ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
		with(SkyDNA.Element.createButtonsBar(_G("toolsBlock"))) {
			ds.bindSearch(addButton("管理日志查找"), srchWinProps);
			//console.debug(ds);
			ds.createPageBar(_G("toolsBlock"), "pagenum","perpagecount",{countPerPage:15});
			ds.createDataTable(_G("userTableBlock"), tablepros);
			ds.remoteListData();
		}
		
	}	

	main();

</script>
</html>
