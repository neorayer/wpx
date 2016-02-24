package org.apache.jsp.u.netdisk;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addFolder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"folder-box\">\r\n");
      out.write("\t<h3 class=\"theme-bor-col theme-c\">\r\n");
      out.write("\t\t新建文件夹\r\n");
      out.write("\t</h3>\r\n");
      out.write("\t<form id=\"addForderForm\" action=\"netdisk/addFolder.json\" method=\"post\">\r\n");
      out.write("\t\t文件夹名：\r\n");
      out.write("\t\t<input type=\"text\" name=\"name\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"保存\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"取消\"  onclick=\"javascript:NetDisk.refresh();\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t<br/><br/>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t$.metadata.setType(\"attr\", \"validate\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t$('#addForderForm').validate({\r\n");
      out.write("\t\terrorClass: \"errorClass\",\r\n");
      out.write("\t\terrorElement: \"div\",\r\n");
      out.write(" \t\terrorPlacement: function(error, element) {\r\n");
      out.write("    \t\terror.appendTo( element.next(\"span\"));\r\n");
      out.write("  \t\t},\r\n");
      out.write("  \t\trules: {\r\n");
      out.write("  \t\t\tgroupName:{\r\n");
      out.write("  \t\t\t\trequired: true\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tmessages: {\r\n");
      out.write("\t\t\tgroupName:{\r\n");
      out.write("  \t\t\t\trequired: \"请输入文件夹名\"\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("  \t\tsubmitHandler: function(form) {\r\n");
      out.write("\t   \t\t$(form).ajaxSubmit({\r\n");
      out.write("\t   \t\t\ttype: 'post',\r\n");
      out.write("\t\t\t\tdataType: 'json',\r\n");
      out.write("\t   \t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\tif(data.res != 'yes') {\r\n");
      out.write("\t   \t\t\t\t\talert(\"新建文件夹失败。\");\r\n");
      out.write("\t   \t\t\t\t\treturn;\r\n");
      out.write("   \t\t\t\t\t}\r\n");
      out.write("\t\t  \t\t\t\r\n");
      out.write("\t\t  \t\t\tNetDisk.openUrl('netdisk/main.html');\r\n");
      out.write("\t\t  \t\t\t\r\n");
      out.write("\t   \t\t\t}\r\n");
      out.write("\t   \t\t});\r\n");
      out.write("\t   \t}\r\n");
      out.write(" \t});\r\n");
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
