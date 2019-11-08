/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.CtimeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bun Sunusi
 */
public class CtimeServlet extends HttpServlet {
   
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

            String ctimeId = request.getParameter("textCtimeId").trim();
            String studentId = request.getParameter("textStudentId").trim();
            String sessionId = request.getParameter("comboSessionId").trim();
            String classId = request.getParameter("comboClassId").trim();
            String termId = request.getParameter("comboTermId").trim();
            String timePresentinSchool = request.getParameter("textTimePresentinSchool").trim();
            String timeAbsentinSchool = request.getParameter("textTimeAbsentinSchool").trim();
            String timePresentinSport = request.getParameter("textTimePresentinSport").trim();
            String timeAbsentinSport = request.getParameter("textTimeAbsentinSport").trim();
            String greenN0 = request.getParameter("textGreenN0").trim();
            String greenDeed = request.getParameter("textGreenDeed").trim();
            String redN0 = request.getParameter("textRedN0").trim();
            String redDeed = request.getParameter("textRedDeed").trim();
            String comments = request.getParameter("textComments").trim();
            String cleanlinessRating = request.getParameter("textCleanlinessRating").trim();
            String remarks = request.getParameter("textRemarks").trim();
           
//            out.print(ctimeId+"<br>");
//            out.print(studentId+"<br>");
//            out.print(timePresentinSchool+"<br>");
//            out.print(timeAbsentinSchool+"<br>");
//            out.print(timePresentinSport+"<br>");
//            out.print(timeAbsentinSport+"<br>");
//            out.print(greenN0+"<br>");
//            out.print(greenDeed+"<br>");
//            out.print(redN0+"<br>");
//            out.print(redDeed+"<br>");
//            out.print(comments+"<br>");
//            out.print(cleanlinessRating+"<br>");
//            out.print(remarks+"<br>");

