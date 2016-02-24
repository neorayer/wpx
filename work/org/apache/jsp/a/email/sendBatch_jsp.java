package org.apache.jsp.a.email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sendBatch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../_css/email.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html {\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#pgBodyBlock {\r\n");
      out.write("\tmargin-right:9px;\t\r\n");
      out.write("\tmargin-left:20px;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#pgBodyBlock .a-btn {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("#pgBodyBlock .a-btn:hover {\r\n");
      out.write("\ttext-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write(".pg-t {\r\n");
      out.write("\tborder-bottom: 1px solid #E49222;\r\n");
      out.write("\theight: 24px;\r\n");
      out.write("\tmargin: 10px 0;\r\n");
      out.write("}\r\n");
      out.write(".pg-t span {\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tbackground-color: #E49222;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 24px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#type-table {\r\n");
      out.write("\tmargin: 5px 0;\r\n");
      out.write("}\r\n");
      out.write("#type-table td {\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tline-height: 30px;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#ou-box {\r\n");
      out.write("\tcolor: #E49222;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#user-list {\r\n");
      out.write("\theight: 300px;\r\n");
      out.write("\twidth: 710px;\r\n");
      out.write("\toverflow-y: scroll;\r\n");
      out.write("\toverflow-x: scroll;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".SDC_DataTable  {\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("margin-right: 0px;\r\n");
      out.write("}\r\n");
      out.write("/****** ******/\r\n");
      out.write("\r\n");
      out.write("div.posSortLstCls{\r\n");
      out.write("\ttable-layout:fixed;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\theight:280px;\r\n");
      out.write("\toverflow:auto;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\tbackground-color:#f1f1f1;\r\n");
      out.write("}\r\n");
      out.write("div.posSortLstCls ol{\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("div.posSortLstCls ol li{\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("}\r\n");
      out.write("table.posSortTableCls{\r\n");
      out.write("\tbackground-color:#e1e1e1;\t\t\r\n");
      out.write("}\r\n");
      out.write("table.posSortTableCls tr{\r\n");
      out.write("\tbackground-color:#eaeaea;\t\t\r\n");
      out.write("}\r\n");
      out.write("table.posSortTableCls td{\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\toverflow:hidden;\t\t\r\n");
      out.write("}\t\r\n");
      out.write("table.posSortTableCls td.tno{\r\n");
      out.write("\twidth:38px;\r\n");
      out.write("\tbackground-color:#f0f1f1;\r\n");
      out.write("}\r\n");
      out.write("table.posSortTableCls td.tuid{\r\n");
      out.write("\twidth:150px;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("table.posSortTableCls td.tname{\r\n");
      out.write("\twidth:150px;\r\n");
      out.write("\tbackground-color:#f8f1f1;\r\n");
      out.write("}\r\n");
      out.write("table.posSortTableCls td.cuid{\r\n");
      out.write("\twidth:150px;\r\n");
      out.write("}\r\n");
      out.write("table.posSortTableCls td.cname{\r\n");
      out.write("\twidth:150px;\r\n");
      out.write("\tbackground-color:#f8f1f1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#deptDataTree\tul{\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\tmargin-left:15px;\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree\tli{\r\n");
      out.write("\tlist-style:none;\r\n");
      out.write("\tmargin-top:1px;\r\n");
      out.write("\tmargin-bottom:1px;\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree\tli ul{\r\n");
      out.write("\tdisplay:none;\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree span{\r\n");
      out.write("\tbackground-color:#eeeeee;\r\n");
      out.write("\tcolor:#666666;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree span.on{\r\n");
      out.write("\tbackground-color:#0022ff;\r\n");
      out.write("\tcolor:#fff;\t\t\t\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree span.t{\r\n");
      out.write("\tpadding:0 3px;\r\n");
      out.write("}\t\t\r\n");
      out.write("#deptDataTree span.closed{\r\n");
      out.write("\tbackground: url(../user/icon/folder_closed.gif) 0 0 no-repeat;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\tpadding:2px 6px 1px 6px;\r\n");
      out.write("\tmargin:3px 0;\r\n");
      out.write("\tcolor:#fff;\t\t\t\r\n");
      out.write("}\r\n");
      out.write("#deptDataTree span.opened{\r\n");
      out.write("\tbackground: url(../user/icon/folder_opened.gif) 0 0 no-repeat;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\tmargin: 3px 0;\r\n");
      out.write("\tpadding:2px 6px 1px 6px;\r\n");
      out.write("\tcolor:#fff;\t\t\t\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/lib_json.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/DNA/jsDNA/FCKEditor/fckeditor.js\"></script>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"pgHeadBlock\" class=\"pgHeadBlock\">\r\n");
      out.write("\t<table border=0 width=\"100%\" height=\"100%\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td algin=\"left\" width=41 class=\"title_BarImg\"></td>\r\n");
      out.write("\t\t\t<td align=\"left\" id=\"title_Font1\">群发邮件</td>\r\n");
      out.write("\t\t\t<td align=\"right\" id=\"title_Font2\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"pgBodyBlock\">\r\n");
      out.write("<form method=\"post\" name=\"noticefrm\" target=\"hiddenIframe\" enctype= \"multipart/form-data\">\r\n");
      out.write("\t<input type=\"hidden\" value=\"\" name=\"rcpt\"/>\r\n");
      out.write("\t<h3 class=\"pg-t\">\r\n");
      out.write("\t\t<span>用户信息</span>\r\n");
      out.write("\t</h3>\r\n");
      out.write("\t<table cellpadding=\"0\" cellspacing=\"0\"  width=\"710\" style=\"background-color: #eee\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"60\">选择用户：</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"su\" id=\"su-dc\" value=\"1\" onclick=\"typeSel(this)\" /><label for=\"su-dc\" style=\"cursor: pointer\">按域</label>\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"su\" id=\"su-group\" value=\"2\" onclick=\"typeSel(this)\"/><label for=\"su-group\" style=\"cursor: pointer\">按组</label>\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\t<td></td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<table id=\"type-table\" cellpadding=\"0\" cellspacing=\"0\" width=\"400\">\r\n");
      out.write("\t\t\t\t\t<tr id=\"sel-1\">\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"domain\" id=\"domain\" onchange=\"selectDomain()\" style=\"width: 150px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t<input value=\"选择部门\" onclick=\"javascript:showOuwin(this)\" type=\"button\"> \r\n");
      out.write("\t\t\t\t\t\t\t<span id=\"ou-box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span id=\"ou-desc\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ou\" id=\"ou-txt\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"60\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"a-btn\" href=\"javascript:void(0)\" onclick=\"addUsersByDc()\">[加入]</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr id=\"sel-2\">\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"group\" id=\"group\" style=\"width: 150px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"60\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"a-btn\" href=\"javascript:void(0)\" onclick=\"addUsersByGroup()\">[加入]</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t用户列表：\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<div id=\"list-btn-bar\"></div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<div id=\"user-list\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<h3 class=\"pg-t\">\r\n");
      out.write("\t\t<span>邮件信息</span>\r\n");
      out.write("\t</h3>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<table id=\"sendBatchTable\" width=\"710\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"60\" valign=\"middle\" align=\"right\"><nobr>主题: </nobr></td>\r\n");
      out.write("\t\t\t<td><input id=\"title\" type=\"text\" name=\"title\" id=\"title\" size=50></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td valign=\"middle\" align=\"right\"><nobr>上传附件: </nobr></td>\r\n");
      out.write("\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t<input type=\"file\" name=\"attfile\" id=\"attfile\"> <input type=\"button\" name='box' value=\"增加新附件按钮\" onclick=\"addfileBtn()\"/>\r\n");
      out.write("\t\t\t\t<div id=\"attfile-box\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<textarea name=\"content\" id=\"content\" style=\"display:none\"></textarea>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td id=\"dvHtmlEditor\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"margin: 10px;width: 710px;text-align: center;\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"发送\" onclick=\"checksubmit()\"/>&nbsp;&nbsp;\r\n");
      out.write("\t   \t<input type=\"button\" value=\"关闭\" onclick=\"_close()\"/>\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<iframe id=\"hiddenIframe\" name=\"hiddenIframe\" style=\"display:none\" ></iframe>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function addfileBtn(){\r\n");
      out.write("\tvar addfileBox = document.getElementById('attfile-box');\r\n");
      out.write("\tvar old= addfileBox.innerHTML;\r\n");
      out.write("\taddfileBox.innerHTML=old+\"<input type=file name='attfile' id='attfile'>\";\r\n");
      out.write("}\r\n");
      out.write("\t_G('su-group').checked = 'checked';\r\n");
      out.write("\t_G('su-group').onclick();\r\n");
      out.write("\r\n");
      out.write("\twindow.RTEditorId = \"RTEditor_\" + Math.random();\r\n");
      out.write("\tvar editArea = _C(\"div\", {style:\"width:100%\"}, _G(\"dvHtmlEditor\"));\r\n");
      out.write("\teditArea.innerHTML = '<iframe id=\"' + RTEditorId + '\"  hspace=\"0\" vspace=\"0\" scrolling=\"auto\" frameborder=\"0\"  width=\"100%\" height=\"300\"><\\/iframe>';\r\n");
      out.write("\t(document.getElementById(window.RTEditorId) || document.frames[window.RTEditorId]).src=\"/DNA/jsDNA/rteditor/RTEditor.htm\";\r\n");
      out.write("\tif(typeof(document.noticefrm.content)!='undefined'){\r\n");
      out.write("\t\twindow.aLoadedIFrame = function (){\r\n");
      out.write("\t\t\t_G(window.RTEditorId).contentWindow.writeRTHTML(document.noticefrm.content.value);\r\n");
      out.write("\t\t};\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar depDesc = [];\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tvar dataTable = SkyDNA.Element.createDataTable(_G('user-list'));\r\n");
      out.write("\tdataTable.subjects = ['uid', 'dc', 'displayname','ou'];\r\n");
      out.write("\tdataTable.props = { \r\n");
      out.write("\t\tfilter: {\r\n");
      out.write("\t\t\tou:function(v){\r\n");
      out.write("\t\t\t\tif(depDesc && depDesc[v])\r\n");
      out.write("\t\t\t\t\treturn depDesc[v];\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t\treturn v;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tisCheckbox: true\r\n");
      out.write("\t};\r\n");
      out.write("\tvar dataStruct = {\r\n");
      out.write("\t\tuid: {title: \"帐号\" , isKey: true},\r\n");
      out.write("\t\tdc: {title: \"域名\", isKey: true},\r\n");
      out.write("\t\tdisplayname: {title: \"姓名\"},\r\n");
      out.write("\t\tou:{title:\"部门\",defaultValue:\"\"}\r\n");
      out.write("\t};\r\n");
      out.write("\tvar ds = new SkyDNA.DataSource(dataStruct);\r\n");
      out.write("\tdataTable.bind(ds);\r\n");
      out.write("\t\r\n");
      out.write("\tvar btnbars = SkyDNA.Element.createButtonsBar(_G('list-btn-bar'));\r\n");
      out.write("\tvar delSelectBtn = btnbars.addButton(\"删除\");\r\n");
      out.write("\tds.bindDel(delSelectBtn);\r\n");
      out.write("\r\n");
      out.write("function _close() {\r\n");
      out.write("\twindow.parent.frames['contentFrame'].location = \"batch.html\";\r\n");
      out.write("}\t\r\n");
      out.write("\r\n");
      out.write("function checksubmit() {\r\n");
      out.write("\tvar rcptArr = [];\r\n");
      out.write("\tvar datasCur = ds.getAllDatas();\r\n");
      out.write("\tif(datasCur.length == 0) {\r\n");
      out.write("\t\talert('发送用户数至少1条');\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar title = document.noticefrm.title.value;\r\n");
      out.write("\tif(title.trim() == '') {\r\n");
      out.write("\t\talert('邮件标题不能为空');\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\t\r\n");
      out.write("\t\r\n");
      out.write("\tfor(var i = 0; i< datasCur.length; i++) {\r\n");
      out.write("\t\tvar _data = datasCur[i];\r\n");
      out.write("\t\trcptArr.push(_data.uid + \"@\" + _data.dc);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar rcpt = rcptArr.join(';');\r\n");
      out.write("\tdocument.noticefrm.rcpt.value = rcpt;\r\n");
      out.write("\r\n");
      out.write("\t_G(\"content\").value = _G(window.RTEditorId).contentWindow.getRTHTML();\r\n");
      out.write("\tdocument.noticefrm.action = \"../email/addbatch.sjs\";\r\n");
      out.write("\tdocument.noticefrm.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function addbatchCallBack() {\r\n");
      out.write("\t_close();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//选择域\r\n");
      out.write("function selectDomain() {\r\n");
      out.write("\tdocument.getElementById(\"ou-txt\").value = \"\";\r\n");
      out.write("\tdocument.getElementById(\"ou-desc\").innerHTML = \"\";\r\n");
      out.write("\t\r\n");
      out.write("\tvar domain = document.getElementById('domain');\r\n");
      out.write("\tif(domain.value == 'all'){\r\n");
      out.write("\t\t//TODO 部门的所有值要清空\r\n");
      out.write("\t\tdocument.getElementById('ou-box').style.display = 'none';\r\n");
      out.write("\t}\r\n");
      out.write("\telse {\r\n");
      out.write("\t\tdocument.getElementById('ou-box').style.display = '';\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//弹出框选择部门\r\n");
      out.write("function showOuwin(btn){\r\n");
      out.write("\tvar oudiv = document.getElementById(\"ou-box\");\r\n");
      out.write("\tvar disType = oudiv.style.display;\r\n");
      out.write("\tif(disType!=\"\"){\r\n");
      out.write("\t\toudiv.style.display='';\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar dc = document.getElementById('domain').value;\r\n");
      out.write("\tif(dc == 'all'){\r\n");
      out.write("\t\talert('请您先选择域');\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tdeptTreeStr(dc);\r\n");
      out.write("\tlistDep(dc);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var ___deptsData = {};\r\n");
      out.write("function deptTreeStr(dc) {\r\n");
      out.write("\t___deptsData = SkyDNA.Ajax.doRequestJSON(\"../email/deptTree.json?dc=\" + dc).data;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function listDep(dc){\r\n");
      out.write("\tdepwin = SkyDNA.Element.createPopupWin({title: dc + '部门列表',width: 350,height:380});\r\n");
      out.write("\tvar treeCtr = _CC(\"div\", null, depwin.contentDom);\r\n");
      out.write("\ttreeCtr.innerHTML =  '<div id=\"deptDataTree\"><ul><li><span title=\"打开/折叠\" id=\"rootECBtn\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span><span _data=\"\" onclick=\"selectBranch(this);\" class=\"t\">部门</span></li></ul></div>';\r\n");
      out.write("\t\r\n");
      out.write("\tselectBranch = function (branch){\r\n");
      out.write("\t\tif(!branch) return;\r\n");
      out.write("\t\tif(window._selectNode) window._selectNode.className = 't';\r\n");
      out.write("\t\twindow._selectNode = branch;\r\n");
      out.write("\t\twindow._selectNode.className = 't on';\r\n");
      out.write("\t\tvar str = unescape(_selectNode.getAttribute(\"_data\"));\r\n");
      out.write("\t\tif(str == '' ) str = '{}';\r\n");
      out.write("\t\tvar _data = eval('(' + str + ')');\r\n");
      out.write("\t\tif(typeof(_data.ou) == 'undefined' || _data.ou == '')\t\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\tvar ou = _data?_data.ou:'';\r\n");
      out.write("\t\tvar desc = _data?_data.description:'';\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"ou-txt\").value = ou;\r\n");
      out.write("\t\tdocument.getElementById(\"ou-desc\").innerHTML = desc;\r\n");
      out.write("\t\tthis.win.dispose();\r\n");
      out.write("\t}.bind({win:depwin});\r\n");
      out.write("\t\r\n");
      out.write("\tswitchBranch(_G('rootECBtn'));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function switchBranch(branch){\t\r\n");
      out.write("\tif(!branch.nextSibling) return;\r\n");
      out.write("\t//selectBranch(branch.nextSibling);\r\n");
      out.write("\tif(!branch.isOpened){\r\n");
      out.write("\t\tif(!branch.isBuilt){\r\n");
      out.write("\t\t\t___addTreeNodes(branch);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
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
      out.write("\r\n");
      out.write("function ___addTreeNodes(branch){\r\n");
      out.write("\tif(!(typeof ___deptsData == 'object')){alert('对象丢失！'); return;}\r\n");
      out.write("\tvar nodeDObjStr = branch.nextSibling.getAttribute(\"_data\");\r\n");
      out.write("\tvar cNodeLst = null;\r\n");
      out.write("\tif(nodeDObjStr.trim()==''){\r\n");
      out.write("\t\tcNodeLst = ___deptsData['ROOT'];\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tvar nData = eval('(' + unescape(nodeDObjStr.trim()) + ')');\r\n");
      out.write("\t\tif(!(typeof nData == 'object')){alert('无效的树节点！'); return;}\r\n");
      out.write("\t\tcNodeLst = ___deptsData[nData.ou];\r\n");
      out.write("\t}\r\n");
      out.write("\tif(cNodeLst){\r\n");
      out.write("\t\tvar _ul = document.createElement('ul');\r\n");
      out.write("\t\tbranch.parentNode.appendChild(_ul);\r\n");
      out.write("\t\ttry{\r\n");
      out.write("\t\t\tvar _arr = new Array();\r\n");
      out.write("\t\t\tfor(var i = 0 ; i < cNodeLst.length; i++){\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  = '<li><span title=\"打开/折叠\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span><span  _data=\\'';\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  = escape(JSON.toString(cNodeLst[i]));\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  = '\\' onclick=\"selectBranch(this);\" class=\"t\">' ;\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  =  cNodeLst[i].description ;\r\n");
      out.write("\t\t\t\t_arr[_arr.length]  =  '</span></li>';\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t_ul.innerHTML = _arr.join('');\r\n");
      out.write("    \t}finally{\r\n");
      out.write("    \t\t_arr = null;\r\n");
      out.write("    \t}\r\n");
      out.write("\t\tbranch.isBuilt = true;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function addUsersByDc() {\r\n");
      out.write("\tvar dc = document.getElementById('domain').value;\r\n");
      out.write("\tif(dc == '' || dc == 'all')\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\tvar ou = document.getElementById('ou-txt').value;\r\n");
      out.write("\t\r\n");
      out.write("\tvar waitingDom = SkyDNA.Element.showWaiting();\r\n");
      out.write("\tnew Ajax.Request(\"../email/searchUsersByDc.json?dc=\" + dc + \"&ou=\" + ou, {\r\n");
      out.write("\t\tmethod: 'post',\r\n");
      out.write("\t\tonComplete: function(resp) {\r\n");
      out.write("\t\t\t_R(waitingDom);\r\n");
      out.write("\t\t\tvar data  = richEval(resp.responseText);\r\n");
      out.write("\t\t\tif(data.res == 'no') {\r\n");
      out.write("\t\t\t\talert(data.data);\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\taddUserLines(data.data);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function addUsersByGroup() {\r\n");
      out.write("\tvar group = document.getElementById('group').value;\r\n");
      out.write("\tif(group == '')\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\tvar waitingDom = SkyDNA.Element.showWaiting();\r\n");
      out.write("\tnew Ajax.Request(\"../email/searchUsersByGroup.json?groupuuid=\" + group, {\r\n");
      out.write("\t\tmethod: 'post',\r\n");
      out.write("\t\tonComplete: function(resp) {\r\n");
      out.write("\t\t\t_R(waitingDom);\r\n");
      out.write("\t\t\tvar data  = richEval(resp.responseText);\r\n");
      out.write("\t\t\tif(data.res == 'no') {\r\n");
      out.write("\t\t\t\talert(data.data);\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\taddUserLines(data.data);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function addUserLines(datas) {\r\n");
      out.write("\tif(datas.length == 0) {\r\n");
      out.write("\t\talert(\"无用户数据可以加入列表\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\tdatas.each(function(data) {\r\n");
      out.write("\t\tif(!checkData(data))\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tds.addData({uid: data.uid, dc: data.dc, displayname: data.displayname, ou: data.ou});\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 用户列表中是否重复\r\n");
      out.write("function checkData(data) {\r\n");
      out.write("\tvar datasCur = ds.getAllDatas();\r\n");
      out.write("\tif(datasCur.length == 0)\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t\t\r\n");
      out.write("\tfor(var i = 0; i< datasCur.length; i++) {\r\n");
      out.write("\t\tvar _data = datasCur[i];\r\n");
      out.write("\t\tif(_data.uid + \"@\" + _data.dc == data.uid + \"@\" + data.dc)\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function typeSel(el) {\r\n");
      out.write("\tvar t_v = el.value;\r\n");
      out.write("\t_G('sel-1').style.display = 'none';\r\n");
      out.write("\t_G('sel-2').style.display = 'none';\r\n");
      out.write("\t\r\n");
      out.write("\t_G('sel-' + t_v).style.display = '';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function showTimerDiv(cb){\r\n");
      out.write("\tvar tdiv = document.getElementById('timerDiv');\r\n");
      out.write("\tif(cb.checked)\r\n");
      out.write("\t \ttdiv.style.display = '';\r\n");
      out.write("\telse\r\n");
      out.write("\t \ttdiv.style.display = 'none';  \r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fimport_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    // /a/email/sendBatch.jsp(6,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /a/email/sendBatch.jsp(211,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("domain");
    // /a/email/sendBatch.jsp(211,8) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domains}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</option>\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t");
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
    // /a/email/sendBatch.jsp(212,24) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/email/sendBatch.jsp(212,55) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${domain.dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
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
    // /a/email/sendBatch.jsp(228,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("g");
    // /a/email/sendBatch.jsp(228,8) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${groups}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("</option>\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /a/email/sendBatch.jsp(229,24) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${g.uuid}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /a/email/sendBatch.jsp(229,52) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${g.name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent(null);
    // /a/email/sendBatch.jsp(308,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("dept");
    // /a/email/sendBatch.jsp(308,1) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deplist}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fforEach_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f2))
            return true;
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f2);
    // /a/email/sendBatch.jsp(308,42) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("depDesc[\"${dept.ou}\"] = \"${dept.description}\";", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/email/sendBatch.jsp(308,42) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
