<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="g-title-1 gWel-greeting">
	<h2><c:out value='${greeting}'/></h2>
</div>
<div class="ln-thin ln-c-mid"></div>

				
<div id="gWel-info">
	邮 件：
	<strong class="txt-impt" id="bWelcomeInboxNew"><c:out value="${newMail}"/></strong>
	 封
	<a href="javascript:MailFolders.openUrl('inbox', 'mail/mails.html?folderid=inbox&condition=read|true');">未读邮件</a>
</div>

<div id="wel-tools-box" class="wxPortlet">
	<div class="wxPortletHeader">
		<span class="wxPortletTitle">邮箱推荐</span>
	</div>
	<div class="wxPortletBody">
		<ul>
			<li>
				<b class="first ico-personAddr"></b>
				<a hidefocus="true" href="javascript:SideBar.open('#personAddr', 'personAddr/main.html');">个人通讯录</a>
				<span class="txt-info">存储和查看私人所有联系人信息,便于快速写信</span>
			</li>
			
			<li>
				<b class="first ico-publicAddr"></b>
				<a hidefocus="true" href="javascript:SideBar.open('#publicAddr', 'publicAddr/main.html');">公共通讯录</a>
				<span class="txt-info">查看单位内所有联系人信息,便于快速写信</span>
			</li>
			
			<li>
				<b class="first ico-wel"></b>
				<a hidefocus="true" href="javascript:SideBar.open('#fd_netdisk', 'netdisk/main.html');">网络U盘</a>
				<span class="txt-info">存储文件</span>
			</li>
			
			<li>
				<b class="first ico-pwd"></b>
				<a hidefocus="true" href="javascript:Portal.open('option/main.html?module=personInfo');">个人信息</a>
				<span class="txt-info">查看和修改自己的个人相关信息</span>
			</li>
			
			<li>
				<b class="first ico-space"></b>
				<a hidefocus="true" href="javascript:Portal.open('option/main.html?module=space');">空间管理</a>
				<span class="txt-info">设置邮件空间大小警戒线</span>
			</li>
			
			<li>
				<b class="first ico-sign"></b>
				<a hidefocus="true" href="javascript:Portal.open('option/main.html?module=sign');">邮件签名</a>
				<span class="txt-info">设置个性化邮件签名</span>
			</li>
		</ul>
		<div style="clear: both;"></div>
	</div>
</div>

<script language="javascript">
window.onload = function(){
		var msg = "系统正在收取POP3邮件,请勿中断退出,耐心等待....";
		$('#LoadingMsg1').text(msg).css({"color":"#ff0000"}); 
		$('#LoadingMsg1').text(msg).show();
		$('#LoadingMsg').text("");
		$('#LoadingMsg').hide();
		$.post(
			"portal/charmgroupPop3.json", 
			{
			},
			function(data) {
				if ('yes' != data.res) {
					alert(data.data);
					return;
				}
				$('#LoadingMsg1').hide();
			},
			'json'
		);
		//自动保存完毕后刷新邮件夹
		//MailFolders.refresh(null);
		//var msg = "数据加载中，请稍候..";
		//$('#LoadingMsg').text(msg);
};
</script>				