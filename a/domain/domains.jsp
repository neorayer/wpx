<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<script type="text/javascript" src="../js/wpx_tool.js"></script>
<link href="../_css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/domain.css" type="text/css" rel="stylesheet" />
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/domain.png', sizingMethod='crop');
}
</style>
<![endif]-->
</head>
<body>
<script type="text/javascript">
__DEBUG_CLOSED = true;
</script>
<div id="pgHeadBlock" class="pgHeadBlock" >
	<table border=0 width="100%" height="100%" cellspacing="0"><tr>
	<td algin="left" width="41" class="title_BarImg"></td>
	<td align="left" id="title_Font1">子邮局管理&nbsp;&nbsp;
	<font style="font-weight: normal"><c:out value="licence限制:${userLicenseCount}  可用licence:${leftLicenseCount}" /></font>
	</td>
	
	<td align="right" id="title_Font2"></td>
	</tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="domainTableBlock" class="tableBlock"></div>
</body>
<script type="text/javascript">
function VF_isDomain(v) {
	if (!v || v.trim() == '')
		return DICT.__NO_EMPTY;
	if (v.trim() != ""){
		ptn = /^[\.0-9a-zA-Z-_]+\.+[a-zA-Z]{2,3}$/;
		flg = ptn.test(v.trim());
		if (!flg){
			return DICT.__WRONG_DOMAIN;
		}
	}
	return null;
}

function VF_Num(v) {
	if (v.trim() == '')
		return DICT.__NO_EMPTY;
	if(v == 0)
		return  "不能为零";
	var ptn = /^(0|[1-9][0-9]*)(\.[0-9]+){0,1}$/;
	var flg = ptn.test(v);
	if (!flg ) return DICT.__WRONG_NUMBER;
}
function VF_DNum(v){	
	dTotalSize = v;
	if (v.trim() == '')
		return DICT.__NO_EMPTY;
	if(v == 0)
		return  "不能为零";
	var ptn = /^(0|[1-9][0-9]*)(\.[0-9]+){0,1}$/;
	var flg = ptn.test(v);
	if (!flg )
		return DICT.__WRONG_NUMBER;
	else
		return null;
}
var dTotalSize = <c:out value="${defaultboxsize}" />;

function VF_isValidateBSize(v){
	var s = VF_Num(v);
	if(s!=null)
		return s;
	if(parseInt(v) > parseInt(dTotalSize))
		return '附件< ' + dTotalSize + ' M';
	else
		return null;	
}

function VF_onlyNum(v) {
	if (v.trim() == '')
		return DICT.__NO_EMPTY;
	if(v == 0)
		return  "不能为零";
	var ptn = /^(0|[1-9][0-9]*)$/;
	var flg = ptn.test(v);
	if (!flg ) return DICT.__WRONG_NUMBER;
}

var dataStruct = {
	dc: {title: "域名", isKey: true,validate: VF_isDomain},	
	sizelocate: {title: "已使用(M)", defaultValue: 0},
	size: {title: "总容量(M)",  defaultValue: <c:out value="${domainsize}" />,validate: VF_Num},
	userlocate: {title: "用户数",  defaultValue: 0,validate: VF_onlyNum},
	defaultboxsize: {title: "默认邮箱大小(M)" , defaultValue: <c:out value="${defaultboxsize}" />,validate: VF_DNum},
	usermax: {title: "最大用户数",  defaultValue:  <c:out value="${userMax}" />,validate: VF_onlyNum},
	description: {title: "说明", ftype: "StringBuffer"},
	attachmentsize: {title: "上传附件大小(M)" , defaultValue:  <c:out value="${attachmentSize}" />,validate: VF_isValidateBSize},
	savenew:{title:"是否自动保存",defaultValue:"1", ftype: "Hash", optionMap:{"1":"自动保存","0":"不自动保存"}},
	ishidepubaddress:{title:"是否隐藏公共通迅录",defaultValue:"0", ftype: "Hash", optionMap:{"0":"隐藏","1":"显示"}},
	cityname:{title:"城市", defaultValue:"上海", ftype: "Hash", optionMap:{
		<c:forEach var="cityCode" varStatus="status" items="${cityCodes}">
			<c:out value="'${cityCode.key}' : '${cityCode.key}'" escapeXml="false"/>
			<c:if test="${!status.last}">,</c:if>
		</c:forEach>
	}}
}

