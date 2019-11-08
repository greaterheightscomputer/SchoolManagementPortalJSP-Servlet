package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import gtr.DAO.UserDAO;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");


    String username = (String)session.getAttribute("name");
    if(username == null){
        //response.sendRedirect("./login.jsp");
    }

    String profileId = (String) session.getAttribute("profileId");
    if(profileId == null){
        profileId = "";
    }


      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("    \r\n");
      out.write("        <title></title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/smweb.css\"/>\r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <frameset rows=\"123,56*\">\r\n");
      out.write("\r\n");
      out.write("        <frame name=\"top\" scrolling=\"no\" frameborder=0 noresize target=\"contents\" src=\"header.jsp\"/>\r\n");
      out.write("        <frameset cols=\"172,*\">\r\n");
      out.write("            <frame name=\"contents\" target=\"main\" frameborder=0 src=\"");
      out.print(UserDAO.setMenu(profileId));
      out.write(".jsp\"/>\r\n");
      out.write("            <frame name=\"main\" frameborder=0 scrolling=\"auto\" src=\"Home2.jsp\" noresize/>\r\n");
      out.write("        </frameset>\r\n");
      out.write("        <!--frame name=\"bottom\" scrolling=\"no\" frameborder=0 noresize target=\"contents\" src=\"footer.jsp\"/-->\r\n");
      out.write("        <noframes>\r\n");
      out.write("            <body>\r\n");
      out.write("                <p>This page uses frames, but your browser doesn't support them.</p>\r\n");
      out.write("            </body>\r\n");
      out.write("        </noframes>\r\n");
      out.write("    </frameset>\r\n");
      out.write("\r\n");
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
