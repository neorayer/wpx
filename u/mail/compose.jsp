<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript">

tinyMCE.init({
	// General options	
	mode: "exact",
	elements: "content",
	language: "zh",	
	theme : "advanced",
	fontSize: "12px",
	plugins : "safari,layer,advhr,advlink,emotions,inlinepopups,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable",
	// Theme options
	theme_advanced_buttons1 : "bold,italic,underline,|,justifyleft,justifycenter,justifyright,justifyfull,formatselect,fontselect,fontsizeselect",
	theme_advanced_buttons2 : "forecolor,backcolor,|,bullist,numlist",
	theme_advanced_buttons3 : "",
	theme_advanced_toolbar_location : "top",	
	theme_advanced_toolbar_align:"left",
	theme_advanced_fonts:"宋体=宋体;黑体=黑体;仿宋=仿宋;楷体=楷体;隶书=隶书;幼圆=幼圆;Arial=arial,helvetica,sans-serif;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Tahoma=tahoma,arial,helvetica,sans-serif;Times New Roman=times new roman,times;Verdana=verdana,geneva;Webdings=webdings;Wingdings=wingdings,zapf dingbats",
	convert_fonts_to_spans:true,
	remove_trailing_nbsp:true,
	remove_linebreaks:false,
	width : "100%",
	relative_urls:false,
	theme_advanced_resizing : true,

	// Example content CSS (should be your site CSS)
	content_css : "",

	// Drop lists for link/image/media/template dialogs
	template_external_list_url : "lists/template_list.js",
	external_link_list_url : "lists/link_list.js",
	external_image_list_url : "lists/image_list.js",
	media_external_list_url : "lists/media_list.js"

});
</script>
<script type="text/javascript">
if('${ccs}'!=''){
	Compose.ccToggle();
}
</script>

<!--[if IE]>
<style type="text/css">
</style>
<![endif]-->
<!--[if lt IE 7]>

<![endif]-->
<!--[if IE 7]>

<![endif]-->

