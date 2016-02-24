<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="gSidebar theme-sb-top">
	<div class="core">
		<a hidefocus="true" class="check" href="javascript:void(0);" onclick="MailFolders.receiveMail();">收信</a>
		<a hidefocus="true" class="compose" href="javascript:void(0);" onclick="Compose.build('mail/compose.html');">写信</a>
	</div>
	
	<div class="cnav gSb-sfolder">
		<ul id="ulSysFolders" class="folders">
			<c:forEach var="f" items="${sysFolders}" >
			<li id="<c:out value='fd_${f.id}'/>" class="<c:if test='${f.id eq folderid}'>on</c:if>">
				<a hidefocus="true" class="ct"  href="javascript:MailFolders.open('<c:out value='${f.id}'/>')">
					<c:if test="${f.id eq 'inbox'}" >
						<strong><c:out value='${f.name}'/></strong>
					</c:if>
					<c:if test="${f.id ne 'inbox'}" >
						<c:out value='${f.name}'/>
					</c:if>
					<c:if test="${f.viewCount}" >
						<strong><c:out value='(${f.newCount}/${f.count })'/></strong>
					</c:if>
					<c:if test="${!f.viewCount}" >
						<strong><c:out value='(${f.newCount})'/></strong>
					</c:if>
				</a>
				<c:if test="${f.clearable}">
					<a hidefocus="true" href="javascript:MailFolders.empty('<c:out value='${f.id}'/>')"  class="fn-bg Aept">清空</a>
				</c:if>
			</li>
			</c:forEach>
			<li>
				<a  href="http://61.175.226.139:17000/SpamNH/pg/do/viewSH.jsp?rcptto=<c:out value='${LoginMail }'/>" target="_blank" class="ct" hidefocus="true">垃圾邮件箱</a>
			</li>
		</ul>
	</div>
	
	<div class="ln-thin ln-c-mid"></div>
	<div class="cnav gSb-sspecial">
		<ul>
			<c:if test="${mod_personAddr eq 0}">
			<li id="personAddr" class="">
				<b class="ico ico-addr"></b>
				<a hidefocus="true" href="javascript:SideBar.open('#personAddr', 'personAddr/main.html');">个人通讯录</a>
			</li>
			</c:if>
			<c:if test="${mod_publicAddr eq 0}">
			<li id="publicAddr" class="">
				<b class="ico ico-paddr"></b>
				<a hidefocus="true" href="javascript:SideBar.open('#publicAddr', 'publicAddr/main.html');">公共通讯录</a>
			</li>
			</c:if>
		</ul>
	</div>

	<div class="ln-thin ln-c-mid"></div>
	
	<div class="cnav gSb-sOTmail">
		<div class="gSb-cnav-tit">
			<a id="lnkDefToggle" hidefocus="true" class="fn-bg opned" href="javascript:SideBar.UFToggle();" title="收起其他文件夹"></a>
			<a id="spnDefCount" hidefocus="true" class="ct" href="javascript:SideBar.UFToggle();">其他文件夹&nbsp;<span style="display: none;"></span></a>
			<a hidefocus="true" title="添加" class="fn-bg Aadd" href="javascript:MailFolders.openFolders();">添加</a>
			<a hidefocus="true" title="管理" class="fn-bg Amag" href="javascript:MailFolders.openFolders();">管理</a>
		</div>
		<ul id="ulDefFolders" class="folders">
			<c:forEach var="f" items="${myFolders}" >
			<li id="<c:out value='fd_${f.id}'/>" class="<c:if test='${f.id eq folderid}'>on</c:if>">
				<b class="ico-account ico-act-default"></b>
				<a hidefocus="true" class="ct"  href="javascript:MailFolders.open('<c:out value='${f.id}'/>')">
					<c:out value='${f.name}'/>
					<c:if test="${f.newCount > 0}" >
						<strong><c:out value='(${f.newCount})'/></strong>
					</c:if>
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	

	<div class="ln-thin ln-c-mid"></div>
	<div class="cnav gSb-sservice">
		<div class="gSb-cnav-tit">
			<a id="lnkServiceToggle" hidefocus="true"  class="fn-bg opned" href="javascript:SideBar.SFToggle();" title="收起邮箱服务"></a>
			<a hidefocus="true" class="ct" href="javascript:SideBar.SFToggle();">邮箱服务</a>
		</div>
			
		<ul class="ulServiceFolders">
			<c:if test="${mod_netdisk eq 0}">
			<li id="fd_netdisk">
				<b style="display: none;" id="bLockNf" class="ico ico-lock"></b>
				<a hidefocus="true" class="ct" href="javascript:SideBar.open('#fd_netdisk', 'netdisk/main.html');">网络U盘</a>
			</li>
			</c:if>
			<c:if test="${mod_bookmark eq 0}">
			<li id="fd_bookmark">
				<b style="display: none;" id="bLockNf" class="ico ico-lock"></b>
				<a hidefocus="true" class="ct" href="javascript:SideBar.open('#fd_bookmark', 'bookmark/main.html');">网上书签</a>
			</li>
			</c:if>
			
			<li id="smspack" style="display: none;"></li>
		</ul>
	</div>
	
</div>



<script type="text/javascript">
<!--
//初始化邮件夹
if(MailFolders.sysFolders.length == 0){
	MailFolders.sysFolders = [];
	<c:forEach var="f" items="${sysFolders}" >
		MailFolders.sysFolders.push({
			id: 	'<c:out value="${f.id}" />',
			name: 	'<c:out value="${f.name}" />'
		});
	</c:forEach>
}
if(MailFolders.myFolders.length == 0){
	MailFolders.myFolders = [];
	<c:forEach var="f" items="${myFolders}" >
		MailFolders.myFolders.push({
			id: 	'<c:out value="${f.id}" />',
			name: 	'<c:out value="${f.name}" />'
		});
	</c:forEach>
}
//alert(MailFolders.sysFolders.length+"-"+MailFolders.myFolders.length);

//初始化 其它文件夹 关闭|打开
var $lnkDefToggle = $('#lnkDefToggle');
var $lnkDefFolders = $('#ulDefFolders');
if(!MailFolders.isOpen){
	$lnkDefToggle.removeClass('opned');
	$lnkDefToggle.addClass('clded');
	
	$lnkDefFolders.hide();
}else {
	$lnkDefToggle.removeClass('clded');
	$lnkDefToggle.addClass('opned');
	
	$lnkDefFolders.show();
}


$('.gSidebar .cnav li')
	.mousemove(function() { 
		if($(this).attr("class")!="on")
			$(this).addClass("over");
	})
	.mouseout(function() {
		$(this).removeClass("over");
	});
	/*
	.mousedown(function() {
		$('#ulSysFolders li').removeClass("on");
		$(this).addClass("on");
	});
	*/

//-->
</script>
