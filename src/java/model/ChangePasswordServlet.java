/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import encript.EPassword;
import gtr.DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bin Sunusi
 */
public class ChangePasswordServlet extends HttpServlet {
   
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
            if(button == null){
                button = "";
            }

            String oldPassword = request.getParameter("textOldPassword").trim();
            if(oldPassword == null){
                oldPassword = "";
            }
            String NewPassword = request.getParameter("textPassword").trim();
            if(NewPassword == null){
                NewPassword = "";
            }
            String username = request.getParameter("textUsername").trim();
            if(username == null){
                username = "";
            }

            String eOldPassword = EPassword.digestValue(oldPassword,"MD5");
            String eNewPassword = EPassword.digestValue(NewPassword,"MD5");

            if(button.equals("Change Default Password")){

                int chkOldPassword = UserDAO.checkOldPassword(username, eOldPassword);
                if(chkOldPassword == 0){
                    int status = UserDAO.changeDefaultPassword(username, eNewPassword);
                    if(status == 0){
                        getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
                    }else{
                        request.setAttribute("msg","Password cannot be changed Try Again!");
                        getServletContext().getRequestDispatcher("/default-password.jsp").forward(request,response);
                    }

                }else{
                    request.setAttribute("msg","Wrong Old Password!");
                    getServletContext().getRequestDispatcher("/default-password.jsp").forward(request,response);
                }

            }
            else if(button.equals("Change Password")){

                int chkOldPassword = UserDAO.checkOldPassword(username, eOldPassword);
                if(chkOldPassword == 0){
                    int status = UserDAO.changePassword(username, eNewPassword);
                    if(status == 0){
                        request.setAttribute("msg","Password Successfully changed!");
                        getServletContext().getRequestDispatcher("/change-password.jsp").forward(request,response);
                    }else{
                        request.setAttribute("msg","Password cannot be changed Try Again!");
                        getServletContext().getRequestDispatcher("/change-password.jsp").forward(request,response);
                    }

                }else{
                    request.setAttribute("msg","Wrong Old Password!");
                    getServletContext().getRequestDispatcher("/change-password.jsp").forward(request,response);
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
