<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../do/portal/include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<link href="../../style/css.css" type="text/css" rel="stylesheet" />
<link href="../../style/domain.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1">子邮局管理</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock" class="toolsBlock">
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
	dc: {title: "域名", isKey: true,validate: this.VF_isDomain},	
	sizelocate: {title: "已使用容量(M)", defaultValue: 0},
	size: {title: "总容量(M)",  defaultValue: 1000,validate: this.VF_Num},
	userlocate: {title: "已有用户",  defaultValue: 0,validate: this.VF_onlyNum},
	defaultboxsize: {title: "默认邮箱大小(M)" , defaultValue: 20,validate: this.VF_Num},
	usermax: {title: "最大用户数",  defaultValue: 100,validate: this.VF_onlyNum},
	description: {title: "说明", ftype: "StringBuffer"},
	attachmentsize: {title: "上传附件大小(M)" , defaultValue: 2,validate: this.VF_Num}
}

var dataSourceProps = {
	listURL: "../../do/domain/listDomain.jsp",
	addURL: "../../do/domain/addDomain.jsp",
	delURL: "../../do/domain/delDomain.jsp",
	modURL: "../../do/domain/modDomain.jsp",
	searchDataStruct : {
		dc: {title: "域名包含"}
	}
}

var addWinProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,
	width: 500,
	height:309,
	isForgetDataStructKey: true,
	subjects: ["dc", "size", "defaultboxsize","usermax","attachmentsize","description"]
}

var modWinProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,
	width: 500,
	height:309,
	subjects: ["size", "defaultboxsize","usermax","attachmentsize","description"]
}


var searchWinProps = {
	pos:SkyDNA.CONST.POS.CLIENT_CENTER,
	width: 400,
	height:247,
	subjects: ["dc"],
	formURL : "../../do/domain/searchDomain.jsp"
}

var ds = new SkyDNA.DataSource(dataStruct, dataSourceProps)
function main(){
	var addBtn;
	with(SkyDNA.Element.createButtonsBar(_G("toolsBlock"))) {
		modBtn = addButton("修改子邮局");
		alsBtn = addButton("别名管理",openAlias);
		refreshBtn = addButton("刷新", null);
	}
	var dataTableProps = {
		isCheckbox: true,
		subjects: ["dc", "sizelocate","size", "defaultboxsize" ,"attachmentsize" , "userlocate", "usermax","description"]
	}
	
	ds.createDataTable(_G("domainTableBlock"), dataTableProps);
			ds.bindRefresh(refreshBtn);
			ds.bindMod(modBtn,modWinProps);
			ds.remoteListData();
			
}

/////////////////////////////////////Alias
function openAlias() {
	
	var data = ds.getActiveData();
	var domain = data.dc;
	var win = SkyDNA.Element.createPopupWin({title: domain + " 子邮局别名管理",width: 400,height:247});
	
	var dataStruct = {
		'dc': {title: '别名'}
	}
	
	var dsProps = {
		listURL: "../../do/domain/aliasList.jsp?dc=" + data.dc
	}
	
	var aliasDs = new SkyDNA.DataSource(dataStruct, dsProps);
	aliasDs.createDataTable(win.contentDom, {subjects: ["dc"], isCheckbox: true});
		with(SkyDNA.Element.createButtonsBar(win.contentDom)){
			delaliasBtn = addButton("删除别名");
		}
		delaliasBtn.onclick= delAlias.bind(this);
	_CC("hr", null, win.contentDom);
	aliasDs.remoteListData();


	var formProps = {
		formURL: "../../do/domain/aliasDomainAdd.jsp?domaindc=" + data.dc,
		onSubmitSucc: function() {aliasDs.remoteListData();}
	};
	with(SkyDNA.Element.createForm(win.contentDom,  formProps)) {
		addInputText("dc", "新别名", {validate: VF_isDomain});
		addSubmit();
		
		
	}
	
	function delAlias(){
		var aliasdata = aliasDs.getActiveData();
		var url = "../../do/domain/delDomainAlias.jsp?dc=" + aliasdata.dc;
		SkyDNA.Ajax.doRequest(url);
		aliasDs.remoteListData();
	}
}


main();
</script>
</html>