package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teacher_005fnavigation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("   <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title></title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/smweb.css\"/>\r\n");
      out.write("        <!-- My Test Accordion -->\r\n");
      out.write("        <script src=\"js/jquery-1.2.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/jquery.cookie.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/menu.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\r\n");
      out.write("\r\n");
      out.write("    \t<base target=\"main\">\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".style1 {font-size: 2em}\r\n");
      out.write("-->\r\n");
      out.write("        </style>\r\n");
      out.write("</head>\r\n");
      out.write("    <body>\r\n");
      out.write("            <ul id=\"menu1\" class=\"menu noaccordion\">\r\n");
      out.write("            <li class=\"style1\">SCH BOARD</li>\r\n");
      out.write("            <li><a class=\"m1\" href=\"Home1.jsp\" target=\"main\">Home</a></li>\r\n");
      out.write("            <li><a class=\"m3\" href=\"gtr?a=change_passwordlink\" target=\"main\">Change Password</a></li>\r\n");
      out.write("            <li><a class=\"m3\" href=\"http://209.173.133.66/default.aspx\" target=\"main\">Send Bulk SMS</a></li>\r\n");
      out.write("            <li><a class=\"m4\" href=\"#\">Manage Subject</a>\r\n");
      out.write("                    <ul class=\"menu\">\r\n");
      out.write("                        <li><a href=\"gtr?a=addSubject\" target=\"main\">Subject Record</a></li>\r\n");
      out.write("                        <li><a href=\"gtr?a=Report&RepType=1\" target=\"main\">Veiw Subjects</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li><a class=\"m4\" href=\"#\">Manage Session</a>\r\n");
      out.write("                    <ul class=\"menu\">\r\n");
      out.write("                        <li><a href=\"gtr?a=addSession\" target=\"main\">Session Record</a></li>\r\n");
      out.write("                        <li><a href=\"gtr?a=Report&RepType=2\" target=\"main\">View Sessions</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li><a class=\"m4\" href=\"#\">Manage Class</a>\r\n");
      out.write("                    <ul class=\"menu\">\r\n");
      out.write("                        <li><a href=\"gtr?a=addClass\" target=\"main\">Class Record</a></li>\r\n");
      out.write("                        <li><a href=\"gtr?a=addClassSubject\" target=\"main\">Class Subject Registration</a></li>\r\n");
      out.write("                         <li><a href=\"view_subject_registration.jsp\" target=\"main\">View Subject Registration</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("           <li><a class=\"m4\" href=\"#\">Manage Student</a>\r\n");
      out.write("                    <ul class=\"menu\">\r\n");
      out.write("                        <li><a href=\"gtr?a=addStudent\" target=\"main\">Student Record</a></li>\r\n");
      out.write("                        <li><a href=\"gtr?a=addSport\" target=\"main\">Sport Record</a></li>\r\n");
      out.write("                        <li><a href=\"gtr?a=addCtime\" target=\"main\">Habit Record</a></li>\r\n");
      out.write("                        <li><a href=\"gtr?a=addDevelopment\" target=\"main\">Development Record</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("             <li><a class=\"m4\" href=\"#\">Assessment</a>\r\n");
      out.write("                    <ul class=\"menu\">\r\n");
      out.write("                        <li><a href=\"gtr?a=addAssessment\" target=\"main\">Add Assessment</a></li>\r\n");
      out.write("                   </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            \r\n");
      out.write("       </ul>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
