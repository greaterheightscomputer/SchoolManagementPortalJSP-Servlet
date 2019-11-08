
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
            <li><a class="m1" href="Home2.jsp" target="main">Home</a></li>
            <li><a class="m3" href="gtr?a=change_passwordlink" target="main">Change Password</a></li>
            <li><a class="m3" href="http://www.ejeso.com" target="main">Send Bulk SMS</a></li>
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
            <li><a class="m4" href="#">Manage Staff</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addStaff" target="main">Staff Record</a></li>
                        <li><a href="gtr?a=Report&RepType=5" target="main">View Staffs</a></li>
                        <li><a href="view_staff.jsp" target="main">View Staff</a></li>
                    </ul>
            </li>
            <li><a class="m4" href="#">Manage School Bill</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addSchoolBill" target="main">Add Record</a></li>
                        <li><a href="gtr?a=addBill" target="main">Delete Record</a></li>                        
                    </ul>
            </li>               
             <li><a class="m4" href="#">Manage Student</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addStudent" target="main">Student Record</a></li>
                        <li><a href="gtr?a=addReport1" target="main">View Student's Form</a></li>
                        <li><a href="veiw_schoolbill.jsp" target="main">View School Bill</a></li>
                        <li><a href="gtr?a=addSport" target="main">Sport Record</a></li>
                        <li><a href="gtr?a=addCtime" target="main">Habit Record</a></li>
                        <li><a href="gtr?a=addDevelopment" target="main">Development Record</a></li>
                    </ul>
            </li>            
            <li><a class="m4" href="#">Manage Exam</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addExam" target="main">Add Exam</a></li>
                        <li><a href="gtr?a=addExamQuestion" target="main">Exam Questions</a></li>
                    </ul>
            </li>
            <li><a class="m4" href="#">Assessment</a>
                    <ul class="menu">
                        <li><a href="gtr?a=addAssessment" target="main">Add Assessment</a></li>
                        <li><a href="gtr?a=addReport" target="main">Student Result</a></li>
                        <li><a href="view_statementofresult.jsp" target="main">Statement Result</a></li>
                        <li><a href="gtr?a=addCertificate" target="main">Certificate</a></li>
                        <li><a href="gtr?a=addReports" target="main">View Certificate</a></li>
                      </ul>
            </li>
            <li><a class="m4" href="#">Student Diary</a>
                    <ul class="menu">
                        <li><a href="view_studentDiary.jsp" target="main">Generate Student's Diary</a></li>
                      </ul>
            </li>
            <li><a href="gtr?a=addUser" target="main">Create User</a></li>
            
       </ul>
    </body>
</html>