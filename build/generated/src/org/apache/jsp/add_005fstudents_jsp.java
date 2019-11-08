package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Vector;
import gtr.DAO.StudentsDAO;
import gtr.DAO.SessionDAO;
import gtr.DAO.ClassDAO;
import gtr.DAO.StaffDAO;
import autoId.StudentId;
import gtr.DAO.SchoolBillDAO;;

public final class add_005fstudents_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"javascript/school.js\">\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("  \r\n");

    String studentId = (String)request.getAttribute("studentId");
    if(studentId == null){
        studentId = StudentId.getId();
    }
    String firstName = (String)request.getAttribute("firstName");
    if(firstName == null){
        firstName = "";
    }
    String lastName = (String)request.getAttribute("lastName");
    if(lastName == null){
        lastName = "";
    }
    String otherNames = (String)request.getAttribute("otherNames");
    if(otherNames == null){
        otherNames = "";
    }
    String gender = (String)request.getAttribute("gender");
    if(gender == null){
        gender = "";
    }
    String dateOfBirth = (String)request.getAttribute("dateOfBirth");
    if(dateOfBirth == null){
        dateOfBirth = "";
    }
    String admissionDate = (String)request.getAttribute("admissionDate");
    if(admissionDate == null){
        admissionDate = "";
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
    String address = (String)request.getAttribute("address");
    if(address == null){
        address = "";
    }
    String parentName = (String)request.getAttribute("parentName");
    if(parentName == null){
        parentName = "";
    }
    String occupation = (String)request.getAttribute("occupation");
    if(occupation == null){
        occupation = "";
    }
    String phoneNumber = (String)request.getAttribute("phoneNumber");
    if(phoneNumber == null){
        phoneNumber = "";
    }
    String mobileNumber = (String)request.getAttribute("mobileNumber");
    if(mobileNumber == null){
        mobileNumber = "";
    }
    String staffId = (String)request.getAttribute("staffId");
    if(staffId == null){
        staffId = "";
    }    
    String image = (String)request.getAttribute("image");
    if(image == null){
        image = "";
    }
    String billId = (String)request.getAttribute("billId");
    if(billId == null){
        billId = "";
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
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <form id=\"form1\" method=\"post\" action=\"gtr?a=Students\" name=\"form1\">\r\n");
      out.write("  <table width=\"816\" height=\"235\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("\t<td valign=\"top\"><table width=\"728\" border=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("          <td colspan=\"4\"><span class=\"style12\">");
      out.print(message);
      out.write("</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\" align=\"right\"><label>\r\n");
      out.write("          ");

              LinkedHashMap map = StudentsDAO.loadCombo();
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
      out.write("        </label>\r\n");
      out.write("          <label>\r\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Load Record\">\r\n");
      out.write("          </label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"217\">&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\">Student Id : </td>\r\n");
      out.write("        <td colspan=\"2\"><label>\r\n");
      out.write("                <input name=\"textStudentId\" type=\"text\" id=\"textStudentId\" size=\"40\" maxlength=\"20\" value=\"");
      out.print(studentId);
      out.write("\">\r\n");
      out.write("        </label></td>\r\n");
      out.write("        <td rowspan=\"6\" valign=\"top\"><img src=\"pictures/");
      out.print(image);
      out.write("\" width=\"160\" height=\"180\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">First Name   : </td>\r\n");
      out.write("        <td colspan=\"2\"><input name=\"textFirstName\" type=\"text\" id=\"textFirstName\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(firstName);
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Last Name : </td>\r\n");
      out.write("        <td colspan=\"2\"><input name=\"textLastName\" type=\"text\" id=\"textLastName\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(lastName);
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Other Names : </td>\r\n");
      out.write("        <td colspan=\"2\"><input name=\"textOtherNames\" type=\"text\" id=\"textOtherNames\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(otherNames);
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Gender : </td>\r\n");
      out.write("        <td colspan=\"2\"><label>\r\n");
      out.write("          <select name=\"comboGender\" id=\"comboGender\">\r\n");
      out.write("            <option>=== Select Gender ===</option>\r\n");
      out.write("            <option ");
if(gender.equals("Male")){out.println(" Selected='true'");}
      out.write(">Male</option>\r\n");
      out.write("            <option ");
if(gender.equals("Female")){out.println(" Selected='true'");}
      out.write(">Female</option>\r\n");
      out.write("          </select>\r\n");
      out.write("        </label></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Date of Birth : </td>\r\n");
      out.write("        <td colspan=\"2\"><input name=\"textdateOfBirth\" type=\"text\" id=\"textdateOfBirth\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(dateOfBirth);
      out.write("\"></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Admission Date : </td>\r\n");
      out.write("        <td colspan=\"2\"><input name=\"textAdmissionDate\" type=\"text\" id=\"textAdmissionDate\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(admissionDate);
      out.write("\"></td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Session : </td>\r\n");
      out.write("        <td colspan=\"2\"><label>\r\n");
      out.write("          ");

              LinkedHashMap dmap = SessionDAO.loadCombo();
              out.print("<select name='comboSessionId'>");
              if (dmap.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Session ===</OPTION>");
                    Set keys = dmap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = dmap.get(selectedId).toString();
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
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Class : </td>\r\n");
      out.write("        <td colspan=\"2\"><label>\r\n");
      out.write("          ");

              map = ClassDAO.loadCombo();
              out.print("<select name='comboClassId'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Class ===</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");
                        if(classId.equals(selectedId)){

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
      out.write("     <tr>\r\n");
      out.write("          <td align=\"right\" >Term : </td>\r\n");
      out.write("          <td colspan=\"3\" valign=\"top\" ><label>\r\n");
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
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Address : </td>\r\n");
      out.write("        <td colspan=\"3\"><textarea name=\"textAddress\" cols=\"32\" rows=\"4\" id=\"textAddress\">");
      out.print(address);
      out.write("</textarea></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Parent/Guadian Name : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textParentName\" type=\"text\" id=\"textParentName\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(parentName);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Occupation : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textOccupation\" type=\"text\" id=\"textOccupation\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(occupation);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Phone Number : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textphoneNumber\" type=\"text\" id=\"textphoneNumber\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(phoneNumber);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Mobile Number : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textmobileNumber\" type=\"text\" id=\"textmobileNumber\" size=\"40\" maxlength=\"200\" value=\"");
      out.print(mobileNumber);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Staff : </td>\r\n");
      out.write("        <td colspan=\"3\">\r\n");
      out.write("           ");

              map = StaffDAO.loadCombo();
              out.print("<select name='comboStaffId'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>==Select Staff==</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();                        
                        out.print("<OPTION value='" + selectedId + "'");
                        if(staffId.equals(selectedId)){
                            
                        out.print("Selected='true'");
                        
                        }
                        out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Bill : </td>\r\n");
      out.write("        <td colspan=\"3\">\r\n");
      out.write("           ");

              map = SchoolBillDAO.loadCombo();
              out.print("<select name='comboBillId'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>==Select Bill==</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");
                        if(billId.equals(selectedId)){

                        out.print("Selected='true'");

                        }
                        out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");

      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("       \r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td width=\"146\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Record\" onClick=\"return validateStudent(form1)\"></td>\r\n");
      out.write("        <td width=\"214\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Update Record\" onClick=\"return validateStudent(form1)\"></td>\r\n");
      out.write("        <td width=\"133\"><label>\r\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Delete Record\" onClick=\"return validateStudent(form1)\">\r\n");
      out.write("        </label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("\t</tr>\r\n");
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
