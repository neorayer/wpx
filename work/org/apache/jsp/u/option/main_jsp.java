package org.apache.jsp.u.option;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div id=\"Option\" class=\"gWel-tab\">\r\n");
      out.write("\t<div class=\"tabs\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li id=\"personInfo\"  class=\"on\" onClick=\"iTabClicked('personInfo');\">\r\n");
      out.write("\t\t\t\t个人信息\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li  id=\"password\" onClick=\"iTabClicked('password');\">\r\n");
      out.write("\t\t\t\t密码管理\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"space\" onClick=\"iTabClicked('space');\">\r\n");
      out.write("\t\t\t\t空间管理\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li id=\"sign\" onClick=\"iTabClicked('sign');\">\r\n");
      out.write("\t\t\t\t邮件签名\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"restore\" onClick=\"iTabClicked('restore');\">\r\n");
      out.write("\t\t\t\t自动回复\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"forward\" onClick=\"iTabClicked('forward');\">\r\n");
      out.write("\t\t\t\t邮件转发\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"common\" onClick=\"iTabClicked('common');\">\r\n");
      out.write("\t\t\t\t常规设置\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"reject\" onClick=\"iTabClicked('reject');\">\r\n");
      out.write("\t\t\t\t拒收设置\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"pans\">\r\n");
      out.write("\t\t<div id=\"personInfoc\" class=\"panel\"></div>\r\n");
      out.write("\t\t<div id=\"passwordc\" class=\"panel\"></div>\r\n");
      out.write("\t\t<div id=\"spacec\" class=\"panel\"></div>\r\n");
      out.write("\t\t<div id=\"signc\" class=\"panel\"></div>\r\n");
      out.write("\t\t<div id=\"restorec\" class=\"panel\"></div>\r\n");
      out.write("\t\t<div id=\"forwardc\" class=\"panel\"></div>\r\n");
      out.write("\t\t<div id=\"commonc\" class=\"panel\"></div>\r\n");
      out.write("\t\t<div id=\"rejectc\" class=\"panel\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function iTabClicked(id){\r\n");
      out.write("\tiTabClickedUrl(id, 'option/'+id+'.html');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function iTabClickedUrl(id, url) {\r\n");
      out.write("\t$('#Option .tabs li').removeClass(\"on\");\r\n");
      out.write("\t$('#Option .tabs #'+id).addClass(\"on\");\r\n");
      out.write("\r\n");
      out.write("\t$('#Option .pans .panel').css(\"display\", \"none\");\r\n");
      out.write("\t$('#Option .pans #'+id +'c')\r\n");
      out.write("\t\t.load(url)\r\n");
      out.write("\t\t.css(\"display\", \"block\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("iTabClicked('");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("');\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
    // /u/option/main.jsp(64,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${module}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
