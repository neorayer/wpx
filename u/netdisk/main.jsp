<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
#netdiskBody {
	vertical-align:top;
	height: 100%;
	width:auto;
}
#netdisk .wxDropMenu {
	width: 150px;
	table-layout: fixed;
	
}

#netdisk .wxDropMenu td {
	overflow:hidden;text-overflow:ellipsis;
}
</style>


<div id="netdisk">
	<div id="NetDiskSize"><c:import url="size.html"/></div>
		
	<div class="wpxTools">
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="160">
					<div class="groupBtnBar" style="padding-left: 10px;">
						<a hidefocus="true" href="javascript:NetDisk.addFolder();">新建组</a>
						<a hidefocus="true" href="javascript:NetDisk.delFolder();">删除组</a>
					</div>
				</td>
				<td><a class="button wirtemail" href="javascript:NetDisk.addFile();"><span class="title">上传新文件</span></a></td>
				<td>
					<a class="button wxMenuButton moveTo" href="javascript:">
						<span class="title">移到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" style="table-layout: fixed">
						<tr><td><a href="javascript:NetDisk.moveTo('/')"><span class="title">根目录</span></a></td></tr>
						<c:forEach var="g" items="${grps}" >
							<tr><td><a title="<c:out value="${g.name}" />" href="javascript:NetDisk.moveTo('<c:out value="${g.uuid}" />')"><span class="title"><c:out value="${g.name}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<a class="button wxMenuButton mark" href="javascript:NetDisk.refresh()"><span class="title">刷新</span></a>
				</td>
				
				<td>
					<a class="button delete" href="javascript:NetDisk.del()"><span class="title">删除</span></a>
				</td>
			</tr>
		</table>
		
	</div>
	
	<table border="0" cellpadding="0" cellspacing="0" width="100%" height="auto" style="table-layout:fixed;">
		<tr>
			<td valign="top" id="netdiskTreeBar" class="sidebar">
				<c:import url="groups.html"/>
			</td>
			<td valign="top" id="netdiskBody">
			</td>
		</tr>
	</table>
	
	<div class="wpxTools">
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="160"></td>
				<td><a class="button wirtemail" href="javascript:NetDisk.addFile();"><span class="title">上传新文件</span></a></td>
				<td>
					<a class="button wxMenuButton moveTo" href="javascript:">
						<span class="title">移到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a href="javascript:NetDisk.moveTo('/')"><span class="title">根目录</span></a></td></tr>
						<c:forEach var="g" items="${grps}" >
							<tr><td><a href="javascript:NetDisk.moveTo('<c:out value="${g.uuid}" />')"><span class="title"><c:out value="${g.name}" /></span></a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<a class="button wxMenuButton mark" href="javascript:NetDisk.refresh()"><span class="title">刷新</span></a>
				</td>
				
				<td>
					<a class="button delete" href="javascript:NetDisk.del()"><span class="title">删除</span></a>
				</td>
			</tr>
		</table>
		
	</div>
	
</div>



<script type="text/javascript">

$(document).ready(function() {
	/********** Enahnce menuButton **********/
	Enhance.menuButton();
	
	NetDisk.open('/');
	
	$('#netdiskTreeBar li a')
		.mousemove(function() {
			if($(this).attr("class")!="on")
				$(this).addClass("over");
		})
		.mouseout(function() {
			$(this).removeClass("over");
		});

});

</script>