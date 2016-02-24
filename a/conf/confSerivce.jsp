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

#MF_table  tr {
	height: 30px;
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
function restartServer(){
	if (!confirm("您更改过系统参数？\r\n\r\n是否确认重新启动邮件服务？"))
		return;
	var res = SkyDNA.Ajax.doRequestJSON("../conf/restartServer.json");
	if (res.res == "0")
		alert("服务重启失败，原因：\r\n\r\n" + res.data);
	else
		alert("服务重启成功！");
}

function modConf(){
	if (!confirm("您的此次更改需重新启动邮件服务，是否确认更改？"))
		return;
		
	document.ConfServieForm.submit();
}


</script>
</head>
<body>

<table id="MFheadTable" border=0 width="100%" height="40px" cellspacing="0">
	<tr>
		<td algin="left" width=41 class="title_BarImg"></td>
		<td align="left" id="title_Font1">系统参数设置</td>
		<td align="right" id="title_Font2"></td>
	</tr>
</table>

<br/>

<p align="center">
	<span style="color: red;">系统提示：更改完系统参数必须重启邮件服务才能生效</span>
</p>
<form id="ConfServieForm" name="ConfServieForm" action="../conf/confSerivce.html" method="post" />
<table align="center">
<tr>
<td style="border:2px solid #c3d9ff">
	<table id="MF_table" width=100%>
		<tr id="MF_table_headTr">
			<td width="30%">参数名</td>
			<td>参数值</td>
		</tr>
		<c:forEach var="conf" items="${confs}">
		<tr >
			<c:if test="${conf.keyname eq 'authmail.defaultDomain'}">
				<td>缺省域</td>
				<td>
					<input type="text" name="<c:out value='${conf.keyname}'/>" value="<c:out value='${conf.value}'/>"  style="width:100%" />
				</td>
			</c:if>
			<c:if test="${conf.keyname eq 'smtp.defaultUserMaxCc'}">
				<td>默认最大发件人数</td>
				<td>
					<input type="text" name="<c:out value='${conf.keyname}'/>" value="<c:out value='${conf.value}'/>"  style="width:100%" />
				</td>
			</c:if>
			
			<c:if test="${conf.keyname eq 'smtp.maxMessageSize'}">
				<td>默认最大邮件大小(单位：M)</td>
				<td>
					<input type="text" name="<c:out value='${conf.keyname}'/>" value="<c:out value='${conf.value}'/>"  style="width:100%" />
				</td>
			</c:if>
			
			<c:if test="${conf.keyname eq 'logger.level'}">
				<td>日志级别</td>
				<td>
					<select name="<c:out value='${conf.keyname}'/>">
						<option value="DEBUG" <c:if test='${conf.value eq "DEBUG"}'>selected="selected"</c:if>>调试级别</option>
						<option value="INFO" <c:if test='${conf.value eq "INFO"}'>selected="selected"</c:if>>明细级别</option>
						<option value="WARN" <c:if test='${conf.value eq "WARN"}'>selected="selected"</c:if>>警告级别</option>
						<option value="ERROR" <c:if test='${conf.value eq "ERROR"}'>selected="selected"</c:if>>错误级别</option>
					</select>
				</td>
			</c:if>
			<c:if test="${conf.keyname eq 'smtpservice.forceAuth'}">
				<td>smtp认证开关</td>
				<td>
					<select name="<c:out value='${conf.keyname}'/>">
						<option value="true" <c:if test='${conf.value}'>selected="selected"</c:if>>开通</option>
						<option value="false" <c:if test='${!conf.value}'>selected="selected"</c:if>>关闭</option>
					</select>
				</td>
			</c:if>
			
			
		</tr>
		</c:forEach>
		
		<tr >
			<td><br/></td>
			<td><br/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="保存提交" onclick="modConf()"/>
				
				<input type="button" value="重启邮件服务" onclick="restartServer()"/>
			</td>
		</tr>
	</table>
</td>
</tr>
</table>
</form>

</body>
</html>