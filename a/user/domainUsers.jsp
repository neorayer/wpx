<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<script type="text/javascript" src="../js/lib_json.js"></script>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/user.css" type="text/css" rel="stylesheet">
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/user.png', sizingMethod='crop');
}
</style>
<![endif]-->
<style type="text/css">
	div.posSortLstCls{
		table-layout:fixed;
		width:100%;
		height:280px;
		overflow:auto;
		padding:0;
		margin:0;
		background-color:#f1f1f1;
	}
	div.posSortLstCls ol{
		margin:0;
		
	}
	div.posSortLstCls ol li{
		margin:0;
		padding:0;
	}
	table.posSortTableCls{
		background-color:#e1e1e1;		
	}
	table.posSortTableCls tr{
		background-color:#eaeaea;		
	}
	table.posSortTableCls td{
		text-align:center;
		overflow:hidden;		
	}	
	table.posSortTableCls td.tno{
		width:38px;
		background-color:#f0f1f1;
	}
	table.posSortTableCls td.tuid{
		width:150px;
		
	}
	table.posSortTableCls td.tname{
		width:150px;
		background-color:#f8f1f1;
	}
	table.posSortTableCls td.cuid{
		width:150px;
	}
	table.posSortTableCls td.cname{
		width:150px;
		background-color:#f8f1f1;
	}

	#deptDataTree	ul{
		padding:0;
		margin-left:15px;
	}
	#deptDataTree	li{
		list-style:none;
		margin-top:1px;
		margin-bottom:1px;
	}
	#deptDataTree	li ul{
		display:none;
	}
	#deptDataTree span{
		background-color:#eeeeee;
		color:#666666;
		cursor:pointer;
	}
	#deptDataTree span.on{
		background-color:#0022ff;
		color:#fff;			
	}
	#deptDataTree span.t{
		padding:0 3px;
	}		
	#deptDataTree span.closed{
		background: url(icon/folder_closed.gif) 0 0 no-repeat;
		font-size:12px;
		padding:2px 6px 1px 6px;
		margin:3px 0;
		color:#fff;			
	}
	#deptDataTree span.opened{
		background: url(icon/folder_opened.gif) 0 0 no-repeat;
		font-size:12px;
		margin: 3px 0;
		padding:2px 6px 1px 6px;
		color:#fff;			
	}

</style>
</head>
<body>

<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1"><c:out value='${dc}'/>用户管理</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
<div id="toolsBlock">
</div>
<div id="userTableBlock" class="tableBlock" align="center">
</div>


</body>
<script language="javascript">
var isWritable = <c:out value='${!ACTOR.isAddressBookRole}' default="false"/>;
var curDc = "<c:out value='${dc}'/>";
var curDepou = "<c:out value='${depou}'/>";

var depDesc = [];
<c:forEach var="dept" items="${deplist}">
	<c:out value='depDesc["${dept.ou}"] = "${dept.description}";' escapeXml="false"/>
</c:forEach>

function VF_onlyNum(v) {
	if (v.trim() == '')
		return DICT.__NO_EMPTY;
	if(v == 0)
		return  "不能为零";
	var ptn = /^(0|[1-9][0-9]*)$/;
	var flg = ptn.test(v);
	if (!flg ) return DICT.__WRONG_NUMBER;
}
	
function VF_storage(v){
	if (v.trim() == 'local')
		return null;
	var index = v.trim().indexOf(":");
	var ip = v.substring(0,index);
	if (v.trim() == '')
		return DICT.__NO_EMPTY;
	var ptn = /^([1-9]\d?|1\d{2}|2[0-4]\d|25[0-5])\.([0-9]\d?|1\d{2}|2[0-4]\d|25[0-5])\.([0-9]\d?|1\d{2}|2[0-4]\d|25[0-5])\.([0-9]\d?|1\d{2}|2[0-4]\d|25[0-5])$/;
	var flg = ptn.test(ip);
	if (!flg)
		return DICT.__IP_ERR_FORMAT;
	if(ip == "255.255.255.255")
		return "无效IP";
	var port = v.substring(index+1);
	var ptn = /^(0|[1-9][0-9]*)$/;
	var flg = ptn.test(port);
	if (!flg ) return "无效端口";
}

function VF_safetyStr(v){
	if(v=='hr')return;
	if(v.length<=3)
		return "用户名长度必须大于3";
	var s = VF_SafeStr_MY(v);
	if(s!=null)
		return s;
}

