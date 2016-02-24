package org.apache.jsp.a.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class domainGrpUsers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/lib_json.js\"></script>\r\n");
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../_css/user.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#page-head-box {\r\n");
      out.write("\tbackground-color:#43A625;\r\n");
      out.write("\tpadding:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#page-title-box {\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#mbr-head-box {\r\n");
      out.write("\tbackground-color:#CCCCCC;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#mbr-title-box {\r\n");
      out.write("\tfont-size:14px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tpadding:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("#deptDataTree\tul{\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\tmargin-left:15px;\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree\tli{\r\n");
      out.write("\tlist-style:none;\r\n");
      out.write("\tmargin-top:1px;\r\n");
      out.write("\tmargin-bottom:1px;\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree\tli ul{\r\n");
      out.write("\tdisplay:none;\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree span{\r\n");
      out.write("\tbackground-color:#eeeeee;\r\n");
      out.write("\tcolor:#666666;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree span.on{\r\n");
      out.write("\tbackground-color:#0022ff;\r\n");
      out.write("\tcolor:#fff;\t\t\t\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree span.t{\r\n");
      out.write("\tpadding:0 3px;\r\n");
      out.write("}\t\t\r\n");
      out.write("#deptDataTree span.closed{\r\n");
      out.write("\tbackground: url(icon/folder_closed.gif) 0 0 no-repeat;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\tpadding:2px 6px 1px 6px;\r\n");
      out.write("\tmargin:3px 0;\r\n");
      out.write("\tcolor:#fff;\t\t\t\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree span.opened{\r\n");
      out.write("\tbackground: url(icon/folder_opened.gif) 0 0 no-repeat;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\tmargin: 3px 0;\r\n");
      out.write("\tpadding:2px 6px 1px 6px;\r\n");
      out.write("\tcolor:#fff;\t\t\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"page-head-box\">\r\n");
      out.write("\t<div id=\"page-title-box\">");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write(" 群组用户</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("var grpDs;\r\n");
      out.write("var memberDs;\r\n");
      out.write("\r\n");
      out.write("var curDc = \"");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("\";\r\n");
      out.write("var addDeptToGrpURL = \"grpMemberAddFromDept.json?dc=\" + curDc;\r\n");
      out.write("var depDesc = [];\r\n");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("function VF_safetyStr(v){\r\n");
      out.write("\tif(v=='hr')return;\r\n");
      out.write("\tif(v.length<=3)\r\n");
      out.write("\t\treturn \"用户名长度须大于3，且不包含@及域名\";\r\n");
      out.write("\tvar s = VF_SafeStr_MY(v);\r\n");
      out.write("\tif(s!=null)\r\n");
      out.write("\t\treturn s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function VF_SafeStr_MY(v){\r\n");
      out.write("\tptn = /^[A-Za-z]+[0-9A-Za-z_.]+[A-Za-z0-9]$/;\r\n");
      out.write("\tvar flg = ptn.test(v);\r\n");
      out.write("\tif (!flg ) return \"由数字、字母或下划线组成,以字母开头\";\r\n");
      out.write("\treturn null;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function listDep(ctr){\r\n");
      out.write("\tSkyDNA.Event.addEvent(ctr,'onclick',function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//\tcreatae popwin to list department data tree\r\n");
      out.write("\t \tdepwin = SkyDNA.Element.createPopupWin({title: curDc + '部门列表',width: 350,height:380});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar treeCtr = _CC(\"div\", null, depwin.contentDom);\r\n");
      out.write("\t\ttreeCtr.innerHTML =  '<div id=\"deptDataTree\"><ul><li><span title=\"打开/折叠\" id=\"rootECBtn\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span><span _data=\"\" onclick=\"selectBranch(this);\" class=\"t\">部门</span></li></ul></div>';\r\n");
      out.write("\r\n");
      out.write("\t \tselectBranch = function (branch){\r\n");
      out.write("\t\t\tif(!branch) return;\r\n");
      out.write("\t\t\tif(window._selectNode) window._selectNode.className = 't';\r\n");
      out.write("\t\t\twindow._selectNode = branch;\r\n");
      out.write("\t\t\twindow._selectNode.className = 't on';\r\n");
      out.write("\t\t\tvar str = unescape(_selectNode.getAttribute(\"_data\"));\r\n");
      out.write("\t\t\tif(str == '' ) str = '{}';\r\n");
      out.write("\t\t\tvar _data = eval('(' + str + ')');\r\n");
      out.write("\t\t\tvar ou = _data?_data.ou:'';\r\n");
      out.write("\t\t\tvar desc = _data?_data.description:'';\r\n");
      out.write("\t\t\tif (confirm(\"你确定要将部门“\" + desc + \"”下的所有用户添加到本群组吗？\")) {\r\n");
      out.write("\t\t\t\tthis.win.dispose();\t\r\n");
      out.write("\t\t\t\tvar parameters = {\r\n");
      out.write("\t\t\t\t\tou: ou,\r\n");
      out.write("\t\t\t\t\tgrpuid: grpDs.getActiveData().uid\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t\tnew Ajax.Request(addDeptToGrpURL, {\r\n");
      out.write("\t\t\t\t\tparameters: parameters,\r\n");
      out.write("\t\t\t\t\tonComplete: function(req) {\r\n");
      out.write("\t\t\t\t\t\tvar s = req.responseText;\r\n");
      out.write("\t\t\t\t\t\tvar v = richEval(s);\r\n");
      out.write("\t\t\t\t\t\tif (1 == v.res) {\r\n");
      out.write("\t\t\t\t\t\t\tmemberDs.remoteListData();\r\n");
      out.write("\t\t\t\t\t\t}else {\r\n");
      out.write("\t\t\t\t\t\t\tvar msg = v.msg || v.data;\r\n");
      out.write("\t\t\t\t\t\t\tSkyDNA.Element.createAlertWin(msg + \"!\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}.bind({win:depwin});\r\n");
      out.write("\t\tswitchBranch(_G('rootECBtn'));\r\n");
      out.write("\t\t\t//selectBranch(_G('rootECBtn').nextSibling);\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("function ___addTreeNodes(branch){\r\n");
      out.write("\tif(!(typeof ___deptsData == 'object')){alert('对象丢失！'); return;}\r\n");
      out.write("\tvar nodeDObjStr = branch.nextSibling.getAttribute(\"_data\");\r\n");
      out.write("\tvar cNodeLst = null;\r\n");
      out.write("\tif(nodeDObjStr.trim()==''){\r\n");
      out.write("\t\tcNodeLst = ___deptsData['ROOT'];\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tvar nData = eval('(' + unescape(nodeDObjStr.trim()) + ')');\r\n");
      out.write("\t\tif(!(typeof nData == 'object')){alert('无效的树节点！'); return;}\r\n");
      out.write("\t\tcNodeLst = ___deptsData[nData.ou];\r\n");
      out.write("\t}\r\n");
      out.write("\tif(cNodeLst){\r\n");
      out.write("\t\tvar _ul = document.createElement('ul');\r\n");
      out.write("\t\tbranch.parentNode.appendChild(_ul);\r\n");
      out.write("\t\ttry{\r\n");
      out.write("\t\t\tvar _arr = new Array();\r\n");
      out.write("\t\t\tfor(var i = 0 ; i < cNodeLst.length; i++){\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  = '<li><span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span><span  _data=\\'';\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  = escape(JSON.toString(cNodeLst[i]));\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  = '\\' onclick=\"selectBranch(this);\" class=\"t\">' ;\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  =  cNodeLst[i].description ;\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  =  '</span></li>';\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t_ul.innerHTML = _arr.join('');\r\n");
      out.write("    \t}finally{\r\n");
      out.write("    \t\t_arr = null;\r\n");
      out.write("    \t}\r\n");
      out.write("\t\tbranch.isBuilt = true;\r\n");
      out.write("\t}\r\n");
      out.write("}\t\r\n");
      out.write("var ___deptsData = ");
      if (_jspx_meth_c_005fout_005f3(_jspx_page_context))
        return;
      out.write(";\r\n");
      out.write("\r\n");
      out.write("function switchBranch(branch){\t\r\n");
      out.write("\tif(!branch.nextSibling) return;\r\n");
      out.write("\t//selectBranch(branch.nextSibling);\r\n");
      out.write("\tif(!branch.isOpened){\r\n");
      out.write("\t\tif(!branch.isBuilt){\r\n");
      out.write("\t\t\t___addTreeNodes(branch);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar _ul = branch.parentNode.getElementsByTagName('ul');\r\n");
      out.write("\tif(_ul.length==0) return;\r\n");
      out.write("\tvar cLst = _ul[0];\r\n");
      out.write("\tif(!branch.isOpened){\r\n");
      out.write("\t\tcLst.style.display = 'block';\r\n");
      out.write("\t\tbranch.isOpened = true;\r\n");
      out.write("\t\tbranch.className = 'opened';\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tcLst.style.display = 'none';\r\n");
      out.write("\t\tbranch.isOpened = false;\r\n");
      out.write("\t\tbranch.className = 'closed';\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("{\r\n");
      out.write("\tvar dataStruct = {\r\n");
      out.write("\t\tdc: {title: \"域名\", defaultValue: curDc},\r\n");
      out.write("\t\tuid: {title: \"群组帐号\" , isKey: true, validate: VF_safetyStr},\r\n");
      out.write("\t\tname: {title: \"说明或描述\"}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar dataSourceProps = {\r\n");
      out.write("\t\tisLocalSort: false,\r\n");
      out.write("\t\tlistURL: \"grpUsers.json?dc=\" + curDc,\r\n");
      out.write("\t\taddURL: \"grpUserAdd.json?dc=\" + curDc,\r\n");
      out.write("\t\tmodURL: \"grpUserMod.json?dc=\" + curDc,\r\n");
      out.write("\t\tdelURL: \"grpUserDel.json?dc=\" + curDc\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar addGrpUserWinProps = {\r\n");
      out.write("\t\twidth: 550,\r\n");
      out.write("\t\theight:200,\r\n");
      out.write("\t\tsubjects: [\"uid\",\"name\"],\r\n");
      out.write("\t\ttitle: \"新增群组\",\r\n");
      out.write("\t\tisForgetDataStructKey: true\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar modGrpUserWinProps = {\r\n");
      out.write("\t\twidth: 550,\r\n");
      out.write("\t\theight:200,\r\n");
      out.write("\t\tsubjects: [\"name\"],\r\n");
      out.write("\t\thiddens: [\"uid\"],\r\n");
      out.write("\t\ttitle: \"修改群组信息\",\r\n");
      out.write("\t\tisForgetDataStructKey: false\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\tvar tableProps = {\r\n");
      out.write("\t\tsubjects: [\"uid\", \"name\"],\r\n");
      out.write("\t\thiddens:[\"dc\"],\r\n");
      out.write("\t\tisCheckbox : true\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar splitter =  SkyDNA.Element.createSplitter(document.body,document.body,{\r\n");
      out.write("\t\tid: \"domainGrpUserSplitter\", \r\n");
      out.write("\t\taideDock: \"left\", \r\n");
      out.write("\t\taideLength: 300,\r\n");
      out.write("\t\tdock: 'full',\r\n");
      out.write("\t\tdockTopTo: _G(\"page-head-box\")\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tvar grpToolsBar = SkyDNA.Element.createButtonsBar(splitter.aideCell);\r\n");
      out.write("\twith(grpToolsBar) {\r\n");
      out.write("\t\tgrpAddBtn = addButton(\"新增群组\");\r\n");
      out.write("\t\tgrpModBtn = addButton(\"修改\");\r\n");
      out.write("\t\tgrpDelBtn = addButton(\"删除\");\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\tvar\tds = new SkyDNA.DataSource(dataStruct, dataSourceProps);\r\n");
      out.write("\tgrpDs = ds;\r\n");
      out.write("\t\r\n");
      out.write("\tds.bindAdd(grpAddBtn, addGrpUserWinProps);\r\n");
      out.write("\tds.bindMod(grpModBtn, modGrpUserWinProps);\r\n");
      out.write("\tds.bindDel(grpDelBtn);\r\n");
      out.write("\t\r\n");
      out.write("\tvar grpsCtr = _CC(\"div\", null, splitter.aideCell);\r\n");
      out.write("\tgrpsCtr.style.overflow = \"scroll\";\r\n");
      out.write("\tSkyDNA.Enhance.enhance(grpsCtr, \"dockable\", {dock: 'full', dockTopTo:grpToolsBar });\r\n");
      out.write("\t\r\n");
      out.write("\tds.createDataTable(grpsCtr, tableProps);\r\n");
      out.write("\tds.remoteListData();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//////////// GroupUserMember //////////\r\n");
      out.write("\r\n");
      out.write("{\r\n");
      out.write("\tvar dataStruct = {\r\n");
      out.write("\t\tdc: {title: \"域名\", defaultValue: curDc},\r\n");
      out.write("\t\tuid: {title: \"帐号\" , isKey: true},\r\n");
      out.write("\t\tdisplayname: {title: \"姓名\"},\r\n");
      out.write("\t\tou:{title:\"部门\",defaultValue:\"\"}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar dataSourceProps = {\r\n");
      out.write("\t\tisLocalSort: false,\r\n");
      out.write("\t\tlistURL: \"grpMembers.json?dc=\" + curDc,\r\n");
      out.write("\t\taddURL: \"grpMemberAdd.json?dc=\" + curDc,\r\n");
      out.write("\t\tdelURL: \"grpMemberDel.json?dc=\" + curDc\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar tableProps = {\r\n");
      out.write("\t\tsubjects: [\"uid\", \"displayname\", \"ou\"],\r\n");
      out.write("\t\thiddens:[\"dc\"],\r\n");
      out.write("\t\tisCheckbox : true,\r\n");
      out.write("\t\tfilter: {\r\n");
      out.write("\t\t\tou: function(v) {\r\n");
      out.write("\t\t\t\treturn depDesc[v];\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar addMemberWinProps = {\r\n");
      out.write("\t\twidth: 550,\r\n");
      out.write("\t\theight:200,\r\n");
      out.write("\t\tsubjects: [\"uid\"],\r\n");
      out.write("\t\ttitle: \"新增群组成员\",\r\n");
      out.write("\t\tisFetchParentDsKey: true,\r\n");
      out.write("\t\tisForgetDataStructKey: true\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar titleDataViewProps = {\r\n");
      out.write("\t\tsubjects: [\"uid\"],\r\n");
      out.write("\t\tfilter: {\r\n");
      out.write("\t\t\tuid: function(v) {\treturn v + \"@\" + curDc + \"成员管理\"}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar mbrToolsBox = _C(\"div\", {id: \"mbr-head-box\"}, splitter.mainCell);\r\n");
      out.write("\tvar mbrTitleBox = _C(\"div\", {id: \"mbr-title-box\" }, mbrToolsBox);\r\n");
      out.write("\tgrpDs.createDataView(mbrTitleBox, titleDataViewProps);\r\n");
      out.write("\r\n");
      out.write("\tvar\tds = new SkyDNA.DataSource(dataStruct, dataSourceProps);\r\n");
      out.write("\tgrpDs.bindSubDataSource(ds);\r\n");
      out.write("\tmemberDs = ds;\r\n");
      out.write("\t\r\n");
      out.write("\tvar mbrToolsBar = SkyDNA.Element.createButtonsBar(splitter.mainCell);\r\n");
      out.write("\twith(mbrToolsBar) {\r\n");
      out.write("\t\tmbrAddBtn = addButton(\"单独添加成员\");\r\n");
      out.write("\t\tmbrAllAddBtn = addButton(\"添加全体用户\",  addMemberAll);\r\n");
      out.write("\t\tmbrDptBtn = addButton(\"添加部门用户\");\r\n");
      out.write("\t\tmbrNoDeptAddBtn = addButton(\"添加“非”部门用户\",  addMemberNoDept);\r\n");
      out.write("\t\tmbrDelBtn = addButton(\"删除成员\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tds.createDataTable(splitter.mainCell, tableProps);\r\n");
      out.write("\tds.bindAdd(mbrAddBtn, addMemberWinProps);\r\n");
      out.write("\tds.bindDel(mbrDelBtn);\r\n");
      out.write("\tlistDep(mbrDptBtn);\r\n");
      out.write("\t\r\n");
      out.write("\tds.remoteListData();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addMemberAll() {\r\n");
      out.write("\t\tif (!confirm(\"您确认要添加所有的用户到本群组吗？\"))\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar parameters = {\r\n");
      out.write("\t\t\tgrpuid: grpDs.getActiveData().uid\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tnew Ajax.Request(\"grpMemberAddAll.json?dc=\" + curDc, {\r\n");
      out.write("\t\t\tparameters: parameters,\r\n");
      out.write("\t\t\tonComplete: function(req) {\r\n");
      out.write("\t\t\t\tvar s = req.responseText;\r\n");
      out.write("\t\t\t\tvar v = richEval(s);\r\n");
      out.write("\t\t\t\tif (1 == v.res) {\r\n");
      out.write("\t\t\t\t\tmemberDs.remoteListData();\r\n");
      out.write("\t\t\t\t}else {\r\n");
      out.write("\t\t\t\t\tvar msg = v.msg || v.data;\r\n");
      out.write("\t\t\t\t\tSkyDNA.Element.createAlertWin(msg + \"!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addMemberNoDept() {\r\n");
      out.write("\t\tif (!confirm(\"您确认要添加所有“无部门信息的”用户到本群组吗？\"))\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar parameters = {\r\n");
      out.write("\t\t\tgrpuid: grpDs.getActiveData().uid\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tnew Ajax.Request(\"grpMemberAddNoDept.json?dc=\" + curDc, {\r\n");
      out.write("\t\t\tparameters: parameters,\r\n");
      out.write("\t\t\tonComplete: function(req) {\r\n");
      out.write("\t\t\t\tvar s = req.responseText;\r\n");
      out.write("\t\t\t\tvar v = richEval(s);\r\n");
      out.write("\t\t\t\tif (1 == v.res) {\r\n");
      out.write("\t\t\t\t\tmemberDs.remoteListData();\r\n");
      out.write("\t\t\t\t}else {\r\n");
      out.write("\t\t\t\t\tvar msg = v.msg || v.data;\r\n");
      out.write("\t\t\t\t\tSkyDNA.Element.createAlertWin(msg + \"!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fimport_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    // /a/user/domainGrpUsers.jsp(7,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fimport_005f0.setUrl("../_pub/common_head.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
      if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /a/user/domainGrpUsers.jsp(78,26) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent(null);
    // /a/user/domainGrpUsers.jsp(86,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /a/user/domainGrpUsers.jsp(89,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("dept");
    // /a/user/domainGrpUsers.jsp(89,0) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${depts}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/user/domainGrpUsers.jsp(90,1) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("depDesc[\"${dept.ou}\"] = \"${dept.description}\";", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/user/domainGrpUsers.jsp(90,1) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent(null);
    // /a/user/domainGrpUsers.jsp(183,19) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptTreeStr}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/user/domainGrpUsers.jsp(183,19) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }
}
