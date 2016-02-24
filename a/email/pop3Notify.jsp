<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%//@include file="../../do/portal/checkSuper.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/DNA/jsDNA/prototype.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Core.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Element.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_ElementDS.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/SkyDNA_Validate.js"></script>
<script type="text/javascript" src="/DNA/jsDNA/language/utf8.js"></script>
<link href="/DNA/jsDNA/style/fast/css/css.css" type="text/css" rel="stylesheet" />
<script>

</script>

</head>
<body>
<div>用户名使用{USER};域名使用{DOMAIN};邮件内日期使用{DATE}分别来表示</div>
<div id="mainDiv"></div>

						
</body>
<script type="text/javascript">
function cr(){
	with(SkyDNA.Element){
		with(createForm(_G("mainDiv"),{formURL:"../../do/email/pop3Notify.jsp"})){
			addTextarea("content","内容:");
			addTextarea("remark","备注:");
			addSubmit();
		}
	}
}

cr();
</script>
</html>
