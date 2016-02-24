<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/user.css" type="text/css" rel="stylesheet">

<script type="text/javascript" src="/DNA/jsDNA/FCKEditor/fckeditor.js"></script>
<script language="javascript">
function checksubmit() {
 	tmp();
	doSubmit();
	_close();
}
function _close() {
	window.parent.frames['contentFrame'].location = "batch.html";
}
 
function tmp(){
 _G("content").value = _G(window.RTEditorId).contentWindow.getRTHTML();
}
 
function doSubmit(){
	document.noticefrm.action = "../email/addbatch.sjs";
	document.noticefrm.submit();
}
 
function showTimerDiv(cb){
	var tdiv = document.getElementById('timerDiv');
	if(cb.checked)
	 	tdiv.style.display = '';
	else
	 	tdiv.style.display = 'none';  
}

//弹出框选择部门
function showOuwin(ou){
	var oudiv = document.getElementById("ouDiv");
	var disType = oudiv.style.display;
	if(disType!=""){
		oudiv.style.display='';
	}
	listDepwin();
}

function listDepwin(){
	var dc ='<c:out value='${dc}'/>';
	depwin = SkyDNA.Element.createPopupWin({title: dc +"部门列表",width: 300,height:350});
	var deptDsProps = {
		dataStruct : {
			'uuid': {title: "UUID", isKey: true},
			'ou': {title: "部门代号", validate: VF_username},
			'description': {title: "部门名称",validate: VF_noEmpty}
		},
		listURL: "../user/getDepts.json?domain=" + dc
	};
				
	var DeptDataSource = new SkyDNA.DataSource(null, deptDsProps);

 	var treeCtr = _CC("div", null, depwin.contentDom);
	treeCtr.style.overflow = "scroll";
	SkyDNA.Enhance.enhance(treeCtr, "dockable", {dock: 'full'});
	
	var treeView = DeptDataSource.createDataTree(treeCtr, {
		title: "部门", 
		titleArg: 'description',
		onSelected: onDeptSelected.bind(this)
	});
	
	DeptDataSource.remoteListData();
}

function onDeptSelected(node){
	var childNote = node.children[0].children[2];
	if(childNote.style.background.indexOf('rgb\(67, 166, 37\)')!=-1 || childNote.style.background.indexOf('#43a625')!=-1){
		alert('不可重复选择！');
		return;
	}
	
	childNote.style.background = "#43A625";
	
	
	var pou = document.getElementById("ou");
	var poudesc = document.getElementById("ou_desc");
	var ou = node.data?node.data.ou:'';
	//var ou = ou==''?'no':ou;
	var desc = node.data?node.data.description:'';
	pou.value += (ou +";");
	poudesc.value+= (desc +";");
	//depwin.dispose();
}

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
<style type="text/css">
	.pgHeadBlock_ {
		height: 41px;
		background-color:#43A625;
		margin-left:10px;
		margin-right:9px;
	}
	#sendBatchTable tr{
		line-height: 162%;
	}
	#sendBatchTable #title {
		width: 100%;
		line-height: 162%;
		height: 25px;
	}
</style>

</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock_">
	<table border=0 width="100%" height="100%" cellspacing="0">
		<tr>
			<td algin="left" width=41 class="title_BarImg"></td>
			<td align="left" id="title_Font1">群发邮件</td>
			<td align="right" id="title_Font2"></td>
		</tr>
	</table>
</div>

