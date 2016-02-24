<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="mail">
	<c:set var="mailHeader" value="${mail.header}"/>
	<c:set var="downableAttachments" value="${attachs}"/>
	<div class="wpxTools"> 
		<table class="menuTable" border="0" cellpadding="0" cellspacing="0" style="float: left;">
			<tr>
				<td>
					<a class="back" href="javascript:Mail.back()">&lt;&lt;返回</a>
				</td>
				<td><a class="button forward" href="javascript:Mail.viCompose('forward')"><span class="title">转发</span></a></td>
				<td>
					<a class="button wxMenuButton reply" href="javascript:">
						<span class="title">回复</span>
						<b class="arr"></b>	
					</a>
					<table class="wxDropMenu">
						<tr><td><a href="javascript:Mail.viCompose('reply')"><span class="title">回复</span></a></td></tr>
						<tr><td><a href="javascript:Mail.viCompose('replyall')"><span class="title">全部回复</span></a></td></tr>
					</table>
				</td>			
				<td><a class="button moveToTrash" href="javascript:Mail.moveTo('trash')"><span class="title">移到废件箱</span></a></td>
				<td>
					<a class="button wxMenuButton moveTo" href="javascript:">
						<span class="title">移到</span>
						<b class="arr"></b>					
					</a>
					<table class="wxDropMenu foldersMenu" border="0" cellpadding="0" cellspacing="0" >

					</table>
				</td>
				<td>
					<a class="button wxMenuButton mark" href="javascript:">
						<span class="title">标记</span>
						<b class="arr"></b>
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a class="markRead" href="javascript:Mail.markRead(true)"><span class="title">标记为已读</span></a></td></tr>
						<tr><td><a class="markUnread" href="javascript:Mail.markRead(false)"><span class="title">标记为未读</span></a></td></tr>
						<tr><td><a class="markReplied" href="javascript:Mail.markReplied(true)"><span class="title">标记为已回复</span></a></td></tr>
					</table>
				</td>
				<td>
					<a class="button wxMenuButton reject" href="javascript:">
						<span class="title">拒收</span>
						<b class="arr"></b>
					</a>
					<table class="wxDropMenu" border="0" cellpadding="0" cellspacing="0" >
						<tr><td><a class="rejectAddress" href="javascript:Mail.rejectAddress('<c:out value="${mailHeader.from.mailAddress}" />')"><span class="title">发件人邮件地址拒收</span></a></td></tr>
						<tr><td><a class="rejectSubject" href="javascript:Mail.rejectSubject('<c:out value="${mailHeader.subject}" />')"><span class="title">主题拒收</span></a></td></tr>
						<tr><td><a class="rejectDomain" href="javascript:Mail.rejectDomain('<c:out value="${mailHeader.from.mailAddress}" />')"><span class="title">发件人域拒收</span></a></td></tr>
					</table>
				</td>
				<td style="display: none;">
					<a class="button download" href="<c:out value='mail/mails_download.html?uuid=${uuid}&folderid=${folderid}' />"><span class="title">下载</span></a>
				</td>
				<td>
					<a class="button delete" href="javascript:Mail.remove()"><span class="title">永久删除</span></a>
				</td>
			</tr>
		</table>
		
		
		<div style="float: right;padding: 8px 10px 0px 0px;">
			<a id="prevMail" href="#">上一封</a>
			<a id="nextMail" href="#">下一封</a>
		</div>
	</div>
	
	<div id="mailView">
		<div id="ctrInfo" class="theme-bg-col theme-bor-col">
			<h3 id="subject">
				<c:if test="${empty mailHeader.subject}">无标题</c:if>
				<c:if test="${not empty mailHeader.subject}"><c:out value="${mailHeader.subject}" /></c:if>
				<a class="btn-mailinfo" hidefocus="true" href="javascript:Mail.toggleInfo()"></a>
			</h3>
			<div id="shortInfo" style="display: none;">
				<span>发件人:<c:out value="${mailHeader.from}" /></span>
				<span>时间: <fmt:formatDate value="${mailHeader.localDate}" type="both" pattern="yyyy年MM月dd日 HH:mm (EEEE)"/></span>
				<a id="openInfo" hidefocus="true" href="javascript:Mail.toggleInfo()">&lt; 完整信息 &gt;</a>
			</div>
			<table id="info" cellpadding="0" cellspacing="0" style="display: block;">
				<tr>
					<td width="50">发件人:</td>
					<td>
						<c:out value="${mailHeader.from}" />
						<c:set var="fromMailAddress" value="${mailHeader.from.mailAddress}"/>
						<a href="javascript:Mail.rejectAddress('<c:out value="${fromMailAddress}" />')"><span class="title">设置邮件地址拒收</span></a>
						<a href="javascript:Mail.rejectDomain('<c:out value="${fromMailAddress}" />')"><span class="title">设置邮件域拒收</span></a>
						<a href="javascript:Mail.addPA('<c:out value="${fromMailAddress}" />')"><span class="title">添加至个人通讯录</span></a>
					</td>
				</tr>
				<tr>
					<td>时　间:</td>
					<td>
						<fmt:formatDate value="${mailHeader.localDate}" type="both" pattern="yyyy年MM月dd日 HH:mm (EEEE)"/>
					</td>
				</tr>
				<tr>
					<td valign="top">收件人:</td>
					<td>
						<c:forEach var="to" items="${mail.to}">
							<p><c:out value="${to}" /></p>
						</c:forEach>
					</td>
				</tr>
				<c:if test="${not empty mail.cc}">
				<tr>
					<td>抄　送:</td>
					<td>
						<c:forEach var="cc" items="${mail.cc}">
							<p><c:out value="${cc}" /></p>
						</c:forEach>
					</td>
				</tr>
				</c:if>
				<tr>
					<td>优先级:</td>
					<td>
						<c:if test="${mailHeader.priority eq '1'}" >(重要邮件<b class="pri1" title="重要邮件"/>)</c:if>
						<c:if test="${mailHeader.priority eq '3'}" >(普通邮件<b class="pri3" title="普通邮件"/>)</c:if>
						<c:if test="${mailHeader.priority eq '5'}" >(不重要邮件<b class="pri5" title="不重要邮件"/>)</c:if>
						
						<a id="openInfo" hidefocus="true" href="javascript:Mail.toggleInfo();">&lt; 精简信息 &gt;</a>
					</td>
				</tr>
				<c:if test="${not empty downableAttachments}" >
				<tr>
					<td>附　件:</td>
					<td>
						<c:out value='${attachSize}'/>个  <a href="main.html#A_attachments">查看全部附件</a>
					</td>
				</tr>
				</c:if>
			</table>
		</div>
		
		
		<iframe id="contentFrame" src="<c:out value='mail/mailContent.html?folderid=${folderid}&uuid=${uuid}' />" scrolling="no" width="100%" height="100%" frameborder="no" onload="dyniframesize();" onresize="dyniframesize();" name="<c:out value='contentIframe_${uuid}' />" frameborder="0">
		</iframe>
		
		
		<c:if test="${not empty downableAttachments}">
		<a name="A_attachments"></a>
		<div id="attachments" name="attachments" class="wxbox">
			<div class="title">附件（<c:out value='${attachSize }'/>个）</div>
			<div class="body">
				<c:forEach var="attach" items="${downableAttachments}" >
					<p>
						<span class="name">附件：
							<a class="download" href="<c:out value="mail/attachment.down?name=${attach.fileName}&path=${attach.shortPath}&uuid=${uuid}" />" >
								<c:out value="${attach.fileName }"/>
							</a>
						</span>
						<span class="size">
							<c:out value="${attach.tgmkSize }"/>k
						</span>
					</p>
				</c:forEach>
			</div>
		</div>
		</c:if>
		
		
		<div id="fastRestore" class="theme-bg-col theme-bor-col" style="<c:if test='${isPostmaster}'>display:none;</c:if>">
			<div class="title">
				<div class="strong">快捷回复</div>
				<div id="restoreBody">
					<span>该邮件发送成功</span>
					<a href="javascript:Mail.showRestore();">再回一封邮件</a>
				</div>
			</div>
			<div class="inputBody theme-bor-col">
				<textarea id="fastRestoreArea"></textarea>
				<a class="btn-big" href="javascript:Mail.fastRestore();">发送</a>
			</div>
		</div>
		
 	</div>

