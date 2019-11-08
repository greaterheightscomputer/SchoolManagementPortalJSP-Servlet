package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Vector;
import gtr.DAO.StaffDAO;;

public final class add_005fstaff_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"javascript/school.js\">\r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");

    String staffId = (String)request.getAttribute("staffId");
    if(staffId == null){
        staffId = "";
    }
    String surname = (String)request.getAttribute("surname");
    if(surname == null){
        surname = "";
    }
    String firstName = (String)request.getAttribute("firstName");
    if(firstName == null){
        firstName = "";
    }
    String gender = (String)request.getAttribute("gender");
    if(gender == null){
        gender = "";
    }
    String dob = (String)request.getAttribute("dob");
    if(dob == null){
        dob = "";
    }
    String address = (String)request.getAttribute("address");
    if(address == null){
        address = "";
    }
    String phone = (String)request.getAttribute("phone");
    if(phone == null){
        phone = "";
    }
    String email = (String)request.getAttribute("email");
    if(email == null){
        email = "";
    }
    String qualification = (String)request.getAttribute("qualification");
    if(qualification == null){
        qualification = "";
    }
    String category = (String)request.getAttribute("category");
    if(category == null){
        category = "";
    }
    String employmentDate = (String)request.getAttribute("employmentDate");
    if(employmentDate == null){
        employmentDate = "";
    }
    String salary = (String)request.getAttribute("salary");
    if(salary == null){
        salary = "";
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
      out.write("    <form id=\"form1\" method=\"post\" action=\"gtr?a=Staff\" name=\"form1\">\r\n");
      out.write("  <table width=\"731\" height=\"235\" cellpadding=\"10\" class=\"style5\">\r\n");
      out.write("    <tr>\r\n");
      out.write("\t<td valign=\"top\"><table width=\"595\" border=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("          <td colspan=\"4\"><span class=\"style12\">");
      out.print(message);
      out.write("</span></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\" align=\"right\"><label>\r\n");
      out.write("          ");

              LinkedHashMap map = StaffDAO.loadCombo();
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
      out.write("        <td width=\"181\">&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\">Staff Id : </td>\r\n");
      out.write("        <td colspan=\"3\"><label>\r\n");
      out.write("                <input name=\"textStaffId\" type=\"text\" id=\"textStaffId\" size=\"40\" maxlength=\"20\" value=\"");
      out.print(staffId);
      out.write("\">\r\n");
      out.write("        </label></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Surname  : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textSurname\" type=\"text\" id=\"textSurname\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(surname);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">First Name : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textFirstName\" type=\"text\" id=\"textFirstName\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(firstName);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Gender : </td>\r\n");
      out.write("        <td colspan=\"3\"><label>\r\n");
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
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Date of Birth : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textDOB\" type=\"text\" id=\"textDOB\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(dob);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Address : </td>\r\n");
      out.write("        <td colspan=\"3\"><textarea name=\"textAddress\" cols=\"32\" rows=\"4\" id=\"textAddress\">");
      out.print(address);
      out.write("</textarea></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Phone Number : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textPhone\" type=\"text\" id=\"textPhone\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(phone);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Email Address : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textEmail\" type=\"text\" id=\"textEmail\" size=\"40\" maxlength=\"200\" value=\"");
      out.print(email);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Qualification : </td>\r\n");
      out.write("        <td colspan=\"3\"><select name=\"comboQualification\" id=\"comboQualification\">\r\n");
      out.write("          <option>=== Select Qualification ===</option>\r\n");
      out.write("          <option ");
if(qualification.equals("PhD")){out.println(" Selected='true'");}
      out.write(">PhD</option>\r\n");
      out.write("          <option ");
if(qualification.equals("Masters")){out.println(" Selected='true'");}
      out.write(">Masters</option>\r\n");
      out.write("          <option ");
if(qualification.equals("BSc")){out.println(" Selected='true'");}
      out.write(">BSc</option>\r\n");
      out.write("          <option ");
if(qualification.equals("HND")){out.println(" Selected='true'");}
      out.write(">HND</option>\r\n");
      out.write("          <option ");
if(qualification.equals("ND")){out.println(" Selected='true'");}
      out.write(">ND</option>\r\n");
      out.write("          <option ");
if(qualification.equals("WAEC")){out.println(" Selected='true'");}
      out.write(">WAEC</option>\r\n");
      out.write("          <option ");
if(qualification.equals("School Leaving")){out.println(" Selected='true'");}
      out.write(">School Leaving</option>\r\n");
      out.write("          <option ");
if(qualification.equals("None")){out.println(" Selected='true'");}
      out.write(">None</option>\r\n");
      out.write("                </select></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Employee Type : </td>\r\n");
      out.write("        <td colspan=\"3\"><select name=\"comboCategory\" id=\"comboCategory\">\r\n");
      out.write("          <option>=== Select Type ===</option>\r\n");
      out.write("          <option ");
if(category.equals("Teaching Staff")){out.println(" Selected='true'");}
      out.write(">Teaching Staff</option>\r\n");
      out.write("          <option ");
if(qualification.equals("Non-Teaching Staff")){out.println(" Selected='true'");}
      out.write(">Non-Teaching Staff</option>\r\n");
      out.write("                        </select></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Employment Date :  </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textEmploymentDate\" type=\"text\" id=\"textEmploymentDate\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(employmentDate);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td align=\"right\" valign=\"top\">Salary : </td>\r\n");
      out.write("        <td colspan=\"3\"><input name=\"textSalary\" type=\"text\" id=\"textSalary\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(salary);
      out.write("\"></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td colspan=\"3\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td width=\"85\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Record\" onClick=\"return validateStaff(form1)\"></td>\r\n");
      out.write("        <td width=\"156\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Update Record\" onClick=\"return validateStaff(form1)\"></td>\r\n");
      out.write("        <td width=\"155\"><label>\r\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Delete Record\" onClick=\"return validateStaff(form1)\">\r\n");
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
