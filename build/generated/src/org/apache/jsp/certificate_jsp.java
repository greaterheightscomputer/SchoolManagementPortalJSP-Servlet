package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Vector;
import gtr.DAO.CertificateDAO;;

public final class certificate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("﻿\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"javascript/school.js\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\t   \n");
      out.write("\t   \n");

    String certificateId = (String)request.getAttribute("certificateId");
    if(certificateId == null){
        certificateId = "";
    }
    String studentId = (String)request.getAttribute("studentId");
    if(studentId == null){
        studentId = "";
    }
    String dateofAdmission = (String)request.getAttribute("dateofAdmission");
    if(dateofAdmission == null){
        dateofAdmission = "";
    }
    String classonAdmission = (String)request.getAttribute("classonAdmission");
    if(classonAdmission == null){
        classonAdmission = "";
    }
    String dateofLeaving = (String)request.getAttribute("dateofLeaving");
    if(dateofLeaving == null){
        dateofLeaving = "";
    }
    String classonLeaving = (String)request.getAttribute("classonLeaving");
    if(classonLeaving == null){
        classonLeaving = "";
    }
    String reasonforLeaving = (String)request.getAttribute("reasonforLeaving");
    if(reasonforLeaving == null){
        reasonforLeaving = "";
    }
    String award  = (String)request.getAttribute("award");
    if(award == null){
        award = "";
    }
    String grade  = (String)request.getAttribute("grade");
    if(grade == null){
        grade = "";
    }
    String subject1  = (String)request.getAttribute("subject1");
    if(subject1 == null){
        subject1 = "";
    }
    String subject2  = (String)request.getAttribute("subject2");
    if(subject2 == null){
        subject2 = "";
    }
    String subject3  = (String)request.getAttribute("subject3");
    if(subject3 == null){
        subject3 = "";
    }
    String subject4  = (String)request.getAttribute("subject4");
    if(subject4 == null){
        subject4 = "";
    }
    String subject5  = (String)request.getAttribute("subject5");
    if(subject5 == null){
        subject5 = "";
    }
    String subject6  = (String)request.getAttribute("subject6");
    if(subject6 == null){
        subject6 = "";
    }
    String subject7  = (String)request.getAttribute("subject7");
    if(subject7 == null){
        subject7 = "";
    }
    String subject8  = (String)request.getAttribute("subject8");
    if(subject8 == null){
        subject8 = "";
    }
    String image = (String)request.getAttribute("image");
    if(image == null){
        image = "";
    }
    String date = (String)request.getAttribute("date");
    if(date == null){
        date = "";
    }

    String message = (String)request.getAttribute("msg");
    if(message == null){
        message = "";
    }



      out.write("\n");
      out.write("\n");
      out.write("<meta content=\"en-us\" http-equiv=\"Content-Language\" />\n");
      out.write("<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/smweb.css\"/>\n");
      out.write("<title>S-Portal</title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".style5 {\n");
      out.write("\tborder-style:inset;\n");
      out.write("}\n");
      out.write(".style12 {\n");
      out.write("\tfont-size: 12px;\n");
      out.write("\tcolor: #660000;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <form id=\"form1\" method=\"post\" action=\"gtr?a=Certificate\" name=\"form1\">\n");
      out.write("  <table width=\"816\" height=\"235\" cellpadding=\"10\" class=\"style5\">\n");
      out.write("    <tr>\n");
      out.write("\t<td valign=\"top\"><table width=\"728\" border=\"0\">\n");
      out.write("      <tr>\n");
      out.write("          <td colspan=\"4\"><span class=\"style12\">");
      out.print(message);
      out.write("</span></td>\n");
      out.write("        </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td>&nbsp;</td>\n");
      out.write("        <td colspan=\"3\" align=\"right\"><label>\n");
      out.write("          ");

              LinkedHashMap map = CertificateDAO.loadCombo();
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

      out.write("\n");
      out.write("        </label>\n");
      out.write("          <label>\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Load Record\">\n");
      out.write("          </label></td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td width=\"217\">&nbsp;</td>\n");
      out.write("        <td colspan=\"3\">&nbsp;</td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td align=\"right\">Certificate Id:</td>\n");
      out.write("        <td colspan=\"2\"><label>\n");
      out.write("                <input name=\"textCertificateId\" type=\"text\" id=\"textCertificateId\" size=\"40\" maxlength=\"20\" value=\"");
      out.print(certificateId);
      out.write("\">\n");
      out.write("        </label></td>\n");
      out.write("        <td rowspan=\"6\" valign=\"top\"><img src=\"pictures/");
      out.print(image);
      out.write("\" width=\"90\" height=\"100\"></td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Student Id   : </td>\n");
      out.write("        <td colspan=\"2\"><input name=\"textStudentId\" type=\"text\" id=\"textStudentId\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(studentId);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("      <tr>       \n");
      out.write("        <td align=\"right\" valign=\"top\">Date of Admission : </td>\n");
      out.write("        <td colspan=\"2\"><input name=\"textDateofAdmission\" type=\"text\" id=\"textDateofAdmission\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(dateofAdmission);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Class on Admission : </td>\n");
      out.write("        <td colspan=\"2\"><input name=\"textClassonAdmission\" type=\"text\" id=\"textClassonAdmission\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(classonAdmission);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Date of Leaving : </td>\n");
      out.write("        <td colspan=\"2\"><input name=\"textDateofLeaving\" type=\"text\" id=\"textDateofLeaving\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(dateofLeaving);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Class on Leaving : </td>\n");
      out.write("        <td colspan=\"2\"><input name=\"textClassonLeaving\" type=\"text\" id=\"textClassonLeaving\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(classonLeaving);
      out.write("\"></td>\n");
      out.write("        <td>&nbsp;</td>\n");
      out.write("      </tr>               \n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Reason for Leaving : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textReasonforLeaving\" type=\"text\" id=\"textReasonforLeaving\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(reasonforLeaving);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Award  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textAward\" type=\"text\" id=\"textAward\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(award);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Grade  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textGrade\" type=\"text\" id=\"textGrade\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(grade);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Subject1  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubject1\" type=\"text\" id=\"textSubject1\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(subject1);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Subject2  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubject2\" type=\"text\" id=\"textSubject2\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(subject2);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Subject3  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubject3\" type=\"text\" id=\"textSubject3\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(subject3);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Subject4  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubject4\" type=\"text\" id=\"textSubject4\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(subject4);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Subject5  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubject5\" type=\"text\" id=\"textSubject5\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(subject5);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Subject6  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubject6\" type=\"text\" id=\"textSubject6\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(subject6);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">subject7  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubject7\" type=\"text\" id=\"textSubject7\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(subject7);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Subject8  : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textSubject8\" type=\"text\" id=\"textSubject8\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(subject8);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("       <tr>\n");
      out.write("        <td align=\"right\" valign=\"top\">Date : </td>\n");
      out.write("        <td colspan=\"3\"><input name=\"textDate\" type=\"text\" id=\"textDate\" size=\"40\" maxlength=\"100\" value=\"");
      out.print(date);
      out.write("\"></td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td>&nbsp;</td>\n");
      out.write("        <td colspan=\"3\">&nbsp;</td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td>&nbsp;</td>\n");
      out.write("        <td width=\"146\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Add Record\" onClick=\"return validateStudent(form1)\"></td>\n");
      out.write("        <td width=\"214\"><input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Update Record\" onClick=\"return validateStudent(form1)\"></td>\n");
      out.write("        <td width=\"133\"><label>\n");
      out.write("          <input name=\"buttonSubmit\" type=\"submit\" id=\"buttonSubmit\" value=\"Delete Record\" onClick=\"return validateStudent(form1)\">\n");
      out.write("        </label></td>\n");
      out.write("      </tr>\n");
      out.write("    </table></td>\n");
      out.write("\t</tr>\n");
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
