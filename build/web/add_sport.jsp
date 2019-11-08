
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.SessionDAO, gtr.DAO.ClassDAO,gtr.DAO.SportDAO;" %>﻿
<html>

<head>

    <script language="javascript" type="text/javascript" src="javascript/school.js">
    </script>
        
<%
    String sportId = (String)request.getAttribute("sportId");
    if(sportId == null){
        sportId = "";
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
    String events = (String)request.getAttribute("events");
    if(events == null){
        events = "";
    }
    String levelAttained = (String)request.getAttribute("levelAttained");
    if(levelAttained == null){
        levelAttained = "";
    }
    String comments = (String)request.getAttribute("comments");
    if(comments == null){
        comments = "";
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
    <form id="form1" method="post" action="gtr?a=Sport" name="form1">
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
              LinkedHashMap map = SportDAO.loadCombo();
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
        <td align="right" valign="top">Sport Id  : </td>
        <td colspan="3"><input name="textSportId" type="text" id="textSportId" size="40" maxlength="100" value="<%=sportId%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">StudentId : </td>
        <td colspan="3"><input name="textStudentId" type="text" id="textStudentId" size="40" maxlength="100" value="<%=studentId%>"></td>
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
       <td align="right" valign="top">Events : </td>
        <td colspan="3"><input name="textEvents" type="text" id="textEvents" size="40" maxlength="100" value="<%=events%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Level Attained : </td>
        <td colspan="3"><input name="textLevelAttained" type="text" id="textLevelAttained" size="40" maxlength="100" value="<%=levelAttained%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Comments : </td>
        <td colspan="3"><textarea name="textComments" cols="32" rows="4" id="textComments"><%=comments%></textarea></td>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="85"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record" onClick="return validateSports(form1)"></td>
        <td width="156"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record" onClick="return validateSports(form1)"></td>
        <td width="155"><label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateSports(form1)">
        </label></td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>
</html>
