package org.apache.jsp.a.email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addbatchgroup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.release();
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
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../_css/email.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../_js/jquery/jquery-1.2.6-all.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#bgfrm {\r\n");
      out.write("\tmargin-left:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#bgfrm .err {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write("#bgfrm .err-input {\r\n");
      out.write("\tborder: 1px solid red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#bgfrm ul li{\r\n");
      out.write("\tmargin: 5px;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("}\r\n");
      out.write("#cdn-line table {\r\n");
      out.write("\tmargin-left: 35px;\r\n");
      out.write("\tmargin-bottom: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#cdn-list td {\r\n");
      out.write("\tbackground-color: #eee;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tborder-bottom: 1px solid #e7e7e7;\r\n");
      out.write("}\r\n");
      out.write("#cdn-list .d-1 {\r\n");
      out.write("\twidth: 20px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#cdn-list .d-2 {\r\n");
      out.write("\twidth: 300px;\r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("#cdn-list .d-3 {\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#bgfrm .t-btn{\r\n");
      out.write("\tmargin-left: 5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!--[if lt IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html{\r\n");
      out.write("\tfilter:expression(document.execCommand(\"BackgroundImageCache\", false, true));\r\n");
      out.write("}\r\n");
      out.write(".title_BarImg{\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/user.png', sizingMethod='crop');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"pgHeadBlock\" class=\"pgHeadBlock\">\r\n");
      out.write("\t<table border=0 width=\"100%\" height=\"100%\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td algin=\"left\" width=41 class=\"title_BarImg\"></td>\r\n");
      out.write("\t\t\t<td align=\"left\" id=\"title_Font1\">新建群发组</td>\r\n");
      out.write("\t\t\t<td align=\"right\" id=\"title_Font2\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<form id=\"bgfrm\" name=\"bgfrm\" method=\"post\" onsubmit=\"_submit();return false;\" action=\"addbatchgroup.json\">\r\n");
      out.write("\t<input name='uuid' type='hidden' value=\"");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("\"/>\r\n");
      out.write("\t<input name='op' type='hidden' value=\"\"/>\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t<li>名称：<input type=\"text\" name=\"name\" size=\"70\" value=\"");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("\"/></li>\r\n");
      out.write("\t\t<li>条件：<span style=\"color: red;\">注: 所有条件为并且关系</span></li>\r\n");
      out.write("\t\t<li id=\"cdn-line\">\r\n");
      out.write("\t\t\t<table id=\"cdn-list\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select id=\"param-sel\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"uid\">用户名 (uid)</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"dc\">域名 (dc)</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"displayname\">姓名 (displayname)</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"description\">部门 (description)</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select id=\"match-sel\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"=\">等于</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"like\">包含</option>\r\n");
      out.write("\t\t\t\t   \t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"key-input\" value=\"\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"addLine(this);\" class=\"t-btn\">[增加]</a>\r\n");
      out.write("\t\t\t\t\t\t<span class='err'></span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("var depDesc = [];\r\n");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("var SQL = {\r\n");
      out.write("\t'=' : function(k, v) {\r\n");
      out.write("\t\treturn k + \" = '\" + v + \"'\";\r\n");
      out.write("\t},\r\n");
      out.write("\t'like': function(k, v) {\r\n");
      out.write("\t\treturn k + \" like '%\" + v + \"%'\";\r\n");
      out.write("\t},\r\n");
      out.write("\t'!=': function(k, v) {\r\n");
      out.write("\t\treturn k + \" != '\" + v + \"'\";\r\n");
      out.write("\t}\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function _close() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"batchgroup.html\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function addLine(el) {\r\n");
      out.write("\tvar $param = jQuery(\"#param-sel\");\r\n");
      out.write("\tvar $match = jQuery(\"#match-sel\");\r\n");
      out.write("\tvar $key = jQuery(\"#key-input\");\r\n");
      out.write("\t\r\n");
      out.write("\t//reset\r\n");
      out.write("\t$(el).next().html('');\r\n");
      out.write("\t$key.removeClass('err-input');\r\n");
      out.write("\t\r\n");
      out.write("\tvar param_v = $param.find(':selected').val();\r\n");
      out.write("\tvar param_text = $param.find(':selected').text();\r\n");
      out.write("\tvar match_v = $match.find(':selected').val();\r\n");
      out.write("\tvar match_text = $match.find(':selected').text();\t\r\n");
      out.write("\tvar key_v = $key.val();\r\n");
      out.write("\t\r\n");
      out.write("\tif(jQuery.trim(key_v) == '') {\r\n");
      out.write("\t\t$(el).next().html('条件内容不能为空');\r\n");
      out.write("\t\t$key.addClass('err-input');\r\n");
      out.write("\t\t$key.focus();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar cname = param_text + \" \" + match_text + \" \" + key_v;\r\n");
      out.write("\tvar sql = SQL[match_v](param_v, key_v);\r\n");
      out.write("\tvar str = \"<tr><td class='d-1'>·<input name='filter' type='hidden' value=\\\"\" + sql + \"::::\" + cname  + \"\\\"/></td><td class='d-2'>\" + cname + \"</td><td class='d-3'><a href='javascript:void(0);' onclick='delLine(this);'>[删除]</a></td></tr>\";\r\n");
      out.write("\tvar $cdnlist = jQuery(\"#cdn-list\");\r\n");
      out.write("\t$cdnlist.append(str); \r\n");
      out.write("\t\r\n");
      out.write("\t// reset\r\n");
      out.write("\t$key.val('');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function delLine(el) {\r\n");
      out.write("\tjQuery(el).parents('tr').remove();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function _submit() {\r\n");
      out.write("\tvar form = document.bgfrm;\r\n");
      out.write("\tif(!_check(form))\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\t\r\n");
      out.write("\t$form = jQuery(form);\r\n");
      out.write("\tnew Ajax.Request($form.attr('action'), {\r\n");
      out.write("\t\tpostBody: $form.serialize(),\r\n");
      out.write("\t\tonComplete: function(resp) {\r\n");
      out.write("\t\t\tvar data  = richEval(resp.responseText);\r\n");
      out.write("\t\t\tif(data.res == 'no') {\r\n");
      out.write("\t\t\t\talert(data.data);\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\twindow.location = \"addbatchgroup.html?uuid=\" + form.uuid.value;\r\n");
      out.write("\t\t\t//_close();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t/**\r\n");
      out.write("\tjQuery(form).ajaxSubmit({\r\n");
      out.write("  \t\ttype: 'post',\r\n");
      out.write("\t\tdataType: 'json',\r\n");
      out.write("   \t\tsuccess: function(data) {\r\n");
      out.write("   \t\t\tif(data.res == 'no') {\r\n");
      out.write("\t\t\t\talert(data.data);\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t_close();\r\n");
      out.write("   \t\t}\t\r\n");
      out.write("   \t});\r\n");
      out.write("   \t*/\r\n");
      out.write("\treturn;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function _check(form) {\r\n");
      out.write("\tvar nameV = form.name.value;\r\n");
      out.write("\tif(jQuery.trim(nameV) == '') {\r\n");
      out.write("\t\tSkyDNA.Element.createAlertWin(\"分组名称不能为空\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar sqlLen = document.getElementsByName('filter').length;\r\n");
      out.write("\tif(sqlLen == 0) {\r\n");
      out.write("\t\tSkyDNA.Element.createAlertWin(\"至少有一条分组条件\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function previewR() {\r\n");
      out.write("\tvar form = document.bgfrm;\r\n");
      out.write("\tif(!_check(form))\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\r\n");
      out.write("\tuserwin = SkyDNA.Element.createPopupWin({title: \"预览分组结果\",width: 600,height:400});\r\n");
      out.write("\tvar userDsProps = {\r\n");
      out.write("\t\tdataStruct : {\r\n");
      out.write("\t\t\tdc: {title: \"域名\"},\r\n");
      out.write("\t\t\tuid: {title: \"帐号\" , isKey: true},\r\n");
      out.write("\t\t\tdisplayname: {title: \"姓名\"},\r\n");
      out.write("\t\t\tou:{title:\"部门\",defaultValue:\"\"}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tlistURL: \"previewUsers.json\"\r\n");
      out.write("\t};\r\n");
      out.write("\tvar tableProps = {\r\n");
      out.write("\t\tsubjects: ['dc', \"uid\",\"displayname\",\"ou\"],\r\n");
      out.write("\t\tisCheckbox : false, \r\n");
      out.write("\t\tfilter:{\r\n");
      out.write("\t\t\tou:function(v){\r\n");
      out.write("\t\t\t\tif(depDesc && depDesc[v])\r\n");
      out.write("\t\t\t\t\treturn depDesc[v];\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t\treturn v;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tuserDsProps.postBody = jQuery(form).formSerialize();\r\n");
      out.write("\tuserDsProps.isLocalSort = true;\r\n");
      out.write("\tvar UserDataSource = new SkyDNA.DataSource(null, userDsProps);\r\n");
      out.write("\tvar listCtr = _CC(\"div\", null, userwin.contentDom);\r\n");
      out.write("\tUserDataSource.createDataTable(listCtr, tableProps);\r\n");
      out.write("\tUserDataSource.remoteListData();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fimport_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    // /a/email/addbatchgroup.jsp(5,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /a/email/addbatchgroup.jsp(86,41) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${group.uuid }", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent(null);
    // /a/email/addbatchgroup.jsp(89,57) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${group.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/email/addbatchgroup.jsp(89,57) name = default type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setDefault("");
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f1);
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
    // /a/email/addbatchgroup.jsp(93,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("cdn");
    // /a/email/addbatchgroup.jsp(93,4) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${group.cdns}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td class='d-1'>·<input name='filter' type='hidden' value=\"");
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\"/></td>\r\n");
          out.write("\t\t\t\t\t\t<td class='d-2'>");
          if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t<td class='d-3'><a href='javascript:void(0);' onclick='delLine(this);'>[删除]</a></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t");
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

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/email/addbatchgroup.jsp(95,65) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cdn.filter}::::${cdn.name }", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    // /a/email/addbatchgroup.jsp(96,22) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cdn.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /a/email/addbatchgroup.jsp(128,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty group.creator || (group.creator eq ACTOR.uniqueId)}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<div style=\"margin: 20px 0;height: 1px;background-color: #eee;\"></div>\r\n");
        out.write("\t\t\t\t<input type=\"button\" value=\"预览分组结果\" onclick=\"previewR();\"/>\r\n");
        out.write("\t\t\t\t<input type=\"submit\" value=\"保存\"/>\r\n");
        out.write("\t\t\t\t<input type=\"button\" value=\"返回\" onclick=\"_close();\"/>\r\n");
        out.write("\t\t\t");
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

  private boolean _jspx_meth_c_005fforEach_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /a/email/addbatchgroup.jsp(140,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("dept");
    // /a/email/addbatchgroup.jsp(140,0) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deplist}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
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
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /a/email/addbatchgroup.jsp(140,41) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("depDesc[\"${dept.ou}\"] = \"${dept.description}\";", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/email/addbatchgroup.jsp(140,41) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }
}