var dataSourceProps = {
	listURL: "list.json",
	addURL: "add.json",
	delURL: "del.json",
	modURL: "mod.json",
	searchDataStruct : {
		dc: {title: "域名包含"}
	}
}


var dataTableProps = {
	isCheckbox: true,
	subjects: ["dc", "sizelocate","size", "defaultboxsize" ,"attachmentsize" , "userlocate", "usermax","description"]
}

var addWinProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 500,
	height:309,
	isForgetDataStructKey: true,
	subjects: ["dc", "size", "defaultboxsize","usermax","attachmentsize","description","savenew","ishidepubaddress","cityname"]
}

var modWinProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 500,
	height:309,
	subjects: ["size", "defaultboxsize","usermax","attachmentsize","description","savenew","ishidepubaddress","cityname"]
}

var searchWinProps = {
	title:"搜索",
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,	
	width: 400,
	height:247,
	subjects: ["dc"],
	formURL : "search.json"
}

var ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
function main(){
	var addBtn;
	with(SkyDNA.Element.createButtonsBar(_G("toolsBlock"))) {
		addBtn = addButton("新增子邮局", null);
		modBtn = addButton("修改子邮局");
		alsBtn = addButton("别名管理",openAlias);
		delBtn = addButton("删除子邮局",null);
		refreshBtn = addButton("刷新", null);
		//snyBtn = addButton("同步", synchronizeDB);
		searchBtn = addButton("搜索", null);
		exportBtn = addButton("导出备份文件",exportUser);
	}
	
	ds.createPageBar(_G("domainTableBlock"),"pagenum","perpagecount",{countPerPage:15});
	ds.createDataTable(_G("domainTableBlock"), dataTableProps);

	ds.bindAdd(addBtn, addWinProps);
	ds.bindRefresh(refreshBtn);
	ds.bindSearch(searchBtn, searchWinProps);
	ds.bindMod(modBtn,modWinProps);
	ds.bindDel(delBtn);
	ds.remoteListData();
}

function openAlias() {
	
	var data = ds.getActiveData();
	var domain = data.dc;
	var win = SkyDNA.Element.createPopupWin({title: domain + " 子邮局别名管理",width: 500,height:350});
	
	var dataStruct = {
		'dc': {title: '别名', isKey:true}
	}
	
	var dsProps = {
		listURL: "aliases.json?aliasedobjectname=" + data.dc,
		delURL: "aliases_del.json?aliasedobjectname=" + data.dc
	}
	
	var aliasDs = new SkyDNA.DataSource(dataStruct, dsProps);
	aliasDs.createDataTable(win.contentDom, {subjects: ["dc"], isCheckbox: true});
	with(SkyDNA.Element.createButtonsBar(win.contentDom)){
		aliasDs.bindDel(addButton("删除别名"));
	}
	_CC("hr", null, win.contentDom);
	aliasDs.remoteListData();


	var formProps = {
		formURL: "alias_add.json?aliasedobjectname=" + data.dc,
		onSubmitSucc: function() {aliasDs.remoteListData();}
	};
	with(SkyDNA.Element.createForm(win.contentDom,  formProps)) {
		addInputText("dc", "新别名", {validate: VF_isDomain});
		addSubmit();
	}
	
}

function synchronizeDB(){
	var data = ds.getActiveData();
	var domain = data.dc;
	var url = "../domain/sychnorizedb.jsp?dc="+domain;
	
	var x = SkyDNA.Ajax.doRequest(url);
	if(x==1)
		alert("数据同步完成!");
}

/////////////////////////////////////exportUser
function exportUser() {
	var data = ds.getActiveData();
	var domain = data.dc;
	document.location.href = "domainsCSV.down?dc=" + domain;
}
main();
</script>
</html>