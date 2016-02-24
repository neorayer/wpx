<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/left.css" type="text/css" rel="stylesheet" />
<link href="../_css/admin.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="mainDiv1"></div>
<!-- <div id="mainDiv2">域管理员</div> -->
<div id="mainDiv3"></div>
</body>
<script type="text/javascript">
var propsButton1 = [
	{title:"超级管理员",name:"superAdmins"},
	{title:"域管理员",name:"domainAdmins"},
	{title:"多域管理员",name:"multiDomainAdmins"},
	{title:"公共地址簿管理员",name:"addressbookAdmins"}
]

var maindiv = ["帐号管理","公共地址簿管理员"];

function cr(div,propsButton,title){
	with(SkyDNA.Element){
		var panel = createBarPanel(_G(div), title, {});
		var bBar = createButtonsBar(panel.body, {isMutex: true});
		with(bBar){
			width = "100%";
			propsButton1.each(function(pb){
				addButton(pb.title,function(){openFrame(pb.name)},{newRow:true});
			});
		}
		bBar.buttons[0].setDown(true);
		bBar.buttons[0].onclick();
	}
}

function openFrame(name){
	window.parent.frames["adminFrame"].location =  name + ".html";
}

cr("mainDiv1",propsButton1,maindiv[0]);
</script>
</html>