package org.apache.jsp.a.email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class batch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
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
      out.write("<td align=\"left\" id=\"title_Font1\">群发邮件</td>\r\n");
      out.write("<td align=\"right\" id=\"title_Font2\"></td></tr></table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"toolsBlock\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"userTableBlock\" class=\"tableBlock\" align=\"center\">\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("var dataStruct = {\r\n");
      out.write("\tuuid: {title: \"UUID\", isKey: true},\r\n");
      out.write("\ttitle: {title: \"主题:\"},\r\n");
      out.write("\tcontent: {title:  \"内容\",ftype: \"StringBuffer\"},\r\n");
      out.write("\ttime: {title: \"创建时间\"},\r\n");
      out.write("\tcreator: {title: \"创建人\"},\r\n");
      out.write("\tstate: {title: \"状态\",ftype: 'Hash',optionMap: {\"sended\" : \"已发送\",\"error\": \"发送出错\",\"new\" : \"未发送\"}}\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var sendSysBatchWin = {\r\n");
      out.write("\twidth: 700,\r\n");
      out.write("\theight:432,\r\n");
      out.write("\tsubjects: [\"title\", \"time\",\"content\"],\r\n");
      out.write("\tisForgetDataStructKey: true\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var tablepros = {\r\n");
      out.write("\tsubjects: [\"title\",\"time\", \"creator\", \"state\"],\r\n");
      out.write("\tisCheckbox: true\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var dataSourceProps = {\r\n");
      out.write("\tlistURL: \"../email/listbatch.json\",\r\n");
      out.write("\tdelURL: \"../email/delbatch.json\"\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("var ds = new SkyDNA.DataSource(dataStruct,dataSourceProps);\r\n");
      out.write("function main(){\r\n");
      out.write("\tvar btnsBar = SkyDNA.Element.createButtonsBar(_G(\"toolsBlock\"));\r\n");
      out.write("\tvar sysnotBtn = btnsBar.addButton(\"发送群发邮件\",sendBatch);\r\n");
      out.write("\tvar delBtn = btnsBar.addButton(\"删除群发邮件\");\r\n");
      out.write("\trfBtn = btnsBar.addButton(\"刷新\");\r\n");
      out.write("//\tvar birthBtn = btnsBar.addButton(\"发送生日邮件\",sendBirthMail);\r\n");
      out.write("\tds.createDataTable(_G(\"userTableBlock\"), tablepros);\r\n");
      out.write("\t//ds.bindAdd(sysnotBtn,sendSysBatchWin);\r\n");
      out.write("\tds.bindRefresh(rfBtn);\r\n");
      out.write("\tds.bindDel(delBtn);\r\n");
      out.write("\t//ds.createPageBar(_G(\"toolsBlock\"),\"pagenum\",\"perpagecount\",{countPerPage:1});\r\n");
      out.write("\t\r\n");
      out.write("\tds.remoteListData();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function sendBatch() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"sendBatch.html\";\r\n");
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
    // /a/email/batch.jsp(6,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
}
