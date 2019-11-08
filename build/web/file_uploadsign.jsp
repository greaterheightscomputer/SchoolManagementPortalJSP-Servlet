<%-- 
    Document   : file_uploadsign
    Created on : Nov 23, 2011, 6:20:35 PM
    Author     : Bun Sunusi
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
        <h3>UPLOAD AUTHORIZED SIGNATURE!</h3>
        <br/>
        <form name="form1" action="gtr?a=UploadSign" method="POST" enctype="multipart/form-data">
            <input type="file" name="file" value="" /><br/>
            <input type="submit" value="Upload" name="buttonSubmit" />
        </form>
    </body>
</html>
