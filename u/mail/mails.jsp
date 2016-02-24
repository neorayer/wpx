<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="wpxTitle">
	<div class="title">
		<h2><c:out value='${folder.name}'/></h2>
		<span class="txt-info">
			(共 
				<strong><c:out value="${allCount}" /></strong> 封,
				<strong class="txt-impt"><c:out value="${newCount}" /></strong> 封
				<a href="javascript:MailFolders.openUrl('<c:out value='${folderid }'/>', 'mail/mails.html?folderid=<c:out value='${folderid }'/>&condition=read|true');">未读邮件</a>
			)
		</span>
	</div>
	<div class="search-box">
		<input id="searchText" class="search-input" type="text" name="keyword" value="<c:out value='${_keyword }'/>">
		<span id="searchBtn" class="search-btn" title="搜索邮件" onclick="<c:out value='javascript:MailFolders.openUrl("${folderid}", "mail/mails.html?folderid=${folderid}&keyword="+document.getElementById("searchText").value)'/>">搜索</span>
	</div>
	<div style="clear: both;"></div>
</div>

<div class="wpxTools">
	<table class="menuTable" border="0" cellpadding="0" cellspacing="0" >
		<tr>
			<td class="delete">
				<a class="button delete" href="javascript:Mails.remove()"><span class="title">永久删除</span></a>
			</td>
			<td class="moveToTrash">
				<a class="button moveToTrash" href="javascript:Mails.moveTo('trash')"><span class="title">移到废件箱</span></a>
			</td>
			<td class="moveTo">
				<a class="button wxMenuButton moveTo" href="javascript:void(0);">
					<span class="title">移到</span>
					<b class="arr"></b>
				</a>
				<table class="wxDropMenu foldersMenu" border="0" cellpadding="0" cellspacing="0" >
				
				</table>
			</td>
			<td class="mark">
				<a class="button wxMenuButton mark" href="javascript:void(0);">
					<span class="title">标记</span>
					<b class="arr"></b>
				</a>
				<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
					<tr><td><a class="markRead" href="javascript:Mails.markRead(true)"><span class="title">标记为已读</span></a></td></tr>
					<tr><td><a class="markUnread" href="javascript:Mails.markRead(false)"><span class="title">标记为未读</span></a></td></tr>
					<tr><td><a class="markReplied" href="javascript:Mails.markReplied(true)"><span class="title">标记为已回复</span></a></td></tr>
				</table>
			</td>
			
			<td class="view">
				<a class="button wxMenuButton view" href="javascript:void(0);">
					<span class="title">查看</span>
					<b class="arr"></b>
				</a>
				<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
					<tr><td width="100"><a href="javascript:Mails.selectAllForce(true)"><span class="title">全部</span></a></td></tr>
					<tr><td><a href="javascript:Mails.selectReadForce(false)"><span class="title">未读</span></a></td></tr>
					<tr><td><a href="javascript:Mails.selectReadForce(true)"><span class="title">已读</span></a></td></tr>
					<tr><td><a href="javascript:Mails.selectAllForce(false)"><span class="title">不选</span></a></td></tr>
				</table>
			</td>
			
			<td class="refresh">
				<a class="button refresh" href="javascript:Mails.refresh(true)"><span class="title">刷新</span></a>
			</td>
		</tr>
	</table>
	
	<div class="pageBarHTML">
		<c:out value="${pageBarTdsHTML}" escapeXml="false" />
	</div>
</div>

