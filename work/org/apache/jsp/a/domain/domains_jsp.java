package org.apache.jsp.a.domain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class domains_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.release();
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/wpx_tool.js\"></script>\r\n");
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"../_css/domain.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<!--[if lt IE 7]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html{\r\n");
      out.write("\tfilter:expression(document.execCommand(\"BackgroundImageCache\", false, true));\r\n");
      out.write("}\r\n");
      out.write(".title_BarImg{\r\n");
      out.write("\tfilter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../_img/domain.png', sizingMethod='crop');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("__DEBUG_CLOSED = true;\r\n");
      out.write("</script>\r\n");
      out.write("<div id=\"pgHeadBlock\" class=\"pgHeadBlock\" >\r\n");
      out.write("\t<table border=0 width=\"100%\" height=\"100%\" cellspacing=\"0\"><tr>\r\n");
      out.write("\t<td algin=\"left\" width=\"41\" class=\"title_BarImg\"></td>\r\n");
      out.write("\t<td align=\"left\" id=\"title_Font1\">子邮局管理&nbsp;&nbsp;\r\n");
      out.write("\t<font style=\"font-weight: normal\">");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</font>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t\r\n");
      out.write("\t<td align=\"right\" id=\"title_Font2\"></td>\r\n");
      out.write("\t</tr></table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"toolsBlock\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"domainTableBlock\" class=\"tableBlock\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function VF_isDomain(v) {\r\n");
      out.write("\tif (!v || v.trim() == '')\r\n");
      out.write("\t\treturn DICT.__NO_EMPTY;\r\n");
      out.write("\tif (v.trim() != \"\"){\r\n");
      out.write("\t\tptn = /^[\\.0-9a-zA-Z-_]+\\.+[a-zA-Z]{2,3}$/;\r\n");
      out.write("\t\tflg = ptn.test(v.trim());\r\n");
      out.write("\t\tif (!flg){\r\n");
      out.write("\t\t\treturn DICT.__WRONG_DOMAIN;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\treturn null;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function VF_Num(v) {\r\n");
      out.write("\tif (v.trim() == '')\r\n");
      out.write("\t\treturn DICT.__NO_EMPTY;\r\n");
      out.write("\tif(v == 0)\r\n");
      out.write("\t\treturn  \"不能为零\";\r\n");
      out.write("\tvar ptn = /^(0|[1-9][0-9]*)(\\.[0-9]+){0,1}$/;\r\n");
      out.write("\tvar flg = ptn.test(v);\r\n");
      out.write("\tif (!flg ) return DICT.__WRONG_NUMBER;\r\n");
      out.write("}\r\n");
      out.write("function VF_DNum(v){\t\r\n");
      out.write("\tdTotalSize = v;\r\n");
      out.write("\tif (v.trim() == '')\r\n");
      out.write("\t\treturn DICT.__NO_EMPTY;\r\n");
      out.write("\tif(v == 0)\r\n");
      out.write("\t\treturn  \"不能为零\";\r\n");
      out.write("\tvar ptn = /^(0|[1-9][0-9]*)(\\.[0-9]+){0,1}$/;\r\n");
      out.write("\tvar flg = ptn.test(v);\r\n");
      out.write("\tif (!flg )\r\n");
      out.write("\t\treturn DICT.__WRONG_NUMBER;\r\n");
      out.write("\telse\r\n");
      out.write("\t\treturn null;\r\n");
      out.write("}\r\n");
      out.write("var dTotalSize = ");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write(";\r\n");
      out.write("\r\n");
      out.write("function VF_isValidateBSize(v){\r\n");
      out.write("\tvar s = VF_Num(v);\r\n");
      out.write("\tif(s!=null)\r\n");
      out.write("\t\treturn s;\r\n");
      out.write("\tif(parseInt(v) > parseInt(dTotalSize))\r\n");
      out.write("\t\treturn '附件< ' + dTotalSize + ' M';\r\n");
      out.write("\telse\r\n");
      out.write("\t\treturn null;\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function VF_onlyNum(v) {\r\n");
      out.write("\tif (v.trim() == '')\r\n");
      out.write("\t\treturn DICT.__NO_EMPTY;\r\n");
      out.write("\tif(v == 0)\r\n");
      out.write("\t\treturn  \"不能为零\";\r\n");
      out.write("\tvar ptn = /^(0|[1-9][0-9]*)$/;\r\n");
      out.write("\tvar flg = ptn.test(v);\r\n");
      out.write("\tif (!flg ) return DICT.__WRONG_NUMBER;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var dataStruct = {\r\n");
      out.write("\tdc: {title: \"域名\", isKey: true,validate: VF_isDomain},\t\r\n");
      out.write("\tsizelocate: {title: \"已使用(M)\", defaultValue: 0},\r\n");
      out.write("\tsize: {title: \"总容量(M)\",  defaultValue: ");
      if (_jspx_meth_c_005fout_005f2(_jspx_page_context))
        return;
      out.write(",validate: VF_Num},\r\n");
      out.write("\tuserlocate: {title: \"用户数\",  defaultValue: 0,validate: VF_onlyNum},\r\n");
      out.write("\tdefaultboxsize: {title: \"默认邮箱大小(M)\" , defaultValue: ");
      if (_jspx_meth_c_005fout_005f3(_jspx_page_context))
        return;
      out.write(",validate: VF_DNum},\r\n");
      out.write("\tusermax: {title: \"最大用户数\",  defaultValue:  ");
      if (_jspx_meth_c_005fout_005f4(_jspx_page_context))
        return;
      out.write(",validate: VF_onlyNum},\r\n");
      out.write("\tdescription: {title: \"说明\", ftype: \"StringBuffer\"},\r\n");
      out.write("\tattachmentsize: {title: \"上传附件大小(M)\" , defaultValue:  ");
      if (_jspx_meth_c_005fout_005f5(_jspx_page_context))
        return;
      out.write(",validate: VF_isValidateBSize},\r\n");
      out.write("\tsavenew:{title:\"是否自动保存\",defaultValue:\"1\", ftype: \"Hash\", optionMap:{\"1\":\"自动保存\",\"0\":\"不自动保存\"}},\r\n");
      out.write("\tishidepubaddress:{title:\"是否隐藏公共通迅录\",defaultValue:\"0\", ftype: \"Hash\", optionMap:{\"0\":\"隐藏\",\"1\":\"显示\"}},\r\n");
      out.write("\tcityname:{title:\"城市\", defaultValue:\"上海\", ftype: \"Hash\", optionMap:{\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t}}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var dataSourceProps = {\r\n");
      out.write("\tlistURL: \"list.json\",\r\n");
      out.write("\taddURL: \"add.json\",\r\n");
      out.write("\tdelURL: \"del.json\",\r\n");
      out.write("\tmodURL: \"mod.json\",\r\n");
      out.write("\tsearchDataStruct : {\r\n");
      out.write("\t\tdc: {title: \"域名包含\"}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var dataTableProps = {\r\n");
      out.write("\tisCheckbox: true,\r\n");
      out.write("\tsubjects: [\"dc\", \"sizelocate\",\"size\", \"defaultboxsize\" ,\"attachmentsize\" , \"userlocate\", \"usermax\",\"description\"]\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var addWinProps = {\r\n");
      out.write("\tpos:SkyDNA.CONST.POS.CLIENT_CENTER,\t\r\n");
      out.write("\twidth: 500,\r\n");
      out.write("\theight:309,\r\n");
      out.write("\tisForgetDataStructKey: true,\r\n");
      out.write("\tsubjects: [\"dc\", \"size\", \"defaultboxsize\",\"usermax\",\"attachmentsize\",\"description\",\"savenew\",\"ishidepubaddress\",\"cityname\"]\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var modWinProps = {\r\n");
      out.write("\tpos:SkyDNA.CONST.POS.CLIENT_CENTER,\t\r\n");
      out.write("\twidth: 500,\r\n");
      out.write("\theight:309,\r\n");
      out.write("\tsubjects: [\"size\", \"defaultboxsize\",\"usermax\",\"attachmentsize\",\"description\",\"savenew\",\"ishidepubaddress\",\"cityname\"]\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var searchWinProps = {\r\n");
      out.write("\ttitle:\"搜索\",\r\n");
      out.write("\tpos:SkyDNA.CONST.POS.CLIENT_CENTER,\t\r\n");
      out.write("\twidth: 400,\r\n");
      out.write("\theight:247,\r\n");
      out.write("\tsubjects: [\"dc\"],\r\n");
      out.write("\tformURL : \"search.json\"\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var ds = new SkyDNA.DataSource(dataStruct, dataSourceProps);\r\n");
      out.write("function main(){\r\n");
      out.write("\tvar addBtn;\r\n");
      out.write("\twith(SkyDNA.Element.createButtonsBar(_G(\"toolsBlock\"))) {\r\n");
      out.write("\t\taddBtn = addButton(\"新增子邮局\", null);\r\n");
      out.write("\t\tmodBtn = addButton(\"修改子邮局\");\r\n");
      out.write("\t\talsBtn = addButton(\"别名管理\",openAlias);\r\n");
      out.write("\t\tdelBtn = addButton(\"删除子邮局\",null);\r\n");
      out.write("\t\trefreshBtn = addButton(\"刷新\", null);\r\n");
      out.write("\t\t//snyBtn = addButton(\"同步\", synchronizeDB);\r\n");
      out.write("\t\tsearchBtn = addButton(\"搜索\", null);\r\n");
      out.write("\t\texportBtn = addButton(\"导出备份文件\",exportUser);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tds.createPageBar(_G(\"domainTableBlock\"),\"pagenum\",\"perpagecount\",{countPerPage:15});\r\n");
      out.write("\tds.createDataTable(_G(\"domainTableBlock\"), dataTableProps);\r\n");
      out.write("\r\n");
      out.write("\tds.bindAdd(addBtn, addWinProps);\r\n");
      out.write("\tds.bindRefresh(refreshBtn);\r\n");
      out.write("\tds.bindSearch(searchBtn, searchWinProps);\r\n");
      out.write("\tds.bindMod(modBtn,modWinProps);\r\n");
      out.write("\tds.bindDel(delBtn);\r\n");
      out.write("\tds.remoteListData();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openAlias() {\r\n");
      out.write("\t\r\n");
      out.write("\tvar data = ds.getActiveData();\r\n");
      out.write("\tvar domain = data.dc;\r\n");
      out.write("\tvar win = SkyDNA.Element.createPopupWin({title: domain + \" 子邮局别名管理\",width: 500,height:350});\r\n");
      out.write("\t\r\n");
      out.write("\tvar dataStruct = {\r\n");
      out.write("\t\t'dc': {title: '别名', isKey:true}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar dsProps = {\r\n");
      out.write("\t\tlistURL: \"aliases.json?aliasedobjectname=\" + data.dc,\r\n");
      out.write("\t\tdelURL: \"aliases_del.json?aliasedobjectname=\" + data.dc\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar aliasDs = new SkyDNA.DataSource(dataStruct, dsProps);\r\n");
      out.write("\taliasDs.createDataTable(win.contentDom, {subjects: [\"dc\"], isCheckbox: true});\r\n");
      out.write("\twith(SkyDNA.Element.createButtonsBar(win.contentDom)){\r\n");
      out.write("\t\taliasDs.bindDel(addButton(\"删除别名\"));\r\n");
      out.write("\t}\r\n");
      out.write("\t_CC(\"hr\", null, win.contentDom);\r\n");
      out.write("\taliasDs.remoteListData();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar formProps = {\r\n");
      out.write("\t\tformURL: \"alias_add.json?aliasedobjectname=\" + data.dc,\r\n");
      out.write("\t\tonSubmitSucc: function() {aliasDs.remoteListData();}\r\n");
      out.write("\t};\r\n");
      out.write("\twith(SkyDNA.Element.createForm(win.contentDom,  formProps)) {\r\n");
      out.write("\t\taddInputText(\"dc\", \"新别名\", {validate: VF_isDomain});\r\n");
      out.write("\t\taddSubmit();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function synchronizeDB(){\r\n");
      out.write("\tvar data = ds.getActiveData();\r\n");
      out.write("\tvar domain = data.dc;\r\n");
      out.write("\tvar url = \"../domain/sychnorizedb.jsp?dc=\"+domain;\r\n");
      out.write("\t\r\n");
      out.write("\tvar x = SkyDNA.Ajax.doRequest(url);\r\n");
      out.write("\tif(x==1)\r\n");
      out.write("\t\talert(\"数据同步完成!\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/////////////////////////////////////exportUser\r\n");
      out.write("function exportUser() {\r\n");
      out.write("\tvar data = ds.getActiveData();\r\n");
      out.write("\tvar domain = data.dc;\r\n");
      out.write("\tdocument.location.href = \"domainsCSV.down?dc=\" + domain;\r\n");
      out.write("}\r\n");
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
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    // /a/domain/domains.jsp(5,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
      _005fjspx_005ftagPool_005fc_005fimport_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /a/domain/domains.jsp(28,35) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("licence限制:${userLicenseCount}  可用licence:${leftLicenseCount}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    // /a/domain/domains.jsp(74,17) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${defaultboxsize}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    // /a/domain/domains.jsp(99,40) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domainsize}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent(null);
    // /a/domain/domains.jsp(101,53) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${defaultboxsize}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
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
    // /a/domain/domains.jsp(102,43) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userMax}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent(null);
    // /a/domain/domains.jsp(104,54) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${attachmentSize}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /a/domain/domains.jsp(108,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("cityCode");
    // /a/domain/domains.jsp(108,2) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("status");
    // /a/domain/domains.jsp(108,2) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cityCodes}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t");
          if (_jspx_meth_c_005fout_005f6(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
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
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/domain/domains.jsp(109,3) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("'${cityCode.key}' : '${cityCode.key}'", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/domain/domains.jsp(109,3) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/domain/domains.jsp(110,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!status.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(',');
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
}
