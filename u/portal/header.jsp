<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="pgHeader" class="gTop theme-tr">
	<div class="fn-bg top-tl"></div>

	<h1 class="logo">
		<a id="lnkHome" href="javascript:void(0);" onclick="Portal.rt('main.html');return false;">
			<img border="0" id="imgLogo" class="gLogo" alt="SkyMiracle邮箱" src="<c:out value='${ProjectBase}${logoPath }'/>">
		</a>
	</h1>
	
	<div id="pgHeaderMenu" class="info">
		<c:choose>
			<c:when test="${not empty ACTOR.displayName}">
			<strong><c:out value='${ACTOR.displayName}'/>的邮箱</strong>
			</c:when>
			<c:otherwise>
			<strong><c:out value='${LoginMail}'/></strong>	
			</c:otherwise>
		</c:choose>
		&nbsp;&nbsp;
		<a href="javascript:void(0);" onclick="HeadMenu.index();return false;">邮箱首页</a>
		<span>|</span>
		<a href="javascript:void(0);" onclick="HeadMenu.options();">邮箱设置</a>
		<span>|</span>
		<a href="javascript:void(0);" onclick="HeadMenu.skins();">换肤设置</a>
	</div>
	
	<a id="pgLogout" class="logout" href="javascript:void(0);" onclick="Portal.rt('logout.html');return false;">安全退出</a>
</div>
