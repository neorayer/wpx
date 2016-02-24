package org.apache.jsp.a.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_005ftest.release();
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/DNA/jsDNA/prototype.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/DNA/jsDNA/SkyDNA_Core.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/DNA/jsDNA/SkyDNA_Element.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/DNA/jsDNA/SkyDNA_ElementDS.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/DNA/jsDNA/SkyDNA_ElementPortal.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/DNA/jsDNA/SkyDNA_Validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/DNA/jsDNA/language/utf8.js\"></script>\r\n");
      out.write("<link href=\"/DNA/jsDNA/style/fast/css/css.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<!--[if lt IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html{\r\n");
      out.write("\tfilter:expression(document.execCommand(\"BackgroundImageCache\", false, true));\r\n");
      out.write("}\r\n");
      out.write(".title_HeadImg{\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/logo.png', sizingMethod='crop');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#exitBtn {\r\n");
      out.write("\tmargin-right: 10px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"pgHead\">\r\n");
      out.write("<table border=0 width=\"100%\" height=\"100%\" cellspacing=\"0\"><tr>\r\n");
      out.write("<td algin=\"left\" width=423 class=\"title_HeadImg\"></td>\r\n");
      out.write("<td align=\"right\"><input style=\"width:120px\" type=\"button\" id=\"exitBtn\" class=\"SDC_Button\" onclick=\"exitSystem();\" value=\"退出系统\" /></td>\r\n");
      out.write("</tr></table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"mainDiv\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function crTabBox(){\r\n");
      out.write("\tvar theDiv = _G(\"mainDiv\");\r\n");
      out.write("\t//超级管理员\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t//域管理员\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t//多域管理员\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t//公共地址簿管理员\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\twith(SkyDNA.Element) {\r\n");
      out.write("\t\twith(createTabBox(theDiv)){\r\n");
      out.write("\t\t\tfor(var i=0;i<arr1.length;i++){\r\n");
      out.write("\t\t\t\tif(i == 0)\r\n");
      out.write("\t\t\t\t\taddTab(arr1[i],{id: \"tab_\"+arr2[i], onOpen: openFrame.bind(this,arr2[i])}).setDown(true);\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t\taddTab(arr1[i],{id: \"tab_\"+arr2[i], onOpen: openFrame.bind(this,arr2[i])});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openFrame(name){\r\n");
      out.write("\twindow.parent.frames[\"mainFrame\"].location = \"../\" + name + \"/main.html\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function exitSystem(){\r\n");
      out.write("\twindow.parent.location.href = \"logout.html\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("crTabBox();\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /a/portal/header.jsp(49,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.roleID eq 'super'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\tvar arr1 = [\"子邮局管理\",\"用户管理\",\"管理员\",\"全局管理\",\"IP访问控制\",\"邮件群发\",\"日志查询\"];\r\n");
        out.write("\t\tvar arr2 = [\"domain\",\"user\",\"admin\",\"conf\", \"ipcontrol\",\"email\",\"log\"];\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /a/portal/header.jsp(55,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.roleID eq 'domain'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\tvar arr1 = [\"用户管理\", \"邮件群发\", \"日志查询\"];\r\n");
        out.write("\t\tvar arr2 = [\"user\", \"email\", \"log\"];\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /a/portal/header.jsp(61,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.roleID eq 'multidomain'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\tvar arr1 = [\"子邮局管理\", \"用户管理\",\"邮件群发\" ,\"日志查询\"];\r\n");
        out.write("\t\tvar arr2 = [\"domain\", \"user\", \"email\", \"log\"];\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /a/portal/header.jsp(67,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.roleID eq 'addressbook'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\tvar arr1 = [\"用户管理\"];\r\n");
        out.write("\t\tvar arr2 = [\"user\"];\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }
}
