<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,java.util.Enumeration,java.util.Iterator,java.util.LinkedHashMap,java.util.Set,gtr.DAO.ExamDAO,gtr.DAO.StudentsDAO"%>


<%

    
    String examId = (String)request.getAttribute("examId");
    if(examId == null){
        examId = "0";
    }

    String studentId = (String)request.getAttribute("studentId");
    if(studentId == null){
        studentId = "";
    }
    
    String passMark = (String)request.getAttribute("passMark");
    if(passMark == null){
        passMark = "40";
    }
    String remark = (String)request.getAttribute("remark");
    if(remark == null){
        remark = "NILL";
    }
    String score = (String)request.getAttribute("score");
    if(score == null){
        score = "1";
    }
    if(Integer.valueOf(score) > 100){
        score = "100";
    }

    

%>


<html>

<head> 

<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href="css/smweb.css"/>
<title>Test Engine: Score Summary</title>
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
.style15 {font-size: small; color: #333333; font-weight: bold; }
</style> 

</head>

<body>
    <form id="form1" name="form1" method="post" action="btl?e=ExamCenter">
	<center>
  <table width="798" cellpadding="10" class="style5">
    <tr>
      <td width="689"><p class="style4">&nbsp;</p>
          <table width="769" border="0">
        <tr bgcolor="#CCCCCC">
          <td colspan="5" bgcolor="#FFFFFF" class="style9"><span class="style15">Exam Score Summary </span></td>
          </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="4" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="4" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">Exam Pass Mark : </td>
          <td colspan="3" valign="top" class="style12"><table width="477" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
            <tr>
              <td width="<%=passMark%>%" bgcolor="#0000FF">&nbsp;</td>
              <td <%if(Integer.valueOf(score) < 100){%>bgcolor="#CCCCCC"<%} %>>&nbsp;</td>
            </tr>
          </table></td>
          <td valign="top" class="style12"><%=passMark%>%</td>
        </tr>
        <tr>
          <td align="right" class="style12">Score : </td>
          <td colspan="3" valign="top" class="style12"><table width="477" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
            <tr>
                <td width="<%=score%>%" bgcolor="<%if(remark.equals("PASSED")){out.print("#009900");}else{out.print("#FF0000");}%>">&nbsp;</td>
              <td <%if(Integer.valueOf(score) < 100){%>bgcolor="#CCCCCC"<%} %>>&nbsp;</td>
            </tr>
          </table></td>
          <td valign="top" class="style12"><%=score%>%</td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="4" valign="top" class="style12"><table width="486" border="0">
            <tr>
              <td width="404" align="right">Remark : </td>
              <td width="72"><%=remark%></td>
            </tr>
          </table></td>
          </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="4" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">Student Name :</td>
          <td colspan="4" valign="top" class="style12"><%=StudentsDAO.getName(studentId)%></td>
        </tr>
        <tr>
          <td align="right" class="style12">Examination : </td>
          <td colspan="4" valign="top" class="style12">
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
          <td width="155" align="right" class="style12">&nbsp;</td>
          <td colspan="4" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td width="76" align="right" valign="top" class="style12">&nbsp;</td>
          <td width="153" valign="top" class="style12">&nbsp;</td>
          <td width="248" valign="top" class="style12">&nbsp;</td>
          <td width="115" valign="top" class="style12">&nbsp;</td>
        </tr>
      </table>
      </td>
    </tr>
  </table>
  </center>
</form>
</body>

</html>
