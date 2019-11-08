<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,java.util.Enumeration,java.util.Iterator,java.util.LinkedHashMap,java.util.Set,gtr.DAO.SessionDAO, gtr.DAO.ClassDAO,gtr.DAO.AssessmentDAO,gtr.DAO.SubjectDAO,gtr.DAO.ExamDAO, gtr.DAO.CtimeDAO, gtr.DAO.DevelopmentDAO, gtr.DAO.SportDAO,gtr.DAO.CertificateDAO"%>

<%

    
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
    <form id="form1" name="form1" method="post" action="gtr?a=Assessment">
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
%>
<input name="buttonSubmit" type="submit" id="buttonSubmit" value="Load Record" onClick="return addData(form1)"></td>
        </tr>
        <tr>
          <td align="right" class="style12"></td>
          <td colspan="5" valign="top" class="style12"><input name="textAssessmentId" type="hidden" id="textAssessmentId" size="40" maxlength="90" value="<%=assessmentId%>"></td>
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
          <td align="right" class="style12">Subject : </td>
          <td colspan="5" valign="top" class="style12"><%
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
%></td>
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
          <td align="right" class="style12">Test 1 Score : </td>
          <td colspan="5" valign="top" class="style12"><input name="textTest1" type="text" id="textTest1" size="30" maxlength="90" value="<%=test1%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Test 2 Score : </td>
          <td colspan="5" valign="top" class="style12"><input name="textTest2" type="text" id="textTest2" size="30" maxlength="90" value="<%=test2%>"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Exam Score : </td>
          <td colspan="5" valign="top" class="style12"><input name="textExam" type="text" id="textExam" size="30" maxlength="90" value="<%=exam%>"></td>
        </tr>
         <tr>
          <td align="right" class="style12">Development : </td>
          <td colspan="5" valign="top" class="style12"><%
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
%>
    </td>
        </tr>
         <tr>
          <td align="right" class="style12">Sport : </td>
          <td colspan="5" valign="top" class="style12"><%
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
%></td>
        </tr>
         <tr>
          <td align="right" class="style12">Ctime : </td>
          <td colspan="5" valign="top" class="style12"><%
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
%></td>
        </tr>
         <tr>
          <td align="right" class="style12">Certificate : </td>
          <td colspan="5" valign="top" class="style12"><%
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
%></td>
        </tr>
                          
        <tr>
        
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
           <td>&nbsp;</td>
        <td width="146"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Test 1" onClick="return validateAssessment(form1)"></td>
        <td width="214"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Test 2" onClick="return validateAssessment(form1)"></td>
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
