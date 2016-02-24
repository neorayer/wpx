package org.apache.jsp.u.publicAddr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class depts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.release();
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
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("ul.tree {\r\n");
      out.write("\tmargin-bottom: 50px;\r\n");
      out.write("\tpadding-bottom: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.tree li#grp_search {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("ul.tree li a.grp {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<ul id=\"ctrPubDeptTree\" class=\"tree\">\r\n");
      out.write("\t<li id=\"grp_all\" parentuuid=\"\">\r\n");
      out.write("\t\t<a class=\"tree-handler\" href=\"javascript:PublicAddr.toggleFolder('grp_all')\"></a>\r\n");
      out.write("\t\t<a id=\"grp_all\" class=\"grp\" href=\"javascript:PublicAddr.open('all', 'all')\">\r\n");
      out.write("\t\t\t所有联系人\r\n");
      out.write("\t\t\t<span>(");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write(")</span>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<ul id=\"DEPT_ROOT\" class=\"subGrps\" style=\"display:block; padding-left:12px;\" >\r\n");
      out.write("\t\t\t<li id=\"grp_nogroup\"  parentuuid=\"\">\r\n");
      out.write("\t\t\t\t<a class=\"tree-handler\" href=\"javascript:PublicAddr.toggleFolder('grp_nogroup')\"></a>\r\n");
      out.write("\t\t\t\t<a id=\"grp_nogroup\" class=\"grp\" href=\"javascript:PublicAddr.open('nogroup', 'nogroup')\">\r\n");
      out.write("\t\t\t\t\t未分组联系人\r\n");
      out.write("\t\t\t\t\t<span>(");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write(")</span>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</li>\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var DeptTree = {\r\n");
      out.write("\tjsonstr: {},\r\n");
      out.write("\t\r\n");
      out.write("\tinit: function(jsonstr) {\r\n");
      out.write("\t\tthis.jsonstr = jsonstr;\r\n");
      out.write("\t},\r\n");
      out.write("\t\r\n");
      out.write("\tcreate: function() {\r\n");
      out.write("\t\tthis.buildChild(this.jsonstr[\"ROOT\"], $('#DEPT_ROOT'));\r\n");
      out.write("\t},\r\n");
      out.write("\t\r\n");
      out.write("\tbuildD: function(dept, ctr) {\r\n");
      out.write("\t\tvar str = \"<li id='grp_\" + dept.ou + \"' class='grp' parentuuid='\" + dept.parentou +\"'></li>\";\r\n");
      out.write("\t\tvar $li = $(str);\r\n");
      out.write("\t\t$li.append(\"<a class='tree-handler tree-handler-close' href='javascript:PublicAddr.toggleFolder(\\\"grp_\"+ dept.ou +\"\\\")'></a>\");\r\n");
      out.write("\t\t$li.append(\"<a class='grp' title='\" + dept.description + \"' href='javascript:PublicAddr.open(\\\"\"+ dept.ou +\"\\\", \\\"\" + dept.ou + \"\\\")'>\"+ subString(dept.description, 20, true) + \"(\" + dept.count + \")\" +\"</a>\");\r\n");
      out.write("\t\tvar $li_ctr = $(\"<ul class='subGrps'></ul>\");\r\n");
      out.write("\t\t$li.append($li_ctr);\r\n");
      out.write("\t\t$li.appendTo(ctr);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.buildChild(this.jsonstr[dept.ou], $li_ctr);\r\n");
      out.write("\t},\r\n");
      out.write("\t\r\n");
      out.write("\tbuildChild: function(arr, ctr) {\r\n");
      out.write("\t\tif(!arr || !arr.length || arr.length == 0) \r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tfor(var i = 0;i < arr.length; i++) {\r\n");
      out.write("\t\t\tvar d = arr[i];\r\n");
      out.write("\t\t\tthis.buildD(d, ctr);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\tDeptTree.init(");
      if (_jspx_meth_c_005fout_005f2(_jspx_page_context))
        return;
      out.write(");\r\n");
      out.write("\tDeptTree.create();\r\n");
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /u/publicAddr/depts.jsp(26,10) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${allPublicCount}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    // /u/publicAddr/depts.jsp(34,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${noGroupPublicCount}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent(null);
    // /u/publicAddr/depts.jsp(79,15) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${treejson}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /u/publicAddr/depts.jsp(79,15) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }
}