<table id="pgMailList" class="wpxTable">
	<thead>
		<tr>
			<td id="checkbox"><input id="checkAll" type="checkbox" /></td>
			<td id="attr" class="bl" width="100"><b class="ico"/></td>
			<c:if test="${folder.id eq 'draft' || folder.id eq 'sent'}">
				<td id="to" class="bl" onclick="javascript:Mails.sort('to')">
					收件人
					<b  class='ico 
						<c:if test='${sortBy eq "to" && !isUp}'>ico-list-down</c:if>
						<c:if test='${sortBy eq "to" && isUp}'>ico-list-up</c:if>
					'>
					</b>
				</td>
			</c:if>
			<c:if test="${folder.id ne 'draft' && folder.id ne 'sent'}">
				<td id="from" class="bl" onclick="javascript:Mails.sort('from')">
					发件人
					<b  class='ico 
						<c:if test='${sortBy eq "from" && !isUp}'>ico-list-down</c:if>
						<c:if test='${sortBy eq "from" && isUp}'>ico-list-up</c:if>
					'>
					</b>
				</td>
			</c:if>
			<td id="subject" class="bl" onclick="javascript:Mails.sort('subject')">
				标题 
				<b  class='ico 
					<c:if test='${sortBy eq "subject" && !isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "subject" && isUp}'>ico-list-up</c:if>
				'>
				</b>
			</td>
			<td id="lastModified" class="bl" onclick="javascript:Mails.sort('lastModified')">
				时间
				<b  class='ico 
					<c:if test='${sortBy eq "lastModified" && !isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "lastModified" && isUp}'>ico-list-up</c:if>
				'>
			</td>
			<td id="size" class="bl" onclick="javascript:Mails.sort('size')">
				大小
				<b  class='ico 
					<c:if test='${sortBy eq "size" && !isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "size" && isUp}'>ico-list-up</c:if>
				'>
			</td>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty mails}">
			<tr height="20"><td colspan="6"></td></tr>
		</c:if>
		
		<c:set var="isSortable" value="${(sortBy == 'lastModified' || (empty sortBy))and ((empty isUp) || isUp == false)}" />
		<c:set var="todayMarked" value="${false}" />
		<c:set var="thisWeekMarked" value="${false}" />
		<c:set var="longAgoMarked" value="${false}" />
		<c:forEach var="mail" items="${mails}" >
			<c:if test="${isSortable}" >
				<c:if test="${(not todayMarked) and mail.isToday}">
					<tr><td class='dateSep' colspan="6">日期：今天</td></tr>
					<c:set var="todayMarked" value="${true}" />
				</c:if>
				<c:if test="${(not thisWeekMarked) and mail.isThisWeek and (not mail.isToday)}">
					<tr><td class='dateSep' colspan="6">日期：一周内</td></tr>
					<c:set var="thisWeekMarked" value="${true}" />
				</c:if>
				<c:if test="${(not longAgoMarked) and  (not mail.isThisWeek) and (not mail.isToday)}">
					<tr><td class='dateSep' colspan="6">日期：更早以前</td></tr>
					<c:set var="longAgoMarked" value="${true}" />
				</c:if>
			</c:if>
			
			<tr id="<c:out value='${mail.uuid}'/>" class="<c:out value="read_${mail.readed}" /> item" height="30">
				<td class="checkbox">
					<input class="inputChkbox" type="checkbox" name="uuid" value='<c:out value="${mail.uuid}" />' />
				</td>
				<td>
					<span class="mailStatus">
					<c:if test="${!mail.reply}" ><b class="reply unreplyed" title="未回复"/></c:if>
					<c:if test="${mail.reply}" ><b class="reply replyed" title="已回复"/></c:if>
					<c:if test="${mail.priority eq '1'}" ><b class="pri1" title="重要邮件"/></c:if>
					<c:if test="${mail.priority eq '3'}" ><b class="pri3" title="普通邮件"/></c:if>
					<c:if test="${mail.priority eq '5'}" ><b class="pri5" title="不重要邮件"/></c:if>
					<c:if test="${mail.hasAttach}"><b class="attach" title="此邮件带附件"/></c:if>
					</span>
				</td>
				<c:if test="${folder.id eq 'draft' || folder.id eq 'sent'}">
					<td class="to" title="<c:out value="${mail.toDisplayName}" />">
						<div><c:out value="${mail.toDisplayName}" /></div>
					</td>
				</c:if>
				<c:if test="${folder.id ne 'draft' && folder.id ne 'sent'}">
					<td class="from" title="<c:out value="${mail.fromDisplayName}" />">
						<div><c:out value="${mail.fromDisplayName}" /></div>
					</td>
				</c:if>
				<td class="subject">
					<a href="javascript:Mails.openMail('<c:out value="${mail.uuid}" />')">
						<c:if test="${empty mail.subject}">(无标题)</c:if>
						<c:if test="${not empty mail.subject}"><c:out value="${mail.subject}" /></c:if>
					</a>
				</td>
				<td class="lastModified">
					<fmt:formatDate value="${mail.lastModifiedDate}" type="both" pattern="yy-MM-dd HH:mm" />
				</td>
				<td class="size"><c:out value="${mail.tgmkSize}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<div class="Tools2">
	<span>选择：</span>
	<a href="javascript:Mails.selectAllForce(true)">全部</a>
	<span>-</span>
	<a href="javascript:Mails.selectReadForce(false)">未读</a>
	<span>-</span>
	<a href="javascript:Mails.selectReadForce(true)">已读</a>
	<span>-</span>
	<a href="javascript:Mails.selectAllForce(false)">不选</a>