function VF_SafeStr_MY(v){
	ptn = /^[A-Za-z]+[0-9A-Za-z_.]+[A-Za-z0-9]$/;
	var flg = ptn.test(v);
	if (!flg ) return "由数字、字母或下划线组成,以字母开头";
	return null;
}
	
function VF_maxSenderNum(v){
	if(v>300)
		return "最大发送人数不能超过300";
	var s = VF_onlyNum(v);
	if(s!=null)
		return s;	
}

var domain_attsize = <c:out value='${attsize}'/>;
function VF_attMentSize(v){
	var s =VF_onlyNum(v);
	if(s!=null)
		return s;
	if(v <= domain_attsize)
		return "信件大小要大于附件大小( > " + domain_attsize + "M)";
}


var dataStruct = {
	dc: {title: "域名", defaultValue: curDc},
	uid: {title: "帐号" , isKey: true, validate: VF_safetyStr},
	userpassword: {title: "新密码",ftype: "Password",validate: VF_passwd},
	repeat: {title: "密码确认",ftype: "Password",validate: VF_passwd},
	ispop3: {title: "pop3", ftype: "Hash", optionMap: {"1": "开通", "0": "关闭"}},
	issmtp: {title: "smtp", ftype: "Hash", optionMap: {"1": "开通", "0": "关闭"}},
	isproxy: {title: "代理", ftype: "Hash", optionMap: {"0": "关闭","1": "开通"}},
	maxcc: {title: "最大发送人数", defaultValue:"<c:out value='${defaultusermaxcc}'/>", validate: VF_maxSenderNum},
	size: {title: "邮箱空间(M)", defaultValue: "<c:out value='${userstoragesize}'/>",validate: this.VF_onlyNum},
	messagesize: {title: "最大邮件大小(M)", defaultValue: "<c:out value='${messagesize}'/>", validate: VF_attMentSize},
	storagelocation :{title: "存储" , defaultValue: "<c:out value='${storageIP}'/>:<c:out value='${storagePort}'/>",validate: VF_storage},
	oudes: {title: "部门名称(点击选择部门)",defaultValue: "点击选择部门"},
	ou:{title:"部门",defaultValue:""},
	sn: {title: "姓"},
	givenname: {title: "名"},
	displayname: {title: "姓名"},
	description: {title: "类型",defaultValue: "person",ftype: "Hash",optionMap: {"person":"个人","unit":"单位"}},
	employeenumber: {title: "管理者"},
	employeeid: {title: "工(学)号"},
	status: {title: "状态", ftype: "Hash",optionMap:{'open': '开通', 'pause': '暂停','closed': '关闭'}},
	ishide: {title: "显示地址簿", ftype: "Hash",optionMap:{'0':'隐藏','1': '显示'}},
	lasttime:{title:"上次登陆时间",defaultValue:"未登陆"},
	sortnum: {title: "排名", defaultValue:"10000", validate: VF_onlyNum},
	search:{title:"条件",defaultValue:"uid", ftype: "Hash",optionMap:{"uid":"帐户名称","displayname":"真实姓名","company":"公司名称","description":"部门名称", "size": "邮箱空间"}},
	sizeoption:{title:"大小(仅用于邮箱空间)",defaultValue:"", ftype: "Hash",optionMap:{"":"", ">":"大于","=":"等于","<":"小于"}},
	findtype:{title:"查询",defaultValue:"2", ftype: "Hash",optionMap:{"1":"精确查询","2":"模糊查询"}},
	textvalue:{title:"条件值",defaultValue:""},
	savenew:{title:"是否自动保存",defaultValue:"1", ftype: "Hash", optionMap:{"1":"自动保存","0":"不自动保存"}}
}

var dataSourceProps = {
	isLocalSort: false,
	listURL: "users.json?dc=" + curDc + "&depou=" + curDepou,
	addURL: "user_add.json?dc=" + curDc + "&depou=" + curDepou,
	modURL: "user_mod.json?dc=" + curDc + "&depou=" + curDepou,
	delURL: "users_del.json?dc=" + curDc
}


var tableProps = {
	subjects: ['sortnum', "uid","size","messagesize","ou","displayname","lasttime","description","status","ishide"],
	hiddens:["dc"],
	isCheckbox : true, 
	filter:{
		ou:function(v){
			if(depDesc && depDesc[v])
				return depDesc[v];
			else
				return v;
		}
	}
}

