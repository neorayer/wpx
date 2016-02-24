<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="folder-box">
	<h3 class="theme-bor-col theme-c">
		上传文件
	</h3>
	<form target="NetdiskIframe" id="addFileForm" action="netdisk/addFile.sjs" method="post" enctype="multipart/form-data">
		组名：
		<input type="file" name="file">
		<input type="hidden" name="groupid" value="<c:out value='${groupid}'/>"/>
		<input type="submit" value="上传" onclick="javascript:$('#tipMsg').text('文件正在上传中，请耐心等待').show();">
		<input type="button" value="取消" onclick="javascript:NetDisk.refresh();">
	</form>
	
	<br/><br/>
</div>
<iframe id="NetdiskIframe" name="NetdiskIframe" style="display:none" ></iframe>


<script type="text/javascript">
</script>