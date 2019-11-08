/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.DevelopmentDAO;
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
 * @author Bun Sunusi
 */
public class DevelopmentServlet extends HttpServlet {
   
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

            String developmentId = request.getParameter("textdevelopmentId").trim();
            String studentId = request.getParameter("textstudentId").trim();
            String sessionId = request.getParameter("comboSessionId").trim();
            String classId = request.getParameter("comboClassId").trim();
            String termId = request.getParameter("comboTermId").trim();
            String hieghtBegin = request.getParameter("texthieghtBegin").trim();
            String hieghtEnd= request.getParameter("texthieghtEnd").trim();
            String weightBegin = request.getParameter("textweightBegin").trim();
            String weightEnd = request.getParameter("textweightEnd").trim();
            String daysAbsent = request.getParameter("textdaysAbsent").trim();
            String nature = request.getParameter("textnature").trim();
            String organization = request.getParameter("textorganization").trim();
            String officeHeld = request.getParameter("textofficeHeld").trim();
            String contribution = request.getParameter("textcontribution").trim();
            String principal = request.getParameter("textprincipal").trim();
            String teacher = request.getParameter("textteacher").trim();
            String vacation = request.getParameter("textvacation").trim();
            String resumption = request.getParameter("textresumption").trim();
            String comboId = request.getParameter("comboLoad").trim();
//
//           out.print(developmentId+"<br>");
//           out.print(studentId+"<br>");
//           out.print(hieghtBegin+"<br>");
//           out.print(hieghtEnd+"<br>");
//           out.print(weightBegin+"<br>");
//           out.print(weightEnd+"<br>");
//           out.print(daysAbsent+"<br>");
//           out.print(nature+"<br>");
//           out.print(organization+"<br>");
//           out.print(officeHeld+"<br>");
//           out.print(contribution+"<br>");
//           out.print(principal+"<br>");
//           out.print(teacher+"<br>");
//           out.print(vacation+"<br>");
//           out.print(resumption+"<br>");

