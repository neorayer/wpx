package org.apache.jsp.a.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addressbookAdmins_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../_css/admin.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<!--[if lt IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html{\r\n");
      out.write("\tfilter:expression(document.execCommand(\"BackgroundImageCache\", false, true));\r\n");
      out.write("}\r\n");
      out.write(".title_BarImg{\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/admin.png', sizingMethod='crop');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"pgHeadBlock\" class=\"pgHeadBlock\">\r\n");
      out.write("<table border=0 width=\"100%\" height=\"100%\" cellspacing=\"0\"><tr>\r\n");
      out.write("<td algin=\"left\" width=41 class=\"title_BarImg\"></td>\r\n");
      out.write("<td align=\"left\" id=\"title_Font1\">公共地址簿管理员</td>\r\n");
      out.write("<td align=\"right\" id=\"title_Font2\"></td>\r\n");
      out.write("</tr></table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"toolsBlock\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"tableBlock\" class=\"tableBlock\" align=\"center\">\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t\r\n");
      out.write("var dataStruct = {\r\n");
      out.write("\t\t'uid': {title: '用户名',  isKey: true, validate: VF_username},\r\n");
      out.write("\t\t'userpassword': {title: '密码',ftype: \"Password\",validate: VF_passwd},\r\n");
      out.write("\t\t'dc': {title: '管理域',ftype: 'Hash',optionMap: {\r\n");
      out.write("\t\t\t\"\":\"\"\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t}},\r\n");
      out.write("\t\t'deptname': {title: '管理部门'},\r\n");
      out.write("\t\t'oudes': {title: \"部门名称(点击选择部门)\",defaultValue: \"点击选择部门\"},\r\n");
      out.write("\t\t'ou':{title:\"部门\",defaultValue:\"\",validate: VF_noEmpty},\r\n");
      out.write("\t\t'status': {title: '状态', ftype: \"Hash\",optionMap: {'open': '开通',  'pause': \"暂停\"},defaultValue:\"open\"}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var dataSourceProps = {\r\n");
      out.write("\tlistURL: \"../admin/addressbookAdmin_list.json\",\r\n");
      out.write("\taddURL: \"../admin/addressbookAdmin_add.json\",\r\n");
      out.write("\tmodURL: \"../admin/addressbookAdmin_mod.json\",\r\n");
      out.write("\tdelURL: \"../admin/addressbookAdmins_del.json\"\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var tableProps = {\r\n");
      out.write("\tsubjects: [\"uid\",\"dc\",\"deptname\",\"status\"],\r\n");
      out.write("\tisCheckbox : true\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var addAddressbookAdminWinProps = {\r\n");
      out.write("\tpos:SkyDNA.CONST.POS.CLIENT_CENTER,\t\r\n");
      out.write("\twidth: 500,\r\n");
      out.write("\theight:247,\r\n");
      out.write("\tsubjects: [\"uid\", \"userpassword\",\"dc\",\"oudes\",\"ou\",\"status\"],\r\n");
      out.write("\thiddens: [\"ou\"],\r\n");
      out.write("\tisForgetDataStructKey: true\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var modAddressbookAdminProps = {\r\n");
      out.write("\tpos:SkyDNA.CONST.POS.CLIENT_CENTER,\t\r\n");
      out.write("\twidth: 400,\r\n");
      out.write("\theight:247,\r\n");
      out.write("\tsubjects: [\"userpassword\",\"status\",\"dc\"],\r\n");
      out.write("\thiddens: [\"dc\"]\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("function listDep(ctr){\r\n");
      out.write("\tSkyDNA.Event.addEvent(ctr,'onclick',function(){\r\n");
      out.write("\t\tvar dc = document.getElementsByName('dc');\t\t\t\r\n");
      out.write("\t\tvar ous = document.getElementsByName('ou');\r\n");
      out.write("\t\tvar oudecs = document.getElementsByName('oudes');\r\n");
      out.write("\t\tif(ous.length<=0) return;\r\n");
      out.write("\t\tvar pou = ous[0];\r\n");
      out.write("\t\tvar poudesc = oudecs[0];\r\n");
      out.write("\t\tpou.readOnly = true;\r\n");
      out.write("\t\tvar depwin = null;\r\n");
      out.write("\t\t\t/*\r\n");
      out.write("\t\t\t *\tcreatae popwin to list department data tree\r\n");
      out.write("\t\t\t */\r\n");
      out.write("\t\t\t SkyDNA.Event.addEvent(poudesc,'onfocus',function(){\r\n");
      out.write("\t\t\t \tdepwin = SkyDNA.Element.createPopupWin({title:dc[0].value+'部门列表',width: 350,height:500});\r\n");
      out.write("\t\t\t \t\t\t\t \t\r\n");
      out.write("\t\t\t\tvar deptDsProps = {\r\n");
      out.write("\t\t\t\t\tdataStruct : {\r\n");
      out.write("\t\t\t\t\t\t'uuid': {title: \"UUID\", isKey: true},\r\n");
      out.write("\t\t\t\t\t\t'ou': {title: \"部门代号\", validate: VF_username},\r\n");
      out.write("\t\t\t\t\t\t'description': {title: \"部门名称\",validate: VF_noEmpty}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tlistURL: \"../user/getDepts.json?domain=\"+dc[0].value\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar DeptDataSource = new SkyDNA.DataSource(null, deptDsProps);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t \tvar treeCtr = _CC(\"div\", null, depwin.contentDom);\r\n");
      out.write("\t\t\t\ttreeCtr.style.overflow = \"scroll\";\r\n");
      out.write("\t\t\t\tSkyDNA.Enhance.enhance(treeCtr, \"dockable\", {dock: 'full'});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar treeView = DeptDataSource.createDataTree(treeCtr, {\r\n");
      out.write("\t\t\t\t\t\ttitle: \"部门\", \r\n");
      out.write("\t\t\t\t\t\ttitleArg: 'description',\r\n");
      out.write("\t\t\t\t\t\tonSelected: onDeptSelected.bind(this)\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tDeptDataSource.remoteListData();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction onDeptSelected(node){\r\n");
      out.write("\t\t\t\tvar ou = node.data?node.data.ou:'';\r\n");
      out.write("\t\t\t\t//var ou = ou==''?'no':ou;\r\n");
      out.write("\t\t\t\tvar desc = node.data?node.data.description:'';\r\n");
      out.write("\t\t\t\tpou.value= ou;\r\n");
      out.write("\t\t\t\tpoudesc.value = desc;\r\n");
      out.write("\t\t\t\tdepwin.dispose();\r\n");
      out.write("\t\t\t}\r\n");
      out.write(" \t\t});\r\n");
      out.write("\t  \t//SkyDNA.Event.addEvent(pou,'onblur',function(){if(depwin)depwin.dispose();});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("function main(){\r\n");
      out.write("\tvar ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);\r\n");
      out.write("\tvar btnsBar = SkyDNA.Element.createButtonsBar(_G(\"toolsBlock\"));\r\n");
      out.write("\tvar addBtn = btnsBar.addButton(\"添加\");\r\n");
      out.write("\tvar modBtn = btnsBar.addButton(\"修改\");\r\n");
      out.write("\tvar rfBtn = btnsBar.addButton(\"刷新\");\r\n");
      out.write("\tvar delBtn = btnsBar.addButton(\"删除\",delAdmin);\r\n");
      out.write("\tvar modwin = ds.bindMod(modBtn,modAddressbookAdminProps);\r\n");
      out.write("\tvar addwin = ds.bindAdd(addBtn,addAddressbookAdminWinProps);\r\n");
      out.write("\tds.createDataTable(_G(\"tableBlock\"), tableProps);\r\n");
      out.write("\tds.bindRefresh(rfBtn);\r\n");
      out.write("\t//ds.bindDel(delBtn);\r\n");
      out.write("\tds.remoteListData();\r\n");
      out.write("\tlistDep(addBtn);\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction delAdmin(){\r\n");
      out.write("\t\tif(!confirm('您确认要删除所选数据？')){\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar deluids = ds.getSelectedDatas();\r\n");
      out.write("\t\tvar deldcs = ds.getSelectedDatas();\r\n");
      out.write("\t\tvar uids=\"\";\r\n");
      out.write("\t\tvar dcs=\"\";\r\n");
      out.write("\t\tdeluids.each(function(data) {\r\n");
      out.write("\t\t\tuids +=\"&uid=\" + data.uid;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tdeldcs.each(function(data) {\r\n");
      out.write("\t\t\tdcs +=\"&dc=\" + data.dc;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar  url = dataSourceProps.delURL + \"?\" +uids+dcs;\r\n");
      out.write("\t\tSkyDNA.Ajax.doRequest(url);\r\n");
      out.write("\t\tds.remoteListData();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("main();\r\n");
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
    // /a/admin/addressbookAdmins.jsp(6,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /a/admin/addressbookAdmins.jsp(40,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("domain");
    // /a/admin/addressbookAdmins.jsp(40,3) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domains}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/admin/addressbookAdmins.jsp(40,3) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("status");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t");
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
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/admin/addressbookAdmins.jsp(41,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.first}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(',');
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/admin/addressbookAdmins.jsp(42,4) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("'${domain.dc}' : '${domain.dc}'", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/admin/addressbookAdmins.jsp(42,4) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/admin/addressbookAdmins.jsp(43,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!status.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(',');
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
