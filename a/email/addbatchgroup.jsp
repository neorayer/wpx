<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:import url="../_pub/common_head.jsp"></c:import>
<link href="../_css/css.css" type="text/css" rel="stylesheet">
<link href="../_css/email.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../../_js/jquery/jquery-1.2.6-all.js"></script>
<style type="text/css">
#bgfrm {
	margin-left:10px;
}

#bgfrm .err {
	color: red;
}
#bgfrm .err-input {
	border: 1px solid red;
}

#bgfrm ul li{
	margin: 5px;
	list-style: none;
}
#cdn-line table {
	margin-left: 35px;
	margin-bottom: 5px;
}

#cdn-list td {
	background-color: #eee;
	padding: 5px;
	border-bottom: 1px solid #e7e7e7;
}
#cdn-list .d-1 {
	width: 20px;
	text-align: center;
}

#cdn-list .d-2 {
	width: 300px;
} 

#cdn-list .d-3 {
	width: 80px;
	text-align: center;
}

#bgfrm .t-btn{
	margin-left: 5px;
}
</style>


<script language="javascript">
</script>

<!--[if lt IE 7]>
<style type="text/css">
html{
	filter:expression(document.execCommand("BackgroundImageCache", false, true));
}
.title_BarImg{
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/user.png', sizingMethod='crop');
}
</style>
<![endif]-->
<style type="text/css">
	
</style>

</head>
<body>
<div id="pgHeadBlock" class="pgHeadBlock">
	<table border=0 width="100%" height="100%" cellspacing="0">
		<tr>
			<td algin="left" width=41 class="title_BarImg"></td>
			<td align="left" id="title_Font1">新建群发组</td>
			<td align="right" id="title_Font2"></td>
		</tr>
	</table>
</div>

<br>
<form id="bgfrm" name="bgfrm" method="post" onsubmit="_submit();return false;" action="addbatchgroup.json">
	<input name='uuid' type='hidden' value="<c:out value='${group.uuid }'/>"/>
	<input name='op' type='hidden' value=""/>
	<ul>
		<li>名称：<input type="text" name="name" size="70" value="<c:out value='${group.name}' default=''/>"/></li>
		<li>条件：<span style="color: red;">注: 所有条件为并且关系</span></li>
		<li id="cdn-line">
			<table id="cdn-list" cellpadding="0" cellspacing="0">
				<c:forEach var="cdn" items="${group.cdns}">
					<tr>
						<td class='d-1'>·<input name='filter' type='hidden' value="<c:out value='${cdn.filter}::::${cdn.name }'/>"/></td>
						<td class='d-2'><c:out value='${cdn.name}'/></td>
						<td class='d-3'><a href='javascript:void(0);' onclick='delLine(this);'>[删除]</a></td>
					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<td>
						<select id="param-sel">
							<option value="uid">用户名 (uid)</option>
							<option value="dc">域名 (dc)</option>
							<option value="displayname">姓名 (displayname)</option>
							<option value="description">部门 (description)</option>
						</select>
					</td>
					<td>
						<select id="match-sel">
							<option value="=">等于</option>
							<option value="like">包含</option>
				   		</select>
					</td>
					<td>
						<input type="text" id="key-input" value="">
					</td>
					<td >
						<a href="javascript:void(0)" onclick="addLine(this);" class="t-btn">[增加]</a>
						<span class='err'></span>
					</td>
				</tr>
			</table>
		</li>
		<li>
			<c:if test="${empty group.creator || (group.creator eq ACTOR.uniqueId)}">
				<div style="margin: 20px 0;height: 1px;background-color: #eee;"></div>
				<input type="button" value="预览分组结果" onclick="previewR();"/>
				<input type="submit" value="保存"/>
				<input type="button" value="返回" onclick="_close();"/>
			</c:if>
		</li>
	</ul>
</form>
</body>
<script language="javascript">
var depDesc = [];
<c:forEach var="dept" items="${deplist}"><c:out value='depDesc["${dept.ou}"] = "${dept.description}";' escapeXml="false"/></c:forEach>

