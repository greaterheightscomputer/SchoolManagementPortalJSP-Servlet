/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bin Sunusi
 */
public class Controller extends HttpServlet {
   
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
        PrintWriter out = null;
        try {
                HttpSession session = request.getSession();

            String action = request.getParameter("a").trim();

            if(action.equals("addSubject")){
                getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
            }
            else if(action.equals("change_passwordlink")){
                getServletContext().getRequestDispatcher("/change-password.jsp").forward(request, response);
            }
            else if(action.equals("addSession")){
                getServletContext().getRequestDispatcher("/add_session.jsp").forward(request, response);
            }
            else if(action.equals("addClass")){
                getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
            }
            else if(action.equals("addClassSubject")){
                getServletContext().getRequestDispatcher("/pick_class_subject.jsp").forward(request, response);
            }
            else if(action.equals("addSchoolBill")){
                getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
            }
            else if(action.equals("addBill")){
                getServletContext().getRequestDispatcher("/add_SBill.jsp").forward(request, response);
            }
            else if(action.equals("addStaff")){
                getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);
            }
            else if(action.equals("addStudent")){
                getServletContext().getRequestDispatcher("/add_students.jsp").forward(request, response);
            }
            else if(action.equals("addCertificate")){
                getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
            }
            else if(action.equals("addSport")){
                getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
            }
            else if(action.equals("addCtime")){
                getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
            }
            else if(action.equals("addDevelopment")){
                getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
            }
            else if(action.equals("addExam")){
                getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
            }
            else if(action.equals("addExamQuestion")){
                getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
            }
            else if(action.equals("addAssessment")){
                getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
            }
            else if(action.equals("addUser")){
                getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
            }           
             else if(action.equals("addReport")){
                getServletContext().getRequestDispatcher("/view_result.jsp").forward(request, response);
             }
             else if(action.equals("addReport1")){
                getServletContext().getRequestDispatcher("/view_Form.jsp").forward(request, response);
             }
            else if(action.equals("addReports")){
                getServletContext().getRequestDispatcher("/veiw_certificate.jsp").forward(request, response);
             }

                     
            //Servlet
            else if(action.equals("ChangePassword")){
                getServletContext().getRequestDispatcher("/ChangePasswordServlet").forward(request, response);
            }
            else if(action.equals("Login")){
                getServletContext().getRequestDispatcher("/LoginServlet").forward(request, response);
            }
            else if(action.equals("Subject")){
                getServletContext().getRequestDispatcher("/SubjectServlet").forward(request, response);
            }
            else if(action.equals("Session")){
                getServletContext().getRequestDispatcher("/SessionServlet").forward(request, response);
            }
            else if(action.equals("Class")){
                getServletContext().getRequestDispatcher("/ClassServlet").forward(request, response);
            }
            else if(action.equals("ClassSubject")){
                getServletContext().getRequestDispatcher("/ClassSubjectServlet").forward(request, response);
            }                  
            else if(action.equals("SchBill")){
                getServletContext().getRequestDispatcher("/SchoolBillServlet").forward(request, response);
            }
            else if(action.equals("SBill")){
                getServletContext().getRequestDispatcher("/SBillServlet").forward(request, response);
            }
           else if(action.equals("Staff")){
                getServletContext().getRequestDispatcher("/StaffServlet").forward(request, response);
            }
            else if(action.equals("Students")){
                getServletContext().getRequestDispatcher("/StudentsServlet").forward(request, response);
            }
            else if(action.equals("Certificate")){
                getServletContext().getRequestDispatcher("/CertificateServlet").forward(request, response);
            }
            else if(action.equals("Sport")){
                getServletContext().getRequestDispatcher("/SportsServlet").forward(request, response);
            }
            else if(action.equals("Ctime")){
                getServletContext().getRequestDispatcher("/CtimeServlet").forward(request, response);
            }
            else if(action.equals("Development")){
                getServletContext().getRequestDispatcher("/DevelopmentServlet").forward(request, response);
            }
            else if(action.equals("Upload")){
                getServletContext().getRequestDispatcher("/UploadServlet").forward(request, response);
            }
            else if(action.equals("UploadSign")){
                getServletContext().getRequestDispatcher("/UploadSignServlet").forward(request, response);
            }
            else if(action.equals("Exam")){
                getServletContext().getRequestDispatcher("/ExamServlet").forward(request, response);
            }
            else if(action.equals("ExamQuestion")){
                getServletContext().getRequestDispatcher("/ExamQuestionServlet").forward(request, response);
            }
            else if(action.equals("ExamCenter")){
                getServletContext().getRequestDispatcher("/ExamCenterServlet").forward(request, response);
            }
            else if(action.equals("ExamSetup")){
                getServletContext().getRequestDispatcher("/ExamSetupServlet").forward(request, response);
            }
            else if(action.equals("User")){
                getServletContext().getRequestDispatcher("/UserServlet").forward(request, response);
            }
            else if(action.equals("Assessment")){
                getServletContext().getRequestDispatcher("/AssessmentServlet").forward(request, response);
            }
            else if(action.equals("Gateway")){
                getServletContext().getRequestDispatcher("/GatewayServlet").forward(request, response);
            }
            else if(action.equals("Report")){
                getServletContext().getRequestDispatcher("/ReportServlet").forward(request, response);
            }
            else{
                session.invalidate();
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
