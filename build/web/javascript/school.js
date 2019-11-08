
function checkComponent(components,alerttxt)
{
    with (components)
    {
       if (value == null || value == "")
       {
          alert(alerttxt);
          return false;
      }
      else
      {
       return true;
      }
    }
}
function checkLength(components,max,mini,alerttxt)
{
    with (components)
    {
        if (value.length > max || value.length < mini)
       {
          alert(alerttxt);
          return false;
      }
      else
      {
       return true;
      }
    }
}
function checkComboBox(combo,alerttxt)
{
    with (combo)
    {
       if (combo.selectedIndex == 0)
       {
          alert(alerttxt);
          return false;
       }
      else
      {
       return true;
      }
    }
}
function checkLoad()
{
       if (document.form1.comboLoad.selectedIndex == 0)
       {
          alert("Please select a valid record to load!");
          return false;
       }
      else
      {
       return true;
      }

}
function checkEmail(field,alerttxt)
{
with (field)
  {
  apos=value.indexOf("@");
  dotpos=value.lastIndexOf(".");
  if (apos<1||dotpos-apos<2)
    {
        alert(alerttxt);
        return false;
    }
  else {
      return true;
  }
  }
}

function confirmPwd(){
    pwd = document.form1.textPassword.value;
    comf = document.form1.textConfirmPassword.value;
    if(pwd != comf){
        alert("Incorrect Re-enter password!");		
        return false;
    }else{
        return true;
    }
}

function comfirmMsg(){    
 if(window.confirm("Do you want to Continue?")== false){
     return false;
   }else{
       return true;
   }
}

function checkLoad(comboLoad)
{
       if (checkComboBox(comboLoad,"Select One from the drop-down") == false)
       {
          comboLoad.focus();
          return false;
       }
      else
      {
       return true;
      }
}
	
function validateClass(form1){
        with(form1){
            if(checkComponent(textClassId,"Please Enter Class Id!") == false)
            {
                textClassId.focus();
                return false;
            }
            else if(checkComponent(textName,"Please Enter Class Name!") == false)
            {
                textName.focus();
                return false;
            }
            else if(checkComponent(textDescription,"Please Enter Class Description!") == false)
            {
                textDescription.focus();
                return false;
            }          
	}
    }

function validateSubject(subjectform){
        with(subjectform){
            if(checkComponent(textSubjectId,"Please Enter Subject Id!") == false)
            {
                textSubjectId.focus();
                return false;
            }
            else if(checkComponent(textSubjectName,"Please Enter Subject Name!") == false)
            {
                textSubjectName.focus();
                return false;
            }
            else if(checkComponent(textDescription,"Please Enter Subject Description!") == false)
            {
                textDescription.focus();
                return false;
            }
	}
    }

function validateCtime(form){
        with(form){
            if(checkComponent(textCtimeId,"Please Enter Ctime Id!") == false)
            {
                textCtimeId.focus();
                return false;
            }
            else if(checkComponent(textStudentId,"Please Enter Student Id!") == false)
            {
                textStudentId.focus();
                return false;
            }
            else if(checkComponent(textTimePresentinSchool,"Please Enter Time Present in School!") == false)
            {
                textTimePresentinSchool.focus();
                return false;
            }
            else if(checkComponent(textTimeAbsentinSchool,"Please Enter Time Absent in School!") == false)
            {
                textTimeAbsentinSchool.focus();
                return false;
            }
            else if(checkComponent(textTimePresentinSport,"Please Enter Time Present in Sport!") == false)
            {
                textTimePresentinSport.focus();
                return false;
            }
            else if(checkComponent(textTimeAbsentinSport,"Please Enter Time Absent in Sport!") == false)
            {
                textTimeAbsentinSport.focus();
                return false;
            }
            else if(checkComponent(textGreenN0,"Please Enter Green No!") == false)
            {
                textGreenN0.focus();
                return false;
            }
            else if(checkComponent(textGreenDeed,"Please Enter Green Deed!") == false)
            {
                textGreenDeed.focus();
                return false;
            }
            else if(checkComponent(textRedN0,"Please Enter Red No!") == false)
            {
                textRedN0.focus();
                return false;
            }
            else if(checkComponent(textRedDeed,"Please Enter Red Deed!") == false)
            {
                textRedDeed.focus();
                return false;
            }
            else if(checkComponent(textComments,"Please Enter Comments!") == false)
            {
                textComments.focus();
                return false;
            }
            else if(checkComponent(textCleanlinessRating,"Please Enter Cleanliness Rate!") == false)
            {
                textCleanlinessRating.focus();
                return false;
            }
            else if(checkComponent(textRemarks,"Please Enter Remarks!") == false)
            {
                textRemarks.focus();
                return false;
            }
        }
    }