var addUserWinProps = {
	width: 600,
	height:400,
	/*
	subjects: ["uid","userpassword","oudes","ou","displayname","description","employeeid",
		"ispop3","issmtp","isproxy","maxcc","size","messagesize","storagelocation","status","ishide"],
	*/
	subjects: ["uid","userpassword","oudes","ou","displayname","size","messagesize"],
	
	hiddens: ["ou"],
	title: "新增用户",
	isForgetDataStructKey: true
}

var modUserWinProps = {
	width: 600,
	height:400,
	title: "用户信息修改",
	subjects: ["uid","userpassword","oudes","ou","displayname","description","employeeid",
		"ispop3","issmtp","isproxy","maxcc","size","messagesize","storagelocation","status","ishide","savenew"],
	hiddens: ["ou"]
}

var modUserSortNumWinProps = {
	width: 400,
	height:100,
	title: "用户排名修改",
	subjects: ["sortnum"],
	hiddens: ["ou"]
}


var modPassWinProps = {
	width: 400,
	height:247,
	title: "密码修改",
	subjects: ["userpassword"],
	hiddens:["uid"]
}



var searchWinProps = {
	title:"搜索",
	isForgetDataStructKey: true,
	width: 400,
	height:247,
	subjects: ["search","textvalue","findtype"],
	formURL: "users_search.json?dc=" + curDc + "&depou=" + curDepou
}


var modSizeWinProps = {
	title:"批量修改邮箱大小",
	isForgetDataStructKey: true,
	width: 400,
	height:247,
	subjects: ["search","textvalue","findtype","sizeoption", "size"],
	formURL : "modUsersSize.json?dc=" + curDc + "&depou=" + curDepou
}

function viewWinProps(){
	var data = ds.getActiveData();
	new Ajax.Request("userinfo.json?uid=" + data.uid +"&dc=" +data.dc, {
		onComplete: function(req) {
			var v = richEval(req.responseText);
			if(v.res != 1){
				alert('请求失败！');
			}
			
			var info = "邮箱收件箱共计有" + v.data.mailCount + "封邮件<br>"
			+ "邮箱以使用" + v.data.spaceMailM +"M<br>"
			+ "网络U盘使用" + v.data.spaceNetdiskM +"M<br>";
			var win = SkyDNA.Element.createAlertWin(info, {title: "账户详细信息",width: 300,height:200});
		}
	});
	
}

function listDep(ctr){
	SkyDNA.Event.addEvent(ctr,'onclick',function(){
		var dc = document.getElementsByName('dc');			
		var ous = document.getElementsByName('ou');
		var oudecs = document.getElementsByName('oudes');
		if(ous.length<=0) return;
		var pou = ous[0];
		var poudesc = oudecs[0];
		pou.readOnly = true;
		var depwin = null;
		/*
		 *	creatae popwin to list department data tree
		 */
		 SkyDNA.Event.addEvent(poudesc,'onfocus',function(){
		 	depwin = SkyDNA.Element.createPopupWin({title: curDc + '部门列表',width: 350,height:380});
		
			var treeCtr = _CC("div", null, depwin.contentDom);
			treeCtr.innerHTML =  '<div id="deptDataTree"><ul><li><span title="打开/折叠" id="rootECBtn" onclick="switchBranch(this);" class="closed">&nbsp;</span><span _data="" onclick="selectBranch(this);" class="t">部门</span></li></ul></div>';

		 	selectBranch = function (branch){
				if(!branch) return;
				if(window._selectNode) window._selectNode.className = 't';
				window._selectNode = branch;
				window._selectNode.className = 't on';
				var str = unescape(_selectNode.getAttribute("_data"));
				if(str == '' ) str = '{}';
				var _data = eval('(' + str + ')');
				var ou = _data?_data.ou:'';
				var desc = _data?_data.description:'';
				pou.value= ou||'';
				poudesc.value = desc||'';
				this.win.dispose();					
			}.bind({win:depwin});
			switchBranch(_G('rootECBtn'));
			//selectBranch(_G('rootECBtn').nextSibling);
		 });
	  	//SkyDNA.Event.addEvent(pou,'onblur',function(){if(depwin)depwin.dispose();});
			
	});
	
}
	

