<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,java.util.Enumeration,java.util.Iterator,java.util.LinkedHashMap,java.util.Set,gtr.DAO.ExamDAO,gtr.DAO.StudentsDAO"%>


<%

    
    String examId = (String)session.getAttribute("examId");
    if(examId == null){
        examId = "";
    }
    String studentId = (String)session.getAttribute("studentId");
    if(studentId == null){
        studentId = "";
    }
    

%>


<html>

<head> 

<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href="css/smweb.css"/>
<title>Test Engine</title>
<script language="javascript" type="text/javascript" src="js/validate.js">

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
.style13 {color: #000000}
</style> 

</head>

<body>
    <form id="form1" name="form1" method="post" action="gtr?a=ExamCenter">
	<center>
  <table width="798" cellpadding="10" class="style5">
    <tr>
      <td width="689"><p class="style4">&nbsp;</p>
          <table width="769" border="0">
        <tr bgcolor="#CCCCCC">
          <td colspan="6" class="style9">&nbsp;</td>
          </tr>
        <tr>
          <td align="right" class="style12">Exam Id : </td>
          <td colspan="5" valign="top" class="style12">
                 <%
              LinkedHashMap map = ExamDAO.loadComboById(examId);
              out.print("<select name='comboLoad'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
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

          </td>
        </tr>
        <tr>
          <td align="right" class="style12">Number of Questions : </td>
          <td colspan="5" valign="top" class="style12"><%=ExamDAO.getNumberOfQuestion(examId)%></td>
        </tr>
        <tr>
          <td align="right" class="style12">Pass Mark : </td>
          <td colspan="5" valign="top" class="style12"><%=ExamDAO.getPassMark(examId)%>/100</td>
        </tr>
        <tr>
          <td align="right" class="style12">Student Id : </td>
          <td colspan="5" valign="top" class="style12"><%=StudentsDAO.getName(studentId)%></td>
        </tr>
        <tr>
          <td width="205" align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="2" align="right" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Start Exam" onClick=""></td>
          <td width="96" valign="top" class="style12">&nbsp;</td>
          <td width="212" valign="top" class="style12">&nbsp;</td>
          <td width="92" valign="top" class="style12">&nbsp;</td>
        </tr>
      </table>
      </td>
    </tr>
  </table>
  </center>
</form>
</body>

</html>