</div>


<script type="text/javascript">
//** iframe自动适应页面 **//

//输入你希望根据页面高度自动调整高度的iframe的名称的列表
//用逗号把每个iframe的ID分隔. 例如: ["myframe1", "myframe2"]，可以只有一个窗体，则不用逗号。

//定义iframe的ID
var iframeids=["contentFrame"]

//如果用户的浏览器不支持iframe是否将iframe隐藏 yes 表示隐藏，no表示不隐藏
var iframehide="no"

function dyniframesize()
{
	var dyniframe=new Array()
	for (i=0; i<iframeids.length; i++)
	{
		if (document.getElementById)
		{
			//自动调整iframe高度
			dyniframe[dyniframe.length] = document.getElementById(iframeids[i]);
			if (dyniframe[i] && !window.opera)
			{
				dyniframe[i].style.display="block"
				if (dyniframe[i].contentDocument && dyniframe[i].contentDocument.body.offsetHeight) //如果用户的浏览器是NetScape
					dyniframe[i].height = dyniframe[i].contentDocument.body.offsetHeight;
				else if (dyniframe[i].Document && dyniframe[i].Document.body.scrollHeight) //如果用户的浏览器是IE
					dyniframe[i].height = dyniframe[i].Document.body.scrollHeight;
			}
		}
		//根据设定的参数来处理不支持iframe的浏览器的显示问题
		if ((document.all || document.getElementById) && iframehide=="no")
		{
			var tempobj=document.all? document.all[iframeids[i]] : document.getElementById(iframeids[i])
			tempobj.style.display="block"
		}
	}
}

