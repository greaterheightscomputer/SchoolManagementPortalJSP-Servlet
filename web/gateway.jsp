<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.StudentsDAO,gtr.DAO.SessionDAO,gtr.DAO.ClassDAO,gtr.DAO.StaffDAO,autoId.StudentId;" %>﻿
<html>



<head>

    <script language="javascript" type="text/javascript" src="javascript/school.js">


    </script>


<%
    String username = (String)request.getAttribute("username");
    if(username == null){
        username = "";
    }
    String password = (String)request.getAttribute("password");
    if(password == null){
        password = "";
    }
    String sender = (String)request.getAttribute("sender");
    if(sender == null){
        sender = "";
    }
    String number = (String)request.getAttribute("number");
    if(number == null){
        number = "";
    }
    String message = (String)request.getAttribute("message");
    if(message == null){
        message = "";
    }    

    String messages = (String)request.getAttribute("msg");
    if(messages == null){
        messages = "";
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
    <form id="form1" method="post" action="gtr?a=Gateway" name="form1">
  <table width="816" height="235" cellpadding="10" class="style5">
    <tr>
	<td valign="top"><table width="728" border="0">
      <tr>
          <td colspan="4"><span class="style12"><%=message%></span></td>
        </tr>
     
      <tr>
        <td width="217">&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td align="right"> </td>
        <td colspan="2"><label>
                <input name="textusername" type="hidden" id="textusername" size="40" maxlength="20" value="<%=username%>">
        </label></td>
         </tr>
      <tr>
        <td align="right" valign="top"> </td>
        <td colspan="2"><input name="textpassword" type="hidden" id="textpassword" size="40" maxlength="100" value="<%=password%>"></td>
        </tr>
       <tr>
        <td align="right" valign="top">Sender : </td>
        <td colspan="2"><input name="textsender" type="text" id="textsender" size="40" maxlength="100" value="<%=sender%>"></td>
        </tr>      
      <tr>
        <td align="right" valign="top">Number : </td>
        <td colspan="2"><input name="textnumber" type="text" id="textnumber" size="40" maxlength="100" value="<%=number%>"></td>
        </tr>          
      <tr>
        <td align="right" valign="top">Message : </td>
        <td colspan="3"><textarea name="textmessage" cols="32" rows="4" id="textmessage"><%=message%></textarea></td>
      </tr>      
      <tr>
        <td>&nbsp;</td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="146"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Send" onClick="return validateStudent(form1)"></td>
        <td width="214"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Refresh" onClick="return validateStudent(form1)"></td>
        <td width="133"><label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateStudent(form1)">
        </label></td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>

</html>

