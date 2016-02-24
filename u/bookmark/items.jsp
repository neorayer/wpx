<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style type="text/css">
/********** addrPsns **********/

.wpxTable thead tr td#name{
	width: 150px;
}

.wpxTable thead tr td#url{
	width: 250px;
}

.wpxTable thead tr td#description {
}

.wpxTable .url {
	text-decoration: underline;
}
</style>

<table class="wpxTable">
	<thead>
		<tr>
			<td id="checkbox"><input id="checkAll" type="checkbox" /></td>
			<td id="name" class="bl">名称</td>
			<td id="url" class="bl">书签地址</td>
			<td id="description" class="bl">描述</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${items}" >
		<tr id="row_<c:out value='${item.uuid}' />" class="item" height="30">
			<td><input class="inputChkbox" type="checkbox" value="<c:out value='${item.uuid}' />" /></td>
			<td>
				<span class="name">
					<a class="icon">&nbsp;</a>
					<c:out value="${item.name}" />
				</span>
			</td>
			<td>
				<a class="url" target="_blank" href="<c:out value='${item.url}'/>" title="<c:out value='${item.url}'/>"><c:out value='${item.url}'/></a>			
			</td>
			<td>
				<c:out value="${item.description}" />
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
			Bookmark.selectAllForce(false);
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
			Bookmark.selectAll();
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
	
});

</script>