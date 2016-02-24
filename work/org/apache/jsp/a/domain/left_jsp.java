package org.apache.jsp.a.domain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody.release();
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
      out.write("    \r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<link href=\"../_css/left.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"../_css/domain.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"maindiv\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var propsButton = [\r\n");
      out.write("\t{title:\"子邮局列表\", url:\"domains.html\"},\r\n");
      out.write("\t{title:\"系统风格\", url:\"style.html?type=domain\"},\r\n");
      out.write("\t{title:\"域名导入\", url:\"importDomains.html\"},\r\n");
      out.write("\t{title:\"部门导入\", url:\"importDepts.html\"},\r\n");
      out.write("\t{title:\"用户导入\", url:\"importUsers.html\"},\r\n");
      out.write("\t{title:\"私人通讯录组导入\", url:\"importGrpAddrbooks.html\"},\r\n");
      out.write("\t{title:\"私人通讯录成员导入\", url:\"importPsnAddrbooks.html\"},\r\n");
      out.write("\t{title:\"用户别名导入\", url:\"importUserAlias.html\"},\r\n");
      out.write("\t{title:\"书签组导入\", url:\"importBmForders.html\"},\r\n");
      out.write("\t{title:\"书签导入\", url:\"importBmItems.html\"},\r\n");
      out.write("\t{title:\"数据整理\", url:\"resetData.html\"},\r\n");
      out.write("\t{title:\"8.5版U盘书签导入\", url:\"importBmsAndNds.html\"}\r\n");
      out.write("];\r\n");
      out.write("\r\n");
      out.write("function cr(){\r\n");
      out.write("\twith(SkyDNA.Element){\r\n");
      out.write("\t\tvar panel = createBarPanel(_G(\"mainDiv\"), \"子邮局管理\", {});\r\n");
      out.write("\t\tvar bBar = createButtonsBar(panel.body, {isMutex: true});\r\n");
      out.write("\t\t//var btnsBar = createButtonsBar(_G(\"mainDiv\"), {isMutex: true});\r\n");
      out.write("\t\twith(bBar){\r\n");
      out.write("\t\t\twidth = \"100%\";\r\n");
      out.write("\t\t\tpropsButton.each(function(pb){\r\n");
      out.write("\t\t\t\taddButton(pb.title, function() {openFrame(pb.url)}, {newRow:true});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tbBar.buttons[0].setDown(true);\r\n");
      out.write("\t\tbBar.buttons[0].onclick();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openFrame(url){\r\n");
      out.write("\twindow.parent.frames[\"contentFrame\"].location = url ; \r\n");
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
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    // /a/domain/left.jsp(5,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
      _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
    }
    return false;
  }
}
