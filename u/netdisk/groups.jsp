<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<li>
		<a id="grp_/" uuid="/" hidefocus="true" href="javascript:NetDisk.open('/');" class="<c:if test='${empty groupid}'>on</c:if>">
			根目录
		</a>
	</li>
	
	<c:forEach var="grp" items="${grps}">
	<li>
		<a title="<c:out value='${grp.name}'/>" uuid="<c:out value='${grp.uuid }'/>" id="grp_<c:out value='${grp.uuid}'/>" hidefocus="true" href="javascript:NetDisk.open('<c:out value='${grp.uuid}'/>')" class="<c:if test='${grp.uuid eq groupid}'>on</c:if>">
			<c:out value='${grp.name}'/>
			<span></span>
		</a>
	</li>
	</c:forEach>
	
</ul>


<script type="text/javascript">

</script>