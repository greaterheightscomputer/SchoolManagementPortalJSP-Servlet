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
import gtr.DAO.StudentsDAO;
import gtr.DAO.ClassDAO;
import gtr.DAO.SchoolBillDAO;

public final class add_005fschoolbill_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");


    String billId = (String)request.getAttribute("billId");
    if(billId == null){
        billId = "";
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
    String termId = (String)request.getAttribute("termId");
    if(termId == null){
        termId = "";
    }
    String accountname = (String)request.getAttribute("accountname");
    if(accountname == null){
        accountname = "";
    }
    String accountno = (String)request.getAttribute("accountno");
    if(accountno == null){
        accountno = "";
    }
    String previousbalance = (String)request.getAttribute("previousbalance");
    if(previousbalance == null){
        previousbalance = "";
    }
    String schoolfees = (String)request.getAttribute("schoolfees");
    if(schoolfees == null){
        schoolfees = "";
    }
    String uniform = (String)request.getAttribute("uniform");
    if(uniform == null){
        uniform = "";
    }
    String sportlevy = (String)request.getAttribute("sportlevy");
    if(sportlevy == null){
        sportlevy = "";
    }
    String registration = (String)request.getAttribute("registration");
    if(registration == null){
        registration = "";
    }
    String examlevy = (String)request.getAttribute("examlevy");
    if(examlevy == null){
        examlevy = "";
    }
    String pta = (String)request.getAttribute("pta");
    if(pta == null){
        pta = "";
    }
    String computerlevy = (String)request.getAttribute("computerlevy");
    if(computerlevy == null){
        computerlevy = "";
    }
    String textbook = (String)request.getAttribute("textbook");
    if(textbook == null){
        textbook = "";
    }
    String notebook = (String)request.getAttribute("notebook");
    if(notebook == null){
        notebook = "";
    }
    String transport = (String)request.getAttribute("transport");
    if(transport == null){
        transport = "";
    }
    String lessonfees = (String)request.getAttribute("lessonfees");
    if(lessonfees == null){
        lessonfees = "";
    }
    String endofyearparty = (String)request.getAttribute("endofyearparty");
    if(endofyearparty == null){
        endofyearparty = "";
    }
    String graduationfees = (String)request.getAttribute("graduationfees");
    if(graduationfees == null){
        graduationfees = "";
    }
    String total = (String)request.getAttribute("total");
    if(total == null){
        total = "";
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
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"javascript/school.js\">\n");
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
      out.write("    <form id=\"form1\" name=\"form1\" method=\"post\" action=\"gtr?a=SchBill\">\n");
      out.write("  <table width=\"707\" cellpadding=\"10\" class=\"style5\">\n");
      out.write("    <tr>\n");
      out.write("      <td width=\"689\"><table width=\"668\" border=\"0\">\n");
      out.write("        <tr>\n");
      out.write("            <td colspan=\"6\" class=\"style9 style15\">");
      out.print(message);
      out.write("\n");
      out.write("                  <label></label>\n");
      out.write("              <label>                  </label>\n");
      out.write("              <label></label>            </td>\n");
      out.write("          </tr>\n");
      out.write("      \n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\"></td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textBillId\" type=\"hidden\" id=\"textBillId\" size=\"40\" maxlength=\"90\" value=\"");
      out.print(billId);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Student Id : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><label>\n");
      out.write("                  <input name=\"textStudentId\" type=\"text\" id=\"textStudentId\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(studentId);
      out.write("\">\n");
      out.write("          </label></td>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Session :  </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">\n");
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

      out.write("          </td>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Class :  </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">\n");
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

      out.write("          </td>\n");
      out.write("        </tr>\n");
      out.write("                <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Term : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><label>\n");
      out.write("            <select name=\"comboTermId\" id=\"comboTermId\">\n");
      out.write("              <option>=== Select Term ===</option>\n");
      out.write("              <option value=\"Term01\" ");
if(termId.equals("Term01")){out.print("Selected='true'");}
      out.write(">First Term</option>\n");
      out.write("              <option value=\"Term02\" ");
if(termId.equals("Term02")){out.print("Selected='true'");}
      out.write(">Second Term</option>\n");
      out.write("              <option value=\"Term03\" ");
if(termId.equals("Term03")){out.print("Selected='true'");}
      out.write(">Third Term</option>\n");
      out.write("            </select>\n");
      out.write("          </label></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Account Name : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textAccountName\" type=\"text\" id=\"textAccountName\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(accountname);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Account N0 : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textAccountNo\" type=\"text\" id=\"textAccountNo\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(accountno);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Previous Balance : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textPreviousBal\" type=\"text\" id=\"textPreviousBal\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(previousbalance);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">School Fees : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textSchoolFee\" type=\"text\" id=\"textSchoolFee\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(schoolfees);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Uniform : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textUniform\" type=\"text\" id=\"textUniform\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(uniform);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Sport Levy : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textSportLevy\" type=\"text\" id=\"textSportLevy\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(sportlevy);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Registration : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textRegistration\" type=\"text\" id=\"textRegistration\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(registration);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Exam Levy : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textExamLevy\" type=\"text\" id=\"textExamLevy\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(examlevy);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">PTA : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textPTA\" type=\"text\" id=\"textPTA\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(pta);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Computer Levy : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textComputerlevy\" type=\"text\" id=\"textComputerlevy\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(computerlevy);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Text Book : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textTextbook\" type=\"text\" id=\"textTextbook\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(textbook);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Note Book : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textNoteBook\" type=\"text\" id=\"textNoteBook\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(notebook);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Transporte Fees : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textTransport\" type=\"text\" id=\"textTransport\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(transport);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Lesson Fees : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textLessonFees\" type=\"text\" id=\"textLessonFees\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(lessonfees);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">End of Year Party : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textEndyear\" type=\"text\" id=\"textEndyear\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(endofyearparty);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Graduation Fees : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textGraduateFees\" type=\"text\" id=\"textGraduateFees\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(graduationfees);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">Total : </td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\"><input name=\"textTotal\" type=\"text\" id=\"textTotal\" size=\"30\" maxlength=\"90\" value=\"");
      out.print(total);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <td align=\"right\" class=\"style12\">&nbsp;</td>\n");
      out.write("          <td colspan=\"5\" valign=\"top\" class=\"style12\">&nbsp;</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("           <td>&nbsp;</td>\n");
      out.write("        <td width=\"146\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Record\" onClick=\"return validateAssessment(form1)\"></td>\n");
      out.write("         <td width=\"133\"><label>           \n");
      out.write("        </label></td>\n");
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
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
