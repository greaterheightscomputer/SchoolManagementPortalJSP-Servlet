/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.AssessmentDAO;
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
public class AssessmentServlet extends HttpServlet {
   
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

            String assessmentId = request.getParameter("textAssessmentId").trim();
            String studentId = request.getParameter("textStudentId").trim();
            String subjectId = request.getParameter("comboSubjectId").trim();
            String sessionId = request.getParameter("comboSessionId").trim();
            String classId = request.getParameter("comboClassId").trim();
            String termId = request.getParameter("comboTermId").trim();
            String developmentId = request.getParameter("comboDevelopmentId").trim();
            String sportId = request.getParameter("comboSportId").trim();
            String ctimeId = request.getParameter("comboCtimeId").trim();
            String certificateId = request.getParameter("comboCertificateId").trim();
                        
            String comboLoad = request.getParameter("comboLoad").trim();

            String test1 = request.getParameter("textTest1").trim();
            if(test1.equals("")){
                test1 = "0";
            }
            String test2 = request.getParameter("textTest2").trim();
            if(test2.equals("")){
                test2 = "0";
            }
            String exam = request.getParameter("textExam").trim();
            if(exam.equals("")){
                exam = "0";
            }
             String staffId = (String) session.getAttribute("staffId");
                        
            if(button.equals("Add Test 1")){

                int chkStudent = StudentsDAO.checkId(studentId);
                if(chkStudent == 0){

                    int status = AssessmentDAO.insertRecord(studentId, subjectId, sessionId, classId, termId, test1, test2, exam, developmentId, sportId, ctimeId, certificateId, staffId);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                    }else{
                        request.setAttribute("studentId",studentId);
                        request.setAttribute("subjectId",subjectId);
                        request.setAttribute("sessionId",sessionId);
                        request.setAttribute("classId",classId);
                        request.setAttribute("termId",termId);
                        request.setAttribute("test1",test1);
                        request.setAttribute("test2",test2);
                        request.setAttribute("exam",exam);
                        request.setAttribute("developmentId",developmentId);
                        request.setAttribute("sportId",sportId);
                        request.setAttribute("ctimeId",ctimeId);
                        request.setAttribute("certificateId",certificateId);
                        
                        request.setAttribute("msg","Record cannot be Saved!");
                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                    }

                }else{
                        request.setAttribute("subjectId",subjectId);
                        request.setAttribute("sessionId",sessionId);
                        request.setAttribute("classId",classId);
                        request.setAttribute("termId",termId);
                        request.setAttribute("test1",test1);
                        request.setAttribute("test2",test2);
                        request.setAttribute("exam",exam);
                        request.setAttribute("developmentId",developmentId);
                        request.setAttribute("sportId",sportId);
                        request.setAttribute("ctimeId",ctimeId);
                        request.setAttribute("certificateId",certificateId);
                        
                        request.setAttribute("msg","Student Id "+studentId+" Does not Exist!");
                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                }

            }
            else if(button.equals("Add Test 2")){

                int chkStudent = StudentsDAO.checkId(studentId);
                if(chkStudent == 0){

                    int status = AssessmentDAO.addTest2(studentId, subjectId, classId, termId, test2, developmentId, sportId, ctimeId, certificateId, staffId);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                    }else{
                        request.setAttribute("studentId",studentId);
                        request.setAttribute("subjectId",subjectId);
                        request.setAttribute("classId",classId);
                        request.setAttribute("termId",termId);
                        request.setAttribute("test1",test1);
                        request.setAttribute("test2",test2);
                        request.setAttribute("exam",exam);
                        request.setAttribute("developmentId",developmentId);
                        request.setAttribute("sportId",sportId);
                        request.setAttribute("ctimeId",ctimeId);
                        request.setAttribute("certificateId",certificateId);
                        
                        request.setAttribute("msg","Record cannot be Saved!");
                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                    }

                }else{
                        request.setAttribute("studentId",studentId);
                        request.setAttribute("subjectId",subjectId);
                        request.setAttribute("classId",classId);
                        request.setAttribute("termId",termId);
                        request.setAttribute("test1",test1);
                        request.setAttribute("test2",test2);
                        request.setAttribute("exam",exam);
                        request.setAttribute("developmentId",developmentId);
                        request.setAttribute("sportId",sportId);
                        request.setAttribute("ctimeId",ctimeId);
                        request.setAttribute("certificateId",certificateId);
                                                
                        request.setAttribute("msg","Student Id "+studentId+" Does not Exist!");
                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);

                }

            }

            else if(button.equals("Delete Record")){
                int chkId = StudentsDAO.checkId(studentId);
                if(chkId == 0){

                        int status = AssessmentDAO.deleteRecord(assessmentId);
                        if(status == 0){

                            request.setAttribute("msg","Record Successfully Deleted!");
                            getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be Deleted, Try Again!");
                            request.setAttribute("subjectId",subjectId);
                            request.setAttribute("sessionId",sessionId);
                            request.setAttribute("classId",classId);
                            request.setAttribute("termId",termId);
                            request.setAttribute("test1",test1);
                            request.setAttribute("test2",test2);
                            request.setAttribute("exam",exam);
                            request.setAttribute("developmentId",developmentId);
                            request.setAttribute("sportId",sportId);
                            request.setAttribute("ctimeId",ctimeId);
                            request.setAttribute("certificateId",certificateId);
                                                        
                            getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                        }
                }else{
                            request.setAttribute("msg","Student Id Does not Exist, Try Again!");
                            request.setAttribute("studentId",studentId);
                            request.setAttribute("subjectId",subjectId);
                            request.setAttribute("sessionId",sessionId);
                            request.setAttribute("classId",classId);
                            request.setAttribute("termId",termId);
                            request.setAttribute("test1",test1);
                            request.setAttribute("test2",test2);
                            request.setAttribute("exam",exam);
                            request.setAttribute("developmentId",developmentId);
                            request.setAttribute("sportId",sportId);
                            request.setAttribute("ctimeId",ctimeId);
                            request.setAttribute("certificateId",certificateId);
                                                        
                            getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                }

            }
                        
            else if(button.equals("Load Record")){

                Vector vector = AssessmentDAO.loadRecord(comboLoad);
                if(!vector.isEmpty()){

                    assessmentId = vector.elementAt(0).toString().trim();
                    studentId = vector.elementAt(1).toString().trim();
                    subjectId = vector.elementAt(2).toString().trim();
                    sessionId = vector.elementAt(3).toString().trim();
                    classId = vector.elementAt(4).toString().trim();
                    termId = vector.elementAt(5).toString().trim();
                    test1 = vector.elementAt(6).toString().trim();
                    test2 = vector.elementAt(7).toString().trim();
                    exam = vector.elementAt(8).toString().trim();
                    developmentId = vector.elementAt(9).toString().trim();
                    sportId = vector.elementAt(10).toString().trim();
                    ctimeId = vector.elementAt(11).toString().trim();
                    certificateId = vector.elementAt(12).toString().trim();
                                        
                    request.setAttribute("assessmentId",assessmentId);
                    request.setAttribute("studentId",studentId);
                    request.setAttribute("subjectId",subjectId);
                    request.setAttribute("sessionId",sessionId);
                    request.setAttribute("classId",classId);
                    request.setAttribute("termId",termId);
                    request.setAttribute("test1",test1);
                    request.setAttribute("test2",test2);
                    request.setAttribute("exam",exam);
                    request.setAttribute("developmentId",developmentId);
                    request.setAttribute("sportId",sportId);
                    request.setAttribute("ctimeId",ctimeId);
                    request.setAttribute("certificateId",certificateId);
                    
                    getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
                }

            }


        }catch(Exception ex){
            request.setAttribute("message", ex.getLocalizedMessage());
            request.setAttribute("class", ex.getClass());
            request.setAttribute("cause", ex.getCause());

            getServletContext().getRequestDispatcher("/exception.jsp").forward(request, response);
         
        } finally { 
            out.close();
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
