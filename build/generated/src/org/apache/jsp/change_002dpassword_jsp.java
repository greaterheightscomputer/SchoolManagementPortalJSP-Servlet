package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Vector;;

public final class change_002dpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");

    
    String username = (String)session.getAttribute("username");
    if(username == null){
        username = "";
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
      out.write("<title>Change-Password </title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".style1 {\r\n");
      out.write("\tfont-family: \"Courier New\", Courier, monospace;\r\n");
      out.write("\tfont-size: small;\r\n");
      out.write("}\r\n");
      out.write(".style5 {\r\n");
      out.write("\tborder-style:inset;\r\n");
      out.write("}\r\n");
      out.write(".style7 {\r\n");
      out.write("\tfont-family: Cambria, Cochin, Georgia, Times, \"Times New Roman\", serif;\r\n");
      out.write("\tfont-size: x-small;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write(".style9 {\r\n");
      out.write("\tfont-size: small;\r\n");
      out.write("\tcolor: #FF0000;\r\n");
      out.write("}\r\n");
      out.write(".style10 {font-size: medium; font-family: \"Courier New\", Courier, monospace;}\r\n");
      out.write(".style20 {font-family: Arial, Helvetica, sans-serif; font-size: 14px; }\r\n");
      out.write(".style21 {font-size: 14px}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script language=\"Javascript\">\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form id=\"form1\" method=\"post\" action=\"gtr?a=ChangePassword\">\r\n");
      out.write("  <table width=\"798\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td width=\"689\"><p class=\"style10\"> </p>\r\n");
      out.write("          <table width=\"769\" border=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td colspan=\"4\" class=\"style9\">\r\n");
      out.write("                ");
      out.print(message);
      out.write("         </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"116\">&nbsp;</td>\r\n");
      out.write("          <td width=\"120\">&nbsp;</td>\r\n");
      out.write("          <td width=\"170\">&nbsp;</td>\r\n");
      out.write("          <td width=\"313\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("        <table width=\"765\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"221\" align=\"right\"><span class=\"style20\">Old Password</span></td>\r\n");
      out.write("            <td width=\"534\"><span class=\"style1\">\r\n");
      out.write("              <input name=\"textOldPassword\" type=\"password\" class=\"style1\" id=\"textOldPassword\" style=\"width: 192px\" tabindex=\"2\" size=\"40\">\r\n");
      out.write("            </span></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"right\" class=\"style20\">&nbsp;</td>\r\n");
      out.write("            <td class=\"style1\" style=\"width: 419px\"><input name=\"textUsername\" type=\"hidden\" class=\"style1\" id=\"textUsername\" style=\"width: 192px\" tabindex=\"2\" value=\"");
      out.print(username);
      out.write("\" size=\"40\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"right\" class=\"style20\">New Password</td>\r\n");
      out.write("            <td class=\"style1\" style=\"width: 419px\"><input name=\"textPassword\" type=\"password\" class=\"style1\" id=\"textPassword\" style=\"width: 192px\" tabindex=\"2\" size=\"40\"></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"right\"><span class=\"style21\"></span></td>\r\n");
      out.write("            <td class=\"style1\" style=\"width: 419px\">&nbsp;</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"right\"><span class=\"style20\">Re-enter Password </span></td>\r\n");
      out.write("            <td><input name=\"textConfirmPassword\" type=\"password\" class=\"style1\" id=\"textConfirmPassword\" style=\"width: 192px\" tabindex=\"2\" size=\"40\"></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td align=\"right\"><span class=\"style21\"></span></td>\r\n");
      out.write("            <td>&nbsp;</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>&nbsp;</td>\r\n");
      out.write("            <td><strong>\r\n");
      out.write("              <input name=\"buttonSubmit\" type=\"submit\" class=\"style7\" id=\"buttonSubmit\" value=\"Change Password\" />\r\n");
      out.write("            </strong></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>      </td>\r\n");
      out.write("    </tr>\r\n");
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
