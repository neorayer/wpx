<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
/********** addrPsns **********/
.wpxTable thead tr td#displayName{
	width: 200px;
	text-decoration:none;
}

.wpxTable thead tr td#mail{
}

.wpxTable thead tr td#mobile{
	width: 150px;
}


</style>



<div class="wpxTitle2">				
	<h3 class="txt-title"><c:out value='${group.groupName}'/></h3>				
	<span class="txt-info">(共有 <strong><c:out value='${group.count}'/></strong> 个联系人)</span>		
</div>

<table class="wpxTable">
	<thead>
		<tr>
			<td id="checkbox"><input id="checkAll" type="checkbox" /></td>
			<td id="displayName" class="bl" onclick="javascript:PersonAddr.sort('displayName')">
				姓名
				<b  class='ico 
					<c:if test='${sortBy eq "displayName" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "displayName" && !isUp}'>ico-list-up</c:if>
				'>
				</b>
			</td>
			<td id="mail" class="bl" onclick="javascript:PersonAddr.sort('mail')">
				电子邮件
				<b  class='ico 
					<c:if test='${sortBy eq "mail" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "mail" && !isUp}'>ico-list-up</c:if>
				'>
				</b>
			</td>
			<td id="mobile" class="bl" onclick="javascript:PersonAddr.sort('mobile')">
				移动电话
				<b  class='ico 
					<c:if test='${sortBy eq "mobile" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "mobile" && !isUp}'>ico-list-up</c:if>
				'>
				</b>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="psn" items="${psns}" >
		<tr id="row_<c:out value='${psn.uuid}' />" class="item" height="30">
			<td><input class="inputChkbox" type="checkbox" value="<c:out value='${psn.uuid}' />" /></td>
			<td title="<c:out value="${psn.displayName}" />">
				<span class="name">
					<a class="icon">&nbsp;</a>
					<a class="name" href="javascript:PersonAddr.viPsn('<c:out value='${psn.groupId }'/>', '<c:out value='${psn.uuid}' />')">
						<c:if test="${empty psn.displayName}">--</c:if>
						<c:if test="${not empty psn.displayName}"><c:out value="${psn.displayName}" /></c:if>
					</a>
				</span>
			</td>
			<td><c:out value="${psn.mail}" /></td>
			<td><c:out value="${psn.mobile}" /></td>
		</tr>
		</c:forEach>
		<tr><td colspan="4"></td></tr>
	</tbody>
</table>

<script type="text/javascript">
$(document).ready(function() {
	
	/********** Enahnce Mails Tr Hover **********/
	$("table.wpxTable tbody tr.item")
		.mouseover(function() {
			$(this).addClass("hover");
		})
		.mouseout(function() {
			$(this).removeClass("hover");
		});
		/*
		.click(function(e) {
			if ($(e.target).is("input"))
				return;
			PersonAddr.selectAllForce(false);
			$(this).find("input.inputChkbox")
					.attr("checked", "checked")
					.trigger("change");
		});
		*/
	
	$("input.inputChkbox").click(function() {
		$(this).trigger('change');
	});
	
	/********** Enahnce Mails Checkbox(All) **********/
	$("table.wpxTable input#checkAll").click(
		function() {
			PersonAddr.selectAll();
		}
	);
	/********** Enahnce Mails Checkbox **********/
	$("input.inputChkbox").change(function() {
		var tr = $(this).parent().parent();
		var checked  = $(this).attr("checked");
		if (checked)
			tr.addClass("selected");
		else
			tr.removeClass("selected");
	});
});

</script>