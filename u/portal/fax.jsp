<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form id="formAutoReply" class="optionForm" action="fax/addfax.html" method="post" >
	ID:<input type="text" name="id">
	Mail:<input type="text" name="mail">
	<input type="submit" value="添加">
	<input type="button" value="同步虚拟传真号" onclick="synFaxNumbers(this);" />
</form>
<hr>
<table>
	<thead>
	<tr><td>ID</td><td>Mail</td><td></td></tr>
	</thead>
	<tbody>
	<c:forEach var="fax" items="${faxs}">
		<tr>
			<td width="150"><c:out value='${fax.id}'/></td>
			<td><c:out value='${fax.mail}'/></td>
			<td><a href="fax/delfax.html?id=<c:out value='${fax.id }'/>">删除</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>


<script type="text/javascript">

function synFaxNumbers(btn) {
	if(!confirm('您确定要同步网络传真服务器的虚拟传真号吗?')) 
		return;
	var $btn =  $(btn);
	$btn.attr('disabled', 'disabled').val('同步中，请稍后...');	
	$.post('fax/synfaxs.json', {}, function(data) {
		$btn.removeAttr('disabled').val('同步虚拟传真号');
		if(data.res != 'yes') {
			alert(data.data);
			return;
		}
		alert('同步成功');
	}, 'json');
}

$(document).ready(function() {
	
});


</script>