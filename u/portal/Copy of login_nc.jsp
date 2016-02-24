<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0041)http://mail.gsjq.com.cn/pguser/vi/portal/ -->
<HTML><HEAD>
<base href="<c:out value='${ProjectBase }'/>">
<TITLE>东吴证券员工邮局</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<script type="text/javascript" src="<c:out value='${ProjectBase }'/>_js/cookie.js"></script>
<STYLE type=text/css>.unnamed1 {
	LINE-HEIGHT: 15pt; FONT-SIZE: 9pt
}
.error {
        color: red;
}
</STYLE>

<META name=GENERATOR content="MSHTML 8.00.6001.18928"></HEAD>
<BODY leftMargin=0 topMargin=0 bgColor=#f3f3e9 text=#000000>

<script language="javascript">
window.onload = function(){
	if(navigator.appVersion.toLowerCase().match(/msie 6/)){
	    try {
	        document.execCommand("BackgroundImageCache", false, true);
	    }catch (e) {}
	}
	deleteCookie("uia_param", '<%=request.getContextPath()%>');
};

function set_dc()
{
alert('<%=session.getAttribute("dc")%>');
	var rand=document.getElementById("imgCode").value;
	if(rand==null||rand==''){
		alert("验证码不能为空");
		return;
	}
	
	var sURL=window.location.toString();
	var sTgt="dwzq.com.cn";
	var nPos=sURL.indexOf(sTgt);
	if(nPos<0)
	{
		document.getElementById("dc").value="skymiracle.com";
	}
	else
	{
		document.getElementById("dc").value="skymiracle.com";
	}
	document.loginfrm.submit();

	return true;

}
</script>

<c:if test="${timeout}">
<script type="text/javascript">
        window.location="<c:out value='${ProjectBase }login.html'/>";
</script>



</c:if>
<TABLE border=0 cellSpacing=0 cellPadding=0 width=731 bgColor=#ffffff 
align=center>
  <TBODY>
  <TR>
    <TD colSpan=5><IMG src="u/portal/images/yg1.gif" width=766 
height=206></TD></TR>
  <TR>
    <TD colSpan=5>
      <TABLE border=0 cellSpacing=0 cellPadding=0 width="100%">
        <TBODY>
        <TR>
          <TD bgColor=#ffffff height=164 width=99><IMG 
            src="u/portal/images/yga.gif" width=99 height=180></TD>
          <TD bgColor=#ffffff height=164 width=415>
            <FORM method=post name=loginfrm action=login.html>
            <TABLE class=unnamed1 border=0 cellSpacing=4 cellPadding=0 
            width="72%" align=center>
              <TBODY>
					<tr>
                           <td colspan="2" class="t error"><c:out value="${REASON}" default="&nbsp;" escapeXml="false"/></td>
                    </tr>
			  <TR>
                <TD width="16%">
                  <DIV align=right>用户:</DIV></TD>
                <TD>
					<INPUT size="12" style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; "  name=uid value="<c:out value='${username }'/>" > 
					<INPUT value=skymiracle.com type=hidden name=dc> 
				</TD>
			  </TR>
              <TR>
                <TD width="16%">
                  <DIV align=right>密码:</DIV></TD>
                <TD width="84%"><INPUT size="12" style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; "  type=password name=userpassword> 
              </TD></TR>

             <c:if test="${REASON != null}" >
             <script>
            location.reload();
            alert(9);
        </script> 
                 <tr>
                          <td class="t">验证码</td>
                          <td class="c">
                          <input id="imgCode" name="imgCode" value="" type="text" size="6" style="font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; "/>
                          <img id="AuthImg" align="top" src="authImage.authImage" align="absmiddle" title="验证码"/>
                          </td>
                  </tr>
              </c:if>



              <TR>
                <TD width="16%">&nbsp;</TD>
                <TD width="84%"><FONT color=#000000><INPUT border=0 
                  src="u/portal/images/login.gif" width=61 height=20 type=image 
                  name=button_login  onClick="javascript:return set_dc();"> </FONT>　<FONT color=#000000></FONT></TD></TR></TBODY></TABLE></FORM></TD>
          <TD bgColor=#ffffff background=u/portal/images/ke-11.gif 
          width=200>&nbsp;</TD>
          <TD bgColor=#ffffff height=164 width=52 align=right><IMG 
            src="u/portal/images/ygb.gif" width=31 
      height=180></TD></TR></TBODY></TABLE><IMG src="u/portal/images/yg0.gif" 
      width=766 height=56></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 align=center wdith="400">
  <TBODY>
  <TR>
    <TD style="FONT-SIZE: 12px" align=middle 
target="_blank"></TD></TR></TBODY></TABLE></BODY></HTML>