var SQL = {
	'=' : function(k, v) {
		return k + " = '" + v + "'";
	},
	'like': function(k, v) {
		return k + " like '%" + v + "%'";
	},
	'!=': function(k, v) {
		return k + " != '" + v + "'";
	}
};

function _close() {
	window.parent.frames['contentFrame'].location = "batchgroup.html";
}

function addLine(el) {
	var $param = jQuery("#param-sel");
	var $match = jQuery("#match-sel");
	var $key = jQuery("#key-input");
	
	//reset
	$(el).next().html('');
	$key.removeClass('err-input');
	
	var param_v = $param.find(':selected').val();
	var param_text = $param.find(':selected').text();
	var match_v = $match.find(':selected').val();
	var match_text = $match.find(':selected').text();	
	var key_v = $key.val();
	
	if(jQuery.trim(key_v) == '') {
		$(el).next().html('条件内容不能为空');
		$key.addClass('err-input');
		$key.focus();
		return;
	}
	
	var cname = param_text + " " + match_text + " " + key_v;
	var sql = SQL[match_v](param_v, key_v);
	var str = "<tr><td class='d-1'>·<input name='filter' type='hidden' value=\"" + sql + "::::" + cname  + "\"/></td><td class='d-2'>" + cname + "</td><td class='d-3'><a href='javascript:void(0);' onclick='delLine(this);'>[删除]</a></td></tr>";
	var $cdnlist = jQuery("#cdn-list");
	$cdnlist.append(str); 
	
	// reset
	$key.val('');
}

function delLine(el) {
	jQuery(el).parents('tr').remove();
}

function _submit() {
	var form = document.bgfrm;
	if(!_check(form))
		return;
		
	$form = jQuery(form);
	new Ajax.Request($form.attr('action'), {
		postBody: $form.serialize(),
		onComplete: function(resp) {
			var data  = richEval(resp.responseText);
			if(data.res == 'no') {
				alert(data.data);
				return;
			}
			window.location = "addbatchgroup.html?uuid=" + form.uuid.value;
			//_close();
		}
	});
	/**
	jQuery(form).ajaxSubmit({
  		type: 'post',
		dataType: 'json',
   		success: function(data) {
   			if(data.res == 'no') {
				alert(data.data);
				return;
			}
			_close();
   		}	
   	});
   	*/
	return;
}

function _check(form) {
	var nameV = form.name.value;
	if(jQuery.trim(nameV) == '') {
		SkyDNA.Element.createAlertWin("分组名称不能为空");
		return false;
	}
	var sqlLen = document.getElementsByName('filter').length;
	if(sqlLen == 0) {
		SkyDNA.Element.createAlertWin("至少有一条分组条件");
		return false;
	}
	
	return true;
}

function previewR() {
	var form = document.bgfrm;
	if(!_check(form))
		return;
	
	userwin = SkyDNA.Element.createPopupWin({title: "预览分组结果",width: 600,height:400});
	var userDsProps = {
		dataStruct : {
			dc: {title: "域名"},
			uid: {title: "帐号" , isKey: true},
			displayname: {title: "姓名"},
			ou:{title:"部门",defaultValue:""}
		},
		listURL: "previewUsers.json"
	};
	var tableProps = {
		subjects: ['dc', "uid","displayname","ou"],
		isCheckbox : false, 
		filter:{
			ou:function(v){
				if(depDesc && depDesc[v])
					return depDesc[v];
				else
					return v;
			}
		}
	}
	userDsProps.postBody = jQuery(form).formSerialize();
	userDsProps.isLocalSort = true;
	var UserDataSource = new SkyDNA.DataSource(null, userDsProps);
	var listCtr = _CC("div", null, userwin.contentDom);
	UserDataSource.createDataTable(listCtr, tableProps);
	UserDataSource.remoteListData();
}
</script>

</html>
