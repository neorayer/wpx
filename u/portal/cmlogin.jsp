<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String host = request.getHeader("host");
	if(host != null && host.equalsIgnoreCase("localhost"))
		host = "127.0.0.1";
	boolean isIP = false;
	try{
		Integer.parseInt(host.split("\\.")[0]);
		isIP = true;
	}catch(Exception e) {
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<c:out value='${ProjectBase }u/portal/'/>">
<title>崇明宽带邮件系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css">
<!--
body {  color: #333333; font-size: 12px; background-color: #FFFFFF; font-family: "MS Shell Dlg", "Tahoma", "宋体"; scrollbar-highlight-color: buttonface; scrollbar-shadow-color: buttonface; scrollbar-3dlight-color: buttonhighlight; scrollbar-track-color: #eeeeee; scrollbar-darkshadow-color: buttonshadow}
pre {  color: #333333; font-family: "MS Shell Dlg", "Tahoma", "宋体"; font-size: 12px}
td {  color: #333333; font-size: 12px}
.chinese {  font-family: "宋体"; font-size: 12px}
.english {  font-family: "Arial", "Helvetica", "sans-serif"; font-size: 12px}
.editbox {  width:151px; height: 20px}
-->
</style>


<script language="javascript">
<!--
	function open_getpwd_win()
	{
		//window.open("/wdregist/rg_get_pwd.php", "win_getpwd", "toolbar=no,resizable=no,scrollbars=no,status=0,left=80, top=60,width=400,height=150");
	}
-->
</script>
<link rel="stylesheet" href="css_mail.css" type="text/css">
<link rel="stylesheet" href="css_mail.css" type="text/css">
</head>

<body background="logincm/bj.jpg">
<table width="775" height="57" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="775"><img src="logincm/yx_r1_c1.jpg" width="775" height="100"></td>
  </tr>
</table>
<table width="775" height="57" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="130"><img src="logincm/yx_r2_c1.jpg" width="130" height="309"></td>
    <td width="389" background="logincm/yx_r2_c3.jpg"><br>
      <table width="271" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td width="271">
            <div align="center"><strong><font size="2">　　</font>用户登陆</strong></div>
          </td>
        </tr>
      </table>
      <table width="380" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="143" width="1">&nbsp;</td>

          <td width="387" valign="top"> <form name="form1" method="post" action="<c:out value='${ProjectBase }login.html'/>">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" class="d">
              	<tr> 
                  <td colspan="2" style="text-align: center;color: red;"> 
                  	<c:out value="${REASON}" default="&nbsp;" escapeXml="false"/>
                  </td>
                </tr>
                <tr> 
                  <td width="19%"> 
                    <div align="right">用户名：</div>
                  </td>
                  <td width="43%"> <input name="uid" type="text" class="inputnormal" id="uid"></td>
                </tr>
                <tr> 
                  <td width="19%"> <div align="right"> 
                      <p>域 名： 
                    </div></td>
                  <td>
                  	<% if(isIP){	%>	
			          <select name="dc" class="inputnormal">
			            <c:forEach var="domain" items="${domains}">
							<c:out value="<option value='' ></option>" />
							<option value="<c:out value='${domain.dc}' />"><c:out value='${domain.dc}' /></option>
					 	</c:forEach>
			          </select>
					<%}else{  %>
						<strong><%= host.substring(5) %></strong>
						<input name="dc" value="<%= host.substring(5) %>" type="hidden">
					<%}%>
                  </td>  
                </tr>
                <tr> 
                  <td width="19%"> <div align="right"> 
                      <p>密　码： 
                    </div></td>
                  <td><input name="userpassword" type="password" class="editbox" id="field_opass"><!--　　　<a href="/wdregist/tk.htm"><font class="normal">免费注册</font></a> -->
                  </td>  
                </tr>
                <tr> 
                  <td height="32">&nbsp;</td>
                  <td height="32"><input type="image" border="0" name="button_login" src="logincm/icon2.gif" width="44" height="18">

                    　<a href="javascript:open_getpwd_win()"><img src="logincm/icon3.gif" width="67" height="18" border="0"></a>　 
                  </td>
                </tr>
              </table>
            </form>
            
          </td>
        </tr>
      </table>
      <table width="91%" height="74" border="0" align="center" cellpadding="0" cellspacing="0">

        <tr> 
          <td height="74" valign="top" class="d">本系统支持WEB或者POP3收发邮件。<br>
            如果要使用OUTLOOK等软件收发邮件，请注意：<font size="2"><br>
            <br>
            </font>SMTP服务器和POP3服务器都是 <font color="#FF0000">mail.cm.net.cn</font><br>
            SMTP服务器需要身份验证，用户名要填<font color="#FF0000">&nbsp;user@cm.net.cn</font></td>

        </tr>
      </table>
      <br>
      <table width="87%" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr> 
          <td> <div align="right"><a href="login.html#"><img src="logincm/help.gif" width="67" height="18" border="0"></a></div></td>
        </tr>
      </table></td>
    <td width="256"><img src="logincm/yx_r2_c2.jpg" width="256" height="309"></td>

  </tr>
</table>
<table width="775" height="57" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="775"><img src="logincm/yx_r3_c1.gif" width="775" height="86" border="0" usemap="#Map"></td>
  </tr>
</table>
<map name="Map">
  <area shape="rect" coords="561,49,661,64" href="mailto:master@cm.net.cn">
</map>
</body>
</html>
