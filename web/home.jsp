

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector, gtr.DAO.UserDAO" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

    "http://www.w3.org/TR/html4/loose.dtd">
<%

    String username = (String)session.getAttribute("name");
    if(username == null){
        //response.sendRedirect("./login.jsp");
    }

    String profileId = (String) session.getAttribute("profileId");
    if(profileId == null){
        profileId = "";
    }

%>

<html>

    <head>
    
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/smweb.css"/>
        
    </head>

    <frameset rows="123,56*">

        <frame name="top" scrolling="no" frameborder=0 noresize target="contents" src="header.jsp"/>
        <frameset cols="172,*">
            <frame name="contents" target="main" frameborder=0 src="<%=UserDAO.setMenu(profileId)%>.jsp"/>
            <frame name="main" frameborder=0 scrolling="auto" src="Home2.jsp" noresize/>
        </frameset>
        <!--frame name="bottom" scrolling="no" frameborder=0 noresize target="contents" src="footer.jsp"/-->
        <noframes>
            <body>
                <p>This page uses frames, but your browser doesn't support them.</p>
            </body>
        </noframes>
    </frameset>

</html>