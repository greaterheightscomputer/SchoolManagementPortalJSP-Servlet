<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap, java.util.Set,java.util.Iterator,java.util.Vector,gtr.DAO.UserDAO,gtr.DAO.StaffDAO;" %>﻿
<html>

<head>
<%
    String username = (String)request.getAttribute("username");
    if(username == null){
        username = "";
    }
    String staffId = (String)request.getAttribute("staffId");
    if(staffId == null){
        staffId = "";
    }
    String profileId = (String)request.getAttribute("profileId");
    if(profileId == null){
        profileId = "";
    }
    
    String profile = (String)session.getAttribute("profileId");
    if(profile == null){
        profile = "";
    }

    String message = (String)request.getAttribute("msg");
    if(message == null){
        message = "";
    }

    String userStatus = (String)request.getAttribute("status");
    String userValue = "";
    if(userStatus == null){
        userStatus = "";
    }
    else if(Integer.valueOf(userStatus) == 0){
        userValue = "Unblock User";
    }
    else if(Integer.valueOf(userStatus) == 2){
        userValue = "Unblock User";
    }
    else if(Integer.valueOf(userStatus) == 1){
        userValue = "Block User";
    }


%>

<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<link rel="stylesheet" type="text/css" href="css/smweb.css"/>
<title></title>
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
<form id="form1" method="post" action="gtr?a=User">
  <table width="731" height="235" cellpadding="10" class="style5">
    <tr>
	<td valign="top"><table width="646" border="0">
      <tr>
          <td colspan="5"><span class="style12"><%=message%></span></td>
        </tr>
      <tr>
        <td>&nbsp;</td>
        <td colspan="4" align="right">
            <%
              LinkedHashMap map = UserDAO.loadCombo();
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
          <label>
          <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Load Record">
          </label></td>
      </tr>
      <tr>
        <td width="184">&nbsp;</td>
        <td colspan="4">&nbsp;</td>
      </tr>
      <tr>
        <td align="right"> Username : </td>
        <td colspan="4"><label>
                <input name="textUsername" type="text" size="40" maxlength="50" value="<%=username%>">
        </label></td>
      </tr>
      <tr>
        <td align="right" valign="top">Password : </td>
        <td colspan="4"><input name="textPassword" type="password" size="40" maxlength="50" value=""></td>
      </tr>
      <tr>
        <td align="right" valign="top">Re-enter Password : </td>
        <td colspan="4"><input name="textConfirmPassword" type="password" size="40" maxlength="50" value=""></td>
      </tr>
      <tr>
        <td align="right" valign="top">Staff  : </td>
        <td colspan="4">
            <%
              map = StaffDAO.loadCombo();
              out.print("<select name='comboStaffId'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Staff ===</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(staffId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");
%>        </td>
      </tr>
      <tr>
        <td align="right">User Profile : </td>
        <td colspan="4"><%
              map = UserDAO.loadProfile(profile);
              out.print("<select name='comboProfileId'>");
              if (map.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>==Select User Profile==</OPTION>");
                    Set keys = map.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = map.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");

                        if(profileId.equals(selectedId)){
                        out.print("Selected='true'");}out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");
%></td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td colspan="4">&nbsp;</td>
      </tr>
     
      <tr>
        <td>&nbsp;</td>
        <td width="2">&nbsp;</td>
        <td width="150"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record"></td>
        <td width="152">
          <%--<input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record">--%>
       </td>
        <td width="136">
            <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record">
        </td>
      </tr>
    </table></td>
	</tr>
  </table>
</form>
</body>

</html>
