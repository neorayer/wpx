<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
#perAddrBody {
	vertical-align:top;
	height: 100%;
	width:auto;
}

</style>


<div id="Person">
		<div class="wpxTitle">
			<div class="title">
				<h2>个人通讯录</h2>
				<span>(共 <strong><c:out value="${allGroupCount}" /></strong> 个分组, <strong><c:out value="${allPersonCount}" /></strong> 个联系人)</span>
			</div>
			<div class="search-box">
				<input id="searchText" class="search-input" type="text" name="keyword" value="<c:out value='${_keyword }'/>">
				<span id="searchBtn" class="search-btn" title="搜索邮件" onclick="<c:out value='javascript:PersonAddr.openUrl("personAddr/main.html?groupid=${groupid}&keyword="+encodeURIComponent(document.getElementById("searchText").value))'/>">搜索</span>
			</div>
		</div>
		
		<div class="wpxTools"> 
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="160">
					<div class="groupBtnBar" style="padding-left: 10px;">
						<a hidefocus="true" href="javascript:PersonAddr.addGroup()">新建组</a>
						<a hidefocus="true" href="javascript:PersonAddr.editGroup()">编辑组</a>
						<a hidefocus="true" href="javascript:PersonAddr.delGroup()">删除组</a>
					</div>
				</td>
				<td><a class="button wirtemail" href="javascript:PersonAddr.viCompose();"><span class="title">写邮件</span></a></td>
				<td><a class="button addaddr" href="javascript:PersonAddr.addAddr('<c:out value='${groupid}'/>');"><span class="title">添加联系人</span></a></td>
				<td>
					<a class="button wxMenuButton moveTo" href="javascript:">
						<span class="title">移到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<c:forEach var="g" items="${grps}" >
							<tr><td><a href="javascript:PersonAddr.moveTo('<c:out value="${g.uuid}" />')"><span class="title"><c:out value="${g.groupName}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td style="display: none;">
					<a class="button wxMenuButton mark" href="javascript:PersonAddr.insertPsns()">
						<span class="title">导入</span>
					</a>
				</td>
				<td style="display: none;">
					<a class="button wxMenuButton reject" href="javascript:">
						<span class="title">导出</span>
						<b class="arr"></b>
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a class="rejectAddress" href="javascript:PersonAddr.exportAll()"><span class="title">导出全部联系人</span></a></td></tr>
						<tr><td><a class="rejectSubject" href="javascript:PersonAddr.exportGroup('<c:out value="${groupid}" />')"><span class="title">导出选中组联系人</span></a></td></tr>
						<tr><td><a class="rejectDomain" href="javascript:PersonAddr.exportPsn()"><span class="title">导出选中联系人</span></a></td></tr>
					</table>
				</td>
				<td>
					<a class="button delete" href="javascript:PersonAddr.del('<c:out value="${groupid}" />')"><span class="title">删除</span></a>
				</td>
				<td>
					<a class="button refresh" href="javascript:PersonAddr.refresh(true);"><span class="title">刷新</span></a>
				</td>
			</tr>
		</table>
		
		<div class="pageBarHTML">
			<c:out value="${pageBarTdsHTML}" escapeXml="false" />
		</div>
	</div>
	
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top" id="perAddrTreeBar" class="sidebar">
				<c:import url="groups.jsp"/>
			</td>
			<td valign="top" id="perAddrBody">
				<c:import url="addrs.jsp"/>
			</td>
		</tr>
	</table>
	
	
	<div class="wpxTools"> 
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="160"></td>
				<td><a class="button wirtemail" href="javascript:PersonAddr.viCompose();"><span class="title">写邮件</span></a></td>
				<td><a class="button addaddr" href="javascript:PersonAddr.addAddr('<c:out value='${groupid}'/>');"><span class="title">添加联系人</span></a></td>
				<td>
					<a class="button wxMenuButton moveTo" href="javascript:">
						<span class="title">移到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<c:forEach var="g" items="${grps}" >
							<tr><td><a href="javascript:PersonAddr.moveTo('<c:out value="${g.uuid}" />')"><span class="title"><c:out value="${g.groupName}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td style="display: none;">
					<a class="button wxMenuButton mark" href="javascript:PersonAddr.insertPsns()">
						<span class="title">导入</span>
					</a>
				</td>
				<td style="display: none;">
					<a class="button wxMenuButton reject" href="javascript:">
						<span class="title">导出</span>
						<b class="arr"></b>
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a class="rejectAddress" href="javascript:PersonAddr.exportAll()"><span class="title">导出全部联系人</span></a></td></tr>
						<tr><td><a class="rejectSubject" href="javascript:PersonAddr.exportGroup('<c:out value="${groupid}" />')"><span class="title">导出选中组联系人</span></a></td></tr>
						<tr><td><a class="rejectDomain" href="javascript:PersonAddr.exportPsn()"><span class="title">导出选中联系人</span></a></td></tr>
					</table>
				</td>
				<td>
					<a class="button delete" href="javascript:PersonAddr.del('<c:out value="${groupid}" />')"><span class="title">删除</span></a>
				</td>
				<td>
					<a class="button refresh" href="javascript:PersonAddr.refresh();"><span class="title">刷新</span></a>
				</td>
			</tr>
		</table>
		
		<div class="pageBarHTML">
			<c:out value="${pageBarTdsHTML}" escapeXml="false" />
		</div>
	</div>
</div>


<script type="text/javascript">

$(document).ready(function() {
	PersonAddr.sortBy = '<c:out value="${sortBy}" />';
	PersonAddr.isUp = '<c:out value="${isUp}" />';
	PersonAddr.pageNum = '<c:out value="${pageNum}" />';
	PersonAddr.countPerPage = '<c:out value="${countPerPage}" />';
	PersonAddr.condition = '<c:out value="${condition}" />';
	PersonAddr.keyword = '<c:out value="${_keyword}" />';
	PersonAddr.groupid = '<c:out value="${groupid}" />';
	
	/********** Enahnce menuButton **********/
	Enhance.menuButton();

	$('#perAddrTreeBar li a')
		.mousemove(function() {
			if($(this).attr("class")!="on")
				$(this).addClass("over");
		})
		.mouseout(function() {
			$(this).removeClass("over");
		});
	
	$(".pageBarHTML a").each(function() {
		var href = $(this).attr('href');
		$(this).attr("href", "javascript: PersonAddr.openUrl('" + href + "')");
	});
	
});

</script>