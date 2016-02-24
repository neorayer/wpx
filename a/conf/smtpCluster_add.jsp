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

</head>
<body>
<table id="MFheadTable" border=0 width="100%" height="40px" cellspacing="0">
	<tr>
		<td algin="left" width=41 class="title_BarImg"></td>
		<td align="left" id="title_Font1">SMTP集群</td>
		<td align="right" id="title_Font2"></td>
	</tr>
</table>

<br/>

<table align="center">
<tr>
<td>
<DIV id="SOR_EXCEPTION" style="color:red"><c:out value="${REASON}" /></DIV>
<form action="../conf/smtpCluster_add.html" method="post" >
	增加集群内设备IP:<input name="ip" type="text" value="127.0.0.1" size="15" />
	说明：<input name="description" type="text" size="44"  />
	<input type="submit" value="增加" />
</form>
</td>
</tr>
<tr>
<td style="border:2px solid #c3d9ff">
	<jsp:include page="smtpCluster_list.jsp"></jsp:include>
	<hr size=1 />
	<div style="padding:4px">说明：增加或删除IP后，修改后的数据将于5秒内，在SMTP服务中生效。</div>
</td>
</tr>
</table>
</body>
</html>