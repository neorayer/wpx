<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/left.css" type="text/css" rel="stylesheet" />
<link href="../_css/ipcontrol.css" type="text/css" rel="stylesheet" />
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/ipcontrol.png', sizingMethod='crop');
}
</style>
<![endif]-->
<title></title>
</head>
<body>
<div></div>
<div id="mainDiv"></div>
</body>
<script type="text/javascript">
/*
var propsButton1 = [
	{title:"访问IP白名单",name:"allowIpList"},
	{title:"访问IP黑名单",name:"rejectIpList"}
];
*/
var propsButton2 = [
	{title:"管理端IP白名单",name:"adminWhiteIp"},
	{title:"管理端IP黑名单",name:"adminBlackIp"},
	{title:"注册端IP白名单",name:"registerWhiteIP"},
	{title:"注册端IP黑名单",name:"registerBlackIP"},
	{title:"smtp拒绝连接名单",name:"smtpRejectIP"}
];

function cr(title,propsButton){
	with(SkyDNA.Element){
		var panel = createBarPanel(_G("mainDiv"), title, {});
		var bBar = createButtonsBar(panel.body, {isMutex: true});
		//var btnsBar = createButtonsBar(_G("mainDiv"),{isMutex:true});
		with(bBar){
			width = "100%";
			propsButton.each(function(pb){
				addButton(pb.title,function(){openFrame(pb.name, pb.title)},{newRow:true});
			});
		}
		bBar.buttons[0].setDown(true);
		bBar.buttons[0].onclick();
	}
}

function openFrame(name, title){
	window.parent.frames['contentFrame'].location =  name + ".html?t=" + title;

}

//cr("访问IP",propsButton1);
cr("管理端IP",propsButton2);
</script>
</html>