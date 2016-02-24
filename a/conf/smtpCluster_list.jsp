<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script type="text/javascript">
function delSmtpTrustIp(ip) {
	window.location.href = "../conf/smtpCluster_del.html?ip=" + ip;
}
</script>

<table id="MF_table" border=0 >
	<tr id="MF_table_headTr" >
		<td>IP地址</td>
		<td>设备说明</td>
		<td align="center">创建时间</td>
		<td align="center" >操作</td>
	</tr>
	
	<c:forEach var="stip" items="${smtpTrustIps}">
	<tr>
		<td><c:out value="${stip.ip }" /></td>
		<td><c:out value="${stip.description }" /></td>
		<td align="center"><c:out value="${stip.createTime }" /></td>
		<td align="center" >
			<input type="button" value="删除" onclick='delSmtpTrustIp("<c:out value="${stip.ip }" />")'  />
		</td>
	</tr>
	</c:forEach>
	
</table>