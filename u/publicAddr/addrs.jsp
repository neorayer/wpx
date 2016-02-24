<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
/********** addrPsns **********/
.wpxTable {
	clear: both;
}

.wpxTable thead tr td#displayName{
	width: 100px;
}

.wpxTable thead tr td#mobile{
	width: 80px;
}


</style>
<!--[if IE]>
<style type="text/css">
#pubAddrBody .pageBarHTML {
	width: 98%;
	position: relative;
}

</style>
<![endif]-->
<!--[if lt IE 7]>

<![endif]-->
<!--[if IE 7]>

<![endif]-->


<div class="wpxTitle2">				
	<h3 class="txt-title"><c:out value='${group.description}'/></h3>				
	<span class="txt-info">(共有 <strong><c:out value='${group.count}'/></strong> 个联系人)</span>		
</div>

<table class="wpxTable">
	<thead>
		<tr>
			<td id="checkbox"><input id="checkAll" type="checkbox" /></td>
			<td id="displayName" class="bl overflow" onclick="javascript:PublicAddr.sort('displayName')">
				姓名
				<b  class='ico 
					<c:if test='${sortBy eq "displayName" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "displayName" && !isUp}'>ico-list-up</c:if>
				'>
				</b>	
			</td>
			<td id="mail" class="bl overflow" onclick="javascript:PublicAddr.sort('mail')">
				电子邮件
				<b  class='ico 
					<c:if test='${sortBy eq "mail" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "mail" && !isUp}'>ico-list-up</c:if>
				'>
			</td>
			<td id="mobile" class="bl" onclick="javascript:PublicAddr.sort('mobile')">
				移动电话
				<b  class='ico 
					<c:if test='${sortBy eq "mobile" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "mobile" && !isUp}'>ico-list-up</c:if>
				'>
			</td>
			<td id="company" class="bl overflow" onclick="javascript:PublicAddr.sort('company')">
				单位
				<b  class='ico 
					<c:if test='${sortBy eq "company" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "company" && !isUp}'>ico-list-up</c:if>
				'>
			</td>
			<td id="ou" class="bl" onclick="javascript:PublicAddr.sort('ou')">
				部门
				<b  class='ico 
					<c:if test='${sortBy eq "ou" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "ou" && !isUp}'>ico-list-up</c:if>
				'>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}" >
		<tr id="row_<c:out value='${user.uuid}' />" class="item" height="30">
			<td><input class="inputChkbox" type="checkbox" value="<c:out value='${user.uuid}' />" /></td>
			<td title="<c:out value="${user.displayName}" />">
				<span class="name">
					<a class="icon">&nbsp;</a>
					<a class="name" href="javascript:PublicAddr.viPsn('<c:out value='${user.uid }'/>', '<c:out value='${user.dc}' />')">
						<c:if test="${empty user.displayName}">--</c:if>
						<c:if test="${not empty user.displayName}"><c:out value="${user.displayName}" /></c:if>
					</a>
				</span>
			</td>
			<td><c:out value="${user.mail}" /></td>
			<td><c:out value="${user.mobile}" /></td>
			<td><c:out value="${user.company}" /></td>
			<td><c:out value="${user.ouName}" /></td>
		</tr>
		</c:forEach>
		<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
	</tbody>
</table>

<div id="pageBarHTMLStr" style="display: none;">
	<c:out value="${pageBarTdsHTML}" escapeXml="false" />
</div>

<script type="text/javascript">
PublicAddr.sortBy= '<c:out value="${sortBy}" />';
PublicAddr.isUp= '<c:out value="${isUp}" />';
PublicAddr.pageNum= '<c:out value="${pageNum}" />';
PublicAddr.countPerPage= '<c:out value="${countPerPage}" />';
PublicAddr.condition= '<c:out value="${condition}" />';
PublicAddr.keyword= '<c:out value="${_keyword}" />';
PublicAddr.groupid= '<c:out value="${groupid}" />';

$(document).ready(function() {
	$('.wpxTools .pageBarHTML').html($('#pageBarHTMLStr').html());

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
			PublicAddr.selectAllForce(false);
			$(this).find("input.inputChkbox")
					.attr("checked", "checked")
					.trigger("change");
		});
		*/
		
	$("input.inputChkbox").click(function() {
		$(this).trigger('change');
	});
	
	$(".pageBarHTML a").each(function() {
		var href = $(this).attr('href');
		$(this).attr("href", "javascript: PublicAddr.openUrl('" + href + "')");
	});
	
	
	/********** Enahnce Mails Checkbox(All) **********/
	$("table.wpxTable input#checkAll").click(
		function() {
			PublicAddr.selectAll();
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
