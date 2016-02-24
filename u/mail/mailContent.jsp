<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"> 
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<style type="text/css">
		body {
			min-height:200px;  
		    height:auto !important;  
		    height:200px;
		    padding-bottom: 10px;
		}
		
		hr {
			border: none;
			border-bottom: 1px solid #CCCCCC;
		}
	</style>
</head>
<body>
	<c:set var="isPlain" value="${empty mail.contentTextHtml}" />
	<c:if test="${isPlain}">
		<c:out value='${mail.contentTextPlain}' escapeXml="false"/>
	</c:if>
	<c:if test="${not isPlain}">
		<c:out value='${mail.contentTextHtml}' escapeXml="false"/>
	</c:if>

</body>
</html>
