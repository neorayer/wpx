<?xml version="1.0" encoding="UTF-8"?>
<root>
	<account>
		<uid>${user.uid}</uid> <!-- 必填 -->	
		<appid>${user.dc}</appid> <!-- 选填, 没有则采用登录APP ID -->	
		<password>${user.userPassword}</password> <!-- 必填 -->
		<ip>${ip}</ip><!-- 必填 -->	
	</account>
	<app>
		<id>${APP_ID}</id> <!-- 必填 -->	
		<password>${APP_PASSWORD}</password> <!-- 必填 -->
	</app>
</root>