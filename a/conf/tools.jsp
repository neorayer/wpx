<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/left.css" type="text/css" rel="stylesheet" />
<link href="../_css/domain.css" type="text/css" rel="stylesheet" />
<title></title>
</head>
<body>
<div id="maindiv"></div>
</body>
<script type="text/javascript">
var propsButton = [
	{title:"服务管理", name:"service"},
	{title:"模块开关", name:"modfunc"},
	{title:"SMTP集群", name:"smtpCluster_add"},
	{title:"系统参数设置", name:"confSerivce"}
	//,{title:"系统监控", name:"monitoring"}
];

function cr(){
	with(SkyDNA.Element){
		var panel = createBarPanel(_G("mainDiv"), "全局管理", {});
		var bBar = createButtonsBar(panel.body, {isMutex: true});
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
	window.parent.frames["contentFrame"].location = name + ".html"; 
}

cr();
</script>
</html>