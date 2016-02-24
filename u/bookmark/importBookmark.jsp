<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String folderUUID = request.getParameter("folderUUID");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导入书签</title>
<link href="../../style/DNA/css/css.css" type="text/css"
	rel="stylesheet" />
<style type="text/css">
body {
	background-color:#ffffff;
}
</style>
<script type="text/javascript">
function check(frm){
	if(frm.bookmarkFile.value==''){
		alert('请选择有效的书签文件！');
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<form onsubmit="return check(this);" name="uploadForm" method="post"
		action="../../do/bookmark/importBookmark.jsp?folderUUID=<%=folderUUID %>" encType=multipart/form-data>
		<table align="center">
			<tr><td colspan="2"><font><b>上传书签文件</b></font></td></tr>
			<tr>
				<td>
					(*)书签文件:
				</td>
				<td>
					<input name="bookmarkFile" type="file">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input name="upoad" type="submit" value="上传">
					<input name="cancel" type="button" value="取消" onclick="javascript: {window.parent.app.bookmarkApp.closeImportBookmarkWin('');}">
				</td>
			</tr>
		</table>					
	</form>	
</body>
</html>