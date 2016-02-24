package org.apache.jsp.a.ipcontrol;

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
      out.write("<link href=\"../_css/ipcontrol.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<!--[if lt IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html{\r\n");
      out.write("\tfilter:expression(document.execCommand(\"BackgroundImageCache\", false, true));\r\n");
      out.write("}\r\n");
      out.write(".title_BarImg{\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/ipcontrol.png', sizingMethod='crop');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div></div>\r\n");
      out.write("<div id=\"mainDiv\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*\r\n");
      out.write("var propsButton1 = [\r\n");
      out.write("\t{title:\"访问IP白名单\",name:\"allowIpList\"},\r\n");
      out.write("\t{title:\"访问IP黑名单\",name:\"rejectIpList\"}\r\n");
      out.write("];\r\n");
      out.write("*/\r\n");
      out.write("var propsButton2 = [\r\n");
      out.write("\t{title:\"管理端IP白名单\",name:\"adminWhiteIp\"},\r\n");
      out.write("\t{title:\"管理端IP黑名单\",name:\"adminBlackIp\"},\r\n");
      out.write("\t{title:\"注册端IP白名单\",name:\"registerWhiteIP\"},\r\n");
      out.write("\t{title:\"注册端IP黑名单\",name:\"registerBlackIP\"},\r\n");
      out.write("\t{title:\"smtp拒绝连接名单\",name:\"smtpRejectIP\"}\r\n");
      out.write("];\r\n");
      out.write("\r\n");
      out.write("function cr(title,propsButton){\r\n");
      out.write("\twith(SkyDNA.Element){\r\n");
      out.write("\t\tvar panel = createBarPanel(_G(\"mainDiv\"), title, {});\r\n");
      out.write("\t\tvar bBar = createButtonsBar(panel.body, {isMutex: true});\r\n");
      out.write("\t\t//var btnsBar = createButtonsBar(_G(\"mainDiv\"),{isMutex:true});\r\n");
      out.write("\t\twith(bBar){\r\n");
      out.write("\t\t\twidth = \"100%\";\r\n");
      out.write("\t\t\tpropsButton.each(function(pb){\r\n");
      out.write("\t\t\t\taddButton(pb.title,function(){openFrame(pb.name, pb.title)},{newRow:true});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tbBar.buttons[0].setDown(true);\r\n");
      out.write("\t\tbBar.buttons[0].onclick();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openFrame(name, title){\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location =  name + \".html?t=\" + title;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//cr(\"访问IP\",propsButton1);\r\n");
      out.write("cr(\"管理端IP\",propsButton2);\r\n");
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
    // /a/ipcontrol/left.jsp(5,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
