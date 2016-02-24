<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<script type="text/javascript" src="/DNA/jsDNA/calendar/calendar.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/calendar/calendar-zh.js"></script>
<link href="/DNA/jsDNA/calendar/skin/theme.css" type="text/css" rel="stylesheet" />

<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/log.css" type="text/css" rel="stylesheet">
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
<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1">登录日志</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="userTableBlock" class="tableBlock" align="center">
</div>
</body>
<script language="javascript">
	var date = new Date();
	//var beginTime = date.print("%Y/%m/%d 00:00:00");
	//var endTime = date.print("%Y/%m/%d %H:%M:%S");

		
	var dataStruct = {
		time: {title: "时间"},
		mail: {title: "帐号"},
		stattype: {title: "统计类型",ftype: "Hash",defaultValue: 'day',optionMap: {'month':'月统计','day':'日统计','hour': '小时统计'}},
		count: {title: "数量(封)"},
		
		ct:{title:"数量查询",defaultValue:"", ftype: "Hash",optionMap:{"":"", ">":"大于","=":"等于","<":"小于"}},
		cv:{title:"数量",defaultValue:""},
		
		fromtime: {title: "起始时间", defaultValue: "", ftype: "DateTime"},
		totime:{title: "终止时间", defaultValue: "", ftype: "DateTime"}
	};
	
	var dataSourceProps = {
		listURL: "../stat/sendMailList.json"
	}
	
	var tablepros = {
		subjects: ["time","mail","stattype","count"],
		isCheckbox: true
	};
	
	
	var srchWinProps = {
		subjects: ["mail", "stattype","ct", "cv", "fromtime", "totime"],
		title:"统计查询",
		width: 400,
		height:247,
		formURL: "../stat/sendMailList.json"
	}
	
	function monthStat() {
		dataStat('month');
	}
	function dayStat() {
		dataStat('day');
	}
	function hourStat() {
		dataStat('hour');
	}
	
	function dataStat(statType) {
		if(!confirm('您确定要重新统计吗？'))
			return;
		var waitingDom = SkyDNA.Element.showWaiting();
		new Ajax.Request("../stat/sendMailStat.json?stattype=" + statType, {
			onComplete: function(req) {
				_R(waitingDom);
				var v = richEval(req.responseText);
				if(v.res != 1){
					alert('请求失败！');
					return;
				}
				alert('数据统计结束');
			}
		});
	}
	

	function main() {
		var ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
		with(SkyDNA.Element.createButtonsBar(_G("toolsBlock"))) {
			ds.bindSearch(addButton("统计查询"), srchWinProps);
			addButton("月数据重新统计", monthStat);
			addButton("日数据重新统计", dayStat);
			addButton("小时数据重新统计", hourStat);
			
			ds.createPageBar(_G("toolsBlock"), "pagenum","perpagecount",{countPerPage:15});
			ds.createDataTable(_G("userTableBlock"), tablepros);
			ds.remoteListData();
		}
	}

	main();
</script>
</html>
