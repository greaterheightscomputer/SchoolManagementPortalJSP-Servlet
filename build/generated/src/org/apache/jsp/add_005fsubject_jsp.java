package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Vector;
import gtr.DAO.SubjectDAO;
import autoId.SubjectId;;

public final class add_005fsubject_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("﻿\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"javascript/school.js\">\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");

    String subjectId = (String)request.getAttribute("subjectId");
    if(subjectId == null){
        subjectId = SubjectId.getId();
    }
    String name = (String)request.getAttribute("name");
    if(name == null){
        name = "";
    }
    String description = (String)request.getAttribute("description");
    if(description == null){
        description = "";
    }
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
      out.write("    <form method=\"post\" action=\"gtr?a=Subject\" name=\"form1\">\r\n");
      out.write("  <table width=\"731\" height=\"235\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("\t<td valign=\"top\"><table width=\"595\" border=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("          <td colspan=\"4\"><span class=\"style12\">");
      out.print(message);
      out.write("</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\" align=\"right\"><label>\r\n");
      out.write("          ");

              LinkedHashMap map = SubjectDAO.loadCombo();
              out.print("<select name='comboLoad'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>===Select Record===</OPTION>");
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
      out.write("          <label>\r\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Load Record\">\r\n");
      out.write("          </label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"145\">&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\">Subject ID : </td>\r\n");
      out.write("        <td colspan=\"3\"><label>\r\n");
      out.write("                <input name=\"textSubjectId\" type=\"text\" id=\"textSubjectId\" size=\"40\" maxlength=\"20\" value=\"");
      out.print(subjectId);
      out.write("\">\r\n");
      out.write("        </label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Subject Name  : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubjectName\" type=\"text\" id=\"textSubjectName\" size=\"40\" maxlength=\"20\" value=\"");
      out.print(name);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Description : </td>\r\n");
      out.write("        <td colspan=\"3\"><textarea name=\"textDescription\" cols=\"32\" rows=\"4\" id=\"textDescription\">");
      out.print(description);
      out.write("</textarea></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td width=\"121\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Record\" onClick=\"return validateSubject(form1)\"></td>\r\n");
      out.write("        <td width=\"156\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Update Record\" onClick=\"return validateSubject(form1)\"></td>\r\n");
      out.write("        <td width=\"155\"><label>\r\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Delete Record\" onClick=\"return validateSubject(form1)\">\r\n");
      out.write("        </label></td>\r\n");
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
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
