<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.StaffDAO;" %>﻿
<html>


<head>

    <script language="javascript" type="text/javascript" src="javascript/school.js">
        
    </script>

<%
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
    <form id="form1" method="post" action="gtr?a=Staff" name="form1">
  <table width="731" height="235" cellpadding="10" class="style5">
    <tr>
	<td valign="top"><table width="595" border="0">
      <tr>
          <td colspan="4"><span class="style12"><%=message%></span></td>
        </tr>
      <tr>
        <td>&nbsp;</td>
        <td colspan="3" align="right"><label>
          <%
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
%>
        </label>
          <label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Load Record">
          </label></td>
      </tr>
      <tr>
        <td width="181">&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">Staff Id : </td>
        <td colspan="3"><label>
                <input name="textStaffId" type="text" id="textStaffId" size="40" maxlength="20" value="<%=staffId%>">
        </label></td>
      </tr>
      <tr>
        <td align="right" valign="top">Surname  : </td>
        <td colspan="3"><input name="textSurname" type="text" id="textSurname" size="40" maxlength="100" value="<%=surname%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">First Name : </td>
        <td colspan="3"><input name="textFirstName" type="text" id="textFirstName" size="40" maxlength="100" value="<%=firstName%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Gender : </td>
        <td colspan="3"><label>
          <select name="comboGender" id="comboGender">
            <option>=== Select Gender ===</option>
            <option <%if(gender.equals("Male")){out.println(" Selected='true'");}%>>Male</option>
            <option <%if(gender.equals("Female")){out.println(" Selected='true'");}%>>Female</option>
          </select>
        </label></td>
      </tr>
      <tr>
        <td align="right" valign="top">Date of Birth : </td>
        <td colspan="3"><input name="textDOB" type="text" id="textDOB" size="40" maxlength="100" value="<%=dob%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Address : </td>
        <td colspan="3"><textarea name="textAddress" cols="32" rows="4" id="textAddress"><%=address%></textarea></td>
      </tr>
      <tr>
        <td align="right" valign="top">Phone Number : </td>
        <td colspan="3"><input name="textPhone" type="text" id="textPhone" size="40" maxlength="100" value="<%=phone%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Email Address : </td>
        <td colspan="3"><input name="textEmail" type="text" id="textEmail" size="40" maxlength="200" value="<%=email%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Qualification : </td>
        <td colspan="3"><select name="comboQualification" id="comboQualification">
          <option>=== Select Qualification ===</option>
          <option <%if(qualification.equals("PhD")){out.println(" Selected='true'");}%>>PhD</option>
          <option <%if(qualification.equals("Masters")){out.println(" Selected='true'");}%>>Masters</option>
          <option <%if(qualification.equals("BSc")){out.println(" Selected='true'");}%>>BSc</option>
          <option <%if(qualification.equals("HND")){out.println(" Selected='true'");}%>>HND</option>
          <option <%if(qualification.equals("ND")){out.println(" Selected='true'");}%>>ND</option>
          <option <%if(qualification.equals("WAEC")){out.println(" Selected='true'");}%>>WAEC</option>
          <option <%if(qualification.equals("School Leaving")){out.println(" Selected='true'");}%>>School Leaving</option>
          <option <%if(qualification.equals("None")){out.println(" Selected='true'");}%>>None</option>
                </select></td>
      </tr>
      <tr>
        <td align="right" valign="top">Employee Type : </td>
        <td colspan="3"><select name="comboCategory" id="comboCategory">
          <option>=== Select Type ===</option>
          <option <%if(category.equals("Teaching Staff")){out.println(" Selected='true'");}%>>Teaching Staff</option>
          <option <%if(qualification.equals("Non-Teaching Staff")){out.println(" Selected='true'");}%>>Non-Teaching Staff</option>
                        </select></td>
      </tr>
      <tr>
        <td align="right" valign="top">Employment Date :  </td>
        <td colspan="3"><input name="textEmploymentDate" type="text" id="textEmploymentDate" size="40" maxlength="100" value="<%=employmentDate%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Salary : </td>
        <td colspan="3"><input name="textSalary" type="text" id="textSalary" size="40" maxlength="100" value="<%=salary%>"></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="85"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record" onClick="return validateStaff(form1)"></td>
        <td width="156"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record" onClick="return validateStaff(form1)"></td>
        <td width="155"><label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateStaff(form1)">
        </label></td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>

</html>
