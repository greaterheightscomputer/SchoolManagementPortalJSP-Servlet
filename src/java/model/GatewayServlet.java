/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.sms.DAO.SMSUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sms.gateway.Gateway;

/**
 *
 * @author Bun Sunusi
 */
public class GatewayServlet extends HttpServlet {
   
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

//            String username = request.getParameter("textusername").trim();
//            String password = request.getParameter("textpassword").trim();
//            String sender = request.getParameter("textsender").trim();
//            String number = request.getParameter("textnumber").trim();
//            String message = request.getParameter("textmessage").trim();

            String comboLoad = request.getParameter("comboLoad").trim();
          

            String host = (String)session.getAttribute("host");
            String username = SMSUserDAO.getUsername().trim();
            String password = SMSUserDAO.getPassword().trim();
            String sender = (String)session.getAttribute("sender");
            String number = (String)session.getAttribute("number");
            String message = (String)session.getAttribute("message");
            
            if(button.equals("Send SMS")){

             int checkUser = SMSUserDAO.getStatus();
            if(checkUser == 0){
            String status = sms.gateway.Gateway.sendSMS(host, username, password, sender, number, message);
                        if(status != null)
                    {
                        request.setAttribute("msg","SUCCESS TRANACTION!");
                        getServletContext().getRequestDispatcher("/gateway.jsp").forward(request, response);
                    }else{
                        request.setAttribute("username",username);
                        request.setAttribute("password",password);
                        request.setAttribute("sender",sender);
                        request.setAttribute("number",number);
                        request.setAttribute("message",message);
                        
                        request.setAttribute("msg","Record cannot be Saved!");
                        getServletContext().getRequestDispatcher("/gateway.jsp").forward(request, response);
                    }

                }

            
//            else if(button.equals("Add Test 2")){
//
//                int chkStudent = StudentsDAO.checkId(studentId);
//                if(chkStudent == 0){
//
//                    int status = AssessmentDAO.addTest2(studentId, subjectId, classId, termId, test2, developmentId, sportId, ctimeId, staffId);
//                    if(status == 0){
//                        request.setAttribute("msg","Record Successfully Saved!");
//                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
//                    }else{
//                        request.setAttribute("studentId",studentId);
//                        request.setAttribute("subjectId",subjectId);
//                        request.setAttribute("classId",classId);
//                        request.setAttribute("termId",termId);
//                        request.setAttribute("test1",test1);
//                        request.setAttribute("test2",test2);
//                        request.setAttribute("exam",exam);
//                        request.setAttribute("developmentId",developmentId);
//                        request.setAttribute("sportId",sportId);
//                        request.setAttribute("ctimeId",ctimeId);
//
//                        request.setAttribute("msg","Record cannot be Saved!");
//                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
//                    }
//
//                }else{
//                        request.setAttribute("studentId",studentId);
//                        request.setAttribute("subjectId",subjectId);
//                        request.setAttribute("classId",classId);
//                        request.setAttribute("termId",termId);
//                        request.setAttribute("test1",test1);
//                        request.setAttribute("test2",test2);
//                        request.setAttribute("exam",exam);
//                        request.setAttribute("developmentId",developmentId);
//                        request.setAttribute("sportId",sportId);
//                        request.setAttribute("ctimeId",ctimeId);
//
//                        request.setAttribute("msg","Student Id "+studentId+" Does not Exist!");
//                        getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
//
//                }
//
//            }
//
//            else if(button.equals("Delete Record")){
//                int chkId = StudentsDAO.checkId(studentId);
//                if(chkId == 0){
//
//                        int status = AssessmentDAO.deleteRecord(assessmentId);
//                        if(status == 0){
//
//                            request.setAttribute("msg","Record Successfully Deleted!");
//                            getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
//                        }else{
//                            request.setAttribute("msg","Record cannot be Deleted, Try Again!");
//                            request.setAttribute("subjectId",subjectId);
//                            request.setAttribute("sessionId",sessionId);
//                            request.setAttribute("classId",classId);
//                            request.setAttribute("termId",termId);
//                            request.setAttribute("test1",test1);
//                            request.setAttribute("test2",test2);
//                            request.setAttribute("exam",exam);
//                            request.setAttribute("developmentId",developmentId);
//                            request.setAttribute("sportId",sportId);
//                            request.setAttribute("ctimeId",ctimeId);
//
//                            getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
//                        }
//                }else{
//                            request.setAttribute("msg","Student Id Does not Exist, Try Again!");
//                            request.setAttribute("studentId",studentId);
//                            request.setAttribute("subjectId",subjectId);
//                            request.setAttribute("sessionId",sessionId);
//                            request.setAttribute("classId",classId);
//                            request.setAttribute("termId",termId);
//                            request.setAttribute("test1",test1);
//                            request.setAttribute("test2",test2);
//                            request.setAttribute("exam",exam);
//                            request.setAttribute("developmentId",developmentId);
//                            request.setAttribute("sportId",sportId);
//                            request.setAttribute("ctimeId",ctimeId);
//
//                            getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
//                }
//
//            }
//
//
//            else if(button.equals("Load Record")){
//
//                Vector vector = AssessmentDAO.loadRecord(comboLoad);
//                if(!vector.isEmpty()){
//
//                    assessmentId = vector.elementAt(0).toString().trim();
//                    studentId = vector.elementAt(1).toString().trim();
//                    subjectId = vector.elementAt(2).toString().trim();
//                    sessionId = vector.elementAt(3).toString().trim();
//                    classId = vector.elementAt(4).toString().trim();
//                    termId = vector.elementAt(5).toString().trim();
//                    test1 = vector.elementAt(6).toString().trim();
//                    test2 = vector.elementAt(7).toString().trim();
//                    exam = vector.elementAt(8).toString().trim();
//                    developmentId = vector.elementAt(9).toString().trim();
//                    sportId = vector.elementAt(10).toString().trim();
//                    ctimeId = vector.elementAt(11).toString().trim();
//
//                    request.setAttribute("assessmentId",assessmentId);
//                    request.setAttribute("studentId",studentId);
//                    request.setAttribute("subjectId",subjectId);
//                    request.setAttribute("sessionId",sessionId);
//                    request.setAttribute("classId",classId);
//                    request.setAttribute("termId",termId);
//                    request.setAttribute("test1",test1);
//                    request.setAttribute("test2",test2);
//                    request.setAttribute("exam",exam);
//                    request.setAttribute("developmentId",developmentId);
//                    request.setAttribute("sportId",sportId);
//                    request.setAttribute("ctimeId",ctimeId);
//
//                    getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
//
//                }else{
//                    request.setAttribute("msg","Invalid Combo Selection!");
//                    getServletContext().getRequestDispatcher("/assessment.jsp").forward(request, response);
//                }
//
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
