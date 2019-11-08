<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.ClassDAO,autoId.ClassId;" %>﻿
<html>



<head>

    <script language="javascript" type="text/javascript" src="jscript/branch.js">

        
    </script>

<%    
    String message = (String)request.getAttribute("msg");
    if(message == null){
        message = "";
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
    <form id="form1" method="post" action="gtr?a=ClassSubject" name="form1">
  <table width="684" height="235" cellpadding="10" class="style5">
    <tr>
	<td width="652" valign="top"><p>&nbsp;</p>
	  <p>&nbsp;</p>
	  <table width="595" border="0">
      <tr>
          <td colspan="4"><span class="style12"><%=message%></span></td>
        </tr>
      <tr>
        <td>&nbsp;</td>
        <td width="432" colspan="3"><label>
          <%
              LinkedHashMap map = ClassDAO.loadCombo();
              out.print("<select name='comboLoad'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Class to Register Subject ===</OPTION>");
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
        </label>
          <label></label></td>
      </tr>
      <tr>
        <td width="145">&nbsp;</td>
        <td colspan="3"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Load Record"></td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>

</html>
