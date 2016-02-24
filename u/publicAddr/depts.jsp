<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style type="text/css">

ul.tree {
	margin-bottom: 50px;
	padding-bottom: 50px;
}

ul.tree li#grp_search {
	display: none;
}
ul.tree li a.grp {
	display: block;
}
</style>


<ul id="ctrPubDeptTree" class="tree">
	<li id="grp_all" parentuuid="">
		<a class="tree-handler" href="javascript:PublicAddr.toggleFolder('grp_all')"></a>
		<a id="grp_all" class="grp" href="javascript:PublicAddr.open('all', 'all')">
			所有联系人
			<span>(<c:out value='${allPublicCount}'/>)</span>
		</a>
	
		<ul id="DEPT_ROOT" class="subGrps" style="display:block; padding-left:12px;" >
			<li id="grp_nogroup"  parentuuid="">
				<a class="tree-handler" href="javascript:PublicAddr.toggleFolder('grp_nogroup')"></a>
				<a id="grp_nogroup" class="grp" href="javascript:PublicAddr.open('nogroup', 'nogroup')">
					未分组联系人
					<span>(<c:out value='${noGroupPublicCount}'/>)</span>
				</a>
			</li>
		</ul>
		
	</li>
</ul>

<script type="text/javascript">
var DeptTree = {
	jsonstr: {},
	
	init: function(jsonstr) {
		this.jsonstr = jsonstr;
	},
	
	create: function() {
		this.buildChild(this.jsonstr["ROOT"], $('#DEPT_ROOT'));
	},
	
	buildD: function(dept, ctr) {
		var str = "<li id='grp_" + dept.ou + "' class='grp' parentuuid='" + dept.parentou +"'></li>";
		var $li = $(str);
		$li.append("<a class='tree-handler tree-handler-close' href='javascript:PublicAddr.toggleFolder(\"grp_"+ dept.ou +"\")'></a>");
		$li.append("<a class='grp' title='" + dept.description + "' href='javascript:PublicAddr.open(\""+ dept.ou +"\", \"" + dept.ou + "\")'>"+ subString(dept.description, 20, true) + "(" + dept.count + ")" +"</a>");
		var $li_ctr = $("<ul class='subGrps'></ul>");
		$li.append($li_ctr);
		$li.appendTo(ctr);
		
		this.buildChild(this.jsonstr[dept.ou], $li_ctr);
	},
	
	buildChild: function(arr, ctr) {
		if(!arr || !arr.length || arr.length == 0) 
			return;
			
		for(var i = 0;i < arr.length; i++) {
			var d = arr[i];
			this.buildD(d, ctr);
		}
	}
};


$(document).ready(function() {
	DeptTree.init(<c:out value='${treejson}' escapeXml='false'/>);
	DeptTree.create();
});
</script>