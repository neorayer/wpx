<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="WPX管理控制台：${ACTOR.uniqueId}" /></title>
<style type="text/css">
	#Frame{
		border-top: 1px solid #000000;
	}
</style>
</head>
<frameSet rows="87,*" bordercolor="#ffffff" border="0"  id="Frame">
	<frame name="headFrame" src="portal/header.html" scrolling="no" frameBorder="0"  border="0" bordercolor="#979797"/>
	<frame name="mainFrame"  scrolling="auto" frameBorder="0" noresize="noresize" src="about:blank"/>
</frameSet>
</html>