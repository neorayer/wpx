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
	{title:"子邮局列表", url:"domains.html"},
	{title:"系统风格", url:"style.html?type=domain"},
	{title:"域名导入", url:"importDomains.html"},
	{title:"部门导入", url:"importDepts.html"},
	{title:"用户导入", url:"importUsers.html"},
	{title:"私人通讯录组导入", url:"importGrpAddrbooks.html"},
	{title:"私人通讯录成员导入", url:"importPsnAddrbooks.html"},
	{title:"用户别名导入", url:"importUserAlias.html"},
	{title:"书签组导入", url:"importBmForders.html"},
	{title:"书签导入", url:"importBmItems.html"},
	{title:"数据整理", url:"resetData.html"},
	{title:"8.5版U盘书签导入", url:"importBmsAndNds.html"}
];

function cr(){
	with(SkyDNA.Element){
		var panel = createBarPanel(_G("mainDiv"), "子邮局管理", {});
		var bBar = createButtonsBar(panel.body, {isMutex: true});
		//var btnsBar = createButtonsBar(_G("mainDiv"), {isMutex: true});
		with(bBar){
			width = "100%";
			propsButton.each(function(pb){
				addButton(pb.title, function() {openFrame(pb.url)}, {newRow:true});
			});
		}
		bBar.buttons[0].setDown(true);
		bBar.buttons[0].onclick();
	}
}

function openFrame(url){
	window.parent.frames["contentFrame"].location = url ; 
}

cr();
</script>
</html>