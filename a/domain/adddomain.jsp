<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../do/portal/include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
</head>
<script language="javascript">
	function check(){
	var name=document.getElementById("name").value;
	var usermax=document.getElementById("usermax").value;
	var size=document.getElementById("size").value;
	var boxsize=document.getElementById("boxsize").value;
	if(name==""){
		alert("域名不能为空!");
		return false;
	}
	else if(usermax!="" && !IsInteger(usermax)){
	   alert("请注意用户数量的填写!");
	   return false;
	}
	else if(size!="" && !IsInteger(size)){
		alert("请注意子邮局容量大小设置!");
		return false;	
	}
	else if(boxsize!="" && !IsInteger(boxsize)){
		alert("请注意默认用户邮箱大小设置!");
		return false;	
	}
	return true;
	}
	function IsInteger(strInteger) {
		return (strInteger.search(/^(-|\+)?\d+$/) != -1);
 }

</script>
<body>
<div id="domainListBlock" align="center"></div>
</body>
<script language="javascript">
	function crForm() {
	with(SkyDNA.Element) {
		with(createForm(_G("domainListBlock"),{formURL:"../../do/domain/adddomain.jsp"})) {
			addInputText("name", "域名：");
			addInputText("usermax", "用户数量:");
			addInputText("size", "域总容量大小:");
			addInputText("boxsize", "默认用户邮箱大小:");
			addInputText("description", "说明：");
			addSelect("applytype", "用户申请类型：", {optionMap: {"auth": "管理员审核","open":"直接开通"}});
			
			addSubmit();
		}
	}
	}
	
	crForm();
</script>
</html>
