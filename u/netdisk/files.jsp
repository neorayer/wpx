<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style type="text/css">
/********** addrPsns **********/

.wpxTable thead tr td#fileName{
}

.wpxTable thead tr td#lastModified{
	width: 150px;
}

.wpxTable thead tr td#size {
	width: 100px
}
</style>

<table class="wpxTable">
	<thead>
		<tr>
			<td id="checkbox"><input id="checkAll" type="checkbox" /></td>
			<td id="fileName" class="bl">
				文件名
				<b  class='ico 
					<c:if test='${sortBy eq "fileName" && isUp}'>ico-list-down</c:if>
					<c:if test='${sortBy eq "fileName" && !isUp}'>ico-list-up</c:if>
				'>
				</b>	
			</td>
			<td id="lastModified" class="bl">最后修改时间</td>
			<td id="size" class="bl">大小</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="file" items="${files}" >
		<tr id="row_<c:out value='${file.uuid}' />" class="item" height="30">
			<td><input class="inputChkbox" type="checkbox" value="<c:out value='${file.uuid}' />" /></td>
			<td>
				<span class="name">
					<a class="icon">&nbsp;</a>
					<a class="download" href="<c:out value='netdisk/download.down?uuid=${file.uuid}'/>"><c:out value="${file.fileName}" /></a>
				</span>
			</td>
			<td>
				<c:out value='${file.lastModifiedTime}'/>			
			</td>
			<td>
				<c:out value="${file.currentSize}" />
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<script type="text/javascript">
$(document).ready(function() {
	
	/********** Enahnce Mails Tr Hover **********/
	$("table.wpxTable tbody tr.item")
		.mouseover(function() {
			$(this).addClass("hover");
		})
		.mouseout(function() {
			$(this).removeClass("hover");
		});
		/*
		.click(function(e) {
			if ($(e.target).is("input"))
				return;
			NetDisk.selectAllForce(false);
			$(this).find("input.inputChkbox")
					.attr("checked", "checked")
					.trigger("change");
		});
		*/
	
	$("input.inputChkbox").click(function() {
		$(this).trigger('change');
	});
	
	/********** Enahnce Mails Checkbox(All) **********/
	$("table.wpxTable input#checkAll").click(
		function() {
			NetDisk.selectAll();
		}
	);
	/********** Enahnce Mails Checkbox **********/
	$("input.inputChkbox").change(function() {
		var tr = $(this).parent().parent();
		var checked  = $(this).attr("checked");
		if (checked)
			tr.addClass("selected");
		else
			tr.removeClass("selected");
	});
	
	/********** 下载路径编码 **********/
	$(".download").each(function() {
		var url =$(this).attr("href");
		url = encodeURI(url);
		
		$(this).attr("href", url);
	});
});

</script>