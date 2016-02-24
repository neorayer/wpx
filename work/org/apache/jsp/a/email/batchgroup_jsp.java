package org.apache.jsp.a.email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class batchgroup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
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
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../_css/email.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<!--[if lt IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html{\r\n");
      out.write("\tfilter:expression(document.execCommand(\"BackgroundImageCache\", false, true));\r\n");
      out.write("}\r\n");
      out.write(".title_BarImg{\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/user.png', sizingMethod='crop');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"pgHeadBlock\" class=\"pgHeadBlock\">\r\n");
      out.write("<table border=0 width=\"100%\" height=\"100%\" cellspacing=\"0\"><tr>\r\n");
      out.write("<td algin=\"left\" width=41 class=\"title_BarImg\"></td>\r\n");
      out.write("<td align=\"left\" id=\"title_Font1\">群发组管理</td>\r\n");
      out.write("<td align=\"right\" id=\"title_Font2\"></td></tr></table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"toolsBlock\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"userTableBlock\" class=\"tableBlock\" align=\"center\">\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("var depDesc = [];\r\n");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("var dataStruct = {\r\n");
      out.write("\tuuid: {title: \"编号\", isKey: true},\r\n");
      out.write("\tname: {title: \"名称\"},\r\n");
      out.write("\tcdn: {title:  \"条件\",ftype: \"StringBuffer\"}\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var tablepros = {\r\n");
      out.write("\tsubjects: [\"name\",\"cdn\"],\r\n");
      out.write("\tisCheckbox: true\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var dataSourceProps = {\r\n");
      out.write("\tlistURL: \"../email/batchgroups.json\",\r\n");
      out.write("\tdelURL: \"../email/delbatchgroup.json\"\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);\r\n");
      out.write("function main(){\r\n");
      out.write("\tvar btnsBar = SkyDNA.Element.createButtonsBar(_G(\"toolsBlock\"));\r\n");
      out.write("\tvar addBtn = btnsBar.addButton(\"新建组\",addBatchGroup);\r\n");
      out.write("\tvar modBtn = btnsBar.addButton(\"修改组\",modBatchGroup);\r\n");
      out.write("\tvar delBtn = btnsBar.addButton(\"删除组\");\r\n");
      out.write("\tvar vigcBtn = btnsBar.addButton(\"查看分组用户\", viGroupUser);\r\n");
      out.write("\trfBtn = btnsBar.addButton(\"刷新\");\r\n");
      out.write("\tds.createDataTable(_G(\"userTableBlock\"), tablepros);\r\n");
      out.write("\tds.bindDel(delBtn);\r\n");
      out.write("\tds.bindRefresh(rfBtn);\r\n");
      out.write("\tds.remoteListData();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function addBatchGroup() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"addbatchgroup.html\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function modBatchGroup() {\r\n");
      out.write("\tvar uuid = \"\";\r\n");
      out.write("\ttry{\r\n");
      out.write("\t\tuuid = ds.getActiveData().uuid;\r\n");
      out.write("\t\tif(uuid == '')\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tcatch(e) {\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"addbatchgroup.html?uuid=\" + uuid;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function viGroupUser() {\r\n");
      out.write("\tvar uuid = ds.getActiveData().uuid;\r\n");
      out.write("\tvar name = ds.getActiveData().name;\r\n");
      out.write("\t\r\n");
      out.write("\tuserwin = SkyDNA.Element.createPopupWin({title: name + \"分组用户\",width: 600,height:400});\r\n");
      out.write("\tvar userDsProps = {\r\n");
      out.write("\t\tdataStruct : {\r\n");
      out.write("\t\t\tdc: {title: \"域名\"},\r\n");
      out.write("\t\t\tuid: {title: \"帐号\" , isKey: true},\r\n");
      out.write("\t\t\tdisplayname: {title: \"姓名\"},\r\n");
      out.write("\t\t\tou:{title:\"部门\",defaultValue:\"\"}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tlistURL: \"viUsersByGroup.json?uuid=\" + uuid\r\n");
      out.write("\t};\r\n");
      out.write("\tvar tableProps = {\r\n");
      out.write("\t\tsubjects: ['dc', \"uid\",\"displayname\",\"ou\"],\r\n");
      out.write("\t\tisCheckbox : false, \r\n");
      out.write("\t\tfilter:{\r\n");
      out.write("\t\t\tou:function(v){\r\n");
      out.write("\t\t\t\tif(depDesc && depDesc[v])\r\n");
      out.write("\t\t\t\t\treturn depDesc[v];\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t\treturn v;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar UserDataSource = new SkyDNA.DataSource(null, userDsProps);\r\n");
      out.write("\tvar listCtr = _CC(\"div\", null, userwin.contentDom);\r\n");
      out.write("\tUserDataSource.createDataTable(listCtr, tableProps);\r\n");
      out.write("\tUserDataSource.remoteListData();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("main();\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
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
    // /a/email/batchgroup.jsp(6,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /a/email/batchgroup.jsp(34,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("dept");
    // /a/email/batchgroup.jsp(34,0) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deplist}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
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

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/email/batchgroup.jsp(34,41) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("depDesc[\"${dept.ou}\"] = \"${dept.description}\";", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/email/batchgroup.jsp(34,41) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
