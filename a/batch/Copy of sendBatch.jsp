<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	//_close();
 }
 
 function _close(){
 	parent._cPopWin();
 }
 
 function tmp(){
	 _G("content").value = _G(window.RTEditorId).contentWindow.getRTHTML();
 }
 
 
 function quicksubmit() {
  	tmp();
	//document.noticefrm.submit();
	doSubmit();
 }
 
 function changegroup() {
	var groupswitch = document.getElementById("groupswitch");
  	var groupdiv = document.getElementById("groupdiv");
  	if(!groupswitch.checked){
  		groupdiv.innerHTML="";
  		return;
  	}
  	var owner = document.getElementById("owner").value;
  	var x = doRequest("groups.jsp?domain="+owner);
  	groupdiv.innerHTML=x;
 }
 
 function IsInteger(strInteger) {
  		return (strInteger.search(/^(-|\+)?\d+$/) != -1);
 }
 
 function doSubmit(){
	document.noticefrm.action = "../batch/addbatch.sjs";
 	document.noticefrm.submit();
 }
 
 function showTimerDiv(cb){
 var tdiv = document.getElementById('timerDiv');
 if(cb.checked)
  	tdiv.style.display = '';
 else
  	tdiv.style.display = 'none';  
}

function showOuwin(ou){
	var oudiv = document.getElementById("ouDiv");
	if(ou.checked){
		oudiv.style.display='';
		listDepwin();
	}
	else
		oudiv.style.display='none';
}

function listDepwin(){
	depwin = SkyDNA.Element.createPopupWin({title: "<c:out value='${dc}'/>"+"部门列表",width: 300,height:260});
	var deptDsProps = {
		dataStruct : {
			'uuid': {title: "UUID", isKey: true},
			'ou': {title: "部门代号", validate: VF_username},
			'description': {title: "部门名称",validate: VF_noEmpty}
		},
		listURL: "../user/getDepts.json?domain=<c:out value='${dc}'/>"
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
	var pou = document.getElementById("ou");
	var poudesc = document.getElementById("ou_desc");
	var ou = node.data?node.data.ou:'';
	//var ou = ou==''?'no':ou;
	var desc = node.data?node.data.description:'';
	pou.value= ou;
	poudesc.value = desc;
	depwin.dispose();
}
	
</script>
</head>
<body bgColor="#FFFFFF" style="margin:0;padding:0;">
<form method="post" name="noticefrm"   enctype= "multipart/form-data">
	<table width="100%">
		<tr>
		<td width="30" valign="middle" align="right"><nobr>主题: </nobr></td>
			<td><input type="text" name="title" id="title" size=50></td>
		</tr>
		<tr>
			<td width="30" valign="middle" align="right"><nobr>发往域: </nobr></td>
			<td><select name="domain" id="domain">
					<option value="<c:out value='${dc}'/>"><c:out value='${dc}'/></option>
				</select></td>
		</tr>
		<tr>
			<td width="30" valign="middle" align="right">发往部门:</td>
			<td>
				<input id="ou_switch" name="ou_switch" value="yes" onclick="javascript:showOuwin(this)" type="checkbox">
				<span id="ouDiv" name="ouDiv" style="display: none">
					<input type="text" name='ou_desc' id='ou_desc' size = '15'/>
					<input type="hidden" name="ou" id="ou" value=""/>
				</span>
			</td>
		</tr>
		<tr>
			<td width="30" valign="middle" align="right"><nobr>发送时间: </nobr></td>
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
				for(var i=1 ; i<=12; i++){
				  document.write('<option value="' +  i + '">'+ i.toString() + '<\/option>');
				}
			</script>							
			</select>月 
			<select id="timerday" name="timerday">
			<script language="javascript" type="text/javascript">
				for(i=1; i<=31; i++){
				  document.write('<option value="' +  i + '">'+ i.toString() + '<\/option>');
				}
			</script>			
			</select>日 
			<select id="timerh" name="timerh">
			<script language="javascript" type="text/javascript">
				for(i=0 ; i<=23; i++){
				  document.write('<option value="' +  i + '">'+ i.toString() + '<\/option>');
				}
			</script>				
			</select>时
			<select id="timermin" name="timermin">
			<script language="javascript" type="text/javascript">
				for( i=0 ; i<=59; i++){
				  document.write('<option value="' +  i + '">'+ i.toString() + '<\/option>');
				}			
			</script>
			</select>分		
		</span></td>
		</tr>
		<tr><td width="30" valign="middle" align="right"><nobr>上传附件: </nobr></td>
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
