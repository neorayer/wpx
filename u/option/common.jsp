<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="formMailCommon" action="option/common.json" method="post" >
	<table cellpadding="0" cellspacing="0">
		<tr>
			<th>邮箱每页显示的邮件数：</th>
			<td><input id="mnpp" name="mnpp" value="<c:out value='${mnpp}' default="20"/>" type="text">1 ~ 100 (缺省 20)<span class="tips"/></td>
		</tr>
		<tr>
			<th>发送邮件是否自动保存：</th>
			<td>
				<c:if test="${ACTOR.savenew == 1}">
					<input name="savenew" type="radio" value="1" checked />是
					<input name="savenew" type="radio" value="0" />否
				</c:if>
				<c:if test="${ACTOR.savenew ne 1}">
					<input name="savenew" type="radio" value="1"  />是
					<input name="savenew" type="radio" value="0" checked />否
				</c:if>
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
		
	$('#formMailCommon').validate({
		errorClass: "errorClass",
		errorElement: "span",
 		errorPlacement: function(error, element) {
    		error.appendTo( element.next());
  		},
  		rules: {
  			mnpp: {
				required: true,
				maxlength: 3,
				minlength: 1,
				number:true
			}
		},
		messages: {
			mnpp: {
				required: "请输入每页显示的数目",
				maxlength: "超出最大值",
				minlength: "字符长度不足",
				number: "请输入数字类型"
			}
		},
  		submitHandler: function(form) {
	   		$(form).ajaxSubmit({
	   			type: 'post',
				dataType: 'json',
	   			success: function(data) {
	   				if (data.res == 'yes') {
						tipMsg("常规设置修改成功");
	   					iTabClicked('common');
					}else {
						alert(data.data);
					}
	   			}
	   		});
	   	}
 	});


});

</script>