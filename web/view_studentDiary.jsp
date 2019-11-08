<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,java.util.Enumeration,java.util.Iterator,java.util.LinkedHashMap,java.util.Set,gtr.DAO.ClassDAO,gtr.DAO.AssessmentDAO,gtr.DAO.SessionDAO,gtr.DAO.ExamDAO"%>

<%

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
.style15 {color: #660000}
</style>

</head>

<body>
    <form id="form1" name="form1" method="post" action="gtr?a=Report&RepType=3">
  <table width="956" cellpadding="10" class="style5">
    <tr>
      <td width="689"><table width="919" border="0">
        <tr>
          <td width="118" align="right" class="style12">&nbsp;</td>
          <td width="229" valign="top" class="style12">&nbsp;</td>
          <td width="82" valign="top" class="style12">&nbsp;</td>
          <td width="210" valign="top" class="style12">&nbsp;</td>
          <td width="87" valign="top" class="style12">&nbsp;</td>
          <td width="167" valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">Student Id</td>
          <td valign="top" class="style12"><label>
                  <input name="textStudentId" type="text" id="textStudentId" size="30" maxlength="90" value="<%=studentId%>">
          </label>
          </td>

        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td valign="top" class="style12"><label></label></td>
          <td valign="top" class="style12">&nbsp;</td>
          <td valign="top" class="style12">&nbsp;</td>
          <td valign="top" class="style12">&nbsp;</td>
          <td valign="top" class="style12">&nbsp;</td>
        </tr>
        <tr>
          <td align="right" class="style12">&nbsp;</td>
          <td valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Generate Student Diary"></td>
          <td valign="top" class="style12">&nbsp;</td>
          <td valign="top" class="style12">&nbsp;</td>
          <td valign="top" class="style12">&nbsp;</td>
          <td valign="top" class="style12">&nbsp;</td>
        </tr>
      </table>
      </td>
    </tr>
  </table>
</form>
</body>

</html>
