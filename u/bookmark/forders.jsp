<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<li>
		<a uuid="" id="forder_" hidefocus="true" href="javascript:Bookmark.open('');" class="<c:if test='${empty forderuuid}'>on</c:if>">
			根目录
		</a>
	</li>
	
	<c:forEach var="forder" items="${forders}">
	<li>
		<a title="<c:out value='${forder.name}'/>" uuid="<c:out value='${forder.uuid}'/>" id="forder_<c:out value='${forder.uuid}'/>" hidefocus="true" href="javascript:Bookmark.open('<c:out value='${forder.uuid}'/>')" class="<c:if test='${forder.uuid eq forderuuid}'>on</c:if>">
			<c:out value='${forder.name}'/>
			<span></span>
		</a>
	</li>
	</c:forEach>
	
</ul>
