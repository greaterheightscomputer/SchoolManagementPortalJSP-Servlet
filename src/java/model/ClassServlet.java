/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import autoId.ClassId;
import gtr.DAO.ClassDAO;
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
public class ClassServlet extends HttpServlet {
   
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

            String classId = request.getParameter("textClassId").trim();
            String name = request.getParameter("textName").trim();
            String description = request.getParameter("textDescription").trim();
            String comboId = request.getParameter("comboLoad").trim();

          
            if(button.equals("Add Record")){

                int chkId = ClassDAO.checkId(classId);
                if(chkId != 0){

                    int chkName = ClassDAO.checkName(name);
                    if(chkName != 0){

                        int status = ClassDAO.insertRecord(classId, name, description);
                        if(status == 0){
                            ClassId.updateId();
                            request.setAttribute("msg","Record Successfully Saved!");
                            getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be saved, Try Again!");
                            request.setAttribute("classId",classId);
                            request.setAttribute("name",name);
                            request.setAttribute("description",description);

                            getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                        }

                    }else{
                        request.setAttribute("msg","Class "+name+" Already Exist!");
                        request.setAttribute("classId",classId);
                        request.setAttribute("name",name);
                        request.setAttribute("description",description);

                        getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                    }

                }else{

                     int chkName = ClassDAO.checkName(name);
                    if(chkName != 0){

                        int status = ClassDAO.insertRecord(ClassId.getId(), name, description);
                        if(status == 0){
                            ClassId.updateId();
                            request.setAttribute("msg","Record Successfully Saved!");
                            getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be saved, Try Again!");
                            request.setAttribute("classId",classId);
                            request.setAttribute("name",name);
                            request.setAttribute("description",description);

                            getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                        }

                    }else{
                        request.setAttribute("msg","Class "+name+" Already Exist!");
                        request.setAttribute("classId",classId);
                        request.setAttribute("name",name);
                        request.setAttribute("description",description);

                        getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                    }

                }

            }
            else if(button.equals("Update Record")){

                int chkId = ClassDAO.checkId(classId);
                if(chkId == 0){

                        int status = ClassDAO.updateRecord(classId, name, description);
                        if(status == 0){
                            request.setAttribute("msg","Record Successfully Updated!");
                            getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be Updated, Try Again!");
                            request.setAttribute("classId",classId);
                            request.setAttribute("name",name);
                            request.setAttribute("description",description);

                            getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                        }

                }else{
                    request.setAttribute("msg","Class Id Does not Exist, Try Again!");
                    request.setAttribute("classId",classId);
                    request.setAttribute("name",name);
                    request.setAttribute("description",description);

                    getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);

                }

            }
            else if(button.equals("Delete Record")){

                int chkId = ClassDAO.checkId(classId);
                if(chkId == 0){

                        int status = ClassDAO.deleteRecord(classId);
                        if(status == 0){
                            request.setAttribute("msg","Record Successfully Deleted!");
                            getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be Deleted, Try Again!");
                            request.setAttribute("classId",classId);
                            request.setAttribute("name",name);
                            request.setAttribute("description",description);

                            getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
                        }

                }else{
                    request.setAttribute("msg","Class Id Does not Exist, Try Again!");
                    request.setAttribute("classId",classId);
                    request.setAttribute("name",name);
                    request.setAttribute("description",description);

                    getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);

                }

            }
            else if(button.equals("Load Record")){

                Vector vector = ClassDAO.loadRecord(comboId);
                if(!vector.isEmpty()){
                    classId = vector.elementAt(0).toString().trim();
                    name = vector.elementAt(1).toString().trim();
                    description = vector.elementAt(2).toString().trim();

                    request.setAttribute("classId",classId);
                    request.setAttribute("name",name);
                    request.setAttribute("description",description);

                    getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/add_class.jsp").forward(request, response);
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
