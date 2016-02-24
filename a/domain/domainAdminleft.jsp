<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
<%@include file="../../do/portal/include.jsp"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<link href="../../style/left.css" type="text/css" rel="stylesheet" />
<link href="../../style/domain.css" type="text/css" rel="stylesheet" />
<title></title>
</head>
<body>
<div id="maindiv"></div>
</body>
<script type="text/javascript">
var propsButton = [
	{title:"子邮局列表", name:"domainlistDomain"},
	{title:"数据导入", name:"import"}
]

function cr(){
	with(SkyDNA.Element){
		var panel = createBarPanel(_G("mainDiv"), "子邮局管理", {});
		var bBar = createButtonsBar(panel.body, {isMutex: true});
		//var btnsBar = createButtonsBar(_G("mainDiv"), {isMutex: true});
		with(bBar){
			width = "100%";
			propsButton.each(function(pb){
				addButton(pb.title, function() {openFrame(pb.name)}, {newRow:true});
			});
		}
		bBar.buttons[0].setDown(true);
		bBar.buttons[0].onclick();
	}
}

function openFrame(name){
	window.parent.frames["contentFrame"].location = name + ".jsp"; 
}

cr();
</script>
</html>