function subString(str, len, hasDot) {
	var newLength = 0;
	var newStr = "";
	var chineseRegex = /[^\x00-\xff]/g;
	var singleChar = "";
	var strLength = str.replace(chineseRegex, "**").length;
	for (var i = 0; i < strLength; i++) {
		singleChar = str.charAt(i).toString();
		if (singleChar.match(chineseRegex) != null) {
			newLength += 2;
		} else {
			newLength++;
		}
		if (newLength > len) {
			break;
		}
		newStr += singleChar;
	}

	if (hasDot && strLength > len) {
		newStr += "...";
	}
	return newStr;
}
/********** 消息提示 **********/
function tipMsg(msg, callback) {
	$('#tipMsg')
		.text(msg)
		.fadeIn('fast', function() {
			$(this).fadeOut(3000);
			if(typeof callback == 'undefined') {
			}
			else if(typeof callback == 'string') {
				alert(callback);
			}
			else if(typeof callback == 'function') {
				callback();
			}
		});
}

/********** 下拉效果 **********/
Enhance = {
	menuButton : function() {
		$('.wxMenuButton').hover(function() {
			$(this).next('.wxDropMenu').show();
		}, function() {
			$(this).next('.wxDropMenu').hide();
		});
		$('.wxDropMenu').hover(function() {
			$(this).show();
		}, function() {
			$(this).hide();
		}).click(function() {
			$(this).hide();
		});;
		/**
		$(document).click(function(e) {
			$target = $(e.target).parent();
			if($target.hasClass('wxMenuButton')) {
				$target.next().show();
				$target.blur(function() {
					$(this).next().hide();
				});
			}
		 });
		 */
	}
}


function getFileName(path) {
	var regstr =/\\/;
	var regresult = new RegExp(regstr)
	var sss = path.split(regresult,'100');
	return sss[sss.length-1]; 
}

function getIcon(_fn){
	var _index =  _fn.lastIndexOf('.');
	var _feName = '';
	var s = '';
	if(_index!=-1)
	 _feName = _fn.substring(_index+1);
	switch(_feName){
		case 'bmp':
		  s =  'bmp.png';
		  break;
		case 'doc':
		  s =  'doc.png';
		  break;
		case 'gif':
		  s =  'gif.png';
		  break;
		case 'gz':
		  s =  'gz.png';
		  break;
		case 'htm':
		  s =  'htm.png';
		  break;
		case 'html':
		  s =  'html.png';
		  break;
		case 'jpg':
		  s =  'jpg.png';
		  break;
		case 'mp3':
		  s =  'mp3.png';
		  break;
		case 'net':
		  s =  'net.png';
		  break;
		case 'pdf':
		  s =  'pdf.png';
		  break;
		case 'png':
		  s =  'png.png';
		  break;
		case 'ppt':
		  s =  'ppt.png';
		  break;
		case 'tar':
		  s =  'tar.png';
		  break;
		case 'tif':
		  s =  'tif.png';
		  break;
		case 'xls':
		  s =  'xls.png';
		  break;
		case 'zip':
		  s =  'zip.png';
		  break;
		default:
		  s =  'normal.png';
		  break;
    }
    return s;	
}

/********** Portal **********/
Portal = {
	ProjectBase: '',
	
	open: function(url) {
		if(!Compose.leaved())
			return;
			
		$("#viewMail").hide();
		$("#gFMain").show().load(url);
	},
	
	rt : function (url) {
		if(!Compose.leaved())
			return;
		
		window.location	= Portal.ProjectBase + url;
	}
}
/********** HeadMenu **********/
HeadMenu = {
	index: function() {
		Portal.rt('main.html');
		setHash('');
	},
	options: function(module) {
		$('.gSidebar ul li').removeClass("on");
		Portal.open('option/main.html?module=personInfo');
		setHash('#options');
	},
	skins: function() {
		$('.gSidebar ul li').removeClass("on");
		Portal.open('option/skins.html');
		setHash('#skins');
	}
}

