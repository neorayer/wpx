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
		<td align="left" id="title_Font1">书签组导入</td>
		<td align="right" id="title_Font2"></td>
	</tr>
	</table>
</div>
<div id="importBlock">
	<br><br>
	<form method="post" action="importBmForders.sjs" enctype="multipart/form-data">
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
		<p>上传的书签组列表格式如下：</p>
		<p>组名1,描述 ......</p>
		<p>组名2,描述 ......</p>
		<p>组名3,描述 ......</p>
		<br>
		<p>每一行是一个书签组的信息，各字段的顺序是</p>
		<p>组名,描述,所有人</p>
		<p>name,description,owner</p>
		<p>不用导入的字段可忽略。</p>
		<p>各字段间以逗号(,)隔开。 </p>
	</div>
	
	<br><br>
	<hr/>
	<a class="export" href="exportBmForders.down">导出所有书签组</a>
</div>
</body>
</html>