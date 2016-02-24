<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="RejectBox" class="gWel-tab">
	
	<div class="tabs">
		<ul>
			<li id="rejectdomain"  class="on" onClick="rTabClicked('rejectdomain');">
				拒绝发件人域名
			</li>
			<li  id="rejectemail" onClick="rTabClicked('rejectemail');">
				拒绝发件人邮件地址
			</li>
			<li id="rejectsubject" onClick="rTabClicked('rejectsubject');">
				拒绝主题（邮件主题包含）
			</li>
		</ul>
	</div>
	
	<div class="pans">
		<div id="rejectdomainc" class="panel">
				
			新增拒收域名：<input class="rejectInput" id="rejectdomainValue"  name="name" value="" type="text" />
			<input type="button" value="新增" onclick="MailReject.add('domain');"/>
			<br><br>

			<div class="tt theme-bor-col theme-c">拒绝发件人域名列表</div>
			<table class="wpxTable" cellpadding="0" cellspacing="0">
				<tbody>
				<c:forEach var="domain" items="${rejectDomains}">
					<tr>
						<td>
							<c:out value='${domain}'/>
						</td>
						<td width="100">
							<a class="del" href="javascript:MailReject.del('domain', '<c:out value='${domain}'/>');">删除</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div id="rejectemailc" class="panel">
				
			新增拒绝发件人邮件地址：<input class="rejectInput" id="rejectemailValue"  name="name" value="" type="text" />
			<input type="button" value="新增" onclick="MailReject.add('email');"/>
			<br><br>

			<div class="tt theme-bor-col theme-c">拒绝发件人邮件地址列表</div>
			<table class="wpxTable" cellpadding="0" cellspacing="0">
				<tbody>
				<c:forEach var="email" items="${rejectEmails}">
					<tr>
						<td>
							<c:out value='${email}'/>
						</td>
						<td width="100">
							<a class="del" href="javascript:MailReject.del('email', '<c:out value='${email}'/>');">删除</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div id="rejectsubjectc" class="panel">
				
			新增拒绝主题（邮件主题包含）：<input class="rejectInput" id="rejectsubjectValue"  name="name" value="" type="text" />
			<input type="button" value="新增" onclick="MailReject.add('subject');"/>
			<br><br>

			<div class="tt theme-bor-col theme-c">拒绝主题（邮件主题包含）列表</div>
			<table class="wpxTable" cellpadding="0" cellspacing="0">
				<tbody>
				<c:forEach var="subject" items="${rejectSubjects}">
					<tr>
						<td>
							<c:out value='${subject}'/>
						</td>
						<td width="100">
							<a class="del" href="javascript:MailReject.del('subject', '<c:out value='${subject}'/>');">删除</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div style="clear: both;"></div>
</div>



<script type="text/javascript">
/** ******** 拒收设置 **********/
var MailReject = {
	add: function(type) {
		var $reject= $('#reject' + type + 'Value');
		var rejectVal = $.trim($reject.val());
		if(rejectVal==''){
			alert('拒收内容不能为空！');
			return;
		}
		if(type == 'domain'){
			var ptn = /^[\.0-9a-zA-Z-_]+\.+[a-zA-Z]{2,3}$/;
			var flg = ptn.test(rejectVal);
			if(!flg){
				alert('域名格式错误！');
				return;
			}
		}
		if(type == 'email'){
			var ptn = /^[\.0-9a-zA-Z_-]+@[\.0-9a-zA-Z-_]+\.+[a-zA-Z]{2,3}$/;
			var flg = ptn.test(rejectVal);
			if(!flg){
				alert('域名格式错误！');
				return;
			}
		}
		if(type == 'subject'){
							
		}
		
		$.post(
			"option/reject_add.json",
			{
				type: type,
				reject: rejectVal
			},
			function(data) {
				if ('yes' != data.res) {
					alert(data.data);
					return;
				}
				$reject.val('');
				var url ='option/reject.html?type='+type;
				iTabClickedUrl('reject', url);
			},
			'json'
		);
	},
	
	/**
	* 删除邮件夹
	*/
	del: function(type, reject) {
		if (!confirm("您是否确认删除此据说设置？注意：此操作不可恢复！")) {
			return;
		}
		$.post(
			"option/reject_del.json", 
			{
				type: type,
				reject: reject
			}, 
			function(data) {
				if ('yes' != data.res) {
					alert(data.data);
					return;
				}
				var url ='option/reject.html?type='+type;
				iTabClickedUrl('reject', url);
			}, 
			'json'
		);
	}
}


function rTabClicked(id){
	$('#RejectBox .tabs li').removeClass("on");
	$('#RejectBox .tabs #'+id).addClass("on");

	$('#RejectBox .pans .panel').hide();
	$('#RejectBox .pans #'+id +'c').show();
}

rTabClicked("reject<c:out value='${type}' />");

$(document).ready(function() {
	
});

</script>