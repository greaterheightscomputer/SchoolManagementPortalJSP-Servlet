<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    
    String Qid = (String)request.getAttribute("questionId");
    if(Qid == null){
        Qid = "";
    }
    String questionNo = (String)request.getAttribute("rowN");
    if(questionNo == null){
        questionNo = "";
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
    String mark = (String)request.getAttribute("mark");
    if(mark == null){
        mark = "";
    }
    String isLast = (String)request.getAttribute("isLast");
    if(isLast == null){
        isLast = "";
    }
    String isFirst = (String)request.getAttribute("isFirst");
    if(isFirst == null){
        isFirst = "";
    }
    String realA = (String)request.getAttribute("realA");
    if(realA == null){
        realA = "";
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
          <td colspan="6" align="right" class="style9">Mark <span class="style12 style13"> <%=mark%></span></td>
          </tr>
        <tr>
          <td width="107" class="style12">Question <span class="style12 style13"><%=questionNo%></span>. </td>
          <td colspan="5" class="style12 style13"><%=question%></td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="5" class="style12 style13">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12"><label>
                  <input name="radio" type="radio" value="<%=optionA%>" <%if(realA.equals(optionA)){out.println("checked='true'");}%>>
          </label></td>
          <td colspan="5" valign="top" class="style12 style13"><%=optionA%></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12"><input name="radio" type="radio" value="<%=optionB%>" <%if(realA.equals(optionB)){out.println("checked='true'");}%>></td>
          <td colspan="5" valign="top" class="style12 style13"><%=optionB%></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12"><input name="radio" type="radio" value="<%=optionC%>" <%if(realA.equals(optionC)){out.println("checked='true'");}%>></td>
          <td colspan="5" valign="top" class="style12 style13"><%=optionC%></td>
        </tr>
        <tr>
          <td align="right" valign="top" class="style12"><input name="radio" type="radio" value="<%=optionD%>" <%if(realA.equals(optionD)){out.println("checked='true'");}%>></td>
          <td colspan="5" valign="top" class="style12"><span class="style13">
            <label></label>
          <%=optionD%></span></td>
        </tr>
        <tr>
            <td align="right" class="style12"><input type="hidden" name="textId" value="<%=Qid%>"><input type="hidden" name="textMark" value="<%=mark%>"></td>
          <td colspan="5" valign="top" class="style12"><input type="hidden" name="textQuestion" value="<%=question%>"></td>
        </tr>         
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td colspan="2" align="right" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Previous" onClick="" <%if(!isFirst.equals("")){out.println("disabled='true'");}%>></td>
          <td width="170" valign="top" class="style12">&nbsp;</td>
          <td width="212" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Next" onClick="" <%if(!isLast.equals("")){out.println("disabled='true'");}%>></td>
          <td width="92" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="End Exam" onClick=""></td>
        </tr>
      </table>
      </td>
    </tr>
  </table>
  </center>
</form>
</body>

</html>
