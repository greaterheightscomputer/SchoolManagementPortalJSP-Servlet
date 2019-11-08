/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.DAO.CertificateDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Bin Sunusi
 */
public class UploadSignServlet extends HttpServlet {

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

            String certificateId = (String)session.getAttribute("id");
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
             if (!isMultipart) {
             } else {
                    ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
                    List fileItemsList = servletFileUpload.parseRequest(request);

                    DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                    diskFileItemFactory.setSizeThreshold(70960);

                    Iterator it = fileItemsList.iterator();
                    while (it.hasNext()){
                      FileItem fileItem = (FileItem)it.next();
                      if (fileItem.isFormField()){
                      }
                      else{
//                          String dir = "D:\\Khadijat\\SPortal\\web\\pictures\\";
                          String dir = "C:\\ComputerG\\Khadijat\\SPortal\\web\\pictures";

                          String fileName = fileItem.getName();
                          int last = fileName.lastIndexOf("\\");
                          int flength = fileName.length();
                          String savefilename = fileName.substring(last+1,flength);

                          File uploadedFile = new File(dir+savefilename);
                          fileItem.write(uploadedFile);

                          CertificateDAO.chagePicture(certificateId, savefilename);
                          request.setAttribute("msg","Record Successfully Saved!");
                          getServletContext().getRequestDispatcher("/certificate.jsp").forward(request, response);

                      }
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
