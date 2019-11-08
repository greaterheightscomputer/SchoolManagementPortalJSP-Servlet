<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,java.util.Enumeration,java.util.Iterator,java.util.LinkedHashMap,java.util.Set,gtr.DAO.ExamDAO,gtr.DAO.ExamQuestionDAO"%>

<%

    
    String examId = (String)request.getAttribute("examId");
    if(examId == null){
        examId = "";
    }
    String studentId = (String)request.getAttribute("studentId");
    if(studentId == null){
        studentId = "";
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
<title>S-Portal  Test Engine</title>
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
.style14 {
	color: #660000;
	font-size: 12px;
}
</style> 

</head>

<body>
    <form id="form1" name="form1" method="post" action="gtr?a=ExamSetup">
	<center>
  <table width="798" cellpadding="10" class="style5">
    <tr>
      <td width="689"><p class="style4">&nbsp;</p>
          <table width="769" border="0">
        <tr bgcolor="#CCCCCC">
          <td colspan="6" class="style9">&nbsp;</td>
          </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12 style14"><%=message%></td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">Examination Code : </td>
          <td colspan="5" valign="top" class="style12">

            <%
              LinkedHashMap map = ExamDAO.loadCombo();
              out.print("<select name='comboExamId'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Exam Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>===Select Exam Record===</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(examId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");

                    }

                }
              out.println("</select>");
%>
          </td>
        </tr>
        <tr>
          <td align="right" class="style12">Enter Student Id : </td>
          <td colspan="5" valign="top" class="style12"><label>
                  <input name="textStudentId" type="text" id="textStudentId" size="40" value="<%=studentId%>">
          </label></td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td width="177" align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="2" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Continue" onClick=""></td>
          <td width="170" valign="top" class="style12">&nbsp;</td>
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
