<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,java.util.Enumeration,java.util.Iterator,java.util.LinkedHashMap,java.util.Set,gtr.DAO.SessionDAO,gtr.DAO.ClassDAO,gtr.DAO.SubjectDAO,gtr.DAO.ExamDAO"%>

<html>

    <head>

        <script language="javascript" type="text/javascript" src="javascript/school.js">
    </script>
<%
            String examId = (String) request.getAttribute("examId");
            if (examId == null) {
                examId = "";
            }
            String examName = (String) request.getAttribute("examName");
            if (examName == null) {
                examName = "";
            }
            String examQuestion = (String) request.getAttribute("question");
            if (examQuestion == null) {
                examQuestion = "";
            }
            String passMark = (String) request.getAttribute("passMark");
            if (passMark == null) {
                passMark = "";
            }
            String sessionId = (String) request.getAttribute("sessionId");
            if (sessionId == null) {
                sessionId = "";
            }
            String classId = (String) request.getAttribute("classId");
            if (classId == null) {
                classId = "";
            }
            String subjectId = (String) request.getAttribute("subjectId");
            if (subjectId == null) {
                subjectId = "";
            }
            String termId = (String) request.getAttribute("termId");
            if (termId == null) {
                termId = "";
            }

            String message = (String) request.getAttribute("msg");
            if (message == null) {
                message = "";
            }

%>

        <meta content="en-us" http-equiv="Content-Language" />
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
        <link rel="stylesheet" type="text/css" href="css/smweb.css"/>
        <title>S-Portal</title>
       
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
        <form id="form1" name="form1" method="post" action="gtr?a=Exam">
            <table width="707" cellpadding="10" class="style5">
                <tr>
                    <td width="689"><table width="668" border="0">
                            <tr>
                                <td colspan="6" class="style9 style15"><%=message%>
                                    <label></label>
                                    <label>                  </label>
                                    <label></label>
                                </td>
                            </tr>
                            <tr>
                                <td width="198" class="style9">&nbsp;</td>
                                <td colspan="5" align="right" class="style12">
                                    <%
                                     LinkedHashMap map = ExamDAO.loadCombo();
                                             out.print("<select name='comboLoad'>");
                                             if (map.isEmpty()) {
                                                 out.print("<OPTION value='0'>==No  Record==</OPTION>");
                                             } else {
                                                 out.print("<OPTION value='0'>=== Select Record ===</OPTION>");
                                                 Set keys = map.keySet();
                                                 Iterator itr = keys.iterator();
                                                 for (int i = 0; i < keys.size(); i++) {
                                                     String selectedId = itr.next().toString();
                                                     String Name = map.get(selectedId).toString();
                                                     out.print("<OPTION value='" + selectedId + "'");

                                                     
                                                     out.println(">" + Name + "</OPTION>");

                                                 }

                                             }
                                             out.println("</select>");
                                    %>
                                    <input name="buttonSubmit" type="submit" id="buttonSubmit" value="Load Record"></td>
                            </tr>
                            <tr>
                                <td align="right" class="style12">&nbsp;</td>
                                <td colspan="5" valign="top" class="style12"><input name="textExamId" type="hidden" id="textExamId" size="40" maxlength="90" value="<%=examId%>"></td>
                            </tr>
                            <tr>
                                <td align="right" class="style12">Exam Name : </td>
                                <td colspan="5" valign="top" class="style12"><label>
                                        <input name="textExamName" type="text" id="textExamName" size="40" maxlength="90" value="<%=examName%>">
                                    </label></td>
                            </tr>
                            <tr>
                                <td align="right" class="style12">Number of Questions : </td>
                                <td colspan="5" valign="top" class="style12"><input name="textQuestion" value="<%=examQuestion%>" type="text" id="textQuestion" size="20" maxlength="3"></td>
                            </tr>
                            <tr>
                                <td align="right" class="style12">Pass Mark : </td>
                                <td colspan="5" valign="top" class="style12"><input name="textPassMark" value="<%=passMark%>" type="text" id="textPassMark" size="20" maxlength="2"></td>
                            </tr>
                               <tr>
         <td align="right" class="style12">Session : </td>
        <td colspan="5" valign="top" class="style12"><%
                  LinkedHashMap smap = SessionDAO.loadCombo();
              out.print("<select name='comboSessionId'>");
              if (smap.isEmpty()) {
                out.print("<OPTION value='0'>==No Record==</OPTION>");
                } else {
                    out.print("<OPTION value='0'>=== Select Session ===</OPTION>");
                    Set keys = smap.keySet();
                    Iterator itr = keys.iterator();
                    for (int i = 0; i < keys.size(); i++) {
                        String selectedId = itr.next().toString();
                        String Name = smap.get(selectedId).toString();
                        out.print("<OPTION value='" + selectedId + "'");
                        if(sessionId.equals(selectedId)){

                        out.print("Selected='true'");

                        }
                        out.println(">" + Name + "</OPTION>");
                    }
                }
              out.println("</select>");
