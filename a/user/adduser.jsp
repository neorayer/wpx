<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.skymiracle.wpxadmin.service.*"
	import="com.skymiracle.wpx.conf.*"
	import="com.skymiracle.wpx.conf.service.*"
	import="com.skymiracle.wpxadmin.branch.dao.*"%>
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
</head>
<body>
<script language="javascript">
   function check(){
     var name=document.getElementById("name").value;
     var password=document.getElementById("password").value;
     var repeat=document.getElementById("repeat").value;
     var size=document.getElementById("size").value;
     var messageSize=document.getElementById("messageSize").value;
     var maxcc=document.getElementById("maxcc").value;
     if(name == ""){
		alert("用户名不能为空!");
		return false;     
     }
     else if(name.length<4){
        alert("用户名长度不能小于4!")
        return false;
     }
     else if(password==""){
     	alert("密码不能为空!")
     	return false;
     }
     
     else if(password.length<6){
     	alert("密码长度不能小于6!")
     	return false;
     }
     else if(password!=repeat){
     	alert("重复密码错误,请确认!")
     	return false
     } 
     else if(size!="" && !IsInteger(size)){
        alert("邮箱大小应该填写数字!")
     	 return false;
     }
     else if(messageSize!="" && !IsInteger(messageSize)){
        alert("信件大小应该填写数字!")
     	 return false;
     }
     else if(maxcc!="" && !IsInteger(maxcc)){
        alert("最大发送人数应该填数字!")
     	 return false;
     }
     else 
     		return true;
 }
 
   function IsInteger(strInteger) {
  		return (strInteger.search(/^(-|\+)?\d+$/) != -1);
 }
 
 function doRequest(uuUrl) {
	var x = "";
	try {
		if (window.XMLHttpRequest)
			xmlHttpReq = new XMLHttpRequest();
		else 
			try {
          		xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
       		} catch (e) {
          		try {
             		xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
          		} catch (e) {
          		}
       		}
 		xmlHttpReq.open("GET", uuUrl, false);
       xmlHttpReq.setRequestHeader("Pragma", "no-cache");
 		xmlHttpReq.send(null);
		x = xmlHttpReq.responseText;	
	}catch(e) {
		alert(e);
	}
	return x;
}

 function checkUserExsit() {
 	var name = document.getElementById("name").value;
 	if(name==""){
 		alert("用户名为空");
 		return;	
 	}
	var x = doRequest("../../do/account/checkuserexist.jsp?name="+name);
	while(x.indexOf("\r") != -1){
		x = x.replace("\r","");
	}
	while(x.indexOf("\n") != -1){
		x = x.replace("\n","");
	}
	alert(x);
}

function changename(){
	var e1 = document.getElementById("sn").value;
	var e2 = document.getElementById("givenName").value;
	var e3 = document.getElementById("displayname");
	e3.value = e1 + e2;
}
</script>
<div id="accountListBlock" align="center">
</div>
</body>

<script language="javascript">
	function crForm() {
	with(SkyDNA.Element) {
		with(createForm(_G("accountListBlock"),{formURL:"../../do/account/adduser.jsp"})) {
			addInputText("domain", "域名：",{value:""});
			addInputText("name", "用户名：", {validate: VF_SafeStr});
			addInputPassword("password", "密码：", {validate: VF_passwd});
			addInputPassword("repeat", "密码确认：");
			addSelect("department", "部门：", {optionMap: {"": "无部门"}});
			addInputText("sn","姓:");
			addInputText("givenName","名:");
			addInputText("displayname","姓名：");
			addSelect("description","类型：",{optionMap: {"person":"个人","unit":"单位"}});
			addInputText("manager","管理者：");
			addInputText("employeeid","证件号：");
			addCheckBox("ispop3","开通pop3：",{value:"1"});
			addCheckBox("issmtp","开通smtp：",{value:"1"});
			addCheckBox("isproxy","开通上网：",{value:"0"});
			addInputText("maxcc","最大发送人数：");
			addInputText("size","邮箱大小：",{value:""});
			addInputText("messageSize","发送信件大小限制(含附件)：",{value:""});
			addInputText("location","存储位置：",{value:"<%=ConfFactory.getWpxConf().getMbapMailBoxClassImplConf().getMBAPHost().getIP()%>:<%=ConfFactory.getWpxConf().getMbapServiceConf().getPort()%>"});
			addSubmit();
		}
	}
	}
	
	crForm();
</script>
</html>
