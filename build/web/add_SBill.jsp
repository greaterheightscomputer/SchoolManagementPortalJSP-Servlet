<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,java.util.Enumeration,java.util.Iterator,java.util.LinkedHashMap,java.util.Set,gtr.DAO.SessionDAO, gtr.DAO.StudentsDAO, gtr.DAO.ClassDAO,gtr.DAO.SchoolBillDAO"%>

<%

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

%>


<html>

<head>

<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href="css/smweb.css"/>
<title>S-Portal</title>
<script language="javascript" type="text/javascript" src="javascript/school.js">

</script>
<style type="text/css">
.style4 {
	font-family: "Courier New", Courier, monospace;
	font-size: medium;
}
.style5 {
	border-style:inset;
}
.style9 {
	font-size: small;
	color: #FF0000;
}
.style12 {font-size: small; color: #333333; }
.style15 {color: #660000}
</style>

</head>

<body>
    <form id="form1" name="form1" method="post" action="gtr?a=SBill">
  <table width="707" cellpadding="10" class="style5">
    <tr>
      <td width="689"><table width="668" border="0">
        <tr>
            <td colspan="6" class="style9 style15"><%=message%>
                  <label></label>
              <label>                  </label>
              <label></label>            </td>
          </tr>
        <tr>
          <td width="198" class="style9">&nbsp;</td>
          <td colspan="5" align="right" class="style12">
              <%
              LinkedHashMap map = SchoolBillDAO.loadCombo();
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
<input name="buttonSubmit" type="submit" id="buttonSubmit" value="Load Record" onClick="return addData(form1)"></td>
        </tr>
        <tr>
          <td align="right" class="style12"></td>
          <td colspan="5" valign="top" class="style12"><input name="textBillId" type="hidden" id="textBillId" size="40" maxlength="90" value="<%=billId%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Student Id : </td>
          <td colspan="5" valign="top" class="style12"><label>
                  <input name="textStudentId" type="text" id="textStudentId" size="30" maxlength="90" value="<%=studentId%>">
          </label></td>
        </tr>

        <tr>
          <td align="right" class="style12">Session :  </td>
          <td colspan="5" valign="top" class="style12">
   <%
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
%>          </td>
        </tr>

        <tr>
          <td align="right" class="style12">Class :  </td>
          <td colspan="5" valign="top" class="style12">
   <%
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
%>          </td>
        </tr>
                <tr>
          <td align="right" class="style12">Term : </td>
          <td colspan="5" valign="top" class="style12"><label>
            <select name="comboTermId" id="comboTermId">
              <option>=== Select Term ===</option>
              <option value="Term01" <%if(termId.equals("Term01")){out.print("Selected='true'");}%>>First Term</option>
              <option value="Term02" <%if(termId.equals("Term02")){out.print("Selected='true'");}%>>Second Term</option>
              <option value="Term03" <%if(termId.equals("Term03")){out.print("Selected='true'");}%>>Third Term</option>
            </select>
          </label></td>
        </tr>
        <tr>
          <td align="right" class="style12">Account Name : </td>
          <td colspan="5" valign="top" class="style12"><input name="textAccountName" type="text" id="textAccountName" size="30" maxlength="90" value="<%=accountname%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Account N0 : </td>
          <td colspan="5" valign="top" class="style12"><input name="textAccountNo" type="text" id="textAccountNo" size="30" maxlength="90" value="<%=accountno%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Previous Balance : </td>
          <td colspan="5" valign="top" class="style12"><input name="textPreviousBal" type="text" id="textPreviousBal" size="30" maxlength="90" value="<%=previousbalance%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">School Fees : </td>
          <td colspan="5" valign="top" class="style12"><input name="textSchoolFee" type="text" id="textSchoolFee" size="30" maxlength="90" value="<%=schoolfees%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Uniform : </td>
          <td colspan="5" valign="top" class="style12"><input name="textUniform" type="text" id="textUniform" size="30" maxlength="90" value="<%=uniform%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Sport Levy : </td>
          <td colspan="5" valign="top" class="style12"><input name="textSportLevy" type="text" id="textSportLevy" size="30" maxlength="90" value="<%=sportlevy%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Registration : </td>
          <td colspan="5" valign="top" class="style12"><input name="textRegistration" type="text" id="textRegistration" size="30" maxlength="90" value="<%=registration%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Exam Levy : </td>
          <td colspan="5" valign="top" class="style12"><input name="textExamLevy" type="text" id="textExamLevy" size="30" maxlength="90" value="<%=examlevy%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">PTA : </td>
          <td colspan="5" valign="top" class="style12"><input name="textPTA" type="text" id="textPTA" size="30" maxlength="90" value="<%=pta%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Computer Levy : </td>
          <td colspan="5" valign="top" class="style12"><input name="textComputerlevy" type="text" id="textComputerlevy" size="30" maxlength="90" value="<%=computerlevy%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Text Book : </td>
          <td colspan="5" valign="top" class="style12"><input name="textTextbook" type="text" id="textTextbook" size="30" maxlength="90" value="<%=textbook%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Note Book : </td>
          <td colspan="5" valign="top" class="style12"><input name="textNoteBook" type="text" id="textNoteBook" size="30" maxlength="90" value="<%=notebook%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Transporte Fees : </td>
          <td colspan="5" valign="top" class="style12"><input name="textTransport" type="text" id="textTransport" size="30" maxlength="90" value="<%=transport%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Lesson Fees : </td>
          <td colspan="5" valign="top" class="style12"><input name="textLessonFees" type="text" id="textLessonFees" size="30" maxlength="90" value="<%=lessonfees%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">End of Year Party : </td>
          <td colspan="5" valign="top" class="style12"><input name="textEndyear" type="text" id="textEndyear" size="30" maxlength="90" value="<%=endofyearparty%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Graduation Fees : </td>
          <td colspan="5" valign="top" class="style12"><input name="textGraduateFees" type="text" id="textGraduateFees" size="30" maxlength="90" value="<%=graduationfees%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Total : </td>
          <td colspan="5" valign="top" class="style12"><input name="textTotal" type="text" id="textTotal" size="30" maxlength="90" value="<%=total%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
           <td>&nbsp;</td>
           
          <td width="133"><label>
           <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateAssessment(form1)">
        </label></td>
        </tr>
      </table>
      </td>
    </tr>
  </table>
</form>
</body>

</html>
