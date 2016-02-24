package org.apache.jsp.a.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../_css/user.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tmargin-left: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li {\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("\tmargin-top: 1px;\r\n");
      out.write("\tmargin-bottom: 1px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li ul {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tree span {\r\n");
      out.write("\tbackground-color: transparent;\r\n");
      out.write("\tcolor: #666666;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tree span.on {\r\n");
      out.write("\tbackground-color: #008aff;\r\n");
      out.write("\tpadding: 2px 3px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tree span.t {\r\n");
      out.write("\tpadding: 0 3px;\r\n");
      out.write("\tmargin-left: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tree span.closed {\r\n");
      out.write("\tbackground: url(icon/folder_closed.gif) 0 0 no-repeat;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tpadding: 2px 14px 1px 14px;\r\n");
      out.write("\tmargin: 3px 0;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tree span.opened {\r\n");
      out.write("\tbackground: url(icon/folder_opened.gif) 0 0 no-repeat;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tmargin: 3px 0;\r\n");
      out.write("\tpadding: 2px 14px 1px 14px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\t//var _btime = (new Date()).getTime();\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"tree\">\r\n");
      out.write("<ul>\r\n");
      out.write("\t<li><span title=\"打开/折叠\" onclick=\"switchBranch(this);\"\r\n");
      out.write("\t\tclass=\"closed\">&nbsp;</span><span\r\n");
      out.write("\t\tonclick=\"selectBranch(this);openDomain(this);\" class=\"t\">全部子邮局</span>\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t</li>\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("function selectBranch(branch){\r\n");
      out.write("\tif(!branch) return;\r\n");
      out.write("\tif(window._selectNode) window._selectNode.className = 't';\r\n");
      out.write("\twindow._selectNode = branch;\r\n");
      out.write("\twindow._selectNode.className = 't on';\t\r\n");
      out.write("}\r\n");
      out.write("function switchBranch(branch){\t\r\n");
      out.write("\tif(!branch.nextSibling) return;\r\n");
      out.write("\t//selectBranch(branch.nextSibling);\r\n");
      out.write("\tvar _ul = branch.parentNode.getElementsByTagName('ul');\r\n");
      out.write("\tif(_ul.length==0) return;\r\n");
      out.write("\tvar cLst = _ul[0];\r\n");
      out.write("\tif(!branch.isOpened){\r\n");
      out.write("\t\tcLst.style.display = 'block';\r\n");
      out.write("\t\tbranch.isOpened = true;\r\n");
      out.write("\t\tbranch.className = 'opened';\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tcLst.style.display = 'none';\r\n");
      out.write("\t\tbranch.isOpened = false;\r\n");
      out.write("\t\tbranch.className = 'closed';\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function openDomain(node){\r\n");
      out.write("\tvar branch = node.previousSibling;\r\n");
      out.write("\tif(!branch) return;\r\n");
      out.write("\tvar _ul = branch.parentNode.getElementsByTagName('ul');\r\n");
      out.write("\tif(_ul.length==0) return;\r\n");
      out.write("\tvar cLst = _ul[0];\r\n");
      out.write("\tcLst.style.display = 'block';\r\n");
      out.write("\tbranch.isOpened = true;\r\n");
      out.write("\tbranch.className = 'opened';\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 用户\r\n");
      out.write("function openUser(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../user/domainUsers.html?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function openTemplate(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../template/template.html?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// 管理员\r\n");
      out.write("function openAdmin(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../user/domainAdmins.html?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function openDomains() {\r\n");
      out.write("\t//window.parent.frames['contentFrame'].location = \"../../vi/domain/listDomain.jsp\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openAB(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../../vi/addressbook/domainAddressbook.jsp?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 部门\r\n");
      out.write("function openDept(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../user/domainDept.html?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//群组\r\n");
      out.write("function openGroup(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../user/domainGrpUsers?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function openNotice(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../../vi/notice/notice.jsp?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 群发邮件 -已废弃\r\n");
      out.write("function openBatch(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../batch/batch.html?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 风格样式\r\n");
      out.write("function openStyle(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../domain/style.html?type=user&dc=\" + dc;  \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openbatch(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../../vi/batch/sendBatch.jsp?dc=\" +dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openLog(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../../vi/log/logmenu.jsp?dc=\" +dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//组用户管理\r\n");
      out.write("function openQ(dc) {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"../user/qUsers.html?dc=\" + dc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//main();\r\n");
      out.write("openDomain(document.getElementById('tree').getElementsByTagName('span')[1]);\r\n");
      out.write("\r\n");
      out.write("//window.status = (new Date()).getTime() - _btime;\r\n");
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
    // /a/user/left.jsp(5,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /a/user/left.jsp(68,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("isAddressBookRole");
    // /a/user/left.jsp(68,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!ACTOR.isAddressBookRole}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /a/user/left.jsp(76,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("domain");
    // /a/user/left.jsp(76,2) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domains}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<li>\r\n");
          out.write("\t\t\t\t<span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span>\r\n");
          out.write("\t\t\t\t<span onclick=\"selectBranch(this);openDomain(this);\" class=\"t\"> \r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t</span>\r\n");
          out.write("\r\n");
          out.write("\t\t\t<ul>\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t<li>\r\n");
          out.write("\t\t\t\t\t<span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span>\r\n");
          out.write("\t\t\t\t\t<span onclick=\"selectBranch(this);openDept('");
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("')\" class=\"t\">部门</span>\r\n");
          out.write("\t\t\t\t</li>\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t<li>\r\n");
          out.write("\t\t\t\t\t<span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span>\r\n");
          out.write("\t\t\t\t\t<span onclick=\"selectBranch(this);openGroup('");
          if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("')\" class=\"t\">群组</span>\r\n");
          out.write("\t\t\t\t</li>\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t</ul>\r\n");
          out.write("\t\t\t</li>\r\n");
          out.write("\r\n");
          out.write("\t\t");
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
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/user/left.jsp(80,5) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/user/left.jsp(84,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isAddressBookRole}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span>\r\n");
        out.write("\t\t\t\t\t\t<span onclick=\"selectBranch(this);openUser('");
        if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("')\" class=\"t\">用户</span>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /a/user/left.jsp(87,50) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/user/left.jsp(93,49) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/user/left.jsp(98,50) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/user/left.jsp(101,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${isAddressBookRole}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span>\r\n");
        out.write("\t\t\t\t\t\t<span onclick=\"selectBranch(this);openAdmin('");
        if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fif_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("')\" class=\"t\">管理员</span>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t<!-- \r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span>\r\n");
        out.write("\t\t\t\t\t\t<span onclick=\"selectBranch(this);openBatch('");
        if (_jspx_meth_c_005fout_005f5(_jspx_th_c_005fif_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("')\" class=\"t\">群发邮件</span>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t \r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<span title=\"打开/折叠\" onclick=\"switchBranch(this);\"\r\n");
        out.write("\t\t\t\t\t\tclass=\"closed\">&nbsp;</span><span\r\n");
        out.write("\t\t\t\t\t\tonclick=\"selectBranch(this);openQ('");
        if (_jspx_meth_c_005fout_005f6(_jspx_th_c_005fif_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("')\"\r\n");
        out.write("\t\t\t\t\t\tclass=\"t\">组用户管理</span>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t-->\r\n");
        out.write("\t\r\n");
        out.write("\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t<span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span>\r\n");
        out.write("\t\t\t\t\t\t<span onclick=\"selectBranch(this);openStyle('");
        if (_jspx_meth_c_005fout_005f7(_jspx_th_c_005fif_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
          return true;
        out.write("')\" class=\"t\">风格样式</span>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /a/user/left.jsp(104,51) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /a/user/left.jsp(109,51) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /a/user/left.jsp(116,41) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /a/user/left.jsp(123,51) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f7 = _jspx_th_c_005fout_005f7.doStartTag();
    if (_jspx_th_c_005fout_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
    return false;
  }
}
