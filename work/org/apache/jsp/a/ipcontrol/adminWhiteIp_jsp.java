package org.apache.jsp.a.ipcontrol;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminWhiteIp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"../_css/ipcontrol.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<!--[if lt IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html{\r\n");
      out.write("\tfilter:expression(document.execCommand(\"BackgroundImageCache\", false, true));\r\n");
      out.write("}\r\n");
      out.write(".title_BarImg{\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/ipcontrol.png', sizingMethod='crop');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"pgHeadBlock\" class=\"pgHeadBlock\">\r\n");
      out.write("<table border=0 width=\"100%\" height=\"100%\" cellspacing=\"0\"><tr>\r\n");
      out.write("<td algin=\"left\" width=41 class=\"title_BarImg\"></td>\r\n");
      out.write("<td align=\"left\" id=\"title_Font1\">管理端IP白名单</td>\r\n");
      out.write("<td align=\"right\" id=\"title_Font2\"></td></tr></table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"toolsBlock\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"domainTableBlock\" class=\"tableBlock\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function cr(){\r\n");
      out.write("\tvar dataStruts = {\r\n");
      out.write("\t\tfromip: {title: \"起始IP地址\", validate:VF_isIP},\r\n");
      out.write("\t\ttoip:{title: \"结束IP地址\", validate:VF_isIP},\r\n");
      out.write("\t\tuuid: {title: \"UUID\", isKey: true}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar addIPWinProps = {\r\n");
      out.write("\twidth: 400,\r\n");
      out.write("\theight:247,\r\n");
      out.write("\tisForgetDataStructKey: true,\r\n");
      out.write("\tsubjects: [\"fromip\",\"toip\"]\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\tvar dataSourceProps = {\r\n");
      out.write("\t\tlistURL: \"../ipcontrol/listAdminWhiteip.json\",\r\n");
      out.write("\t\taddURL: \"../ipcontrol/addAdminWhite.json\",\r\n");
      out.write("\t\tdelURL: \"../ipcontrol/delAdminWhiteIP.json\"\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar dataTableProps = {\r\n");
      out.write("\t\tisCheckbox: true,\r\n");
      out.write("\t\tsubjects: [\"fromip\",\"toip\"]\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar butBar = SkyDNA.Element.createButtonsBar(_G(\"toolsBlock\"));\r\n");
      out.write("\tvar addBtn = butBar.addButton(\"添加IP\");\r\n");
      out.write("\tvar delbtn = butBar.addButton(\"删除IP\", delip);\r\n");
      out.write("\tvar dataSource = new SkyDNA.DataSource(dataStruts,dataSourceProps);\r\n");
      out.write("\tdataSource.createDataTable(_G(\"domainTableBlock\"), dataTableProps);\r\n");
      out.write("\t\r\n");
      out.write("\tdataSource.bindAdd(addBtn,addIPWinProps);\r\n");
      out.write("\t//dataSource.bindDel(delbtn);\r\n");
      out.write("\tdataSource.remoteListData();\r\n");
      out.write("\t\r\n");
      out.write("\tfunction delip(){\r\n");
      out.write("\t\tif(!confirm('您确认要删除所选数据？')){\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar delIP = dataSource.getSelectedDatas();\r\n");
      out.write("\t\tvar uuids=\"\";\r\n");
      out.write("\t\tdelIP.each(function(data) {\r\n");
      out.write("\t\t\tuuids += \"&uuid=\" + data.uuid;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar url = \"../ipcontrol/delAdminWhiteIP.json?\" + uuids;\r\n");
      out.write("\t\tSkyDNA.Ajax.doRequest(url);\r\n");
      out.write("\t\tdataSource.remoteListData();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("cr();\r\n");
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
    // /a/ipcontrol/adminWhiteIp.jsp(5,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
