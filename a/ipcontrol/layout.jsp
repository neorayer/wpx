<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/ipcontrol.css" type="text/css" rel="stylesheet">
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/ipcontrol.png', sizingMethod='crop');
}
</style>
<![endif]-->
</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1"><c:out value="${t}" /></td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="domainTableBlock" class="tableBlock"></div>
</body>
<c:import url="${PL}"></c:import>


</html>