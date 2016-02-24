<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div id="Public">
	<div class="wpxTitle">
		<div class="title">
			<h2>公共通讯录</h2>
			<span>(共 <strong><c:out value="${allGroupCount}" /></strong> 个分组, <strong><c:out value="${allPersonCount}" /></strong> 个联系人)</span>
		</div>
		<div class="search-box">
			<input id="searchText" class="search-input" type="text" name="keyword" value="<c:out value='${_keyword }'/>">
			<span id="searchBtn" class="search-btn" title="搜索邮件" onclick="<c:out value='javascript:PublicAddr.openUrl("publicAddr/addrs.html?groupid=${groupid}&keyword="+encodeURIComponent(document.getElementById("searchText").value))'/>">搜索</span>
		</div>
	</div>
	
	<div class="wpxTools"> 
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="160"></td>
				<td><a class="button wirtemail" href="javascript:PublicAddr.viCompose();"><span class="title">写邮件</span></a></td>
				<td><a class="button addaddr" href="javascript:PublicAddr.copyToPsn('<c:out value='${groupid}'/>');"><span class="title">复制到个人通讯录</span></a></td>
				<td><a class="button refresh" href="javascript:PublicAddr.refresh(true);"><span class="title">刷新</span></a></td>
			</tr>
		</table>
		<div class="pageBarHTML">
		</div>
	</div>
	
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top" id="pubAddrTreeBar" class="">
				<c:import url="depts.html"/>
			</td>
			<td valign="top">
				<div id="pubAddrBody"></div>
				<div id="pubAddrViPsn"></div>
			</td>
		</tr>
	</table>
	
	<div class="wpxTools"> 
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="160"></td>
				<td><a class="button wirtemail" href="javascript:PublicAddr.viCompose();"><span class="title">写邮件</span></a></td>
				<td><a class="button addaddr" href="javascript:PublicAddr.copyToPsn('<c:out value='${groupid}'/>');"><span class="title">复制到个人通讯录</span></a></td>
				<td><a class="button refresh" href="javascript:PublicAddr.refresh(true);"><span class="title">刷新</span></a></td>
			</tr>
		</table>
		<div class="pageBarHTML">
		</div>
	</div>
	
	<div style="clear: both;"></div>
</div>


<script type="text/javascript">
$(document).ready(function() {

	PublicAddr.sortBy = '<c:out value="${sortBy}" />';
	PublicAddr.isUp = '<c:out value="${isUp}" />';
	PublicAddr.pageNum = '<c:out value="${pageNum}" />';
	PublicAddr.countPerPage = '<c:out value="${countPerPage}" />';
	PublicAddr.condition = '<c:out value="${condition}" />';
	PublicAddr.keyword = '<c:out value="${_keyword}" />';
	PublicAddr.groupid = '<c:out value="${groupid}" />';

	//PublicAddr.arrageTree();
	PublicAddr.open('all', 'all');
});

</script>