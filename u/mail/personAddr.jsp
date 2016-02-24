<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<ul class="tree">
	<li id="grp_">
		<a class="tree-handler tree-handler-close" href="javascript:MailPersonAddr.toggleFolder('grp_')"></a>
		<a class="grp" href="javascript:MailPersonAddr.toggleFolder('grp_')">未分组(<c:out value='${person_ngCount}'/>)</a>
		<a class="grpall" href="javascript:MailPersonAddr.toMailsAll('');">全选</a>
		
		<ul class="subPsns" style="display:block; padding-left:18px;" >
		</ul>
	</li>
	
	<c:forEach var="grp" items="${person_grps}">
	<li id="grp_<c:out value='${grp.uuid }'/>">
		<a class="tree-handler tree-handler-close" href="javascript:MailPersonAddr.toggleFolder('grp_<c:out value='${grp.uuid }'/>')"></a>
		<a class="grp" href="javascript:MailPersonAddr.toggleFolder('grp_<c:out value='${grp.uuid }'/>')"><c:out value='${grp.groupName }(${grp.count })'/></a>
		<a class="grpall" href="javascript:MailPersonAddr.toMailsAll('<c:out value='${grp.uuid }'/>');">全选</a>
		
		<ul class="subPsns" style="display:block; padding-left:18px;" >
		</ul>
	</li>
	</c:forEach>
	
</ul>