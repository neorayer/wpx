<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet" />
<style type="text/css">
#MFheadTable {
	background-color:#236fbd;
	color:#ffffff;
}

#MF_table {
	width:600px;
	
}

#MF_table_headTr {
	background-color:#c3d9ff;
}

#MF_table_headTr td {
	padding:5px;
}
</style>
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

<script type="text/javascript">
function doModFunc(funcId, status) {
	var url = "../conf/doModFunc.json?funcid=" + funcId + "&status=" + status;
	var res = SkyDNA.Ajax.doRequestJSON(url);
	if (res.res == 1) {
		window.location.href += "?" + Math.random();
	}
			
}
</script>
</head>
<body>
<table id="MFheadTable" border=0 width="100%" height="40px" cellspacing="0">
	<tr>
		<td algin="left" width=41 class="title_BarImg"></td>
		<td align="left" id="title_Font1">系统监控</td>
		<td align="right" id="title_Font2"></td>
	</tr>
</table>

<br/>
<table align="center">
<tr>
<td style="border:2px solid #c3d9ff">

	<table id="MF_table" border=0 >
	<tr id="MF_table_headTr" >
		<td>监控内容</td>
		<td>系统参数</td>
	</tr>
	
	<tr>
		<td>cpu：</td>
		<td><c:out value='${sys.cpuUsage}'/></td>
	</tr>
	
	<tr>
		<td>系统内存：</td>
		<td><c:out value='${sys.memUsage}'/></td>
	</tr>
	
	<tr>
		<td>磁盘空间：</td>
		<td><c:out value='${sys.deskUsage}'/></td>
	</tr>
	
	
	
	<tr>
		<td>空闲内存：</td>
		<td><c:out value='${freeMemory}'/></td>
	</tr>
	
	<tr>
		<td>最大内存：</td>
		<td><c:out value='${maxMemory}'/></td>
	</tr>
	
	<tr>
		<td>内存总量：</td>
		<td><c:out value='${totalMemory}'/></td>
	</tr>
	
	<tr>
		<td>内存总量：</td>
		<td><c:out value='${availableProcessors}'/></td>
	</tr>
	
	</table>

</td>
</tr>
</table>
</body>
</html>