<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="com.skymiracle.wpx.user.*"
	import="com.skymiracle.mdo4.*"
	import="java.text.SimpleDateFormat"
	import="java.util.*"
	%>
<%@include file="../../do/portal/include.jsp"%>

<%
	String dc = request.getParameter("dc");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String today = sdf.format(Calendar.getInstance().getTime());
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

<link href="FCKEditor/sample.css" rel="stylesheet" type="text/css" />
				

<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<link href="../../style/css.css" type="text/css" rel="stylesheet">
<link href="../../style/email.css" type="text/css" rel="stylesheet">
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
<style type="text/css">
#btn {
	margin-left: 360px;
}
</style>
</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1">系统公告</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="userTableBlock" class="tableBlock" align="center">
</div>
</body>
<script language="javascript">

var dataStruct = {
	uuid: {title: "UUID", isKey: true},
	subject: {title: "主题",validate: VF_noEmpty},
	type: {title: "类型",ftype: "Hash",optionMap: {'TEXT' : '普通文本','URL' : '网络链接'}},
	content: {title: "邮件内容",ftype: "StringBuffer"},
	date: {title: "发送时间",defaultValue: "<%=today%>",validate: VF_noEmpty},
	state: {title: "状态",ftype: 'Hash',optionMap: {"1" : "显示","-1": "不显示"}}
}

	var sendSysNoticeWin = {
		width: 500,
		height:309,
		subjects: ["subject", "type","content","date",'state'],
		isForgetDataStructKey: true
	}


	var modSysNoticeWin = {
		width: 500,
		height:309,
		subjects: ["subject","type","content","date",'state']
	}
	
	var searchWinProps = {
		title:"搜索",
		subjects: ["subject"],
		width: 400,
		height:247,
		formURL : "../../do/notice/listnotice.jsp",
		isForgetDataStructKey: true,
		formURL: "../../do/notice/searchnotice.jsp"
	}


	var tablepros = {
		subjects: ["subject","type","content","date","state"],
		isCheckbox: true
	}
	
	var dataSourceProps = {
		listURL: "../../do/notice/listnotice.jsp",
		addURL: "../../do/notice/addnotice.jsp",
		modURL: "../../do/notice/modnotice.jsp",
		delURL: "../../do/notice/delnotice.jsp"
	}
	
	
	var ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);
	function main(){
	var btnsBar = SkyDNA.Element.createButtonsBar(_G("toolsBlock"));
	var sysnotBtn = btnsBar.addButton("发送系统公告",opSysNot.bind(this,"add"));
	var displyBtn = btnsBar.addButton("显示系统公告",displyNotice);
	var pauseBtn = btnsBar.addButton("暂停系统公告",pauseNotice);
	var modBtn = btnsBar.addButton("修改系统公告",opSysNot.bind(this,"mod"));
	var searchBtn = btnsBar.addButton("系统公告搜索");
	var delBtn = btnsBar.addButton("删除系统公告");
	var rfBtn = btnsBar.addButton("刷新");
	//var birthBtn = btnsBar.addButton("发送生日邮件",sendBirthMail);
	//ds.bindAdd(sysnotBtn,sendSysNoticeWin);
	ds.createDataTable(_G("userTableBlock"), tablepros);
	ds.createPageBar(_G("toolsBlock"),"pagenum","perpagecount",{countPerPage:2});
	ds.bindRefresh(rfBtn);
	//ds.bindMod(modBtn,modSysNoticeWin);
	ds.bindDel(delBtn);
	ds.bindSearch(searchBtn,searchWinProps);
	
	ds.remoteListData();
	}
	
	function displyNotice(){
		modNoticeStatus("disply");
	}
	
	function pauseNotice(){
		modNoticeStatus("pause");
	}
	
	function modNoticeStatus(status){
		state = status=="disply" ? 1: -1;
		
		var selDatas = ds.getSelectedDatas();
		var uuid="";
		selDatas.each(function(data){
			uuid += "&uuid=" + data.uuid; 
		});
		var url = "../../do/notice/modnoticestatus.jsp?state=" + state  + uuid;
		SkyDNA.Ajax.doRequest(url);
		ds.remoteListData();
	}

