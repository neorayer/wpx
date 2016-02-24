<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="zh" xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>Your Page Title Here</title>
<script type="text/javascript" src="../../jquery/jquery-1.2.6.js"></script>
<script type="text/javascript" src="../../jquery/ui/ui.core.js"></script>
<script type="text/javascript" src="../../jquery/ui/ui.resizable.js"></script>
<script type="text/javascript" src="../wx.js"></script>
<style type="text/css" media="all">
html,body,p,div,img,h1,h2,h3,h4,li,ul,ol,dl,dd,dt,form,table,td,tr {
	margin: 0;
	padding: 0;
	border: 0;
	border-collapse: separate;
	border-spacing: 0;
}

html,body {
	height: 100%;
	overflow: hidden;
}

body {
	padding: 10px; 
/*	margin: 10px; */
}

.wxSplitter {
	border:1px solid gray;
	background-color: #c3d9ff;
	padding: 5px;
	width: 600px;
	height: 300px;
	
	POSITION: relative;
	OVERFLOW: hidden;
}


.wxSplitter-part1 {
	background-color: #cccccc;
	padding: 10px;
	width: 200px;

	OVERFLOW: hidden;
	POSITION: absolute;
}

.wxSplitter-part2 {
	background-color: white;
	padding: 10px;
	height: 300px;
	
	OVERFLOW: auto;
	POSITION: absolute;
	LEFT: 0;
	TOP: 0;
	
}

.wxSplitter-partWraper {
	border:1px solid red;

	OVERFLOW: hidden;
	POSITION: absolute;
	LEFT: 200px;
	width: 300px;
	height: 300px;
}

</style>
</head>

<body>

<div id="wxSplitter" class="wxSplitter">
	<div class="wxSplitter-part1">
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
		part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 part1 <br/>
	</div>
	<div class="wxSplitter-partWraper">
		<div class="wxSplitter-part2">
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
			part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 part2 <br/>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
	var pos = $(".wxSplitter-part1").position();
});
</script>
</body>


</html>