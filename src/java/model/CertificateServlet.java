/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.CertificateDAO;
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
public class CertificateServlet extends HttpServlet {
   
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

            String certificateId = request.getParameter("textCertificateId").trim();
            String studentId = request.getParameter("textStudentId").trim();
            String dateofAdmission = request.getParameter("textDateofAdmission").trim();
            String classonAdmission = request.getParameter("textClassonAdmission").trim();
            String dateofLeaving = request.getParameter("textDateofLeaving").trim();
            String classonLeaving = request.getParameter("textClassonLeaving").trim();
            String reasonforLeaving = request.getParameter("textReasonforLeaving").trim();
            String award = request.getParameter("textAward").trim();
            String grade = request.getParameter("textGrade").trim();
            String subject1 = request.getParameter("textSubject1").trim();
            String subject2 = request.getParameter("textSubject2").trim();
            String subject3 = request.getParameter("textSubject3").trim();
            String subject4 = request.getParameter("textSubject4").trim();
            String subject5 = request.getParameter("textSubject5").trim();
            String subject6 = request.getParameter("textSubject6").trim();
            String subject7 = request.getParameter("textSubject7").trim();
            String subject8 = request.getParameter("textSubject8").trim();
            String date = request.getParameter("textDate").trim();
            String picture = "default.png";

                        
            if(button.equals("Add Record")){
                int chkId = CertificateDAO.checkId(certificateId);
                if(chkId != 0){
                    int status = CertificateDAO.insertRecord(certificateId, studentId, dateofAdmission, classonAdmission, dateofLeaving, classonLeaving, reasonforLeaving, award, grade, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, picture, date);
                    if(status == 0){
                        session.setAttribute("id", certificateId);
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/file_uploadsign.jsp").forward(request, response);
                    }else{
                        request.setAttribute("certificateId", certificateId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("dateofAdmission", dateofAdmission);
                        request.setAttribute("classonAdmission", classonAdmission);
                        request.setAttribute("dateofLeaving", dateofLeaving);
                        request.setAttribute("classonLeaving", classonLeaving);
                        request.setAttribute("reasonforLeaving", reasonforLeaving);
                        request.setAttribute("award", award);
                        request.setAttribute("grade", grade);
                        request.setAttribute("subject1", subject1);
                        request.setAttribute("subject2", subject2);
                        request.setAttribute("subject3", subject3);
                        request.setAttribute("subject4", subject4);
                        request.setAttribute("subject5", subject5);
                        request.setAttribute("subject6", subject6);
                        request.setAttribute("subject7", subject7);
                        request.setAttribute("subject8", subject8);
                        request.setAttribute("date", date);
                       
                        request.setAttribute("msg", "certificateId" +certificateId+ " Already Exist!" );
                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
                    }
                }else{
                        
                        request.setAttribute("certificateId", certificateId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("dateofAdmission", dateofAdmission);
                        request.setAttribute("classonAdmission", classonAdmission);
                        request.setAttribute("dateofLeaving", dateofLeaving);
                        request.setAttribute("classonLeaving", classonLeaving);
                        request.setAttribute("reasonforLeaving", reasonforLeaving);
                        request.setAttribute("award", award);
                        request.setAttribute("grade", grade);
                        request.setAttribute("subject1", subject1);
                        request.setAttribute("subject2", subject2);
                        request.setAttribute("subject3", subject3);
                        request.setAttribute("subject4", subject4);
                        request.setAttribute("subject5", subject5);
                        request.setAttribute("subject6", subject6);
                        request.setAttribute("subject7", subject7);
                        request.setAttribute("subject8", subject8);
                        request.setAttribute("date", date);

                        request.setAttribute("msg","Student Id "+studentId+" Does not Existt!");
                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
                    }

                }
            else if(button.equals("Update Record")){

                int chkId = CertificateDAO.checkId(certificateId);
                if(chkId == 0)
                    {
                    int status = CertificateDAO.updateRecord(certificateId, studentId, dateofAdmission, classonAdmission, dateofLeaving, classonLeaving, reasonforLeaving, award, grade, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, picture, date);
                    if(status == 0){
                        session.setAttribute("id", certificateId);
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/file_uploadsign.jsp").forward(request, response);
//                        request.setAttribute("msg","Record Successfully Updated!");
//                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
                    }else{
                        request.setAttribute("certificateId", certificateId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("dateofAdmission", dateofAdmission);
                        request.setAttribute("classonAdmission", classonAdmission);
                        request.setAttribute("dateofLeaving", dateofLeaving);
                        request.setAttribute("classonLeaving", classonLeaving);
                        request.setAttribute("reasonforLeaving", reasonforLeaving);
                        request.setAttribute("award", award);
                        request.setAttribute("grade", grade);
                        request.setAttribute("subject1", subject1);
                        request.setAttribute("subject2", subject2);
                        request.setAttribute("subject3", subject3);
                        request.setAttribute("subject4", subject4);
                        request.setAttribute("subject5", subject5);
                        request.setAttribute("subject6", subject6);
                        request.setAttribute("subject7", subject7);
                        request.setAttribute("subject8", subject8);
                        request.setAttribute("date", date);

                        request.setAttribute("msg","Record Not Updated, Try Again!");
                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("certificateId", certificateId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("dateofAdmission", dateofAdmission);
                        request.setAttribute("classonAdmission", classonAdmission);
                        request.setAttribute("dateofLeaving", dateofLeaving);
                        request.setAttribute("classonLeaving", classonLeaving);
                        request.setAttribute("reasonforLeaving", reasonforLeaving);
                        request.setAttribute("award", award);
                        request.setAttribute("grade", grade);
                        request.setAttribute("subject1", subject1);
                        request.setAttribute("subject2", subject2);
                        request.setAttribute("subject3", subject3);
                        request.setAttribute("subject4", subject4);
                        request.setAttribute("subject5", subject5);
                        request.setAttribute("subject6", subject6);
                        request.setAttribute("subject7", subject7);
                        request.setAttribute("subject8", subject8);
                        request.setAttribute("date", date);

                        request.setAttribute("msg","Student Id Does not Exist, Try Again!");
                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
                }
            }

            else if(button.equals("Delete Record")){

                int chkId = CertificateDAO.checkId(certificateId);
                if(chkId == 0){
                    int status = CertificateDAO.deleteRecord(certificateId);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Deleted!");
                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
                    }else{
                        request.setAttribute("certificateId", certificateId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("dateofAdmission", dateofAdmission);
                        request.setAttribute("classonAdmission", classonAdmission);
                        request.setAttribute("dateofLeaving", dateofLeaving);
                        request.setAttribute("classonLeaving", classonLeaving);
                        request.setAttribute("reasonforLeaving", reasonforLeaving);
                        request.setAttribute("award", award);
                        request.setAttribute("grade", grade);
                        request.setAttribute("subject1", subject1);
                        request.setAttribute("subject2", subject2);
                        request.setAttribute("subject3", subject3);
                        request.setAttribute("subject4", subject4);
                        request.setAttribute("subject5", subject5);
                        request.setAttribute("subject6", subject6);
                        request.setAttribute("subject7", subject7);
                        request.setAttribute("subject8", subject8);
                        request.setAttribute("date", date);

                        request.setAttribute("msg","Record Not Deleted, Try Again!");
                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
                    }
                }else{
                        request.setAttribute("certificateId", certificateId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("dateofAdmission", dateofAdmission);
                        request.setAttribute("classonAdmission", classonAdmission);
                        request.setAttribute("dateofLeaving", dateofLeaving);
                        request.setAttribute("classonLeaving", classonLeaving);
                        request.setAttribute("reasonforLeaving", reasonforLeaving);
                        request.setAttribute("award", award);
                        request.setAttribute("grade", grade);
                        request.setAttribute("subject1", subject1);
                        request.setAttribute("subject2", subject2);
                        request.setAttribute("subject3", subject3);
                        request.setAttribute("subject4", subject4);
                        request.setAttribute("subject5", subject5);
                        request.setAttribute("subject6", subject6);
                        request.setAttribute("subject7", subject7);
                        request.setAttribute("subject8", subject8);
                        request.setAttribute("date", date);

                        request.setAttribute("msg","Student Id Does not Exist, Try Again!");
                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
                }
            }

            else if(button.equals("Load Record")){
                certificateId = request.getParameter("comboLoad").trim();
                Vector vector = CertificateDAO.loadRecord(certificateId);
                if(!vector.isEmpty()){

                    certificateId = vector.elementAt(0).toString().trim();
                    studentId = vector.elementAt(1).toString().trim();
                    dateofAdmission = vector.elementAt(2).toString().trim();
                    classonAdmission = vector.elementAt(3).toString().trim();
                    dateofLeaving = vector.elementAt(4).toString().trim();
                    classonLeaving = vector.elementAt(5).toString().trim();
                    reasonforLeaving = vector.elementAt(6).toString().trim();
                    award = vector.elementAt(7).toString().trim();
                    grade = vector.elementAt(8).toString().trim();
                    subject1 = vector.elementAt(9).toString().trim();
                    subject2 = vector.elementAt(10).toString().trim();
                    subject3 = vector.elementAt(11).toString().trim();
                    subject4 = vector.elementAt(12).toString().trim();
                    subject5 = vector.elementAt(13).toString().trim();
                    subject6 = vector.elementAt(14).toString().trim();
                    subject7 = vector.elementAt(15).toString().trim();
                    subject8 = vector.elementAt(16).toString().trim();
                    String image = vector.elementAt(17).toString().trim();
                    date = vector.elementAt(18).toString().trim();
                   
                        request.setAttribute("certificateId", certificateId);
                        request.setAttribute("studentId", studentId);
                        request.setAttribute("dateofAdmission", dateofAdmission);
                        request.setAttribute("classonAdmission", classonAdmission);
                        request.setAttribute("dateofLeaving", dateofLeaving);
                        request.setAttribute("classonLeaving", classonLeaving);
                        request.setAttribute("reasonforLeaving", reasonforLeaving);
                        request.setAttribute("award", award);
                        request.setAttribute("grade", grade);
                        request.setAttribute("subject1", subject1);
                        request.setAttribute("subject2", subject2);
                        request.setAttribute("subject3", subject3);
                        request.setAttribute("subject4", subject4);
                        request.setAttribute("subject5", subject5);
                        request.setAttribute("subject6", subject6);
                        request.setAttribute("subject7", subject7);
                        request.setAttribute("subject8", subject8);
                        request.setAttribute("image", image);
                        request.setAttribute("date", date);
                        
                        getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);

                }else{
                    request.setAttribute("msg","Invalid Combo Selection!");
                    getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);
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
