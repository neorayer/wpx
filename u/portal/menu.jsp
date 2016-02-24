<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul id="pgMainMenu">
	<c:forEach var="modFunc" items="${modFuncs}">
	<li id="mi_<c:out value='${modFunc.funcId}' />" >
		<a href="javascript:Portal.open('<c:out value='${modFunc.funcId}' />')" ><c:out value='${modFunc.funcName}' /></a>
	</li>
	</c:forEach>

	<li id="miLogout">
		<a href="../portal/portal_logout.jsp.do" >退出</a>
	</li>
</ul>
<script language="javascript">
;(function($) {

Portal = {
	open: function(funcId) {
		$("#mi_" + funcId).addClass("selected");
		if (window.parent.Frameset) {
			window.parent.location.href = "../" + funcId + "/main.jsplayout.vi";
		}else {
			window.location.href = "../" + funcId + "/main.jsplayout.vi";
		}
	}
}
$(document).ready(function() {
	var funcId = 'portal';
	if (window.parent.Frameset) {
		funcId = window.parent.Frameset.funcId;
	}else {
		var mod = location.pathname;
		var idx = mod.lastIndexOf('/');
		mod = mod.substring(0, idx);
		var idx = mod.lastIndexOf('/');
		funcId = mod.substring(idx + 1);
	}
	$("#mi_" + funcId).addClass("selected");

});

})(jQuery);
</script>
