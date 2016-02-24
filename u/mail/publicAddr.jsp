<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<ul id="mail-public-addr-tree" class="tree">
	<li id="grp_">
		<a class="tree-handler tree-handler-close" href="javascript:MailPublicAddr.toggleFolder('grp_','')"></a>
		<a class="grp" href="javascript:MailPublicAddr.toggleFolder('grp_','')">未分组(<c:out value='${public_ngCount}'/>)</a>
		<a class="grpall" href="javascript:MailPublicAddr.toMailsAll('');">全选</a>
		
		<ul class="subPsns" style="display:block; padding-left:18px;" >
		</ul>
		<ul class="subGrps">
		</ul>
	</li>
	<c:forEach var="grp" items="${public_grps}" >
	<li id="grp_<c:out value='${grp.ou}' />">
		<a class="tree-handler tree-handler-close" href="javascript:MailPublicAddr.toggleFolder('grp_<c:out value='${grp.ou}' />','<c:out value='${grp.ou}' />')"></a>
		<a class="grp" title="<c:out value="${grp.description}"/>" href="javascript:javascript:MailPublicAddr.toggleFolder('grp_<c:out value='${grp.ou}' />','<c:out value='${grp.ou}' />')">
			<c:choose>
				<c:when test="${fn:length(grp.description) > 10}">
					<c:out value="${fn:substring(grp.description,0,10)}...(${grp.count })"/>
				</c:when>
				<c:otherwise>
					<c:out value="${grp.description}(${grp.count })"/>
				</c:otherwise>
			</c:choose>
		</a>
		<a class="grpall" href="javascript:MailPublicAddr.toMailsAll('<c:out value='${grp.ou }'/>');">全选</a>
		
		<ul class="subPsns" style="display:block; padding-left:18px;" >
		</ul>
		<ul class="subGrps">
		</ul>
	</li>
	</c:forEach>
</ul>
