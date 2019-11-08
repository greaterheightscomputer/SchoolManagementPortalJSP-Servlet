package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import gtr.DAO.SessionDAO;
import gtr.DAO.ClassDAO;
import gtr.DAO.SubjectDAO;
import gtr.DAO.ExamDAO;

public final class exam_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <script language=\"javascript\" type=\"text/javascript\" src=\"javascript/school.js\">\r\n");
      out.write("    </script>\r\n");

            String examId = (String) request.getAttribute("examId");
            if (examId == null) {
                examId = "";
            }
            String examName = (String) request.getAttribute("examName");
            if (examName == null) {
                examName = "";
            }
            String examQuestion = (String) request.getAttribute("question");
            if (examQuestion == null) {
                examQuestion = "";
            }
            String passMark = (String) request.getAttribute("passMark");
            if (passMark == null) {
                passMark = "";
            }
            String sessionId = (String) request.getAttribute("sessionId");
            if (sessionId == null) {
                sessionId = "";
            }
            String classId = (String) request.getAttribute("classId");
            if (classId == null) {
                classId = "";
            }
            String subjectId = (String) request.getAttribute("subjectId");
            if (subjectId == null) {
                subjectId = "";
            }
            String termId = (String) request.getAttribute("termId");
            if (termId == null) {
                termId = "";
            }

            String message = (String) request.getAttribute("msg");
            if (message == null) {
                message = "";
            }


      out.write("\r\n");
      out.write("\r\n");
      out.write("        <meta content=\"en-us\" http-equiv=\"Content-Language\" />\r\n");
      out.write("        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/smweb.css\"/>\r\n");
      out.write("        <title>S-Portal</title>\r\n");
      out.write("       \r\n");
      out.write("          <style type=\"text/css\">\r\n");
      out.write("            .style4 {\r\n");
      out.write("                font-family: \"Courier New\", Courier, monospace;\r\n");
      out.write("                font-size: medium;\r\n");
      out.write("            }\r\n");
      out.write("            .style5 {\r\n");
      out.write("                border-style:inset;\r\n");
      out.write("            }\r\n");
      out.write("            .style9 {\r\n");
      out.write("                font-size: small;\r\n");
      out.write("                color: #FF0000;\r\n");
      out.write("            }\r\n");
      out.write("            .style12 {font-size: small; color: #333333; }\r\n");
      out.write("            .style15 {color: #660000}\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <form id=\"form1\" name=\"form1\" method=\"post\" action=\"gtr?a=Exam\">\r\n");
      out.write("            <table width=\"707\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"689\"><table width=\"668\" border=\"0\">\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td colspan=\"6\" class=\"style9 style15\">");
      out.print(message);
      out.write("\r\n");
      out.write("                                    <label></label>\r\n");
      out.write("                                    <label>                  </label>\r\n");
      out.write("                                    <label></label>\r\n");
      out.write("                                </td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td width=\"198\" class=\"style9\">&nbsp;</td>\r\n");
      out.write("                                <td colspan=\"5\" align=\"right\" class=\"style12\">\r\n");
      out.write("                                    ");

                                     LinkedHashMap map = ExamDAO.loadCombo();
                                             out.print("<select name='comboLoad'>");
                                             if (map.isEmpty()) {
                                                 out.print("<OPTION value='0'>==No  Record==</OPTION>");
                                             } else {
                                                 out.print("<OPTION value='0'>=== Select Record ===</OPTION>");
                                                 Set keys = map.keySet();
                                                 Iterator itr = keys.iterator();
                                                 for (int i = 0; i < keys.size(); i++) {
                                                     String selectedId = itr.next().toString();
                                                     String Name = map.get(selectedId).toString();
                                                     out.print("<OPTION value='" + selectedId + "'");

                                                     
                                                     out.println(">" + Name + "</OPTION>");

                                                 }

                                             }
                                             out.println("</select>");
                                    
      out.write("\r\n");
      out.write("                                    <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Load Record\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("                                <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textExamId\" type=\"hidden\" id=\"textExamId\" size=\"40\" maxlength=\"90\" value=\"");
      out.print(examId);
      out.write("\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">Exam Name : </td>\r\n");
      out.write("                                <td colspan=\"5\" valign=\"top\" class=\"style12\"><label>\r\n");
      out.write("                                        <input name=\"textExamName\" type=\"text\" id=\"textExamName\" size=\"40\" maxlength=\"90\" value=\"");
      out.print(examName);
      out.write("\">\r\n");
      out.write("                                    </label></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">Number of Questions : </td>\r\n");
      out.write("                                <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textQuestion\" value=\"");
      out.print(examQuestion);
      out.write("\" type=\"text\" id=\"textQuestion\" size=\"20\" maxlength=\"3\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">Pass Mark : </td>\r\n");
      out.write("                                <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textPassMark\" value=\"");
      out.print(passMark);
      out.write("\" type=\"text\" id=\"textPassMark\" size=\"20\" maxlength=\"2\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                               <tr>\r\n");
      out.write("         <td align=\"right\" class=\"style12\">Session : </td>\r\n");
      out.write("        <td colspan=\"5\" valign=\"top\" class=\"style12\">");

                  LinkedHashMap smap = SessionDAO.loadCombo();
              out.print("<select name='comboSessionId'>");
              if (smap.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Session ===</OPTION>");
                    Set keys = smap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = smap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");
                        if(sessionId.equals(selectedId)){

                        out.print("Selected='true'");

                        }
                        out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("\r\n");
      out.write("        </label></td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">Class :  </td>\r\n");
      out.write("                                <td colspan=\"5\" valign=\"top\" class=\"style12\">\r\n");
      out.write("                                    ");

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

                                                     if (classId.equals(selectedId)) {
                                                         out.print("Selected='true'");
                                                     }
                                                     out.println(">" + Name + "</OPTION>");

                                                 }

                                             }
                                             out.println("</select>");
                                    
      out.write("          </td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">Subject : </td>\r\n");
      out.write("                                <td colspan=\"5\" valign=\"top\" class=\"style12\">");

                                  dmap = SubjectDAO.loadCombo();
                                  out.print("<select name='comboSubjectId'>");
                                  if (dmap.isEmpty()) {
                                      out.print("<OPTION value='0'>==No  Record==</OPTION>");
                                  } else {
                                      out.print("<OPTION value='0'>=== Select Subject ===</OPTION>");
                                      Set keys = dmap.keySet();
                                      Iterator itr = keys.iterator();
                                      for (int i = 0; i < keys.size(); i++) {
                                          String selectedId = itr.next().toString();
                                          String Name = dmap.get(selectedId).toString();
                                          out.print("<OPTION value='" + selectedId + "'");

                                          if (subjectId.equals(selectedId)) {
                                              out.print("Selected='true'");
                                          }
                                          out.println(">" + Name + "</OPTION>");

                                      }

                                  }
                                  out.println("</select>");
                                    
      out.write("</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">Term : </td>\r\n");
      out.write("                                <td colspan=\"5\" valign=\"top\" class=\"style12\"><label>\r\n");
      out.write("                                        <select name=\"comboTermId\" id=\"comboTermId\">\r\n");
      out.write("                                            <option>=== Select Term ===</option>\r\n");
      out.write("                                            <option value=\"Term01\" ");
if (termId.equals("Term01")) {out.print("Selected='true'");
            }
      out.write(">First Term</option>\r\n");
      out.write("                                            <option value=\"Term02\" ");
if (termId.equals("Term02")) {out.print("Selected='true'");
            }
      out.write(">Second Term</option>\r\n");
      out.write("                                            <option value=\"Term03\" ");
if (termId.equals("Term03")) {out.print("Selected='true'");
            }
      out.write(">Third Term</option>\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                    </label></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("                                <td colspan=\"5\" valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td align=\"right\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("                                <td colspan=\"3\" valign=\"top\" class=\"style12\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Record\" onClick=\"return validateExam(form1)\"></td>\r\n");
      out.write("                                <td width=\"133\" valign=\"top\" class=\"style12\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Update Record\" onClick=\"return validateExam(form1)\"></td>\r\n");
      out.write("                                <td width=\"206\" valign=\"top\" class=\"style12\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Delete Record\" onClick=\"return validateExam(form1)\"></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
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
