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
function restoreScriptPath() {
	if (!confirm("是否恢复出厂设置？"))
		return;
	window.location.href= "../conf/restoreScriptPath.html";		
}

function runScript(scriptKey) {
	if (scriptKey == "<c:out value='${SCK_startupServerPath}'/>") {
	}else if (scriptKey == "<c:out value='${SCK_shutdownServerPath}'/>") {
	}else if (scriptKey == "<c:out value='${SCK_startupWebPath}'/>") {
		alert("事实上，您在操作此管理台的同时，WEB服务已经处在运行状态中！");
		return;
	}else if (scriptKey == "<c:out value='${SCK_shutdownWebPath}'/>") {
		if (!confirm("请确认你是否真的运行此脚本？\r\n运行此操作后，您的管理控制台将随着WEB的停止而失效！随后您只能在命令行控制台中再次启动WEB服务。"))
			return;
	}
	var res = SkyDNA.Ajax.doRequestJSON("../conf/runScript.json?key=" + scriptKey);
	if (res.res == "0")
		alert(res.data);
}

function restartServer(){
	if (!confirm("是否确认重新启动邮件服务？"))
		return;
	var res = SkyDNA.Ajax.doRequestJSON("../conf/restartServer.json");
	if (res.res == "0")
		alert("服务重启失败，原因：\r\n\r\n" + res.data);
	else
		alert("服务重启成功！");
}

function restartWeb() {
	if (!confirm("是否确认重新启动WEB服务？\r\n重新启动WEB服务后，你需要重新登陆管理控制界面。"))
		return;
	var res = SkyDNA.Ajax.doRequestJSON("../conf/restartWeb.json");
	if (res.res == "0")
		alert("服务重启失败，原因：\r\n\r\n" + res.data);
	else
		alert("服务重启成功！");
}
//同步系统时间
function SynTime() {
	var res = SkyDNA.Ajax.doRequestJSON("../conf/synTime.json");
	if (res.res == "0")
		alert("时间同步失败，原因：\r\n\r\n" + res.data);
	else
		alert("时间同步成功！");
}

</script>
</head>
<body>

<table id="MFheadTable" border=0 width="100%" height="40px" cellspacing="0">
	<tr>
		<td algin="left" width=41 class="title_BarImg"></td>
		<td align="left" id="title_Font1">服务管理</td>
		<td align="right" id="title_Font2"></td>
	</tr>
</table>

<br/>

<form action="../conf/modScriptPath.html" method="post" />
<table align="center">
<tr>
<td style="border:2px solid #c3d9ff">
	<table id="MF_table" width=100%>
		<tr id="MF_table_headTr">
			<td>服务</td>
			<td>状态</td>
			<td>参数</td>
			<td>数值</td>
			<td>运行</td>
			<td>重新启动</td>
		</tr>
		<tr >
			<td rowspan=2 >邮件服务</td>
			<td><br/></td>
			<td><span style="font-weight:bold">启动</span>脚本路径</td>
			<td><input type="text" id="<c:out value='${SCK_startupServerPath}'/>"  name="<c:out value='${SCK_startupServerPath}'/>" value="<c:out value='${startupServerPath}'/>"  style="width:100%" /></td>
			<td><input type="button" value="运行" onclick="runScript('<c:out value='${SCK_startupServerPath}'/>')" <c:if test='${isServiceStart }'>disabled</c:if>/></td>
			<td rowspan=2 ><input type="button" value="重新启动"  onclick="restartServer()" /></td>
		</tr>
		<tr >
			
			<td><br/></td>
			<td><span style="font-weight:bold">停止</span>脚本路径</td>
			<td><input type="text" id="<c:out value='${SCK_shutdownServerPath}'/>" name="<c:out value='${SCK_shutdownServerPath}'/>" value="<c:out value='${shutdownServerPath}'/>"  style="width:100%" /></td>
			<td><input type="button" value="运行" onclick="runScript('<c:out value='${SCK_shutdownServerPath}'/>')" /></td>
			
		</tr>
		<tr >
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
		</tr>
		<tr >
			<td rowspan=2 >WEB服务</td>
			<td><br/></td>
			<td><span style="font-weight:bold">启动</span>脚本路径</td>
			<td><input type="text" id="<c:out value='${SCK_startupWebPath}'/>" name="<c:out value='${SCK_startupWebPath}'/>" value="<c:out value='${startupWebPath}'/>"  style="width:100%" /></td>
			<td><input type="button" value="运行" onclick="runScript('<c:out value='${SCK_startupWebPath}'/>')" disabled /></td>
			<td rowspan=2 ><input type="button" value="重新启动" onclick="restartWeb()" disabled/></td>
		</tr>
		<tr >
			
			<td><br/></td>
			<td><span style="font-weight:bold">停止</span>脚本路径</td>
			<td><input type="text" id="<c:out value='${SCK_shutdownWebPath}'/>" name="<c:out value='${SCK_shutdownWebPath}'/>" value="<c:out value='${shutdownWebPath}'/>" style="width:100%" /></td>
			<td><input type="button" value="运行" onclick="runScript('<c:out value='${SCK_shutdownWebPath}'/>')" /></td>
		</tr>
		<tr >
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
		</tr>
		<tr >
			<td>同步系统时间</td>
			<td><br/></td>
			<td><span style="font-weight:bold">shell命令</span>脚本</td>
			<td><input type="text" name="shellcmd" value="/usr/sbin/ntpdate 210.72.145.44"  style="width:100%" /></td>
			<td><input type="button" value="同步" onclick="SynTime()" /></td>
			<td rowspan=2 ><br/></td>
		</tr>
		<tr >
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
		</tr>
		<tr >
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			<td><input type="submit" value="保存提交" /><input type="button" value="恢复出厂设置" onclick="restoreScriptPath()" /></td>
			<td><br/></td>
			<td><br/></td>
		</tr>
	</table>
</td>
</tr>
</table>
</form>

</body>
</html>