var	ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
function main() {
	<c:if test="${depou == 'dep'}">
		_G("pgHeadBlock").style.display = "none";
	</c:if>
	
	with(SkyDNA.Element.createButtonsBar(_G("toolsBlock"))) {
		filterCell = addCell();
		filterCell.innerHTML = "查看: &nbsp;";
		var optionMap = SkyDNA.Object.clone(dataStruct.status.optionMap);
		var selectEl = SkyDNA.Element.Select.create(filterCell, {'optionMap': optionMap});
		selectEl.onchange = function() {
			if(selectEl.value!='all')
				dataSourceProps.listURL = "../user/users.json?dc=" + curDc + "&depou=" + curDepou + "&status=" + selectEl.value;
			else
				dataSourceProps.listURL = "../user/users.json?dc=" + curDc + "&depou=" + curDepou;
			ds.remoteListData();
		}
		
		addBtn = addButton("新增");
		modBtn = addButton("修改");
		//modPassBtn = addButton("密码");
		openBtn = addButton("开通",   openUsers);
		pauseBtn = addButton("暂停", pauseUsers);
		aliasBtn = addButton("别名",  openAlias);
		rfBtn = addButton("刷新");
		delBtn = addButton("删除");
		//searchBtn = addButton("搜索");
		searchBtn = addButton("搜索");
		hideTrueBtn = addButton("显示地址簿",  hideTrue);
		hideFalseBtn = addButton("隐藏地址簿",  hideFalse);
		modSortBtn = addButton("排名");
		modSizeBtn = addButton("批量修改");
		viewBtn = addButton("查看账户信息", viewWinProps);
		
		<c:if test="${not empty depou}">
			moveBtn = addButton("移动",moveUsers);
			SkyDNA.Element.show(moveBtn, isWritable);
		</c:if>
		
		if(isWritable){
			SkyDNA.Element.show(addBtn, true);
			SkyDNA.Element.show(modBtn, true);
	//		SkyDNA.Element.show(modPassBtn, true);
	//		SkyDNA.Element.show(openBtn, true);
	//		SkyDNA.Element.show(pauseBtn, true);
			SkyDNA.Element.show(aliasBtn, true);
			SkyDNA.Element.show(rfBtn, true);
			SkyDNA.Element.show(delBtn, true);
			SkyDNA.Element.show(searchBtn, true);
	//		SkyDNA.Element.show(hideTrueBtn, true);
	//		SkyDNA.Element.show(hideFalseBtn, true);
			SkyDNA.Element.show(modSortBtn, true);
			SkyDNA.Element.show(modSizeBtn, true);
			SkyDNA.Element.show(viewBtn, true);
			
		}else{
			SkyDNA.Element.show(addBtn, false);
			SkyDNA.Element.show(modBtn, false);
	//		SkyDNA.Element.show(modPassBtn, false);
	//		SkyDNA.Element.show(openBtn, false);
	//		SkyDNA.Element.show(pauseBtn, false);
			SkyDNA.Element.show(aliasBtn, false);
			SkyDNA.Element.show(rfBtn, true);
			SkyDNA.Element.show(delBtn, false);
			SkyDNA.Element.show(searchBtn, true);
	//		SkyDNA.Element.show(hideTrueBtn, false);
	//		SkyDNA.Element.show(hideFalseBtn, false);
			SkyDNA.Element.show(modSortBtn, false);
			SkyDNA.Element.show(modSizeBtn, false);
			SkyDNA.Element.show(viewBtn, false);
		}
	}
	
	ds.bindAdd(addBtn,addUserWinProps);
	ds.bindMod(modBtn,modUserWinProps);
	SkyDNA.Event.addEvent(modBtn,"onclick",function(){
			var ous = document.getElementsByName('ou');
			var oudecs = document.getElementsByName('oudes');
			if(ous.length<=0||oudecs.length<=0) return;	
			
			if(depDesc && depDesc[ous[0].value])  oudecs[0].value  = depDesc[ous[0].value];
	
	});
//	ds.bindMod(modPassBtn, modPassWinProps);
	ds.bindMod(modSortBtn, modUserSortNumWinProps);
	ds.bindRefresh(rfBtn);
	ds.bindDel(delBtn);
	ds.bindSearch(searchBtn, searchWinProps);
	ds.bindSearch(modSizeBtn, modSizeWinProps);
	ds.createDataTable(_G("userTableBlock"), tableProps);
	ds.createPageBar(_G("toolsBlock"),"pagenum","perpagecount",{countPerPage:15});
	

	ds.remoteListData();
	<c:if test='${!isAddrAdmin}'>
		listDep(addBtn);
		listDep(modBtn);
	</c:if>
}

