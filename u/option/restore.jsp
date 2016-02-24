<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
tinyMCE.init({
	// General options
	mode : "textareas",
	language:"zh",
	theme : "advanced",
	fontSize: "12px",
	plugins : "safari,layer,advhr,advlink,emotions,inlinepopups,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable",
	// Theme options
	theme_advanced_buttons1 : "bold,italic,underline,|,justifyleft,justifycenter,justifyright,justifyfull,formatselect,fontselect,fontsizeselect,|,forecolor,backcolor,|,outdent,indent,link,unlink,|,undo,redo",
	theme_advanced_buttons2 : "",
	theme_advanced_toolbar_location : "top",	
	theme_advanced_toolbar_align:"left",
	theme_advanced_fonts:"宋体=宋体;黑体=黑体;仿宋=仿宋;楷体=楷体;隶书=隶书;幼圆=幼圆;Arial=arial,helvetica,sans-serif;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Tahoma=tahoma,arial,helvetica,sans-serif;Times New Roman=times new roman,times;Verdana=verdana,geneva;Webdings=webdings;Wingdings=wingdings,zapf dingbats",
	convert_fonts_to_spans:true,
	remove_trailing_nbsp:true,
	remove_linebreaks:false,
	width:"99%",
	relative_urls:false,
	theme_advanced_resizing : true,

	// Example content CSS (should be your site CSS)
	content_css : ""
});

</script>

<form id="formAutoReply" target="formReplyFrame" action="option/restore.sjs" method="post" >
	<div>
		<input name="autoreplyswitch" id="ay-1" type="radio" value="1" <c:if test="${autoreplyswitch == 1}">checked</c:if> /><label for="ay-1">打开邮件自动回复功能</label>
		&nbsp;&nbsp;
		<input name="autoreplyswitch" id="ay-2" type="radio" value="0" <c:if test="${autoreplyswitch == 0}">checked</c:if>/><label for="ay-2">关闭邮件自动回复功能</label>
	</div>
	<div class="fr-tt">邮件回复内容:</div>
	<div>
		<textarea id="autoreplycontent" name="autoreplycontent" cols="80" rows="5"><c:out value="${autoreplycontent}" escapeXml="false"/></textarea>
	</div>
	<div class="fr-btn">
		<input type="submit" value="确定修改" >
	</div>
</form>
<iframe id="formReplyFrame" name="formReplyFrame" style="display:none"></iframe>

<script type="text/javascript">

$(document).ready(function() {
	document.getElementById("autoreplycontent").focus();
});


</script>