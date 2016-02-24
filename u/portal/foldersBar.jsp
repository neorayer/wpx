<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
#fd_inbox {
	background-position:0 0;
}

#fd_draft {
	background-position:0 -48px;
}

#fd_sent {
	background-position:0 -24px;
}

#fd_trash {
	background-position:0 -72px;
}

#fd_spam {
	background-position:0 -72px;
}

</style>

<ul id="folders">
	<c:forEach var="f" items="${sysFolders}" >
	<c:set var="clearable" value="${f.id == 'trash' || f.id == 'spam'}" />
	<c:set var="link" value='<a id="fd_${f.id}" class="folder"  href="javascript:MailFolders.open(\'${f.id}\')" >${f.name}<span class="count"> (${f.newCount}/${f.count })</span></a>' />
	<li><div>
		<c:if test="${!clearable}" >
			<c:out value='${link}' escapeXml="false" />
		</c:if>
		</div>
		<c:if test="${clearable}">
			<table width="100%">
				<tr>
					<td>
						<c:out value='${link}' escapeXml="false" />
					</td>
					<td width="1">
						<a href="javascript:">[X]</a>
					</td>
				</tr>
			</table>
		</c:if>
	</li>
	</c:forEach>

</ul>
<div id="myFolders">
	<a href="javascript:MailFolders.openFolders()">自定义邮件夹</a>
</div>
<ul id="folders">
	<c:forEach var="f" items="${myFolders}" >
	<li>
		<c:set var="link" value='<a id="fd_${f.id}" class="folder" href="javascript:MailFolders.open(\'${f.id}\')" >${f.name}<span class="count"> (${f.newCount}/${f.count })</span></a>' />
		<div><c:out value='${link}' escapeXml="false" /></div>
	</li>
	</c:forEach>
</ul>


<script language="javascript">
</script>
