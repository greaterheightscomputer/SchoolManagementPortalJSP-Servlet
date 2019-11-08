/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.SportDAO;
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
public class SportsServlet extends HttpServlet {
   
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

            String sportId = request.getParameter("textSportId").trim();
            String studentId = request.getParameter("textStudentId").trim();
            String sessionId = request.getParameter("comboSessionId").trim();
            String classId = request.getParameter("comboClassId").trim();
            String termId = request.getParameter("comboTermId").trim();
            String events = request.getParameter("textEvents").trim();
            String levelAttained = request.getParameter("textLevelAttained").trim();
            String comments = request.getParameter("textComments").trim();

//            out.print(sportId+"<br>");
//            out.print(studentId+"<br>");
//            out.print(events+"<br>");
//            out.print(levelAttained+"<br>");
//            out.print(comments+"<br>");
//            out.println("Servlet SportsServlet ");

            if(button.equals("Add Record")){

                int chkId = SportDAO.checkId(sportId);
                if(chkId != 0){

                    int status = SportDAO.insertRecord(sportId, studentId, sessionId, classId, termId, events, levelAttained, comments);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                    }else{
                        request.setAttribute("sportId", sportId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("events", events);
                        request.setAttribute("levelAttained", levelAttained);
                        request.setAttribute("comments", comments);

                        request.setAttribute("msg","Record Not Saved, Try Again!");
                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                    }
                }
                    else{
                        request.setAttribute("msg", "sportId" +sportId+ " Already Exist!" );
                        request.setAttribute("sportId", sportId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("events", events);
                        request.setAttribute("levelAttained", levelAttained);
                        request.setAttribute("comments", comments);

                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                }
                }
            else if(button.equals("Update Record")){

                int chkId = SportDAO.checkId(sportId);
                if(chkId == 0){
                    int status = SportDAO.updateRecord(sportId, studentId, sessionId, classId, termId, events, levelAttained, comments);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Updated!");
                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                    }else{
                        request.setAttribute("sportId", sportId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("events", events);
                        request.setAttribute("levelAttained", levelAttained);
                        request.setAttribute("comments", comments);

                        request.setAttribute("msg","Record Not Updated, Try Again!");
                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                    }
                }else{
                       request.setAttribute("sportId", sportId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("events", events);
                        request.setAttribute("levelAttained", levelAttained);
                        request.setAttribute("comments", comments);

                        request.setAttribute("msg","Sport Id Does not Exist, Try Again!");
                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                }
            }

            else if(button.equals("Delete Record")){

                int chkId = SportDAO.checkId(sportId);
                if(chkId == 0){
                    int status = SportDAO.deleteRecord(sportId);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Deleted!");
                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                    }else{
                        request.setAttribute("sportId", sportId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("events", events);
                        request.setAttribute("levelAttained", levelAttained);
                        request.setAttribute("comments", comments);

                        request.setAttribute("msg","Record Not Deleted, Try Again!");
                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("sportId", sportId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("events", events);
                        request.setAttribute("levelAttained", levelAttained);
                        request.setAttribute("comments", comments);

                       request.setAttribute("msg","Sport Id Does not Exist, Try Again!");
                       getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                }

            }
            else if(button.equals("Load Record")){

                sportId = request.getParameter("comboLoad").trim();
                Vector vector = SportDAO.loadRecord(sportId);
                if(!vector.isEmpty()){

                    sportId = vector.elementAt(0).toString().trim();
                    studentId = vector.elementAt(1).toString().trim();
                    sessionId = vector.elementAt(2).toString().trim();
                    classId = vector.elementAt(3).toString().trim();
                    termId = vector.elementAt(4).toString().trim();
                    events = vector.elementAt(5).toString().trim();
                    levelAttained = vector.elementAt(6).toString().trim();
                    comments = vector.elementAt(7).toString().trim();

                        request.setAttribute("sportId", sportId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("events", events);
                        request.setAttribute("levelAttained", levelAttained);
                        request.setAttribute("comments", comments);

                        getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/add_sport.jsp").forward(request, response);
                }

            }

        }catch(Exception ex){
            request.setAttribute("message", ex.getLocalizedMessage());
            request.setAttribute("class", ex.getClass());
            request.setAttribute("cause", ex.getCause());

            getServletContext().getRequestDispatcher("/exception.jsp").forward(request, response);

            }

         finally { 
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
