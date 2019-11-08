
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/smweb.css"/>
        <!-- My Test Accordion -->
        <script src="js/jquery-1.2.1.min.js" type="text/javascript"></script>
        <script src="js/jquery.cookie.js" type="text/javascript"></script>
        <script src="js/menu.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css" />

    	<base target="main">
        <style type="text/css">
<!--
.style1 {font-size: 2em}
-->
        </style>
</head>
    <body>
            <ul id="menu1" class="menu noaccordion">
            <li class="style1">SCH BOARD</li>
            <li><a class="m1" href="Home1.jsp" target="main">Home</a></li>
            <li><a class="m3" href="gtr?a=change_passwordlink" target="main">Change Password</a></li>
            <li><a class="m3" href="http://209.173.133.66/default.aspx" target="main">Send Bulk SMS</a></li>
            <li><a class="m4" href="#">Manage Subject</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addSubject" target="main">Subject Record</a></li>
                        <li><a href="gtr?a=Report&RepType=1" target="main">Veiw Subjects</a></li>
                    </ul>
            </li>
            <li><a class="m4" href="#">Manage Session</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addSession" target="main">Session Record</a></li>
                        <li><a href="gtr?a=Report&RepType=2" target="main">View Sessions</a></li>
                    </ul>
            </li>
            <li><a class="m4" href="#">Manage Class</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addClass" target="main">Class Record</a></li>
                        <li><a href="gtr?a=addClassSubject" target="main">Class Subject Registration</a></li>
                         <li><a href="view_subject_registration.jsp" target="main">View Subject Registration</a></li>
                    </ul>
            </li>
           <li><a class="m4" href="#">Manage Student</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addStudent" target="main">Student Record</a></li>
                        <li><a href="gtr?a=addSport" target="main">Sport Record</a></li>
                        <li><a href="gtr?a=addCtime" target="main">Habit Record</a></li>
                        <li><a href="gtr?a=addDevelopment" target="main">Development Record</a></li>
                    </ul>
            </li>
             <li><a class="m4" href="#">Assessment</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addAssessment" target="main">Add Assessment</a></li>
                   </ul>
            </li>
            
       </ul>
    </body>
</html>