            if(button.equals("Add Record")){

                int chkId = DevelopmentDAO.checkId(developmentId);
                if(chkId != 0){

                    int status = DevelopmentDAO.insertRecord(developmentId, studentId, sessionId, classId, termId, hieghtBegin, hieghtEnd, weightBegin, weightEnd, daysAbsent, nature, organization, officeHeld, contribution, principal, teacher, vacation, resumption);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                    }else{
                        request.setAttribute("developmentId", developmentId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("hieghtBegin", hieghtBegin);
                        request.setAttribute("hieghtEnd", hieghtEnd);
                        request.setAttribute("weightBegin", weightBegin);
                        request.setAttribute("weightEnd", weightEnd);
                        request.setAttribute("daysAbsent", daysAbsent);
                        request.setAttribute("nature", nature);
                        request.setAttribute("organization", organization);
                        request.setAttribute("officeHeld", officeHeld);
                        request.setAttribute("contribution", contribution);
                        request.setAttribute("principal", principal);
                        request.setAttribute("teacher", teacher);
                        request.setAttribute("vacation", vacation);
                        request.setAttribute("resumption", resumption);

                        request.setAttribute("msg","Record Not Saved, Try Again!");
                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                    }
                }
                    else{
                        request.setAttribute("msg", "developmentId" +developmentId+ " Already Exist!" );
                        request.setAttribute("developmentId", developmentId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("hieghtBegin", hieghtBegin);
                        request.setAttribute("hieghtEnd", hieghtEnd);
                        request.setAttribute("weightBegin", weightBegin);
                        request.setAttribute("weightEnd", weightEnd);
                        request.setAttribute("daysAbsent", daysAbsent);
                        request.setAttribute("nature", nature);
                        request.setAttribute("organization", organization);
                        request.setAttribute("officeHeld", officeHeld);
                        request.setAttribute("contribution", contribution);
                        request.setAttribute("principal", principal);
                        request.setAttribute("teacher", teacher);
                        request.setAttribute("vacation", vacation);
                        request.setAttribute("resumption", resumption);

                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                }
            }
                else if(button.equals("Update Record")){

                int chkId = DevelopmentDAO.checkId(developmentId);
                if(chkId == 0){
                    int status = DevelopmentDAO.updateRecord(developmentId, studentId, sessionId, classId, termId, hieghtBegin, hieghtEnd, weightBegin, weightEnd, daysAbsent, nature, organization, officeHeld, contribution, principal, teacher, vacation, resumption);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Updated!");
                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                    }else{
                        request.setAttribute("developmentId", developmentId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("hieghtBegin", hieghtBegin);
                        request.setAttribute("hieghtEnd", hieghtEnd);
                        request.setAttribute("weightBegin", weightBegin);
                        request.setAttribute("weightEnd", weightEnd);
                        request.setAttribute("daysAbsent", daysAbsent);
                        request.setAttribute("nature", nature);
                        request.setAttribute("organization", organization);
                        request.setAttribute("officeHeld", officeHeld);
                        request.setAttribute("contribution", contribution);
                        request.setAttribute("principal", principal);
                        request.setAttribute("teacher", teacher);
                        request.setAttribute("vacation", vacation);
                        request.setAttribute("resumption", resumption);

                        request.setAttribute("msg","Record Not Updated, Try Again!");
                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("developmentId", developmentId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("hieghtBegin", hieghtBegin);
                        request.setAttribute("hieghtEnd", hieghtEnd);
                        request.setAttribute("weightBegin", weightBegin);
                        request.setAttribute("weightEnd", weightEnd);
                        request.setAttribute("daysAbsent", daysAbsent);
                        request.setAttribute("nature", nature);
                        request.setAttribute("organization", organization);
                        request.setAttribute("officeHeld", officeHeld);
                        request.setAttribute("contribution", contribution);
                        request.setAttribute("principal", principal);
                        request.setAttribute("teacher", teacher);
                        request.setAttribute("vacation", vacation);
                        request.setAttribute("resumption", resumption);

                        request.setAttribute("msg","Development Id Does not Exist, Try Again!");
                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                }
            }

            else if(button.equals("Delete Record")){

                int chkId = DevelopmentDAO.checkId(developmentId);
                if(chkId == 0){
                    int status = DevelopmentDAO.deleteRecord(developmentId);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Deleted!");
                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                    }else{
                        request.setAttribute("developmentId", developmentId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("hieghtBegin", hieghtBegin);
                        request.setAttribute("hieghtEnd", hieghtEnd);
                        request.setAttribute("weightBegin", weightBegin);
                        request.setAttribute("weightEnd", weightEnd);
                        request.setAttribute("daysAbsent", daysAbsent);
                        request.setAttribute("nature", nature);
                        request.setAttribute("organization", organization);
                        request.setAttribute("officeHeld", officeHeld);
                        request.setAttribute("contribution", contribution);
                        request.setAttribute("principal", principal);
                        request.setAttribute("teacher", teacher);
                        request.setAttribute("vacation", vacation);
                        request.setAttribute("resumption", resumption);

                        request.setAttribute("msg","Record Not Deleted, Try Again!");
                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("developmentId", developmentId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("hieghtBegin", hieghtBegin);
                        request.setAttribute("hieghtEnd", hieghtEnd);
                        request.setAttribute("weightBegin", weightBegin);
                        request.setAttribute("weightEnd", weightEnd);
                        request.setAttribute("daysAbsent", daysAbsent);
                        request.setAttribute("nature", nature);
                        request.setAttribute("organization", organization);
                        request.setAttribute("officeHeld", officeHeld);
                        request.setAttribute("contribution", contribution);
                        request.setAttribute("principal", principal);
                        request.setAttribute("teacher", teacher);
                        request.setAttribute("vacation", vacation);
                        request.setAttribute("resumption", resumption);

                       request.setAttribute("msg","Development Id Does not Exist, Try Again!");
                       getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
                }

            }
            else if(button.equals("Load Record")){

                Vector vector = DevelopmentDAO.loadRecord(comboId);
                if(!vector.isEmpty()){

                    developmentId = vector.elementAt(0).toString().trim();
                    studentId = vector.elementAt(1).toString().trim();
                    sessionId = vector.elementAt(2).toString().trim();
                    classId = vector.elementAt(3).toString().trim();
                    termId = vector.elementAt(4).toString().trim();
                    hieghtBegin = vector.elementAt(5).toString().trim();
                    hieghtEnd = vector.elementAt(6).toString().trim();
                    weightBegin = vector.elementAt(7).toString().trim();
                    weightEnd = vector.elementAt(8).toString().trim();
                    daysAbsent = vector.elementAt(9).toString().trim();
                    nature = vector.elementAt(10).toString().trim();
                    organization = vector.elementAt(11).toString().trim();
                    officeHeld = vector.elementAt(12).toString().trim();
                    contribution = vector.elementAt(13).toString().trim();
                    principal = vector.elementAt(14).toString().trim();
                    teacher = vector.elementAt(15).toString().trim();
                    vacation = vector.elementAt(16).toString().trim();
                    resumption = vector.elementAt(17).toString().trim();

                        request.setAttribute("developmentId", developmentId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("sessionId", sessionId);
                        request.setAttribute("classId", classId);
                        request.setAttribute("termId", termId);
                        request.setAttribute("hieghtBegin", hieghtBegin);
                        request.setAttribute("hieghtEnd", hieghtEnd);
                        request.setAttribute("weightBegin", weightBegin);
                        request.setAttribute("weightEnd", weightEnd);
                        request.setAttribute("daysAbsent", daysAbsent);
                        request.setAttribute("nature", nature);
                        request.setAttribute("organization", organization);
                        request.setAttribute("officeHeld", officeHeld);
                        request.setAttribute("contribution", contribution);
                        request.setAttribute("principal", principal);
                        request.setAttribute("teacher", teacher);
                        request.setAttribute("vacation", vacation);
                        request.setAttribute("resumption", resumption);

                        getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/add_development.jsp").forward(request, response);
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
