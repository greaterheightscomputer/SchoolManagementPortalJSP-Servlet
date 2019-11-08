<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Enumeration,java.util.Vector,gtr.DAO.ClassSubjectDAO,gtr.DAO.SubjectDAO,gtr.DAO.ClassDAO,autoId.ClassId;" %>﻿
<html>



<head>

    <script language="javascript" type="text/javascript" src="jscript/branch.js">


    </script>

<%
    String classId = (String)session.getAttribute("classId");
    if(classId == null){
        classId = "";
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
.style17 {font-size: 12px}
.style18 {font-size: 11px}
</style>



</head>

<body>

  <table width="762" height="235" cellpadding="10" class="style5">
    <tr>
	<td width="652" valign="top"><p>&nbsp;</p>
            <p>Subject Registration for <%=ClassDAO.getClassName(classId)%></p>
           <table width="595" border="0">
      <tr>
          <td colspan="4"><span class="style12"><%=message%></span></td>
        </tr>


    </table>
	<br/>
	  <table width="529" border="0" cellspacing="0">

        <tr>
          <td bgcolor="#F0F0F0"><span class="style17">SUBJECT CODE </span></td>
          <td width="354" bgcolor="#F0F0F0"><span class="style17">SUBJECT NAME </span></td>
          <td width="44" bgcolor="#F0F0F0"><span class="style17"></span></td>
        </tr>
        <%
         Vector vector = SubjectDAO.loadAllRecord();
         Enumeration enu = vector.elements();
         while(enu.hasMoreElements()){
            String subjectId = enu.nextElement().toString().trim();
            String subject = enu.nextElement().toString().trim();

            int chkCS = ClassSubjectDAO.checkSubjectId(classId, subjectId);
            if(chkCS != 0){
     %>

        <form id="form1" method="post" action="gtr?a=ClassSubject" name="form1">
        <tr>
            <td width="125"><span class="style18"><%=subjectId%></span></td>
            <td><span class="style18"><%=subject%>
            <input type="hidden" name="textClassId" value="<%=classId%>"/>
            <input type="hidden" name="textSubjectId" value="<%=subjectId%>"/>
          </span></td>
          <td><label>
            <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add">
          </label></td>
        </tr>
        </form>

        <%
                }
            }

     %>
      </table>
	  <p>&nbsp;</p></td>
	</tr>
  </table>
</body>

</html>
