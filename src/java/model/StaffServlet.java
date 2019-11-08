/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import gtr.DAO.StaffDAO;
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
public class StaffServlet extends HttpServlet {
   
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

            String staffId = request.getParameter("textStaffId").trim();
            String surname = request.getParameter("textSurname").trim();
            String firstName = request.getParameter("textFirstName").trim();
            String gender = request.getParameter("comboGender").trim();
            String dob = request.getParameter("textDOB").trim();
            String address = request.getParameter("textAddress").trim();
            String phone = request.getParameter("textPhone").trim();
            String email = request.getParameter("textEmail").trim();
            String qualification = request.getParameter("comboQualification").trim();
            String category = request.getParameter("comboCategory").trim();
            String employmentDate = request.getParameter("textEmploymentDate").trim();
            String salary = request.getParameter("textSalary").trim();

            if(button.equals("Add Record")){
               int chkId = StaffDAO.checkId(staffId);
                  if(chkId != 0){

                      int status = StaffDAO.insertRecord(staffId, surname, firstName, gender, dob, address, phone, email, qualification, category, employmentDate, salary);
                      if(status == 0){

                          request.setAttribute("msg","Record Successfully Saved!");
                          getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);

                      }else{
                          request.setAttribute("staffId", staffId);
                          request.setAttribute("surname", surname);
                          request.setAttribute("firstName", firstName);
                          request.setAttribute("gender", gender);
                          request.setAttribute("dob", dob);
                          request.setAttribute("address", address);
                          request.setAttribute("phone", phone);
                          request.setAttribute("email", email);
                          request.setAttribute("qualification", qualification);
                          request.setAttribute("category", category);
                          request.setAttribute("employmentDate", employmentDate);
                          request.setAttribute("salary", salary);

                           request.setAttribute("msg","Record Not Saved, Try Again!");
                           getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);
                      }

                  }else{
                         request.setAttribute("staffId", staffId);
                          request.setAttribute("surname", surname);
                          request.setAttribute("firstName", firstName);
                          request.setAttribute("gender", gender);
                          request.setAttribute("dob", dob);
                          request.setAttribute("address", address);
                          request.setAttribute("phone", phone);
                          request.setAttribute("email", email);
                          request.setAttribute("qualification", qualification);
                          request.setAttribute("category", category);
                          request.setAttribute("employmentDate", employmentDate);
                          request.setAttribute("salary", salary);

                           request.setAttribute("msg","Staff Id Already Exist, Try Again!");
                           getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);
                  }
            }

         else if(button.equals("Update Record")){
                  int chkId = StaffDAO.checkId(staffId);
                  if(chkId == 0){

                      int status = StaffDAO.updateRecord(staffId, surname, firstName, gender, dob, address, phone, email, qualification, category, employmentDate, salary);
                      if(status == 0){

                          request.setAttribute("msg","Record Successfully Updated!");
                          getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);

                      }else{
                          request.setAttribute("staffId", staffId);
                          request.setAttribute("surname", surname);
                          request.setAttribute("firstName", firstName);
                          request.setAttribute("gender", gender);
                          request.setAttribute("dob", dob);
                          request.setAttribute("address", address);
                          request.setAttribute("phone", phone);
                          request.setAttribute("email", email);
                          request.setAttribute("qualification", qualification);
                          request.setAttribute("category", category);
                          request.setAttribute("employmentDate", employmentDate);
                          request.setAttribute("salary", salary);

                           request.setAttribute("msg","Record Not Updated, Try Again!");
                           getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);
                      }

                  }else{
                         request.setAttribute("staffId", staffId);
                          request.setAttribute("surname", surname);
                          request.setAttribute("firstName", firstName);
                          request.setAttribute("gender", gender);
                          request.setAttribute("dob", dob);
                          request.setAttribute("address", address);
                          request.setAttribute("phone", phone);
                          request.setAttribute("email", email);
                          request.setAttribute("qualification", qualification);
                          request.setAttribute("category", category);
                          request.setAttribute("employmentDate", employmentDate);
                          request.setAttribute("salary", salary);

                           request.setAttribute("msg","Staff Id Does not Exist, Try Again!");
                           getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);
                  }
            }

             else if(button.equals("Delete Record")){
                  int chkId = StaffDAO.checkId(staffId);
                  if(chkId == 0){

                      int status = StaffDAO.deleteRecord(staffId);
                      if(status == 0){

                          request.setAttribute("msg","Record Successfully Deleted!");
                          getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);

                      }else{
                          request.setAttribute("staffId", staffId);
                          request.setAttribute("surname", surname);
                          request.setAttribute("firstName", firstName);
                          request.setAttribute("gender", gender);
                          request.setAttribute("dob", dob);
                          request.setAttribute("address", address);
                          request.setAttribute("phone", phone);
                          request.setAttribute("email", email);
                          request.setAttribute("qualification", qualification);
                          request.setAttribute("category", category);
                          request.setAttribute("employmentDate", employmentDate);
                          request.setAttribute("salary", salary);

                           request.setAttribute("msg","Record Not Deleted, Try Again!");
                           getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);
                      }

                  }else{
                         request.setAttribute("staffId", staffId);
                          request.setAttribute("surname", surname);
                          request.setAttribute("firstName", firstName);
                          request.setAttribute("gender", gender);
                          request.setAttribute("dob", dob);
                          request.setAttribute("address", address);
                          request.setAttribute("phone", phone);
                          request.setAttribute("email", email);
                          request.setAttribute("qualification", qualification);
                          request.setAttribute("category", category);
                          request.setAttribute("employmentDate", employmentDate);
                          request.setAttribute("salary", salary);

                           request.setAttribute("msg","Staff Id Does not Exist, Try Again!");
                           getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);
                  }
            }

             else if(button.equals("Load Record")){

                staffId = request.getParameter("comboLoad").trim();

                Vector vector = StaffDAO.loadRecord(staffId);
                if(!vector.isEmpty()){

                    staffId = vector.elementAt(0).toString().trim();
                    surname = vector.elementAt(1).toString().trim();
                    firstName = vector.elementAt(2).toString().trim();
                    gender = vector.elementAt(3).toString().trim();
                    dob = vector.elementAt(4).toString().trim();
                    address = vector.elementAt(5).toString().trim();
                    phone = vector.elementAt(6).toString().trim();
                    email = vector.elementAt(7).toString().trim();
                    qualification = vector.elementAt(8).toString().trim();
                    category = vector.elementAt(9).toString().trim();
                    employmentDate = vector.elementAt(10).toString().trim();
                    salary = vector.elementAt(11).toString().trim();

                          request.setAttribute("staffId", staffId);
                          request.setAttribute("surname", surname);
                          request.setAttribute("firstName", firstName);
                          request.setAttribute("gender", gender);
                          request.setAttribute("dob", dob);
                          request.setAttribute("address", address);
                          request.setAttribute("phone", phone);
                          request.setAttribute("email", email);
                          request.setAttribute("qualification", qualification);
                          request.setAttribute("category", category);
                          request.setAttribute("employmentDate", employmentDate);
                          request.setAttribute("salary", salary);

                           getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/add_staff.jsp").forward(request, response);
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
