<%-- 
    Document   : index
    Created on : Jun 13, 2011, 1:37:45 AM
    Author     : JamesCal.Java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>UPLOAD STUDENT PICTURE!</h3>
        <br/>
        <form name="form1" action="gtr?a=Upload" method="POST" enctype="multipart/form-data">
            <input type="file" name="file" value="" /><br/>
            <input type="submit" value="Upload" name="buttonSubmit" />
        </form>
    </body>
</html>