/********** SideBar **********/
SideBar = {
	//其它文件夹
	UFToggle: function (){
		var $lnkDefToggle = $('#lnkDefToggle');
		if($lnkDefToggle.attr('class').indexOf('opned')!=-1){
			$lnkDefToggle.removeClass('opned');
			$lnkDefToggle.addClass('clded');
			
			MailFolders.isOpen = false;
		}else{
			$lnkDefToggle.removeClass('clded');
			$lnkDefToggle.addClass('opned');
			
			MailFolders.isOpen = true;
		}
		$('#ulDefFolders').toggle();
	},
	
	//邮件服务
	SFToggle: function (){
		var $lnkDefToggle = $('#lnkServiceToggle');
		if($lnkDefToggle.attr('class').indexOf('opned')!=-1){
			$lnkDefToggle.removeClass('opned');
			$lnkDefToggle.addClass('clded');
		}else{
			$lnkDefToggle.removeClass('clded');
			$lnkDefToggle.addClass('opned');
		}
		$('.ulServiceFolders').toggle();
	},
	
	open: function (id, url){
		if(!Compose.leaved())
			return;
			
		var $gFMain = $("#gFMain");
		var $viewMail = $("#viewMail");
		$viewMail.hide();
		$gFMain.show();
	
		$('.gSidebar ul li').removeClass("on");
		$('.gSidebar '+ id).addClass("on");
		$gFMain.load(url);
		setHash(id);
	}
}

		
/********** Compose **********/
Compose = {
	//自动保存定时参数
	autoTimer: 3,
	
	/**
	* 是否已离开写信页面
	*/
	leaved: function() {
		if($('#composeIframe').css("display")=="block"){
			if (!confirm("您确定要离开此页面吗?\n\n您正在编辑的内容将丢失, 请慎重操作!")) 
				return false;
			
			Compose.remove();
		}
		
		return true;
	},
	
	/**
	* 写信：mail/compose.html
	* 通讯录快速写信 ：mail/compose.html?act=addr&tos=%22cit%40citynet001.com%22%3Ccit%40citynet001.com%3E%2C%22cnfax%40nc.cn%22%3Ccnfax%40nc.cn%3E%2C
	* 草稿箱打开邮件：mail/compose.html?act=draft&folderid=draft&uuid=dc4c104f-d775-439d-a51e-57af4cbe936e
	* 转发：mail/compose.html?act=forward&folderid=inbox&parentuuid=f9b6bba0-3737-4ee7-a0ea-deca32482432
	* 回复：mail/compose.html?act=reply&folderid=inbox&parentuuid=f9b6bba0-3737-4ee7-a0ea-deca32482432
	* 全部回复：mail/compose.html?act=replyall&folderid=inbox&parentuuid=f9b6bba0-3737-4ee7-a0ea-deca32482432
	*/
	build: function(url) {
		if(!Compose.leaved())
			return;
			
		$("#viewMail").hide();
		$("#gFMain").hide();
		$('#composeIframe').load(url).show();
		
		Compose.startAutoSaveMail();
	},
	
	/**
	* 定时保存邮件
	*/
	startAutoSaveMail: function() {
		timer = setInterval(
			function(){
				Compose.autoSaveDraft();
			},
			Compose.autoTimer * 60 * 1000
		);
	},
	
	/**
	* 清除定时保存邮件
	* 离开写信界面时调用
	*/
	stopAutoSaveMail: function() {
		clearInterval(timer);
	},
	
	/**
	* 离开写信页面
	*/
	remove: function() {
		Compose.stopAutoSaveMail();
		$("#composeIframe").html('').hide();
	},
	
	/**
	* 关闭写信页面，展现之前页面
	*/
	close: function() {
		if (!confirm("您确定要离开此页面吗?\n\n您正在编辑的内容将丢失, 请慎重操作!")) 
			return ;
		Compose.remove();
		$('#gFMain').show();
	},
	
	/**
	* 切换抄送
	*/
	ccToggle: function() {
		$("#pgCompose form#composeForm tr#ccRow").toggle();
	},
	
	/**
	* 切换密送
	*/
	bccToggle: function() {
		$("#pgCompose form#composeForm tr#bccRow").toggle();
	},
	
	/**
	* 发信结束时服务器的回调函数
	* 邮件发送完毕以后跳转至成功页面 
	*/
	turnCompose: function(tos) {
		$('#tipMsg').hide();
		
		var $gFMain = $("#gFMain");
		$gFMain.html('');
		
		var $viewMail = $("#viewMail");
		$viewMail.hide();
		
		var url = 'mail/tos.html?tos='+encodeURIComponent(tos);
		$gFMain.load(url);
		
		Compose.remove();
		$gFMain.show();
	},
	
	/**
	* 写信界面切换通讯录
	*/
	toggleAddrbook: function() {
		var $addr = $("#pgCompose td#rightSide");
		var _loaded = $addr.data('_loaded');
		if(!_loaded){
			$addr.load("mail/addrbooks.html");
			$addr.data('_loaded', 'true');
		}
		$addr.toggle();
	},
	
	/**
	* 自动补全收件人
	* 写信界面调用
	*/
	enhanceAutoComplete: function() {
		$.getJSON("mail/psns.json",null, function(data) {
			if ('yes' != data.res)
				return ;
			var addrPsns = data.data.psns;
			var items = [];
			for(var i=0; i<addrPsns.length; i++) {
				var psn = addrPsns[i];
				//items.push('"' + psn.displayname + '" <' + psn.mail + '>');
				items.push(psn.displayname + ' &lt;' + psn.mail + '&gt;');
			}
			var autoCompOption = {
				data: items,
				multiple: true,
				multipleSeparator: ',',
				matchContains: true,
				formatResult: function(s) {
					s = '\"' + s;
					s = s.replace("&lt;", '\"<');
					s = s.replace("&gt;", '>');
					return s;
				}
			}
			$("#pgCompose form#composeForm #tos").autocomplete(autoCompOption);
			$("#pgCompose form#composeForm #ccs").autocomplete(autoCompOption);
			$("#pgCompose form#composeForm #bccs").autocomplete(autoCompOption);
		});
	},
	
	/**
	* 发信
	*/
	sendMail: function () {
		var $tos = $('form#composeForm #tos');
		var tos = $.trim($tos.val());

		if (tos.length == 0){
			alert('请填写收件人电子邮件地址!');
			return;
		}
		
		//自动保存已发送 ？？？
		$("#pgCompose form#composeForm input#isSend").val("true");
		
		var msg = "邮件正在发送中，请耐心等待";
		$('#tipMsg').text(msg).show();
		
		Compose._submit();
	},
	
	/**
	* 存草稿
	*/
	saveDraft: function () {
		//存草稿时不自动保存到已发送
		$("#pgCompose form#composeForm input#isSend").val("false");
		$("#pgCompose form#composeForm input#isSafeDraft").attr("checked", "checked");
		
		//邮件内容
		var contentVal =tinyMCE.getInstanceById('content').getBody().innerHTML;
		if ($.trim(contentVal).length == 0){
			alert('该邮件内容均为空!');
			return;
		}
		
		var msg = "邮件正在保存中，请耐心等待";
		$('#tipMsg').text(msg).show();
		
		Compose._submit();
	},
	
	
	/**
	* 定时存草稿
	*/
	autoSaveDraft: function () {
		//邮件内容
		var contentVal =tinyMCE.getInstanceById('content').getBody().innerHTML;
		//内容为空不定时存草稿(tinyMCE 默认有25个长度的内容)
		if ($.trim(contentVal).length <= 25)
			return;
		
		//收件人
		var $tos = $('form#composeForm #tos');
		//邮件id (若已经存稿就会产生id，防止重复存稿)
		var $uuid = $('form#composeForm #uuid');
		//标题
		var $subject = $('form#composeForm #subject');
		
		var msg = "系统正在为您定时保存邮件";
		$('#tipMsg').text(msg).show();
		
		$.post(
			"mail/autoSaveDraft.json", 
			{
				uuid: $uuid.val(),
				tos: $tos.val(),
				subject: $subject.val(),
				content: contentVal
			},
			function(data) {
				if ('yes' != data.res) {
					alert(data.data);
					return;
				}
				$('#tipMsg').hide();
				
				//邮件自动保存以后，该邮件会生成一个UUID, 系统会返回该邮件UUID, 防止该邮件重复存稿
				var uuid = data.data.uuid;
				$('#pgCompose form#composeForm #uuid').val(uuid);
				
			},
			'json'
		);
		
		//自动保存完毕后刷新邮件夹
		MailFolders.refresh(null);
	},
	
	/**
	* 提交写信form
	*/
	_submit: function () {
		//form 提交前清楚自动保存的定时函数
		Compose.stopAutoSaveMail();
		
		//替换所有的双引号
		var $tos = $('form#composeForm #tos');
		var tos = $.trim($tos.val());
		tos = tos.replace(/\"|\'/g, '"');
		tos = tos.replace(/;/g, ',');
		$tos.val(tos);
		
		var $ccs = $('form#composeForm #ccs');
		var ccs = $.trim($ccs.val());
		ccs = ccs.replace(/\"|\'/g, '"');
		ccs = ccs.replace(/;/g, ',');
		$ccs.val(ccs);
		
		var $bccs = $('form#composeForm #bccs');
		var bccs = $.trim($bccs.val());
		bccs = bccs.replace(/\"|\'/g, '"');
		bccs = bccs.replace(/;/g, ',');
		$bccs.val(bccs);
		
		$("#pgCompose form#composeForm").submit();
	}
	
}

/** ******** 邮件夹 **********/

var MailFolders = {
	//自定义邮件夹是否打开
	isOpen: true,
	
	//邮件夹
	folders: [],
	//系统邮件夹
	sysFolders: [],
	//自定义邮件夹
	myFolders: [],
	
	/**
	* 收信	
	*/
	receiveMail:function() {
		//MailFolders.refresh('inbox');
		MailFolders.open('inbox');
	},
	
	/**
	* 打开指定的邮件夹	
	*/
	open: function(folderid) {
		if(!Compose.leaved())
			return;
			
		$("#viewMail").hide();
		var $gFMain = $("#gFMain");
		$gFMain.show();
		
		$('.gSidebar ul li').removeClass("on");
		
		//中文自定义文件夹
		//$('.gSidebar #fd_'+folderid).addClass("on");
		$('.gSidebar ul.folders li').each(
			function() {
				var id =$(this).attr("id").substring(3);
				if(id == folderid){
					$(this).addClass("on");	
				}
			}
		);
		
		MailFolders.refresh(folderid);
		
		$gFMain.load("mail/mails.html?folderid=" + folderid);
		
		var hk = '#' + folderid;
		var f = HashMap.get(hk);
		if(typeof f != 'function') {
			HashMap.set(hk, function() {
				MailFolders.open(folderid);
			});
		}
		setHash(hk);
	},
	
	/**
	* 打开指定的邮件夹	，带参数url
	* 未读邮件：mail/mails.html?folderid=inbox&condition=read|true
	* 搜索邮件：mail/mails.html?folderid=inbox&keyword=jiayan
	* 分页：mail/mails.html?folderid=inbox&condition=&keyword=&pageNum=1&countPerPage=20
	* 排序：mail/mails.html?folderid=inbox&sortBy=subject&isUp=true&pageNum=1&countPerPage=20
	*/
	openUrl: function(folderid, url) {
		if(!Compose.leaved())
			return;
		var $gFMain = $("#gFMain");
		var $viewMail = $("#viewMail");
		$viewMail.hide();
		$gFMain.show();
		
		$('.gSidebar ul li').removeClass("on");
		//中文自定义文件夹
		//$('.gSidebar #fd_'+folderid).addClass("on");
		$('.gSidebar ul.folders li').each(
			function() {
				var id =$(this).attr("id").substring(3);
				if(id == folderid){
					$(this).addClass("on");	
				}
			}
		);
		
		MailFolders.refresh(folderid);
		var _url = url.replace(/(&keyword=)([^&]+)/, function($0, $1, $2) {
			return $1 + encodeURIComponent($2);
		});
		$gFMain.load(_url);
	},
	
	/**
	* 删除邮件夹
	*/
	del: function(folderid) {
		if (!confirm("您是否确认删除此邮件夹？注意：此操作不可恢复！")) {
			return;
		}
		$.post("mail/folder_del.json", {folderid: folderid}, function(data) {
			if ('yes' != data.res) {
				alert(data.data);
				return;
			}
			MailFolders.refresh();
			MailFolders.openFolders();
		}, 'json');
	},
	
	/**
	* 清空邮件夹
	*/	
	empty: function(folderid) {
		if (!confirm("您是否确认清空此邮件夹？注意：此操作不可恢复！")) {
			return;
		}
		$.post("mail/folder_empty.json", {folderid: folderid}, function(data) {
			if ('yes' != data.res) {
				alert(data.data);
				return;
			}
			MailFolders.refresh();
			MailFolders.open(folderid);
		}, 'json' );
	},

	/**
	* 刷新邮件夹
	*/
	refresh: function(fidSelected) {
		var url = 'portal/side.html';
		if(typeof(fidSelected) != 'undefined' && fidSelected!=null){
			url = url+'?folderid=' + fidSelected;
		}
		$("#gFSide").load(url);
	},
	
	/**
	* 打开邮件夹管理页面
	*/
	openFolders: function() {
		if(!Compose.leaved())
			return;
			
		var url = "mail/folders.html";
		$("#viewMail").hide();
		$("#gFMain").show().load(url);
		setHash('#ufm');
	},

	/**
	* 添加邮件夹
	*/
	doAdd: function() {
		var name = $("form#folderAdd input#folderName").val();
		$.post("mail/folder_add.json", {name: name}, function(data) {
			if ('yes' != data.res) {
				alert(data.data);
				return;
			}
			
			tipMsg("邮件夹添加完成！");
			
			MailFolders.refresh();
			MailFolders.openFolders();
			
		}, 'json');
		
	},
	
	/**
	* 设置邮件夹提交按钮是否可见
	*/
	enableAdd: function(isEnabled) {
		$('form#folderAdd input#folderAddSubmit').attr('disabled', !isEnabled);
	},
	
	/**
	* 添加邮件夹是判断邮件夹是否存在
	*/
	exists: function(name) {
		for(var i=0; i<MailFolders.folders.length; i++) {
			var f = MailFolders.folders[i];
			if (f.id == name)
				return true;
			if (f.name == name)
				return true;
		}
		return false;
	},
	
	/**
	* 邮件夹添加的验证方法
	*/
	validateAdd: function() {
		var v = $('form#folderAdd input#folderName').val();
		v = $.trim(v);
		
		if (v.length == 0) {
			MailFolders.enableAdd(false);
			return;
		}
		
		//判断邮件夹是否含有特殊字符
		var ptn_name =/[@#\$%\^&\*]+/g;
		if(ptn_name.test(v)){
			tipMsg("邮件夹" + v + " 含有不规则字符,例如：@#%&*！");
			MailFolders.enableAdd(false);
			return;
		}
		
		//判断邮件夹是否已经存在
		if (MailFolders.exists(v)) {
			tipMsg("邮件夹" + v + " 已存在！");
			MailFolders.enableAdd(false);
			return;
		}
		
		//判断邮件夹名字是否是系统关键字 （spam 垃圾邮件）（star 已加星标）
		if (v == 'spam'|| v == 'star') {
			tipMsg("邮件夹名" + v + " 为系统关键字！");
			MailFolders.enableAdd(false);
			return;
		}
		
		MailFolders.enableAdd(true);
	}
}


/********** Mails Functions **********/
Mails = {
	folderid: '',
	sortBy: '',
	isUp: '',
	pageNum: '',
	countPerPage: '',
	condition: '',
	keyword: '',

	/**
	* 选种邮件列表所有邮件
	*/
	selectAll: function() {
		var checked = $("input#checkAll").attr("checked");
		this.selectAllForce(checked);
	},
	
	/**
	* 选种的方法
	*/
	selectAllForce: function(checked) {
		$("input.inputChkbox:checkbox").each(
			function() {
				$(this).attr("checked", checked ? "checked" : "");
				$(this).trigger("change");
			}
		);
	},
	
	/**
	* 选种邮件列表中所有 已读|未读 邮件
	*/
	selectReadForce: function(hasRead) {
		$("tr.read_" + hasRead).each(
			function() {
				var checkbox = $(this).find("input.inputChkbox");
				checkbox.attr("checked", "checked");
				checkbox.trigger("change");
			}
		);
		$("tr.read_" + !hasRead).each(
			function() {
				var checkbox = $(this).find("input.inputChkbox");
				checkbox.attr("checked", "");
				checkbox.trigger("change");
			}
		);
		
	},
	
	/**
	* 刷新邮件列表
	*/
	refresh: function(isFirstPage) {
		if (isFirstPage) {
			Mails.pageNum = 1;
			Mails.sortBy = 'lastModified';
			Mails.isUp = false;
			Mails.condition = '';
			Mails.keyword = '';
		}
		Mails.pageNum = Mails.pageNum ? Mails.pageNum: 1;
		Mails.countPerPage = Mails.countPerPage ? Mails.countPerPage : 20;
		var url = "mail/mails.html?folderid="+Mails.folderid;
		url += "&sortBy=" + Mails.sortBy;	
		url += "&isUp=" + Mails.isUp;				
		url += "&pageNum=" + Mails.pageNum;			
		url += "&countPerPage=" + Mails.countPerPage;
		if (Mails.condition != '') {
			url += "&condition=" + Mails.condition;
		}
		if (Mails.keyword != '') {
			url += "&keyword=" + Mails.keyword;
		}
		//MailFolders.refresh(Mails.folderid);

		MailFolders.openUrl(Mails.folderid, url);
	},

	/**
	* 邮件列表排序
	*/
	sort: function(sortBy) {
		if (sortBy == Mails.sortBy) {
			Mails.isUp = Mails.isUp=='false'?true:false;
		}else {
			Mails.sortBy = sortBy;
			Mails.isUp = true;
		}
		
		Mails.refresh(false);
	},
	
	/**
	* 打开指定邮件
	*/
	openMail: function(uuid) {
		//若是草稿箱，进入写信页面
		if(Mails.folderid =='draft'){
			var url = "mail/compose.html?act=draft&folderid=" + Mails.folderid + "&uuid=" + uuid;
			Compose.build(url);	
			
			//设置已读
			var $mailTr = $("#gFMain tr#"+uuid);
			if(!$mailTr.hasClass('read_true')){
				
				jQuery.post(
					'mail/mails_setRead.json', 
					{
						folderid: Mails.folderid,
						uuid: uuid,
						read: true
					},
					function() {
						$mailTr.removeClass("read_false").addClass("read_true");
							
						MailFolders.refresh(Mails.folderid);
					}
				);
			}
			
		}else{
			$("#viewMail").html('');
			$("#gFMain").hide();
			
			var url = "mail/mail.html?folderid=" + Mails.folderid + "&uuid=" + uuid;
			$("#viewMail").load(url).show();
			
			//设置已读
			var $mailTr = $("#gFMain tr#"+uuid);
			if(!$mailTr.hasClass('read_true'))
				$mailTr.removeClass("read_false").addClass("read_true");
					
			MailFolders.refresh(Mails.folderid);
		}
	},
	
	/**
	* 获取所有选种邮件的id
	*/
	checkedUuids: function() {
		var uuids = [];
		$("input.inputChkbox:checkbox").each(function() {
			if ($(this).attr("checked") == "")
				return;
			uuids.push($(this).val());
		});
		return uuids;
	},
	
	/**
	* 判断是否选种邮件
	*/
	checkUuids: function(uuids) {
		if (uuids.length != 0)
			return true;
		tipMsg("请先选择要操作的邮件");
		return false;
	},
	
	/**
	* 将选种邮件移动到指定邮件夹
	*/
	moveTo: function(folderId) {
		var uuids = Mails.checkedUuids();
		if (!Mails.checkUuids(uuids))
			return;
		jQuery.post(
			'mail/mails_move.json', 
			{
				srcFid: Mails.folderid,
				destFid: folderId,
				uuid: uuids
			},
			function() {
				tipMsg("邮件移动操作完成");
				Mails.refresh();
			}
		);
	},
	
	/**
	* 设置指定邮件是否已读
	*/
	markRead: function(isRead) {
		var uuids = Mails.checkedUuids();
		if (!Mails.checkUuids(uuids))
			return;
		jQuery.post(
			'mail/mails_setRead.json', 
			{
				folderid: Mails.folderid,
				uuid: uuids,
				read: isRead
			},
			function() {
				tipMsg("邮件标记操作完成");
				
				for(var i=0;i<uuids.length;i++){
					$("tr#"+uuids[i])
						.removeClass("read_true")
						.removeClass("read_false")
						.addClass("read_"+isRead);
				}
				
				MailFolders.refresh(Mails.folderid);
			}
		);
	},
	
	/**
	* 设置指定邮件是否已回复
	*/
	markReplied: function(isReplied) {
		var uuids = Mails.checkedUuids();
		if (!Mails.checkUuids(uuids))
			return;
		jQuery.post(
			'mail/mails_setReplied.json', 
			{
				folderid: Mails.folderid,
				uuid: uuids,
				reply: isReplied
			},
			function() {
				tipMsg("邮件标记操作完成");
				
				var reply = isReplied?'replyed':'unreplyed';
				for(var i=0;i<uuids.length;i++){
					$("tr#"+uuids[i] + " .mailStatus .reply")
						.removeClass("unreplyed")
						.removeClass("replyed")
						.addClass(reply)
						.attr('title', '已回复');
				}
				
				MailFolders.refresh(Mails.folderid);
			}
		);
	},
	
	/**
	* 永久删除邮件
	*/
	remove: function() {
		var uuids = Mails.checkedUuids();
		if (!Mails.checkUuids(uuids))
			return;
		if (!confirm("您是否确认永久删除所选邮件？注意此操作不可恢复。"))
			return;
		jQuery.post(
			'mail/mails_del.json', 
			{
				folderid: Mails.folderid,
				uuid: uuids
			},
			function() {
				tipMsg("邮件永久删除完毕");
				Mails.refresh();	
			}
		);
	}
};





/********** Toggle Mail Info **********/
Mail = {
	/**
	* 打开指定邮件
	*/
	openMail: function(uuid) {
		var url = "mail/mail.html?folderid=" + Mail.folderid +"&uuid=" + uuid;
		
		$("#viewMail").load(url).show();
		$("#gFMain").hide();
		
		MailFolders.refresh(Mail.folderid);
	},
	
	/**
	* 返回邮件列表页面
	*/
	back: function() {
		//Mails.refresh(true);

		$("#viewMail").html('').css("display","none");
		$("#gFMain").css("display","block");
	},
	
	/**
	* 将选种邮件移动到指定邮件夹
	*/
	moveTo: function(folderId) {
		jQuery.post(
			'mail/mails_move.json', 
			{
				srcFid: Mail.folderid,
				destFid: folderId,
				uuid: Mail.uuid
			},
			function() {
				//移除页面数据
				$("tr#"+Mail.uuid).remove();
				
				MailFolders.refresh(Mail.folderid);
				
				Mail.back();
			}
		);
	},
	
	/**
	* 设置指定邮件是否已读
	*/
	markRead: function(isRead) {
		jQuery.post(
			'mail/mails_setRead.json', 
			{
				folderid: Mail.folderid,
				uuid: Mail.uuid,
				read: isRead
			},
			function() {
				
				$("tr#"+Mail.uuid)
					.removeClass("read_true")
					.removeClass("read_false")
					.addClass("read_"+isRead);
				
				MailFolders.refresh(Mail.folderid);
				tipMsg("邮件标记操作完成");
			}
		);
	},
	
	/**
	* 设置指定邮件是否已回复
	*/
	markReplied: function(isReplied) {
		jQuery.post(
			'mail/mails_setReplied.json', 
			{
				folderid: Mail.folderid,
				uuid: Mail.uuid,
				reply: isReplied
			},
			function() {
				var reply = isReplied?'replyed':'unreplyed';
				$("tr#"+Mail.uuid + " .mailStatus .reply")
					.removeClass("unreplyed")
					.removeClass("replyed")
					.addClass(reply);
				
				tipMsg("邮件标记操作完成");
			}
		);
	},
	
	/**
	* 永久删除所选邮件
	*/
	remove: function() {
		if (!confirm("您是否确认永久删除所选邮件？注意此操作不可恢复。"))
			return;
		jQuery.post(
			'mail/mails_del.json', 
			{
				folderid: Mail.folderid,
				uuid: Mail.uuid
			},
			function() {
				$("tr#"+Mail.uuid).remove();
				
				MailFolders.refresh(Mail.folderid);
				
				Mail.back();
			}
		);
	},
	
	/**
	* 设置拒收邮件地址
	*/
	rejectAddress: function(address) {
		if (!confirm("您是否确认拒收 \""+ address +"\" 邮件地址？"))
			return;
		jQuery.post(
			'mail/mails_rejectAddress.json', 
			{
				address: address
			},
			function() {
				tipMsg("邮件拒收设置操作完成");
			}
		);
	},
	
	/**
	* 设置拒收邮件主题
	*/
	rejectSubject: function(subject) {
		if (!confirm("您是否确认拒收 \""+ subject +"\" 邮件主题？"))
			return;
		jQuery.post(
			'mail/mails_rejectSubject.json',
			{
				subject: subject
			},
			function() {
				tipMsg("邮件拒收设置操作完成");
			}
		);
	},
	
	/**
	* 设置拒收邮件域
	*/
	rejectDomain: function(address) {
		var domain = address.substring(address.indexOf("@")+1);
		if (!confirm("您是否确认拒收 \""+ domain +"\" 邮件域？"))
			return;
		jQuery.post(
			'mail/mails_rejectDomain.json',
			{
				domain: domain
			},
			function() {
				tipMsg("邮件拒收设置操作完成");
			}
		);
	},
	
	/**
	* 添加至个人通讯录(邮件查看页面)
	*/
	addPA: function(mail) {
		if (!confirm("您确认要把 \""+ mail +"\" 加入到个人通迅录吗？"))
			return;
		jQuery.post('mail/addPersonAddr.json', {mail: mail },function(data) {
			if (data.res != 'yes') {
				tipMsg(data.data);
				return;
			}
			tipMsg("加入到个人通迅录操作完成");
		},'json');
	},
	
	/**
	* 切换邮件显示页面的信头
	*/
	toggleInfo: function() {
		var mailinfo =$("#mail #subject a");
		if(mailinfo.attr('class') == 'btn-mailinfo'){
			mailinfo.removeClass('btn-mailinfo');
			mailinfo.addClass('btn-mailinfo-off');
		}else {
			mailinfo.removeClass('btn-mailinfo-off');
			mailinfo.addClass('btn-mailinfo');
		}
		
		
		$("#mail #shortInfo").toggle();
		$("#mail #info").toggle();
		//$("#content").dockIn('redraw');
	},
	
	/**
	* 转发，回复，全部回复
	*/
	viCompose: function(act) {
		$("#viewMail").html('');
		var url = "mail/compose.html?act=" + act+ "&folderid=" + Mail.folderid + "&parentuuid=" + Mail.uuid;
		Compose.build(url);
	},
	
	/**
	* 快速回复
	*/
	fastRestore: function() {
		var $restore = $('#fastRestoreArea');
		if($restore.val() == ""){
			alert("请您输入回复内容！");
			return ;
		}
   		
   		jQuery.post(
			'mail/fastRestore.json',
			{
				uuid: Mail.uuid,
				folderid: Mail.folderid,
				restore: $restore.val()
			},
			function(data) {
				if (data.res != 'yes') {
					alert(data.data);
				}
				$restore.val('');
				$('#restoreBody').show();
				
				//隐藏输入框
				$('#fastRestore .inputBody').hide();
			},
			'json'
		);
	},
	
	/**
	* 再快速回一封邮件
	*/
	showRestore: function() {
		$('#restoreBody').hide();
		
		$('#fastRestore .inputBody').show();
	}
	
};



MailPublicAddr = {
	toMails: function(id){
		var tomail =$("#publicAddrc li#pubpsn_" + id).attr("tomail").replace(/\"|\'/g, '"');
		var $tos = $("form#composeForm .checked");
		var tos = $tos.val();
		$tos.val(tos+tomail+",");
		$tos.trigger('focus');
	},
	
	toMailsAll: function(id){
		jQuery.getJSON(
			'publicAddr/getGroupToMails.json', 
			{
				groupid: id
			},
			function(data) {
				if ('yes' != data.res)
					return;
					
				var tomails = data.data.tomails;
				var $tos = $("form#composeForm .checked");
				var tos = $tos.val();
				$tos.val(tos+tomails);
				$tos.trigger('focus');
			}
		);
	},
	
	
	
	addPsn: function(id, data) {
		var name = data.displayname==""?data.mail:data.displayname;
		$("#publicAddrc li#" + id).children("ul.subPsns").append(''
			+ '<li id="pubpsn_' + data.uuid + '" class="grp" tomail="\''+data.displayname +'\'<'+data.mail+'>" >'
			+ '<span class="tree-psn"></span>'
			+ '<a class="psn" href="javascript:MailPublicAddr.toMails(\''+data.uuid+'\');">'+name+'</a>'
			+ '</li>'
		);
	},
	
	addGrp: function(data) {
		$("#publicAddrc li#grp_" + data.parentou).children("ul.subGrps").append(''
			+ '<li id="grp_' + data.ou + '" class="grp" parentuuid="'+data.parentou +'" >'
			+ '<a class="tree-handler tree-handler-close" href="javascript:MailPublicAddr.toggleFolder(\'grp_' + data.ou+ '\',\''+data.ou + '\')"></a>'
			+ '<a class="grp" title="'+ data.description +'" href="javascript:MailPublicAddr.toggleFolder(\'grp_' + data.ou + '\',\''+data.ou+'\')">'+subString(data.description, 20, true)+'('+(data.count)+')'+'</a>'
			+ '<a class="grpall" href="javascript:MailPublicAddr.toMailsAll(\''+data.ou+'\');">全选</a>'
			+ '<ul class="subPsns" style="display:block; padding-left:18px;">'
			+ '</ul>'
			+ '<ul class="subGrps">'
			+ '</ul>'
			+ '</li>'
		);
	},
	
	openFolder: function(id, ou) {
		var children = $("#publicAddrc li#" + id).children("a.grp");
		// 是否已打开过
		if(!children.hasClass("open")){
			children.addClass("open");
			
			//找出该节点下的用户
			jQuery.getJSON(
				'publicAddr/getNotes.json', 
				{
					groupid: ou
				},
				function(data) {
					if ('yes' != data.res)
						return;
						
					var psns = data.data.public_psns;
					
					for(var i = 0 ; i < psns.length; i++ ) {
						MailPublicAddr.addPsn(id, psns[i]);
					}	
				}
			);
			
			//找出子节点
			var treeid = id.substring(id.indexOf("_")+1);
			if(treeid=="")
				return ;
			jQuery.getJSON(
				'publicAddr/getChildrenNodes.json', 
				{
					uuid: treeid
				},
				function(data) {
					if ('yes' != data.res)
						return;
					var depts = data.data.depts;
					for(var i = 0 ; i < depts.length; i++ ) {
						MailPublicAddr.addGrp(depts[i]);
					}	
				}
			);
			
		}
		
		$("#publicAddrc li#" + id).children("ul.subPsns").show();
		$("#publicAddrc li#" + id).children("ul.subGrps").show();
		
		$("#publicAddrc li#" + id).children("a.tree-handler")
			.addClass("tree-handler-open")
			.removeClass("tree-handler-close");
			
		
	},

	closeFolder: function(id) {
		$("#publicAddrc li#" + id).children("ul.subPsns").hide();
		$("#publicAddrc li#" + id).children("ul.subGrps").hide();
		
		$("#publicAddrc li#" + id).children("a.tree-handler")
			.addClass("tree-handler-close")
			.removeClass("tree-handler-open");

	},
	
	toggleFolder: function(id, ou) {
		$folderHandler = $("#publicAddrc li#" + id).children("a.tree-handler");
		if ($folderHandler.hasClass("tree-handler-close")) {
			MailPublicAddr.openFolder(id, ou);
		}else {
			MailPublicAddr.closeFolder(id);
		}
	}

};


MailPersonAddr = {
	toMails: function(id){
		var tomail =$("#personAddrc li#grp_" + id).attr("tomail").replace(/\"|\'/g, '"');
		var $tos = $("form#composeForm .checked");
		var tos = $tos.val();
		$tos.val(tos+tomail+",");
		$tos.trigger('focus');
	},
	
	toMailsAll: function(id){
		jQuery.getJSON(
			'personAddr/getGroupToMails.json', 
			{
				groupid: id
			},
			function(data) {
				if ('yes' != data.res)
					return;
					
				var tomails = data.data.tomails;
				var $tos = $("form#composeForm .checked");
				var tos = $tos.val();
				$tos.val(tos+tomails);
				$tos.trigger('focus');
			}
		);
	},
	
	
	openFolder: function(id) {
		var children = $("#personAddrc li#" + id).children("a.grp");
		if(children.attr("class").indexOf("open")==-1){
			children.addClass("open");
			var treeid = id.substring(id.indexOf("_")+1);
			jQuery.getJSON(
				'personAddr/getNotes.json', 
				{
					groupid: treeid
				},
				function(data) {
					if ('yes' != data.res)
						return;
						
					var psns = data.data.person_psns;
					for(var i = 0 ; i < psns.length; i++ )
						MailPersonAddr.addPsn(psns[i]);
				}
			);
		}
		
		$("#personAddrc li#" + id).children("ul.subPsns").show();
		
		$("#personAddrc li#" + id).children("a.tree-handler")
			.addClass("tree-handler-open")
			.removeClass("tree-handler-close");
			
		
	},
	
	addPsn: function(data) {
		var name = data.displayname==""?data.mail:data.displayname;
		$("#personAddrc li#grp_" + data.groupid).children("ul.subPsns").prepend(''
			+ '<li id="grp_' + data.uuid + '" class="grp" tomail="\''+data.displayname +'\'<'+data.mail+'>" >'
			+ '<span class="tree-psn"></span>'
			+ '<a class="psn" href="javascript:MailPersonAddr.toMails(\''+data.uuid+'\');">'+name+'</a>'
			+ '</li>'
		);
	},

	closeFolder: function(id) {
		$("#personAddrc li#" + id).children("ul.subPsns").hide();
		
		$("#personAddrc li#" + id).children("a.tree-handler")
			.addClass("tree-handler-close")
			.removeClass("tree-handler-open");

	},
	
	toggleFolder: function(id) {
		$folderHandler = $("#personAddrc li#" + id).children("a.tree-handler");
		if ($folderHandler.hasClass("tree-handler-close")) {
			MailPersonAddr.openFolder(id);
		}else {
			MailPersonAddr.closeFolder(id);
		}
	}

};

/********** Mails Functions **********/

PersonAddr = {
	sortBy: '',
	isUp: '',
	pageNum: '',
	countPerPage: '',
	condition: '',
	keyword: '',
	groupid: '',
	
	selectAll: function() {
		var checked = $("#perAddrBody input#checkAll").attr("checked");
		this.selectAllForce(checked);
	},
	
	selectAllForce: function(checked) {
		$("#perAddrBody input.inputChkbox:checkbox").each(
			function() {
				$(this).attr("checked", checked ? "checked" : "");
				$(this).trigger("change");
			}
		);
	},
	
	open: function(groupid) {
		var url ='personAddr/main.html?groupid='+groupid;
		$('#gFMain').load(url);
	},

	openUrl: function(url) {
		$('#gFMain').load(url);
	},

	checkedUuids: function() {
		var uuids = [];
		$("input.inputChkbox:checkbox").each(function() {
			if ($(this).attr("checked") == "")
				return;
			uuids.push($(this).val());
		});
		return uuids;
	},
	
	checkUuids: function(uuids) {
		if (uuids.length != 0)
			return true;
		tipMsg("请先选择要操作的记录");
		return false;
	},
	
	viCompose: function() {
		var uuids = PersonAddr.checkedUuids();
		if (!PersonAddr.checkUuids(uuids))
			return;
		var tos = "";
		jQuery.getJSON(
			'personAddr/getTos.json', 
			{
				uuid: uuids
			},
			function(data) {
				if ('yes' != data.res)
					return;
				var url = "mail/compose.html?act=addr&tos=" +encodeURIComponent(data.data.tos);
				Compose.build(url);
			}
		);
	},
	
	addAddr: function(groupid) {
		var url = 'personAddr/contactForm.html?type=add&groupid='+groupid;
		$('#perAddrBody').load(url);
	},
	
	moveTo: function(groupid) {
		var uuids = PersonAddr.checkedUuids();
		if (!PersonAddr.checkUuids(uuids))
			return;
		jQuery.post(
			'personAddr/moveTo.json',
			{
				groupid: groupid,
				uuid: uuids
			},
			function() {
				tipMsg("通讯录移动操作完成");
				
				PersonAddr.open(groupid);
			}
		);
		
	},
	
	del: function(groupid) {
		var uuids = PersonAddr.checkedUuids();
		if (!PersonAddr.checkUuids(uuids))
			return;
		jQuery.post(
			'personAddr/del.json',
			{
				groupid: groupid,
				uuid: uuids
			},
			function() {
				tipMsg("通讯录删除操作完成");
				
				PersonAddr.open(groupid);
			}
		);
	},
	
	exportAll:function (){
		alert('暂未开通');
	},
	
	exportGroup:function (groupid){
		alert('暂未开通');
	},
	
	exportPsn:function (){
		alert('暂未开通');
	},
	
	insertPsns:function () {
		alert('暂未开通');
	},
	
	addGroup:function () {
		var url = 'personAddr/addGroup.html';
		$('#perAddrBody').load(url);
	},
	
	editGroup:function () {
		var groupid = $('#perAddrTreeBar li a.on').attr("uuid");
		if(groupid ==""){
			tipMsg("系统目录不能修改");
			return ;
		}
		var url = 'personAddr/editGroup.html?groupid='+groupid;
		$('#perAddrBody').load(url);
	},
	
	delGroup:function () {
		var $GroupBar = $('#perAddrTreeBar li a.on')
		
		var groupid = $GroupBar.attr("uuid");
		if(groupid ==""){
			tipMsg("系统目录不能删除");
			return ;
		}
		
		var count = $GroupBar.attr("count");
		if(parseInt(count)>0){
			tipMsg("该目录下还有成员不能删除");
			return ;
		}
		
		jQuery.post(
			'personAddr/delGroup.json',
			{
				groupid: groupid
			},
			function() {
				tipMsg("删除操作完成");
				
				PersonAddr.open('');
			}
		);
	},
	
	viPsn:function (groupid, uuid) {
		var url = 'personAddr/contactForm.html?type=view&groupid='+groupid +'&uuid='+uuid;
		$('#perAddrBody').load(url);
	},
	
	toMod:function (groupid, uuid) {
		var url = 'personAddr/contactForm.html?type=mod&groupid='+groupid +'&uuid='+uuid;
		$('#perAddrBody').load(url);
	},
	/*
	refresh: function() {
		tipMsg("刷新");
		var groupid =$('#perAddrTreeBar li a.on').atrr("id").substring(4);
		PersonAddr.open(groupid);
	},
	*/
	
	refresh: function(isFirstPage) {
		if (isFirstPage) {
			PersonAddr.pageNum = 1;
			PersonAddr.sortBy = 'displayname';
			PersonAddr.isUp = false;
			PersonAddr.condition = '';
			PersonAddr.keyword = '';
		}
		PersonAddr.pageNum = PersonAddr.pageNum ? PersonAddr.pageNum: 1;
		PersonAddr.countPerPage = PersonAddr.countPerPage ? PersonAddr.countPerPage : 20;
		var url ='personAddr/main.html?groupid='+PersonAddr.groupid;
		url += "&sortBy=" + PersonAddr.sortBy;	
		url += "&isUp=" + PersonAddr.isUp;				
		url += "&pageNum=" + PersonAddr.pageNum;			
		url += "&countPerPage=" + PersonAddr.countPerPage;
		
		if (PersonAddr.condition != '') {
			url += "&condition=" + PersonAddr.condition;
		}
		if (PersonAddr.keyword != '') {
			url += "&keyword=" + PersonAddr.keyword;
		}
		
		PersonAddr.openUrl(url);
	},

	sort: function(sortBy) {
		if (sortBy == PersonAddr.sortBy) {
			PersonAddr.isUp = PersonAddr.isUp=='false'?true:false;
		}else {
			PersonAddr.sortBy = sortBy;
			PersonAddr.isUp = true;
		}
		
		PersonAddr.refresh(false);
	}
	
}


/********** Mails Functions **********/
PublicAddr = {
	sortBy: '',
	isUp: '',
	pageNum: '',
	countPerPage: '',
	condition: '',
	keyword: '',
	groupid: '',
	
	selectAll: function() {
		var checked = $("#pubAddrBody input#checkAll").attr("checked");
		this.selectAllForce(checked);
	},
	
	selectAllForce: function(checked) {
		$("#pubAddrBody input.inputChkbox:checkbox").each(
			function() {
				$(this).attr("checked", checked ? "checked" : "");
				$(this).trigger("change");
			}
		);
	},
	
	open: function(groupid, treeid) {
		//初始化设置显示列表
		$('#pubAddrBody').show();
		$('#pubAddrViPsn').hide();
	
		$("ul#ctrPubDeptTree li a.grp").removeClass("selected");
		$("li#grp_" + treeid).children("a.grp").addClass("selected");
			
		if (null != treeid && treeid !='nogroup' && treeid !='all') {
			PublicAddr.openFolder("grp_" + treeid);
		}
		
		var url ='publicAddr/addrs.html?groupid='+groupid+'&treeid='+treeid;
		$('#pubAddrBody').load(url);
	},

	openUrl: function(url) {
		//初始化设置显示列表
		$('#pubAddrBody').show();
		$('#pubAddrViPsn').hide();
		
		$('#pubAddrBody').load(url);
	},

	checkedUuids: function() {
		var uuids = [];
		$("input.inputChkbox:checkbox").each(function() {
			if ($(this).attr("checked") == "")
				return;
			uuids.push($(this).val());
		});
		return uuids;
	},
	
	checkUuids: function(uuids) {
		if (uuids.length != 0)
			return true;
		tipMsg("请先选择要操作的记录");
		return false;
	},
	
	viCompose: function() {
		var uuids = PublicAddr.checkedUuids();
		if (!PublicAddr.checkUuids(uuids))
			return;
		
		jQuery.getJSON(
			'publicAddr/getTos.json', 
			{
				uuid: uuids
			},
			function(data) {
				if ('yes' != data.res)
					return;
				var url = "mail/compose.html?act=addr&tos="+encodeURIComponent(data.data.tos);
				Compose.build(url);
			}
		);
	},
	
	//tree
		
	//初始化加载树
	arrageTree: function() {
		$("ul#ctrPubDeptTree li.grp").each(function(i){
			var p_uuid = $(this).attr("parentuuid");
			
			if (p_uuid == "") { // 一级节点
				PublicAddr.openFolder($(this).attr("id"));
			}else {
				//将子节点都添加到父节点
				$(this).appendTo($("li#grp_" + p_uuid).children("ul.subGrps"));
				PublicAddr.closeFolder($(this).attr("id"));
			}
		});
	},
	
	openFolder: function(id) {
		var children = $("li#" + id).children("a.grp");
		if(children.attr("class").indexOf("open")==-1){
			children.addClass("open");
			
			var treeid = id.substring(id.indexOf("_")+1);
			jQuery.getJSON(
				'publicAddr/getChildrenNodes.json', 
				{
					uuid: treeid
				},
				function(data) {
					if ('yes' != data.res)
						return;
					var depts = data.data.depts;
					for(var i = 0 ; i < depts.length; i++ )
						PublicAddr.addGrp(depts[i]);
				}
			);
		}
		
		$("li#" + id).children("ul.subGrps").show();
		
		$("li#" + id).children("a.tree-handler")
			.addClass("tree-handler-open")
			.removeClass("tree-handler-close");
			
		$("li#" + id).children("span.tree-icon")
			.addClass("tree-icon-open")
			.removeClass("tree-icon-close");
		
	},
	
	addGrp: function(data) {
		$("li#grp_" + data.parentuuid).children("ul.subGrps").prepend(''
			+ '<li id="grp_' + data.uuid + '" class="grp" parentuuid="'+data.parentuuid +'" >'
			+ '<a class="tree-handler tree-handler-close" href="javascript:PublicAddr.toggleFolder(\'grp_' + data.uuid + '\')"></a>'
			+ '<a class="grp" href="javascript:PublicAddr.open(\''+data.ou+'\',\'' +data.uuid+ '\')">'+data.description+'('+(data.count)+')'+'</a>'
			+ '<ul class="subGrps">'
			+ '</ul>'
			+ '</li>'
		);
	},

	closeFolder: function(id) {
		$("li#" + id).children("ul.subGrps").hide();
		
		$("li#" + id).children("a.tree-handler")
			.addClass("tree-handler-close")
			.removeClass("tree-handler-open");
	},
	
	toggleFolder: function(id) {
		$folderHandler = $("li#" + id).children("a.tree-handler");
		if ($folderHandler.hasClass("tree-handler-close")) {
			PublicAddr.openFolder(id);
		}else {
			PublicAddr.closeFolder(id);
		}
	},
	
	viPsn: function(uid, dc) {
		var url = 'publicAddr/contactForm.html?uid='+uid +'&dc='+dc;
		$('#pubAddrBody').hide();
		$('#pubAddrViPsn').load(url).show();
	},
	
	back: function() {
		$('#pubAddrBody').show();
		$('#pubAddrViPsn').hide();
	},
	
	copyToPsn: function() {
		var uuids = PublicAddr.checkedUuids();
		if (!PublicAddr.checkUuids(uuids))
			return;
		jQuery.post(
			'publicAddr/copyToPsn.json',
			{
				uuid: uuids
			},
			function() {
				tipMsg("复制操作完成");
			}
		);
	},
	
	refresh: function(isFirstPage) {
		if (isFirstPage) {
			PublicAddr.pageNum = 1;
			PublicAddr.sortBy = 'displayname';
			PublicAddr.isUp = false;
			PublicAddr.condition = '';
			PublicAddr.keyword = '';
		}
		PublicAddr.pageNum = PublicAddr.pageNum ? PublicAddr.pageNum: 1;
		PublicAddr.countPerPage = PublicAddr.countPerPage ? PublicAddr.countPerPage : 20;
		//var url ='PublicAddr/main.html?groupid='+PublicAddr.groupid;
		var url ='publicAddr/addrs.html?groupid='+PublicAddr.groupid;
		url += "&sortBy=" + PublicAddr.sortBy;	
		url += "&isUp=" + PublicAddr.isUp;				
		url += "&pageNum=" + PublicAddr.pageNum;			
		url += "&countPerPage=" + PublicAddr.countPerPage;
		
		if (PublicAddr.condition != '') {
			url += "&condition=" + PublicAddr.condition;
		}
		if (PublicAddr.keyword != '') {
			url += "&keyword=" + PublicAddr.keyword;
		}
		PublicAddr.openUrl(url);
	},

	sort: function(sortBy) {
		if (sortBy == PublicAddr.sortBy) {
			PublicAddr.isUp = PublicAddr.isUp=='false'?true:false;
		}else {
			PublicAddr.sortBy = sortBy;
			PublicAddr.isUp = true;
		}
		
		PublicAddr.refresh(false);
	}
};

/********** NetDisk Functions **********/
NetDisk = {
	selectAll: function() {
		var checked = $("#netdiskBody input#checkAll").attr("checked");
		this.selectAllForce(checked);
	},
	
	selectAllForce: function(checked) {
		$("#netdiskBody input.inputChkbox:checkbox").each(
			function() {
				$(this).attr("checked", checked ? "checked" : "");
				$(this).trigger("change");
			}
		);
	},
	
	checkedUuids: function() {
		var uuids = [];
		$("input.inputChkbox:checkbox").each(function() {
			if ($(this).attr("checked") == "")
				return;
			uuids.push($(this).val());
		});
		return uuids;
	},
	
	checkUuids: function(uuids) {
		if (uuids.length != 0)
			return true;
		tipMsg("请先选择要操作的记录");
		return false;
	},
	
	/**
	* 打开网络U盘
	* groupid: 组id
	*/
	open: function(groupid) {
		$('#netdiskTreeBar li a').removeClass("on");
		$('#netdiskTreeBar ul a').each(
			function() {
				var uuid =$(this).attr("uuid").replace(/\\|\//g,'');
				var newGroupid = groupid.replace(/\\|\//g,'');
				
				if(uuid==newGroupid)
					$(this).addClass("on");	
			}
		);
		
		var url ='netdisk/files.html?groupid='+groupid;
		$('#netdiskBody').load(url);
	},

	/**
	* 打开网络U盘 （全局）
	* url: netdisk/files.html
	*/
	openUrl: function(url) {
		$("#gFMain").load(url);
	},
	
	/**
	* 搜索网络U盘
	*/
	search: function(){
		var uuid = $('#netdiskTreeBar li a.on').attr("uuid");
		var keyword = encodeURIComponent($('#searchText').val());
		var url ='netdisk/files.html?groupid='+uuid+'&keyword='+keyword;
		NetDisk.openUrl(url);
	},
	
	/**
	* 刷新网络U盘
	*/
	refresh:function() {
		var uuid = $('#netdiskTreeBar li a.on').attr("uuid");
		var url ='netdisk/files.html?groupid='+uuid;
		$('#netdiskBody').load(url);
	},
	
	/**
	* 刷新占用空间
	*/
	refreshSize:function() {
		$('#NetDiskSize').load("netdisk/size.html");
	},

	/**
	* 整体刷新
	*/	
	refreshAll: function() {
		var url ='netdisk/main.html';
		$("#gFMain").load(url);
	},

	/**
	* 移动指定组
	* groupid : 组id
	*/
	moveTo: function(groupid) {
		var uuids = NetDisk.checkedUuids();
		if (!NetDisk.checkUuids(uuids))
			return;
		jQuery.post(
			'netdisk/moveTo.json',
			{
				groupid: groupid,
				uuid: uuids
			},
			function(data) {
				if(data.res !='yes'){
					alert(data.data);
					return ;
				}
				tipMsg("网络U盘移动操作完成");
				
				NetDisk.open(groupid);
			},
			'json'
		);
		
	},
	
	/**
	* 上传文件
	*/	
	addFile:function () {
		var uuid = $('#netdiskTreeBar li a.on').attr("uuid");
		var url = 'netdisk/addFile.html?groupid='+uuid;
		$('#netdiskBody').load(url);
	},
	
	/**
	* 删除选中文件
	*/	
	del: function() {
		var uuids = NetDisk.checkedUuids();
		if (!NetDisk.checkUuids(uuids))
			return;
			
		if(!confirm('您确定要删除选中的记录吗?'))
			return;
				
		jQuery.post(
			'netdisk/del.json',
			{
				uuid: uuids
			},
			function(data) {
				if(data.res !='yes'){
					alert(data.data);
					return ;
				}
				tipMsg("网络U盘删除操作完成");
				
				NetDisk.refresh();
				
				NetDisk.refreshSize();
			},
			'json'
		);
	},
	
	/**
	* 增加组
	*/	
	addFolder:function () {
		var url = 'netdisk/addFolder.html';
		$('#netdiskBody').load(url);
	},
	
	/**
	* 删除组
	*/
	delFolder:function () {
		var uuid = $('#netdiskTreeBar li a.on').attr("uuid");
		if(uuid == '/' || uuid == '\\') {
			tipMsg("根目录不能删除!");
			return;
		}
			
		
		if(!confirm('您确定要删除选中的记录吗?'))
			return;
		
		jQuery.post(
			'netdisk/delFolder.json',
			{
				uuid: uuid
			},
			function(data) {
				if(data.res !='yes'){
					var errmsg = data.data;
					errmsg += "!\n\n可能原因：该目录下面存在文件, 请先删除目录下的文件.";
					alert(errmsg);
					return ;
				}
				tipMsg("网络U盘删除操作完成");
				
				NetDisk.refreshAll();
			},
			'json'
		);
	}
	
};


/********** Bookmark Functions **********/
var Bookmark = {
	selectAll: function() {
		var checked = $("#BookmarkBody input#checkAll").attr("checked");
		this.selectAllForce(checked);
	},
	
	selectAllForce: function(checked) {
		$("#BookmarkBody input.inputChkbox:checkbox").each(
			function() {
				$(this).attr("checked", checked ? "checked" : "");
				$(this).trigger("change");
			}
		);
	},
	
	checkedUuids: function() {
		var uuids = [];
		$("input.inputChkbox:checkbox").each(function() {
			if ($(this).attr("checked") == "")
				return;
			uuids.push($(this).val());
		});
		return uuids;
	},
	
	checkUuids: function(uuids) {
		if (uuids.length != 0)
			return true;
		tipMsg("请先选择要操作的记录");
		return false;
	},
	
	/**
	* 打开书签组
	* forderuuid: 组id
	*/
	open: function(forderuuid) {
		$('#BookmarkTreeBar li a').removeClass("on");
		$('#BookmarkTreeBar ul a#forder_'+forderuuid).addClass("on");
		
		var url ='bookmark/items.html?folderuuid='+forderuuid;
		$('#BookmarkBody').load(url);
	},
	
	/**
	* 打开整个书签页面
	* url: bookmark/main.html
	*/
	openUrl: function(url) {
		$("#gFMain").load(url);
	},

	/**
	* 添加书签界面返回（取消按钮）
	*/
	back:function() {
		//找出当前选中的组
		var uuid = $('#BookmarkTreeBar li a.on').attr("uuid");
		
		var url ='bookmark/items.html?folderuuid='+uuid;
		$('#BookmarkBody').load(url);
	},
	
	/**
	* 刷新当前书签列表
	*/
	refresh:function() {
		//找出当前选中的组
		var uuid = $('#BookmarkTreeBar li a.on').attr("uuid");
		
		var url ='bookmark/items.html?folderuuid='+uuid;
		$('#BookmarkBody').load(url);
	},
	
	/**
	* 添加书签
	*/
	addItem: function () {
		var uuid = $('#BookmarkTreeBar li a.on').attr("uuid");
		var url = 'bookmark/addItem.html?folderuuid='+uuid;
		$('#BookmarkBody').load(url);
	},
	
	/**
	* 删除书签
	*/
	delItem: function() {
		var uuids = Bookmark.checkedUuids();
		if (!Bookmark.checkUuids(uuids))
			return;
			
		if(!confirm('您确定要删除选中的记录吗?'))
			return;
				
		jQuery.post(
			'bookmark/delItem.json',
			{
				uuid: uuids
			},
			function(data) {
				if(data.res !='yes'){
					alert(data.data);
					return ;
				}
				tipMsg("网上书签删除操作完成");
				
				Bookmark.refresh();
				
			},
			'json'
		);
	},
	
	/**
	* 修改书签
	*/
	modItem: function() {
		var uuids = Bookmark.checkedUuids();
		if (!Bookmark.checkUuids(uuids))
			return;
		
		var url = 'bookmark/modItem.html?itemuuid='+uuids[0];
		$('#BookmarkBody').load(url);
	},

	/**
	* 复制书签到
	* forderid: 书签组id
	*/
	copyTo: function(folderuuid) {
		var uuids = Bookmark.checkedUuids();
		if (!Bookmark.checkUuids(uuids))
			return;
		jQuery.post(
			'bookmark/copyTo.json',
			{
				folderuuid: folderuuid,
				uuid: uuids
			},
			function(data) {
				if(data.res !='yes'){
					alert(data.data);
					return ;
				}
				tipMsg("网上书签复制操作完成");
				
				Bookmark.open(folderuuid);
			},
			'json'
		);
		
	},
		
	/**
	* 移动书签到
	* forderid: 书签组id
	*/
	moveTo: function(folderuuid) {
		var uuids = Bookmark.checkedUuids();
		if (!Bookmark.checkUuids(uuids))
			return;
		jQuery.post(
			'bookmark/moveTo.json',
			{
				folderuuid: folderuuid,
				uuid: uuids
			},
			function(data) {
				if(data.res !='yes'){
					alert(data.data);
					return ;
				}
				tipMsg("网上书签移动操作完成");
				
				Bookmark.open(folderuuid);
			},
			'json'
		);
		
	},
	
	/**
	* 导入书签
	*/
	importItems: function () {
		var uuid = $('#BookmarkTreeBar li a.on').attr("uuid");
		var url = 'bookmark/importItems.html?folderuuid='+uuid;
		$('#BookmarkBody').load(url);
	},
	
	/**
	* 添加书签的目录
	*/
	addFolder:function () {
		var url = 'bookmark/addFolder.html';
		$('#BookmarkBody').load(url);
	},
	
	/**
	* 修改书签组
	*/
	modFolder:function () {
		//获取选中的栏目id
		var uuid = $('#BookmarkTreeBar li a.on').attr("uuid");
		
		var url = 'bookmark/modFolder.html?folderuuid='+uuid;
		$('#BookmarkBody').load(url);
	},
	
	/**
	* 删除书签组
	*/
	delFolder:function () {
		//获取选中的组id
		var uuid = $('#BookmarkTreeBar li a.on').attr("uuid");
		if(uuid == '') {
			tipMsg("根目录不能删除!");
			return;
		}
		
		if(!confirm('您确定要删除选中的书签组吗?')) {
			return;
		}
		
		jQuery.post(
			'bookmark/delFolder.json',
			{
				uuid: uuid
			},
			function(data) {
				if(data.res !='yes'){
					alert(data.data);
					return ;
				}
				tipMsg("网上书签组删除操作完成");
				
				Bookmark.openUrl('bookmark/main.html');
			},
			'json'
		);
	}
	
};



/********** Location Hash **********/
function setHash(hash){
	window.location.hash = hash;
}

$(window).hashchange(function(){
	doHash();
});

function doHash() {
	var h = window.location.hash;
	if(h == '#') h = '';
	var f = HashMap.get(h);
	if(typeof f == 'function') {
		f();	
	}
}

if(typeof HashMap == 'undefined') HashMap = {};
HashMap = {
	'': function() {
		HeadMenu.index();
	},
	'#inbox': function() {
		MailFolders.open('inbox')
	},
	'#draft': function() {
		MailFolders.open('draft');
	},
	'#sent': function() {
		MailFolders.open('sent');
	},
	'#trash': function() {
		MailFolders.open('trash');
	},
	'#personAddr': function() {
		SideBar.open('#personAddr', 'personAddr/main.html');
	},
	'#publicAddr': function() {
		SideBar.open('#publicAddr', 'publicAddr/main.html');
	},
	'#fd_netdisk': function() {
		SideBar.open('#fd_netdisk', 'netdisk/main.html');
	},
	'#fd_bookmark': function() {
		SideBar.open('#fd_bookmark', 'bookmark/main.html');
	},
	'#ufm': function() {
		MailFolders.openFolders();
	},
	'#options': function() {
		HeadMenu.options();
	},
	'#skins': function() {
		HeadMenu.skins();
	},
	
	get: function(h) {
		return this[h];
	},
	set: function(k, f) {
		this[k] = f;
	}
}



