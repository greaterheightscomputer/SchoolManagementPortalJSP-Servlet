<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.SessionDAO, gtr.DAO.ClassDAO,gtr.DAO.CtimeDAO;" %>﻿
<html>

<head>

    <script language="javascript" type="text/javascript" src="javascript/school.js">

    </script>

<%
    String ctimeId = (String)request.getAttribute("ctimeId");
    if(ctimeId == null){
        ctimeId = "";
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
    String timePresentinSchool = (String)request.getAttribute("timePresentinSchool");
    if(timePresentinSchool == null){
        timePresentinSchool = "";
    }
    String timeAbsentinSchool = (String)request.getAttribute("timeAbsentinSchool");
    if(timeAbsentinSchool == null){
        timeAbsentinSchool = "";
    }
    String timePresentinSport = (String)request.getAttribute("timePresentinSport");
    if(timePresentinSport == null){
        timePresentinSport = "";
    }
    String timeAbsentinSport = (String)request.getAttribute("timeAbsentinSport");
    if(timeAbsentinSport == null){
        timeAbsentinSport = "";
    }
    String greenN0 = (String)request.getAttribute("greenN0");
    if(greenN0 == null){
        greenN0 = "";
    }
    String greenDeed = (String)request.getAttribute("greenDeed");
    if(greenDeed == null){
        greenDeed = "";
    }
    String redN0 = (String)request.getAttribute("redN0");
    if(redN0 == null){
        redN0 = "";
    }
    String redDeed = (String)request.getAttribute("redDeed");
    if(redDeed == null){
        redDeed = "";
    }
    String comments = (String)request.getAttribute("comments");
    if(comments == null){
        comments = "";
    }
    String cleanlinessRating = (String)request.getAttribute("cleanlinessRating");
    if(cleanlinessRating == null){
        cleanlinessRating = "";
    }
    String remarks = (String)request.getAttribute("remarks");
    if(remarks == null){
        remarks = "";
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
    <form id="form1" method="post" action="gtr?a=Ctime" name="form1">
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
              LinkedHashMap map = CtimeDAO.loadCombo();
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
        <td align="right" valign="top">Ctime Id  : </td>
        <td colspan="3"><input name="textCtimeId" type="text" id="textCtimeId" size="30" maxlength="100" value="<%=ctimeId%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">StudentId : </td>
        <td colspan="3"><input name="textStudentId" type="text" id="textStudentId" size="30" maxlength="100" value="<%=studentId%>"></td>
      </tr>
       <tr>
          <td align="right" >Session :  </td>
          <td colspan="3" >
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
          <td align="right" >Class :  </td>
          <td colspan="3" valign="top" class="style12">
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
          <td align="right" >Term : </td>
          <td colspan="3" valign="top" class="style12"><label>
            <select name="comboTermId" id="comboTermId">
              <option>=== Select Term ===</option>
              <option value="Term01" <%if(termId.equals("Term01")){out.print("Selected='true'");}%>>First Term</option>
              <option value="Term02" <%if(termId.equals("Term02")){out.print("Selected='true'");}%>>Second Term</option>
              <option value="Term03" <%if(termId.equals("Term03")){out.print("Selected='true'");}%>>Third Term</option>
            </select>
          </label></td>
        </tr>
      <tr>
          <td align="left" valign="top">PUNCTUALITY</td>
        </tr>
      <tr>
       <td align="right" valign="top">Time Present in School : </td>
        <td colspan="3"><input name="textTimePresentinSchool" type="text" id="textTimePresentinSchool" size="30" maxlength="100" value="<%=timePresentinSchool%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Time Absent in School : </td>
        <td colspan="3"><input name="textTimeAbsentinSchool" type="text" id="textTimeAbsentinSchool" size="30" maxlength="100" value="<%=timeAbsentinSchool%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Time Present in Sport : </td>
        <td colspan="3"><input name="textTimePresentinSport" type="text" id="textTimePresentinSport" size="30" maxlength="100" value="<%=timePresentinSport%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Time Absent in Sport : </td>
        <td colspan="3"><input name="textTimeAbsentinSport" type="text" id="textTimeAbsentinSport" size="30" maxlength="100" value="<%=timeAbsentinSport%>"></td>
      </tr>
      <tr>
          <td align="left" valign="top">CONDUCT</td>
        </tr>
      <tr>
        <td align="right" valign="top">Green Number: </td>
        <td colspan="3"><input name="textGreenN0" type="text" id="textGreenN0" size="30" maxlength="100" value="<%=greenN0%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Green Deed : </td>
        <td colspan="3"><input name="textGreenDeed" type="text" id="textGreenDeed" size="30" maxlength="100" value="<%=greenDeed%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Red Number : </td>
        <td colspan="3"><input name="textRedN0" type="text" id="textRedN0" size="30" maxlength="100" value="<%=redN0%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Red Deed : </td>
        <td colspan="3"><input name="textRedDeed" type="text" id="textRedDeed" size="30" maxlength="100" value="<%=redDeed%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Comments : </td>
        <td colspan="3"><textarea name="textComments" cols="32" rows="3" id="textComments"><%=comments%></textarea></td>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td align="right" valign="top">Cleanliness Rating : </td>
        <td colspan="3"><input name="textCleanlinessRating" type="text" id="textCleanlinessRating" size="30" maxlength="100" value="<%=cleanlinessRating%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Remarks : </td>
        <td colspan="3"><textarea name="textRemarks" cols="32" rows="3" id="textRemarks"><%=remarks%></textarea></td>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="85"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record" onClick="return validateCtime(form1)"></td>
        <td width="156"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record" onClick="return validateCtime(form1)"></td>
        <td width="155"><label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateCtime(form1)">
        </label></td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>
</html>
