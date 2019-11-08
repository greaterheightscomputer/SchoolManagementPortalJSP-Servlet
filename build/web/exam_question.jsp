<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,java.util.Enumeration,java.util.Iterator,java.util.LinkedHashMap,java.util.Set,gtr.DAO.ExamDAO,gtr.DAO.ExamQuestionDAO"%>

<%

    
    String questionId = (String)request.getAttribute("questionId");
    if(questionId == null){
        questionId = "";
    }
    String question = (String)request.getAttribute("question");
    if(question == null){
        question = "";
    }
    String optionA = (String)request.getAttribute("optionA");
    if(optionA == null){
        optionA = "";
    }
    String optionB = (String)request.getAttribute("optionB");
    if(optionB == null){
        optionB = "";
    }
    String optionC = (String)request.getAttribute("optionC");
    if(optionC == null){
        optionC = "";
    }
    String optionD = (String)request.getAttribute("optionD");
    if(optionD == null){
        optionD = "";
    }
    String answer = (String)request.getAttribute("answer");
    if(answer == null){
        answer = "";
    }
    String mark = (String)request.getAttribute("mark");
    if(mark == null){
        mark = "";
    }
    String examId = (String)request.getAttribute("examId");
    if(examId == null){
        examId = "";
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
.style14 {font-size: small; color: #000000; }
</style>

</head>

<body>
    <form id="form1" name="form1" method="post" action="gtr?a=ExamQuestion">
  <table width="798" cellpadding="10" class="style5">
    <tr>
      <td width="689"><table width="608" border="0">
        <tr>
            <td colspan="4" class="style9"><%=message%>
            </td>
          <td width="143" align="right" class="style12"><label>
 
          </label>
            <label></label></td>
          <td width="174" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td width="148" class="style9">&nbsp;</td>
          <td colspan="5" align="right" class="style12">

           <%
              LinkedHashMap map = ExamQuestionDAO.loadCombo();
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
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12"><input name="textQuestionId" type="hidden" id="textQuestionId" size="50" maxlength="90" value="<%=questionId%>"></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12">Question : </td>
          <td colspan="5" valign="top" class="style12">
                  <textarea name="textQuestion" cols="30" id="textQuestion"><%=question%></textarea>
         </td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12">Option (A) :  </td>
          <td colspan="5" valign="top" class="style12"><textarea name="textOptionA" cols="30" id="textOptionA"><%=optionA%></textarea></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12">Option (B) : </td>
          <td colspan="5" valign="top" class="style12"><textarea name="textOptionB" cols="30" id="textOptionB"><%=optionB%></textarea></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12">Option (C) : </td>
          <td colspan="5" valign="top" class="style12"><textarea name="textOptionC" cols="30" id="textOptionC"><%=optionC%></textarea></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12">Option (D) : </td>
          <td colspan="5" valign="top" class="style12"><textarea name="textOptionD" cols="30" id="textOptionD"><%=optionD%></textarea></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12">Correct Answer : </td>
          <td colspan="5" valign="top" class="style12"><textarea name="textCorrectAnswer" cols="30" id="textCorrectAnswer"><%=answer%></textarea></td>
        </tr>
        <tr>
          <td align="right" class="style12">Mark : </td>
          <td colspan="5" valign="top" class="style12"><input name="textMark" value="<%=mark%>" type="text" id="textMark" size="20" maxlength="2"></td>
        </tr>
        <tr>
          <td align="right" class="style12">Exam : </td>
          <td colspan="5" valign="top" class="style12">
   <%
              LinkedHashMap dmap = ExamDAO.loadCombo();
              out.print("<select name='comboExamId'>");
              if (dmap.isEmpty()) {
                out.print("<OPTION value='0'>==No Exam Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>===Select Exam Record===</OPTION>");
                    Set keys = dmap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = dmap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(examId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");

                    }

                }
              out.println("</select>");
%>          </td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="5" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="3" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record" onClick="return addData(form1)"></td>
          <td valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record" onClick="return addData(form1)"></td>
          <td valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return addData(form1)"></td>
        </tr>
      </table>
      </td>
    </tr>
  </table>
</form>
</body>

</html>
