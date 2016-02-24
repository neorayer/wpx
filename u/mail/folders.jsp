<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="pgFolders">
	<div class="wpxTitle">
		<div class="title">
			<h2>文件夹管理</h2>
		</div>
		<div class="search-box">
			
		</div>
	</div>
	
	
	<form id="folderAdd" action="" method="post">
		新建邮件夹：<input id="folderName"  name="name" value="" type="text" />
		<input id="folderAddSubmit" type="button" onclick="MailFolders.doAdd()" value="新建" />
	</form>
	
	<table class="wpxTable">
		<thead>
			<tr>
				<td>文件夹</td>
				<td class="bl">未读邮件</td>
				<td class="bl">总封数</td>
				<td class="bl" id="op">操作</td>
			</tr>
		</thead>
	</table>
	
	<div class="table-title theme-bor-col"><h3>系统文件夹</h3></div>
	<table class="wpxTable">
		<tbody>
			<c:forEach var="f" items="${sysFolders}" >
			<tr height="30">
				<td>
					<a href="javascript:MailFolders.open('<c:out value='${f.id}'/>');"><c:out value="${f.name}" /></a>
				</td>
				<td><c:out value="${f.newCount}" /></td>
				<td><c:out value="${f.count}" /></td>
				<td>
					<c:if test="${not f.sysFolder}" >
						<a href="javascript:MailFolders.empty('<c:out value='${f.id}' />')">[清空]</a>
						<a href="javascript:MailFolders.del('<c:out value='${f.id}' />')">[删除]</a>
					</c:if>
					<c:if test="${f.id == 'trash' || f.id == 'spam'}" >
						<a href="javascript:MailFolders.empty('<c:out value='${f.id}' />')">[清空]</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="table-title theme-bor-col"><h3>自定义文件夹</h3></div>
	<table class="wpxTable">
		<tbody>
			<c:forEach var="f" items="${myFolders}" >
			<tr height="30">
				<td>
					<a href="javascript:MailFolders.open('<c:out value='${f.id}'/>');"><c:out value="${f.name}" /></a>
				</td>
				<td><c:out value="${f.newCount}" /></td>
				<td><c:out value="${f.count}" /></td>
				<td>
					<c:if test="${not f.sysFolder}" >
						<a href="javascript:MailFolders.empty('<c:out value='${f.id}' />')">[清空]</a>
						<a href="javascript:MailFolders.del('<c:out value='${f.id}' />')">[删除]</a>
					</c:if>
					<c:if test="${f.id == 'trash' || f.id == 'spam'}" >
						<a href="javascript:MailFolders.empty('<c:out value='${f.id}' />')">[清空]</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>


<script language="javascript">
MailFolders.folders = [];
<c:forEach var="f" items="${allFolders}" >
	MailFolders.folders.push({
		id: 	'<c:out value="${f.id}" />',
		name: 	'<c:out value="${f.name}" />'
	});
</c:forEach>

MailFolders.sysFolders = [];
<c:forEach var="f" items="${sysFolders}" >
	MailFolders.sysFolders.push({
		id: 	'<c:out value="${f.id}" />',
		name: 	'<c:out value="${f.name}" />'
	});
</c:forEach>

MailFolders.myFolders = [];
<c:forEach var="f" items="${myFolders}" >
	MailFolders.myFolders.push({
		id: 	'<c:out value="${f.id}" />',
		name: 	'<c:out value="${f.name}" />'
	});
</c:forEach>

$(document).ready(function() {
	MailFolders.enableAdd(false);
	$('form#folderAdd input#folderName').val("");
	
	$('form#folderAdd input#folderName').keyup(function() {
		MailFolders.validateAdd();
	});
	
	
});
</script>