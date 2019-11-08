package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import gtr.DAO.ClassDAO;
import gtr.DAO.AssessmentDAO;
import gtr.DAO.SessionDAO;
import gtr.DAO.ExamDAO;

public final class view_005fresult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");


    String studentId = (String)request.getAttribute("studentId");
    if(studentId == null){
        studentId = "";
    }
    String classId = (String)request.getAttribute("classId");
    if(classId == null){
        classId = "";
    }
    String sessionId = (String)request.getAttribute("sessionId");
    if(sessionId == null){
        sessionId = "";
    }
    String termId = (String)request.getAttribute("termId");
    if(termId == null){
        termId = "";
    }
    
    String message = (String)request.getAttribute("msg");
    if(message == null){
        message = "";
    }


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta content=\"en-us\" http-equiv=\"Content-Language\" />\r\n");
      out.write("<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/smweb.css\"/>\r\n");
      out.write("<title>S-Portal</title>\r\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"js/validate.js\">\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".style4 {\r\n");
      out.write("\tfont-family: \"Courier New\", Courier, monospace;\r\n");
      out.write("\tfont-size: medium;\r\n");
      out.write("}\r\n");
      out.write(".style5 {\r\n");
      out.write("\tborder-style:inset;\r\n");
      out.write("}\r\n");
      out.write(".style9 {\r\n");
      out.write("\tfont-size: small;\r\n");
      out.write("\tcolor: #FF0000;\r\n");
      out.write("}\r\n");
      out.write(".style12 {font-size: small; color: #333333; }\r\n");
      out.write(".style15 {color: #660000}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <form id=\"form1\" name=\"form1\" method=\"post\" action=\"gtr?a=Report&RepType=7\">\r\n");
      out.write("  <table width=\"956\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td width=\"689\"><table width=\"919\" border=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"118\" align=\"right\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td width=\"229\" valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td width=\"82\" valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td width=\"210\" valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td width=\"87\" valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td width=\"167\" valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Student Id</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\"><label>\r\n");
      out.write("                  <input name=\"textStudentId\" type=\"text\" id=\"textStudentId\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(studentId);
      out.write("\">\r\n");
      out.write("          </label>\r\n");
      out.write("          </td>\r\n");
      out.write("           <td align=\"right\" valign=\"top\" class=\"style12\">Session</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">");

              LinkedHashMap smap = SessionDAO.loadCombo();
              out.print("<select name='comboSessionId'>");
              if (smap.isEmpty()) {
                out.print("<OPTION value='0'>==No  Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Class ===</OPTION>");
                    Set keys = smap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = smap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(sessionId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");

                    }

                }
              out.println("</select>");

      out.write("</td>\r\n");
      out.write("          <td align=\"right\" valign=\"top\" class=\"style12\">Class</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">");

              LinkedHashMap dmap = ClassDAO.loadCombo();
              out.print("<select name='comboClassId'>");
              if (dmap.isEmpty()) {
                out.print("<OPTION value='0'>==No  Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Class ===</OPTION>");
                    Set keys = dmap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = dmap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(classId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");

                    }

                }
              out.println("</select>");

      out.write("</td>\r\n");
      out.write("         \r\n");
      out.write("          <td align=\"right\" valign=\"top\" class=\"style12\">Term</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\"><select name=\"comboTermId\" id=\"comboTermId\">\r\n");
      out.write("            <option>=== Select Term ===</option>\r\n");
      out.write("            <option value=\"Term01\" ");
if(termId.equals("Term01")){out.print("Selected='true'");}
      out.write(">First Term</option>\r\n");
      out.write("            <option value=\"Term02\" ");
if(termId.equals("Term02")){out.print("Selected='true'");}
      out.write(">Second Term</option>\r\n");
      out.write("            <option value=\"Term03\" ");
if(termId.equals("Term03")){out.print("Selected='true'");}
      out.write(">Third Term</option>\r\n");
      out.write("          </select></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\"><label></label></td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Generate Result\"></td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      </td>\r\n");
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
