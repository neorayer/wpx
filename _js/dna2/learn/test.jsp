<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>

<style type="text/css">
* {

}

body {
	margin:0;
	padding:0;
}


li {
	clear: both;
	background-color: #eeeeee;
	padding-left: 10px;
	list-style: none;
}

.box {
	width: 200px;
	height: 50px;
	background-color: #c3d9ff;
	font-size: 12px;
}

.box2 {
	border: 10px solid gray;
}

.box3 {
	padding: 10px;
}


.box4 {
	margin: 10px;
}

.box5 {
	background-color: #cccccc;
	margin: 10px;
	padding: 5px;
	height: 22px;
}

h3 {
	background-color: gray;
	color: white;
	margin:0;
	padding:0;
}

</style>
<body>
<ul>
	<li>
		<h2>Padding & Margin & Border</h2>
		<h3>IE的width是指outerWidth, FF是指innerWidth,指定 !DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN" 后，IE=FF</h3>
		<div>
			<div class="box box1">width: 200px; height: 50px;</div>
			<div class="box box2">border: 10px solid gray;</div>
			<div class="box box3">padding: 10px;</div>
			<div class="box box4">margin: 10px;</div>
		</div>
	</li>
	<li>
		<h2>Inner Margin & Border</h2>
		<h3>IE的margin-top是相对容器（或上一个元素），FF如果没有上一个可视元素，则把margin-top属性交给父类（滑稽！）除非容器有个border,padding!</h3>
		<h3>一个解决方案：FF下 容器style="float:left; clear:both"</h3>
		<div>
			<div class="box" style="float:left; clear:both">
				<div class="box5">
					margin: 10px;
				</div>
			</div>
			<div class="box" style="float:left; clear:both">
				<div class="box5">
					margin: 10px;
				</div>
			</div>
		</div>
	</li>
	<li>
		<h2>overflow:visible (default)</h2>
		<h3>建议：* {overflow: hidden}</h3>
		<div>
			<div class="box" style="overflow:visible">
				<div class="box5" style="height: 100px" >
					overflow:visible
				</div>
			</div>
		</div>
	</li>
	<li>
		margin和Float一起使用的时候要高disply:inline
	</li>
</ul>

<div style="position: absolute;left:0;top:0">
<div style="position:absolute; left:100px; top:100px;background-color: pink;width:200px;height:200px">
	<div  style="position:absolute; left:10px; top:10px;background-color: orange;width:50px;height:50px">
	</div>
</div>
</div>
</body>
</html>