function searchWin(){
	var win = SkyDNA.Element.createFormWin({title: "搜索联系人",width: "400",height: "150"});
	var form = SkyDNA.Element.createForm(win.contentDom, {formURL:'users_search.json'});
	with(form){
		addInputHidden("dc",{value: curDc});
		addInputHidden("depou",{value: curDepou});
		addSelect("search","条件名",{id:"searchID",value:"uid",optionMap:{"uid":"用户名称","displayname":"真实姓名","company":"公司名称","description":"部门名称"}});
		addInputText("text","条件值",{id:"textID"});
		addSelect("radio","搜索类型",{id:"radioID",value:"2",optionMap:{"2":"模糊查询", "1":"精确查询"}});
	}
	win.submitBtn.onclick = function search(win){
		var sIDV = _G('searchID').value;
		var tIDV = _G('textID').value;
		
		/*
		urlPara = sIDV + '=' + tIDV;
		if(sIDV == "displayname") urlPara = "&displayname=" + tIDV;
		if(sIDV == "uid") urlPara = "&uid=" + tIDV;
		if(sIDV == "company") urlPara = "&company=" + tIDV;
		if(sIDV == "description") urlPara = "&description=" + tIDV;
		*/
		var urlPara = '&search='+sIDV+'&textvalue='+tIDV;
		var sRadio =_G('radioID').value;
		urlPara +="&findtype=" +sRadio;
		
		new Ajax.Request("users_search.json?dc=" + curDc + "&depou=" + curDepou+ urlPara , {
			onComplete: function(req) {
				var v = richEval(req.responseText);
				if (ds.pageBar)
					ds.pageBar.reset();
				
				ds.__reListDatas(v.data, v.msg);
			}
		});
		win.dispose();
	}.bind(this,win);
}


function openUsers() {
	modUserStatus('status', 'open');
}
function pauseUsers() {
	modUserStatus('status', 'pause');
}

function hideTrue() {
	modUserStatus('ishide', 1);
}
	
function hideFalse() {
	modUserStatus('ishide', 0);
}

function modUserStatus(field, value) {
	var selDatas = ds.getSelectedDatas();
	
	var uids = "";
	selDatas.each(function(data) {
		uids += "&uid=" + data.uid;
	});
	var url = "../user/userStatus_mod.json?dc=" + curDc + "&depou=" + curDepou + "&" + field + "=" + value + uids;	
	
	SkyDNA.Ajax.doRequest(url);
	ds.remoteListData();
}
		
function moveUsers() {
	var selectedDatas = ds.getSelectedDatas();
	if (selectedDatas.length == 0) {
		SkyDNA.Element.createAlertWin("请先选择您要移动的员工！");
		return;
	}

	var win = SkyDNA.Element.createFormWin({title: "移动到...",width:500,height:220});
	//var depOu = null;
	win.contentDom.style.width = 'auto';
	win.contentDom.style.height = '180px';
	win.contentDom.style.overflow = "auto";
	win.contentDom.innerHTML = "";

	var treeCtr = _CC("div", null, win.contentDom);
	treeCtr.innerHTML =  '<div id="deptDataTree"><ul><li><span title="打开/折叠" id="rootECBtn" onclick="switchBranch(this);" class="closed">&nbsp;</span><span _data="" onclick="selectBranch(this);" class="t">部门</span></li></ul></div>';
 	selectBranch = function (branch){
		if(!branch) return;
		if(window._selectNode) window._selectNode.className = 't';
		window._selectNode = branch;
		window._selectNode.className = 't on';
	}.bind({win:win});
	switchBranch(_G('rootECBtn'));		
	win.submitBtn.onclick = function() {
		var str = unescape(_selectNode.getAttribute("_data"));
		if(str == '' ) str = '{}';
		var _data = eval('(' + str + ')');
		var ou = _data?_data.ou:'';
		var desc = _data?_data.description:'';
		//alert(ou);
		var depOu = ou;
		if (!depOu) {
			SkyDNA.Element.createAlertWin("请先选择要移动的目标部门！");
			return;
		}
		
		if (depOu == ds.datas[0].data.ou) {
			SkyDNA.Element.createAlertWin("不能移动到相同的目录！");
			return;
		}
		var moveuids = ds.getSelectedDatas();

		
		var uids="";
		moveuids.each(function(data) {
			uids +="&uid=" + data.uid;
		});
		var  url = "../user/moveUser.json?dc=" + curDc + "&ou=" + curDepou + uids;
		var v = SkyDNA.Ajax.doRequestJSON(url);
		if (v.res == 1) {
			win.dispose();
			// TODO 
			ds.remoteListData();

		}else {
			SkyDNA.Element.createAlertWin(v.msg);
		}
		
	}.bind(this);
	
	//ds.remoteListData();
	
}
			
