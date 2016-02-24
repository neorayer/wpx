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
	body {
		margin-left: 10px;
	}
	.pgHeadBlock {
		margin-left:0px;
	}
	 #addrSplitter {
		margin-top: 10px;
	}
	.group {
		text-align: left;
		border: 0px solid #000000;
		margin-left:8px;
		vertical-align:middle;
		margin-bottom:3px;
		margin-top:3px;
		white-space:nowrap;
	}
	.groupdata{
		text-align: left;
		border: 0px solid #000000;
		margin-left:17px;
		vertical-align:middle;
		margin-bottom:3px;
		margin-top:3px;
		white-space:nowrap;
	}
	 .group .group,
	 .group .groupdata{
		display:none;
		white-space:nowrap;
	}
	.groupname input{
		margin:0;
		padding:0;
	}
	span.shTreeNodeE,
	span.shTreeNode{
		background-image:url(../../img/icons.gif);
		background-repeat:no-repeat;
	}
	.shTreeNode{
		background-position:-8px -327px;
		margin:0 3px 0 0;
		>margin:0;
		padding:0 2px 0 2px;
		width:20px;
		>padding-right:6px;
		>padding-left:0;
		cursor:pointer;
		font-size:12px;
	}
	.shTreeNodeE{
		background-position:-8px -343px;
		margin:0 3px 0 0;
		>margin:0;
		padding:0 2px 0 2px;
		width:20px;
		>padding-right:6px;
		>padding-left:0;
		cursor:pointer;
		font-size:12px;
	}
	#deptSortDisArea{
		width:100%;
		height:75%;
		overflow:auto;
	}
	#deptSortToolbar{
		display:block;
		margin:5px;
		height:25%;
		overflow:auto;
	}
	#deptSortToolbar form{
		margin:0;
		padding:0;
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
			padding:2px 14px 1px 14px;
			margin:3px 0;
			color:#fff;			
		}
		#deptDataTree span.opened{
			background: url(icon/folder_opened.gif) 0 0 no-repeat;
			font-size:12px;
			margin: 3px 0;
			padding:2px 14px 1px 14px;
			color:#fff;			
		}
span.Tsucc{background-color:#E2F5FF ;border:1px solid #00a8ff;padding:3px 8px;margin:2px; font-family: Verdana, "宋体";}
span.Tfail{background-color:#FBF8E9;border:1px solid #FEC600;padding:3px 8px;margin:2px; font-family: Verdana, "宋体";}
span.Tnor{padding:3px 8px;margin:2px; font-family: Verdana, "宋体";}
.txt{
	margin:10px 20px;
	line-height:30px;
	height:30px;
	vertical-align:middle;
}
.txt input{
	margin:3px 2px;
}
.btn{
	text-align:right;
	margin-right:20px;
}
#toolsBlock button{
	margin-left:5px;
}
</style>
<script language="javascript">
function doHiddenPubAddress(_o){
	var url = '../../do/domain/modDomain.jsp?dc=<c:out value='${dc}'/>';
	if(_o.checked){
			// '隐藏公共地址簿';
			url +=  '&isHidePubAddress=1';
	}else{
			// '显示公共地址簿';
			url +=  '&isHidePubAddress=0';
	}
	try{
		var  json= SkyDNA.Ajax.doRequestJSON(url);
		if(json.res=='yes'||json.res=='1'){
			alert('修改成功！');
		}else{
			alert('修改失败！');	
		}
	}catch(e){
		alert('异常：修改失败！');
	}
}


</script>
</head>
<body>

<c:if test="${ACTOR.isAddressBookRole}">
	<div style="height:30px;float:right;width:120px;">
		<input type="checkbox" title="是否隐藏公共地址簿" onclick="javascript:doHiddenPubAddress(this);" id="hiddenPubAddressBtn"  <c:if test="${doamin.isHidePubAddress }">checked = "true"</c:if> />
		<label for="hiddenPubAddressBtn" id="hiddenPubAddressInfo" style="color:#ff6699;">隐藏公共地址簿</label>
	</div>
</c:if>
<!--
<div id="pgHeadBlock" class="pgHeadBlock">
<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1"><c:out value='${dc}'/>部门管理</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>
-->

<div id="menubarId">
	<div style="width:300px;text-align:center;color:#ff1199" id="__showMsg"></div>
</div>
<div id="toolsBlock" style="margin:0 150px 0 0 ;">
	<button  onclick="__aTreeNode();return false;" id="aTreeNode" disabled>新建</button>
	<button  onclick="__mTreeNode();return false;" id="mTreeNode" disabled>修改</button>
	<button  onclick="__dTreeNode();return false;" id="eTreeNode" disabled>删除</button>
</div>
<div id="mainBlock"></div>
</body>

<script language="javascript">

///////////////////////////////////////////////

	
var splitter =  SkyDNA.Element.createSplitter(document.body,document.body,{
	id: "addrSplitter", 
	aideDock: "left", 
	aideLength: 200,
	dock: 'full',
	dockTopTo: _G("toolsBlock")
});
	
splitter.mainCell.innerHTML = "<br/>";


try {
	var treeCtr = _CC("div", null, splitter.aideCell);
	treeCtr.style.overflow = "scroll";
	SkyDNA.Enhance.enhance(treeCtr, "dockable", {dock: 'full'});
	splitter.aideCell.scrollCtr = treeCtr;

	var treeCtr1 = _CC("div", "", splitter.mainCell);
	treeCtr1.style.overflow = "scroll";
	SkyDNA.Enhance.enhance(treeCtr1, "dockable", {dock: 'full'});
	splitter.mainCell.scrollCtr = treeCtr1;	
	
	splitter.mainCell.scrollCtr = treeCtr1;
	window.userLstIframe = _C("iframe", {src: "about:blank",frameBorder:0}, splitter.mainCell.scrollCtr);
	SkyDNA.Enhance.enhance(userLstIframe, "dockable", {dock: 'full'});
	var _html = '<div id="deptDataTree"><ul><li><span title="打开/折叠" id="rootECBtn" onclick="switchBranch(this);" class="closed">&nbsp;</span><span _data="" onclick="selectBranch(this);" class="t">部门</span></li></ul></div>';
	treeCtr.innerHTML = _html;
}catch(e) {
	DEBUG(e);
}

function sMsg(msg){
	if(!_G('__showMsg')) return;
	_G('__showMsg').innerHTML = msg;
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
		sMsg('正在初始化节点...');
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
		sMsg('');
	}
}

