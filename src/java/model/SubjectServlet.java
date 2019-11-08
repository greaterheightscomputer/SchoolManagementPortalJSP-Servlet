/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import sms.gateway.Gateway;
import autoId.SubjectId;
import gtr.DAO.SubjectDAO;
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
public class SubjectServlet extends HttpServlet {
   
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

            String subjectId = request.getParameter("textSubjectId").trim();
            String name = request.getParameter("textSubjectName").trim();
            String description = request.getParameter("textDescription").trim();
            String comboId = request.getParameter("comboLoad").trim();

            if(button.equals("Add Record")){

                int chkId = SubjectDAO.checkId(subjectId);
                if(chkId != 0){

                    int chkName = SubjectDAO.checkName(name);
                    if(chkName != 0){

                        int status = SubjectDAO.insertRecord(subjectId, name, description);
                        if(status == 0){
                            SubjectId.updateId();
                            request.setAttribute("msg","Record Successfully Saved!");
                            getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be saved, Try Again!");
                            request.setAttribute("subjectId",subjectId);
                            request.setAttribute("name",name);
                            request.setAttribute("description",description);

                            getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                        }

                    }else{
                        request.setAttribute("msg","Subject "+name+" Already Exist!");
                        request.setAttribute("subjectId",subjectId);
                        request.setAttribute("name",name);
                        request.setAttribute("description",description);

                        getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                    }

                }else{

                     int chkName = SubjectDAO.checkName(name);
                    if(chkName != 0){

                        int status = SubjectDAO.insertRecord(SubjectId.getId(), name, description);
                        if(status == 0){
                            SubjectId.updateId();
                            request.setAttribute("msg","Record Successfully Saved!");
                            getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be saved, Try Again!");
                            request.setAttribute("subjectId",subjectId);
                            request.setAttribute("name",name);
                            request.setAttribute("description",description);

                            getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                        }

                    }else{
                        request.setAttribute("msg","Subject "+name+" Already Exist!");
                        request.setAttribute("subjectId",subjectId);
                        request.setAttribute("name",name);
                        request.setAttribute("description",description);

                        getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                    }

                }

            }
            else if(button.equals("Update Record")){

                int chkId = SubjectDAO.checkId(subjectId);
                if(chkId == 0){

                        int status = SubjectDAO.updateRecord(subjectId, name, description);
                        if(status == 0){
                            request.setAttribute("msg","Record Successfully Updated!");
                            getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be Updated, Try Again!");
                            request.setAttribute("subjectId",subjectId);
                            request.setAttribute("name",name);
                            request.setAttribute("description",description);

                            getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                        }

                }else{
                    request.setAttribute("msg","Subject Id Does not Exist, Try Again!");
                    request.setAttribute("subjectId",subjectId);
                    request.setAttribute("name",name);
                    request.setAttribute("description",description);

                    getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);

                }

            }
            else if(button.equals("Delete Record")){

                int chkId = SubjectDAO.checkId(subjectId);
                if(chkId == 0){

                        int status = SubjectDAO.deleteRecord(subjectId);
                        if(status == 0){
                            request.setAttribute("msg","Record Successfully Deleted!");
                            getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                        }else{
                            request.setAttribute("msg","Record cannot be Deleted, Try Again!");
                            request.setAttribute("subjectId",subjectId);
                            request.setAttribute("name",name);
                            request.setAttribute("description",description);

                            getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
                        }

                }else{
                    request.setAttribute("msg","Subject Id Does not Exist, Try Again!");
                    request.setAttribute("subjectId",subjectId);
                    request.setAttribute("name",name);
                    request.setAttribute("description",description);

                    getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);

                }

            }
            else if(button.equals("Load Record")){

                Vector vector = SubjectDAO.loadRecord(comboId);
                if(!vector.isEmpty()){
                    subjectId = vector.elementAt(0).toString().trim();
                    name = vector.elementAt(1).toString().trim();
                    description = vector.elementAt(2).toString().trim();

                    request.setAttribute("subjectId",subjectId);
                    request.setAttribute("name",name);
                    request.setAttribute("description",description);

                    getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/add_subject.jsp").forward(request, response);
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
