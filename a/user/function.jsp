<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<title></title>
</head>
<body>
<div id="mainDiv">
</div>
</body>
<script type="text/javascript">
function crTabBox(){
	var theDiv = _G("mainDiv");
	var arr1 = ["添加新用户","用户管理","被暂停用户","可删除用户","部门管理"];
	var arr2 = ["adduser","listusers","listpauseusers","listcloseusers","listdepartments"];
	with(SkyDNA.Element) {
		with(createTabBox(theDiv)){
			for(var i=0;i<arr1.length;i++){
				if(i == 0)
					addTab(arr1[i],{onOpen: openFrame.bind(this,arr2[i])}).setDown(true);
				else
					addTab(arr1[i],{onOpen: openFrame.bind(this,arr2[i])});
			}
		}
	}
}

function openFrame(name){
	window.parent.frames["usersFrame"].location = name + ".jsp";
}
crTabBox();
</script>
</html>