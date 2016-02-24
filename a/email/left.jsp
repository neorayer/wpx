<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/left.css" type="text/css" rel="stylesheet" />
<link href="../_css/email.css" type="text/css" rel="stylesheet" />
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/email.png', sizingMethod='crop');
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
var propsButton = [
	{title:"邮件群发",name:"batch"},
	{title:"群发组管理",name:"batchgroup"}
	//{title:"生日邮件",name:"birthdaymail"},
	//{title:"系统公告",name:"notice"},
	//, {title:"新闻管理",name:"news"}
	//{title:"POP3通知管理",name:"pop3Notify"},
]

function cr(){
	with(SkyDNA.Element){
		var panel = createBarPanel(_G("mainDiv"), "邮件群发", {});
		var bBar = createButtonsBar(panel.body, {isMutex: true});
		//var btnsBar = createButtonsBar(_G("mainDiv"),{isMutex:true});
		with(bBar){
			width = "100%";
			propsButton.each(function(pb){
				addButton(pb.title,function(){openFrame(pb.name)},{newRow:true});
			});
		}
		bBar.buttons[0].setDown(true);
		bBar.buttons[0].onclick();
	}
}

function openFrame(name){
	window.parent.frames['contentFrame'].location =  name + ".html";
}

cr();
</script>
</html>