<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../do/portal/include.jsp"%>
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
<div id="searchDiv"></div>
<div id="mainDiv"></div>
</body>
<script type="text/javascript">
function crSC(){
	var dataStruct = {
		domain: {title: "域名"},	
		description: {title: "说明"},
		sizeLocate: {title: "已使用容量"},
		size: {title: "总容量"},
		userLocate: {title: "已有用户"},
		userMax: {title: "最大用户数"},
		domain1: {title: "用户备份"}
	}
	
	var dataSourceProps = {
	}
	
	var srchWinProps = {
		//formURL: "",
		subjects: ["domain"]
	}
	
	var dataTableProps = {
		isCheckbox : true,
		subjects: ["domain", "description", "sizeLocate", "size", "userLocate", "userMax", "domain1"]
	}
	var btn = SkyDNA.Element.createButton(SkyDNA.Element.createGrid(_G("mainDiv")).addCell(), "search");
	var dataSource = new SkyDNA.DataSource(dataStruct, dataSourceProps);
	dataSource.createPageBar(_G("mainDiv"), "pp", "cp", {countPerPage: 5});
	dataSource.createDataTable(_G("mainDiv"), dataTableProps);
	dataSource.bindSearch(btn, srchWinProps);
}

crSC();
</script>
</html>