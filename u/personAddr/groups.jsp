<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<ul>
	<li>
		<a id="grp_" uuid="" hidefocus="true" href="javascript:PersonAddr.open('');" class="<c:if test='${empty groupid}'>on</c:if>">
			所有
			<span>(<c:out value='${allPersonCount}'/>)</span>
		</a>
	</li>
	
	<li>
		<a id="grp_nogroup" uuid="" hidefocus="true" href="javascript:PersonAddr.open('nogroup');" class="<c:if test='${groupid eq "nogroup"}'>on</c:if>">
			未分组
			<span>(<c:out value='${nogroupPersonCount}'/>)</span>
		</a>
	</li>
	
	<c:forEach var="grp" items="${grps}">
	<li>
		<a id="grp_<c:out value='${grp.uuid}'/>" uuid="<c:out value='${grp.uuid}'/>" count="<c:out value='${grp.count}'/>" hidefocus="true" href="javascript:PersonAddr.open('<c:out value='${grp.uuid}'/>')" class="<c:if test='${grp.uuid eq groupid}'>on</c:if>">
			<c:out value='${grp.groupName}'/>
			<span>(<c:out value='${grp.count}'/>)</span>
		</a>
	</li>
	</c:forEach>
	
</ul>



<script type="text/javascript">

</script>