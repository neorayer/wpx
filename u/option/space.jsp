<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="formSpace" action="option/space.json" method="post" >
	<div id="ctrSpaceAlertInfo" class="theme-bg-col" style="width: 99%;">
		当前邮箱空间为 <strong class="txt-impt"><c:out value="${sizeM}" />M</strong>, 
		设置空间警告线为<strong class="txt-impt"><c:out value="${spaceAlertM}" />M</strong>, 
		占邮箱空间<strong class="txt-impt"><c:out value="${sizePercent}" />%</strong>; 
		当系统空间使用超出该设定警告线时，系统自动发出提醒信件。 
	</div>
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>设置空间卫士类型：</th>
			<td>
				<select name="sizetype">
					<option value="issize">按大小(M)</option>
					<option value="isper">按百分比(%)</option>
					<option value="isclose">关闭该功能</option>
				</select>
				<span class="tips"/>
			</td>
		</tr>
		<tr>
			<th>设置新的空间卫士警告线：</th>
			<td>
				<input id="newSpaceAlert" name="newSpaceAlert" type="text">
				<span class="tips"/>
			</td>
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
		
	$('#formSpace').validate({
		errorClass: "errorClass",
		errorElement: "span",
 		errorPlacement: function(error, element) {
    		error.appendTo( element.next());
  		},
  		rules: {
  			
		},
		messages: {
			
		},
  		submitHandler: function(form) {
	   		$(form).ajaxSubmit({
	   			type: 'post',
				dataType: 'json',
	   			success: function(data) {
	   				if (data.res == 'yes') {
						tipMsg("空间管理修改成功");
						iTabClicked('space');
					}else {
						alert(data.data);
					}
	   			}
	   		});
	   	}
 	});


});


</script>