<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/email.css" type="text/css" rel="stylesheet">
<style type="text/css">
html {
	height: 100%;
	width: 100%;
}

#pgBodyBlock {
	margin-right:9px;	
	margin-left:20px;
	margin-bottom: 10px;
}

#pgBodyBlock .a-btn {
	display: block;
	text-decoration: none;
	text-align: center;
}
#pgBodyBlock .a-btn:hover {
	text-decoration: underline;
}
.pg-t {
	border-bottom: 1px solid #E49222;
	height: 24px;
	margin: 10px 0;
}
.pg-t span {
	width: 80px;
	height: 100%;
	background-color: #E49222;
	color: #fff;
	display: block;
	text-align: center;
	font-size: 12px;
	line-height: 24px;
}

#type-table {
	margin: 5px 0;
}
#type-table td {
	height: 30px;
	line-height: 30px;
	
}

#ou-box {
	color: #E49222;
	font-weight: bold;
	font-size: 14px;
}

#user-list {
	height: 300px;
	width: 710px;
	overflow-y: scroll;
	overflow-x: scroll;
}

.SDC_DataTable  {
	margin-bottom: 0px;
margin-right: 0px;
}
/****** ******/

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
	background: url(../user/icon/folder_closed.gif) 0 0 no-repeat;
	font-size:12px;
	padding:2px 6px 1px 6px;
	margin:3px 0;
	color:#fff;			
}
#deptDataTree span.opened{
	background: url(../user/icon/folder_opened.gif) 0 0 no-repeat;
	font-size:12px;
	margin: 3px 0;
	padding:2px 6px 1px 6px;
	color:#fff;			
}
</style>

<script type="text/javascript" src="../js/lib_json.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/FCKEditor/fckeditor.js"></script>
<script language="javascript">

</script>

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

</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock">
	<table border=0 width="100%" height="100%" cellspacing="0">
		<tr>
			<td algin="left" width=41 class="title_BarImg"></td>
			<td align="left" id="title_Font1">群发邮件</td>
			<td align="right" id="title_Font2"></td>
		</tr>
	</table>
</div>


<div id="pgBodyBlock">
<form method="post" name="noticefrm" target="hiddenIframe" enctype= "multipart/form-data">
	<input type="hidden" value="" name="rcpt"/>
	<h3 class="pg-t">
		<span>用户信息</span>
	</h3>
	<table cellpadding="0" cellspacing="0"  width="710" style="background-color: #eee">
		<tr>
			<td width="60">选择用户：</td>
			<td>
				<input type="radio" name="su" id="su-dc" value="1" onclick="typeSel(this)" /><label for="su-dc" style="cursor: pointer">按域</label>
				<input type="radio" name="su" id="su-group" value="2" onclick="typeSel(this)"/><label for="su-group" style="cursor: pointer">按组</label>	
			</td>
		</tr>
		<tr>	
			<td></td>
			<td>
				<table id="type-table" cellpadding="0" cellspacing="0" width="400">
					<tr id="sel-1">
						<td>
							<select name="domain" id="domain" onchange="selectDomain()" style="width: 150px;">
								<c:forEach var="domain" items="${domains}">
									<option value="<c:out value='${domain.dc}'/>"><c:out value='${domain.dc}'/></option>					
								</c:forEach>
							</select>
							<input value="选择部门" onclick="javascript:showOuwin(this)" type="button"> 
							<span id="ou-box">
								<span id="ou-desc"></span>
								<input type="hidden" name="ou" id="ou-txt" value=""/>
							</span>
						</td>
						<td width="60">
							<a class="a-btn" href="javascript:void(0)" onclick="addUsersByDc()">[加入]</a>
						</td>
					</tr>
					<tr id="sel-2">
						<td>
							<select name="group" id="group" style="width: 150px;">
								<c:forEach var="g" items="${groups}">
									<option value="<c:out value='${g.uuid}'/>"><c:out value='${g.name}'/></option>					
								</c:forEach>
							</select>
						</td>
						<td width="60">
							<a class="a-btn" href="javascript:void(0)" onclick="addUsersByGroup()">[加入]</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				用户列表：
			</td>
			<td>
				<div id="list-btn-bar"></div>
			</td>
		</tr>
	</table>
	<div id="user-list"></div>
	
	<h3 class="pg-t">
		<span>邮件信息</span>
	</h3>
	<div>
		<table id="sendBatchTable" width="710">
		<tr>
			<td width="60" valign="middle" align="right"><nobr>主题: </nobr></td>
			<td><input id="title" type="text" name="title" id="title" size=50></td>
		</tr>
		<tr>
			<td valign="middle" align="right"><nobr>上传附件: </nobr></td>
			<td colspan="2">
				<input type="file" name="attfile" id="attfile"> <input type="button" name='box' value="增加新附件按钮" onclick="addfileBtn()"/>
				<div id="attfile-box">
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<textarea name="content" id="content" style="display:none"></textarea>
			</td>
			<td id="dvHtmlEditor"></td>
		</tr>
		</table>
	</div>
	
	<div style="margin: 10px;width: 710px;text-align: center;">
		<input type="button" value="发送" onclick="checksubmit()"/>&nbsp;&nbsp;
	   	<input type="button" value="关闭" onclick="_close()"/>
	</div>
