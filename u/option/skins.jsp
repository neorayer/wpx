<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="gOpt">
	<div class="g-title-1">
		<span class="txt-info">选择您喜欢的邮箱界面主题颜色</span>
	</div>
	
	<div class="ln-thick theme-bor-col"></div>
	
	<div id="oSkins">
		<c:forEach var="skin" items="${skins}">
			<div class="gOpt-skin-box">
				<div class="warper">
					<p class="skin-demo <c:out value='skin-${skin.code}'/>">&nbsp;</p>
					<p>
						<input type="radio" value="<c:out value='${skin.id}'/>" name="skinType">
						&nbsp;
						<label>
							<c:out value='${skin.desc}'/>
							<span class="txt-info"></span>
							<c:if test="${skin.id == 1}">
								<span class="txt-info">(默认)</span>
							</c:if>
						</label>
					</p>
				</div>
			</div>		
		</c:forEach>
		
		<div style="clear: both;" class="tip-normal">
			<p><strong>小提示：</strong></p>
			<p class="txt-tips">点击图片后可直接更换皮肤，自动为您保存。</p>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
	$('#oSkins .gOpt-skin-box').click(function() {
		$(this).find('input[type=radio]').trigger('click');
	});
	
	$('#oSkins input[name=skinType]').click(function() {
		$('#oSkins .gOpt-skin-box').removeClass('gOpt-skin-Bsel');
		$(this).parents('.gOpt-skin-box').addClass('gOpt-skin-Bsel');
		
		$.post('option/skinSet.json', {id: this.value}, function(data) {
			if (data.res != 'yes') {
				alert(data.data);
				return false;
			}
			$('#skin-css-link').attr('href', '_skin/'+ data.data.code + '/skin.css');
			tipMsg("邮箱皮肤设置成功");
		}, 'json');
	});
	
	var $selectedSkin = $('#oSkins input[name=skinType][value=<c:out value='${ACTOR.skin}'/>]');
	$selectedSkin.attr('checked', 'checked');
	$selectedSkin.parents('.gOpt-skin-box').addClass('gOpt-skin-Bsel');
});
</script>
