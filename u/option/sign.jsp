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
	width:"100%",
	relative_urls:false,
	theme_advanced_resizing : true,

	// Example content CSS (should be your site CSS)
	content_css : ""
});

</script>

<div id="ctrMailInks">
	<form id="formMailInk" class="optionForm" target="formSubmitFrame" action="option/sign.sjs" method="post" >
		<input id="uuid" name="uuid" type="hidden" value="<c:out value='${link.uuid}'/>"/>
		
		<table width="99%" cellpadding="0" cellspacing="0">
			<tr>
				<th valign="top">签名名称：</th>
				<td>
					<input id="name" name="name" value="<c:out value='${link.name}'/>" type="text">
					<div class="tips"/>
				</td>
			</tr>
			<tr>
				<th valign="top">签名内容：</th>
				<td>
					<textarea id="ink" name="ink" cols="80" rows="5"><c:out value='${link.ink}' escapeXml="false"/></textarea>
					<div class="tips"/>
				</td>
			</tr>
			<tr>
				<th><br/></th>
				<td><input type="submit" value="确定提交" ></td>
			</tr>
		</table>
	</form>
	
	<iframe id="formSubmitFrame" name="formSubmitFrame" style="display:none"></iframe>
	
	<h3 class="tt theme-bor-col theme-c">签名列表</h3>

	<table id="mailInksTable">
		<c:forEach var="ink" items="${inks}" >
		<tr id="tr_<c:out value='${ink.uuid}' />">
			<td class="name"><c:out value="${ink.name}"></c:out></td>
			<td class="ink">
				<c:out value="${ink.ink}" escapeXml="false"></c:out>
			</td>
			<td class="buttons">
				<a href="javascript:signToEdit('<c:out value="${ink.uuid}"/>')">编辑</a>
				<a href="javascript:signDel('<c:out value="${ink.uuid}"/>')">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>

<script type="text/javascript">

function signToEdit(uuid) {
	var url = 'option/sign.html?uuid='+uuid;
	iTabClickedUrl('sign', url);
}

function signDel(uuid) {
	if(!confirm('您确认要删除这条记录吗?'))
		return;
		
	jQuery.post(
		'option/sign_del.json',
		{
			uuid: uuid
		},
		function() {
			tipMsg("签名操作完成");
			iTabClicked('sign');
			
		}
	);
}
$(document).ready(function() {
	document.getElementById("name").focus();
});

</script>