</form>	
</div>

<iframe id="hiddenIframe" name="hiddenIframe" style="display:none" ></iframe>

<script type="text/javascript">
function addfileBtn(){
	var addfileBox = document.getElementById('attfile-box');
	var old= addfileBox.innerHTML;
	addfileBox.innerHTML=old+"<input type=file name='attfile' id='attfile'>";
}
	_G('su-group').checked = 'checked';
	_G('su-group').onclick();

	window.RTEditorId = "RTEditor_" + Math.random();
	var editArea = _C("div", {style:"width:100%"}, _G("dvHtmlEditor"));
	editArea.innerHTML = '<iframe id="' + RTEditorId + '"  hspace="0" vspace="0" scrolling="auto" frameborder="0"  width="100%" height="300"><\/iframe>';
	(document.getElementById(window.RTEditorId) || document.frames[window.RTEditorId]).src="/DNA/jsDNA/rteditor/RTEditor.htm";
	if(typeof(document.noticefrm.content)!='undefined'){
		window.aLoadedIFrame = function (){
			_G(window.RTEditorId).contentWindow.writeRTHTML(document.noticefrm.content.value);
		};
	}
	
	var depDesc = [];
	<c:forEach var="dept" items="${deplist}"><c:out value='depDesc["${dept.ou}"] = "${dept.description}";' escapeXml="false"/></c:forEach>
	
	
	var dataTable = SkyDNA.Element.createDataTable(_G('user-list'));
	dataTable.subjects = ['uid', 'dc', 'displayname','ou'];
	dataTable.props = { 
		filter: {
			ou:function(v){
				if(depDesc && depDesc[v])
					return depDesc[v];
				else
					return v;
			}
		},
		isCheckbox: true
	};
	var dataStruct = {
		uid: {title: "帐号" , isKey: true},
		dc: {title: "域名", isKey: true},
		displayname: {title: "姓名"},
		ou:{title:"部门",defaultValue:""}
	};
	var ds = new SkyDNA.DataSource(dataStruct);
	dataTable.bind(ds);
	
	var btnbars = SkyDNA.Element.createButtonsBar(_G('list-btn-bar'));
	var delSelectBtn = btnbars.addButton("删除");
	ds.bindDel(delSelectBtn);

function _close() {
	window.parent.frames['contentFrame'].location = "batch.html";
}	

function checksubmit() {
	var rcptArr = [];
	var datasCur = ds.getAllDatas();
	if(datasCur.length == 0) {
		alert('发送用户数至少1条');
		return false;
	}
	
	var title = document.noticefrm.title.value;
	if(title.trim() == '') {
		alert('邮件标题不能为空');
		return false;
	}	
	
	for(var i = 0; i< datasCur.length; i++) {
		var _data = datasCur[i];
		rcptArr.push(_data.uid + "@" + _data.dc);
	}
	
	var rcpt = rcptArr.join(';');
	document.noticefrm.rcpt.value = rcpt;

	_G("content").value = _G(window.RTEditorId).contentWindow.getRTHTML();
	document.noticefrm.action = "../email/addbatch.sjs";
	document.noticefrm.submit();
}

