<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.skymiracle.wpxadmin.service.*" %>
<%@ page language="java" import="com.skymiracle.wpxadmin.branch.dao.*" %>
<%//@include file="../../do/portal/checkDomain.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="../../style/style.css" type="text/css" rel="stylesheet">

<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" language="JAVASCRIPT">
function check(){
   var name = document.getElementById("name").value;
   var desc = document.getElementById("description").value;
   if(name==""){
   		alert("代号不能为空");
   		return false;
   }else if(desc==""){
   		alert("名称不能为空");
   		return false;
   }
   return true;
}

function setAll(s){
   for (var i=0;i<document.listdep.elements.length;i++){
      var e=document.listdep.elements[i];
      if ("checkbox" == e.type)
         e.checked = s;
   }
}

function checkSelected() {
	var ids = new Array();
	var temps = document.listdep.elements;
   for (var i=0;i<temps.length;i++) {
       var e=temps[i];
       if ("checkbox" == e.type && e.checked)
          ids.push(e.value);
    }
   if(ids.length <= 0){
       alert("选择至少一个部门");
      	return false;
    }
   return true;
}

function del(){
     if(!checkSelected())
     	return;
     if(!confirm("你确定要删除这个部门吗?"))
     	return;
     document.listdep.submit();
}

function combinate(){
	var deparr = new Array();
	var temps = document.listdep.elements;
   for (var i=0;i<temps.length;i++) {
       var e=temps[i];
       if ("checkbox" == e.type && e.checked)
            deparr[i]=e.value;
           // alert(deparr[i]);
    }
    var paragarr = new Array();
    var j =0;
	for(var i = 0;i<deparr.length;i++){
		if(undefined!=deparr[i]){
			paragarr[j]=deparr[i];
			j++;
			}
	}
	if(2>paragarr.length){
		alert("至少选择2个部门!");
		return false
	}else{
		var paraString='';
		for(var i=0;i<paragarr.length;i++){
		paraString = paraString + paragarr[i]+",";
	}
	
	
	//document.location.href = "combinate.jsp?cuuids="+paraString;
	document.getElementById("cuuids").value = paraString;
	document.getElementById("combinateForm").submit();
	
	}
	
}

function test(){
	alert(document.getElementById("cuuids").value);
	return false;
}

</script>
</head>
<body>
<div id="accountInfoBlock"></div>
<div id="accountListBlock">
									<form id="listdep" name="listdep" method="post" action="../../do/account/deletedepartment.jsp">
									<div class="listTableBarBlock">
									<%
									//Department[] departments = DepartmentService.getDepartments(domain);
									//for(int i = 0; i < departments.length; i++){
									//	if(departments[i].getL()==null)
									//		DepartmentService.modDepartment(departments[i].getName(),domain,departments[i].getDescription());
									//}
									%>
									<center><nobr>
									<input type="button" value="全选" onclick="setAll(true)">
									<input type="button" value="不选" onclick="setAll(false)">
									<input type="button" value="删除"  onclick="del()">
									<input type="button" value="合并" onclick="combinate()">
									</nobr>
									</center>
									</div>
									<table id="listTable" width="100%">
									<tr>
									<td>&nbsp;</td><td>部门代号</td><td>部门名称</td>
									</tr>
									<tr><td colspan="3">没有可显示的部门信息</td></tr>
									
									
									</table>	</form>
	</div>								
				<form id="combinateForm" name="combinateForm" method="post" action="combinate.jsp" onsubmit="return test()">
					<input type="hidden" id="cuuids" name="cuuids" value="">
				</form>
			
</body>
<script language="javascript">
	function crForm() {
	with(SkyDNA.Element) {
		with(createForm(_G("accountInfoBlock"),{formURL:"../../do/account/adddepartment.jsp"})) {
			addInputText("name", "部门代号：");
			addInputText("description", "部门名称：");
			addSubmit();
		}
	}
	}
	
	crForm();
</script>
</html>