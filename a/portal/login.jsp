<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<c:out value='${ProjectBase }'/>">
<title>WorldPost X3 Administrator</title>

<c:import url="_pub/common_head.jsp"></c:import>
<link href="a/_css/css.css" type="text/css" rel="stylesheet">	  

<style type="text/css">
body{
	background-color: #073b6e !important;
	margin:0;
	padding:0;
}
form.SDC_Form{	
	width:auto !important;
}
form.SDC_Form td{
	color:#fff;
	width:80px;
}
form.SDC_Form table{
	text-align:center;
}
.SDC_Button_Title{
	color:#000;
}
</style>
<script language="javascript">if(navigator.appVersion.match(/\bMSIE 6\b/)) document.execCommand("BackgroundImageCache", false, true);</script>
</head>

<body>
<table height="196"  style="table-layout:fixed;"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="192"><img src="a/portal/login/1.jpg" width="192" height="144"></td>
    <td width="324"><img src="a/portal/login/2.jpg" width="324" height="144"></td>
  </tr>
  <tr>
    <td><img src="a/portal/login/3.jpg" width="192" height="204"></td>
    <td background="a/portal/login/4.jpg" id="mainDiv"></td>
  </tr>
  <tr>
    <td><img src="a/portal/login/5.jpg" width="192" height="54"></td>
    <td><img src="a/portal/login/6.jpg" width="324" height="54"></td>    
  </tr>
</table>

	<script language="javascript">
	window.onload = function() {
		if (top.location != self.location)
			top.location=self.location;
	}
	function doEnter() {
		window.location.href = "<c:out value='${ProjectBase }'/>a/main.html";
	}

	with(SkyDNA.Element){
		with(createForm(_G("mainDiv"),{formURL:"a/login.json", onSubmitSucc: doEnter})){
			addInputText("username","用户名");
			addInputPassword("password","密&nbsp;&nbsp;码");
			addSelect("admintype","管理员",{
					optionMap:{
						"super":"超级管理员",
						"multidomain":"多域管理员",
						"domain":"域管理员",
						"addressbook":"公共地址簿管理员"
					},
					value:"super"
				}
			);
			addSelect("dc","所属域",{
				optionMap:{
					"":""
					<c:forEach var="domain" items="${domains}" varStatus="status">
						<c:if test="${status.first}">,</c:if>
						<c:out value="'${domain.dc}' : '${domain.dc}'" escapeXml="false"/>
						<c:if test="${!status.last}">,</c:if>
					</c:forEach>
				}
			});
			
			
			addSubmit();
		}
	}
	</script>
</body>
</html>
