/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.ExamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bin Sunusi
 */
public class ExamServlet extends HttpServlet {
   
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
            String button = request.getParameter("buttonSubmit").trim();
            String examId = request.getParameter("textExamId").trim();
            String examName = request.getParameter("textExamName").trim();
            String question = request.getParameter("textQuestion").trim();
            String passMark = request.getParameter("textPassMark").trim();
            String sessionId = request.getParameter("comboSessionId").trim();
            String classId = request.getParameter("comboClassId").trim();
            String subjectId = request.getParameter("comboSubjectId").trim();
            String termId = request.getParameter("comboTermId").trim();

            if(button.equals("Add Record")){

                int status = ExamDAO.insertRecord(examName, question, passMark, sessionId, classId, subjectId, termId);
                if(status == 0){
                    request.setAttribute("msg","Record Successfully Saved!");
                    getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                }else{
                    request.setAttribute("examName", examName);
                    request.setAttribute("question", question);
                    request.setAttribute("passMark", passMark);
                    request.setAttribute("sessionId", sessionId);
                    request.setAttribute("classId", classId);
                    request.setAttribute("subjectId", subjectId);
                    request.setAttribute("termId", termId);

                    request.setAttribute("msg","Record Not Saved, Try Again!");
                    getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                }
            }
            else if(button.equals("Update Record")){

                int chkId = ExamDAO.checkId(examId);
                if(chkId == 0){
                        int status = ExamDAO.updateRecord(examId, examName, question, passMark, sessionId, classId, subjectId, termId);
                        if(status == 0){
                            request.setAttribute("msg","Record Successfully Updated!");
                            getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                        }else{
                            request.setAttribute("examId", examId);
                            request.setAttribute("examName", examName);
                            request.setAttribute("question", question);
                            request.setAttribute("passMark", passMark);
                            request.setAttribute("sessionId", sessionId);
                            request.setAttribute("classId", classId);
                            request.setAttribute("subjectId", subjectId);
                            request.setAttribute("termId", termId);

                            request.setAttribute("msg","Record Not Updated, Try Again!");
                            getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                        }
                }else{
                            request.setAttribute("examId", examId);
                            request.setAttribute("examName", examName);
                            request.setAttribute("question", question);
                            request.setAttribute("passMark", passMark);
                            request.setAttribute("sessionId", sessionId);
                            request.setAttribute("classId", classId);
                            request.setAttribute("subjectId", subjectId);
                            request.setAttribute("termId", termId);

                            request.setAttribute("msg","Exam Does not Exist, Try Again!");
                            getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                }
            }
            else if(button.equals("Delete Record")){

                int chkId = ExamDAO.checkId(examId);
                if(chkId == 0){
                        int status = ExamDAO.deleteRecord(examId);
                        if(status == 0){
                            request.setAttribute("msg","Record Successfully Deleted!");
                            getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                        }else{
                            request.setAttribute("examId", examId);
                            request.setAttribute("examName", examName);
                            request.setAttribute("question", question);
                            request.setAttribute("passMark", passMark);
                            request.setAttribute("sessionId", sessionId);
                            request.setAttribute("classId", classId);
                            request.setAttribute("subjectId", subjectId);
                            request.setAttribute("termId", termId);

                            request.setAttribute("msg","Record Not Deleted, Try Again!");
                            getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                        }
                }else{
                            request.setAttribute("examId", examId);
                            request.setAttribute("examName", examName);
                            request.setAttribute("question", question);
                            request.setAttribute("passMark", passMark);
                            request.setAttribute("sessionId", sessionId);
                            request.setAttribute("classId", classId);
                            request.setAttribute("subjectId", subjectId);
                            request.setAttribute("termId", termId);

                            request.setAttribute("msg","Exam Does not Exist, Try Again!");
                            getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                }
            }
            else if(button.equals("Load Record")){
                examId = request.getParameter("comboLoad").trim();
                Vector vector = ExamDAO.loadRecord(examId);
                if(!vector.isEmpty()){
                    examId = vector.elementAt(0).toString().trim();
                    examName = vector.elementAt(1).toString().trim();
                    question = vector.elementAt(2).toString().trim();
                    passMark = vector.elementAt(3).toString().trim();
                    sessionId = vector.elementAt(4).toString().trim();
                    classId = vector.elementAt(5).toString().trim();
                    subjectId = vector.elementAt(6).toString().trim();
                    termId = vector.elementAt(7).toString().trim();

                    request.setAttribute("examId", examId);
                    request.setAttribute("examName", examName);
                    request.setAttribute("question", question);
                    request.setAttribute("passMark", passMark);
                    request.setAttribute("sessionId", sessionId);
                    request.setAttribute("classId", classId);
                    request.setAttribute("subjectId", subjectId);
                    request.setAttribute("termId", termId);

                    getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/exam.jsp").forward(request, response);
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
