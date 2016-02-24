<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><head>
<base href="<c:out value='${ProjectBase }u/portal/'/>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>南昌市信息网电子邮局系统</title>
<style type="text/css">
<!--

tr {font-size:9pt}
td {font-size:9pt}

.p6 {font-size:12pt}
.p7 {font-size:10.8pt}
.p8 {font-size:10.5pt}
.p9 {font-size:9pt}

.Brd_Top_Left {border-top: #666666 1px solid;  border-left: #666666 1px solid;}
.Brd_Top_Left_Bottom {border-top: #666666 1px solid;  border-left: #666666 1px solid;
                     border-bottom: #666666 1px solid;}
.Brd_Top_Left_Right {border-top: #666666 1px solid;  border-left: #666666 1px solid;
                    border-right: #666666 1px solid;}
.Brd_Top_Left_Right_Bottom {border-top: #666666 1px solid;  border-left: #666666 1px solid;
                           border-right: #666666 1px solid; border-bottom: #666666 1px solid;width: 100px}

.title{font-size:12pt;color:#000000;font-weight:bold}   
.bt_link {  font-size: 9pt; color: #000099; text-decoration: none}   
.bt_more {  font-size: 9pt; color: #000099; text-decoration: none}
.bt_content {  font-size: 10.5pt; color: #000000; text-decoration: none}  
.bt_time {  font-size: 7pt; color: #999999}
.top { font-size: 9pt; color: #ffffff; text-decoration: none}  

a { text-decoration: none;}
a:hover { text-decoration: underline; color:#ff6600;}

-->
</style>
<script language="javascript">
<!--
	function openadminwin()
	{
		//window.open("/sp/wp_suadmin.sp", "win_suadmin", "toolbar=no,resizable=yes,scrollbars=no,status=0,left=80, top=60,width=640,height=480");
	}
	function open_getpwd_win()
	{
		//window.open("/wdregist/rg_get_pwd.php", "win_getpwd", "toolbar=no,resizable=no,scrollbars=no,status=0,left=80, top=60,width=400,height=150");
	}
-->
</script>

</head>

<body bgcolor="#FFFFFF" text="#000000">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
    <td align="center" valign="middle"> 
      <table width="673" border="0" cellspacing="0" cellpadding="0" background="login_nc/mail.jpg" height="424">
        <tr>
          <td height="70" width="340">&nbsp;</td>
          <td height="70">&nbsp;</td>
        </tr>
        <tr>
          <td height="180" width="340">&nbsp;</td>
          <td height="180" valign="top">
		  <FORM name="form1" method="post" action="<c:out value='${ProjectBase }login.html'/>" > 
            <table width="90%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><font color="red"><c:out value="${REASON}" default="&nbsp;" escapeXml="false"/></font></td>
              </tr>
              <tr>
                <td height="30">用户名：<input type="text" name="uid" class="Brd_Top_Left_Right_Bottom" maxlength="30" size="10">&nbsp;@ 
             <!--       <select name="field_ovdomain" class="Brd_Top_Left_Right_Bottom">
                      <option selected>选择域名</option>
                       <option value="nc.gov.cn" >nc.gov.cn</option><option value="nc.cn" >nc.cn</option><option value="test.com" >test.com</option>
                    </select>
		<height="30">域名<input type="text" name="field_ovdomain" class="Brd_Top_Left_Right_Bottom" maxlength="50" size="15">
		</td>-->
<!--	<TD><font size="2">nc.gov.cn  
                        </font></TD>  -->
		 nc.gov.cn 
                  <TD>&nbsp;</TD>
              </tr>
              <tr>
                <td height="30">密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="userpassword" class="Brd_Top_Left_Right_Bottom" maxlength="30" size="10">
                </td>
              </tr>
              <tr>
                <td height="10">&nbsp;<input type="hidden" name="dc" value="nc.gov.cn"></td>
              </tr>
              <tr>
                  <td height="30"> 
                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="image" src="login_nc/login.gif" border=0 name=button_login>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                  </td>
              </tr>
              <tr>
               <!-- <td align="right" height="30">[<a href="javascript:open_getpwd_win()">忘记密码</a>] &nbsp;&nbsp;&nbsp;&nbsp;</td>-->
		<td align="left">如<a href="javascript:open_getpwd_win()">忘记密码</a><br>请与南昌市经济信息中心联系<br>联系电话：0791－3884056;0791－3883933
		</td> 
              </tr>
            </table>
			</FORM>
          </td>
        </tr>
        <tr valign="top"> 
          <td height="174" colspan="2" align="right"> 
            <table width="60%" border="0" cellspacing="0" cellpadding="0">
			<tr><td height="90">&nbsp;</td></tr>
        	<tr> 
          		<td>本系统支持WEB或者SMTP、POP3收发邮件。<br>
                  </td>
        	</tr>
      		</table>
   		 </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</body>
</html>

