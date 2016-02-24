<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
/********** addrPsns **********/

.folder-box table tr td {
	line-height: 162%;
	height: 30px;
	vertical-align: top;
	padding: 0 0 5px 0;
}
.folder-box table input.text {
	height: 26px;
}
.folder-box table .text {
	width: 500px;
}
div.errorClass {
	padding: 2px 5px;
	border: none;
}
</style>

<div class="folder-box">
	<h3 class="theme-bor-col theme-c">
		修改书签
	</h3>
	<form id="addForderForm" action="bookmark/modItem.json" method="post">
		<table>
			<tr>
				<td>书签名称：</td>
				<td>
					<input type="hidden" name="uuid" value="<c:out value='${item.uuid}'/>">
					<input type="hidden" name="folderuuid" value="<c:out value='${item.folderUUID}'/>">
					<input class="text" type="text" name="name" value="<c:out value='${item.name}'/>">
				</td>
			</tr>
			<tr>
				<td>书签地址：</td>
				<td><input class="text" type="text" name="url" value="<c:out value='${item.url}'/>"></td>
			</tr>
			<tr>
				<td>书签描述：</td>
				<td>
					<textarea class="text" name="description" rows="16" cols="80"><c:out value='${item.description}'/></textarea>					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交">
					<input type="button" value="取消"  onclick="javascript:Bookmark.back();">
				</td>
			</tr>
		</table>
		
	</form>
	
	<br/><br/>
</div>

<script type="text/javascript">
$(document).ready(function() {
	$.metadata.setType("attr", "validate");
		
	$('#addForderForm').validate({
		errorClass: "errorClass",
		errorElement: "div",
 		errorPlacement: function(error, $elem) {
 			error.appendTo($elem.parent("td"));
  		},
  		rules: {
  			name:{
  				required: true
  			},
  			url:{
  				required: true,
  				url:true,
  				maxlength:255
  			}
		},
		messages: {
			name:{
  				required: "请输入书签名"
  			},
  			url:{
  				required: "请输入网址",
  				url:"请输入合法的网址",
  				maxlength: '书签地址太长,最多为255的字符'
  			}
		},
  		submitHandler: function(form) {
	   		$(form).ajaxSubmit({
	   			type: 'post',
				dataType: 'json',
	   			success: function(data) {
					if(data.res != 'yes') {
	   					alert("修改书签失败。");
	   					return;
   					}
		  			
		  			Bookmark.back();
	   			}
	   		});
	   	}
 	});

});
</script>