

package model;

import autoId.StudentId;
import gtr.DAO.StudentsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bin Sunusi
 */
public class StudentsServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
           HttpSession session = request.getSession();

            String button = request.getParameter("buttonSubmit").trim();

            String studentId = request.getParameter("textStudentId").trim();
            String firstName = request.getParameter("textFirstName").trim();
            String lastName = request.getParameter("textLastName").trim();
            String otherNames = request.getParameter("textOtherNames").trim();
            String gender = request.getParameter("comboGender").trim();
            String dateOfBirth = request.getParameter("textdateOfBirth").trim();
            String admissionDate = request.getParameter("textAdmissionDate").trim();
            String sessionId = request.getParameter("comboSessionId").trim();
            String classId = request.getParameter("comboClassId").trim();
            String termId = request.getParameter("comboTermId").trim();
            String address = request.getParameter("textAddress").trim();
            String parentName = request.getParameter("textParentName").trim();
            String occupation = request.getParameter("textOccupation").trim();
            String phoneNumber = request.getParameter("textphoneNumber").trim();
            String mobileNumber = request.getParameter("textmobileNumber").trim();
            String staffId = request.getParameter("comboStaffId").trim();
            String billId = request.getParameter("comboBillId").trim();
            
            String picture = "default.jpg";

            if(button.equals("Add Record")){

                int chkId = StudentsDAO.checkId(studentId);
                if(chkId != 0){

                int chkstudentId = StudentsDAO.checkId(studentId);
                if(chkstudentId != 0){
                    int status = StudentsDAO.insertRecord(studentId, firstName, lastName, otherNames, gender, dateOfBirth, admissionDate, sessionId, classId, termId, address, parentName, occupation, phoneNumber, mobileNumber, staffId, picture, billId);
                    if(status == 0){
                        session.setAttribute("id", studentId);
                        StudentId.updateId();
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/file_upload.jsp").forward(request, response);
                    }else{
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", mobileNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("billId", billId);
                        
                        request.setAttribute("msg","Record Not Saved, Try Again!");
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                    }
                }       else{
                        request.setAttribute("msg", "studentId" +studentId+ " Already Exist!" );
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", mobileNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("billId", billId);
                        
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);                
                }
                }else {

                    int chkstudentId = StudentsDAO.checkId(studentId);
                    if(chkstudentId != 0){

                    int status = StudentsDAO.insertRecord(StudentId.getId(), firstName, lastName, otherNames, gender, dateOfBirth, admissionDate, sessionId, classId, termId, address, parentName, occupation, phoneNumber, mobileNumber, staffId, picture, billId);
                    if(status == 0){
                        session.setAttribute("id", studentId);
                        StudentId.updateId();
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/file_upload.jsp").forward(request, response);
                    }else{
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", mobileNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("billId", billId);
                        
                        request.setAttribute("msg","Record Not Saved, Try Again!");
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("msg", "studentId" +studentId+ " Already Exist!" );
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", mobileNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("billId", billId);
                        
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                        }
                  }
            }
            
            else if(button.equals("Update Record")){
                 int chkId = StudentsDAO.checkId(studentId);
                if(chkId == 0){                     
                    int status = StudentsDAO.updateRecord(studentId, firstName, lastName, otherNames, gender, dateOfBirth, admissionDate, sessionId, classId, termId, address, parentName, occupation, phoneNumber, mobileNumber, staffId, picture, billId);
                     if(status == 0){
                         session.setAttribute("id", studentId);
                         request.setAttribute("msg","Record Successfully Updated!");
                         getServletContext().getRequestDispatcher("/file_upload.jsp").forward(request, response);
                    }else{
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", mobileNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("billId", billId);

                        request.setAttribute("msg","Record Not Updated, Try Again!");
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", phoneNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("billId", billId);

                        request.setAttribute("msg","Student Id Does not Exist, Try Again!");
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                }
            }
            else if(button.equals("Delete Record")){

                int chkId = StudentsDAO.checkId(studentId);
                if(chkId == 0){
                    int status = StudentsDAO.deleteRecord(studentId);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Deleted!");
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                    }else{
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", mobileNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("billId", billId);

                        request.setAttribute("msg","Record Not Deleted, Try Again!");
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                         request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", mobileNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("billId", billId);

                        request.setAttribute("msg","Student Id Does not Exist, Try Again!");
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                }

            }
            else if(button.equals("Load Record")){

                studentId = request.getParameter("comboLoad").trim();
                Vector vector = StudentsDAO.loadRecord(studentId);
                if(!vector.isEmpty()){

                    studentId = vector.elementAt(0).toString().trim();
                    firstName = vector.elementAt(1).toString().trim();
                    lastName = vector.elementAt(2).toString().trim();
                    otherNames = vector.elementAt(3).toString().trim();
                    gender = vector.elementAt(4).toString().trim();
                    dateOfBirth = vector.elementAt(5).toString().trim();
                    admissionDate = vector.elementAt(6).toString().trim();
                    sessionId = vector.elementAt(7).toString().trim();
                    classId = vector.elementAt(8).toString().trim();
                    termId = vector.elementAt(9).toString().trim();
                    address = vector.elementAt(10).toString().trim();
                    parentName = vector.elementAt(11).toString().trim();
                    occupation = vector.elementAt(12).toString().trim();
                    phoneNumber = vector.elementAt(13).toString().trim();
                    mobileNumber = vector.elementAt(14).toString().trim();
                    staffId = vector.elementAt(15).toString().trim();
                    String image = vector.elementAt(16).toString().trim();
                    billId = vector.elementAt(17).toString().trim();
                    
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("firstName", firstName);
                        request.setAttribute("lastName", lastName);
                        request.setAttribute("otherNames", otherNames);
                        request.setAttribute("gender", gender);
                        request.setAttribute("dateOfBirth", dateOfBirth);
                        request.setAttribute("admissionDate", admissionDate);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("address", address);
                        request.setAttribute("parentName", parentName);
                        request.setAttribute("occupation", occupation);
                        request.setAttribute("phoneNumber", phoneNumber);
                        request.setAttribute("mobileNumber", mobileNumber);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("image", image);
                        request.setAttribute("billId", billId);
                        
                        getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
                }

            }

        }catch(Exception ex){
            request.setAttribute("message", ex.getLocalizedMessage());
            request.setAttribute("class", ex.getClass());
            request.setAttribute("cause", ex.getCause());

            getServletContext().getRequestDispatcher("/exception.jsp").forward(request, response);

        }
        finally {
            if(out != null){
                out.close();
            }
         
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
