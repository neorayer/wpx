<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="folder-box">
	<h3 class="theme-bor-col theme-c">
		导入书签
	</h3>
	<form target="BookmarkIframe" method="post" action="bookmark/importItems.sjs" enctype="multipart/form-data">
		<table align="left">
			<tr>
				<td width="25%" align="right">上传文件：</td>
				<td>
					
					<input type="hidden" name="folderuuid" value="<c:out value='${folderuuid }'/>">	
					<input type="file" name="filename">
				</td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr>
				<td width="25%" colspan="2" align="center">
					<input type="submit" name="submit" value="提交">
					<input type="button" value="取消"  onclick="javascript:Bookmark.back();">
				</td>
			</tr>
		</table>
		
	</form>
	
	<iframe id="BookmarkIframe" name="BookmarkIframe" style="display:none" ></iframe>
	
	<br/><br/>
	<br/><br/>
	<br/><br/>
</div>

<script type="text/javascript">
$(document).ready(function() {
	$.metadata.setType("attr", "validate");
		
	$('#addForderForm').validate({
		errorClass: "errorClass",
		errorElement: "div",
 		errorPlacement: function(error, element) {
    		error.appendTo( element.next("span"));
  		},
  		rules: {
  			groupName:{
  				required: true
  			}
		},
		messages: {
			groupName:{
  				required: "请输入组名"
  			}
		},
  		submitHandler: function(form) {
	   		$(form).ajaxSubmit({
	   			type: 'post',
				dataType: 'json',
	   			success: function(data) {
					if(data.res != 'yes') {
	   					alert("新建组失败。");
	   					return;
   					}
		  			
		  			Bookmark.openUrl('bookmark/main.html');
		  			
	   			}
	   		});
	   	}
 	});

});
</script>