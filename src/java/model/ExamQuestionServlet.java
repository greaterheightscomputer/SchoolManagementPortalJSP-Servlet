/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.ExamQuestionDAO;
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
public class ExamQuestionServlet extends HttpServlet {
   
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

            String questionId = request.getParameter("textQuestionId").trim();
            String question = request.getParameter("textQuestion").trim();
            String optionA = request.getParameter("textOptionA").trim();
            String optionB = request.getParameter("textOptionB").trim();
            String optionC = request.getParameter("textOptionC").trim();
            String optionD = request.getParameter("textOptionD").trim();
            String answer = request.getParameter("textCorrectAnswer").trim();
            String mark = request.getParameter("textMark").trim();
            String examId = request.getParameter("comboExamId").trim();
            
            if(button.equals("Add Record")){

                int status = ExamQuestionDAO.insertRecord(question, optionA, optionB, optionC, optionD, answer, mark, examId);
                if(status == 0){
                    request.setAttribute("msg","Record Successfully Saved!");
                    getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
                }else{
                    request.setAttribute("question", question);
                    request.setAttribute("optionA", optionA);
                    request.setAttribute("optionB", optionB);
                    request.setAttribute("optionC", optionC);
                    request.setAttribute("optionD", optionD);
                    request.setAttribute("answer", answer);
                    request.setAttribute("mark", mark);
                    request.setAttribute("examId", examId);

                    request.setAttribute("msg","Record Not Saved, Try Again!");
                    getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
                }
            }

             else if(button.equals("Update Record")){
                int chkId = ExamQuestionDAO.checkId(questionId);
                if(chkId == 0){
                        int status = ExamQuestionDAO.updateRecord(questionId,question, optionA, optionB, optionC, optionD, answer, mark, examId);
                        if(status == 0){
                            request.setAttribute("msg","Record Successfully Updated!");
                            getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
                        }else{
                            request.setAttribute("questionId", questionId);
                            request.setAttribute("question", question);
                            request.setAttribute("optionA", optionA);
                            request.setAttribute("optionB", optionB);
                            request.setAttribute("optionC", optionC);
                            request.setAttribute("optionD", optionD);
                            request.setAttribute("answer", answer);
                            request.setAttribute("mark", mark);
                            request.setAttribute("examId", examId);

                            request.setAttribute("msg","Record Not Updated, Try Again!");
                            getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
                        }
                }else{
                            request.setAttribute("questionId", questionId);
                            request.setAttribute("question", question);
                            request.setAttribute("optionA", optionA);
                            request.setAttribute("optionB", optionB);
                            request.setAttribute("optionC", optionC);
                            request.setAttribute("optionD", optionD);
                            request.setAttribute("answer", answer);
                            request.setAttribute("mark", mark);
                            request.setAttribute("examId", examId);

                            request.setAttribute("msg","Question Id Does not Exist, Try Again!");
                            getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
                }
            }

            else if(button.equals("Delete Record")){
                int chkId = ExamQuestionDAO.checkId(questionId);
                if(chkId == 0){
                        int status = ExamQuestionDAO.deleteRecord(questionId);
                        if(status == 0){
                            request.setAttribute("msg","Record Successfully Deleted!");
                            getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
                        }else{
                            request.setAttribute("questionId", questionId);
                            request.setAttribute("question", question);
                            request.setAttribute("optionA", optionA);
                            request.setAttribute("optionB", optionB);
                            request.setAttribute("optionC", optionC);
                            request.setAttribute("optionD", optionD);
                            request.setAttribute("answer", answer);
                            request.setAttribute("mark", mark);
                            request.setAttribute("examId", examId);

                            request.setAttribute("msg","Record Not Deleted, Try Again!");
                            getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
                        }
                }else{
                            request.setAttribute("questionId", questionId);
                            request.setAttribute("question", question);
                            request.setAttribute("optionA", optionA);
                            request.setAttribute("optionB", optionB);
                            request.setAttribute("optionC", optionC);
                            request.setAttribute("optionD", optionD);
                            request.setAttribute("answer", answer);
                            request.setAttribute("mark", mark);
                            request.setAttribute("examId", examId);

                            request.setAttribute("msg","Question Id Does not Exist, Try Again!");
                            getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
                }
            }

            else if(button.equals("Load Record")){

                questionId = request.getParameter("comboLoad").trim();
                Vector vector = ExamQuestionDAO.loadRecord(questionId);
                if(!vector.isEmpty()){
                    questionId = vector.elementAt(0).toString().trim();
                    question = vector.elementAt(1).toString().trim();
                    optionA = vector.elementAt(2).toString().trim();
                    optionB = vector.elementAt(3).toString().trim();
                    optionC = vector.elementAt(4).toString().trim();
                    optionD = vector.elementAt(5).toString().trim();
                    answer = vector.elementAt(6).toString().trim();
                    mark = vector.elementAt(7).toString().trim();
                    examId = vector.elementAt(8).toString().trim();

                    request.setAttribute("questionId", questionId);
                            request.setAttribute("question", question);
                            request.setAttribute("optionA", optionA);
                            request.setAttribute("optionB", optionB);
                            request.setAttribute("optionC", optionC);
                            request.setAttribute("optionD", optionD);
                            request.setAttribute("answer", answer);
                            request.setAttribute("mark", mark);
                            request.setAttribute("examId", examId);
                            getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/exam_question.jsp").forward(request, response);
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
