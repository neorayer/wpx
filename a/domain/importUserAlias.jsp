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
#importBlock {
	margin: 0px;
}
.desc {
	padding-left: 10px;
}
.export {
	padding:10px;
}
</style>
</head>
<body>
<div class="pgHeadBlock">
	<table border=0 width="100%" height="100%" cellspacing="0">
	<tr>
		<td algin="left" width=41 class="title_BarImg"></td>
		<td align="left" id="title_Font1">用户别名导入</td>
		<td align="right" id="title_Font2"></td>
	</tr>
	</table>
</div>
<div id="importBlock">
	<br><br>
	<form method="post" action="importUserAlias.sjs" enctype="multipart/form-data">
		<table align="left">
		
			<tr>
				<td width="25%" align="right">上传文件：</td>
				<td><input type="file" name="filename"></td>
			</tr>
			
			<tr>
				<td width="25%" colspan="2" align="center">
					<input type="submit" name="submit" value="提交">
					<input type="reset" name="reset" value="重置">
				</td>
			</tr>
		</table>
		
	</form>
	
	<br><br><br><br><br><br>
	
	<div class="desc">
		<h2>说明</h2>
		<p>上传的用户别名列表格式如下：</p>
		<p>别名1,域名 ......</p>
		<p>别名2,域名 ......</p>
		<p>别名3,域名 ......</p>
		<br>
		<p>每一行是一个用户别名的信息，各字段的顺序是</p>
		<p>别名,域名,别名对象</p>
		<p>uid,dc,aliasedObjectName</p>
		<p>不用导入的字段可忽略。</p>
		<p>各字段间以逗号(,)隔开。 </p>
	</div>
	
	<br><br>
	<hr/>
	<a class="export" href="exportUserAlias.down">导出所有用户别名</a>
</div>
</body>
</html>