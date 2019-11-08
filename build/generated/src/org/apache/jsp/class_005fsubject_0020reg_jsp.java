package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.Vector;
import gtr.DAO.ClassSubjectDAO;
import gtr.DAO.SubjectDAO;
import gtr.DAO.ClassDAO;
import autoId.ClassId;;

public final class class_005fsubject_0020reg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"jscript/branch.js\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");

    String classId = (String)session.getAttribute("classId");
    if(classId == null){
        classId = "";
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
      out.write(".style17 {font-size: 12px}\r\n");
      out.write(".style18 {font-size: 11px}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <table width=\"762\" height=\"235\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("\t<td width=\"652\" valign=\"top\"><p>&nbsp;</p>\r\n");
      out.write("            <p>Subject Registration for ");
      out.print(ClassDAO.getClassName(classId));
      out.write("</p>\r\n");
      out.write("           <table width=\"595\" border=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("          <td colspan=\"4\"><span class=\"style12\">");
      out.print(message);
      out.write("</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("\t<br/>\r\n");
      out.write("\t  <table width=\"529\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td bgcolor=\"#F0F0F0\"><span class=\"style17\">SUBJECT CODE </span></td>\r\n");
      out.write("          <td width=\"354\" bgcolor=\"#F0F0F0\"><span class=\"style17\">SUBJECT NAME </span></td>\r\n");
      out.write("          <td width=\"44\" bgcolor=\"#F0F0F0\"><span class=\"style17\"></span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

         Vector vector = SubjectDAO.loadAllRecord();
         Enumeration enu = vector.elements();
         while(enu.hasMoreElements()){
            String subjectId = enu.nextElement().toString().trim();
            String subject = enu.nextElement().toString().trim();

            int chkCS = ClassSubjectDAO.checkSubjectId(classId, subjectId);
            if(chkCS != 0){
     
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form id=\"form1\" method=\"post\" action=\"gtr?a=ClassSubject\" name=\"form1\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"125\"><span class=\"style18\">");
      out.print(subjectId);
      out.write("</span></td>\r\n");
      out.write("            <td><span class=\"style18\">");
      out.print(subject);
      out.write("\r\n");
      out.write("            <input type=\"hidden\" name=\"textClassId\" value=\"");
      out.print(classId);
      out.write("\"/>\r\n");
      out.write("            <input type=\"hidden\" name=\"textSubjectId\" value=\"");
      out.print(subjectId);
      out.write("\"/>\r\n");
      out.write("          </span></td>\r\n");
      out.write("          <td><label>\r\n");
      out.write("            <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add\">\r\n");
      out.write("          </label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        ");

                }
            }

     
      out.write("\r\n");
      out.write("      </table>\r\n");
      out.write("\t  <p>&nbsp;</p></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("  </table>\r\n");
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
