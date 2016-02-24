<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementPortal.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />

<link href="../_css/css.css" type="text/css" rel="stylesheet" />
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_HeadImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/logo.png', sizingMethod='crop');
}
</style>
<![endif]-->
</head>
<style type="text/css">
#exitBtn {
	margin-right: 10px;
	cursor: pointer;
}
</style>
<body>

<div id="pgHead">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=423 class="title_HeadImg"></td>
<td align="right"><input style="width:120px" type="button" id="exitBtn" class="SDC_Button" onclick="exitSystem();" value="退出系统" /></td>
</tr></table>
</div>
<div id="mainDiv"></div>
</body>
<script type="text/javascript">
function crTabBox(){
	var theDiv = _G("mainDiv");
	//超级管理员
	<c:if test="${admin.roleID eq 'super'}">
		var arr1 = ["子邮局管理","用户管理","管理员","全局管理","IP访问控制","邮件群发","日志查询"];
		var arr2 = ["domain","user","admin","conf", "ipcontrol","email","log"];
	</c:if>
	
	//域管理员
	<c:if test="${admin.roleID eq 'domain'}">
		var arr1 = ["用户管理", "邮件群发", "日志查询"];
		var arr2 = ["user", "email", "log"];
	</c:if>
	
	//多域管理员
	<c:if test="${admin.roleID eq 'multidomain'}">
		var arr1 = ["子邮局管理", "用户管理","邮件群发" ,"日志查询"];
		var arr2 = ["domain", "user", "email", "log"];
	</c:if>
	
	//公共地址簿管理员
	<c:if test="${admin.roleID eq 'addressbook'}">
		var arr1 = ["用户管理"];
		var arr2 = ["user"];
	</c:if>
	
	with(SkyDNA.Element) {
		with(createTabBox(theDiv)){
			for(var i=0;i<arr1.length;i++){
				if(i == 0)
					addTab(arr1[i],{id: "tab_"+arr2[i], onOpen: openFrame.bind(this,arr2[i])}).setDown(true);
				else
					addTab(arr1[i],{id: "tab_"+arr2[i], onOpen: openFrame.bind(this,arr2[i])});
			}
		}
	}
}

function openFrame(name){
	window.parent.frames["mainFrame"].location = "../" + name + "/main.html";
}

function exitSystem(){
	window.parent.location.href = "logout.html";
}

crTabBox();
</script>
</html>