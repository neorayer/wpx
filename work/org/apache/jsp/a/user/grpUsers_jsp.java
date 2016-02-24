package org.apache.jsp.a.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class grpUsers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.release();
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/lib_json.js\"></script>\r\n");
      out.write("<link href=\"../_css/css.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../_css/user.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
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
      out.write("\tdiv.posSortLstCls{\r\n");
      out.write("\t\ttable-layout:fixed;\r\n");
      out.write("\t\twidth:100%;\r\n");
      out.write("\t\theight:280px;\r\n");
      out.write("\t\toverflow:auto;\r\n");
      out.write("\t\tpadding:0;\r\n");
      out.write("\t\tmargin:0;\r\n");
      out.write("\t\tbackground-color:#f1f1f1;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv.posSortLstCls ol{\r\n");
      out.write("\t\tmargin:0;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv.posSortLstCls ol li{\r\n");
      out.write("\t\tmargin:0;\r\n");
      out.write("\t\tpadding:0;\r\n");
      out.write("\t}\r\n");
      out.write("\ttable.posSortTableCls{\r\n");
      out.write("\t\tbackground-color:#e1e1e1;\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\ttable.posSortTableCls tr{\r\n");
      out.write("\t\tbackground-color:#eaeaea;\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\ttable.posSortTableCls td{\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\toverflow:hidden;\t\t\r\n");
      out.write("\t}\t\r\n");
      out.write("\ttable.posSortTableCls td.tno{\r\n");
      out.write("\t\twidth:38px;\r\n");
      out.write("\t\tbackground-color:#f0f1f1;\r\n");
      out.write("\t}\r\n");
      out.write("\ttable.posSortTableCls td.tuid{\r\n");
      out.write("\t\twidth:150px;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\ttable.posSortTableCls td.tname{\r\n");
      out.write("\t\twidth:150px;\r\n");
      out.write("\t\tbackground-color:#f8f1f1;\r\n");
      out.write("\t}\r\n");
      out.write("\ttable.posSortTableCls td.cuid{\r\n");
      out.write("\t\twidth:150px;\r\n");
      out.write("\t}\r\n");
      out.write("\ttable.posSortTableCls td.cname{\r\n");
      out.write("\t\twidth:150px;\r\n");
      out.write("\t\tbackground-color:#f8f1f1;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#deptDataTree\tul{\r\n");
      out.write("\t\tpadding:0;\r\n");
      out.write("\t\tmargin-left:15px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#deptDataTree\tli{\r\n");
      out.write("\t\tlist-style:none;\r\n");
      out.write("\t\tmargin-top:1px;\r\n");
      out.write("\t\tmargin-bottom:1px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#deptDataTree\tli ul{\r\n");
      out.write("\t\tdisplay:none;\r\n");
      out.write("\t}\r\n");
      out.write("\t#deptDataTree span{\r\n");
      out.write("\t\tbackground-color:#eeeeee;\r\n");
      out.write("\t\tcolor:#666666;\r\n");
      out.write("\t\tcursor:pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\t#deptDataTree span.on{\r\n");
      out.write("\t\tbackground-color:#0022ff;\r\n");
      out.write("\t\tcolor:#fff;\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t#deptDataTree span.t{\r\n");
      out.write("\t\tpadding:0 3px;\r\n");
      out.write("\t}\t\t\r\n");
      out.write("\t#deptDataTree span.closed{\r\n");
      out.write("\t\tbackground: url(icon/folder_closed.gif) 0 0 no-repeat;\r\n");
      out.write("\t\tfont-size:12px;\r\n");
      out.write("\t\tpadding:2px 6px 1px 6px;\r\n");
      out.write("\t\tmargin:3px 0;\r\n");
      out.write("\t\tcolor:#fff;\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t#deptDataTree span.opened{\r\n");
      out.write("\t\tbackground: url(icon/folder_opened.gif) 0 0 no-repeat;\r\n");
      out.write("\t\tfont-size:12px;\r\n");
      out.write("\t\tmargin: 3px 0;\r\n");
      out.write("\t\tpadding:2px 6px 1px 6px;\r\n");
      out.write("\t\tcolor:#fff;\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"pgHeadBlock\" class=\"pgHeadBlock\">\r\n");
      out.write("<table border=0 width=\"100%\" height=\"100%\" cellspacing=\"0\"><tr>\r\n");
      out.write("<td algin=\"left\" width=41 class=\"title_BarImg\"></td>\r\n");
      out.write("<td align=\"left\" id=\"title_Font1\">");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write(" 的群组用户</td>\r\n");
      out.write("<td align=\"right\" id=\"title_Font2\"></td></tr></table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"toolsBlock\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"userTableBlock\" class=\"tableBlock\" align=\"center\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("var isWritable = ");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write(";\r\n");
      out.write("var curDc = \"");
      if (_jspx_meth_c_005fout_005f2(_jspx_page_context))
        return;
      out.write("\";\r\n");
      out.write("var curDepou = \"");
      if (_jspx_meth_c_005fout_005f3(_jspx_page_context))
        return;
      out.write("\";\r\n");
      out.write("\r\n");
      out.write("var depDesc = [];\r\n");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
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
      out.write("\t\r\n");
      out.write("function VF_storage(v){\r\n");
      out.write("\tif (v.trim() == 'local')\r\n");
      out.write("\t\treturn null;\r\n");
      out.write("\tvar index = v.trim().indexOf(\":\");\r\n");
      out.write("\tvar ip = v.substring(0,index);\r\n");
      out.write("\tif (v.trim() == '')\r\n");
      out.write("\t\treturn DICT.__NO_EMPTY;\r\n");
      out.write("\tvar ptn = /^([1-9]\\d?|1\\d{2}|2[0-4]\\d|25[0-5])\\.([0-9]\\d?|1\\d{2}|2[0-4]\\d|25[0-5])\\.([0-9]\\d?|1\\d{2}|2[0-4]\\d|25[0-5])\\.([0-9]\\d?|1\\d{2}|2[0-4]\\d|25[0-5])$/;\r\n");
      out.write("\tvar flg = ptn.test(ip);\r\n");
      out.write("\tif (!flg)\r\n");
      out.write("\t\treturn DICT.__IP_ERR_FORMAT;\r\n");
      out.write("\tif(ip == \"255.255.255.255\")\r\n");
      out.write("\t\treturn \"无效IP\";\r\n");
      out.write("\tvar port = v.substring(index+1);\r\n");
      out.write("\tvar ptn = /^(0|[1-9][0-9]*)$/;\r\n");
      out.write("\tvar flg = ptn.test(port);\r\n");
      out.write("\tif (!flg ) return \"无效端口\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function VF_safetyStr(v){\r\n");
      out.write("\tif(v=='hr')return;\r\n");
      out.write("\tif(v.length<=3)\r\n");
      out.write("\t\treturn \"用户名长度必须大于3\";\r\n");
      out.write("\tvar s = VF_SafeStr_MY(v);\r\n");
      out.write("\tif(s!=null)\r\n");
      out.write("\t\treturn s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function VF_SafeStr_MY(v){\r\n");
      out.write("\tptn = /^[A-Za-z]+[0-9A-Za-z_.]+[A-Za-z0-9]$/;\r\n");
      out.write("\tvar flg = ptn.test(v);\r\n");
      out.write("\tif (!flg ) return \"由数字、字母或下划线组成,以字母开头\";\r\n");
      out.write("\treturn null;\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("function VF_maxSenderNum(v){\r\n");
      out.write("\tif(v>300)\r\n");
      out.write("\t\treturn \"最大发送人数不能超过300\";\r\n");
      out.write("\tvar s = VF_onlyNum(v);\r\n");
      out.write("\tif(s!=null)\r\n");
      out.write("\t\treturn s;\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var domain_attsize = ");
      if (_jspx_meth_c_005fout_005f5(_jspx_page_context))
        return;
      out.write(";\r\n");
      out.write("function VF_attMentSize(v){\r\n");
      out.write("\tvar s =VF_onlyNum(v);\r\n");
      out.write("\tif(s!=null)\r\n");
      out.write("\t\treturn s;\r\n");
      out.write("\tif(v <= domain_attsize)\r\n");
      out.write("\t\treturn \"信件大小要大于附件大小( > \" + domain_attsize + \"M)\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var dataStruct = {\r\n");
      out.write("\tdc: {title: \"域名\", defaultValue: curDc},\r\n");
      out.write("\tuid: {title: \"帐号\" , isKey: true, validate: VF_safetyStr},\r\n");
      out.write("\tuserpassword: {title: \"新密码\",ftype: \"Password\",validate: VF_passwd},\r\n");
      out.write("\trepeat: {title: \"密码确认\",ftype: \"Password\",validate: VF_passwd},\r\n");
      out.write("\tispop3: {title: \"pop3\", ftype: \"Hash\", optionMap: {\"1\": \"开通\", \"0\": \"关闭\"}},\r\n");
      out.write("\tissmtp: {title: \"smtp\", ftype: \"Hash\", optionMap: {\"1\": \"开通\", \"0\": \"关闭\"}},\r\n");
      out.write("\tisproxy: {title: \"代理\", ftype: \"Hash\", optionMap: {\"0\": \"关闭\",\"1\": \"开通\"}},\r\n");
      out.write("\tmaxcc: {title: \"最大发送人数\", defaultValue:\"");
      if (_jspx_meth_c_005fout_005f6(_jspx_page_context))
        return;
      out.write("\", validate: VF_maxSenderNum},\r\n");
      out.write("\tsize: {title: \"邮箱空间(M)\", defaultValue: \"");
      if (_jspx_meth_c_005fout_005f7(_jspx_page_context))
        return;
      out.write("\",validate: this.VF_onlyNum},\r\n");
      out.write("\tmessagesize: {title: \"最大邮件大小(M)\", defaultValue: \"");
      if (_jspx_meth_c_005fout_005f8(_jspx_page_context))
        return;
      out.write("\", validate: VF_attMentSize},\r\n");
      out.write("\tstoragelocation :{title: \"存储\" , defaultValue: \"");
      if (_jspx_meth_c_005fout_005f9(_jspx_page_context))
        return;
      out.write(':');
      if (_jspx_meth_c_005fout_005f10(_jspx_page_context))
        return;
      out.write("\",validate: VF_storage},\r\n");
      out.write("\toudes: {title: \"部门名称(点击选择部门)\",defaultValue: \"点击选择部门\"},\r\n");
      out.write("\tou:{title:\"部门\",defaultValue:\"\"},\r\n");
      out.write("\tsn: {title: \"姓\"},\r\n");
      out.write("\tgivenname: {title: \"名\"},\r\n");
      out.write("\tdisplayname: {title: \"姓名\"},\r\n");
      out.write("\tdescription: {title: \"类型\",defaultValue: \"person\",ftype: \"Hash\",optionMap: {\"person\":\"个人\",\"unit\":\"单位\"}},\r\n");
      out.write("\temployeenumber: {title: \"管理者\"},\r\n");
      out.write("\temployeeid: {title: \"工(学)号\"},\r\n");
      out.write("\tstatus: {title: \"状态\", ftype: \"Hash\",optionMap:{'open': '开通', 'pause': '暂停','closed': '关闭'}},\r\n");
      out.write("\tishide: {title: \"显示地址簿\", ftype: \"Hash\",optionMap:{'0':'隐藏','1': '显示'}},\r\n");
      out.write("\tlasttime:{title:\"上次登陆时间\",defaultValue:\"未登陆\"},\r\n");
      out.write("\tsortnum: {title: \"排名\", defaultValue:\"10000\", validate: VF_onlyNum},\r\n");
      out.write("\tsearch:{title:\"条件\",defaultValue:\"uid\", ftype: \"Hash\",optionMap:{\"uid\":\"帐户名称\",\"displayname\":\"真实姓名\",\"company\":\"公司名称\",\"description\":\"部门名称\", \"size\": \"邮箱空间\"}},\r\n");
      out.write("\tsizeoption:{title:\"大小(仅用于邮箱空间)\",defaultValue:\"\", ftype: \"Hash\",optionMap:{\"\":\"\", \">\":\"大于\",\"=\":\"等于\",\"<\":\"小于\"}},\r\n");
      out.write("\tfindtype:{title:\"查询\",defaultValue:\"2\", ftype: \"Hash\",optionMap:{\"1\":\"精确查询\",\"2\":\"模糊查询\"}},\r\n");
      out.write("\ttextvalue:{title:\"条件值\",defaultValue:\"\"},\r\n");
      out.write("\tsavenew:{title:\"是否自动保存\",defaultValue:\"1\", ftype: \"Hash\", optionMap:{\"1\":\"自动保存\",\"0\":\"不自动保存\"}}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var dataSourceProps = {\r\n");
      out.write("\tisLocalSort: false,\r\n");
      out.write("\tlistURL: \"users.json?dc=\" + curDc + \"&depou=\" + curDepou,\r\n");
      out.write("\taddURL: \"user_add.json?dc=\" + curDc + \"&depou=\" + curDepou,\r\n");
      out.write("\tmodURL: \"user_mod.json?dc=\" + curDc + \"&depou=\" + curDepou,\r\n");
      out.write("\tdelURL: \"users_del.json?dc=\" + curDc\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var tableProps = {\r\n");
      out.write("\tsubjects: ['sortnum', \"uid\",\"size\",\"messagesize\",\"ou\",\"displayname\",\"lasttime\",\"description\",\"status\",\"ishide\"],\r\n");
      out.write("\thiddens:[\"dc\"],\r\n");
      out.write("\tisCheckbox : true, \r\n");
      out.write("\tfilter:{\r\n");
      out.write("\t\tou:function(v){\r\n");
      out.write("\t\t\tif(depDesc && depDesc[v])\r\n");
      out.write("\t\t\t\treturn depDesc[v];\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t\treturn v;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var addUserWinProps = {\r\n");
      out.write("\twidth: 600,\r\n");
      out.write("\theight:400,\r\n");
      out.write("\t/*\r\n");
      out.write("\tsubjects: [\"uid\",\"userpassword\",\"oudes\",\"ou\",\"displayname\",\"description\",\"employeeid\",\r\n");
      out.write("\t\t\"ispop3\",\"issmtp\",\"isproxy\",\"maxcc\",\"size\",\"messagesize\",\"storagelocation\",\"status\",\"ishide\"],\r\n");
      out.write("\t*/\r\n");
      out.write("\tsubjects: [\"uid\",\"userpassword\",\"oudes\",\"ou\",\"displayname\",\"size\",\"messagesize\"],\r\n");
      out.write("\t\r\n");
      out.write("\thiddens: [\"ou\"],\r\n");
      out.write("\ttitle: \"新增用户\",\r\n");
      out.write("\tisForgetDataStructKey: true\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var modUserWinProps = {\r\n");
      out.write("\twidth: 600,\r\n");
      out.write("\theight:400,\r\n");
      out.write("\ttitle: \"用户信息修改\",\r\n");
      out.write("\tsubjects: [\"uid\",\"userpassword\",\"oudes\",\"ou\",\"displayname\",\"description\",\"employeeid\",\r\n");
      out.write("\t\t\"ispop3\",\"issmtp\",\"isproxy\",\"maxcc\",\"size\",\"messagesize\",\"storagelocation\",\"status\",\"ishide\",\"savenew\"],\r\n");
      out.write("\thiddens: [\"ou\"]\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var modUserSortNumWinProps = {\r\n");
      out.write("\twidth: 400,\r\n");
      out.write("\theight:100,\r\n");
      out.write("\ttitle: \"用户排名修改\",\r\n");
      out.write("\tsubjects: [\"sortnum\"],\r\n");
      out.write("\thiddens: [\"ou\"]\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var modPassWinProps = {\r\n");
      out.write("\twidth: 400,\r\n");
      out.write("\theight:247,\r\n");
      out.write("\ttitle: \"密码修改\",\r\n");
      out.write("\tsubjects: [\"userpassword\"],\r\n");
      out.write("\thiddens:[\"uid\"]\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var searchWinProps = {\r\n");
      out.write("\ttitle:\"搜索\",\r\n");
      out.write("\tisForgetDataStructKey: true,\r\n");
      out.write("\twidth: 400,\r\n");
      out.write("\theight:247,\r\n");
      out.write("\tsubjects: [\"search\",\"textvalue\",\"findtype\"],\r\n");
      out.write("\tformURL: \"users_search.json?dc=\" + curDc + \"&depou=\" + curDepou\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var modSizeWinProps = {\r\n");
      out.write("\ttitle:\"批量修改邮箱大小\",\r\n");
      out.write("\tisForgetDataStructKey: true,\r\n");
      out.write("\twidth: 400,\r\n");
      out.write("\theight:247,\r\n");
      out.write("\tsubjects: [\"search\",\"textvalue\",\"findtype\",\"sizeoption\", \"size\"],\r\n");
      out.write("\tformURL : \"modUsersSize.json?dc=\" + curDc + \"&depou=\" + curDepou\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function viewWinProps(){\r\n");
      out.write("\tvar data = ds.getActiveData();\r\n");
      out.write("\tnew Ajax.Request(\"userinfo.json?uid=\" + data.uid +\"&dc=\" +data.dc, {\r\n");
      out.write("\t\tonComplete: function(req) {\r\n");
      out.write("\t\t\tvar v = richEval(req.responseText);\r\n");
      out.write("\t\t\tif(v.res != 1){\r\n");
      out.write("\t\t\t\talert('请求失败！');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar info = \"邮箱收件箱共计有\" + v.data.mailCount + \"封邮件<br>\"\r\n");
      out.write("\t\t\t+ \"邮箱以使用\" + v.data.spaceMailM +\"M<br>\"\r\n");
      out.write("\t\t\t+ \"网络U盘使用\" + v.data.spaceNetdiskM +\"M<br>\";\r\n");
      out.write("\t\t\tvar win = SkyDNA.Element.createAlertWin(info, {title: \"账户详细信息\",width: 300,height:200});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function listDep(ctr){\r\n");
      out.write("\tSkyDNA.Event.addEvent(ctr,'onclick',function(){\r\n");
      out.write("\t\tvar dc = document.getElementsByName('dc');\t\t\t\r\n");
      out.write("\t\tvar ous = document.getElementsByName('ou');\r\n");
      out.write("\t\tvar oudecs = document.getElementsByName('oudes');\r\n");
      out.write("\t\tif(ous.length<=0) return;\r\n");
      out.write("\t\tvar pou = ous[0];\r\n");
      out.write("\t\tvar poudesc = oudecs[0];\r\n");
      out.write("\t\tpou.readOnly = true;\r\n");
      out.write("\t\tvar depwin = null;\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\t *\tcreatae popwin to list department data tree\r\n");
      out.write("\t\t */\r\n");
      out.write("\t\t SkyDNA.Event.addEvent(poudesc,'onfocus',function(){\r\n");
      out.write("\t\t \tdepwin = SkyDNA.Element.createPopupWin({title: curDc + '部门列表',width: 350,height:380});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tvar treeCtr = _CC(\"div\", null, depwin.contentDom);\r\n");
      out.write("\t\t\ttreeCtr.innerHTML =  '<div id=\"deptDataTree\"><ul><li><span title=\"打开/折叠\" id=\"rootECBtn\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span><span _data=\"\" onclick=\"selectBranch(this);\" class=\"t\">部门</span></li></ul></div>';\r\n");
      out.write("\r\n");
      out.write("\t\t \tselectBranch = function (branch){\r\n");
      out.write("\t\t\t\tif(!branch) return;\r\n");
      out.write("\t\t\t\tif(window._selectNode) window._selectNode.className = 't';\r\n");
      out.write("\t\t\t\twindow._selectNode = branch;\r\n");
      out.write("\t\t\t\twindow._selectNode.className = 't on';\r\n");
      out.write("\t\t\t\tvar str = unescape(_selectNode.getAttribute(\"_data\"));\r\n");
      out.write("\t\t\t\tif(str == '' ) str = '{}';\r\n");
      out.write("\t\t\t\tvar _data = eval('(' + str + ')');\r\n");
      out.write("\t\t\t\tvar ou = _data?_data.ou:'';\r\n");
      out.write("\t\t\t\tvar desc = _data?_data.description:'';\r\n");
      out.write("\t\t\t\tpou.value= ou||'';\r\n");
      out.write("\t\t\t\tpoudesc.value = desc||'';\r\n");
      out.write("\t\t\t\tthis.win.dispose();\t\t\t\t\t\r\n");
      out.write("\t\t\t}.bind({win:depwin});\r\n");
      out.write("\t\t\tswitchBranch(_G('rootECBtn'));\r\n");
      out.write("\t\t\t//selectBranch(_G('rootECBtn').nextSibling);\r\n");
      out.write("\t\t });\r\n");
      out.write("\t  \t//SkyDNA.Event.addEvent(pou,'onblur',function(){if(depwin)depwin.dispose();});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("var\tds = new SkyDNA.DataSource(dataStruct, dataSourceProps);\r\n");
      out.write("function main() {\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\twith(SkyDNA.Element.createButtonsBar(_G(\"toolsBlock\"))) {\r\n");
      out.write("\t\tfilterCell = addCell();\r\n");
      out.write("\t\tfilterCell.innerHTML = \"查看: &nbsp;\";\r\n");
      out.write("\t\tvar optionMap = SkyDNA.Object.clone(dataStruct.status.optionMap);\r\n");
      out.write("\t\tvar selectEl = SkyDNA.Element.Select.create(filterCell, {'optionMap': optionMap});\r\n");
      out.write("\t\tselectEl.onchange = function() {\r\n");
      out.write("\t\t\tif(selectEl.value!='all')\r\n");
      out.write("\t\t\t\tdataSourceProps.listURL = \"../user/users.json?dc=\" + curDc + \"&depou=\" + curDepou + \"&status=\" + selectEl.value;\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t\tdataSourceProps.listURL = \"../user/users.json?dc=\" + curDc + \"&depou=\" + curDepou;\r\n");
      out.write("\t\t\tds.remoteListData();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\taddBtn = addButton(\"新增\");\r\n");
      out.write("\t\tmodBtn = addButton(\"修改\");\r\n");
      out.write("\t\t//modPassBtn = addButton(\"密码\");\r\n");
      out.write("\t\topenBtn = addButton(\"开通\",   openUsers);\r\n");
      out.write("\t\tpauseBtn = addButton(\"暂停\", pauseUsers);\r\n");
      out.write("\t\taliasBtn = addButton(\"别名\",  openAlias);\r\n");
      out.write("\t\trfBtn = addButton(\"刷新\");\r\n");
      out.write("\t\tdelBtn = addButton(\"删除\");\r\n");
      out.write("\t\t//searchBtn = addButton(\"搜索\");\r\n");
      out.write("\t\tsearchBtn = addButton(\"搜索\");\r\n");
      out.write("\t\thideTrueBtn = addButton(\"显示地址簿\",  hideTrue);\r\n");
      out.write("\t\thideFalseBtn = addButton(\"隐藏地址簿\",  hideFalse);\r\n");
      out.write("\t\tmodSortBtn = addButton(\"排名\");\r\n");
      out.write("\t\tmodSizeBtn = addButton(\"批量修改\");\r\n");
      out.write("\t\tviewBtn = addButton(\"查看账户信息\", viewWinProps);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(isWritable){\r\n");
      out.write("\t\t\tSkyDNA.Element.show(addBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(modBtn, true);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(modPassBtn, true);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(openBtn, true);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(pauseBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(aliasBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(rfBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(delBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(searchBtn, true);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(hideTrueBtn, true);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(hideFalseBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(modSortBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(modSizeBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(viewBtn, true);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tSkyDNA.Element.show(addBtn, false);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(modBtn, false);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(modPassBtn, false);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(openBtn, false);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(pauseBtn, false);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(aliasBtn, false);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(rfBtn, true);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(delBtn, false);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(searchBtn, true);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(hideTrueBtn, false);\r\n");
      out.write("\t//\t\tSkyDNA.Element.show(hideFalseBtn, false);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(modSortBtn, false);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(modSizeBtn, false);\r\n");
      out.write("\t\t\tSkyDNA.Element.show(viewBtn, false);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tds.bindAdd(addBtn,addUserWinProps);\r\n");
      out.write("\tds.bindMod(modBtn,modUserWinProps);\r\n");
      out.write("\tSkyDNA.Event.addEvent(modBtn,\"onclick\",function(){\r\n");
      out.write("\t\t\tvar ous = document.getElementsByName('ou');\r\n");
      out.write("\t\t\tvar oudecs = document.getElementsByName('oudes');\r\n");
      out.write("\t\t\tif(ous.length<=0||oudecs.length<=0) return;\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(depDesc && depDesc[ous[0].value])  oudecs[0].value  = depDesc[ous[0].value];\r\n");
      out.write("\t\r\n");
      out.write("\t});\r\n");
      out.write("//\tds.bindMod(modPassBtn, modPassWinProps);\r\n");
      out.write("\tds.bindMod(modSortBtn, modUserSortNumWinProps);\r\n");
      out.write("\tds.bindRefresh(rfBtn);\r\n");
      out.write("\tds.bindDel(delBtn);\r\n");
      out.write("\tds.bindSearch(searchBtn, searchWinProps);\r\n");
      out.write("\tds.bindSearch(modSizeBtn, modSizeWinProps);\r\n");
      out.write("\tds.createDataTable(_G(\"userTableBlock\"), tableProps);\r\n");
      out.write("\tds.createPageBar(_G(\"toolsBlock\"),\"pagenum\",\"perpagecount\",{countPerPage:15});\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\tds.remoteListData();\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function searchWin(){\r\n");
      out.write("\tvar win = SkyDNA.Element.createFormWin({title: \"搜索联系人\",width: \"400\",height: \"150\"});\r\n");
      out.write("\tvar form = SkyDNA.Element.createForm(win.contentDom, {formURL:'users_search.json'});\r\n");
      out.write("\twith(form){\r\n");
      out.write("\t\taddInputHidden(\"dc\",{value: curDc});\r\n");
      out.write("\t\taddInputHidden(\"depou\",{value: curDepou});\r\n");
      out.write("\t\taddSelect(\"search\",\"条件名\",{id:\"searchID\",value:\"uid\",optionMap:{\"uid\":\"用户名称\",\"displayname\":\"真实姓名\",\"company\":\"公司名称\",\"description\":\"部门名称\"}});\r\n");
      out.write("\t\taddInputText(\"text\",\"条件值\",{id:\"textID\"});\r\n");
      out.write("\t\taddSelect(\"radio\",\"搜索类型\",{id:\"radioID\",value:\"2\",optionMap:{\"2\":\"模糊查询\", \"1\":\"精确查询\"}});\r\n");
      out.write("\t}\r\n");
      out.write("\twin.submitBtn.onclick = function search(win){\r\n");
      out.write("\t\tvar sIDV = _G('searchID').value;\r\n");
      out.write("\t\tvar tIDV = _G('textID').value;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\turlPara = sIDV + '=' + tIDV;\r\n");
      out.write("\t\tif(sIDV == \"displayname\") urlPara = \"&displayname=\" + tIDV;\r\n");
      out.write("\t\tif(sIDV == \"uid\") urlPara = \"&uid=\" + tIDV;\r\n");
      out.write("\t\tif(sIDV == \"company\") urlPara = \"&company=\" + tIDV;\r\n");
      out.write("\t\tif(sIDV == \"description\") urlPara = \"&description=\" + tIDV;\r\n");
      out.write("\t\t*/\r\n");
      out.write("\t\tvar urlPara = '&search='+sIDV+'&textvalue='+tIDV;\r\n");
      out.write("\t\tvar sRadio =_G('radioID').value;\r\n");
      out.write("\t\turlPara +=\"&findtype=\" +sRadio;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tnew Ajax.Request(\"users_search.json?dc=\" + curDc + \"&depou=\" + curDepou+ urlPara , {\r\n");
      out.write("\t\t\tonComplete: function(req) {\r\n");
      out.write("\t\t\t\tvar v = richEval(req.responseText);\r\n");
      out.write("\t\t\t\tif (ds.pageBar)\r\n");
      out.write("\t\t\t\t\tds.pageBar.reset();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tds.__reListDatas(v.data, v.msg);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\twin.dispose();\r\n");
      out.write("\t}.bind(this,win);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function openUsers() {\r\n");
      out.write("\tmodUserStatus('status', 'open');\r\n");
      out.write("}\r\n");
      out.write("function pauseUsers() {\r\n");
      out.write("\tmodUserStatus('status', 'pause');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function hideTrue() {\r\n");
      out.write("\tmodUserStatus('ishide', 1);\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("function hideFalse() {\r\n");
      out.write("\tmodUserStatus('ishide', 0);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function modUserStatus(field, value) {\r\n");
      out.write("\tvar selDatas = ds.getSelectedDatas();\r\n");
      out.write("\t\r\n");
      out.write("\tvar uids = \"\";\r\n");
      out.write("\tselDatas.each(function(data) {\r\n");
      out.write("\t\tuids += \"&uid=\" + data.uid;\r\n");
      out.write("\t});\r\n");
      out.write("\tvar url = \"../user/userStatus_mod.json?dc=\" + curDc + \"&depou=\" + curDepou + \"&\" + field + \"=\" + value + uids;\t\r\n");
      out.write("\t\r\n");
      out.write("\tSkyDNA.Ajax.doRequest(url);\r\n");
      out.write("\tds.remoteListData();\r\n");
      out.write("}\r\n");
      out.write("\t\t\r\n");
      out.write("function moveUsers() {\r\n");
      out.write("\tvar selectedDatas = ds.getSelectedDatas();\r\n");
      out.write("\tif (selectedDatas.length == 0) {\r\n");
      out.write("\t\tSkyDNA.Element.createAlertWin(\"请先选择您要移动的员工！\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tvar win = SkyDNA.Element.createFormWin({title: \"移动到...\",width:500,height:220});\r\n");
      out.write("\t//var depOu = null;\r\n");
      out.write("\twin.contentDom.style.width = 'auto';\r\n");
      out.write("\twin.contentDom.style.height = '180px';\r\n");
      out.write("\twin.contentDom.style.overflow = \"auto\";\r\n");
      out.write("\twin.contentDom.innerHTML = \"\";\r\n");
      out.write("\r\n");
      out.write("\tvar treeCtr = _CC(\"div\", null, win.contentDom);\r\n");
      out.write("\ttreeCtr.innerHTML =  '<div id=\"deptDataTree\"><ul><li><span title=\"打开/折叠\" id=\"rootECBtn\" onclick=\"switchBranch(this);\" class=\"closed\">&nbsp;</span><span _data=\"\" onclick=\"selectBranch(this);\" class=\"t\">部门</span></li></ul></div>';\r\n");
      out.write(" \tselectBranch = function (branch){\r\n");
      out.write("\t\tif(!branch) return;\r\n");
      out.write("\t\tif(window._selectNode) window._selectNode.className = 't';\r\n");
      out.write("\t\twindow._selectNode = branch;\r\n");
      out.write("\t\twindow._selectNode.className = 't on';\r\n");
      out.write("\t}.bind({win:win});\r\n");
      out.write("\tswitchBranch(_G('rootECBtn'));\t\t\r\n");
      out.write("\twin.submitBtn.onclick = function() {\r\n");
      out.write("\t\tvar str = unescape(_selectNode.getAttribute(\"_data\"));\r\n");
      out.write("\t\tif(str == '' ) str = '{}';\r\n");
      out.write("\t\tvar _data = eval('(' + str + ')');\r\n");
      out.write("\t\tvar ou = _data?_data.ou:'';\r\n");
      out.write("\t\tvar desc = _data?_data.description:'';\r\n");
      out.write("\t\t//alert(ou);\t\t\r\n");
      out.write("\t\tvar depOu = ou;\r\n");
      out.write("\t\tif (!depOu) {\r\n");
      out.write("\t\t\tSkyDNA.Element.createAlertWin(\"请先选择要移动的目标部门！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (depOu == ds.datas[0].data.ou) {\r\n");
      out.write("\t\t\tSkyDNA.Element.createAlertWin(\"不能移动到相同的目录！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar moveuids = ds.getSelectedDatas();\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar uids=\"\";\r\n");
      out.write("\t\tmoveuids.each(function(data) {\r\n");
      out.write("\t\t\tuids +=\"&uid=\" + data.uid;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar  url = \"../user/moveUser.json?dc=\" + curDc + \"&ou=\" + curDepou + uids;\r\n");
      out.write("\t\tvar v = SkyDNA.Ajax.doRequestJSON(url);\r\n");
      out.write("\t\tif (v.res == 1) {\r\n");
      out.write("\t\t\twin.dispose();\r\n");
      out.write("\t\t\t// TODO \r\n");
      out.write("\t\t\tds.remoteListData();\r\n");
      out.write("\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\t\t\tSkyDNA.Element.createAlertWin(v.msg);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}.bind(this);\r\n");
      out.write("\t\r\n");
      out.write("\t//ds.remoteListData();\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\t\t\t\r\n");
      out.write("function openAlias() {\r\n");
      out.write("\t\r\n");
      out.write("\tvar data = ds.getActiveData();\r\n");
      out.write("\tvar uid = data.uid;\r\n");
      out.write("\tvar win = SkyDNA.Element.createPopupWin({title: uid + \" 用户别名管理\",width: 500,height:350});\r\n");
      out.write("\t\r\n");
      out.write("\tvar dataStruct = {\r\n");
      out.write("\t\t'uid': {title: '别名', isKey: true},\r\n");
      out.write("\t\t'dc':  {title: \"dc\", isKey: true, defaultValue: curDc}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar dsProps = {\r\n");
      out.write("\t\tlistURL: \"aliases.json?aliasedobjectname=\" + data.uid + \"@\" + curDc,\r\n");
      out.write("\t\tdelURL: \"aliases_del.json?\"\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar aliasDs = new SkyDNA.DataSource(dataStruct, dsProps);\r\n");
      out.write("\taliasDs.createDataTable(win.contentDom, {subjects: [\"uid\"], isCheckbox: true});\r\n");
      out.write("\t\twith(SkyDNA.Element.createButtonsBar(win.contentDom)){\r\n");
      out.write("\t\t\taliasDs.bindDel(addButton(\"删除别名\"));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t_CC(\"hr\", null, win.contentDom);\r\n");
      out.write("\taliasDs.remoteListData();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar formProps = {\r\n");
      out.write("\t\tformURL: \"alias_add.json?dc=\" + curDc + \"&uid=\" + data.uid,\r\n");
      out.write("\t\tonSubmitSucc: function() {aliasDs.remoteListData();}\r\n");
      out.write("\t};\r\n");
      out.write("\twith(SkyDNA.Element.createForm(win.contentDom,  formProps)) {\r\n");
      out.write("\t\taddInputText(\"aliasUid\", \"新别名\", {validate: VF_username});\r\n");
      out.write("\t\taddSubmit();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction delAlias(){\r\n");
      out.write("\t\tvar aliasdata = aliasDs.getSelectedDatas();\r\n");
      out.write("\t\tvar uids=\"\";\r\n");
      out.write("\t\taliasdata.each(function(data) {\r\n");
      out.write("\t\tuids +=\"&uid=\" + data.uid;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar url = \"aliases_del.json?dc=\" + curDc + \"&useruid=\"+uid + uids;\r\n");
      out.write("\t\tSkyDNA.Ajax.doRequest(url);\r\n");
      out.write("\t\taliasDs.remoteListData();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\tmain();\r\n");
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
      out.write("}\t\r\n");
      out.write("\r\n");
      out.write("var ___deptsData = ");
      if (_jspx_meth_c_005fout_005f11(_jspx_page_context))
        return;
      out.write(";\r\n");
      out.write("window.onload = function(){\r\n");
      out.write("\r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
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
    // /a/user/grpUsers.jsp(7,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /a/user/grpUsers.jsp(115,34) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
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
    // /a/user/grpUsers.jsp(126,17) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!ACTOR.isAddressBookRole}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/user/grpUsers.jsp(126,17) name = default type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setDefault("false");
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fdefault_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent(null);
    // /a/user/grpUsers.jsp(127,13) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent(null);
    // /a/user/grpUsers.jsp(128,16) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${depou}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
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
    // /a/user/grpUsers.jsp(131,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("dept");
    // /a/user/grpUsers.jsp(131,0) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deplist}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write('\r');
          out.write('\n');
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

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /a/user/grpUsers.jsp(132,1) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("depDesc[\"${dept.ou}\"] = \"${dept.description}\";", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/user/grpUsers.jsp(132,1) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent(null);
    // /a/user/grpUsers.jsp(188,21) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${attsize}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent(null);
    // /a/user/grpUsers.jsp(206,40) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${defaultusermaxcc}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f7 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f7.setParent(null);
    // /a/user/grpUsers.jsp(207,41) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f7.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userstoragesize}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f7 = _jspx_th_c_005fout_005f7.doStartTag();
    if (_jspx_th_c_005fout_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f8 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f8.setParent(null);
    // /a/user/grpUsers.jsp(208,50) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${messagesize}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f8 = _jspx_th_c_005fout_005f8.doStartTag();
    if (_jspx_th_c_005fout_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f9 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f9.setParent(null);
    // /a/user/grpUsers.jsp(209,48) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${storageIP}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f9 = _jspx_th_c_005fout_005f9.doStartTag();
    if (_jspx_th_c_005fout_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f10 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f10.setParent(null);
    // /a/user/grpUsers.jsp(209,78) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${storagePort}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f10 = _jspx_th_c_005fout_005f10.doStartTag();
    if (_jspx_th_c_005fout_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
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
    // /a/user/grpUsers.jsp(376,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${depou == 'dep'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t_G(\"pgHeadBlock\").style.display = \"none\";\r\n");
        out.write("\t");
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

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /a/user/grpUsers.jsp(409,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty depou}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\tmoveBtn = addButton(\"移动\",moveUsers);\r\n");
        out.write("\t\t\tSkyDNA.Element.show(moveBtn, isWritable);\r\n");
        out.write("\t\t");
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

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /a/user/grpUsers.jsp(469,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!isAddrAdmin}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\tlistDep(addBtn);\r\n");
        out.write("\t\tlistDep(modBtn);\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f11 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f11.setParent(null);
    // /a/user/grpUsers.jsp(708,19) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f11.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deptTreeStr}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /a/user/grpUsers.jsp(708,19) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f11.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f11 = _jspx_th_c_005fout_005f11.doStartTag();
    if (_jspx_th_c_005fout_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f11);
    return false;
  }
}
