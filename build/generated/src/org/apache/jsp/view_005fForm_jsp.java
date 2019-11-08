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

public final class view_005fForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");


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


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<meta content=\"en-us\" http-equiv=\"Content-Language\" />\n");
      out.write("<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/smweb.css\"/>\n");
      out.write("<title>S-Portal</title>\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"js/validate.js\">\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".style4 {\n");
      out.write("\tfont-family: \"Courier New\", Courier, monospace;\n");
      out.write("\tfont-size: medium;\n");
      out.write("}\n");
      out.write(".style5 {\n");
      out.write("\tborder-style:inset;\n");
      out.write("}\n");
      out.write(".style9 {\n");
      out.write("\tfont-size: small;\n");
      out.write("\tcolor: #FF0000;\n");
      out.write("}\n");
      out.write(".style12 {font-size: small; color: #333333; }\n");
      out.write(".style15 {color: #660000}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">\n");
      out.write("  <table width=\"956\" cellpadding=\"10\" class=\"style5\">\n");
      out.write("    <tr>\n");
      out.write("      <td width=\"689\"><table width=\"919\" border=\"0\">\n");
      out.write("        <tr>\n");
      out.write("          <td width=\"118\" align=\"right\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td width=\"229\" valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td width=\"82\" valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td width=\"210\" valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td width=\"87\" valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td width=\"167\" valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Student Id</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\"><label>\n");
      out.write("                  <input name=\"textStudentId\" type=\"text\" id=\"textStudentId\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(studentId);
      out.write("\">\n");
      out.write("          </label>\n");
      out.write("          </td>\n");
      out.write("           <td align=\"right\" valign=\"top\" class=\"style12\">Session</td>\n");
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

      out.write("</td>\n");
      out.write("          <td align=\"right\" valign=\"top\" class=\"style12\">Class</td>\n");
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

      out.write("</td>\n");
      out.write("\n");
      out.write("          <td align=\"right\" valign=\"top\" class=\"style12\">Term</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\"><select name=\"comboTermId\" id=\"comboTermId\">\n");
      out.write("            <option>=== Select Term ===</option>\n");
      out.write("            <option value=\"Term01\" ");
if(termId.equals("Term01")){out.print("Selected='true'");}
      out.write(">First Term</option>\n");
      out.write("            <option value=\"Term02\" ");
if(termId.equals("Term02")){out.print("Selected='true'");}
      out.write(">Second Term</option>\n");
      out.write("            <option value=\"Term03\" ");
if(termId.equals("Term03")){out.print("Selected='true'");}
      out.write(">Third Term</option>\n");
      out.write("          </select></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\"><label></label></td>\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Generate Form\"></td>\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("        </tr>\n");
      out.write("      </table>\n");
      out.write("      </td>\n");
      out.write("    </tr>\n");
      out.write("  </table>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
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