             if(button.equals("Add Record")){

                int chkId = CtimeDAO.checkId(ctimeId);
                if(chkId != 0){

                    int status = CtimeDAO.insertRecord(ctimeId, studentId, sessionId, classId, termId, timePresentinSchool, timeAbsentinSchool, timePresentinSport, timeAbsentinSport, greenN0, greenDeed, redN0, redDeed, comments, cleanlinessRating, remarks);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                    }else{
                        request.setAttribute("ctimeId", ctimeId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("timePresentinSchool", timePresentinSchool);
                        request.setAttribute("timeAbsentinSchool", timeAbsentinSchool);
                        request.setAttribute("timePresentinSport", timePresentinSport);
                        request.setAttribute("timeAbsentinSport", timeAbsentinSport);
                        request.setAttribute("greenN0", greenN0);
                        request.setAttribute("greenDeed", greenDeed);
                        request.setAttribute("redN0", redN0);
                        request.setAttribute("redDeed", redDeed);
                        request.setAttribute("comments", comments);
                        request.setAttribute("cleanlinessRating", cleanlinessRating);
                        request.setAttribute("remarks", remarks);

                        request.setAttribute("msg","Record Not Saved, Try Again!");
                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                    }
                }
                    else{
                        request.setAttribute("msg", "ctimeId" +ctimeId+ " Already Exist!" );
                        request.setAttribute("ctimeId", ctimeId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("timePresentinSchool", timePresentinSchool);
                        request.setAttribute("timeAbsentinSchool", timeAbsentinSchool);
                        request.setAttribute("timePresentinSport", timePresentinSport);
                        request.setAttribute("timeAbsentinSport", timeAbsentinSport);
                        request.setAttribute("greenN0", greenN0);
                        request.setAttribute("greenDeed", greenDeed);
                        request.setAttribute("redN0", redN0);
                        request.setAttribute("redDeed", redDeed);
                        request.setAttribute("comments", comments);
                        request.setAttribute("cleanlinessRating", cleanlinessRating);
                        request.setAttribute("remarks", remarks);

                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                }
                 }
            else if(button.equals("Update Record")){

                int chkId = CtimeDAO.checkId(ctimeId);
                if(chkId == 0){
                    int status = CtimeDAO.updateRecord(ctimeId, studentId, sessionId, classId, termId, timePresentinSchool, timeAbsentinSchool, timePresentinSport, timeAbsentinSport, greenN0, greenDeed, redN0, redDeed, comments, cleanlinessRating, remarks);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Updated!");
                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                    }else{
                        request.setAttribute("ctimeId", ctimeId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("timePresentinSchool", timePresentinSchool);
                        request.setAttribute("timeAbsentinSchool", timeAbsentinSchool);
                        request.setAttribute("timePresentinSport", timePresentinSport);
                        request.setAttribute("timeAbsentinSport", timeAbsentinSport);
                        request.setAttribute("greenN0", greenN0);
                        request.setAttribute("greenDeed", greenDeed);
                        request.setAttribute("redN0", redN0);
                        request.setAttribute("redDeed", redDeed);
                        request.setAttribute("comments", comments);
                        request.setAttribute("cleanlinessRating", cleanlinessRating);
                        request.setAttribute("remarks", remarks);

                        request.setAttribute("msg","Record Not Updated, Try Again!");
                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("ctimeId", ctimeId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("timePresentinSchool", timePresentinSchool);
                        request.setAttribute("timeAbsentinSchool", timeAbsentinSchool);
                        request.setAttribute("timePresentinSport", timePresentinSport);
                        request.setAttribute("timeAbsentinSport", timeAbsentinSport);
                        request.setAttribute("greenN0", greenN0);
                        request.setAttribute("greenDeed", greenDeed);
                        request.setAttribute("redN0", redN0);
                        request.setAttribute("redDeed", redDeed);
                        request.setAttribute("comments", comments);
                        request.setAttribute("cleanlinessRating", cleanlinessRating);
                        request.setAttribute("remarks", remarks);

                        request.setAttribute("msg","Ctime Id Does not Exist, Try Again!");
                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                }
            }

            else if(button.equals("Delete Record")){

                int chkId = CtimeDAO.checkId(ctimeId);
                if(chkId == 0){
                    int status = CtimeDAO.deleteRecord(ctimeId);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Deleted!");
                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                    }else{
                        request.setAttribute("ctimeId", ctimeId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("timePresentinSchool", timePresentinSchool);
                        request.setAttribute("timeAbsentinSchool", timeAbsentinSchool);
                        request.setAttribute("timePresentinSport", timePresentinSport);
                        request.setAttribute("timeAbsentinSport", timeAbsentinSport);
                        request.setAttribute("greenN0", greenN0);
                        request.setAttribute("greenDeed", greenDeed);
                        request.setAttribute("redN0", redN0);
                        request.setAttribute("redDeed", redDeed);
                        request.setAttribute("comments", comments);
                        request.setAttribute("cleanlinessRating", cleanlinessRating);
                        request.setAttribute("remarks", remarks);

                        request.setAttribute("msg","Record Not Deleted, Try Again!");
                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("ctimeId", ctimeId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("timePresentinSchool", timePresentinSchool);
                        request.setAttribute("timeAbsentinSchool", timeAbsentinSchool);
                        request.setAttribute("timePresentinSport", timePresentinSport);
                        request.setAttribute("timeAbsentinSport", timeAbsentinSport);
                        request.setAttribute("greenN0", greenN0);
                        request.setAttribute("greenDeed", greenDeed);
                        request.setAttribute("redN0", redN0);
                        request.setAttribute("redDeed", redDeed);
                        request.setAttribute("comments", comments);
                        request.setAttribute("cleanlinessRating", cleanlinessRating);
                        request.setAttribute("remarks", remarks);

                       request.setAttribute("msg","Ctime Id Does not Exist, Try Again!");
                       getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
                }

            }
            else if(button.equals("Load Record")){

                ctimeId = request.getParameter("comboLoad").trim();
                Vector vector = CtimeDAO.loadRecord(ctimeId);
                if(!vector.isEmpty()){

                    ctimeId = vector.elementAt(0).toString().trim();
                    studentId = vector.elementAt(1).toString().trim();
                    sessionId = vector.elementAt(2).toString().trim();
                    classId = vector.elementAt(3).toString().trim();
                    termId = vector.elementAt(4).toString().trim();
                    timePresentinSchool = vector.elementAt(5).toString().trim();
                    timeAbsentinSchool = vector.elementAt(6).toString().trim();
                    timePresentinSport = vector.elementAt(7).toString().trim();
                    timeAbsentinSport = vector.elementAt(8).toString().trim();
                    greenN0 = vector.elementAt(9).toString().trim();
                    greenDeed = vector.elementAt(10).toString().trim();
                    redN0 = vector.elementAt(11).toString().trim();
                    redDeed = vector.elementAt(12).toString().trim();
                    comments = vector.elementAt(13).toString().trim();
                    cleanlinessRating = vector.elementAt(14).toString().trim();
                    remarks = vector.elementAt(15).toString().trim();

                        request.setAttribute("ctimeId", ctimeId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("timePresentinSchool", timePresentinSchool);
                        request.setAttribute("timeAbsentinSchool", timeAbsentinSchool);
                        request.setAttribute("timePresentinSport", timePresentinSport);
                        request.setAttribute("timeAbsentinSport", timeAbsentinSport);
                        request.setAttribute("greenN0", greenN0);
                        request.setAttribute("greenDeed", greenDeed);
                        request.setAttribute("redN0", redN0);
                        request.setAttribute("redDeed", redDeed);
                        request.setAttribute("comments", comments);
                        request.setAttribute("cleanlinessRating", cleanlinessRating);
                        request.setAttribute("remarks", remarks);

                        getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/add_ctime.jsp").forward(request, response);
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
