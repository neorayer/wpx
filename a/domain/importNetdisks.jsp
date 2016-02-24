<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../do/portal/include.jsp"%>
<%
//
	String res = request.getParameter("res");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css"
	rel="stylesheet" />
<link href="../../style/css.css" type="text/css" rel="stylesheet" />
<link href="../../style/domain.css" type="text/css" rel="stylesheet" />
</head>
<body>
<form id="uploadFileForm" name="uploadFileForm" method="post"
	action="../../do/domain/importNetdisks.jsp"
	enctype="multipart/form-data">

<table align="left">
	
	
<p>	文件格式为：csv 编码为：UTF-8
</p>
例子：<br>
fid,fatherpath,self,btime,rtime,mtime,title,filename,fmode,fsize,ftype,user,vdomain,uname,clicks<br>
0,/vdomain=beni.com.cn/user=test/func=storage,dir=Pictures,0000-00-00 00:00:00,0000-00-00 00:00:00,2002-10-22 16:20,,Pictures,DIR,0,DIR,,,PLAIN,0
<br>
<br>
<br>
	</tr>

	<tr>
		<td width="25%" align="right">filename：</td>
		<td><input type="file" name="filename"></td>
	</tr>
	
	<tr>
		<td width="25%" align="right"><input type="submit" name="submit"
			value="提交"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="reset" name="reset" value="重置"></td>

	</tr>
</table>
</body>
</html>