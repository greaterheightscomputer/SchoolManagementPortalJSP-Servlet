<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector;"%>﻿



<html>

<head>
<%
    
    String username = (String)session.getAttribute("username");
    if(username == null){
        username = "";
    } 
    
    String message = (String)request.getAttribute("msg");
    if(message == null){
        message = "";
    }


%>

<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href="css/smweb.css"/>
<title>Change Default-Password</title>
<style type="text/css">
.style1 {
	font-family: "Courier New", Courier, monospace;
	font-size: small;
}
.style4 {
	font-family: "Courier New", Courier, monospace;
	font-size: medium;
	font-weight: bold;
}
.style5 {
	border-style:inset;
}
.style7 {
	font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
	font-size: x-small;
	font-weight: bold;
}
.style9 {
	font-size: small;
	color: #FF0000;
}
</style>

<script language="Javascript">

   

</script>

</head>

<body>
<form name="form1" method="post" action="gtr?a=ChangePassword">
  <table width="798" cellpadding="10" class="style5">
    <tr>
      <td width="689"><p class="style4">Change your default password  to continue </p>
          <table width="769" border="0">
        <tr>
          <td colspan="4" class="style9">
                <%=message%>
          </td>
          </tr>
        <tr>
          <td width="116">&nbsp;</td>
          <td width="120">&nbsp;</td>
          <td width="170">&nbsp;</td>
          <td width="313">&nbsp;</td>
        </tr>
      </table>
        <table width="765" border="0">
          <tr>
            <td width="262"><span class="style1">Old Password</span></td>
            <td width="479">&nbsp;</td>
          </tr>
          <tr>
            <td class="style1"><input name="textOldPassword" type="password" class="style1" id="textOldPassword" style="width: 192px" tabindex="2" size="40"></td>
            <td class="style1" style="width: 419px"><input name="textUsername" type="hidden" class="style1" id="textUsername" style="width: 192px" tabindex="2" value="<%=username%>" size="40" /></td>
          </tr>
          <tr>
            <td class="style1">New Password</td>
            <td class="style1" style="width: 419px">&nbsp;</td>
          </tr>
          <tr>
            <td><input name="textPassword" type="password" class="style1" id="textPassword" style="width: 192px" tabindex="2" size="40"></td>
            <td class="style1" style="width: 419px">&nbsp;</td>
          </tr>
          <tr>
            <td><span class="style1">Re-enter Password </span></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><input name="textConfirmPassword" type="password" class="style1" id="textConfirmPassword" style="width: 192px" tabindex="2" size="40"></td>
            <td><strong>
              <input name="buttonSubmit" type="submit" class="style7" id="buttonSubmit" value="Change Default Password" />
            </strong></td>
          </tr>
        </table>      </td>
    </tr>
  </table>
</form>
</body>

</html>
