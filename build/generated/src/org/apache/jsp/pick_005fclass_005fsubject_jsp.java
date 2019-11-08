package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Vector;
import gtr.DAO.ClassDAO;
import autoId.ClassId;;

public final class pick_005fclass_005fsubject_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("﻿\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"jscript/branch.js\">\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
    
    String message = (String)request.getAttribute("msg");
    if(message == null){
        message = "";
    }



      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta content=\"en-us\" http-equiv=\"Content-Language\" />\r\n");
      out.write("<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/smweb.css\"/>\r\n");
      out.write("<title>S-Portal</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".style5 {\r\n");
      out.write("\tborder-style:inset;\r\n");
      out.write("}\r\n");
      out.write(".style12 {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: #660000;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <form id=\"form1\" method=\"post\" action=\"gtr?a=ClassSubject\" name=\"form1\">\r\n");
      out.write("  <table width=\"684\" height=\"235\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("\t<td width=\"652\" valign=\"top\"><p>&nbsp;</p>\r\n");
      out.write("\t  <p>&nbsp;</p>\r\n");
      out.write("\t  <table width=\"595\" border=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("          <td colspan=\"4\"><span class=\"style12\">");
      out.print(message);
      out.write("</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td width=\"432\" colspan=\"3\"><label>\r\n");
      out.write("          ");

              LinkedHashMap map = ClassDAO.loadCombo();
              out.print("<select name='comboLoad'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Class to Register Subject ===</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'>" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("\r\n");
      out.write("        </label>\r\n");
      out.write("          <label></label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"145\">&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Load Record\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("  </table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
