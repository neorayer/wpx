<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="isDetail" value="${isDetail}" />

<form id="ContactForm" action="personAddr/contactForm.json" method="post">
	<div id="ContactBox" class="gWel-tab">
		<div class="tabs">
			<ul>
				<li id="mainTID"  class="on" onClick="iTabClicked('mainTID');">
					基本信息
				</li>
				<li  id="personalTID" onClick="iTabClicked('personalTID');">
					个人信息
				</li>
				<li id="companyTID" onClick="iTabClicked('companyTID');">
					单位信息
				</li>
				<li id="homeTID" onClick="iTabClicked('homeTID');">
					家庭信息
				</li>
				<li id="remarkTID" onClick="iTabClicked('remarkTID');">
					备注
				</li>
			</ul>
		</div>
		
		<div class="pans">
			<div id="mainTIDc" class="panel">
				<table border="0" cellpadding="0" cellspacing="0"  title="个人基本信息">
					<tr>
						<td class="tTitlecls">姓名：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="displayname" id="displayname" type="text" value="<c:out value='${psn.displayName}'/>"></td>
						<td align="left"><span class="tip" id="forDisplayNameTip"></span></td>
					</tr>
					<tr>
						<td class="tTitlecls">电子邮件：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="mail" id="mail" type="text" value="<c:out value='${psn.mail}'/>" ></td>
						<td align="left"><span class="tip" id="forMailTip"></span></td>
					</tr>
					<tr>
						<td class="tTitlecls">MSN：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="msn" id="msn" type="text" value="<c:out value='${psn.msn}'/>"></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td class="tTitlecls">OICQ：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="oicq" id="oicq" type="text" value="<c:out value='${psn.oicq}'/>"></td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			<div id="personalTIDc" class="panel">
				<table border="0" cellpadding="0" cellspacing="0"  title="个人具体信息">
					<tr>
						 <td class="tTitlecls">姓：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="sn" id="sn" type="text" value="<c:out value='${psn.sn}'/>"></td>
						 <td class="tTitlecls">名：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="givenName" id="givename" type="text" value="<c:out value='${psn.givenName}'/>"></td>
					</tr>
					<tr>
						<td class="tTitlecls">昵称：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="rdn" id="rdn" type="text" value="<c:out value='${psn.RDN}'/>"></td>
						<td class="tTitlecls">性别：</td>
						<td class="tContentcls">
							<select <c:if test="${isDetail }">readonly</c:if> name="sex" id="sex">
								<option value="男" <c:if test="${sex eq '男'}">selected class="readonly"</c:if>>男</option>
								<option value="女" <c:if test="${sex eq '女'}">selected class="readonly"</c:if>>女</option>
							</select>
						</td>			
					</tr>
					<tr>
						<td class="tTitlecls">生日：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="birthday" id="birthday" type="text" value="<c:out value='${psn.birthday}'/>"></td>
						<td class="tTitlecls">移动电话：</td>
						<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="mobile" id="mobile" type="text" value="<c:out value='${psn.mobile}'/>"></td>
					</tr>
					<tr>
						<td class="tTitlecls">个人网页：</td>
						<td colspan="3" class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="web" type="text" id="web" size="33" value="<c:out value='${psn.web}'/>"></td>			
					</tr>
				</table>
			</div>
			<div id="companyTIDc" class="panel">
				<table border="0" cellpadding="0" cellspacing="0"  title="单位具体信息">
					<tr>
						<td class="tTitlecls">单位：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="company" id="company" type="text" value="<c:out value='${psn.company}'/>"></td>
						<td class="tTitlecls">职务：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="title" id="title" type="text" value="<c:out value='${psn.title}'/>"></td>
					</tr>
					<tr>
						<td class="tTitlecls">部门：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="ou" id="ou" type="text" value="<c:out value='${psn.ou}'/>"></td>
						<td class="tTitlecls">办公地点：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="physicaldeliveryofficename" id="physicaldeliveryofficename" type="text" value="<c:out value='${psn.physicalDeliveryOfficeName}'/>"></td>				
					</tr>
					<tr>
						<td class="tTitlecls">单位网页：</td>
						<td  colspan="3"  class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="url" type="text" id="url" size="30" value="<c:out value='${psn.URL}'/>"></td>
					</tr>
					<tr>
						<td class="tTitlecls">所在国家/地区：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="c" id="c" type="text" value="<c:out value='${psn.c}'/>"></td>
						<td class="tTitlecls">所在省/自治区：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="st" id="st" type="text" value="<c:out value='${psn.st}'/>"></td>
					</tr>
					<tr>
						<td class="tTitlecls">所在城市：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="l" id="l" type="text" value="<c:out value='${psn.l}'/>"></td>
						<td class="tTitlecls">所在街道：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="postaladdress" id="postaladdress" type="text" value="<c:out value='${psn.postalAddress}'/>"></td>
					</tr>
					<tr>
						<td class="tTitlecls">所在地邮政编码：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="postalcode" id="postalcode" type="text" value="<c:out value='${psn.postalCode}'/>"></td>
						<td class="tTitlecls">商务传真：</td>
					  <td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="pfax" id="facsimiletelephonenumber" type="text" value="<c:out value='${psn.pfax}'/>"></td>
					</tr>
					<tr>
						<td class="tTitlecls">商务电话：</td>
					  <td class="tContentcls" colspan="3"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="phone" id="phone" type="text" value="<c:out value='${psn.phone}'/>"></td>
					</tr>
				</table>
			</div>
			<div id="homeTIDc" class="panel">
				<table border="0" cellpadding="0" cellspacing="0" title="住宅具体信息" >
				  <tr>
					<td class="tTitlecls">所在国家/地区：</td>
					<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="pc" id="pc" type="text" value="<c:out value='${psn.pc}'/>"></td>
					<td class="tTitlecls">所在省/自治区：</td>
					<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="pst" id="pst" type="text" value="<c:out value='${psn.pst}'/>"></td>
				  </tr>
				  <tr>
					<td class="tTitlecls">所在城市：</td>
					<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="pl" id="pl" type="text" value="<c:out value='${psn.pl}'/>"></td>
					<td class="tTitlecls">所在街道：</td>
					<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="ppa" id="ppa" type="text" value="<c:out value='${psn.ppa}'/>"></td>
				  </tr>
				  <tr>
					<td class="tTitlecls">住宅电话：</td>
					<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="homephone" id="homephone" type="text" value="<c:out value='${psn.homePhone}'/>"></td>
					<td class="tTitlecls">住宅传真：</td>
					<td class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="pfax" id="pfax" type="text" value="<c:out value='${psn.pfax}'/>"></td>
				  </tr>
				  <tr>
					<td class="tTitlecls">所在地邮政编码：</td>
					<td colspan="3"  class="tContentcls"><input <c:if test="${isDetail }">readonly class="readonly"</c:if> name="ppc" id="ppc" type="text" value="<c:out value='${psn.ppc}'/>"></td>
				  </tr>
				</table>
			</div>
			<div id="remarkTIDc" class="panel">
				<table border="0" cellpadding="0" cellspacing="0" title="备注信息" >
					<tr>
						<td><textarea <c:if test="${isDetail }">readonly class="readonly"</c:if> name="remark" id="remark" cols="50" rows="8"><c:out value='${psn.remark}'/></textarea></td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="iTab_btn theme-bg-col">
			<input type="button" value="返回" onclick="javascript:PublicAddr.back();">
	  	</div>
		
	</div>
</form>


<script type="text/javascript">
function iTabClicked(id){
	$('#ContactBox .tabs li').removeClass("on");
	$('#ContactBox .tabs #'+id).addClass("on");
	
	$('#ContactBox .pans .panel').hide();
	$('#ContactBox .pans #'+id +'c').show();
}

iTabClicked('mainTID');


$(document).ready(function() {
	$.metadata.setType("attr", "validate");
		
	$('#ContactForm').validate({
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
   					}
					PersonAddr.open(data.data.groupid);
	   			}
	   		});
	   	}
 	});


});
</script>
