/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.AnswerDAO;
import gtr.DAO.AssessmentDAO;
import gtr.DAO.ExamDAO;
import gtr.DAO.ExamQuestionDAO;
import gtr.DAO.ExamScoreDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bin Sunusi
 */
public class ExamCenterServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ResultSet rs = null;
   HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            session = request.getSession();

            rs = (ResultSet)session.getAttribute("rs");

            String eId = (String)session.getAttribute("examId");
            String stId = (String)session.getAttribute("studentId");

            String score;
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            String button = request.getParameter("buttonSubmit").trim();
            if(button.equals("Start Exam")){

                    if(rs.next()){

                        String questionId = rs.getString("iExamQuestionId").trim();
                        String question = rs.getString("vExamQuestion").trim();
                        String optionA = rs.getString("vAnswer01").trim();
                        String optionB = rs.getString("vAnswer02").trim();
                        String optionC = rs.getString("vAnswer03").trim();
                        String optionD = rs.getString("vAnswer04").trim();
                        String answer = rs.getString("vCorrectAnswer").trim();
                        String mark = rs.getString("iMark").trim();
                        String examId = rs.getString("iExamId").trim();

                        request.setAttribute("questionId", questionId);
                        request.setAttribute("question", question);
                        request.setAttribute("optionA", optionA);
                        request.setAttribute("optionB", optionB);
                        request.setAttribute("optionC", optionC);
                        request.setAttribute("optionD", optionD);
                        request.setAttribute("answer", answer);
                        request.setAttribute("mark", mark);
                        request.setAttribute("examId", examId);
                        request.setAttribute("rowN", String.valueOf(rs.getRow()));

                        if(rs.isLast()){
                            request.setAttribute("isLast", "isLast");
                        }
                        if(rs.isFirst()){
                            request.setAttribute("isFirst", "isFirst");
                        }
                        getServletContext().getRequestDispatcher("/exam_center.jsp").forward(request, response);
                    }
            }

            else if(button.equals("Next"))
            {
                String examQuestionId = request.getParameter("textId").trim();
                String examQuestion = request.getParameter("textQuestion").trim();
                String qmark = request.getParameter("textMark").trim();
                String answ;
                if(request.getParameter("radio") == null){
                    answ = "NULL";
                }else{
                    answ = request.getParameter("radio").trim();
                }

                int xx = AnswerDAO.checkId(examQuestionId,eId,stId);
                if(xx != 0){
                    AnswerDAO.insertRecord(examQuestionId, eId, stId, examQuestion, answ);
                }else{
                    AnswerDAO.updateRecord(examQuestionId, answ);
                }

                int es = ExamScoreDAO.checkId(eId, stId, examQuestionId);
                if(es != 0){

                    if(answ.equals(ExamQuestionDAO.getCorrectAnswer(examQuestionId,eId))){
                        ExamScoreDAO.insertRecord(eId, stId, examQuestionId, qmark, date);
                    }else{
                        ExamScoreDAO.insertRecord(eId, stId, examQuestionId,"0",date);
                    }

                }else{
                    if(answ.equalsIgnoreCase(ExamQuestionDAO.getCorrectAnswer(examQuestionId,eId))){
                        ExamScoreDAO.updateScore(eId, stId, examQuestionId, qmark);
                    }else{
                        ExamScoreDAO.updateScore(eId, stId, examQuestionId,"0");
                    }
                }


                    if(rs.next()){

                        String questionId = rs.getString("iExamQuestionId").trim();
                        String question = rs.getString("vExamQuestion").trim();
                        String optionA = rs.getString("vAnswer01").trim();
                        String optionB = rs.getString("vAnswer02").trim();
                        String optionC = rs.getString("vAnswer03").trim();
                        String optionD = rs.getString("vAnswer04").trim();
                        String answer = rs.getString("vCorrectAnswer").trim();
                        String mark = rs.getString("iMark").trim();
                        String examId = rs.getString("iExamId").trim();

                        int x = AnswerDAO.checkId(questionId,eId,stId);
                        if(x != 0){

                        }else{
                            request.setAttribute("realA", AnswerDAO.loadQuestion(stId, questionId,question));
                        }

                        request.setAttribute("questionId", questionId);
                        request.setAttribute("question", question);
                        request.setAttribute("optionA", optionA);
                        request.setAttribute("optionB", optionB);
                        request.setAttribute("optionC", optionC);
                        request.setAttribute("optionD", optionD);
                        request.setAttribute("answer", answer);
                        request.setAttribute("mark", mark);
                        request.setAttribute("examId", examId);
                        request.setAttribute("rowN", String.valueOf(rs.getRow()));

                        request.setAttribute("realA", AnswerDAO.loadQuestion(stId, questionId,question));

                        if(rs.isLast()){
                            request.setAttribute("isLast", "isLast");
                        }
                        if(rs.isFirst()){
                            request.setAttribute("isFirst", "isFirst");
                        }

                        getServletContext().getRequestDispatcher("/exam_center.jsp").forward(request, response);

                    }

            }
            else if(button.equals("Previous"))
            {
                if(rs.previous()){

                        String questionId = rs.getString("iExamQuestionId").trim();
                        String question = rs.getString("vExamQuestion").trim();
                        String optionA = rs.getString("vAnswer01").trim();
                        String optionB = rs.getString("vAnswer02").trim();
                        String optionC = rs.getString("vAnswer03").trim();
                        String optionD = rs.getString("vAnswer04").trim();
                        String answer = rs.getString("vCorrectAnswer").trim();
                        String mark = rs.getString("iMark").trim();
                        String examId = rs.getString("iExamId").trim();

                        request.setAttribute("realA", AnswerDAO.loadQuestion(stId, questionId,question));


                        request.setAttribute("questionId", questionId);
                        request.setAttribute("question", question);
                        request.setAttribute("optionA", optionA);
                        request.setAttribute("optionB", optionB);
                        request.setAttribute("optionC", optionC);
                        request.setAttribute("optionD", optionD);
                        request.setAttribute("answer", answer);
                        request.setAttribute("mark", mark);
                        request.setAttribute("examId", examId);
                        request.setAttribute("rowN", String.valueOf(rs.getRow()));

                        if(rs.isLast()){
                            request.setAttribute("isLast", "isLast");
                        }
                        if(rs.isFirst()){
                            request.setAttribute("isFirst", "isFirst");
                        }

                        getServletContext().getRequestDispatcher("/exam_center.jsp").forward(request, response);

                    }
            }
            else if(button.equals("End Exam"))
            {

                String eqId = request.getParameter("textId").trim();
                String eQues = request.getParameter("textQuestion").trim();
                String qmark = request.getParameter("textMark").trim();
                String answ;
                if(request.getParameter("radio") == null){
                    answ = "NULL";
                }else{
                    answ = request.getParameter("radio").trim();
                }

                int xx = AnswerDAO.checkId(eqId,eId,stId);
                if(xx != 0){
                    AnswerDAO.insertRecord(eqId, eId, stId, eQues, answ);
                }else{
                    AnswerDAO.updateRecord(eqId, answ);
                }

                int es = ExamScoreDAO.checkId(eId, stId, eqId);
                if(es != 0){

                    if(answ.equals(ExamQuestionDAO.getCorrectAnswer(eqId,eId))){
                        ExamScoreDAO.insertRecord(eId, stId, eqId, qmark,date);
                    }else{
                        ExamScoreDAO.insertRecord(eId, stId, eqId,"0",date);
                    }

                }else{
                    if(answ.equalsIgnoreCase(ExamQuestionDAO.getCorrectAnswer(eqId,eId))){
                        ExamScoreDAO.updateScore(eId, stId, eqId, qmark);
                    }else{
                        ExamScoreDAO.updateScore(eId, stId, eqId,"0");
                    }
                }

                AnswerDAO.deleteRecord(stId);

                int pm = ExamDAO.getPassMark(eId);
                int us = ExamScoreDAO.getTotalScore(eId, stId);
                String remark;

                request.setAttribute("passMark", String.valueOf(pm));
                request.setAttribute("score", String.valueOf(us));
                request.setAttribute("examId", eId);
                request.setAttribute("studentId", stId);

                if(pm > us){
                     request.setAttribute("remark", "FAILED");
                }else{
                     request.setAttribute("remark", "PASSED");
                }

                String classId = ExamDAO.getClassId(eId);
                String subjectId = ExamDAO.getSubjectId(eId);
                String termId = ExamDAO.getTermId(eId);

                AssessmentDAO.addExamScore(stId, subjectId, classId, termId, String.valueOf(us));

                int total = AssessmentDAO.getTotal(stId, subjectId, classId, termId);
                

                if(total < 50){
                    remark = "FAILED";
                }else{
                    remark = "PASSED";
                }

                AssessmentDAO.updateRemark(stId, subjectId, classId, termId, remark);

                getServletContext().getRequestDispatcher("/score_summary.jsp").forward(request, response);
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
//        session = request.getSession();
//        String eId = (String)session.getAttribute("examId");
//        rs = ExamQuestionDAO.loadExam(eId);
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
//        session = request.getSession();
//        String eId = (String)session.getAttribute("examId");
//        rs = ExamQuestionDAO.loadExam(eId);
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