function __aTreeNode(){
	if(typeof _selectNode.getAttribute("_data") == 'undefined')return;
	var str = unescape(_selectNode.getAttribute("_data"));
	if(str == '' ) str = '{}';
	var _data = eval('(' + str + ')');
	var __popWin =SkyDNA.Element.createPopupWin({title:'新建部门',width:500,height:180});
	_CC('div',"",__popWin.contentDom).innerHTML = '<form name="aTreeNodeFrm"><div class="txt">部门名称：<input type="text" name="description" value="" onFocus="cDept(this);" onKeyUp="cDept(this);" onBlur="cDept(this);"><span></span></div><div class="txt">部门排名：<input type="text" name="sortnum" value="10000" onFocus="cSort(this);" onKeyUp="cSort(this);" onBlur="cSort(this);"><span></span></div><div class="btn"><input type="button" name="adddept" value="增加部门" onclick="submitDept(this,this.form);"></div></form>';
	submitDept = function (btn,frm){
		// 输入框验证
		if(!cDept(frm.description))return false;
		if(!cSort(frm.sortnum))return false;
		
		var v = SkyDNA.Ajax.doRequestJSON("../user/addDept.json", {
			domain: "<c:out value='${dc}'/>",
			description: frm.description.value,
			sortnum: frm.sortnum.value,
			parent_ou: _data.ou ? _data.ou :  ''
		}) ;
		if(v.res=='1' || v.res==1){
			//ok
			//_data.description = v.data.description;
			//_selectNode.setAttribute("_data",escape(JSON.toString(v.data)));
			var _uls = _selectNode.parentNode.getElementsByTagName('ul');
			var _ul =  null;
			if(_uls.length ==0){
				_ul = document.createElement('ul');
				_selectNode.parentNode.appendChild(_ul);
			}else{
				_ul = _uls[0];
			}
			var s = '';
			s+= '<span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span><span  _data=\'';
			s+= escape(JSON.toString(v.data));
			s+= '\' onclick="selectBranch(this);" class="t">' ;
			s+=  v.data.description ;
			s+=  '</span>';
			var _li = 	document.createElement('li');
			_li.innerHTML = s;
			_ul.appendChild(_li);

		}else{
			SkyDNA.Element.createAlertWin(v.msg||v.data);			
		}
		__popWin.dispose();		
	};
}

