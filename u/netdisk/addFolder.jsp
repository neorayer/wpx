<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="folder-box">
	<h3 class="theme-bor-col theme-c">
		新建文件夹
	</h3>
	<form id="addForderForm" action="netdisk/addFolder.json" method="post">
		文件夹名：
		<input type="text" name="name">
		<input type="submit" value="保存">
		<input type="button" value="取消"  onclick="javascript:NetDisk.refresh();">
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
  				required: "请输入文件夹名"
  			}
		},
  		submitHandler: function(form) {
	   		$(form).ajaxSubmit({
	   			type: 'post',
				dataType: 'json',
	   			success: function(data) {
					if(data.res != 'yes') {
	   					alert("新建文件夹失败。");
	   					return;
   					}
		  			
		  			NetDisk.openUrl('netdisk/main.html');
		  			
	   			}
	   		});
	   	}
 	});

});
</script>