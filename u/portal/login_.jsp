<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String host = request.getHeader("host");
	boolean isIP = false;
	try{
		Integer.parseInt(host.split("\\.")[0]);
		isIP = true;
	}catch(Exception e) {
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"> 
<html>
<head>
<base href="<c:out value='${ProjectBase }u/'/>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<c:out value='${ProjectBase }'/>_js/cookie.js"></script>
<title>WPX3 邮件系统</title>
<style type="text/css">
body{
	background-color: #527c98;
	margin:0;
	padding:0;
}

.error {
	color: red;
}
#loginfrm .btn{
	margin:0;
	padding:0;
	display:block;
	width:68px;
	height:28px;
	background:url(portal/login/button.gif) 0 0 no-repeat #f1f1f1;
	border:none;
}
#loginfrm .btn:hover{
	background:url(portal/login/button.gif) 0 -41px no-repeat #f1f1f1;
	border:none;	
}
#loginfrm  .t{
	font-family:宋体;
}
#loginfrm  .t,
#loginfrm  .c{
	font-size:12px;
	padding:3px 0 3px 0;
}
#loginfrm span.abtn{
margin-left:80px;
margin-top:-20px;
display:block;
}
#loginfrm span.abtn a{
	margin-left:3px;
	margin-right:3px;
	text-decoration:none;
	font-size:12px;
}
#loginfrm span.abtn a:hover{
	text-decoration:underline;
}
table.body{
	margin:80px auto 0 auto;
	background:url(portal/login/bg.jpg) repeat-x 0 0;
	width:100%;
}
table.body{
	margin:80px auto 0 auto;
	background:url(portal/login/bg.jpg) repeat-x 0 0;
	width:100%;
}
</style>

<script language="javascript">
function loginForKeyDown(e){
	if(e.keyCode==13) document.loginfrm.submit();
}


window.onload = function(){
	if(navigator.appVersion.toLowerCase().match(/msie 6/)){
	    try {
	        document.execCommand("BackgroundImageCache", false, true);
	    }catch (e) {}
	}
	deleteCookie("uia_param", '<%=request.getContextPath()%>');
};

</script>
</head>

<body>
<c:if test="${timeout}">
<script type="text/javascript">
	window.location="<c:out value='${ProjectBase }login.html'/>";
</script>
</c:if>

<table border="0" cellspacing="0" cellpadding="0" align="center" class="body">
  <tr>
  	<td>&nbsp;</td>
    <td width="161"><img src="portal/login/1.jpg" width="161" height="135"></td>
    <td width="134"><img src="portal/login/2.jpg" width="134" height="135"></td>
    <td width="337"><img src="portal/login/3.jpg" width="337" height="135"></td>
	<td width="295" align="left"><img src="portal/login/4.jpg" width="219" height="135"></td>

  	<td>&nbsp;</td>
  </tr>
  <tr>
  	<td>&nbsp;</td>
    <td><img src="portal/login/5.jpg" width="161" height="241"></td>
    <td><img src="portal/login/6.jpg" width="134" height="241"></td>
    <td background="portal/login/7.jpg" valign="top">
		<form method="post" onkeydown="loginForKeyDown(event);" action="login.html" name="loginfrm" id="loginfrm">
			<table width="77%" height="141"  border="0" align="center" cellpadding="0" cellspacing="0">

			  <tr>
				<td colspan="2" class="t error"><c:out value="${REASON}" default="&nbsp;" escapeXml="false"/></td>
			  </tr>
			  <tr>
				<td class="t">用户名</td>
				<td class="c"><input name="uid" type="text" value="<c:out value='${username }'/>" size="28" style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; "></td>
			  </tr>

			  <tr>
				<td class="t">域&nbsp;&nbsp;名</td>
				<td class="c">
				<% if(isIP){	%>	
					<select name="dc" style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; ">
						<c:forEach var="domain" items="${domains}">
							<option value="<c:out value='${domain.dc}' />"><c:out value='${domain.dc}' /></option>
					 	</c:forEach>
					 	
					 	<c:forEach var="da" items="${domainAlias}">
							<option value="<c:out value='${da.dc}' />"><c:out value='${da.dc}' /></option>
					 	</c:forEach>
					</select>
				<%}else if(host.indexOf(":")!= -1){  %>
				<span  style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10pt; "><%= host.substring(5,host.indexOf(":")) %></span> 
					<input name="dc" value="<%= host.substring(5,host.indexOf(":")) %>" type="hidden">
				<%}else{%>
				<span  style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10pt; "><%= host.substring(5) %></span> 
					<input name="dc" value="<%= host.substring(5) %>" type="hidden">
				<%} %>
				</td>

			  </tr>
			  <tr>
				<td class="t">密&nbsp;&nbsp;码</td>
				<td class="c"><input name="userpassword" type="password" value="" size="28"  style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; "></td>
			  </tr>
			  
			 <c:if test="${REASON != null}">
				 <tr>
					  	  <td class="t">验证码</td>
					  	  <td class="c">
					  	  <input id="imgCode" name="imgCode" value="" type="text" size="6" style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; "/>
		                  <img id="AuthImg" align="top" src="authImage.authImage" align="absmiddle" title="单击刷新验证码"/>
		                  <a href="javascript:Util.refreshAuthImage();"  style="text-decoration: none;color: red; display: none;" >[刷新]</a>
					  	  </td>
	              </tr>
			  </c:if>
			  
			  <tr valign="middle">
				<td>&nbsp;</td>
				<td class="c"><a href="login.jsp" onClick="javascript:document.loginfrm.submit();return false;" tabindex="5" title="登录系统" target="_self" class="btn"></a>

				<span class="abtn" style="display: none;"><a href="register.html" target="_blank">用户注册</a><a href="#" target="_blank">忘记密码</a></span></td>
			  </tr>
			</table>
		</form>	
	</td>
	<td><img src="portal/login/8.jpg" width="219" height="241"></td>
  	<td>&nbsp;</td>
  </tr>

  <tr>
  	<td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  </tr>
</table>


</body>
</html>
