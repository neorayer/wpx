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
		<td align="left" id="title_Font1">模块开关</td>
		<td align="right" id="title_Font2"></td>
	</tr>
</table>

<br/>
<table align="center">
<tr>
<td style="border:2px solid #c3d9ff">

	<table id="MF_table" border=0 >
	<tr id="MF_table_headTr" >
		<td>功能名称</td>
		<td>功能编号</td>
		<td align="center">开放状态</td>
		<td align="center" >操作</td>
	</tr>
	
	<c:forEach var="modfunc" items="${modFuncs}">
		
		<tr>
			<td><c:out value='${modfunc.funcName}'/></td>
			<td><c:out value='${modfunc.funcId}'/></td>
			<td align="center">
				<c:if test="${modfunc.status == 0}"><span style='color:green'>已打开</span></c:if>
				<c:if test="${modfunc.status == 3}"><span style='color:red'>已关闭</span></c:if>
			</td>
			<td align="center" >
				<c:if test="${modfunc.funcId ne 'mail'}">
				<input type="button" value="打开" <c:if test="${modfunc.status == 0}">disabled</c:if> onclick="javascript:doModFunc('<c:out value='${modfunc.funcId}'/>', 0)" />
				<input type="button" value="关闭" <c:if test="${modfunc.status == 3}">disabled</c:if> onclick="javascript:doModFunc('<c:out value='${modfunc.funcId}'/>', 3)" />
				</c:if>
			</td>
		</tr>
	</c:forEach>
	</table>

</td>
</tr>
</table>
</body>
</html>