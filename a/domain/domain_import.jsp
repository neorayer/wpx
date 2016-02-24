<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet" />
<link href="../_css/domain.css" type="text/css" rel="stylesheet" />
<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/domain.png', sizingMethod='crop');
}
</style>
<![endif]-->
<style type="text/css">
#ldifBlock,
#csvBlock {
	margin-top:10px;
	margin-bottom:10px;
	margin-left: 10px;
}
</style>
</head>
<body>
<div>
<div class="pgHeadBlock">

<table border=0 width="100%" height="100%" cellspacing="0"><tr>
<td algin="left" width=41 class="title_BarImg"></td>
<td align="left" id="title_Font1">数据导入</td>
<td align="right" id="title_Font2"></td></tr></table>
</div>

</div>
<div id="toolsBlock"></div>
<div id="ldifBlock"></div>
<div id="csvBlock"></div>
</body>
<script type="text/javascript">
var res = "<c:out value='${REASON}'/>";
if (res.trim() != "") {
	alert(res);
}
function main() {
	with(SkyDNA.Element) {
		//var ldifPanel = createSimplePanel(_G("ldifBlock"), "LDIF格式数据导入");
		var ldifPanel = _C("div", {}, _G("ldifBlock"));
		ldifPanel.style.height=200;
		//var d = _C("div", {}, ldifPanel);
		//var v = _C("div", {className: 'commentBlock'}, d, "");
		_CC("br", null, ldifPanel);
		//var dd= _CC("div", {}, d);
		buildForm(ldifPanel, 'ldif');
		

		//var csvPanel = createSimplePanel(_G("csvBlock"), "CSV格式数据导入");
		var csvPanel = _C("div", {}, _G("csvBlock"));
		_C("div", {className: 'commentBlock'}, csvPanel, "CSV（ Comma Separated Values）即“逗号分隔值”。它是一种纯文本格式，用于存储数据，它经常使用的软件是电子表格或数据库。在CSV文件中，数据的“字段”由逗号分隔开。程序通过读取文件为数据重新创建正确的字段，并在每次遇到逗号时开始新的一段。");
		_CC("br", null, csvPanel);
		buildForm(csvPanel, 'csv');
	}
}

function buildForm(ctr, type) {
	/*
	var theForm = _C("form", {
			method :'post',
			action :'../../do/domain/import.jsp',
			enctype :"multipart/form-data"
			},
		ctr
	);
	_C("input", {type: 'file', name: 'file'}, theForm);
	_C("input", {type: 'hidden', name: 'type', value: type}, theForm);
	_C("input", {type: 'Submit', value:"上传"}, theForm);
	*/
	
	if(type=='ldif'){
		var  ldifframe = _C("iframe", {src: "about:blank",id:"iframe",frameBorder:0,border:0,style:{border:'none'}}, ctr);
		SkyDNA.Enhance.enhance(ldifframe, "dockable", {dock: 'full'});	
		ldifframe.src = "uploadLDIF.jsp";
	}
}


main();
</script>
</html>
