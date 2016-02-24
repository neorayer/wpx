<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/domain.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function check(){
		var filename = document.getElementById("ldiffile").value;
		if(filename==""){
			alert("上传文件不能为空!");
			return false;
		}
		
		if(filename.indexOf(".ldif") == -1){
			alert("请上传ldif文件");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
<div class="commentBlock">LDIF是LDAP目录服务所特有的文本数据格式，用于导入和到出LDAP目录服务器中的数据条目。</div>

<form method="post" name="ldifform" action="../../do/domain/importldif.jsp" enctype= "multipart/form-data" onsubmit="return check()">
	<BR><BR>
	<table>
		<tr >
			文件大小请勿超过20MB
			<td width="30" valign="middle"><nobr>上传LDIF文件(*.ldif): </nobr></td>
			<td colspan="2"><input type="file" name="ldiffile" id="ldiffile"><input type="submit" value="上传"/></td>
		</tr>
		<tr align="center">
		</tr>
	</table>
	
</form>
</body>
</html>