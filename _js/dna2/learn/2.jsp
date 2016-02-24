<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Scrollable 100% high element</title>
<script type="text/javascript" src="../../jquery/jquery-1.2.6.js"></script>
<script type="text/javascript" src="../../jquery/ui/ui.core.js"></script>
<script type="text/javascript" src="../wx.js"></script>
<link rel="stylesheet"  type="text/css" href="../../../_css/ui.css"></link>
<style type="text/css">
html {
}

body {
	height: 100%;
	overflow: hidden;
}

#spHeader {
	height: 40px;
	background-color: #c3d9ff;
	margin-bottom: 4px;
}

#spFooter {
	clear: both;
	height: 40px;
	background-color: maroon;
}

#spBody {
	background-color: white;

}

#spLeft {
	float: left;
	width: 20%;
	background-color: gray;
	height: 300px;
}

#spRight {
	float: left;
	width: 30%;
	background-color: #eeeeee;
	height: 300px;
}


#spCenter {
	float: right;
	width: 50%;
	background-color: #cccccc;
	height: 300px;
}
</style>
</head>
<body>
	<div id="spHeader">
	</div>
	<div id="spLeft">
	</div>
	<div id="spCenter">
	</div>
	<div id="spRight">
	</div>
	<div id="spFooter">
	</div>

</body>

<script type="text/javascript">
$(document).ready(function() {
	$(window).resize(function() {
		var pos = $("#spLeft").position();
		var outH = $(window).height();
		var footerH = $("#spFooter").height();
		var h = outH - pos.top - footerH;
		//console.debug(pos, outH, footerH, h);
		$("#spLeft").height(h);
		$("#spCenter").height(h);
		$("#spRight").height(h);
	});
});
</script>
</html>
