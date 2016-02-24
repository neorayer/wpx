package org.apache.jsp.u.option;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class password_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<form id=\"formPassword\" class=\"optionForm\" action=\"option/password.json\" method=\"post\" >\r\n");
      out.write("\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>原密码：</th>\r\n");
      out.write("\t\t\t<td><input id=\"oldPass\" name=\"oldPass\" type=\"password\"><span class=\"tips\"/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>新密码：</th>\r\n");
      out.write("\t\t\t<td><input id=\"newPass\" name=\"newPass\" type=\"password\"><span class=\"tips\"/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>密码确认：</th>\r\n");
      out.write("\t\t\t<td><input id=\"newPass2\" name=\"newPass2\" type=\"password\"><span class=\"tips\"/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th><br/></th>\r\n");
      out.write("\t\t\t<td><input type=\"submit\" value=\"确定修改\" ></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t$.metadata.setType(\"attr\", \"validate\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t$('#formPassword').validate({\r\n");
      out.write("\t\terrorClass: \"errorClass\",\r\n");
      out.write("\t\terrorElement: \"span\",\r\n");
      out.write(" \t\terrorPlacement: function(error, element) {\r\n");
      out.write("    \t\terror.appendTo( element.next());\r\n");
      out.write("  \t\t},\r\n");
      out.write("  \t\trules: {\r\n");
      out.write("  \t\t\tnewPass: {\r\n");
      out.write("\t\t\t\trequired: true,\r\n");
      out.write("\t\t\t\trangelength: [6,16]\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tnewPass2: {\r\n");
      out.write("\t\t\t\trequired: true,\r\n");
      out.write("\t\t\t\trangelength: [6,16],\r\n");
      out.write("\t\t\t\tequalTo: \"#newPass\"\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tmessages: {\r\n");
      out.write("\t\t\tnewPass: {\r\n");
      out.write("\t\t\t\trequired: \"请输入正确的密码\",\r\n");
      out.write("\t\t\t\trangelength: \"6~16位字符长度\"\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tnewPass2: {\r\n");
      out.write("\t\t\t\trequired: \"请输入确认密码\",\r\n");
      out.write("\t\t\t\trangelength: \"6~16位字符长度\",\r\n");
      out.write("\t\t\t\tequalTo: \"两次输入不正确\"\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("  \t\tsubmitHandler: function(form) {\r\n");
      out.write("\t   \t\t$(form).ajaxSubmit({\r\n");
      out.write("\t   \t\t\ttype: 'post',\r\n");
      out.write("\t\t\t\tdataType: 'json',\r\n");
      out.write("\t   \t\t\tsuccess: function(data) {\r\n");
      out.write("\t   \t\t\t\tif (data.res == 'yes') {\r\n");
      out.write("\t\t\t\t\t\ttipMsg(\"密码信息修改成功\");\r\n");
      out.write("\t   \t\t\t\t\tiTabClicked('password');\r\n");
      out.write("\t\t\t\t\t}else {\r\n");
      out.write("\t\t\t\t\t\talert(data.data);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t   \t\t\t}\r\n");
      out.write("\t   \t\t});\r\n");
      out.write("\t   \t}\r\n");
      out.write(" \t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
