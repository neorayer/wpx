<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/domain.css" type="text/css" rel="stylesheet" />
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
#resetdata {
	padding: 10px;
}
</style>
</head>
<body>
<div class="pgHeadBlock">
	<table border=0 width="100%" height="100%" cellspacing="0">
	<tr>
		<td algin="left" width=41 class="title_BarImg"></td>
		<td align="left" id="title_Font1">用户导入</td>
		<td align="right" id="title_Font2"></td>
	</tr>
	</table>
</div>
<div id="resetdata">
	<a href="resetDomains.sjs"><h2>域数据整理</h2></a>
	<p>说明:导入域和用户完毕以后，对域的使用量和用户数进行整理</p>
	<br><br>
	
	<a href="resetPsnAddrs.sjs"><h2>个人通讯录数据整理</h2></a>
	<p>个人通讯录数据整理:导入用户和部门完毕以后，对部门的用户数进行整理</p>
	<br><br>

	<a href="resetPubAddrs.sjs"><h2>公共通讯录数据整理</h2></a>
	<p>公共通讯录数据整理:导入公共通讯录组和用户完毕以后，对组的用户数进行整理</p>
	<br><br>
	
	<a href="resetUserSpells.sjs"><h2>用户姓名拼音整理</h2></a>
	<p>用户姓名拼音整理:把用户姓名转换成拼音</p>
	<br><br>
		
	<br><br>
</div>

</body>
<script type="text/javascript">

</script>
</html>