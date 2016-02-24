<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="MailAddrBook" class="gWel-tab">
	<div class="tabs">
		<ul>
			<li id="personAddr" class="on"  onClick="iTabClicked('personAddr');">
				个人通讯录
			</li>
			<li  id="publicAddr" onClick="iTabClicked('publicAddr');">
				公共通讯录
			</li>
		</ul>
	</div>
	<div class="pans">
		<div id="personAddrc" class="panel"></div>
		<div id="publicAddrc" class="panel"></div>
	</div>
</div>



<script type="text/javascript">

function iTabClicked(id){
	$('#MailAddrBook .tabs li').removeClass("on");
	$('#MailAddrBook .tabs #'+id).addClass("on");


	$('#MailAddrBook .pans .panel').hide();
	var $body = $('#MailAddrBook .pans #'+id +'c');
	if(!$body.hasClass('opened')) {
		//如果没有打开过，要初始化加载该页面
		$body.load('mail/'+id+'.html');
		//设置是否打开过
		$body.addClass("opened");
	}
	$body.show();
}

$(document).ready(function() {
	//初始化私人通讯录
	iTabClicked('personAddr');

});
</script>