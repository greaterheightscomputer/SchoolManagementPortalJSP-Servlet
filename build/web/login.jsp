<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>S-Portal : Login Page</title>
<style type="text/css">
<!--
.style1 {
         font-family: "Times New Roman", Times, serif;
	font-size: 12px;
}
.style4 {
	font-family: "Times New Roman", Times, serif;
	font-size: 16px;
	font-style: italic;
	color: #000000;
}
.style6 {
	font-size: 28px;
	font-family: Georgia, "Times New Roman", Times, serif;
}
.style7 {
	font-family: "Times New Roman", Times, serif;
	font-size: 11px;
	color: #FF0000;
}
-->
</style>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<%
        String message = (String)request.getAttribute("msg");
        if(message == null){
            message = "";
        }
 %>
<style type="text/css">
<!--
.style10 {
	font-family: "Times New Roman", Times, serif;
	font-size: 10;
	color: #DC3433;
}
.style11 {
	font-family: "Courier New", Courier, monospace;
	font-size: 13px;
	font-weight: bold;
}
.style12 {color: #DC3433}
.style13 {
	color: #86B8D1;
	font-size: 40px;
}
.style14 {
	font-size: 24px;
	color: #D38B03;
}
-->
</style>
</head>

<body>

<p align="center">&nbsp;</p>
<center>
<div align="center">
	<p align="center">&nbsp;</p>
	<p align="center">&nbsp;</p>
	<table border="0" width="30%" style="border-collapse: collapse" cellpadding="0">
		<tr>
			<td colspan="2" rowspan="2" bordercolor="#FF8040" bgcolor="#FFFFFF" class="style6">
			<span class="style13">S</span>-<span class="style14">PORTAL  </span></td>
			<td colspan="3" bordercolor="#FF8040" bgcolor="#FFFFFF">&nbsp;</td>
		    <td bordercolor="#FF8040" bgcolor="#FFFFFF" width="30">&nbsp;</td>
		</tr>
		<tr>
			<td bordercolor="#2A5F8B" bgcolor="#4981BE">&nbsp;</td>
		    <td colspan="2" bordercolor="#2A5F8B" bgcolor="#4981BE"><span class="style11">
			<font size="3">Admin Login</font></span></td>
		    <td bordercolor="#FF8040" bgcolor="#89B2C8" width="30">&nbsp;</td>
		</tr>
		<tr>
			<td width="520" rowspan="2" valign="top">
			<p align="center">
			<img border="0" src="images/Logo.gif" width="163" height="152"></td>
			<td width="4" rowspan="2" valign="top">&nbsp;</td>
		  <td bgcolor="#77A6B6"><p class="style7"></td>
		    <td colspan="2"><form method="POST" action="gtr?a=Login">
               <!--webbot bot="SaveResults" U-File="C:\Users\GTR\Desktop\Login\_private\form_results.csv" S-Format="TEXT/CSV" S-Label-Fields="TRUE" -->
              <div align="right">
                <table border="0" width="186" cellpadding="0">
                  <tr>
                    <td width="54"><span class="style1">Username</span></td>
                    <td width="126"><input type="text" name="textUsername" value="greater" size="20"></td>
                  </tr>  
                  <tr>
                    <td width="54"><span class="style1">Password</span></td>
                    <td><input type="password" name="textPassword" value="gtr2012" size="20"></td>
                  </tr>
                  <tr>
                    <td width="54">&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="54">&nbsp;</td>
                    <td>
					<input type="submit" value="Submit" name="buttonSubmit1"></td>
                  </tr>
                </table>
              </div>
	        </form></td>
		    <td width="30" bgcolor="#89B2C8">&nbsp;</td>
		</tr>
		<tr>
		  <td width="4" bgcolor="#77A6B6"><p class="style7"><span class="style12"></span></td>
		  <td width="79"><span class="style12"></span></td>
		  <td width="123"><span class="style10"><%=message%></span></td>
		  <td bgcolor="#77A6B6">&nbsp;</td>
	  </tr>
		<tr>
			<td colspan="2" valign="top" bgcolor="#4981BE">&nbsp;</td>
			<td colspan="3" bgcolor="#4981BE"><p class="style7"><span class="style12"></span></td>
		    <td width="30" bgcolor="#4981BE">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" bgcolor="#D38B03">&nbsp;</td>
			<td colspan="3" bgcolor="#D38B03">
		  <p align="right" class="style4">powered by JAVA </td>
		    <td width="30" bgcolor="#9D7216">&nbsp;</td>
		</tr>
	</table>
</div>
</center>
</body>

</html>
