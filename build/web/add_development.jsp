<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.SessionDAO, gtr.DAO.ClassDAO,gtr.DAO.DevelopmentDAO;" %>﻿
<html>

<head>
    <script language="javascript" type="text/javascript" src="javascript/school.js">

    </script>

<%
    String developmentId = (String)request.getAttribute("developmentId");
    if(developmentId == null){
        developmentId = "";
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
    String hieghtBegin = (String)request.getAttribute("hieghtBegin");
    if(hieghtBegin == null){
        hieghtBegin = "";
    }
    String hieghtEnd = (String)request.getAttribute("hieghtEnd");
    if(hieghtEnd == null){
        hieghtEnd = "";
    }
    String weightBegin = (String)request.getAttribute("weightBegin");
    if(weightBegin == null){
        weightBegin = "";
    }
    String weightEnd = (String)request.getAttribute("weightEnd");
    if(weightEnd == null){
        weightEnd = "";
    }
    String daysAbsent = (String)request.getAttribute("daysAbsent");
    if(daysAbsent == null){
        daysAbsent = "";
    }
    String nature = (String)request.getAttribute("nature");
    if(nature == null){
        nature = "";
    }
    String organization = (String)request.getAttribute("organization");
    if(organization == null){
        organization = "";
    }
    String officeHeld = (String)request.getAttribute("officeHeld");
    if(officeHeld == null){
        officeHeld = "";
    }
    String contribution = (String)request.getAttribute("contribution");
    if(contribution == null){
        contribution = "";
    }
    String principal = (String)request.getAttribute("principal");
    if(principal == null){
        principal = "";
    }
    String teacher = (String)request.getAttribute("teacher");
    if(teacher == null){
        teacher = "";
    }
    String vacation = (String)request.getAttribute("vacation");
    if(vacation == null){
        vacation = "";
    }
    String resumption = (String)request.getAttribute("resumption");
    if(resumption == null){
        resumption = "";
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
    <form id="form1" method="post" action="gtr?a=Development" name="form1">
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
              LinkedHashMap map = DevelopmentDAO.loadCombo();
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
        <td align="right" valign="top">Development Id  : </td>
        <td colspan="3"><input name="textdevelopmentId" type="text" id="textdevelopmentId" size="30" maxlength="100" value="<%=developmentId%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">StudentId : </td>
        <td colspan="3"><input name="textstudentId" type="text" id="textstudentId" size="30" maxlength="100" value="<%=studentId%>"></td>
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
          <td align="left" valign="top">PHYSICAL HEALTH</td>
        </tr>
      <tr>
          <td align="right" valign="top">Height at the Beginning of Term : </td>
        <td colspan="3"><input name="texthieghtBegin" type="text" id="texthieghtBegin" size="30" maxlength="100" value="<%=hieghtBegin%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Height at the End of Term : </td>
        <td colspan="3"><input name="texthieghtEnd" type="text" id="texthieghtEnd" size="30" maxlength="100" value="<%=hieghtEnd%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Weight at the Begin of Term : </td>
        <td colspan="3"><input name="textweightBegin" type="text" id="textweightBegin" size="30" maxlength="100" value="<%=weightBegin%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Weight at the End of Term : </td>
        <td colspan="3"><input name="textweightEnd" type="text" id="textweightEnd" size="30" maxlength="100" value="<%=weightEnd%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Days Absent: </td>
        <td colspan="3"><input name="textdaysAbsent" type="text" id="textdaysAbsent" size="30" maxlength="100" value="<%=daysAbsent%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Reasons for Absent : </td>
        <td colspan="3"><input name="textnature" type="text" id="textnature" size="30" maxlength="100" value="<%=nature%>"></td>
      </tr>
      <tr>
          <td align="left" valign="top">CLUBS,YOUTH ETC</td>
        </tr>
      <tr>
        <td align="right" valign="top">Organization : </td>
        <td colspan="3"><input name="textorganization" type="text" id="textorganization" size="30" maxlength="100" value="<%=organization%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Office Held : </td>
        <td colspan="3"><input name="textofficeHeld" type="text" id="textofficeHeld" size="30" maxlength="100" value="<%=officeHeld%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Contributions : </td>
        <td colspan="3"><textarea name="textcontribution" cols="32" rows="3" id="textcontribution"><%=contribution%></textarea></td>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
          <td align="left" valign="top">COMMENTS</td>
        </tr>
      <tr>
        <td align="right" valign="top">Principal's Comments : </td>
        <td colspan="3"><textarea name="textprincipal" cols="32" rows="3" id="textprincipal"><%=principal%></textarea></td>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td align="right" valign="top">Teacher's Comments : </td>
        <td colspan="3"><textarea name="textteacher" cols="32" rows="3" id="textteacher"><%=teacher%></textarea></td>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
          <td align="left" valign="top">DATE</td>
        </tr>
      <tr>
        <td align="right" valign="top">Vacation Date : </td>
        <td colspan="3"><input name="textvacation" type="text" id="textvacation" size="30" maxlength="100" value="<%=vacation%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Resumption Date : </td>
        <td colspan="3"><input name="textresumption" type="text" id="textresumption" size="30" maxlength="100" value="<%=resumption%>"></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="85"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record" onClick="return validateDevelopment(form1)"></td>
        <td width="156"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record" onClick="return validateDevelopment(form1)"></td>
        <td width="155"><label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateDevelopment(form1)">
        </label></td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>
</html>