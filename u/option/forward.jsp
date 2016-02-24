<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div id="ForwardBox">
	<table id="forward-set"> 
		<tr>
			<td><span style="margin-right: 10px;">转发设置：</span></td>
			<td>
				<div>
					<input type="radio" name="forward" id="not-forward"  value="0" <c:if test="${ACTOR.forward == 0}">checked="checked"</c:if>><label for="not-forward">不转发</label>
					<input type="radio" name="forward" id="forward-not-save" value="1" <c:if test="${ACTOR.forward == 1}">checked="checked"</c:if>><label for="forward-not-save">转发不保存</label>
					<input type="radio" name="forward" id="forward-and-save"  value="2" <c:if test="${ACTOR.forward == 2}">checked="checked"</c:if>><label for="forward-and-save">转发保存</label>
				</div>
			</td>
		</tr>
	</table>
	
	<div class="sep theme-bor-col theme-c"></div>
	
	<div id="forward-list">
		<div>转发列表：</div>
		<table width="99%">
			<c:forEach var="fm" items="${ACTOR.forwardaddr}">
				<tr>
					<td width="20px;">></td>
					<td ><c:out value='${fm}'/></td>
					<td width="100"><a href="javascript:void(0);" onclick="deleteForward('<c:out value='${fm}'/>')">删除</a></td>
				</tr>	
			</c:forEach>
		</table>
	</div>
	
	<div class="sep theme-bor-col theme-c"></div>
	
	<form id="forward-add-form" action="option/forwardadd.json" method="post">
		转发邮箱： <input type="text" name="fmail" value="" validate="required:true,email:true"/>
		<input type="submit" value="新增" />
		<span class="errorC"></span>
	</form>
</div>


<script type="text/javascript">
var userCurForward = <c:out value='${ACTOR.forward}'/>;

function forwardReload() {
	iTabClicked('forward');
}

// 删除转发
function deleteForward(fmail) {
	if(!confirm('您确认要删除这条转发记录吗?'))
		return;
	
	$.post('option/forwarddel.json', {fmail: fmail}, function(data) {
		if (data.res != 'yes') {
			alert(data.data);
			return;
		}
		tipMsg("删除成功");
		forwardReload();
	}, 'json');	
}

$(document).ready(function() {
	// 转发设置
	var forwardSet = {
		0: "不转发",
		1: "转发不保存",
		2: "转发保存"
	};
	$('#forward-set input').click(function() {
		var v = this.value;
		if(userCurForward == v)
			return false;
			
		if(!confirm("您确认把邮件转发设置为“" + forwardSet[v] + "”吗?")) {
			return false;
		}
		$.post('option/forwardset.json', {forward: v}, function(data) {
			userCurForward = new Number(v);
			tipMsg("修改成功");
		}, 'json');
	});
	
	// 转发新增
	$.metadata.setType("attr", "validate");
	$.validator.addMethod("email", function(value) {
		var reg = /^([.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		return reg.test(value); 
	},'请输入正确邮箱格式!');
	
	$('#forward-add-form').validate({
		errorClass: "errorClass",
		errorElement: "label",
 		errorPlacement: function(error, element) {
    		error.appendTo(element.siblings('.errorC'));
  		},
  		submitHandler: function(form) {
	   		$(form).ajaxSubmit({
	   			type: 'post',
				dataType: 'json',
	   			success: function(data) {
	   				if (data.res != 'yes') {
	   					alert(data.data);
	   					return;
	   				}
	   				tipMsg("新增成功");
	   				forwardReload();
	   			}
	   		});
	   	}
 	});
});
</script>