package org.apache.jsp.u.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fdefault_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fdefault_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fdefault_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.release();
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\"> \r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("_js/cookie.js\"></script>\r\n");
      out.write("<title>WPX3 邮件系统</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body{\r\n");
      out.write("\tbackground-color: #527c98;\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".error {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write("#loginfrm .btn{\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("\twidth:68px;\r\n");
      out.write("\theight:28px;\r\n");
      out.write("\tbackground:url(portal/login/button.gif) 0 0 no-repeat #f1f1f1;\r\n");
      out.write("\tborder:none;\r\n");
      out.write("}\r\n");
      out.write("#loginfrm .btn:hover{\r\n");
      out.write("\tbackground:url(portal/login/button.gif) 0 -41px no-repeat #f1f1f1;\r\n");
      out.write("\tborder:none;\t\r\n");
      out.write("}\r\n");
      out.write("#loginfrm  .t{\r\n");
      out.write("\tfont-family:宋体;\r\n");
      out.write("}\r\n");
      out.write("#loginfrm  .t,\r\n");
      out.write("#loginfrm  .c{\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\tpadding:3px 0 3px 0;\r\n");
      out.write("}\r\n");
      out.write("#loginfrm span.abtn{\r\n");
      out.write("margin-left:80px;\r\n");
      out.write("margin-top:-20px;\r\n");
      out.write("display:block;\r\n");
      out.write("}\r\n");
      out.write("#loginfrm span.abtn a{\r\n");
      out.write("\tmargin-left:3px;\r\n");
      out.write("\tmargin-right:3px;\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("}\r\n");
      out.write("#loginfrm span.abtn a:hover{\r\n");
      out.write("\ttext-decoration:underline;\r\n");
      out.write("}\r\n");
      out.write("table.body{\r\n");
      out.write("\tmargin:80px auto 0 auto;\r\n");
      out.write("\tbackground:url(portal/login/bg.jpg) repeat-x 0 0;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("}\r\n");
      out.write("table.body{\r\n");
      out.write("\tmargin:80px auto 0 auto;\r\n");
      out.write("\tbackground:url(portal/login/bg.jpg) repeat-x 0 0;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function loginForKeyDown(e){\r\n");
      out.write("\tif(e.keyCode==13) document.loginfrm.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("window.onload = function(){\r\n");
      out.write("\tif(navigator.appVersion.toLowerCase().match(/msie 6/)){\r\n");
      out.write("\t    try {\r\n");
      out.write("\t        document.execCommand(\"BackgroundImageCache\", false, true);\r\n");
      out.write("\t    }catch (e) {}\r\n");
      out.write("\t}\r\n");
      out.write("\tdeleteCookie(\"uia_param\", '");
      out.print(request.getContextPath());
      out.write("');\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" class=\"body\">\r\n");
      out.write("  <tr>\r\n");
      out.write("  \t<td>&nbsp;</td>\r\n");
      out.write("    <td width=\"161\"><img src=\"portal/login/1.jpg\" width=\"161\" height=\"135\"></td>\r\n");
      out.write("    <td width=\"134\"><img src=\"portal/login/2.jpg\" width=\"134\" height=\"135\"></td>\r\n");
      out.write("    <td width=\"337\"><img src=\"portal/login/3.jpg\" width=\"337\" height=\"135\"></td>\r\n");
      out.write("\t<td width=\"295\" align=\"left\"><img src=\"portal/login/4.jpg\" width=\"219\" height=\"135\"></td>\r\n");
      out.write("\r\n");
      out.write("  \t<td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("  \t<td>&nbsp;</td>\r\n");
      out.write("    <td><img src=\"portal/login/5.jpg\" width=\"161\" height=\"241\"></td>\r\n");
      out.write("    <td><img src=\"portal/login/6.jpg\" width=\"134\" height=\"241\"></td>\r\n");
      out.write("    <td background=\"portal/login/7.jpg\" valign=\"top\">\r\n");
      out.write("\t\t<form method=\"post\" onkeydown=\"loginForKeyDown(event);\" action=\"login.html\" name=\"loginfrm\" id=\"loginfrm\">\r\n");
      out.write("\t\t\t<table width=\"77%\" height=\"141\"  border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" class=\"t error\">");
      if (_jspx_meth_c_005fout_005f3(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t<td class=\"t\">用户名</td>\r\n");
      out.write("\t\t\t\t<td class=\"c\"><input name=\"uid\" type=\"text\" value=\"");
      if (_jspx_meth_c_005fout_005f4(_jspx_page_context))
        return;
      out.write("\" size=\"28\" style=\"font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; \"></td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t<td class=\"t\">域&nbsp;&nbsp;名</td>\r\n");
      out.write("\t\t\t\t<td class=\"c\">\r\n");
      out.write("\t\t\t\t\t<select name=\"dc\" style=\"font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; \">\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t \t\r\n");
      out.write("\t\t\t\t\t \t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t\t\t  <tr>\r\n");
      out.write("\t\t\t\t<td class=\"t\">密&nbsp;&nbsp;码</td>\r\n");
      out.write("\t\t\t\t<td class=\"c\"><input name=\"userpassword\" type=\"password\" value=\"\" size=\"28\"  style=\"font-family:Verdana, Arial, Helvetica, sans-serif; font-size:8pt; \"></td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t\t\t  <tr valign=\"middle\">\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td class=\"c\"><a href=\"login.jsp\" onClick=\"javascript:document.loginfrm.submit();return false;\" tabindex=\"5\" title=\"登录系统\" target=\"_self\" class=\"btn\"></a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<span class=\"abtn\" style=\"display: none;\"><a href=\"register.html\" target=\"_blank\">用户注册</a><a href=\"#\" target=\"_blank\">忘记密码</a></span></td>\r\n");
      out.write("\t\t\t  </tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\t\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td><img src=\"portal/login/8.jpg\" width=\"219\" height=\"241\"></td>\r\n");
      out.write("  \t<td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("\r\n");
      out.write("  <tr>\r\n");
      out.write("  \t<td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("\t<td>&nbsp;</td>\r\n");
      out.write("  \t<td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
    // /u/portal/login.jsp(7,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ProjectBase }u/", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    // /u/portal/login.jsp(9,36) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ProjectBase }", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /u/portal/login.jsp(87,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${timeout}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<script type=\"text/javascript\">\r\n");
        out.write("\twindow.location=\"");
        if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\";\r\n");
        out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /u/portal/login.jsp(89,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ProjectBase }login.html", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fdefault_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent(null);
    // /u/portal/login.jsp(112,36) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${REASON}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /u/portal/login.jsp(112,36) name = default type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setDefault("&nbsp;");
    // /u/portal/login.jsp(112,36) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent(null);
    // /u/portal/login.jsp(116,55) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username }", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /u/portal/login.jsp(123,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("domain");
    // /u/portal/login.jsp(123,6) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domains}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f5(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fout_005f6(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t \t");
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
      _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /u/portal/login.jsp(124,22) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /u/portal/login.jsp(124,54) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /u/portal/login.jsp(127,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("da");
    // /u/portal/login.jsp(127,7) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domainAlias}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f7(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fout_005f8(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t \t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /u/portal/login.jsp(128,22) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${da.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f7 = _jspx_th_c_005fout_005f7.doStartTag();
    if (_jspx_th_c_005fout_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /u/portal/login.jsp(128,50) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${da.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f8 = _jspx_th_c_005fout_005f8.doStartTag();
    if (_jspx_th_c_005fout_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
    return false;
  }
}
