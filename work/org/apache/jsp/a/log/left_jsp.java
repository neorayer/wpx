package org.apache.jsp.a.log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"../_css/left.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"../_css/log.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<!--[if lt IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html{\r\n");
      out.write("\tfilter:expression(document.execCommand(\"BackgroundImageCache\", false, true));\r\n");
      out.write("}\r\n");
      out.write(".title_BarImg{\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/log.png', sizingMethod='crop');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function main() {\r\n");
      out.write("\twith(SkyDNA.Element) {\r\n");
      out.write("\t\tvar treeView = createTreeView(document.body, {title: \"日志查询\"});\r\n");
      out.write("\t\t//treeView.style.overflow = \"scroll\";\r\n");
      out.write("\t\tSkyDNA.Enhance.enhance(treeView, \"dockable\", {dock: 'full'});\r\n");
      out.write("\t\tvar domainNode = treeView.addNode(\"管理日志\", {onSelected: openSysLog});\r\n");
      out.write("\t\tvar domainNode = treeView.addNode(\"邮件日志\", {onSelected: openMailLog});\r\n");
      out.write("\t\tvar domainNode = treeView.addNode(\"登录日志\", {onSelected: openLoginLog});\r\n");
      out.write("\t\tvar domainNode = treeView.addNode(\"邮件发送统计\", {onSelected: openLogStat});\r\n");
      out.write("\t\t//var domainNode = treeView.addNode(\"统计每日发件量\", {onSelected: openSendMailCount, isLeaf: true});\r\n");
      out.write("\t\t//var domainNode = treeView.addNode(\"统计每日外发邮件类型\", {onSelected: openmailtypecount, isLeaf: true});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 管理日志\t\r\n");
      out.write("function openSysLog() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../log/sysLog.html\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 管理日志\t\r\n");
      out.write("function openMailLog() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../log/mailLog.html\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 登录日志\r\n");
      out.write("function openLoginLog() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../log/loginlog.html\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openLogStat() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../log/sendMailStat.html\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openSendMailCount() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../../vi/log/sendmailcount.jsp\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openmailtypecount() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../../vi/log/openmailtypecount.jsp\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("main();\r\n");
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
    // /a/log/left.jsp(5,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
