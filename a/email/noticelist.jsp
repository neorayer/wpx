<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//@include file="../../do/portal/checkSuper.jsp"%>

<html >
<head >
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
function cr(){
	var dataStruct = {
		subject: {title: "主题"},	
		type: {title: "类型"},
		content: {title: "内容"},
		time: {title: "时间"},
		status: {title: "状态"},
	}
	
	var dataSourceProps = {
	}
	
	
	var srchWinProps = {
		//formURL: "",
		subjects: ["subject"]
	}
	
	var dataTableProps = {
		isCheckbox : true,
		subjects: ["subject", "type", "content", "time", "status"]
	}
	var butBar = SkyDNA.Element.createButtonsBar(_G("mainDiv"));
	var searchbtn = butBar.addButton("search");
	var delbtn = butBar.addButton("del");
	var showbtn = butBar.addButton("show");
	var pausebtn = butBar.addButton("pause");
	var dataSource = new SkyDNA.DataSource(dataStruct, dataSourceProps);
	dataSource.createPageBar(_G("mainDiv"), "pp", "cp", {countPerPage: 5});
	dataSource.createDataTable(_G("mainDiv"), dataTableProps);
	dataSource.bindSearch(searchbtn, srchWinProps);
	dataSource.bindDel(delbtn);
}

cr();
</script>
</html>