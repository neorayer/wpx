package org.apache.jsp.u.option;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class space_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
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
      out.write("<form id=\"formSpace\" action=\"option/space.json\" method=\"post\" >\r\n");
      out.write("\t<div id=\"ctrSpaceAlertInfo\" class=\"theme-bg-col\" style=\"width: 99%;\">\r\n");
      out.write("\t\t当前邮箱空间为 <strong class=\"txt-impt\">");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("M</strong>, \r\n");
      out.write("\t\t设置空间警告线为<strong class=\"txt-impt\">");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("M</strong>, \r\n");
      out.write("\t\t占邮箱空间<strong class=\"txt-impt\">");
      if (_jspx_meth_c_005fout_005f2(_jspx_page_context))
        return;
      out.write("%</strong>; \r\n");
      out.write("\t\t当系统空间使用超出该设定警告线时，系统自动发出提醒信件。 \r\n");
      out.write("\t</div>\r\n");
      out.write("\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>设置空间卫士类型：</th>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<select name=\"sizetype\">\r\n");
      out.write("\t\t\t\t\t<option value=\"issize\">按大小(M)</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"isper\">按百分比(%)</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"isclose\">关闭该功能</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<span class=\"tips\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>设置新的空间卫士警告线：</th>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input id=\"newSpaceAlert\" name=\"newSpaceAlert\" type=\"text\">\r\n");
      out.write("\t\t\t\t<span class=\"tips\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
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
      out.write("\t$('#formSpace').validate({\r\n");
      out.write("\t\terrorClass: \"errorClass\",\r\n");
      out.write("\t\terrorElement: \"span\",\r\n");
      out.write(" \t\terrorPlacement: function(error, element) {\r\n");
      out.write("    \t\terror.appendTo( element.next());\r\n");
      out.write("  \t\t},\r\n");
      out.write("  \t\trules: {\r\n");
      out.write("  \t\t\t\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tmessages: {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t},\r\n");
      out.write("  \t\tsubmitHandler: function(form) {\r\n");
      out.write("\t   \t\t$(form).ajaxSubmit({\r\n");
      out.write("\t   \t\t\ttype: 'post',\r\n");
      out.write("\t\t\t\tdataType: 'json',\r\n");
      out.write("\t   \t\t\tsuccess: function(data) {\r\n");
      out.write("\t   \t\t\t\tif (data.res == 'yes') {\r\n");
      out.write("\t\t\t\t\t\ttipMsg(\"空间管理修改成功\");\r\n");
      out.write("\t\t\t\t\t\tiTabClicked('space');\r\n");
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /u/option/space.jsp(6,35) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sizeM}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent(null);
    // /u/option/space.jsp(7,35) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${spaceAlertM}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent(null);
    // /u/option/space.jsp(8,32) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sizePercent}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }
}
