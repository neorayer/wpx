<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/<c:out value='${type}'/>.css" type="text/css" rel="stylesheet" />
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/domain.png', sizingMethod='crop');   
}
</style>   
<![endif]-->  
<style type="text/css">
#logoBlock {
	margin-top:20px;
	overflow: auto;
}
</style>
</head>
<body>
<div class="pgHeadBlock">  
	<table border=0 width="100%" height="100%" cellspacing="0">
	<tr>
		<td algin="left" width=41 class="title_BarImg"></td>
		<td align="left" id="title_Font1">设置系统风格</td>
		<td align="right" id="title_Font2"></td>
	</tr>
	</table>
</div>
<div id="logoBlock">
	<form method="post" name="ldifform" action="sysStyle_upload.html" enctype= "multipart/form-data">
		<center>
			<DIV id="SOR_EXCEPTION" style="color:red"><c:out value="${REASON}" /></DIV>
			<input type="hidden" name="type" value="<c:out value='${type }'/>">
			<input type="hidden" name="dc" value="<c:out value="${dc }"/>"/>			
			<img src="<c:out value='${ProjectBase}${logoPath}'/>" />
			
			<br/><br/>
			<input type="file" name="logogile" id="logogile">
			<input type="submit" value="更改LOGO文件"/>
			<br><br>
			文件大小请勿超过50KB,为了达到最佳效果，请将LOGO设计为100*80:(jpg,jpeg,png,gif)
		</center>	
	</form>
</div>

</body>

</html>