%>
        </label></td>
        <td>&nbsp;</td>
      </tr>
                            <tr>
                                <td align="right" class="style12">Class :  </td>
                                <td colspan="5" valign="top" class="style12">
                                    <%
                                             LinkedHashMap dmap = ClassDAO.loadCombo();
                                             out.print("<select name='comboClassId'>");
                                             if (dmap.isEmpty()) {
                                                 out.print("<OPTION value='0'>==No  Record==</OPTION>");
                                             } else {
                                                 out.print("<OPTION value='0'>=== Select Class ===</OPTION>");
                                                 Set keys = dmap.keySet();
                                                 Iterator itr = keys.iterator();
                                                 for (int i = 0; i < keys.size(); i++) {
                                                     String selectedId = itr.next().toString();
                                                     String Name = dmap.get(selectedId).toString();
                                                     out.print("<OPTION value='" + selectedId + "'");

                                                     if (classId.equals(selectedId)) {
                                                         out.print("Selected='true'");
                                                     }
                                                     out.println(">" + Name + "</OPTION>");

                                                 }

                                             }
                                             out.println("</select>");
                                    %>          </td>
                            </tr>
                            <tr>
                                <td align="right" class="style12">Subject : </td>
                                <td colspan="5" valign="top" class="style12"><%
                                  dmap = SubjectDAO.loadCombo();
                                  out.print("<select name='comboSubjectId'>");
                                  if (dmap.isEmpty()) {
                                      out.print("<OPTION value='0'>==No  Record==</OPTION>");
                                  } else {
                                      out.print("<OPTION value='0'>=== Select Subject ===</OPTION>");
                                      Set keys = dmap.keySet();
                                      Iterator itr = keys.iterator();
                                      for (int i = 0; i < keys.size(); i++) {
                                          String selectedId = itr.next().toString();
                                          String Name = dmap.get(selectedId).toString();
                                          out.print("<OPTION value='" + selectedId + "'");

                                          if (subjectId.equals(selectedId)) {
                                              out.print("Selected='true'");
                                          }
                                          out.println(">" + Name + "</OPTION>");

                                      }

                                  }
                                  out.println("</select>");
                                    %></td>
                            </tr>
                            <tr>
                                <td align="right" class="style12">Term : </td>
                                <td colspan="5" valign="top" class="style12"><label>
                                        <select name="comboTermId" id="comboTermId">
                                            <option>=== Select Term ===</option>
                                            <option value="Term01" <%if (termId.equals("Term01")) {out.print("Selected='true'");
            }%>>First Term</option>
                                            <option value="Term02" <%if (termId.equals("Term02")) {out.print("Selected='true'");
            }%>>Second Term</option>
                                            <option value="Term03" <%if (termId.equals("Term03")) {out.print("Selected='true'");
            }%>>Third Term</option>
                                        </select>
                                    </label></td>
                            </tr>
                            <tr>
                                <td align="right" class="style12">&nbsp;</td>
                                <td colspan="5" valign="top" class="style12">&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="right" class="style12">&nbsp;</td>
                                <td colspan="3" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Add Record" onClick="return validateExam(form1)"></td>
                                <td width="133" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Update Record" onClick="return validateExam(form1)"></td>
                                <td width="206" valign="top" class="style12"><input name="buttonSubmit" type="submit" id="buttonSubmit" value="Delete Record" onClick="return validateExam(form1)"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </body>

</html>
