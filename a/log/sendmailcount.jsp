<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  	import="com.skymiracle.wpx.oplog.service.*"%>
  	<%@include file="../../do/portal/include.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%	
	MailLogStasticsService ms = new MailLogStasticsService();
	String[] tables = ms.getMailLogTableName();
	//String[] mailtypeTables = ms.getMailTypeLogTableName();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/FCKEditor/fckeditor.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/calendar/calendar.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/calendar/calendar-zh.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<link href="/DNA/jsDNA/calendar/skin/theme.css" type="text/css" rel="stylesheet" />
<link href="../../style/css.css" type="text/css" rel="stylesheet">
<link href="../../style/log.css" type="text/css" rel="stylesheet">
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
<td align="left" id="title_Font1">每日发件量统计</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="userTableBlock" class="tableBlock" align="center">
</div>
</body>
<script language="javascript">
			var dataStruct = {
					senderemail: {title: "发件人邮箱"},
					 senderdomain: {title: "发件域"},
					 num: {title: "最多发信记录数"},
					count: {title: "发件数量"},
					tablename: {title: "选择要统计的日期", ftype: "Hash",optionMap: {"no": ""<%for(int i=0;i<tables.length;i++){
						String date = tables[i].substring(10);%>,"<%=tables[i]%>"  :  "<%=date%>"<%	}%>}}
			//			totime:{title: "终止时间", ftype: "DateTime",validate:VF_noEmpty}
		};
		
		var dataSourceProps = {
			listURL: "../../do/log/listsendmailcount.jsp"
		}
		
		var tablepros = {
			subjects: ["senderemail","senderdomain","count"],
			isCheckbox: true
		};
		
		var	ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
		
		var srchWinProps = {
			subjects: [ "tablename"],
			title:"每日发件量统计",
			width: 400,
			height:247,
			formURL: "../../do/log/listsendmailcount.jsp"
		}

		function main() {
			with(SkyDNA.Element.createButtonsBar(_G("toolsBlock"))) {
				ds.bindSearch(addButton("每日发件量统计"), srchWinProps);
				ds.createPageBar(_G("toolsBlock"), "pagenum","perpagecount",{countPerPage:15});
				ds.createDataTable(_G("userTableBlock"), tablepros);
				ds.remoteListData();
			}
			
		}	

	main();
</script>
</html>
