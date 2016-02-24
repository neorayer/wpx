package org.apache.jsp.u.mail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addrbooks_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      out.write("\r\n");
      out.write("<div id=\"MailAddrBook\" class=\"gWel-tab\">\r\n");
      out.write("\t<div class=\"tabs\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li id=\"personAddr\" class=\"on\"  onClick=\"iTabClicked('personAddr');\">\r\n");
      out.write("\t\t\t\t个人通讯录\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li  id=\"publicAddr\" onClick=\"iTabClicked('publicAddr');\">\r\n");
      out.write("\t\t\t\t公共通讯录\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"pans\">\r\n");
      out.write("\t\t<div id=\"personAddrc\" class=\"panel\"></div>\r\n");
      out.write("\t\t<div id=\"publicAddrc\" class=\"panel\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function iTabClicked(id){\r\n");
      out.write("\t$('#MailAddrBook .tabs li').removeClass(\"on\");\r\n");
      out.write("\t$('#MailAddrBook .tabs #'+id).addClass(\"on\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t$('#MailAddrBook .pans .panel').hide();\r\n");
      out.write("\tvar $body = $('#MailAddrBook .pans #'+id +'c');\r\n");
      out.write("\tif(!$body.hasClass('opened')) {\r\n");
      out.write("\t\t//如果没有打开过，要初始化加载该页面\r\n");
      out.write("\t\t$body.load('mail/'+id+'.html');\r\n");
      out.write("\t\t//设置是否打开过\r\n");
      out.write("\t\t$body.addClass(\"opened\");\r\n");
      out.write("\t}\r\n");
      out.write("\t$body.show();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t//初始化私人通讯录\r\n");
      out.write("\tiTabClicked('personAddr');\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("</script>");
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
}
