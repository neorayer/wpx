<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="pgSpace" >
	<div class="wxPortletHeader">
		<span class="wxPortletTitle">空间信息</span>
	</div>
	
	<div  class="wxPortletBody">
		<table id="tableSpace" class="txt-info">
			<tr>
				<th>总容量：</th>
				<td><c:out value="${spaceTotalM}" /> <strong>M</strong></td>
			</tr>
			<tr>
				<th>邮件占用：</th>
				<td><c:out value="${spaceMailM}" /> <strong>M</strong></td>
			</tr>
			<tr>
				<th>网络U盘：</th>
				<td><c:out value="${spaceNetdiskM}" /> <strong>M</strong></td>
			</tr>
			<tr>
				<th>剩余：</th>
				<td><c:out value="${spaceLessM}" /> <strong>M</strong></td>
			</tr>
		</table>
		<table class="spaceTotal" width="90%" align="center">
			<tr>
				<td class="spaceSub spaceMail" width="<c:out value='${spaceMailPersent}' />%" title="邮件大小"><br/></td>
				<td class="spaceSub spaceNetdisk"  width="<c:out value='${spaceNetdiskPersent}' />%" title="网络硬盘大小"><br/></td>
				<td class="spaceSub spaceLess"  width="<c:out value='${spaceLessPersent}' />%" title="剩余大小"><br/></td>
			</tr>
		</table>
		
		<div class="txt-info">
			<div style="margin-top: 10px;">
				您的邮箱空间警告线为
				<span class="txt-impt"><c:out value="${spaceAlertM}" /></span>M ，
				空间警告线为
				<span class="txt-impt"><c:out value="${sizePercent}" /></span>%；
				当系统空间使用超出该设定警告线时，系统自动发出提醒信件。 
			</div>
		</div>
	</div>
</div>
