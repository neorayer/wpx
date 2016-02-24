<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="com.skymiracle.json.*"%>
<%@include file="../../do/portal/include.jsp"%>

<%
	String dc = (String)session.getAttribute("opdc");
%>
<html>
<head>
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
</head>
<body>
</body>
<script language="javascript">
function main() {
	var dc = "<%=dc%>";
	with(SkyDNA.Element) {
		var treeView = createTreeView(document.body, {title: "子邮局"});
			var domainNode = treeView.addNode(dc, {onSelected: openDomain});
			// domainNode.addNode("公共地址簿", {onSelected: openAB, isLeaf: true});
	}
}
	

function openAB(node) {
	window.parent.frames['contentFrame'].location = "../../vi/addressbook/domainAddressbook.jsp?dc=" + "<%=dc%>";
}

function openDomain(node) {
	window.parent.frames['contentFrame'].location ="../../vi/user/domainDept.jsp?dc="+ "<%=dc%>";
}

main();
</script>
</html>