package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Language\" content=\"en-us\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n");
      out.write("<title>S-Portal : Login Page</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".style1 {\r\n");
      out.write("         font-family: \"Times New Roman\", Times, serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("}\r\n");
      out.write(".style4 {\r\n");
      out.write("\tfont-family: \"Times New Roman\", Times, serif;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-style: italic;\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("}\r\n");
      out.write(".style6 {\r\n");
      out.write("\tfont-size: 28px;\r\n");
      out.write("\tfont-family: Georgia, \"Times New Roman\", Times, serif;\r\n");
      out.write("}\r\n");
      out.write(".style7 {\r\n");
      out.write("\tfont-family: \"Times New Roman\", Times, serif;\r\n");
      out.write("\tfont-size: 11px;\r\n");
      out.write("\tcolor: #FF0000;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\"/>\r\n");

        String message = (String)request.getAttribute("msg");
        if(message == null){
            message = "";
        }
 
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".style10 {\r\n");
      out.write("\tfont-family: \"Times New Roman\", Times, serif;\r\n");
      out.write("\tfont-size: 10;\r\n");
      out.write("\tcolor: #DC3433;\r\n");
      out.write("}\r\n");
      out.write(".style11 {\r\n");
      out.write("\tfont-family: \"Courier New\", Courier, monospace;\r\n");
      out.write("\tfont-size: 13px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write(".style12 {color: #DC3433}\r\n");
      out.write(".style13 {\r\n");
      out.write("\tcolor: #86B8D1;\r\n");
      out.write("\tfont-size: 40px;\r\n");
      out.write("}\r\n");
      out.write(".style14 {\r\n");
      out.write("\tfont-size: 24px;\r\n");
      out.write("\tcolor: #D38B03;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<p align=\"center\">&nbsp;</p>\r\n");
      out.write("<center>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("\t<p align=\"center\">&nbsp;</p>\r\n");
      out.write("\t<p align=\"center\">&nbsp;</p>\r\n");
      out.write("\t<table border=\"0\" width=\"30%\" style=\"border-collapse: collapse\" cellpadding=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" rowspan=\"2\" bordercolor=\"#FF8040\" bgcolor=\"#FFFFFF\" class=\"style6\">\r\n");
      out.write("\t\t\t<span class=\"style13\">S</span>-<span class=\"style14\">PORTAL  </span></td>\r\n");
      out.write("\t\t\t<td colspan=\"3\" bordercolor=\"#FF8040\" bgcolor=\"#FFFFFF\">&nbsp;</td>\r\n");
      out.write("\t\t    <td bordercolor=\"#FF8040\" bgcolor=\"#FFFFFF\" width=\"30\">&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td bordercolor=\"#2A5F8B\" bgcolor=\"#4981BE\">&nbsp;</td>\r\n");
      out.write("\t\t    <td colspan=\"2\" bordercolor=\"#2A5F8B\" bgcolor=\"#4981BE\"><span class=\"style11\">\r\n");
      out.write("\t\t\t<font size=\"3\">Admin Login</font></span></td>\r\n");
      out.write("\t\t    <td bordercolor=\"#FF8040\" bgcolor=\"#89B2C8\" width=\"30\">&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"520\" rowspan=\"2\" valign=\"top\">\r\n");
      out.write("\t\t\t<p align=\"center\">\r\n");
      out.write("\t\t\t<img border=\"0\" src=\"images/Logo.gif\" width=\"163\" height=\"152\"></td>\r\n");
      out.write("\t\t\t<td width=\"4\" rowspan=\"2\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("\t\t  <td bgcolor=\"#77A6B6\"><p class=\"style7\"></td>\r\n");
      out.write("\t\t    <td colspan=\"2\"><form method=\"POST\" action=\"gtr?a=Login\">\r\n");
      out.write("               <!--webbot bot=\"SaveResults\" U-File=\"C:\\Users\\GTR\\Desktop\\Login\\_private\\form_results.csv\" S-Format=\"TEXT/CSV\" S-Label-Fields=\"TRUE\" -->\r\n");
      out.write("              <div align=\"right\">\r\n");
      out.write("                <table border=\"0\" width=\"186\" cellpadding=\"0\">\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td width=\"54\"><span class=\"style1\">Username</span></td>\r\n");
      out.write("                    <td width=\"126\"><input type=\"text\" name=\"textUsername\" size=\"20\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td width=\"54\"><span class=\"style1\">Password</span></td>\r\n");
      out.write("                    <td><input type=\"password\" name=\"textPassword\" size=\"20\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td width=\"54\">&nbsp;</td>\r\n");
      out.write("                    <td>&nbsp;</td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td width=\"54\">&nbsp;</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Submit\" name=\"buttonSubmit1\"></td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("              </div>\r\n");
      out.write("\t        </form></td>\r\n");
      out.write("\t\t    <td width=\"30\" bgcolor=\"#89B2C8\">&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t  <td width=\"4\" bgcolor=\"#77A6B6\"><p class=\"style7\"><span class=\"style12\"></span></td>\r\n");
      out.write("\t\t  <td width=\"79\"><span class=\"style12\"></span></td>\r\n");
      out.write("\t\t  <td width=\"123\"><span class=\"style10\">");
      out.print(message);
      out.write("</span></td>\r\n");
      out.write("\t\t  <td bgcolor=\"#77A6B6\">&nbsp;</td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" valign=\"top\" bgcolor=\"#4981BE\">&nbsp;</td>\r\n");
      out.write("\t\t\t<td colspan=\"3\" bgcolor=\"#4981BE\"><p class=\"style7\"><span class=\"style12\"></span></td>\r\n");
      out.write("\t\t    <td width=\"30\" bgcolor=\"#4981BE\">&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" bgcolor=\"#D38B03\">&nbsp;</td>\r\n");
      out.write("\t\t\t<td colspan=\"3\" bgcolor=\"#D38B03\">\r\n");
      out.write("\t\t  <p align=\"right\" class=\"style4\">powered by JAVA </td>\r\n");
      out.write("\t\t    <td width=\"30\" bgcolor=\"#9D7216\">&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
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
