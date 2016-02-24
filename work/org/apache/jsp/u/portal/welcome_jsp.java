package org.apache.jsp.u.portal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<div class=\"g-title-1 gWel-greeting\">\r\n");
      out.write("\t<h2>");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</h2>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"ln-thin ln-c-mid\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("<div id=\"gWel-info\">\r\n");
      out.write("\t邮 件：\r\n");
      out.write("\t<strong class=\"txt-impt\" id=\"bWelcomeInboxNew\">");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("</strong>\r\n");
      out.write("\t 封\r\n");
      out.write("\t<a href=\"javascript:MailFolders.openUrl('inbox', 'mail/mails.html?folderid=inbox&condition=read|true');\">未读邮件</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"wel-tools-box\" class=\"wxPortlet\">\r\n");
      out.write("\t<div class=\"wxPortletHeader\">\r\n");
      out.write("\t\t<span class=\"wxPortletTitle\">邮箱推荐</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"wxPortletBody\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<b class=\"first ico-personAddr\"></b>\r\n");
      out.write("\t\t\t\t<a hidefocus=\"true\" href=\"javascript:SideBar.open('#personAddr', 'personAddr/main.html');\">个人通讯录</a>\r\n");
      out.write("\t\t\t\t<span class=\"txt-info\">存储和查看私人所有联系人信息,便于快速写信</span>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<b class=\"first ico-publicAddr\"></b>\r\n");
      out.write("\t\t\t\t<a hidefocus=\"true\" href=\"javascript:SideBar.open('#publicAddr', 'publicAddr/main.html');\">公共通讯录</a>\r\n");
      out.write("\t\t\t\t<span class=\"txt-info\">查看单位内所有联系人信息,便于快速写信</span>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<b class=\"first ico-wel\"></b>\r\n");
      out.write("\t\t\t\t<a hidefocus=\"true\" href=\"javascript:SideBar.open('#fd_netdisk', 'netdisk/main.html');\">网络U盘</a>\r\n");
      out.write("\t\t\t\t<span class=\"txt-info\">存储文件</span>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<b class=\"first ico-pwd\"></b>\r\n");
      out.write("\t\t\t\t<a hidefocus=\"true\" href=\"javascript:Portal.open('option/main.html?module=personInfo');\">个人信息</a>\r\n");
      out.write("\t\t\t\t<span class=\"txt-info\">查看和修改自己的个人相关信息</span>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<b class=\"first ico-space\"></b>\r\n");
      out.write("\t\t\t\t<a hidefocus=\"true\" href=\"javascript:Portal.open('option/main.html?module=space');\">空间管理</a>\r\n");
      out.write("\t\t\t\t<span class=\"txt-info\">设置邮件空间大小警戒线</span>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<b class=\"first ico-sign\"></b>\r\n");
      out.write("\t\t\t\t<a hidefocus=\"true\" href=\"javascript:Portal.open('option/main.html?module=sign');\">邮件签名</a>\r\n");
      out.write("\t\t\t\t<span class=\"txt-info\">设置个性化邮件签名</span>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div style=\"clear: both;\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\t\t\t");
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
    // /u/portal/welcome.jsp(6,5) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${greeting}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    // /u/portal/welcome.jsp(13,48) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newMail}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }
}