function addbatchCallBack() {
	_close();
}

//选择域
function selectDomain() {
	document.getElementById("ou-txt").value = "";
	document.getElementById("ou-desc").innerHTML = "";
	
	var domain = document.getElementById('domain');
	if(domain.value == 'all'){
		//TODO 部门的所有值要清空
		document.getElementById('ou-box').style.display = 'none';
	}
	else {
		document.getElementById('ou-box').style.display = '';
	}
}

//弹出框选择部门
function showOuwin(btn){
	var oudiv = document.getElementById("ou-box");
	var disType = oudiv.style.display;
	if(disType!=""){
		oudiv.style.display='';
	}
	
	var dc = document.getElementById('domain').value;
	if(dc == 'all'){
		alert('请您先选择域');
		return;
	}
	deptTreeStr(dc);
	listDep(dc);
}

var ___deptsData = {};
function deptTreeStr(dc) {
	___deptsData = SkyDNA.Ajax.doRequestJSON("../email/deptTree.json?dc=" + dc).data;
}


function listDep(dc){
	depwin = SkyDNA.Element.createPopupWin({title: dc + '部门列表',width: 350,height:380});
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
		if(typeof(_data.ou) == 'undefined' || _data.ou == '')	
			return;
		var ou = _data?_data.ou:'';
		var desc = _data?_data.description:'';
		
		document.getElementById("ou-txt").value = ou;
		document.getElementById("ou-desc").innerHTML = desc;
		this.win.dispose();
	}.bind({win:depwin});
	
	switchBranch(_G('rootECBtn'));
}


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


function addUsersByDc() {
	var dc = document.getElementById('domain').value;
	if(dc == '' || dc == 'all')
		return;
	var ou = document.getElementById('ou-txt').value;
	
	var waitingDom = SkyDNA.Element.showWaiting();
	new Ajax.Request("../email/searchUsersByDc.json?dc=" + dc + "&ou=" + ou, {
		method: 'post',
		onComplete: function(resp) {
			_R(waitingDom);
			var data  = richEval(resp.responseText);
			if(data.res == 'no') {
				alert(data.data);
				return;
			}
			addUserLines(data.data);
		}
	});
}

function addUsersByGroup() {
	var group = document.getElementById('group').value;
	if(group == '')
		return;
	var waitingDom = SkyDNA.Element.showWaiting();
	new Ajax.Request("../email/searchUsersByGroup.json?groupuuid=" + group, {
		method: 'post',
		onComplete: function(resp) {
			_R(waitingDom);
			var data  = richEval(resp.responseText);
			if(data.res == 'no') {
				alert(data.data);
				return;
			}
			addUserLines(data.data);
		}
	});
}

function addUserLines(datas) {
	if(datas.length == 0) {
		alert("无用户数据可以加入列表");
		return;
	}
		
	datas.each(function(data) {
		if(!checkData(data))
			return;
		
		ds.addData({uid: data.uid, dc: data.dc, displayname: data.displayname, ou: data.ou});
	});
}

// 用户列表中是否重复
function checkData(data) {
	var datasCur = ds.getAllDatas();
	if(datasCur.length == 0)
		return true;
		
	for(var i = 0; i< datasCur.length; i++) {
		var _data = datasCur[i];
		if(_data.uid + "@" + _data.dc == data.uid + "@" + data.dc)
			return false;
	}
	
	return true;
}

function typeSel(el) {
	var t_v = el.value;
	_G('sel-1').style.display = 'none';
	_G('sel-2').style.display = 'none';
	
	_G('sel-' + t_v).style.display = '';
}

function showTimerDiv(cb){
	var tdiv = document.getElementById('timerDiv');
	if(cb.checked)
	 	tdiv.style.display = '';
	else
	 	tdiv.style.display = 'none';  
}
	
	
</script>
</body>
</html>
