<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="Option" class="gWel-tab">
	<div class="tabs">
		<ul>
			<li id="personInfo"  class="on" onClick="iTabClicked('personInfo');">
				个人信息
			</li>
			<li  id="password" onClick="iTabClicked('password');">
				密码管理
			</li>
			<li id="space" onClick="iTabClicked('space');">
				空间管理
			</li>
			
			<li id="sign" onClick="iTabClicked('sign');">
				邮件签名
			</li>
			<li id="restore" onClick="iTabClicked('restore');">
				自动回复
			</li>
			<li id="forward" onClick="iTabClicked('forward');">
				邮件转发
			</li>
			<li id="common" onClick="iTabClicked('common');">
				常规设置
			</li>
			<li id="reject" onClick="iTabClicked('reject');">
				拒收设置
			</li>
		</ul>
	</div>
	<div class="pans">
		<div id="personInfoc" class="panel"></div>
		<div id="passwordc" class="panel"></div>
		<div id="spacec" class="panel"></div>
		<div id="signc" class="panel"></div>
		<div id="restorec" class="panel"></div>
		<div id="forwardc" class="panel"></div>
		<div id="commonc" class="panel"></div>
		<div id="rejectc" class="panel"></div>
	</div>
</div>




<script language="javascript">
function iTabClicked(id){
	iTabClickedUrl(id, 'option/'+id+'.html');
}

function iTabClickedUrl(id, url) {
	$('#Option .tabs li').removeClass("on");
	$('#Option .tabs #'+id).addClass("on");

	$('#Option .pans .panel').css("display", "none");
	$('#Option .pans #'+id +'c')
		.load(url)
		.css("display", "block");
}

iTabClicked('<c:out value='${module}'/>');


</script>
