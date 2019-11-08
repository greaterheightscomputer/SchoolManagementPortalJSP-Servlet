/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import encript.EPassword;
import gtr.DAO.UserDAO;
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
public class UserServlet extends HttpServlet {
   
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

                 if(button.equals("Add Record")){
                String username = request.getParameter("textUsername").trim();
                String password = request.getParameter("textPassword").trim();
                String staffId = request.getParameter("comboStaffId").trim();
                String profileId = request.getParameter("comboProfileId").trim();

                String encriptedPwd = EPassword.digestValue(password, "MD5");

                int chkId = UserDAO.checkId(username);
                if(chkId != 0){
                    int status = UserDAO.insertRecord(username, encriptedPwd, staffId, profileId);
                    if(status == 0){

                        request.setAttribute("msg", "User Successfully Saved!");
                        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);

                    }else{
                        request.setAttribute("username", username);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("profileId", profileId);

                        request.setAttribute("msg", "User Cannot be Saved, Try again!");
                        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("username", username);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("profileId", profileId);

                        request.setAttribute("msg", "Username "+username+" Already Exist, Try again!");
                        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
                }

            }
            else if(button.equals("Delete Record")){
                String username = request.getParameter("textUsername").trim();
                String password = request.getParameter("textPassword").trim();
                String staffId = request.getParameter("comboStaffId").trim();
                String profileId = request.getParameter("comboProfileId").trim();

//                String encriptedPwd = EPassword.digestValue(password, "MD5");

                int chkId = UserDAO.checkId(username);
                if(chkId == 0){
                    int status = UserDAO.deleteRecord(username);
                    if(status == 0){

                        request.setAttribute("msg", "User Successfully Deleted!");
                        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);

                    }else{
                        request.setAttribute("username", username);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("profileId", profileId);

                        request.setAttribute("msg", "User Cannot be Deleted, Try again!");
                        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("username", username);
                        request.setAttribute("staffId", staffId);
                        request.setAttribute("profileId", profileId);

                        request.setAttribute("msg", "Username "+username+" Does not Exist, Try again!");
                        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
                }

            }
            else if(button.equals("Load Record")){

                String comboId = request.getParameter("comboLoad").trim();

                Vector vector = UserDAO.loadRecord(comboId);
                if(!vector.isEmpty()){
                    String username = vector.elementAt(0).toString().trim();
                    String staffId = vector.elementAt(1).toString().trim();
                    String profileId = vector.elementAt(2).toString().trim();
                    String status = vector.elementAt(3).toString().trim();

//                    int profile = UserDAO.getProfileStatus(userProfile);


                   request.setAttribute("username", username);
                   request.setAttribute("staffId", staffId);
                   request.setAttribute("profileId",profileId);
                    request.setAttribute("status", status);
//                    request.setAttribute("profileStatus", String.valueOf(profile));
                    getServletContext().getRequestDispatcher("/user.jsp").forward(request,response);
                }else{
                    request.setAttribute("msg","Username Does not Exist Try Again!");
                    getServletContext().getRequestDispatcher("/user.jsp").forward(request,response);
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