function validateDevelopment(form){
        with(form){
            if(checkComponent(textdevelopmentId,"Please Enter Development Id!") == false)
            {
                textdevelopmentId.focus();
                return false;
            }
            else if(checkComponent(textstudentId,"Please Enter Student Id!") == false)
            {
                textstudentId.focus();
                return false;
            }
            else if(checkComponent(texthieghtBegin,"Please Enter Height at Beginning of Term!") == false)
            {
                texthieghtBegin.focus();
                return false;
            }
            else if(checkComponent(texthieghtEnd,"Please Enter Height at End of Term!") == false)
            {
                texthieghtEnd.focus();
                return false;
            }
            else if(checkComponent(textweightBegin,"Please Enter Weight at Beginning of Term!") == false)
            {
                textweightBegin.focus();
                return false;
            }
            else if(checkComponent(textweightEnd,"Please Enter Weight at End of Term!") == false)
            {
                textweightEnd.focus();
                return false;
            }
            else if(checkComponent(textdaysAbsent,"Please Enter Days of Absent!") == false)
            {
                textdaysAbsent.focus();
                return false;
            }
            else if(checkComponent(textnature,"Please Enter Nature of Illness!") == false)
            {
                textnature.focus();
                return false;
            }
            else if(checkComponent(textorganization,"Please Enter Organization!") == false)
            {
                textorganization.focus();
                return false;
            }
            else if(checkComponent(textofficeHeld,"Please Enter Office Held!") == false)
            {
                textofficeHeld.focus();
                return false;
            }
            else if(checkComponent(textcontribution,"Please Enter Contribution!") == false)
            {
                textcontribution.focus();
                return false;
            }
            else if(checkComponent(textprincipal,"Please Enter Principal's Comment!") == false)
            {
                textprincipal.focus();
                return false;
            }
            else if(checkComponent(textteacher,"Please Enter Teacher's Comment!") == false)
            {
                textteacher.focus();
                return false;
            }
            else if(checkComponent(textvacation,"Please Enter Vocation Date!") == false)
            {
                textvacation.focus();
                return false;
            }
            else if(checkComponent(textresumption,"Please Enter Resumption Date!") == false)
            {
                textresumption.focus();
                return false;
            }
        }
    }

function validateSession(form){
        with(form){
            if(checkComponent(textSessionId,"Please Enter Session Id!") == false)
            {
                textSessionId.focus();
                return false;
            }
            else if(checkComponent(textName,"Please Enter Session Name!") == false)
            {
                textName.focus();
                return false;
            }
            else if(checkComponent(textDescription,"Please Enter Description!") == false)
            {
                textDescription.focus();
                return false;
            }
         }
    }

function validateSports(form){
        with(form){
            if(checkComponent(textSportId,"Please Enter Sport Id!") == false)
            {
                textSportId.focus();
                return false;
            }
            else if(checkComponent(textStudentId,"Please Enter Student Id!") == false)
            {
                textStudentId.focus();
                return false;
            }
            else if(checkComponent(textEvents,"Please Enter Event!") == false)
            {
                textEvents.focus();
                return false;
            }
            else if(checkComponent(textLevelAttained,"Please Enter Level Attained!") == false)
            {
                textLevelAttained.focus();
                return false;
            }
            else if(checkComponent(textComments,"Please Enter Comments!") == false)
            {
                textComments.focus();
                return false;
            }
         }
    }

function validateStaff(form){
        with(form){
            if(checkComponent(textStaffId,"Please Enter Staff Id!") == false)
            {
                textStaffId.focus();
                return false;
            }
            else if(checkComponent(textSurname,"Please Enter Surname!") == false)
            {
                textSurname.focus();
                return false;
            }
            else if(checkComponent(textFirstName,"Please Enter First Name!") == false)
            {
                textFirstName.focus();
                return false;
            }
            else if(checkComboBox(comboGender,"Select One from the Gender drop-down!") == false)
            {
                comboGender.focus();
                return false;
            }
            else if(checkComponent(textDOB,"Please Enter Date of Birth!") == false)
            {
                textDOB.focus();
                return false;
            }
            else if(checkComponent(textAddress,"Please Enter Address!") == false)
            {
                textAddress.focus();
                return false;
            }
            else if(checkComponent(textPhone,"Please Enter Phone!") == false)
            {
                textPhone.focus();
                return false;
            }
            else if(checkComponent(textEmail,"Please Enter Email!") == false)
            {
                textEmail.focus();
                return false;
            }
            else if(checkComboBox(comboQualification,"Select One from the Qualification drop-down!") == false)
            {
                comboQualification.focus();
                return false;
            }
            else if(checkComboBox(comboCategory,"Select One from the Employee Type drop-down!") == false)
            {
                comboCategory.focus();
                return false;
            }
            else if(checkComponent(textEmploymentDate,"Please Enter Employment Date!") == false)
            {
                textEmploymentDate.focus();
                return false;
            }
            else if(checkComponent(textSalary,"Please Enter Salary!") == false)
            {
                textSalary.focus();
                return false;
            }
         }
    }

