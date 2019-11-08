<%

    String username = (String)session.getAttribute("name");
    //if(username == null){
        //request.getRequestDispatcher("/btl?e=logout").forward(request,response);
   // }
    String profile = (String)session.getAttribute("profileName");
    if(profile == null){
        profile = "";
    }
%>
<%@page import="java.util.Hashtable"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>

</title>


<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/headerStyle.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
.style10 {font-size: 12px; color: #666666; }
.style12 {
	font-size: 12px;
	color: #666666;
	font-family: "Courier New", Courier, monospace;
	font-weight: bold;
	text-decoration:underline;
}
.style14 {font-size: 30px}
.style15 {color: #959492}
.style17 {font-size: 50px}
-->
</style>
<base target="contents">
</head>
<body>
	<div id="logo">
		<table width="1025" border="0" cellspacing="0" cellpadding="0" height="105">
          <tr>
            <td width="221" rowspan="4" align="center">
			<!--img src="images/lcc.jpg" /-->
            </td>
            <td width="52" height="78" rowspan="3" align="right"><div align="left"><!--img src="images/logo.png" alt="" width="281" height="49" /-->
            </div>
            <span class="style14"><span class="style17">S</span></span></td>
            <td width="167" rowspan="3"><div align="left"><!--img src="images/logo.png" alt="" width="281" height="49" /-->
            </div><span class="style14"> <span class="style15">PORTAL</span></span></td>
            <td width="276" height="78" rowspan="3">&nbsp;</td>
            <td width="152" height="78" rowspan="3">&nbsp;</td>
            <td width="157" height="39" valign="middle"><span class="style10">Hi <%=username%></span><span class="style10">&nbsp;|&nbsp;<a href="gtr?a=logout" target="_top">log out</a>
            
            </span></td>
          </tr>
          <tr>
              <td height="19" valign="top"><span class="style12">Profile : <%=profile%> </span></td>
          </tr>
          <tr>
            <td height="20" valign="top">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2">&nbsp;</td>
            <td colspan="2">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
      </table>
		<br/>
		<p>&nbsp;</p>
</div>
</body>
</html>
