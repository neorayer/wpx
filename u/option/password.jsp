<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="formPassword" class="optionForm" action="option/password.json" method="post" >
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>原密码：</th>
			<td><input id="oldPass" name="oldPass" type="password"><span class="tips"/></td>
		</tr>
		<tr>
			<th>新密码：</th>
			<td><input id="newPass" name="newPass" type="password"><span class="tips"/></td>
		</tr>
		<tr>
			<th>密码确认：</th>
			<td><input id="newPass2" name="newPass2" type="password"><span class="tips"/></td>
		</tr>
		<tr>
			<th><br/></th>
			<td><input type="submit" value="确定修改" ></td>
		</tr>
	</table>
</form>


<script type="text/javascript">

$(document).ready(function() {
	$.metadata.setType("attr", "validate");
		
	$('#formPassword').validate({
		errorClass: "errorClass",
		errorElement: "span",
 		errorPlacement: function(error, element) {
    		error.appendTo( element.next());
  		},
  		rules: {
  			newPass: {
				required: true,
				rangelength: [6,16]
			},
			newPass2: {
				required: true,
				rangelength: [6,16],
				equalTo: "#newPass"
			}
		},
		messages: {
			newPass: {
				required: "请输入正确的密码",
				rangelength: "6~16位字符长度"
			},
			newPass2: {
				required: "请输入确认密码",
				rangelength: "6~16位字符长度",
				equalTo: "两次输入不正确"
			}
		},
  		submitHandler: function(form) {
	   		$(form).ajaxSubmit({
	   			type: 'post',
				dataType: 'json',
	   			success: function(data) {
	   				if (data.res == 'yes') {
						tipMsg("密码信息修改成功");
	   					iTabClicked('password');
					}else {
						alert(data.data);
					}
	   			}
	   		});
	   	}
 	});


});


</script>