function validateExam(form){
        with(form){
            if(checkComponent(textExamName,"Please Enter Exam Name!") == false)
            {
                textExamName.focus();
                return false;
            }
            else if(checkComponent(textQuestion,"Please Enter Number of Questions!") == false)
            {
                textQuestion.focus();
                return false;
            }
            else if(checkComponent(textPassMark,"Please Enter Pass Mark!") == false)
            {
                textPassMark.focus();
                return false;
            }
            else if(checkComboBox(comboSessionId,"Select One from the Session Id drop-down!") == false)
            {
                comboSessionId.focus();
                return false;
            }
            else if(checkComboBox(comboClassId,"Select One from the Class Id drop-down!") == false)
            {
                comboClassId.focus();
                return false;
            }
            else if(checkComboBox(comboSubjectId,"Select One from the Subject Id drop-down!") == false)
            {
                comboSubjectId.focus();
                return false;
            }
            else if(checkComboBox(comboTermId,"Select One from the Term Id drop-down!") == false)
            {
                comboTermId.focus();
                return false;
            }

         }
    }

function validateStudent(form){
        with(form){
            if(checkComponent(textStudentId,"Please Enter Student Id!") == false)
            {
                textStudentId.focus();
                return false;
            }
            else if(checkComponent(textFirstName,"Please Enter First Name!") == false)
            {
                textFirstName.focus();
                return false;
            }
            else if(checkComponent(textLastName,"Please Enter Last Name!") == false)
            {
                textLastName.focus();
                return false;
            }
            else if(checkComponent(textOtherNames,"Please Enter Other Names!") == false)
            {
                textOtherNames.focus();
                return false;
            }
            else if(checkComboBox(comboGender,"Select One from the Gender drop-down!") == false)
            {
                comboGender.focus();
                return false;
            }
            else if(checkComponent(textdateOfBirth,"Please Enter Date of Birth!") == false)
            {
                textdateOfBirth.focus();
                return false;
            }
            else if(checkComponent(textAdmissionDate,"Please Enter Admission Date!") == false)
            {
                textAdmissionDate.focus();
                return false;
            }
            else if(checkComboBox(comboSessionId,"Select One from the Session Id drop-down!") == false)
            {
                comboSessionId.focus();
                return false;
            }
            else if(checkComboBox(comboClassId,"Select One from the Class Id drop-down!") == false)
            {
                comboClassId.focus();
                return false;
            }
            else if(checkComboBox(comboTermId,"Select One from the Term Id drop-down!") == false)
            {
                comboTermId.focus();
                return false;
            }
            else if(checkComponent(textAddress,"Please Enter Address!") == false)
            {
                textAddress.focus();
                return false;
            }
            else if(checkComponent(textParentName,"Please Enter Parent Name!") == false)
            {
                textParentName.focus();
                return false;
            }
            else if(checkComponent(textOccupation,"Please Enter Occupation!") == false)
            {
                textOccupation.focus();
                return false;
            }
            else if(checkComponent(textphoneNumber,"Please Enter Phone Number!") == false)
            {
                textphoneNumber.focus();
                return false;
            }
            else if(checkComponent(textmobileNumber,"Please Enter Mobile Number!") == false)
            {
                textmobileNumber.focus();
                return false;
            }
             else if(checkComboBox(comboStaffId,"Select One from the Staff Id drop-down!") == false)
            {
                comboStaffId.focus();
                return false;
            }
         }
    }

function validateAssessment(form){
        with(form){
            if(checkComponent(textStudentId,"Please Enter Student Id!") == false)
            {
                textStudentId.focus();
                return false;
            }
            else if(checkComboBox(comboSessionId,"Select One from the Session Id drop-down!") == false)
            {
                comboSessionId.focus();
                return false;
            }
            else if(checkComboBox(comboClassId,"Select One from the Class Id drop-down!") == false)
            {
                comboClassId.focus();
                return false;
            }
            else if(checkComboBox(comboSubjectId,"Select One from the Subject Id drop-down!") == false)
            {
                comboSubjectId.focus();
                return false;
            }
            else if(checkComboBox(comboTermId,"Select One from the Term Id drop-down!") == false)
            {
                comboTermId.focus();
                return false;
            }
            else if(checkComboBox(comboDevelopmentId,"Select One from the Development Id drop-down!") == false)
            {
                comboDevelopmentId.focus();
                return false;
            }
            else if(checkComboBox(comboSportId,"Select One from the Sport Id drop-down!") == false)
            {
                comboSportId.focus();
                return false;
            }
            else if(checkComboBox(comboCtimeId,"Select One from the Ctime Id drop-down!") == false)
            {
                comboCtimeId.focus();
                return false;
            }
         }
    }