function openAlias() {
	
	var data = ds.getActiveData();
	var uid = data.uid;
	var win = SkyDNA.Element.createPopupWin({title: uid + " 用户别名管理",width: 500,height:350});
	
	var dataStruct = {
		'uid': {title: '别名', isKey: true},
		'dc':  {title: "dc", isKey: true, defaultValue: curDc}
	}
	
	var dsProps = {
		listURL: "aliases.json?aliasedobjectname=" + data.uid + "@" + curDc,
		delURL: "aliases_del.json?"
	}
	
	var aliasDs = new SkyDNA.DataSource(dataStruct, dsProps);
	aliasDs.createDataTable(win.contentDom, {subjects: ["uid"], isCheckbox: true});
		with(SkyDNA.Element.createButtonsBar(win.contentDom)){
			aliasDs.bindDel(addButton("删除别名"));
		}
	_CC("hr", null, win.contentDom);
	aliasDs.remoteListData();


	var formProps = {
		formURL: "alias_add.json?dc=" + curDc + "&uid=" + data.uid,
		onSubmitSucc: function() {aliasDs.remoteListData();}
	};
	with(SkyDNA.Element.createForm(win.contentDom,  formProps)) {
		addInputText("aliasUid", "新别名", {validate: VF_username});
		addSubmit();
	}
	
	function delAlias(){
		var aliasdata = aliasDs.getSelectedDatas();
		var uids="";
		aliasdata.each(function(data) {
		uids +="&uid=" + data.uid;
		});
		
		var url = "aliases_del.json?dc=" + curDc + "&useruid="+uid + uids;
		SkyDNA.Ajax.doRequest(url);
		aliasDs.remoteListData();
	}
}
	

	main();

function switchBranch(branch){	
	if(!branch.nextSibling) return;
	//selectBranch(branch.nextSibling);
	if(!branch.isOpened){
		if(!branch.isBuilt){
			___addTreeNodes(branch);
		}
	}
	var _ul = branch.parentNode.getElementsByTagName('ul');
	if(_ul.length==0) return;
	var cLst = _ul[0];
	if(!branch.isOpened){
		cLst.style.display = 'block';
		branch.isOpened = true;
		branch.className = 'opened';
	}else{
		cLst.style.display = 'none';
		branch.isOpened = false;
		branch.className = 'closed';
	}
}
function ___addTreeNodes(branch){
	if(!(typeof ___deptsData == 'object')){alert('对象丢失！'); return;}
	var nodeDObjStr = branch.nextSibling.getAttribute("_data");
	var cNodeLst = null;
	if(nodeDObjStr.trim()==''){
		cNodeLst = ___deptsData['ROOT'];
	}else{
		var nData = eval('(' + unescape(nodeDObjStr.trim()) + ')');
		if(!(typeof nData == 'object')){alert('无效的树节点！'); return;}
		cNodeLst = ___deptsData[nData.ou];
	}
	if(cNodeLst){
		var _ul = document.createElement('ul');
		branch.parentNode.appendChild(_ul);
		try{
			var _arr = new Array();
			for(var i = 0 ; i < cNodeLst.length; i++){
				_arr[_arr.length]  = '<li><span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span><span  _data=\'';
				_arr[_arr.length]  = escape(JSON.toString(cNodeLst[i]));
				_arr[_arr.length]  = '\' onclick="selectBranch(this);" class="t">' ;
				_arr[_arr.length]  =  cNodeLst[i].description ;
				_arr[_arr.length]  =  '</span></li>';
			}
			_ul.innerHTML = _arr.join('');
    	}finally{
    		_arr = null;
    	}
		branch.isBuilt = true;
	}
}	

var ___deptsData = <c:out value='${deptTreeStr}' escapeXml='false'/>;
window.onload = function(){

};
</script>
</html>
