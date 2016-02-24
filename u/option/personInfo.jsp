<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form method="post" name="personalForm" id="personalForm" class="s-form" action="option/personInfo.json">
	<div class="f-title theme-bor-col theme-c">
		<h3>个人信息</h3>
	</div>
	<table class="f-body">
		<tr>
			<th>姓名：</th>
			<td><input type="text" name="displayName" id="displayName" value="<c:out value="${ACTOR.displayName}"/>"></td>
			<th>邮箱：</th>
			<td><c:out value="${ACTOR.mail}"/></td>
		</tr>
		<tr>
			<th>性别：</th>
			<td>
				<select name="sex" id="sex">
					<option value="男" <c:if test="${ACTOR.sex eq '男'}">selected</c:if>>男</option>
					<option value="女" <c:if test="${ACTOR.sex eq '女'}">selected</c:if>>女</option>
				</select>
			</td>
			<th>昵称：</th>
			<td><input type="text" value="<c:out value="${ACTOR.RDN}"/>" name="rdn"></td>
		</tr>
	</table>
	
	<div class="f-title theme-bor-col theme-c">
		<h3>单位信息</h3>
	</div>
	<table class="f-body">
		<tr>
			<th>单位：</th>
			<td><input type="text" name="company" id="company" value="<c:out value="${ACTOR.company}"/>"></td>
			<th>职务：</th>
			<td><input type="text" name="title" id="title" value="<c:out value="${ACTOR.title}"/>"></td>
		</tr>
		<tr>
			<th>单位所在国家/地区：</th>
			<td>
				<input type="text" name="c" id="c" value="<c:out value="${ACTOR.c}"/>">
			</td>
			<th>单位所在省/自治区：</th>
			<td><input type="text" name="st" id="st" value="<c:out value="${ACTOR.st}"/>"></td>
		</tr>
		<tr>
			<th>单位所在城市：</th>
			<td>
				<input type="text" name="l" id="l" value="<c:out value="${ACTOR.l}"/>">
			</td>
			<th></th>
			<td></td>
		</tr>
	</table>
	
	<div class="f-title theme-bor-col theme-c">
		<h3>联系方式</h3>
	</div>
	<table class="f-body">
		<tr>
			<th>移动电话：</th>
			<td><input type="text" name="mobile" id="mobile" value="<c:out value="${ACTOR.mobile}"/>"></td>
			<th>商务电话1：</th>
			<td><input type="text" name="phone" id="phone" value="<c:out value="${ACTOR.phone}"/>"></td>
		</tr>
		<tr>
			<th>商务电话2：</th>
			<td>
				<input type="text" name="telephonenumber" id="telephonenumber" value="<c:out value="${ACTOR.telephoneNumber}"/>">
			</td>
			<th>商务传真：</th>
			<td><input type="text" name="facsimiletelephonenumber" id="facsimiletelephonenumber" value="<c:out value="${ACTOR.facsimileTelephoneNumber}"/>"></td>
		</tr>
		<tr>
			<th>即时通讯1：</th>
			<td>
				<input type="text" name="msn" id="msn" value="<c:out value="${ACTOR.msn}"/>">
			</td>
			<th>即时通讯2：</th>
			<td><input type="text" name="oicq" id="oicq" value="<c:out value="${ACTOR.oicq}"/>"></td>
		</tr>
	</table>
	
	<div class="f-title theme-bor-col theme-c">
		<h3>通迅地址</h3>
	</div>
	<table class="f-body">
		<tr>
			<th>住宅所在国家/地区：</th>
			<td><input type="text" name="pc" id="pc" value="<c:out value="${ACTOR.pc}"/>"></td>
			<th>住宅所在省/自治区：</th>
			<td><input type="text" name="pst" id="pst" value="<c:out value="${ACTOR.pst}"/>"></td>
		</tr>
		<tr>
			<th>住宅所在城市：</th>
			<td>
				<input type="text" name="pl" id="pl" value="<c:out value="${ACTOR.pl}"/>">
			</td>
			<th>住宅所在街道：</th>
			<td><input type="text" name="ppa" id="ppa" value="<c:out value="${ACTOR.ppa}"/>"></td>
		</tr>
		<tr>
			<th>住宅所在地邮政编码：</th>
			<td>
				<input type="text" name="ppc" id="ppc" value="<c:out value="${ACTOR.ppc}"/>">
			</td>
			<th>住宅电话：</th>
			<td><input type="text" name="homephone" id="homephone" value="<c:out value="${ACTOR.homePhone}"/>"></td>
		</tr>
		<tr>
			<th>住宅传真：</th>
			<td>
				<input type="text" name="pfax" id="pfax" value="<c:out value="${ACTOR.pfax}"/>">
			</td>
			<th></th>
			<td></td>
		</tr>
	</table>
	
	<div class="f-title theme-bor-col theme-c">
		<h3>其它信息</h3>
	</div>
	<table class="f-body">
		<tr>
			<th>附注：</th>
			<td colspan="3"><input type="text" name="remark" id="remark" size="70" value="<c:out value="${ACTOR.remark}"/>"></td>
		</tr>
	</table>
	
	<div class="f-button">
		<input type="submit" value="提交修改"/>
	</div>
</form>

<script>


$(document).ready(function() {
	$.metadata.setType("attr", "validate");
		
	$('#personalForm').validate({
		errorClass: "errorClass",
		errorElement: "div",
 		errorPlacement: function(error, element) {
    		error.appendTo( element.next("span"));
  		},
  		rules: {
  			mail: {
				required: true,
				email: true
			},
  			displayname:{
  				required: true
  			}
		},
		messages: {
  			mail: {
				required: "必填",
				email: "邮件格式错误"
			},
			displayname:{
  				required: "请输入姓名"
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
   					}else{
   						tipMsg("基本信息修改成功");
						iTabClicked('personInfo');
					}
	   			}
	   		});
	   	}
 	});


});
</script>
