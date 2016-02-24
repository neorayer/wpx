<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
<%@include file="../../do/portal/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/calendar/calendar.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/calendar/calendar-zh.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/calendar/skin"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />

<script language="javascript" src="../../js/ajax.js"></script>
<script language="javascript" src="../../js/common.js"></script>
<script language="javascript" src="../../js/taskmenu.js"></script>
<script language="javascript" src="../../js/menubar.js"></script>
<script language="javascript" src="../../js/popupwindow.js"></script>
<script language="javascript" src="../../js/s3button.js"></script>
<script language="javascript" src="../../js/appPotal.js"></script>
<script language="javascript" src="../../js/appMail.js"></script>
</head>
<body>
<div id="mainDiv"></div>								
</body>
<script type="text/javascript">
function cr(){
	with(SkyDNA.Element){
		with(createForm(_G("mainDiv"),{formURL:"../../do/email/batch.jsp"})){
			addSelect("birthdayset","设置:", {optionMap:{"open":"开通 ","close":"关闭"}});
			addInputText("subject","邮件主题:");
			addSubmit();
		}
	}
}

cr();
</script>
</html>