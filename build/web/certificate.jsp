<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.CertificateDAO;" %>﻿
<html>



<head>

    <script language="javascript" type="text/javascript" src="javascript/school.js">


    </script>
	   
	   
<%
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


%>

<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href="css/smweb.css"/>
<title>S-Portal</title>
<style type="text/css">
.style5 {
	border-style:inset;
}
.style12 {
	font-size: 12px;
	color: #660000;
}
</style>



</head>

<body>
    <form id="form1" method="post" action="gtr?a=Certificate" name="form1">
  <table width="816" height="235" cellpadding="10" class="style5">
    <tr>
	<td valign="top"><table width="728" border="0">
      <tr>
          <td colspan="4"><span class="style12"><%=message%></span></td>
        </tr>
      <tr>
        <td>&nbsp;</td>
        <td colspan="3" align="right"><label>
          <%
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
%>
        </label>
          <label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Load Record">
          </label></td>
      </tr>
      <tr>
        <td width="217">&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">Certificate Id:</td>
        <td colspan="2"><label>
                <input name="textCertificateId" type="text" id="textCertificateId" size="40" maxlength="20" value="<%=certificateId%>">
        </label></td>
        <td rowspan="6" valign="top"><img src="pictures/<%=image%>" width="90" height="100"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Student Id   : </td>
        <td colspan="2"><input name="textStudentId" type="text" id="textStudentId" size="40" maxlength="100" value="<%=studentId%>"></td>
        </tr>
      <tr>       
        <td align="right" valign="top">Date of Admission : </td>
        <td colspan="2"><input name="textDateofAdmission" type="text" id="textDateofAdmission" size="40" maxlength="100" value="<%=dateofAdmission%>"></td>
        </tr>
      <tr>
        <td align="right" valign="top">Class on Admission : </td>
        <td colspan="2"><input name="textClassonAdmission" type="text" id="textClassonAdmission" size="40" maxlength="100" value="<%=classonAdmission%>"></td>
        </tr>
        <tr>
        <td align="right" valign="top">Date of Leaving : </td>
        <td colspan="2"><input name="textDateofLeaving" type="text" id="textDateofLeaving" size="40" maxlength="100" value="<%=dateofLeaving%>"></td>
        </tr>
      <tr>
        <td align="right" valign="top">Class on Leaving : </td>
        <td colspan="2"><input name="textClassonLeaving" type="text" id="textClassonLeaving" size="40" maxlength="100" value="<%=classonLeaving%>"></td>
        <td>&nbsp;</td>
      </tr>               
       <tr>
        <td align="right" valign="top">Reason for Leaving : </td>
        <td colspan="3"><input name="textReasonforLeaving" type="text" id="textReasonforLeaving" size="40" maxlength="100" value="<%=reasonforLeaving%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Award  : </td>
        <td colspan="3"><input name="textAward" type="text" id="textAward" size="40" maxlength="100" value="<%=award%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Grade  : </td>
        <td colspan="3"><input name="textGrade" type="text" id="textGrade" size="40" maxlength="100" value="<%=grade%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Subject1  : </td>
        <td colspan="3"><input name="textSubject1" type="text" id="textSubject1" size="40" maxlength="100" value="<%=subject1%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Subject2  : </td>
        <td colspan="3"><input name="textSubject2" type="text" id="textSubject2" size="40" maxlength="100" value="<%=subject2%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Subject3  : </td>
        <td colspan="3"><input name="textSubject3" type="text" id="textSubject3" size="40" maxlength="100" value="<%=subject3%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Subject4  : </td>
        <td colspan="3"><input name="textSubject4" type="text" id="textSubject4" size="40" maxlength="100" value="<%=subject4%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Subject5  : </td>
        <td colspan="3"><input name="textSubject5" type="text" id="textSubject5" size="40" maxlength="100" value="<%=subject5%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Subject6  : </td>
        <td colspan="3"><input name="textSubject6" type="text" id="textSubject6" size="40" maxlength="100" value="<%=subject6%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">subject7  : </td>
        <td colspan="3"><input name="textSubject7" type="text" id="textSubject7" size="40" maxlength="100" value="<%=subject7%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Subject8  : </td>
        <td colspan="3"><input name="textSubject8" type="text" id="textSubject8" size="40" maxlength="100" value="<%=subject8%>"></td>
      </tr>
       <tr>
        <td align="right" valign="top">Date : </td>
        <td colspan="3"><input name="textDate" type="text" id="textDate" size="40" maxlength="100" value="<%=date%>"></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="146"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record" onClick="return validateStudent(form1)"></td>
        <td width="214"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record" onClick="return validateStudent(form1)"></td>
        <td width="133"><label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateStudent(form1)">
        </label></td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>

</html>
