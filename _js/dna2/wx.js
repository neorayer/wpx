;(function($){
	
Enhance = {
	menuButton : function() {
		$(document).click(function(e) {
			$target = $(e.target).parent();
			if($target.hasClass('wxMenuButton')) {
				$target.next().show();
				$target.blur(function() {
					$(this).next().fadeOut('fast');
				});
			}
		 });
	}
}


$(document).ready(function() {
	$.ajaxSetup ({
	    cache: false //关闭AJAX相应的缓存
	});

	/********** Enahnce menuButton **********/
	Enhance.menuButton();
});


/* 利用Post方式进行download操作 */
$.postDownload = function(url, params) {
	var form = document.getElementById("downloadForm");
	if (form != null)
		document.body.removeChild(form);
	var form = document.createElement("form");
	form.id = "downloadForm";
	form.action = url;
	form.method = "post";
	form.style.display = "none";
	
	for(var k in params) {
		if (typeof params[k] == 'object') {
			for(var pK in params[k]) {
				var input = document.createElement("input");
				input.name = k;
				input.value = params[k][pK];
				form.appendChild(input);
			}
		}else {
			var input = document.createElement("input");
			input.name = k;
			input.value = params[k];
			form.appendChild(input);
		}
	}
	
	document.body.appendChild(form);
	form.submit();
}

/********************
 * Util 
 *******************/
Util = {
	num: function(s) {
		var n = parseInt(s, 0);
		return n ? n : 0;
	}
}

Dom = {
	getPadding: function(expr) {
		var $expr = $(expr);
		$expr = $expr[0] == window ? $(document.body) : $expr;
		return {
			l:  Util.num($expr.css("padding-left"), 0),
			t:  Util.num($expr.css("padding-top"), 0),
			r:  Util.num($expr.css("padding-right"), 0),
			b:  Util.num($expr.css("padding-bottom"), 0)
		}
	},
	
	getMargin: function(expr) {
		var $expr = $(expr);
		$expr = $expr[0] == window ? $(document.body) : $expr;
		return {
			l:  Util.num($expr.css("margin-left"), 0),
			t:  Util.num($expr.css("margin-top"), 0),
			r:  Util.num($expr.css("margin-right"), 0),
			b:  Util.num($expr.css("margin-bottom"), 0)
		}
	},

	getBorder: function(expr) {
		var $expr = $(expr);
		if ($expr[0] == window)
			return {l: 0, t: 0, r: 0, b: 0};
		return {
			l:  Util.num($expr.css("borderLeftWidth"), 0),
			t:  Util.num($expr.css("borderTopWidth"), 0),
			r:  Util.num($expr.css("borderRightWidth"), 0),
			b:  Util.num($expr.css("borderBottomWidth"), 0)
		}
	},

	// 包括border, 包括 margin
	getOutSize: function(expr) {
		var $expr = $(expr);
		var margin = Dom.getMargin(expr); 
		if ($expr[0] == document.body)
			return {w: $(window).width(), h: $(window).height()};
		return {w: $expr.outerWidth() + margin.l + margin.r, h: $expr.outerHeight() + margin.t + margin.b};
	},

	// 包括border, 包括 margin
	getOutRect: function(expr) {
		var offset = Dom.getOffset(expr);

		var outSize = Dom.getOutSize(expr);
		var rect = {
			l: offset.l,
			t: offset.t,
			w: outSize.w,
			h: outSize.h
		}
		rect.r = rect.l + rect.w;
		rect.b = rect.t + rect.h;
		return rect;
	},
	
	//取得4个元素中间的Rect
	getCenterRect: function(t, r, b, l) { // 4 args is expr
		var tR = Dom.getOutRect(t);
		var rR = Dom.getOutRect(r);
		var bR = Dom.getOutRect(b);
		var lR = Dom.getOutRect(l);
		return {
			l: lR.r,
			t: tR.b,
			w: rR.l - lR.b,
			h: bR.t - rR.b,
			r: rR.l,
			b: bR.t
		}
	},
	
	//在padding内部
	getInnerSize: function(expr) {
		var padding = Dom.getPadding(expr); 
		var margin = Dom.getMargin(expr); 
		var border = Dom.getBorder(expr); 
		var outSize = Dom.getOutSize(expr);
		return {
			w: outSize.w - padding.l - padding.r - border.l - border.r - margin.l - margin.r,
			h: outSize.h - padding.t - padding.b - border.t - border.b - margin.t - margin.b
		}
	},

	getOffset: function(expr) {
		var $expr = $(expr);
		var pos = $expr.position();
		if ($expr.size() == 0)
			return {l: 0, t: 0};
		return {
			l: parseInt($expr.css("left")) || pos.left,
			t: parseInt($expr.css("top")) || pos.top
		}
	},
	
	//设置相对父类容器的位置
	setOffset: function(expr, l, t) {
		$(expr)
			.css("position", "absolute")
			.css("left", l + "px")
			.css("top", t + "px");
	},

	//设置包括margin在内的最外框大小	
	setOutSize: function(expr, w, h) {
		var padding = Dom.getPadding(expr); 
		var margin = Dom.getMargin(expr); 
		var border  = Dom.getBorder(expr); 
		var width = w - margin.l - margin.r - padding.l - padding.r - border.l - border.r;
		var height = h - margin.t - margin.b - padding.t - padding.b- border.t - border.b;
		$(expr)
			.width(width)
			.height(height);
	}	
}

/********************
 * Dock 
 *******************/
$.widget("ui.dockIn", {
	_init: function() {
		var options = this.options,
			pos = options.pos,
			self = this,
			$expr = $(this.element),
			$toExpr = $expr.parent(),
			$r = $toExpr;
			
		if ($toExpr[0] == document.body) {
			$r = $(window);
		}
		options.container = $toExpr;
		
		if (! $.browser.msie)
			$r = $(window);

		$expr.css("overflow", options.overflow);
		$toExpr.css("overflow", "hidden");
		
		$r.resize(function() {
			self.redraw();
		});
		
		self.redraw();
	},
	
	redraw: function() {
		this[this.options.pos]();
	},

	lb: function() {
		var expr = this.element;
		var $toExpr = this.options.container;
		var size = Dom.getOutSize(expr);
		var padding = Dom.getPadding($toExpr);
		var margin = Dom.getMargin(expr);
		var innerSize = Dom.getInnerSize($toExpr);
		Dom.setOffset(expr, padding.l, innerSize.h - size.h  + padding.t);
	},
	
	rb: function() {
		var expr = this.element;
		var $toExpr = this.options.container;
		var size = Dom.getOutSize(expr);
		var padding = Dom.getPadding($toExpr);
		var margin = Dom.getMargin(expr);
		var innerSize = Dom.getInnerSize($toExpr);
		Dom.setOffset(expr, innerSize.w - size.w  + padding.l, innerSize.h - size.h + padding.t);
	},
	
	lt: function() {
		var expr = this.element;
		var $toExpr = this.options.container;
		var padding = Dom.getPadding($toExpr);
		var innerSize = Dom.getInnerSize($toExpr);
		Dom.setOffset(expr, padding.l, padding.t);
	},

	rt: function() {
		var expr = this.element;
		var $toExpr = this.options.container;
		var size = Dom.getOutSize(expr);
		var padding = Dom.getPadding($toExpr);
		var margin = Dom.getMargin(expr);
		var innerSize = Dom.getInnerSize($toExpr);
		Dom.setOffset(expr, innerSize.w - size.w + padding.l, padding.t);
	},
	
	l: function() {
		var expr = this.element,
			options = this.options,
			$toExpr = this.options.container,
			size = Dom.getOutSize(expr),
			padding = Dom.getPadding($toExpr),
			innerSize = Dom.getInnerSize($toExpr),
			pos = $(expr).position(),
			l = pos.left,
			t = pos.top;
		if (options.beside)
			l = Dom.getOutRect(options.beside).r;
		Dom.setOutSize(expr, size.w, innerSize.h);
		Dom.setOffset(expr, l, t);
	},

	t: function() {
		var expr = this.element,
			options = this.options,
			$toExpr = this.options.container,
			size = Dom.getOutSize(expr),
			padding = Dom.getPadding($toExpr),
			innerSize = Dom.getInnerSize($toExpr),
			pos = $(expr).position(),
			l = pos.left,
			t = pos.top;
		if (options.beside)
			t = Dom.getOutRect(options.beside).b;
		Dom.setOutSize(expr, innerSize.w, size.h);
		Dom.setOffset(expr, l, t);
	},
	
	b: function() {
		var expr = this.element,
			options = this.options,
			$toExpr = this.options.container,
			size = Dom.getOutSize(expr),
			padding = Dom.getPadding($toExpr),
			innerSize = Dom.getInnerSize($toExpr),
			pos = $(expr).position();
		Dom.setOutSize(expr, innerSize.w, size.h);
		var size = Dom.getOutSize(expr);
		var l = pos.left;
		var t = innerSize.h - size.h + padding.t;
		if (options.beside)
			t = Dom.getOutRect(options.beside).t - size.h;
		Dom.setOffset(expr, l, t);

	},
	
	r: function() {
		var expr = this.element,
			options = this.options,
			$toExpr = this.options.container,
			size = Dom.getOutSize(expr),
			padding = Dom.getPadding($toExpr),
			innerSize = Dom.getInnerSize($toExpr),
			pos = $(expr).position();
		Dom.setOutSize(expr, size.w, innerSize.h);
		var size = Dom.getOutSize(expr);
		var l = innerSize.w - size.w + padding.l;
		var t = pos.top;
		if (options.beside)
			l = Dom.getOutRect(options.beside).l - size.w;
		Dom.setOffset(expr, l, t);
	},
	
	f: function() {
		var expr = this.element,
			options = this.options,
			$toExpr = this.options.container,
			size = Dom.getOutSize(expr),
			padding = Dom.getPadding($toExpr),
			margin = Dom.getMargin(expr),
			pos = $(expr).position(),
			innerSize = Dom.getInnerSize($toExpr),
			l = pos.left,
			t = pos.top,
			r = padding.l + innerSize.w ,
			b = padding.t + innerSize.h ;
		if (options.left) {
			var rect = Dom.getOutRect(options.left);
			l = rect.r;
		}
		if (options.top) {
			var rect = Dom.getOutRect(options.top);
			t = rect.b;
		}
		if (options.bottom) {
			var rect = Dom.getOutRect(options.bottom);
			b = rect.t;
		}
		if (options.right) {
			var rect = Dom.getOutRect(options.right);
			r = rect.l;
		}
		var w = r - l;
		var h = b - t;
		Dom.setOutSize(expr, w, h);
		Dom.setOffset(expr, l, t);
	}
});

$.extend($.ui.dockIn, {
	defaults: {
		pos: 'f',
		overflow: 'auto'
	}
});

/********************
 * Splitter
 * ********************/

$.widget("ui.splitter", {
	_init: function() {
		var options = this.options,
			width = options.width,
			pos = options.pos,
			$expr = this.element,
			$part1 = $expr.children().eq(0),
			$part2 = $expr.children().eq(1),
			$partWrapper = $("<div></div>")
				.prependTo($expr)
				.addClass("wxSplitter-partWrapper")
				.css("position", "absolute");
		$expr.css("position", "absolute");
		if (options.dock)
			$expr.dockIn(options.dock);
		var resizeHandles = "all";
		switch(pos) {
			case 'l':
				$partWrapper[0].appendChild($part1[0]);
				$partWrapper.width(width);
				$partWrapper.css("padding-right", "3px");

				$part2.dockIn({pos: 'f', left: $partWrapper});
				$partWrapper.dockIn({pos: pos});
				$part1.dockIn({pos: 'f', overflow: options.overflow});
				
				resizeHandles = "e";
				break;
			case 'r':
				$partWrapper[0].appendChild($part2[0]);
				$partWrapper.width(width);

				$partWrapper.dockIn({pos: pos});
				$part2.dockIn({pos: 'f', overflow: options.overflow});
				$part1.dockIn({pos: 'f', right: $partWrapper});
				
				resizeHandles = "w";
				break;
			case 't':
				$partWrapper[0].appendChild($part1[0]);
				$partWrapper.height(width);

				$partWrapper.dockIn({pos: pos});
				$part1.dockIn({pos: 'f', overflow: options.overflow});
				$part2.dockIn({pos: 'f', top: $partWrapper});
				
				resizeHandles = "s";
				break;
			case 'b':
				$partWrapper[0].appendChild($part2[0]);
				$partWrapper.height(width);
				$partWrapper.css("padding-top", "3px");
				
				$partWrapper.dockIn({pos: pos});
				$part2.dockIn({pos: 'f', overflow: options.overflow});
				$part1.dockIn({pos: 'f', bottom: $partWrapper});
				
				resizeHandles = "n";
				break;
		}
		
		if (options.resizable) {
			$partWrapper.resizable({
				handles: resizeHandles,
				transparent: true,
				resize: function() {
					if (! $.browser.msie)
						$(window).trigger('resize');
					else {
						$part1.dockIn("redraw");
						$part2.dockIn("redraw");
					}
				},
				start: function() {
				},
				stop: function() {
				}
			});
		}
	}
});

$.extend($.ui.splitter, {
	defaults: {
		pos: 'l',
		width: 180,
		dock: {pos: 'f'},
		resizable: true
	}
});

})(jQuery);