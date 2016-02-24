<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="wpxTitle">
	<div class="title">
		<h2>网络U盘</h2>
		<span>(占用空间 <strong><c:out value='${spaceSize}'/></strong>)</span>
	</div>
	<div class="search-box" style="display: none;">
		<input id="searchText" class="search-input" type="text" name="keyword" value="<c:out value='${_keyword }'/>">
		<span id="searchBtn" class="search-btn" title="搜索邮件" onclick="<c:out value='javascript:NetDisk.search();'/>">搜索</span>
	</div>
	<div style="clear: both;"></div>
</div>