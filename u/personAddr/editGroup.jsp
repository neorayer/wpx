<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="folder-box">
	<h3 class="theme-bor-col">
		新建组
	</h3>
	<form id="addGroupForm" action="personAddr/editGroup.json" method="post">
		<input type="hidden" name="groupid" value="<c:out value='${groupid}'/>">
		组名：
		<input type="text" name="groupName" value="<c:out value='${grp.groupName}'/>">
		<input type="submit" value="保存">
		<input type="button" value="取消" onclick="javascript:PersonAddr.open('<c:out value='${groupid}'/>');">
	</form>
</div>

<script type="text/javascript">
$(document).ready(function() {
	$.metadata.setType("attr", "validate");
		
	$('#addGroupForm').validate({
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
					if(data.res == 'no') {
	   					alert(data.data);
	   					return;
   					}
					PersonAddr.open(data.data.groupid);
					
					//写信页面从新加载
					Compose.isBuild=true;
	   			}
	   		});
	   	}
 	});


});
</script>