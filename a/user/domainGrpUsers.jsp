<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<script type="text/javascript" src="../js/lib_json.js"></script>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/user.css" type="text/css" rel="stylesheet">
<style type="text/css">
#page-head-box {
	background-color:#43A625;
	padding:10px;
}

#page-title-box {
	font-size:12px;
	font-weight: bold;
	color: white;
}

#mbr-head-box {
	background-color:#CCCCCC;
}

#mbr-title-box {
	font-size:14px;
	font-weight: bold;
	padding:10px;
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
<div id="page-head-box">
	<div id="page-title-box"><c:out value='${dc}'/> 群组用户</div>
</div>

</body>
<script language="javascript">
var grpDs;
var memberDs;

var curDc = "<c:out value='${dc}'/>";
var addDeptToGrpURL = "grpMemberAddFromDept.json?dc=" + curDc;
var depDesc = [];
<c:forEach var="dept" items="${depts}">
	<c:out value='depDesc["${dept.ou}"] = "${dept.description}";' escapeXml="false"/>
</c:forEach>

function VF_safetyStr(v){
	if(v=='hr')return;
	if(v.length<=3)
		return "用户名长度须大于3，且不包含@及域名";
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

function listDep(ctr){
	SkyDNA.Event.addEvent(ctr,'onclick',function(){
		
		//	creatae popwin to list department data tree
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
			if (confirm("你确定要将部门“" + desc + "”下的所有用户添加到本群组吗？")) {
				this.win.dispose();	
				var parameters = {
					ou: ou,
					grpuid: grpDs.getActiveData().uid
				};
				new Ajax.Request(addDeptToGrpURL, {
					parameters: parameters,
					onComplete: function(req) {
						var s = req.responseText;
						var v = richEval(s);
						if (1 == v.res) {
							memberDs.remoteListData();
						}else {
							var msg = v.msg || v.data;
							SkyDNA.Element.createAlertWin(msg + "!");
						}
					}
				});
			}
		}.bind({win:depwin});
		switchBranch(_G('rootECBtn'));
			//selectBranch(_G('rootECBtn').nextSibling);
	});
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


{
	var dataStruct = {
		dc: {title: "域名", defaultValue: curDc},
		uid: {title: "群组帐号" , isKey: true, validate: VF_safetyStr},
		name: {title: "说明或描述"}
	}
	
	var dataSourceProps = {
		isLocalSort: false,
		listURL: "grpUsers.json?dc=" + curDc,
		addURL: "grpUserAdd.json?dc=" + curDc,
		modURL: "grpUserMod.json?dc=" + curDc,
		delURL: "grpUserDel.json?dc=" + curDc
	}
	
	var addGrpUserWinProps = {
		width: 550,
		height:200,
		subjects: ["uid","name"],
		title: "新增群组",
		isForgetDataStructKey: true
	}
	
	var modGrpUserWinProps = {
		width: 550,
		height:200,
		subjects: ["name"],
		hiddens: ["uid"],
		title: "修改群组信息",
		isForgetDataStructKey: false
	}
		
	var tableProps = {
		subjects: ["uid", "name"],
		hiddens:["dc"],
		isCheckbox : true
	}
	
	var splitter =  SkyDNA.Element.createSplitter(document.body,document.body,{
		id: "domainGrpUserSplitter", 
		aideDock: "left", 
		aideLength: 300,
		dock: 'full',
		dockTopTo: _G("page-head-box")
	});
	
	var grpToolsBar = SkyDNA.Element.createButtonsBar(splitter.aideCell);
	with(grpToolsBar) {
		grpAddBtn = addButton("新增群组");
		grpModBtn = addButton("修改");
		grpDelBtn = addButton("删除");
	};
	
	var	ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
	grpDs = ds;
	
	ds.bindAdd(grpAddBtn, addGrpUserWinProps);
	ds.bindMod(grpModBtn, modGrpUserWinProps);
	ds.bindDel(grpDelBtn);
	
	var grpsCtr = _CC("div", null, splitter.aideCell);
	grpsCtr.style.overflow = "scroll";
	SkyDNA.Enhance.enhance(grpsCtr, "dockable", {dock: 'full', dockTopTo:grpToolsBar });
	
	ds.createDataTable(grpsCtr, tableProps);
	ds.remoteListData();
}

//////////// GroupUserMember //////////

{
	var dataStruct = {
		dc: {title: "域名", defaultValue: curDc},
		uid: {title: "帐号" , isKey: true},
		displayname: {title: "姓名"},
		ou:{title:"部门",defaultValue:""}
	}
	
	var dataSourceProps = {
		isLocalSort: false,
		listURL: "grpMembers.json?dc=" + curDc,
		addURL: "grpMemberAdd.json?dc=" + curDc,
		delURL: "grpMemberDel.json?dc=" + curDc
	}
	
	var tableProps = {
		subjects: ["uid", "displayname", "ou"],
		hiddens:["dc"],
		isCheckbox : true,
		filter: {
			ou: function(v) {
				return depDesc[v];
			}
		}
	}
	
	var addMemberWinProps = {
		width: 550,
		height:200,
		subjects: ["uid"],
		title: "新增群组成员",
		isFetchParentDsKey: true,
		isForgetDataStructKey: true
	}
	
	var titleDataViewProps = {
		subjects: ["uid"],
		filter: {
			uid: function(v) {	return v + "@" + curDc + "成员管理"}
		}
	}

	var mbrToolsBox = _C("div", {id: "mbr-head-box"}, splitter.mainCell);
	var mbrTitleBox = _C("div", {id: "mbr-title-box" }, mbrToolsBox);
	grpDs.createDataView(mbrTitleBox, titleDataViewProps);

	var	ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);
	grpDs.bindSubDataSource(ds);
	memberDs = ds;
	
	var mbrToolsBar = SkyDNA.Element.createButtonsBar(splitter.mainCell);
	with(mbrToolsBar) {
		mbrAddBtn = addButton("单独添加成员");
		mbrAllAddBtn = addButton("添加全体用户",  addMemberAll);
		mbrDptBtn = addButton("添加部门用户");
		mbrNoDeptAddBtn = addButton("添加“非”部门用户",  addMemberNoDept);
		mbrDelBtn = addButton("删除成员");
	}
	
	ds.createDataTable(splitter.mainCell, tableProps);
	ds.bindAdd(mbrAddBtn, addMemberWinProps);
	ds.bindDel(mbrDelBtn);
	listDep(mbrDptBtn);
	
	ds.remoteListData();
	
	
	
	function addMemberAll() {
		if (!confirm("您确认要添加所有的用户到本群组吗？"))
			return;
		
		var parameters = {
			grpuid: grpDs.getActiveData().uid
		};
		new Ajax.Request("grpMemberAddAll.json?dc=" + curDc, {
			parameters: parameters,
			onComplete: function(req) {
				var s = req.responseText;
				var v = richEval(s);
				if (1 == v.res) {
					memberDs.remoteListData();
				}else {
					var msg = v.msg || v.data;
					SkyDNA.Element.createAlertWin(msg + "!");
				}
			}
		});
	}
	
	function addMemberNoDept() {
		if (!confirm("您确认要添加所有“无部门信息的”用户到本群组吗？"))
			return;
		
		var parameters = {
			grpuid: grpDs.getActiveData().uid
		};
		new Ajax.Request("grpMemberAddNoDept.json?dc=" + curDc, {
			parameters: parameters,
			onComplete: function(req) {
				var s = req.responseText;
				var v = richEval(s);
				if (1 == v.res) {
					memberDs.remoteListData();
				}else {
					var msg = v.msg || v.data;
					SkyDNA.Element.createAlertWin(msg + "!");
				}
			}
		});
	}

	
}
</script>
</html>
