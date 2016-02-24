<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="com.skymiracle.wpx.admin.*"
	import="com.skymiracle.wpx.domain.*"
	import="com.skymiracle.wpx.*"
	import="java.util.*"
%>
<%
	DomainService ds = ServiceFactory.getDomainService(request);
	List domainlist = ds.getDomainList();
	Domain[] domains = new Domain[0];
	if(domainlist.size()>0)
		domains = (Domain[])domainlist.toArray(new Domain[0]);

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>WorldPost X2 Administrator</title>
	<link href="../../style/css.css" type="text/css" rel="stylesheet">	  	
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
    <td width="192"><img src="login/1.jpg" width="192" height="144"></td>
    <td width="324"><img src="login/2.jpg" width="324" height="144"></td>
  </tr>
  <tr>
    <td><img src="login/3.jpg" width="192" height="204"></td>
    <td background="login/4.jpg" id="mainDiv"></td>
  </tr>
  <tr>
    <td><img src="login/5.jpg" width="192" height="54"></td>
    <td><img src="login/6.jpg" width="324" height="54"></td>    
  </tr>
</table>
  	<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
	<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
	<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
	<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
	<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
	<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
	<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />

	<script language="javascript">

	function doEnter() {
	window.location.href = "main.jsp";
		}

		with(SkyDNA.Element){
			with(createForm(_G("mainDiv"),{formURL:"../../do/portal/login.jsp", onSubmitSucc: doEnter})){
				addInputText("username","用户名");
				addInputPassword("password","密&nbsp;&nbsp;码");
				addSelect("role","管理员",{optionMap:{"<%=Admin.TYPE_SUPER%>":"超级管理员","<%=Admin.TYPE_MULTIDOMAIN%>":"多域管理员","<%=Admin.TYPE_DOMAIN%>":"域管理员","<%=Admin.TYPE_ADDRESSBOOK %>":"公共地址簿管理员"},value:"<%=Admin.TYPE_SUPER%>"});
				addSelect("dc","所属域",{optionMap:{"":""<%for(int i=0;i<domains.length;i++){%>,"<%=domains[i].getDc()%>"  :  "<%=domains[i].getDc()%>"<%	}%>}});
				addSubmit();
			}
		}	
	</script>
</body>
</html>