<br>
<form method="post" name="noticefrm" enctype= "multipart/form-data">
	<input name="domain" type="hidden" value="<c:out value='${dc }'/>">
	<table id="sendBatchTable" width="100%">
		<tr>
			<td width="60" valign="middle" align="right"><nobr>主题: </nobr></td>
			<td><input id="title" type="text" name="title" id="title" size=50></td>
		</tr>
		<tr id="ou-box" style="width: 100%;">
			<td valign="middle" align="right">发往部门:</td>
			<td>
				<input id="ou_switch" name="ou_switch" value="选择部门" onclick="javascript:showOuwin(this)" type="button"> 
				<span id="ouDiv" name="ouDiv" style="display: none">
					<input type="text" name='ou_desc' id='ou_desc' size='50' readonly="readonly"/>
					<input type="text" name="ou" id="ou" value=""/>
				</span>
				
				(默认所有部门)
			</td>
		</tr>
		<tr>
			<td valign="middle" align="right"><nobr>发送时间: </nobr></td>
			<td>
			<input id="mail_timerchk" name="mail_timerchk" value="yes" onclick="javascript:showTimerDiv(this)" type="checkbox">定时发送
			<span id="timerDiv" style="display: none">
			<select id="timeyear" name="timeryear">
			<script language="javascript" type="text/javascript">
				var date = new Date();
				
				for(var i=0;i<3;i++){
					var year = date.getFullYear()+i;
					 document.write('<option value="' +  year + '">'+ year + '<\/option>');
				}
			</script>
			</select>年
			<select id="timermon" name="timermon">
			<script language="javascript" type="text/javascript">
				var month = date.getMonth()+1;
				for(var i=1 ; i<=12; i++){
					if(month == i){
					  	document.write('<option value="' +  i + '" selected="selected">'+ i.toString() + '<\/option>');
				  	}else{
					  	document.write('<option value="' +  i + '">'+ i.toString() + '<\/option>');
				  	}
				}
			</script>
			</select>月 
			<select id="timerday" name="timerday">
			<script language="javascript" type="text/javascript">
				var day = date.getDate();
				for(i=1; i<=31; i++){
					if(day == i){
						document.write('<option value="' +  i + '" selected="selected">'+ i.toString() + '<\/option>');
					}else{
						document.write('<option value="' +  i + '">'+ i.toString() + '<\/option>');
					}
				}
			</script>			
			</select>日 
			<select id="timerh" name="timerh">
			<script language="javascript" type="text/javascript">
				var hour = date.getHours();
				for(i=0 ; i<=23; i++){
					if(hour == i){
				 		document.write('<option value="' +  i + '" selected="selected">'+ i.toString() + '<\/option>');
				 	}else {
				 		document.write('<option value="' +  i + '">'+ i.toString() + '<\/option>');
				 	}
				}
			</script>				
			</select>时
			<select id="timermin" name="timermin">
			<script language="javascript" type="text/javascript">
				var minute = date.getMinutes();
				for( i=0 ; i<=59; i++){
					if(minute == i){
				 		document.write('<option value="' +  i + '" selected="selected">'+ i.toString() + '<\/option>');
				 	}else {
				 		document.write('<option value="' +  i + '">'+ i.toString() + '<\/option>');
				 	}
				}			
			</script>
			</select>分		
		</span></td>
		</tr>
		<tr>
			<td valign="middle" align="right"><nobr>上传附件: </nobr></td>
			<td colspan="2"><input type="file" name="attfile" id="attfile"></td>
		</tr>
		<tr>
			<td>
				<textarea name="content" id="content" style="display:none"></textarea>
			</td>
			<td id="dvHtmlEditor"></td>
		</tr>
		<tr>	
			<td align="center" colspan="2">
				<input type="button" value="发送" onclick="checksubmit()"/>&nbsp;&nbsp;
			   	<input type="button" value="关闭" onclick="_close()"/>
		   	</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
	window.RTEditorId = "RTEditor_" + Math.random();
	var editArea = _C("div", {style:"width:100%"}, _G("dvHtmlEditor"));
	editArea.innerHTML = '<iframe id="' + RTEditorId + '"  hspace="0" vspace="0" scrolling="auto" frameborder="0"  width="100%" height="300"><\/iframe>';
	(document.getElementById(window.RTEditorId) || document.frames[window.RTEditorId]).src="/DNA/jsDNA/rteditor/MinRTEditor.htm";
	if(typeof(document.noticefrm.content)!='undefined'){
		window.aLoadedIFrame = function (){
			_G(window.RTEditorId).contentWindow.writeRTHTML(document.noticefrm.content.value);
		};
	}
</script>

</body>
</html>
