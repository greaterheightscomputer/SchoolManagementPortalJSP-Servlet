<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.StudentsDAO,gtr.DAO.SessionDAO,gtr.DAO.ClassDAO,gtr.DAO.StaffDAO,autoId.StudentId,gtr.DAO.SchoolBillDAO;" %>﻿
<html>



<head>

    <script language="javascript" type="text/javascript" src="javascript/school.js">

        
    </script>

  
<%
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
    <form id="form1" method="post" action="gtr?a=Students" name="form1">
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
        <td align="right">Student Id : </td>
        <td colspan="2"><label>
                <input name="textStudentId" type="text" id="textStudentId" size="40" maxlength="20" value="<%=studentId%>">
        </label></td>
        <td rowspan="6" valign="top"><img src="pictures/<%=image%>" width="160" height="180"></td>
      </tr>
      <tr>
        <td align="right" valign="top">First Name   : </td>
        <td colspan="2"><input name="textFirstName" type="text" id="textFirstName" size="40" maxlength="100" value="<%=firstName%>"></td>
        </tr>
      <tr>
        <td align="right" valign="top">Last Name : </td>
        <td colspan="2"><input name="textLastName" type="text" id="textLastName" size="40" maxlength="100" value="<%=lastName%>"></td>
        </tr>
      <tr>
        <td align="right" valign="top">Other Names : </td>
        <td colspan="2"><input name="textOtherNames" type="text" id="textOtherNames" size="40" maxlength="100" value="<%=otherNames%>"></td>
        </tr>
      <tr>
        <td align="right" valign="top">Gender : </td>
        <td colspan="2"><label>
          <select name="comboGender" id="comboGender">
            <option>=== Select Gender ===</option>
            <option <%if(gender.equals("Male")){out.println(" Selected='true'");}%>>Male</option>
            <option <%if(gender.equals("Female")){out.println(" Selected='true'");}%>>Female</option>
          </select>
        </label></td>
        </tr>
      <tr>
        <td align="right" valign="top">Date of Birth : </td>
        <td colspan="2"><input name="textdateOfBirth" type="text" id="textdateOfBirth" size="40" maxlength="100" value="<%=dateOfBirth%>"></td>
        </tr>
      <tr>
        <td align="right" valign="top">Admission Date : </td>
        <td colspan="2"><input name="textAdmissionDate" type="text" id="textAdmissionDate" size="40" maxlength="100" value="<%=admissionDate%>"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="right" valign="top">Session : </td>
        <td colspan="2"><label>
          <%
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
%>
        </label></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="right" valign="top">Class : </td>
        <td colspan="2"><label>
          <%
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
%>
        </label></td>
        <td>&nbsp;</td>
      </tr>
     <tr>
          <td align="right" >Term : </td>
          <td colspan="3" valign="top" ><label>
            <select name="comboTermId" id="comboTermId">
              <option>=== Select Term ===</option>
              <option value="Term01" <%if(termId.equals("Term01")){out.print("Selected='true'");}%>>First Term</option>
              <option value="Term02" <%if(termId.equals("Term02")){out.print("Selected='true'");}%>>Second Term</option>
              <option value="Term03" <%if(termId.equals("Term03")){out.print("Selected='true'");}%>>Third Term</option>
            </select>
          </label></td>
        </tr>
      <tr>
        <td align="right" valign="top">Address : </td>
        <td colspan="3"><textarea name="textAddress" cols="32" rows="4" id="textAddress"><%=address%></textarea></td>
      </tr>
      <tr>
        <td align="right" valign="top">Parent/Guadian Name : </td>
        <td colspan="3"><input name="textParentName" type="text" id="textParentName" size="40" maxlength="100" value="<%=parentName%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Occupation : </td>
        <td colspan="3"><input name="textOccupation" type="text" id="textOccupation" size="40" maxlength="100" value="<%=occupation%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Phone Number : </td>
        <td colspan="3"><input name="textphoneNumber" type="text" id="textphoneNumber" size="40" maxlength="100" value="<%=phoneNumber%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Mobile Number : </td>
        <td colspan="3"><input name="textmobileNumber" type="text" id="textmobileNumber" size="40" maxlength="200" value="<%=mobileNumber%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Staff : </td>
        <td colspan="3">
           <%
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
%>        </td>
      </tr>
      <tr>
        <td align="right" valign="top">Bill : </td>
        <td colspan="3">
           <%
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
%>        </td>
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
