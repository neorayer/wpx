<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%//@include file="../../do/portal/checkSuper.jsp"%>
<%
	//String name = request.getParameter("name");
	//name = name == null ? "" : name;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="mainDiv"></div>
</body>
<script type="text/javascript">
function crHP(){
	var dataStruct = {
		fdomain: {title: "访问域名"},	
		isdomain: {title: "所属域"},
		status: {title: "模板设置状态"},
		local: {title: "本地发布"}
	}
	
	var dataSourceProps = {
	}
	
	var addWinProps = {
		subjects: ["username", "domain", "status", "email"]
	}
	
	var srchWinProps = {
		//formURL: "",
		subjects: ["isdomain"]
	}
	
	var dataTableProps = {
		isCheckbox : true,
		subjects: ["fdomain", "isdomain", "status", "local"]
	}
	var butBar = SkyDNA.Element.createButtonsBar(_G("mainDiv"));
	var searchbtn = butBar.addButton("search");
	var addbtn = butBar.addButton("add");
	var delbtn = butBar.addButton("del");
	var dataSource = new SkyDNA.DataSource(dataStruct, dataSourceProps);
	dataSource.createPageBar(_G("mainDiv"), "pp", "cp", {countPerPage: 5});
	dataSource.createDataTable(_G("mainDiv"), dataTableProps);
	dataSource.bindSearch(searchbtn, srchWinProps);
	dataSource.bindDel(delbtn);
}

crHP();
</script>
</html>
