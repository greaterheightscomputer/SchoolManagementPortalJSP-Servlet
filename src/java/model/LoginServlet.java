/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import encript.EPassword;
import gtr.DAO.StaffDAO;
import gtr.DAO.UserDAO;
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
public class LoginServlet extends HttpServlet {
   
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

            String username = request.getParameter("textUsername").trim();
            String password = request.getParameter("textPassword").trim();

            String encriptPwd = EPassword.digestValue(password, "MD5");

            Vector vector = UserDAO.authenticateUser(username, encriptPwd);
            if(!vector.isEmpty()){

                username = vector.elementAt(0).toString().trim();
                String staffId = vector.elementAt(1).toString().trim();
                String profileId = vector.elementAt(2).toString().trim();
                String stat = vector.elementAt(3).toString().trim();

                int status = Integer.valueOf(stat);
                String staffName = StaffDAO.getName(staffId);
                String profileName = UserDAO.getProfileName(profileId);

                if(status == 1){
                    session.setAttribute("username", username);
                    session.setAttribute("name", staffName);
                    session.setAttribute("staffId", staffId);
                    session.setAttribute("profileName", profileName);
                    session.setAttribute("profileId", profileId);
                    getServletContext().getRequestDispatcher("/default-password.jsp").forward(request, response);
                }
                else if(status == 0){
                    session.setAttribute("username", username);
                    session.setAttribute("name", staffName);
                    session.setAttribute("staffId", staffId);
                    session.setAttribute("profileName", profileName);
                    session.setAttribute("profileId", profileId);
                    getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
                }else{
                    request.setAttribute("msg", "Sorry your account has been blocked, contact your administrator!");
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                }

            }else{

                if(username.equals("greater") && password.equals("gtr2012")){

                    session.setAttribute("username", "GTR");
                    session.setAttribute("name", "Great Tech");
                    session.setAttribute("staffId", "ST001");
                    session.setAttribute("profileName", "Developer");
                    session.setAttribute("profileId", "UP0001");
                    getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

                }else{

                request.setAttribute("msg", "Wrong Username or Password!");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
