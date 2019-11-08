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
import gtr.DAO.AssessmentDAO;
import gtr.DAO.SubjectDAO;
import gtr.DAO.ExamDAO;
import gtr.DAO.CtimeDAO;
import gtr.DAO.DevelopmentDAO;
import gtr.DAO.SportDAO;
import gtr.DAO.CertificateDAO;

public final class assessment_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    
    String assessmentId = (String)request.getAttribute("assessmentId");
    if(assessmentId == null){
        assessmentId = "";
    }
    String studentId = (String)request.getAttribute("studentId");
    if(studentId == null){
        studentId = "";
    }
    String sessionId = (String)request.getAttribute("sessionId");
    if(sessionId == null){
        sessionId = "";
    }
    String classId = (String)request.getAttribute("classId");
    if(classId == null){
        classId = "";
    }
    String subjectId = (String)request.getAttribute("subjectId");
    if(subjectId == null){
        subjectId = "";
    }
    String termId = (String)request.getAttribute("termId");
    if(termId == null){
        termId = "";
    }
    String test1 = (String)request.getAttribute("test1");
    if(test1 == null){
        test1 = "";
    }
    String test2 = (String)request.getAttribute("test2");
    if(test2 == null){
        test2 = "";
    }
    String exam = (String)request.getAttribute("exam");
    if(exam == null){
        exam = "";
    }
    String developmentId = (String)request.getAttribute("developmentId");
    if(developmentId == null){
        developmentId = "";
    }
    String sportId = (String)request.getAttribute("sportId");
    if(sportId == null){
        sportId = "";
    }
    String ctimeId = (String)request.getAttribute("ctimeId");
    if(ctimeId == null){
        ctimeId = "";
    }
    String certificateId = (String)request.getAttribute("certificateId");
    if(certificateId == null){
        certificateId = "";
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
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"javascript/school.js\">\r\n");
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
      out.write("    <form id=\"form1\" name=\"form1\" method=\"post\" action=\"gtr?a=Assessment\">\r\n");
      out.write("  <table width=\"707\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("      <td width=\"689\"><table width=\"668\" border=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td colspan=\"6\" class=\"style9 style15\">");
      out.print(message);
      out.write("\r\n");
      out.write("                  <label></label>\r\n");
      out.write("              <label>                  </label>\r\n");
      out.write("              <label></label>            </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td width=\"198\" class=\"style9\">&nbsp;</td>\r\n");
      out.write("          <td colspan=\"5\" align=\"right\" class=\"style12\">\r\n");
      out.write("              ");

              LinkedHashMap map = AssessmentDAO.loadCombo();
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
      out.write("<input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Load Record\" onClick=\"return addData(form1)\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\"></td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textAssessmentId\" type=\"hidden\" id=\"textAssessmentId\" size=\"40\" maxlength=\"90\" value=\"");
      out.print(assessmentId);
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Student Id : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><label>\r\n");
      out.write("                  <input name=\"textStudentId\" type=\"text\" id=\"textStudentId\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(studentId);
      out.write("\">\r\n");
      out.write("          </label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("       <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Session :  </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">\r\n");
      out.write("   ");

              LinkedHashMap smap = SessionDAO.loadCombo();
              out.print("<select name='comboSessionId'>");
              if (smap.isEmpty()) {
                out.print("<OPTION value='0'>==No  Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Session ===</OPTION>");
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

      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Class :  </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">\r\n");
      out.write("   ");

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

      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Subject : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">");

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

                        if(subjectId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");

                    }

                }
              out.println("</select>");

      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Term : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><label>\r\n");
      out.write("            <select name=\"comboTermId\" id=\"comboTermId\">\r\n");
      out.write("              <option>=== Select Term ===</option>\r\n");
      out.write("              <option value=\"Term01\" ");
if(termId.equals("Term01")){out.print("Selected='true'");}
      out.write(">First Term</option>\r\n");
      out.write("              <option value=\"Term02\" ");
if(termId.equals("Term02")){out.print("Selected='true'");}
      out.write(">Second Term</option>\r\n");
      out.write("              <option value=\"Term03\" ");
if(termId.equals("Term03")){out.print("Selected='true'");}
      out.write(">Third Term</option>\r\n");
      out.write("            </select>\r\n");
      out.write("          </label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Test 1 Score : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textTest1\" type=\"text\" id=\"textTest1\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(test1);
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Test 2 Score : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textTest2\" type=\"text\" id=\"textTest2\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(test2);
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Exam Score : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textExam\" type=\"text\" id=\"textExam\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(exam);
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Development : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">");

              dmap = DevelopmentDAO.loadCombo();
              out.print("<select name='comboDevelopmentId'>");
              if (dmap.isEmpty()) {
                out.print("<OPTION value='0'>==No  Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Development Id ===</OPTION>");
                    Set keys = dmap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = dmap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(developmentId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Sport : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">");

              dmap = SportDAO.loadCombo();
              out.print("<select name='comboSportId'>");
              if (dmap.isEmpty()) {
                out.print("<OPTION value='0'>==No  Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Sport Id ===</OPTION>");
                    Set keys = dmap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = dmap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(sportId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Ctime : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">");

              dmap = CtimeDAO.loadCombo();
              out.print("<select name='comboCtimeId'>");
              if (dmap.isEmpty()) {
                out.print("<OPTION value='0'>==No  Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Ctime Id ===</OPTION>");
                    Set keys = dmap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = dmap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(ctimeId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("          <td align=\"right\" class=\"style12\">Certificate : </td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">");

              dmap = CertificateDAO.loadCombo();
              out.print("<select name='comboCertificateId'>");
              if (dmap.isEmpty()) {
                out.print("<OPTION value='0'>==No  Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Cert Id ===</OPTION>");
                    Set keys = dmap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = dmap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(certificateId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("                          \r\n");
      out.write("        <tr>\r\n");
      out.write("        \r\n");
      out.write("          <td align=\"right\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("           <td>&nbsp;</td>\r\n");
      out.write("        <td width=\"146\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Test 1\" onClick=\"return validateAssessment(form1)\"></td>\r\n");
      out.write("        <td width=\"214\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Test 2\" onClick=\"return validateAssessment(form1)\"></td>\r\n");
      out.write("        <td width=\"133\"><label>\r\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Delete Record\" onClick=\"return validateAssessment(form1)\">\r\n");
      out.write("        </label></td>\r\n");
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