<div id="pgCompose" class="theme-bg-col" style="width: 100%">
	<div class="wpxTools">
		<table class="menuTable" width='100%' style="margin-top: 4px;">
		<tr>
			<td>
				<table class="wxButtons">
					<tr>
						<td>
							<a class="button send" href="javascript:Compose.sendMail();"><span>发送</span></a>
						</td>
						<td>
							<a class="button save" href="javascript:Compose.saveDraft(false);"><span>保存草稿</span></a>
						</td>
						<td>
							<a id="cancelBtn" class="button cancel" href="javascript:Compose.close();"><span>关闭</span></a>
						</td>
					</tr>
				</table>
			</td>
			<td align="right" width="25%">
				<table class="wxButtons" style="margin-right: 10px;float: right;">
					<tr>
						<td>
							<a id="addrbook" class="button addrbook" href="javascript:Compose.toggleAddrbook();"><span>通讯录</span></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
	</div>
	
	<table id="composeMainTable">
	<tr>
		<td valign="top" style="padding: 0 10px;">
			<form id="composeForm" target="hiddenIframe" action="mail/compose.sjs" method="post" enctype="multipart/form-data" >
				<input type="hidden" id="mailFrom" name="mailFrom" value="<c:out value='${LoginMail}'/>"/>
				<input type="hidden" id="uuid" name="uuid" value="<c:out value='${uuid }'/>"/>
				<input type="hidden" id="parentuuid" name="parentuuid" value="<c:out value='${parentuuid }'/>"/>
				<input type="hidden" name="folderid" value="<c:out value='${folderid }'/>"/>
				
				<table id="formTable">
					<tr>
						<th>发件人</th>
						<td>
							<span style="display: block;float: left;"><c:out value='${LoginMail}'/></span>
							<span style="display: block;float: right;">
								<a id="ccToggle" href="javascript:Compose.ccToggle();">抄送</a>
								<a id="bccToggle" href="javascript:Compose.bccToggle();">密送</a>
							</span>
						</td>
					</tr>
					<tr>
						<th>收件人</th>
						<td height="55">
							<textarea id="tos" class="checked" name="tos"><c:out value='${tos}' /></textarea>
						</td>
					</tr>
					<tr id="ccRow">
						<th>抄　送</th>
						<td>
							<textarea id="ccs"  name="ccs"><c:out value='${ccs}' /></textarea>
						</td>
					</tr>
					<tr id="bccRow">
						<th>密　送</th>
						<td>
							<textarea id="bccs"  name="bccs"><c:out value='${bccs}' /></textarea>
						</td>
					</tr>
					<tr>
						<th>标　题</th>
						<td>
							<input id="subject" name="subject" type="text" value="<c:out value='${subject}' />"  />
						</td>
					</tr>
					<tr>
						<th>附　件</th>
						<td>
							<input class="attach-input" name="attach" type="file" />
							<span style="color: #CCCCCC;">您最大能上传20M的附件</span>
							<table id="attachs">
								<c:forEach var="attach" items="${attachs}">
									<tr>
										<td></td>
										<td><c:out value="${attach.fileName}" /></td>
										<td>
											<input class="file" name="attachOnSite" value="<c:out value='${attach.fileName}|||||${attach.filePath}' />" type="hidden"/>
											<a class="delAttachOnSite" href="javascript:">删除</a>
										</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
					<tr><td height="8" colspan="2"></td></tr>
					<tr>
						<td colspan="2">
							<textarea id="content" name="content" rows="25">
								<c:if test="${not empty content && !isOpenDraftMail}">
									<p></p>
									<div style="border-left:2px solid #cccccc;padding:5px;">
									------------------------------ 原文 ------------------------------ <br/>
										<div>
											<p><b>发件人：</b><c:out value="${orig_from}" /></p>
											<p><b style="display: block;float: left;">收件人：</b><span style="display: block;float: left;"><c:out value="${orig_tos}" /></span></p>
											<c:if test="${not empty orig_ccs}" >
												<p style="clear: both;"><b>抄　送：</b><c:out value="${orig_ccs}" /></p>
											</c:if>
											<p style="clear: both;"><b>标　题：</b><c:out value="${orig_subject}" /></p>
											<p><b>日　期：</b><c:out value="${orig_date}" /></p>
										</div>
										<hr />
										<c:out value='${orig_content}' />
									</div>
								</c:if>
								<c:if test="${isOpenDraftMail}">
									<c:out value='${orig_content}' />
								</c:if>
							</textarea>
						</td>
					</tr>
					
				</table>
				
				<div id="ctrOptions">		
					<select id="mailInk" name="mailInk">
						<option value="-1" selected="selected">不使用邮件签名</option>
						<c:forEach var="ink" items="${inks}">
							<option value="<c:out value='${ink.uuid}' />" ><c:out value="${ink.name}" /></option>
						</c:forEach>
					</select>
					重要性
					<select id="priority" name="priority">
						<option value="3" style="background-color: rgb(255, 255, 255);" selected="selected">普通</option>	
						<option value="1" style="background-color: rgb(255, 0, 0);">重要</option>
						<option value="5" style="background-color: rgb(255, 255, 0);">不重要</option>		
					</select>
					
					<input id="isSend" name="isSend" type="hidden" value="false" />
					
					<input id="isSafeDraft" name="isSafeDraft" type="checkbox" value="true" /> 保存到［草稿箱］
					
					<input id="isSafeSent" name="isSaveSent" type="checkbox" value="true" <c:if test="${ACTOR.savenew eq 1}">checked="checked"</c:if>/> 保存［已发送邮件］
					
					<input id="isReceipt" name="isReceipt" type="checkbox" value="true" /> 要求回执
					
					<input id="isTimerSend" name="isTimerSend" type="checkbox" value="true" /> 定时发送
					
					<div id="timerSend">
						<input id="sendDate" name="sendDate" type="text" />
		
						<select id="sendHour" name="sendHour">
							<c:forEach var="hour" begin="0" end="23" step="1" >
							<option value="<c:out value='${hour}' />" ><c:out value='${hour}' /></option>
							</c:forEach>
						</select>时
						<select id="sendMin" name="sendMin">
							<c:forEach var="min" begin="0" end="59" step="1" >
							<option value="<c:out value='${min}' />" ><c:out value='${min}' /></option>
							</c:forEach>
						</select>分		
					</div>					
				</div>	   
			</form>
		</td>
		<td id="rightSide" valign="top" width="250"></td>
	</tr>
	</table>

	<iframe id="hiddenIframe" name="hiddenIframe" style="display:none" ></iframe>