if (window.addEventListener)
	window.addEventListener("load", dyniframesize, false)
else if (window.attachEvent)
	window.attachEvent("onload", dyniframesize)
else
	window.onload=dyniframesize

//-->
</script> 


<script type="text/javascript">
Mail.uuid= '<c:out value="${uuid}" />';
Mail.folderid= '<c:out value="${folderid}" />';

$(document).ready(function() {
	/********** Enahnce menuButton **********/
	Enhance.menuButton();
	
	/********** 上一封 下一封 邮件 **********/
	var mailTr = $('#pgMailList tr#<c:out value="${uuid}" />');
	
	var prev_id = mailTr.prev().attr("id");
	if(prev_id != "" && prev_id != 'undefined'){
		$('#prevMail').attr("href", "javascript:Mail.openMail('" + prev_id + "');");
	}
	else{
		$('#prevMail').hide();
	}
	
	var next_id = mailTr.next().attr("id");
	if(next_id != "" && next_id != 'undefined'){
		$('#nextMail').attr("href", "javascript:Mail.openMail('" + next_id + "');");
	}
	else{
		$('#nextMail').hide();
	}
	
	/********** foldersMenu **********/
	var foldersHtml = '';
	for(var i=0;i<MailFolders.sysFolders.length;i++ ){
		var f = MailFolders.sysFolders[i];
		foldersHtml+='<tr><td><a href=\"javascript:Mail.moveTo(\''+ f.id +'\')\"><span class=\"title\">'+ f.name +'</span></a></td></tr>'
	}
	for(var i=0;i<MailFolders.myFolders.length;i++ ){
		var f = MailFolders.myFolders[i];
		foldersHtml+='<tr><td><a href=\"javascript:Mail.moveTo(\''+ f.id +'\')\"><span class=\"title\">'+ f.name +'</span></a></td></tr>'
	}
	$('.foldersMenu').html(foldersHtml);
	
	
	
	/********** 快速回复 **********/
	<c:if test='${!isPostmaster}'>
	var restore = '给<c:out value='${mailHeader.from}' escapeXml="false"/>快速回复';
	$("#fastRestoreArea")
		.val(restore)
		.focus(function() {
			var v = $.trim(this.value);
			if(v == restore) {
				this.value = '';
				this.style.color="#000";
			}
		})
		.blur(function() {
			var v = $.trim(this.value);
			if(v == '') {
				this.value = restore;
				this.style.color="#ADADAD";	
			}
		});
	</c:if>
	
	/********** 下载路径编码 **********/
	$(".download").each(function() {
		var url =$(this).attr("href");
		url = encodeURI(url);
		
		$(this).attr("href", url);
	});
});

</script>


