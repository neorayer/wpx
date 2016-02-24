<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银川市商业银行电子邮件系统</title>
<!--邮件用户验证 -->
<SCRIPT language=javascript>
<!--
//////////////////////////////////////////////////
function go(e){
        if(e.keyCode==13)  
                loginSubmit();
} 

function loginSubmit() {
	var username = document.getElementById("usernameInput").value;
	var domain = document.getElementById("domainSelect").value;
	var password = document.getElementById("passwordInput").value;
	
//	username = username.trim();
//	domain = domain.trim();
//	password = password.trim();
	
	if (username == "") {
		alert("请输入用户名！");
		return false;
	}
	
	if (domain == "") {
		alert("请选择域名！");
		return false;
	}
	
	if (password == "") {
		alert("请输入密码！");
		return false;
	}
	
	var loginForm = document.getElementById("loginForm");
	loginForm.submit();
	
}

//////////////////////////////////////////////////
    var field_ouser='';
    var the_cookie=document.cookie;
    var each_cookie=the_cookie.split('; ');
   var style=0;
   for(var i=0;i<each_cookie.length;i++)
    {
        var  each_value=each_cookie[i].split('=');
        if(each_value[0]=='style')
            style=each_value[1];
        if(each_value[0]=='field_ouser')
            field_ouser=each_value[1];
    }

    function login_check()
    {
     if(document.login.field_ouser.value=="")
     {
        alert("请输入你的用户名.");
		 return false;
      }
     else if(document.login.field_opass.value=="")
     {
        alert("请输入你的密码.");
		 return false;
      }
      else
	  {
         return true;
	  }
    }
function read_cookie()
{
    for(i=0;i<document.images.length;i++)
    {
        var the_src=document.images[i].src;
        var the_src=the_src.replace(/\/img\//,'/img'+style+'/');
        document.images[i].src=the_src;
    }   
    if(field_ouser.indexOf('%40') != -1)
    {
        var field_ouser_value=field_ouser.split('%40')
        document.login.field_ouser.value=field_ouser_value[0];
        document.login.field_ovdomain.value=field_ouser_value[1];
	}
}

//-->
</SCRIPT>

<style type="text/css">
<!--
.bg1 {
	background-image: url(./images/fy2_01.jpg);
	background-position: top;
	background-repeat: no-repeat;
}
.pt9-180 {
	font-size: 9pt;
	line-height: 180%;
}
-->
</style>
</head>

<body background="./images/fy2.jpg" background-repeat= "no-repeat"  leftmargin="0" topmargin="0" >
<table width="752" height="480" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="./images/fy2_02.jpg"><table width="96%" height="369" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="274" height="130">&nbsp;</td>
          <td width="352">&nbsp;</td>
          <td width="96">&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td width="352" height="177" background="./images/kk.gif"><table width="96%" height="144" border="0" cellpadding="0" cellspacing="0" class="pt9-180">
              <form name="loginForm" id="loginForm" method="post" action="<c:out value='${ProjectBase }login.html'/>" onkeydown="go(event)">
                <tr> 
                  <td height="21">&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr> 
                  <td width="4%" height="42">&nbsp;</td>
                  <td width="17%"><div align="center">用 户</div></td>
                  <td width="34%"><input name="uid" id="usernameInput" type="text" size="16"> 
                  </td>
                  <td width="45%"><img src="./images/ad.gif"></td>
                  <input type="hidden" name="dc" id="domainSelect" value="ycccb.com">
                </tr>
                <tr> 
                  <td height="41">&nbsp;</td>
                  <td><div align="center">密 码</div></td>
                  <td colspan="2"><input name="userpassword" id="passwordInput" type="password" size="16"></td>
                </tr>
                <tr> 
                  <td>&nbsp;</td>
                  <td colspan="3"><div align="center"></div>
                    <div align="center"> 
                     <!--  <input name="button_login" type="image" src="./images/login.gif" width="61" height="20" border="0">--> 
                     	<img border=0 src="./images/login.gif" width="61" height="20" border="0" onclick="loginSubmit();" />
                      <a href="javascript:document.loginForm.reset()"><img src="./images/refash.gif" width="61" height="20" border="0"></a>
                    </div></td>
                </tr>
              </form>
            </table></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>

<div align="center"> </div>
<div align="center" class="pt9-180">最佳分辨率1024*768 </div>
</body>
</html>
