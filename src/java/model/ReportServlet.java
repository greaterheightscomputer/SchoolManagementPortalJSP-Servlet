/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import gtr.connection.GTRConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author James Etim - breantech@yahoo.com
 */
public class ReportServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            StringWriter stringWriter = null;
            PrintWriter printWriter = null;
            HttpSession session = request.getSession(true);
        try {

            int type = 0;

            HashMap params = new HashMap();
            Map<String,String> param = params;

            if (request.getParameter("RepType")!=null) {
                type = Integer.parseInt(request.getParameter("RepType"));
            } else if (session.getAttribute("RepType") != null) {
                String RepType3 = String.valueOf(session.getAttribute("RepType"));
                type = Integer.parseInt(RepType3);
            }

            String report_path = "";

            switch (type) {
                case 1:
                    report_path = "Report/subject.jasper";
                    break;
                case 2:
                    report_path = "Report/sessions.jasper";
                    break;
                case 3:
                   String Studentid = request.getParameter("textStudentId").trim();
                    params.put("StudentId", Studentid);

                   report_path = "Report/StudentDiary.jasper";
                    break;
                case 4:
                    String StudentId = request.getParameter("textStudentId").trim();
                    String SessionId = request.getParameter("comboSessionId").trim();
                    String ClassId = request.getParameter("comboClassId").trim();
                    String TermId = request.getParameter("comboTermId").trim();
                    params.put("StudentId", StudentId);
                    params.put("SessionId", SessionId);
                    params.put("ClassId", ClassId);
                    params.put("TermId", TermId);
                    report_path = "Report/Registrations.jasper";
                    break;
                case 5:
                   report_path = "Report/staffs.jasper";
                    break;
                case 6:
                    String staffId = request.getParameter("textStaffId").trim();
                    params.put("staffId", staffId);   
                   report_path = "Report/staff.jasper";
                    break;
                case 7:
                    String studentId = request.getParameter("textStudentId").trim();
                    String sessionId = request.getParameter("comboSessionId").trim();
                    String classId = request.getParameter("comboClassId").trim();
                    String termId = request.getParameter("comboTermId").trim();
                    params.put("studentId", studentId);
                    params.put("sessionId", sessionId);
                    params.put("classId", classId);
                    params.put("termId", termId);
                   report_path = "Report/Result.jasper";
                    break;
                case 8:
                    String studentID = request.getParameter("textStudentId").trim();
                    params.put("studentId", studentID);
                    report_path = "Report/Result_2.jasper";
                    break;
                case 9:
                    String StudentID = request.getParameter("textStudentId").trim();
                    params.put("StudentId", StudentID);

                   report_path = "Report/certificate.jasper";
                    break;
                case 10:
                    String StudentiD = request.getParameter("textStudentId").trim();
                    String SessionID = request.getParameter("comboSessionId").trim();
                    String ClassID = request.getParameter("comboClassId").trim();
                    String TermID = request.getParameter("comboTermId").trim();
                    params.put("studentId", StudentiD);
                    params.put("sessionId", SessionID);
                    params.put("classId", ClassID);
                    params.put("termId", TermID);
                    report_path = "Report/Regform.jasper";
                    break;
                case 11:
                    String studentid = request.getParameter("textStudentId").trim();
                    String sessionid = request.getParameter("comboSessionId").trim();
                    String classid = request.getParameter("comboClassId").trim();
                    String termid = request.getParameter("comboTermId").trim();
                    params.put("studentId", studentid);
                    params.put("sessionId", sessionid);
                    params.put("classId", classid);
                    params.put("termId", termid);
                    report_path = "Report/Bills.jasper";
                    break;

                default:
                    break;
            }

            JasperPrint jasperprint = JasperFillManager.fillReport(getServletContext().getRealPath("/") + report_path, param,GTRConnection.getConnection());

            byte[] pdfasbytes = JasperExportManager.exportReportToPdf(jasperprint);

            ServletOutputStream outstream = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setContentLength(pdfasbytes.length);

//            response.setHeader("Content-disposition", "inline; filename=\"Report.pdf\"");
            outstream.write(pdfasbytes);


        }catch(Exception ex){
            request.setAttribute("message", ex.getLocalizedMessage());
            request.setAttribute("class", ex.getClass());
            request.setAttribute("cause", ex.getCause());

            getServletContext().getRequestDispatcher("/exception.jsp").forward(request, response);
        }
        finally {

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
