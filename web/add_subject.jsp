<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.SubjectDAO,autoId.SubjectId;" %>﻿
<html>

<head>
    <script language="javascript" type="text/javascript" src="javascript/school.js">
    </script>

<%
    String subjectId = (String)request.getAttribute("subjectId");
    if(subjectId == null){
        subjectId = SubjectId.getId();
    }
    String name = (String)request.getAttribute("name");
    if(name == null){
        name = "";
    }
    String description = (String)request.getAttribute("description");
    if(description == null){
        description = "";
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
    <form method="post" action="gtr?a=Subject" name="form1">
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
              LinkedHashMap map = SubjectDAO.loadCombo();
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
        <td width="145">&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">Subject ID : </td>
        <td colspan="3"><label>
                <input name="textSubjectId" type="text" id="textSubjectId" size="40" maxlength="20" value="<%=subjectId%>">
        </label></td>
      </tr>
      <tr>
        <td align="right" valign="top">Subject Name  : </td>
        <td colspan="3"><input name="textSubjectName" type="text" id="textSubjectName" size="40" maxlength="20" value="<%=name%>"></td>
      </tr>
      <tr>
        <td align="right" valign="top">Description : </td>
        <td colspan="3"><textarea name="textDescription" cols="32" rows="4" id="textDescription"><%=description%></textarea></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="121"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record" onClick="return validateSubject(form1)"></td>
        <td width="156"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record" onClick="return validateSubject(form1)"></td>
        <td width="155"><label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateSubject(form1)">
        </label></td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>

</html>
