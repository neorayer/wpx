<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="weather" style="display: none;">
	<div class="wxPortletHeader">
		<span class="wxPortletTitle">天气</span>
	</div>
	 
	<div class="wxPortletBody">
		<img  src='<c:out value="${weather.current.iconUrl}" />' />
		<p class="txt-info">
			<span class="txt-impt"><c:out value="${weather.current.cityName}" /></span>
			<c:out value="${weather.current.condition}" />(<c:out value="${weather.current.temp_c}" /> ℃)
			<br>
			<c:out value="${weather.current.humidity}" />
			<c:out value="${weather.current.wind_condition}" />
		</p>
		<div style="clear: both;"></div>
	</div>
</div>

<script type="text/javascript">

</script>