</div>



<div class="wpxTools" > 
	<table class="menuTable" border="0" cellpadding="0" cellspacing="0" >
		<tr>
			<td class="delete">
				<a class="button delete" href="javascript:Mails.remove()"><span class="title">永久删除</span></a>
			</td>
			<td class="moveToTrash">
				<a class="button moveToTrash" href="javascript:Mails.moveTo('trash')"><span class="title">移到废件箱</span></a>
			</td>
			<td class="moveTo">
				<a class="button wxMenuButton moveTo" href="javascript:">
					<span class="title">移到</span>
					<b class="arr"></b>
				</a>
				<table class="wxDropMenu foldersMenu" border="0" cellpadding="0" cellspacing="0" >
					
				</table>
			</td>
			<td class="mark">
				<a class="button wxMenuButton mark" href="javascript:">
					<span class="title">标记</span>
					<b class="arr"></b>
				</a>
				<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
					<tr><td><a class="markRead" href="javascript:Mails.markRead(true)"><span class="title">标记为已读</span></a></td></tr>
					<tr><td><a class="markUnread" href="javascript:Mails.markRead(false)"><span class="title">标记为未读</span></a></td></tr>
					<tr><td><a class="markReplied" href="javascript:Mails.markReplied(true)"><span class="title">标记为已回复</span></a></td></tr>
				</table>
			</td>
			
			<td class="view">
				<a class="button wxMenuButton view" href="javascript:">
					<span class="title">查看</span>
					<b class="arr"></b>
				</a>
				<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
					<tr><td width="100"><a href="javascript:Mails.selectAllForce(true)"><span class="title">全部</span></a></td></tr>
					<tr><td><a href="javascript:Mails.selectReadForce(false)"><span class="title">未读</span></a></td></tr>
					<tr><td><a href="javascript:Mails.selectReadForce(true)"><span class="title">已读</span></a></td></tr>
					<tr><td><a href="javascript:Mails.selectAllForce(false)"><span class="title">不选</span></a></td></tr>
				</table>
			</td>
			
			<td class="refresh">
				<a class="button refresh" href="javascript:Mails.refresh(true)"><span class="title">刷新</span></a>
			</td>
		</tr>
	</table>
	
	<div class="pageBarHTML">
		<c:out value="${pageBarTdsHTML}" escapeXml="false" />
	</div>
</div>


<script type="text/javascript">

Mails.folderid= '<c:out value="${folder.id}" />';
Mails.sortBy= '<c:out value="${sortBy}" />';
Mails.isUp= '<c:out value="${isUp}" />';
Mails.pageNum= '<c:out value="${pageNum}" />';
Mails.countPerPage= '<c:out value="${countPerPage}" />';
Mails.condition= '<c:out value="${condition}" />';
Mails.keyword= '<c:out value="${_keyword}" />';


$(document).ready(function() {
	/********** Enahnce menuButton **********/
	Enhance.menuButton();
	
	/********** Enahnce Mails Tr Hover **********/
	$(".wpxTable tbody tr.item")
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
			//Mails.selectAllForce(false);
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
		$(this).attr("href", "javascript: MailFolders.openUrl('<c:out value='${folderid}' />','" + href + "')");
	});
	
	
	/********** Enahnce Mails Checkbox(All) **********/
	$("table.wpxTable input#checkAll").click(
		function() {
			Mails.selectAll();
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
	
	/********** foldersMenu **********/
	var foldersHtml = '';
	for(var i=0;i<MailFolders.sysFolders.length;i++ ){
		var f = MailFolders.sysFolders[i];
		foldersHtml+='<tr><td><a href=\"javascript:Mails.moveTo(\''+ f.id +'\')\"><span class=\"title\">'+ f.name +'</span></a></td></tr>'
	}
	for(var i=0;i<MailFolders.myFolders.length;i++ ){
		var f = MailFolders.myFolders[i];
		foldersHtml+='<tr><td><a href=\"javascript:Mails.moveTo(\''+ f.id +'\')\"><span class=\"title\">'+ f.name +'</span></a></td></tr>'
	}
	$('.foldersMenu').html(foldersHtml);
});

</script>