<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
#BookmarkBody {
	vertical-align:top;
	height: 100%;
	width:auto;
}

</style>


<div id="Bookmark">
	<div class="wpxTitle">
		<div class="title">
			<h2>网上书签</h2>
			<span>(共计有 <strong><c:out value='${allcount}'/></strong> 个书签)</span>
		</div>
		<div class="search-box" style="display: none;">
			<input id="searchText" class="search-input" type="text" name="keyword" value="<c:out value='${_keyword }'/>">
			<span id="searchBtn" class="search-btn" title="搜索邮件" onclick="<c:out value='javascript:NetDisk.search();'/>">搜索</span>
		</div>
		<div style="clear: both;"></div>
	</div>
		
	<div class="wpxTools">
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="160">
					<div class="groupBtnBar" style="padding-left: 10px;">
						<a hidefocus="true" href="javascript:Bookmark.addFolder();">新建组</a>
						<a hidefocus="true" href="javascript:Bookmark.modFolder();">修改组</a>
						<a hidefocus="true" href="javascript:Bookmark.delFolder();">删除组</a>
					</div>
				</td>
				<td>
					<a class="button" href="javascript:Bookmark.addItem();"><span class="title">新增书签</span></a>
				</td>
				<td>
					<a class="button" href="javascript:Bookmark.delItem();"><span class="title">删除书签</span></a>
				</td>
				<td>
					<a class="button" href="javascript:Bookmark.modItem();"><span class="title">修改书签</span></a>
				</td>
				<td>
					<a class="button wxMenuButton" href="javascript:">
						<span class="title">复制到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a href="javascript:Bookmark.copyTo('')"><span class="title">根目录</span></a></td></tr>
						<c:forEach var="forder" items="${forders}" >
							<tr><td><a href="javascript:Bookmark.copyTo('<c:out value="${forder.uuid}" />')"><span class="title"><c:out value="${forder.name}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<a class="button wxMenuButton" href="javascript:">
						<span class="title">移动到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a href="javascript:Bookmark.moveTo('')"><span class="title">根目录</span></a></td></tr>
						<c:forEach var="forder" items="${forders}" >
							<tr><td><a href="javascript:Bookmark.moveTo('<c:out value="${forder.uuid}" />')"><span class="title"><c:out value="${forder.name}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<a class="button" href="javascript:Bookmark.importItems();"><span class="title">导入书签</span></a>
				</td>
				<td>
					<a class="button wxMenuButton" href="javascript:">
						<span class="title">导出书签</span>
						<b class="arr"></b>
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a href="bookmark/export.down?folderuuid="><span class="title">根目录</span></a></td></tr>
						<c:forEach var="forder" items="${forders}" >
							<tr><td><a href="bookmark/export.down?folderuuid=<c:out value='${forder.uuid}' />"><span class="title"><c:out value="${forder.name}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
		
	</div>
	
	<table border="0" cellpadding="0" cellspacing="0" width="100%" height="auto" style="table-layout: fixed;">
		<tr>
			<td valign="top" id="BookmarkTreeBar" class="sidebar">
				<c:import url="forders.html"/>
			</td>
			<td valign="top" id="BookmarkBody">
			</td>
		</tr>
	</table>
	
	
	<div class="wpxTools">
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="160">
				</td>
				<td>
					<a class="button" href="javascript:Bookmark.addItem();"><span class="title">新增书签</span></a>
				</td>
				<td>
					<a class="button" href="javascript:Bookmark.delItem();"><span class="title">删除书签</span></a>
				</td>
				<td>
					<a class="button" href="javascript:Bookmark.modItem();"><span class="title">修改书签</span></a>
				</td>
				<td>
					<a class="button wxMenuButton" href="javascript:">
						<span class="title">复制到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a href="javascript:Bookmark.copyTo('')"><span class="title">根目录</span></a></td></tr>
						<c:forEach var="forder" items="${forders}" >
							<tr><td><a href="javascript:Bookmark.copyTo('<c:out value="${forder.uuid}" />')"><span class="title"><c:out value="${forder.name}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<a class="button wxMenuButton" href="javascript:">
						<span class="title">移动到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a href="javascript:Bookmark.moveTo('')"><span class="title">根目录</span></a></td></tr>
						<c:forEach var="forder" items="${forders}" >
							<tr><td><a href="javascript:Bookmark.moveTo('<c:out value="${forder.uuid}" />')"><span class="title"><c:out value="${forder.name}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<a class="button" href="javascript:Bookmark.importItems();"><span class="title">导入书签</span></a>
				</td>
				<td>
					<a class="button wxMenuButton" href="javascript:">
						<span class="title">导出书签</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a href="bookmark/export.down?folderuuid="><span class="title">根目录</span></a></td></tr>
						<c:forEach var="forder" items="${forders}" >
							<tr><td><a href="bookmark/export.down?folderuuid=<c:out value='${forder.uuid}' />"><span class="title"><c:out value="${forder.name}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
		
	</div>
	
</div>



<script type="text/javascript">

$(document).ready(function() {
	/********** Enahnce menuButton **********/
	Enhance.menuButton();
	
	Bookmark.open('');
	
	$('#BookmarkTreeBar li a')
		.mousemove(function() {
			if($(this).attr("class")!="on")
				$(this).addClass("over");
		})
		.mouseout(function() {
			$(this).removeClass("over");
		});

});

</script>