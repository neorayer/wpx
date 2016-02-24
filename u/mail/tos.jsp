<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="tos-box">
	
	<img align="absmiddle" src="_skin/sendSuccess.gif">
	
	<div class="addrtitle">
		<b id="sendinfomsg">您的邮件已经发送完毕!</b>	

		<div style="padding-bottom: 40px;padding-top: 20px;">
			
			<span id="backlist">
				<input type="button" style="width: 104px;" onclick="javascript:window.location='main.html';" value="« 返回邮箱首页" >
				
				<input type="button" onclick="javascript:MailFolders.receiveMail();Compose.build('mail/compose.html');" value="再写一封 »" style="width: 104px;">
			</span>
			<span id="entermail">
				<input type="button" onclick="javascript:MailFolders.receiveMail();" value="进入收件箱" style="width: 104px;">
			</span>
		</div>
	</div>
	
	<div class="addrbody">
		<ul>
		<c:forEach var="psn" items="${mails}" varStatus="status">
			<li class="addr_<c:out value='${status.count}'/>">
				<table width="90%" cellpadding="0" cellspacing="0" height="30">
					<tr>
						<td>
							<span class="detail">"<c:out value='${psn.displayName }'/>" <c:out value='${psn.mail }'/></span>
						</td>
						<td width="150">
							<span class="edit" <c:if test="${!psn.uuid}">style="display: none;"</c:if>>
								已存在
							</span>
							
							<span class="add" <c:if test="${psn.uuid}">style="display: none;"</c:if>>
								<a href="javascript:To.toggleAdd(<c:out value='\'${status.count }\''/>);">添加到通讯录</a>
							</span>
						</td>
					</tr>
				</table>
				
				<form class="<c:out value='addrForm addr_${status.count }_Form'/>" action="personAddr/addAddr.json" style="display: none;">
					<input type="hidden" value="" name="id">
					<table class="wpxTableCss" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>姓名：</th>
								<td><input type="text" maxlength="12" value="<c:out value='${psn.displayName }'/>" name="name"></td>
							</tr>
							<tr>
								<th>电子邮箱：</th>
								<td><input type="text" readonly="readonly" maxlength="50" value="<c:out value='${psn.mail }'/>" name="mail"></td>
							</tr>
							<tr>
								<th>手机/电话：</th>
								<td><input type="text" maxlength="20" value="" name="phone"></td>
							</tr>
							<tr>
								<th>所属组：</th>
								<td>
									<span><input type="checkbox" value="" name="groupId" checked="checked">&nbsp;<label>不分组</label></span>
									<c:forEach var="grp" items="${grps}">
										<span><input type="checkbox" value="<c:out value='${grp.uuid }'/>" name="groupId">&nbsp;<label><c:out value='${grp.groupName }'/></label></span>
									</c:forEach>
								</td>
							</tr>
							<tr>
								<th></th>
								<td>
									<input type="button" name="submit" value="确定" onclick="javascript:To.add(<c:out value='\'${status.count }\''/>);" />
									<input type="button" name="cancel" value="取消" onclick="javascript:To.toggleAdd(<c:out value='\'${status.count }\''/>);" />
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</li>
		</c:forEach>
		</ul>
	</div>
	
</div>

<script type="text/javascript">
To = {
	toggleAdd: function(count) {
		$('.addr_'+ count +'_Form').toggle();
	},
	
	add: function(count) {
		var $form = $('.addr_'+ count +'_Form');
		$form.ajaxSubmit({
   			type: 'post',
			dataType: 'json',
   			success: function(data) {
   				if (data.res != 'yes') {
					alert(data.data);
				}
				
				tipMsg("添加操作成功！");
				$('#tos-box .addrbody .addr_' + count + ' .add').hide();
				$('#tos-box .addrbody .addr_' + count + '_Form').hide();
				$('#tos-box .addrbody .addr_' + count + ' .edit').show();
   			}
   		});
	}
}

</script>