// 部门名称输入框验证
function cDept(_input){
	var v = _input.value;
	if(v.trim()==''){
		_input.nextSibling.innerHTML= '必填！部门名称不能为空！';
		_input.nextSibling.className = 'Tfail';
		return false;
	}else{
		_input.nextSibling.innerHTML= '正确！';
		_input.nextSibling.className = 'Tsucc';
		return true;
	}
}
// 部门排名输入框验证
function cSort(_input){
	var v = _input.value;
	if(v.trim()=='' || ! /^[1-9][0-9]*$/.test(v)){
		_input.nextSibling.innerHTML= '必填！数字组合！';
		_input.nextSibling.className = 'Tfail';
		return false;
	}else{
		_input.nextSibling.innerHTML= '正确！';
		_input.nextSibling.className = 'Tsucc';
		return true;
	}
}

function __mTreeNode(){
	if(typeof _selectNode.getAttribute("_data") == 'undefined')return;
	var str = unescape(_selectNode.getAttribute("_data"));
	if(str == '' ) str = '{}';
	var _data = eval('(' + str + ')');
	var __popWin =SkyDNA.Element.createPopupWin({title:'修改部门',width:500,height:180});
	_CC('div',"",__popWin.contentDom).innerHTML = '<form name="aTreeNodeFrm"><div class="txt">部门名称：<input type="text" name="description"  onFocus="cDept(this);" onKeyUp="cDept(this);" onBlur="cDept(this);" value="'  + _data.description + '"><span></span></div><div class="txt">部门排名：<input type="text" name="sortnum" value="' + _data.sortnum + '" onFocus="cSort(this);" onKeyUp="cSort(this);" onBlur="cSort(this);"><span></span></div><div class="btn"><input type="button" name="adddept" value="修改部门" onclick="submitDept(this,this.form);"></div></form>';
	submitDept = function (btn,frm){
		if(!cDept(frm.description))return false;
		if(!cSort(frm.sortnum))return false;
		var v = SkyDNA.Ajax.doRequestJSON("../user/modDept.json", {
			ou: _data.ou,
			domain: "<c:out value='${dc}'/>",
			description: frm.description.value, 
			sortnum: frm.sortnum.value
		});
		if(v.res=='1' || v.res==1){
			//ok
			_selectNode.innerHTML  = v.data.description;
			_selectNode.setAttribute("_data",escape(JSON.toString(v.data)));			
		}else{
			SkyDNA.Element.createAlertWin(v.msg||v.data);			
		}
		__popWin.dispose();
	};
}

function __dTreeNode(){
	if(!_selectNode) return;
	if(typeof _selectNode.getAttribute("_data") == 'undefined')return;
	if(!confirm('是否删除部门？')) return;
	var str = unescape(_selectNode.getAttribute("_data"));
	if(str == '' ) str = '{}';
	var _data = eval('(' + str + ')');	
	var v = SkyDNA.Ajax.doRequestJSON("../user/delDept.json?domain=<c:out value='${dc}'/>" + "&ou=" + _data.ou );
	if(v.res=='1' || v.res==1){
		//ok
		var _li = _selectNode.parentNode;
		_li.parentNode.removeChild(_li);
	}else{
		SkyDNA.Element.createAlertWin(v.msg||v.data);			
	}
}

function selectBranch(branch){
	if(!branch) return;
	if(window._selectNode) window._selectNode.className = 't';
	window._selectNode = branch;
	window._selectNode.className = 't on';

	var dStr = unescape(branch.getAttribute("_data"));
	var __data = null;
	if(dStr.trim() != '')
		__data = eval('(' + dStr  + ')');

	var parent_ou = __data ? __data.ou : "";
	var power = __data ? __data.power ? __data.power : "1"  : "";			
	var p =0;
	var aBtn =	_G("aTreeNode");
	var mBtn =	_G("mTreeNode");
	var dBtn =	_G("eTreeNode");

	if((parent_ou == '' && <c:out value='${ACTOR.isAddressBookRole}'/>) || power){
		p=1;
		aBtn.disabled = false;
		mBtn.disabled = false;
		dBtn.disabled = false;
	}else{
		aBtn.disabled = true;
		mBtn.disabled = true;
		dBtn.disabled = true;
		p=0;
 	}

	if(! __data){
		aBtn.disabled = false;
		mBtn.disabled = true;
		dBtn.disabled = true;	
	}
	
	userLstIframe.src = "domainUsers.html?dc=<c:out value='${dc}'/>&depou=" + (__data ? __data.ou : "")  + "&power=" + p;
}

// 打开/折叠
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

var ___deptsData = <c:out value='${deptTreeStr}' escapeXml='false'/>;
window.onload = function(){
//var _btime = (new Date()).getTime();
	switchBranch(_G('rootECBtn'));
	selectBranch(_G('rootECBtn').nextSibling);
//window.status = 	(new Date()).getTime() - _btime;
};
</script>
</html>