function opSysNot(op) {
	var titleName;
	var timeName;
	var sendName;
	if(op == "mod"){titleName = "修改系统公告";timeName="修改时间";sendName="修改";}
	if(op == "add"){titleName = "发送系统公告";timeName="发送时间";sendName="发送";}
	var win = SkyDNA.Element.createPopupWin({title: titleName,width: "600",height: "320",pos:SkyDNA.CONST.POS.CLIENT_CENTER});
	var ctr = _CC("div", {id:"dvHtmlEditor"}, win.contentDom);
	ctr.style.height=430;
	var form = SkyDNA.Element.createForm(ctr);
	if(op == "add"){
		with(form){
			addInputText("subject","主题",{id:"subject"});
			addSelect("type","类型",{id:"type",optionMap: {'TEXT' : '普通文本','URL' : '网络链接'},value:"TEXT"});
			addSelect("state","状态",{id:"state",optionMap: {"1" : "显示","-1": "不显示"},value:"1"});
			addInputText("date","发送时间",{id:"date",value:"<%=today %>",readonly:"true"});
			addInputHidden("content",{id:"content"});
		}
	}
	var selDatas = ds.getSelectedDatas();
	var uuid="";
	selDatas.each(function(data){
		uuid += "&uuid=" + data.uuid; 
	});
	var url = "../../do/notice/listnotice.jsp?"+ uuid;
	var datas = SkyDNA.Ajax.doRequestJSON(url);
	var data = datas.data;
	if(op == "mod"){
		with(form){
			addInputText("subject","主题",{id:"subject",value:data[0].subject});
			addSelect("type","类型",{id:"type",optionMap: {'TEXT' : '普通文本','URL' : '网络链接'},value:data[0].type});
			addSelect("state","状态",{id:"state",optionMap: {"1" : "显示","-1": "不显示"},value:data[0].state});
			addInputText("date",timeName,{id:"date",value:"<%=today %>",readonly:"true"});
			addInputHidden("content",{id:"content"});
		}
	}
	var ctr1 = _CC("div", {id:"dvHtmlEditor1"}, ctr);
	var  oFCKeditor = new FCKeditor( 'FCKeditor1' ) ;
	oFCKeditor.BasePath	= "/DNA/jsDNA/FCKEditor/" ;
	oFCKeditor.Config['CustomConfigurationsPath'] = '../editor.config.js' ;
	oFCKeditor.ToolbarSet = 'MyToolbar' ;
	oFCKeditor.Height	= 300 ;
	oFCKeditor.Config["AutoDetectLanguage"] = true ;
	oFCKeditor.Config["DefaultLanguage"]    = "zh-cn" ;
	if(op == "add") oFCKeditor.Value = "";
	if(op == "mod") oFCKeditor.Value = data[0].content;
	ctr1.innerHTML = oFCKeditor.CreateHtml();

	var ctr2 = _CC("div", {}, win.contentDom);
	var btnbar = SkyDNA.Element.createButtonsBar(ctr2);
	btnbar.addButton(sendName,send.bind(this,win,op,selDatas[0].uuid),{id:"btn"});
	btnbar.addButton("取消",function(){win.dispose();});
}
	
function send(win,op,uuid){
	//alert(uuid);
	var content = _G("content");
	var editor = FCKeditorAPI.GetInstance( 'FCKeditor1' );
	content.value= editor.GetXHTML();
	var data1 = {
	 	content: _G("content").value,
		subject: _G("subject").value,
		type: _G("type").value,
  		state: _G("state").value,
  		date: _G("date").value
  	}
  	var data2 = {
	 	uuid:uuid,
	 	content: _G("content").value,
		subject: _G("subject").value,
		type: _G("type").value,
  		state: _G("state").value,
  		date: _G("date").value
  	}
  	var url = "";
  	if(op == "add") url = SkyDNA.Utils.getSubmitURL("../../do/notice/addnotice.jsp",data1);
  	if(op == "mod") url = SkyDNA.Utils.getSubmitURL("../../do/notice/modnotice.jsp",data2);
	var str = SkyDNA.Ajax.doRequestJSON(url);
	win.dispose();
	ds.remoteListData();
}

function modSysNot() {
	
}

main();
</script>

						
<script type="text/javascript">
							
								 
										
</script>
</html>