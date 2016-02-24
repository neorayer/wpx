<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"> 
<html>
<head>
	<base href="<c:out value='${ProjectBase }u/'/>">
	<c:choose>
		<c:when test="${not empty ACTOR.displayName}">
		<title><c:out value='${ACTOR.displayName}'/>的邮箱</title>
		</c:when>
		<c:otherwise>
		<title><c:out value='${LoginMail}'/></title>
		</c:otherwise>
	</c:choose>
	<c:import url="../_pub/common_head.jsp" />
	<link rel="stylesheet" href="_skin/global.css" type="text/css" ></link>
	<link id="skin-css-link" rel="stylesheet" href="_skin/<c:out value='${ACTOR.skinCode }'/>/skin.css" type="text/css" ></link>
	<link rel="stylesheet" href="_skin/common.css" type="text/css" ></link>
	<script type="text/javascript" src="_js/mail.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		Portal.ProjectBase = "<c:out value='${ProjectBase }'/>";
	
		$.ajaxSetup ({
		    cache: false //关闭AJAX相应的缓存
		});
		
		$("div#LoadingPanel")
			.ajaxStart(function(){
				$(this).show();
				
			}).ajaxStop(function() {
				$(this).hide();
			});
		
		deleteCookie("uia_param", '<%=request.getContextPath()%>');
	});
	</script>
</head>
<body>
	<div id="LoadingPanel">
		<b id="IcoLoading"></b>
		<p id="LoadingMsg">数据加载中，请稍候..</p>
	</div>
	
	<div id="LoadingPanel1">
		<b id="IcoLoading1"></b>
		<p id="LoadingMsg1"></p>
	</div>
	
	<table id="LayoutTable">
		<thead>
			<tr>
				<td class="gFToptd">
					<c:import url="header.html" />
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="gFMaintd">
					<table class="gMtable">
						<tr>
							<td class="gMl theme-sb-bot">
								<div id="gFSide">
									<c:import url="side.html" />
								</div>
								<div class="keep"></div>
							</td>
							<td class="gMr">
								<div id="tipMsg"></div>  
								
								<div id="gFMain" class="gWel">
									<c:import url="${PL}"/>
								</div>
								
								<div id="composeIframe"></div>
								
								<div id="viewMail"></div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
