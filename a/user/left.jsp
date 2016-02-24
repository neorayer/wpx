<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/user.css" type="text/css" rel="stylesheet">
<head>
<style type="text/css">
body {
	font-size: 12px;
}

ul {
	padding: 0;
	margin-left: 15px;
}

li {
	list-style: none;
	margin-top: 1px;
	margin-bottom: 1px;
}

li ul {
	display: none;
}

#tree span {
	background-color: transparent;
	color: #666666;
	cursor: pointer;
}

#tree span.on {
	background-color: #008aff;
	padding: 2px 3px;
	color: #fff;
}

#tree span.t {
	padding: 0 3px;
	margin-left: 5px;
}

#tree span.closed {
	background: url(icon/folder_closed.gif) 0 0 no-repeat;
	font-size: 12px;
	padding: 2px 14px 1px 14px;
	margin: 3px 0;
	color: #fff;
}

#tree span.opened {
	background: url(icon/folder_opened.gif) 0 0 no-repeat;
	font-size: 12px;
	margin: 3px 0;
	padding: 2px 14px 1px 14px;
	color: #fff;
}
</style>
</head>
<script>

	//var _btime = (new Date()).getTime();
</script>
<body>
<c:set var="isAddressBookRole" value='${!ACTOR.isAddressBookRole}' />

<div id="tree">
<ul>
	<li><span title="打开/折叠" onclick="switchBranch(this);"
		class="closed">&nbsp;</span><span
		onclick="selectBranch(this);openDomain(this);" class="t">全部子邮局</span>
	<ul>
		<c:forEach var="domain" items="${domains}">
			<li>
				<span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span>
				<span onclick="selectBranch(this);openDomain(this);" class="t"> 
					<c:out value="${domain.dc}" />
				</span>

			<ul>
				<c:if test="${isAddressBookRole}">
					<li>
						<span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span>
						<span onclick="selectBranch(this);openUser('<c:out value="${domain.dc}" />')" class="t">用户</span>
					</li>
				</c:if>
				
				<li>
					<span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span>
					<span onclick="selectBranch(this);openDept('<c:out value="${domain.dc}" />')" class="t">部门</span>
				</li>
				
				<li>
					<span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span>
					<span onclick="selectBranch(this);openGroup('<c:out value="${domain.dc}" />')" class="t">群组</span>
				</li>
				
				<c:if test="${isAddressBookRole}">
					<li>
						<span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span>
						<span onclick="selectBranch(this);openAdmin('<c:out value="${domain.dc}" />')" class="t">管理员</span>
					</li>
					<!-- 
					<li>
						<span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span>
						<span onclick="selectBranch(this);openBatch('<c:out value="${domain.dc}" />')" class="t">群发邮件</span>
					</li>
					
					 
					<li>
						<span title="打开/折叠" onclick="switchBranch(this);"
						class="closed">&nbsp;</span><span
						onclick="selectBranch(this);openQ('<c:out value="${domain.dc}" />')"
						class="t">组用户管理</span>
					</li>
					-->
	
					<li>
						<span title="打开/折叠" onclick="switchBranch(this);" class="closed">&nbsp;</span>
						<span onclick="selectBranch(this);openStyle('<c:out value="${domain.dc}" />')" class="t">风格样式</span>
					</li>
				</c:if>
			</ul>
			</li>

		</c:forEach>
	</ul>
	</li>
</ul>
</div>
</body>
<script language="javascript">

function selectBranch(branch){
	if(!branch) return;
	if(window._selectNode) window._selectNode.className = 't';
	window._selectNode = branch;
	window._selectNode.className = 't on';	
}
function switchBranch(branch){	
	if(!branch.nextSibling) return;
	//selectBranch(branch.nextSibling);
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
function openDomain(node){
	var branch = node.previousSibling;
	if(!branch) return;
	var _ul = branch.parentNode.getElementsByTagName('ul');
	if(_ul.length==0) return;
	var cLst = _ul[0];
	cLst.style.display = 'block';
	branch.isOpened = true;
	branch.className = 'opened';
	return true;
}

// 用户
function openUser(dc) {
	window.parent.frames['contentFrame'].location = "../user/domainUsers.html?dc=" + dc;
}


function openTemplate(dc) {
	window.parent.frames['contentFrame'].location = "../template/template.html?dc=" + dc;
}


// 管理员
function openAdmin(dc) {
	window.parent.frames['contentFrame'].location = "../user/domainAdmins.html?dc=" + dc;
}


function openDomains() {
	//window.parent.frames['contentFrame'].location = "../../vi/domain/listDomain.jsp";
}

function openAB(dc) {
	window.parent.frames['contentFrame'].location = "../../vi/addressbook/domainAddressbook.jsp?dc=" + dc;
}

// 部门
function openDept(dc) {
	window.parent.frames['contentFrame'].location = "../user/domainDept.html?dc=" + dc;
}

//群组
function openGroup(dc) {
	window.parent.frames['contentFrame'].location = "../user/domainGrpUsers?dc=" + dc;
}


function openNotice(dc) {
	window.parent.frames['contentFrame'].location = "../../vi/notice/notice.jsp?dc=" + dc;
}

// 群发邮件 -已废弃
function openBatch(dc) {
	window.parent.frames['contentFrame'].location = "../batch/batch.html?dc=" + dc;
}

// 风格样式
function openStyle(dc) {
	window.parent.frames['contentFrame'].location = "../domain/style.html?type=user&dc=" + dc;  
}

function openbatch(dc) {
	window.parent.frames['contentFrame'].location = "../../vi/batch/sendBatch.jsp?dc=" +dc;
}

function openLog(dc) {
	window.parent.frames['contentFrame'].location = "../../vi/log/logmenu.jsp?dc=" +dc;
}

//组用户管理
function openQ(dc) {
	window.parent.frames['contentFrame'].location = "../user/qUsers.html?dc=" + dc;
}


//main();
openDomain(document.getElementById('tree').getElementsByTagName('span')[1]);

//window.status = (new Date()).getTime() - _btime;
</script>
</html>