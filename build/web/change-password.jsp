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
<title>Change-Password </title>
<style type="text/css">
.style1 {
	font-family: "Courier New", Courier, monospace;
	font-size: small;
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
.style10 {font-size: medium; font-family: "Courier New", Courier, monospace;}
.style20 {font-family: Arial, Helvetica, sans-serif; font-size: 14px; }
.style21 {font-size: 14px}
</style>

<script language="Javascript">

   

</script>

</head>

<body>
<form id="form1" method="post" action="gtr?a=ChangePassword">
  <table width="798" cellpadding="10" class="style5">
    <tr>
      <td width="689"><p class="style10"> </p>
          <table width="769" border="0">
        <tr>
          <td colspan="4" class="style9">
                <%=message%>         </td>
          </tr>
        <tr>
          <td width="116">&nbsp;</td>
          <td width="120">&nbsp;</td>
          <td width="170">&nbsp;</td>
          <td width="313">&nbsp;</td>
        </tr>
      </table>
        <table width="765" border="0" cellspacing="0">
          <tr>
            <td width="221" align="right"><span class="style20">Old Password</span></td>
            <td width="534"><span class="style1">
              <input name="textOldPassword" type="password" class="style1" id="textOldPassword" style="width: 192px" tabindex="2" size="40">
            </span></td>
          </tr>
          <tr>
            <td align="right" class="style20">&nbsp;</td>
            <td class="style1" style="width: 419px"><input name="textUsername" type="hidden" class="style1" id="textUsername" style="width: 192px" tabindex="2" value="<%=username%>" size="40" /></td>
          </tr>
          <tr>
            <td align="right" class="style20">New Password</td>
            <td class="style1" style="width: 419px"><input name="textPassword" type="password" class="style1" id="textPassword" style="width: 192px" tabindex="2" size="40"></td>
          </tr>
          <tr>
            <td align="right"><span class="style21"></span></td>
            <td class="style1" style="width: 419px">&nbsp;</td>
          </tr>
          <tr>
            <td align="right"><span class="style20">Re-enter Password </span></td>
            <td><input name="textConfirmPassword" type="password" class="style1" id="textConfirmPassword" style="width: 192px" tabindex="2" size="40"></td>
          </tr>
          <tr>
            <td align="right"><span class="style21"></span></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><strong>
              <input name="buttonSubmit" type="submit" class="style7" id="buttonSubmit" value="Change Password" />
            </strong></td>
          </tr>
        </table>      </td>
    </tr>
  </table>
</form>
</body>

</html>
