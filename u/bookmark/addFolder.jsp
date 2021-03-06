<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="folder-box">
	<h3 class="theme-bor-col theme-c">
		新建书签组
	</h3>
	<form id="addForderForm" action="bookmark/addFolder.json" method="post">
		组名：
		<input type="text" name="name">
		<input type="submit" value="保存">
		<input type="button" value="取消"  onclick="javascript:Bookmark.back();">
	</form>
	
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