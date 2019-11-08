package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Vector;
import gtr.DAO.UserDAO;
import gtr.DAO.StaffDAO;;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String username = (String)request.getAttribute("username");
    if(username == null){
        username = "";
    }
    String staffId = (String)request.getAttribute("staffId");
    if(staffId == null){
        staffId = "";
    }
    String profileId = (String)request.getAttribute("profileId");
    if(profileId == null){
        profileId = "";
    }
    
    String profile = (String)session.getAttribute("profileId");
    if(profile == null){
        profile = "";
    }

    String message = (String)request.getAttribute("msg");
    if(message == null){
        message = "";
    }

    String userStatus = (String)request.getAttribute("status");
    String userValue = "";
    if(userStatus == null){
        userStatus = "";
    }
    else if(Integer.valueOf(userStatus) == 0){
        userValue = "Unblock User";
    }
    else if(Integer.valueOf(userStatus) == 2){
        userValue = "Unblock User";
    }
    else if(Integer.valueOf(userStatus) == 1){
        userValue = "Block User";
    }



      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta content=\"en-us\" http-equiv=\"Content-Language\" />\r\n");
      out.write("<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/smweb.css\"/>\r\n");
      out.write("<title></title>\r\n");
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
      out.write("<form id=\"form1\" method=\"post\" action=\"gtr?a=User\">\r\n");
      out.write("  <table width=\"731\" height=\"235\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("\t<td valign=\"top\"><table width=\"646\" border=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("          <td colspan=\"5\"><span class=\"style12\">");
      out.print(message);
      out.write("</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td colspan=\"4\" align=\"right\">\r\n");
      out.write("            ");

              LinkedHashMap map = UserDAO.loadCombo();
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
      out.write("          <label>\r\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Load Record\">\r\n");
      out.write("          </label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"184\">&nbsp;</td>\r\n");
      out.write("        <td colspan=\"4\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\"> Username : </td>\r\n");
      out.write("        <td colspan=\"4\"><label>\r\n");
      out.write("                <input name=\"textUsername\" type=\"text\" size=\"40\" maxlength=\"50\" value=\"");
      out.print(username);
      out.write("\">\r\n");
      out.write("        </label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Password : </td>\r\n");
      out.write("        <td colspan=\"4\"><input name=\"textPassword\" type=\"password\" size=\"40\" maxlength=\"50\" value=\"\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Re-enter Password : </td>\r\n");
      out.write("        <td colspan=\"4\"><input name=\"textConfirmPassword\" type=\"password\" size=\"40\" maxlength=\"50\" value=\"\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Staff  : </td>\r\n");
      out.write("        <td colspan=\"4\">\r\n");
      out.write("            ");

              map = StaffDAO.loadCombo();
              out.print("<select name='comboStaffId'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Staff ===</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(staffId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\">User Profile : </td>\r\n");
      out.write("        <td colspan=\"4\">");

              map = UserDAO.loadProfile(profile);
              out.print("<select name='comboProfileId'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>==Select User Profile==</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(profileId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\">&nbsp;</td>\r\n");
      out.write("        <td colspan=\"4\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("     \r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td width=\"2\">&nbsp;</td>\r\n");
      out.write("        <td width=\"150\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Record\"></td>\r\n");
      out.write("        <td width=\"152\">\r\n");
      out.write("          ");
      out.write("\r\n");
      out.write("       </td>\r\n");
      out.write("        <td width=\"136\">\r\n");
      out.write("            <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Delete Record\">\r\n");
      out.write("        </td>\r\n");
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
