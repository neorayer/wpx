<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>
	<table width="98%;">
		<tr>
			<td id="pgWelcome" valign="top">
				<c:import url="welcome.html"></c:import>	
			</td>
			<td id="pg-main-right">
				<div class="wxPortlet">
<!-- 					<c:import url="weather.html?test=abc"></c:import>
 -->
 				</div>
				<div class="wxPortlet" style="margin-top: 97px;_margin-top: 95px;">
					<c:import url="space.html"></c:import>
				</div>
			</td>
		</tr>
	</table>
</div>  

<script type="text/javascript">
$(document).ready(function() {
});
</script>