<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/left.css" type="text/css" rel="stylesheet" />
<link href="../_css/log.css" type="text/css" rel="stylesheet" />
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/log.png', sizingMethod='crop');
}
</style>
<![endif]-->
</head>
<body>
</body>
<script language="javascript">
function main() {
	with(SkyDNA.Element) {
		var treeView = createTreeView(document.body, {title: "日志查询"});
		//treeView.style.overflow = "scroll";
		SkyDNA.Enhance.enhance(treeView, "dockable", {dock: 'full'});
		var domainNode = treeView.addNode("管理日志", {onSelected: openSysLog});
		var domainNode = treeView.addNode("邮件日志", {onSelected: openMailLog});
		var domainNode = treeView.addNode("登录日志", {onSelected: openLoginLog});
		var domainNode = treeView.addNode("邮件发送统计", {onSelected: openLogStat});
		//var domainNode = treeView.addNode("统计每日发件量", {onSelected: openSendMailCount, isLeaf: true});
		//var domainNode = treeView.addNode("统计每日外发邮件类型", {onSelected: openmailtypecount, isLeaf: true});
	}
}

// 管理日志	
function openSysLog() {
	window.parent.frames['contentFrame'].location = "../log/sysLog.html";
}

// 管理日志	
function openMailLog() {
	window.parent.frames['contentFrame'].location = "../log/mailLog.html";
}

// 登录日志
function openLoginLog() {
	window.parent.frames['contentFrame'].location = "../log/loginlog.html";
}

function openLogStat() {
	window.parent.frames['contentFrame'].location = "../log/sendMailStat.html";
}

function openSendMailCount() {
	window.parent.frames['contentFrame'].location = "../../vi/log/sendmailcount.jsp";
}

function openmailtypecount() {
	window.parent.frames['contentFrame'].location = "../../vi/log/openmailtypecount.jsp";
}


main();
</script>
</html>