</div>


<script type="text/javascript" language="javascript">
var inks = <c:out value="${inksJson}" escapeXml="false" />;

$(document).ready(function() {
	document.getElementById("tos").focus();
	
	Compose.enhanceAutoComplete();
		
	$("#pgCompose form#composeForm input.attach-input").livequery('change',function() {
		var filename = getFileName($(this).val());
		$(this).css("display", "none").appendTo;
		$(this).parent().prepend('<input class="attach-input" name="attach" type="file" />');
		
		$(this).remove();
		
		var table = $('#pgCompose form#composeForm table#attachs');
		var iconUrl = "_imgs/icons/" + getIcon(filename);
		table.append('<tr><td></td><td  class="filename"><img align="absmiddle" src="' + Portal.ProjectBase + iconUrl +'" />' + filename + '</td><td><a class="delAttach" href="javascript:">删除</a></td></tr>');
		$(this).appendTo(table.children("tbody").children("tr:last").children(":first"));
	});
	
	$("#pgCompose form#composeForm a.delAttach").livequery('click', function() {
		$(this).parent().parent().remove();
	})
	.livequery('mouseover', function() {
		$(this).parent().parent().addClass("hover");
	})
	.livequery('mouseout', function() {
		$(this).parent().parent().removeClass("hover");
	});

	/********* delAttachOnSite **********/
	$("form#composeForm a.delAttachOnSite").click(function() {
		$(this).parent().parent().remove();
	});
	
	$("form#composeForm input")
		.focus(function() {
			$(this).addClass("focus");
		})
		.blur(function() {
			$(this).removeClass("focus");
		});
		
	
	//发件人
	$("form#composeForm #tos")
		.focus(function() {
			$("form#composeForm .ui-autocomplete-input").removeClass("checked");
			$(this).addClass("checked");
			
			$(this).addClass("focus");
		})
		.blur(function() {
			$(this).removeClass("focus");
		});
	
	//选种密送
	$("form#composeForm #ccs")
		.focus(function() {
			$("form#composeForm .ui-autocomplete-input").removeClass("checked");
			$(this).addClass("checked");
			$(this).addClass("focus");
		})
		.blur(function() {
			$(this).removeClass("focus");
		});
	
	//选种抄送
	$("form#composeForm #bccs")
		.focus(function() {
			$("form#composeForm .ui-autocomplete-input").removeClass("checked");
			$(this).addClass("checked");
			$(this).addClass("focus");
		})
		.blur(function() {
			$(this).removeClass("focus");
		});
	
	//邮件签名
	$("select#mailInk").change(function() {
		var uuid = $(this).val();
		if (uuid == -1)
			return;
		var ink = null;
		for(var i=0; i<inks.length; i++) {
			if (inks[i].uuid == uuid) {
				ink = inks[i];
				break;
			}
		}
		s = "<br><br><br><br><div id='" + uuid + "'>" + ink.ink + "</div>";
		tinyMCE.execCommand('mceInsertContent',false, s);
	});
	
	//定时发送
	$("#pgCompose form#composeForm input#sendDate").val($.datepicker.formatDate("yy-mm-dd", new Date()));
	$("#pgCompose form#composeForm input#sendDate").datepicker(
		{
			yearRange: '-0:+1',
			dayNamesMin: ['日', '一', '二', '三','四', '五', '六'],
			monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
			prevText: "上月",
			nextText: "下月",
			currentText: "今天",
			closeText: "X",
			clearText: "取消",
			hideIfNoPrevNext: true,
			dateFormat: 'yy-mm-dd'
		}
	);
	
	$("#pgCompose form#composeForm input#isTimerSend").click(
		function() {
			$("#pgCompose form#composeForm div#timerSend").toggle();
		}
	);
	

});
</script>

