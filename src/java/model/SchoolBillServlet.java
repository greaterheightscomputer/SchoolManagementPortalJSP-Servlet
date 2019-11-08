
package model;


import gtr.DAO.SchoolBillDAO;
//import gtr.DAO.StudentsDAO;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bun Sunusi
 */
public class SchoolBillServlet extends HttpServlet {

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

            String billId = request.getParameter("textBillId").trim();
            String studentId = request.getParameter("textStudentId").trim();
            String sessionId = request.getParameter("comboSessionId").trim();
            String classId = request.getParameter("comboClassId").trim();
            String termId = request.getParameter("comboTermId").trim();
            String accountname = request.getParameter("textAccountName").trim();
            String accountno = request.getParameter("textAccountNo").trim();
            String previousbalance = request.getParameter("textPreviousBal").trim();
            String schoolfees = request.getParameter("textSchoolFee").trim();
            String uniform = request.getParameter("textUniform").trim();
            String sportlevy = request.getParameter("textSportLevy").trim();
            String registration = request.getParameter("textRegistration").trim();
            String examlevy = request.getParameter("textExamLevy").trim();
            String pta = request.getParameter("textPTA").trim();
            String computerlevy = request.getParameter("textComputerlevy").trim();
            String textbook = request.getParameter("textTextbook").trim();
            String notebook = request.getParameter("textNoteBook").trim();
            String transport = request.getParameter("textTransport").trim();
            String lessonfees = request.getParameter("textLessonFees").trim();
            String endofyearparty = request.getParameter("textEndyear").trim();
            String graduationfees = request.getParameter("textGraduateFees").trim();
//            String total = request.getParameter("textTotal").trim();

            double xx = Double.valueOf(previousbalance)+Double.valueOf(schoolfees)+Double.valueOf(uniform)
                    +Double.valueOf(sportlevy)+Double.valueOf(registration)+Double.valueOf(examlevy)
                    +Double.valueOf(pta)+Double.valueOf(computerlevy)+Double.valueOf(textbook)
                    +Double.valueOf(notebook)+Double.valueOf(transport)+Double.valueOf(lessonfees)
                    +Double.valueOf(endofyearparty)+Double.valueOf(graduationfees);

            String total = String.valueOf(xx);

//            String comboLoad = request.getParameter("comboLoad").trim();



            if(button.equals("Add Record")){

                int chkStudent = SchoolBillDAO.checkId(billId);
                if(chkStudent != 0){

                    int status = SchoolBillDAO.insertRecord(studentId, sessionId, classId, termId, accountname, accountno, previousbalance, schoolfees, uniform, sportlevy, registration, examlevy, pta, computerlevy, textbook, notebook, transport, lessonfees, endofyearparty, graduationfees,total);
                    if(status == 0){
                        request.setAttribute("msg","Record Successfully Saved!");
                        getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
                    }else{
                        request.setAttribute("studentId",studentId);
                        request.setAttribute("sessionId",sessionId);
                        request.setAttribute("classId",classId);
                        request.setAttribute("termId",termId);
                        request.setAttribute("accountname",accountname);
                        request.setAttribute("accountno",accountno);
                        request.setAttribute("previousbalance",previousbalance);
                        request.setAttribute("schoolfees",schoolfees);
                        request.setAttribute("uniform",uniform);
                        request.setAttribute("sportlevy",sportlevy);
                        request.setAttribute("sportlevy",registration);
                        request.setAttribute("sportlevy",examlevy);
                        request.setAttribute("sportlevy",pta);
                        request.setAttribute("computerlevy",computerlevy);
                        request.setAttribute("textbook",textbook);
                        request.setAttribute("notebook",notebook);
                        request.setAttribute("transport",transport);
                        request.setAttribute("lessonfees",lessonfees);
                        request.setAttribute("endofyearparty",endofyearparty);
                        request.setAttribute("graduationfees",graduationfees);

                        request.setAttribute("msg","Record cannot be Saved!");
                        getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
                    }

                }else{
                        request.setAttribute("studentId",studentId);
                        request.setAttribute("sessionId",sessionId);
                        request.setAttribute("classId",classId);
                        request.setAttribute("termId",termId);
                        request.setAttribute("accountname",accountname);
                        request.setAttribute("accountno",accountno);
                        request.setAttribute("previousbalance",previousbalance);
                        request.setAttribute("schoolfees",schoolfees);
                        request.setAttribute("uniform",uniform);
                        request.setAttribute("sportlevy",sportlevy);
                        request.setAttribute("registration",registration);
                        request.setAttribute("examlevy",examlevy);
                        request.setAttribute("pta",pta);
                        request.setAttribute("computerlevy",computerlevy);
                        request.setAttribute("textbook",textbook);
                        request.setAttribute("notebook",notebook);
                        request.setAttribute("transport",transport);
                        request.setAttribute("lessonfees",lessonfees);
                        request.setAttribute("endofyearparty",endofyearparty);
                        request.setAttribute("graduationfees",graduationfees);

                        request.setAttribute("msg","Bill Id "+billId+" Does not Exist!");
                        getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
                }
            }

//            else if(button.equals("Update Record")){
//                int chkStudent = StudentsDAO.checkId(studentId);
//                if(chkStudent == 0){
//
//                    int status = SchoolBillDAO.updateRecord(billId, studentId, sessionId, classId, termId, accountname, accountno, previousbalance, schoolfees, uniform, sportlevy, registration, examlevy, pta, computerlevy, textbook, notebook, transport, lessonfees, endofyearparty, graduationfees, total);
//                    if(status == 0){
//                        request.setAttribute("msg","Record Successfully Updated!");
//                        getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
//                    }else{
//                        request.setAttribute("studentId",studentId);
//                        request.setAttribute("sessionId",sessionId);
//                        request.setAttribute("classId",classId);
//                        request.setAttribute("termId",termId);
//                        request.setAttribute("accountname",accountname);
//                        request.setAttribute("accountno",accountno);
//                        request.setAttribute("previousbalance",previousbalance);
//                        request.setAttribute("schoolfees",schoolfees);
//                        request.setAttribute("uniform",uniform);
//                        request.setAttribute("sportlevy",sportlevy);
//                        request.setAttribute("sportlevy",registration);
//                        request.setAttribute("sportlevy",examlevy);
//                        request.setAttribute("sportlevy",pta);
//                        request.setAttribute("computerlevy",computerlevy);
//                        request.setAttribute("textbook",textbook);
//                        request.setAttribute("notebook",notebook);
//                        request.setAttribute("transport",transport);
//                        request.setAttribute("lessonfees",lessonfees);
//                        request.setAttribute("endofyearparty",endofyearparty);
//                        request.setAttribute("graduationfees",graduationfees);
//                        request.setAttribute("total",total);
//
//                        request.setAttribute("msg","Record cannot be Updated!");
//                        getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
//                    }
//
//                }else{
//                        request.setAttribute("studentId",studentId);
//                        request.setAttribute("sessionId",sessionId);
//                        request.setAttribute("classId",classId);
//                        request.setAttribute("termId",termId);
//                        request.setAttribute("accountname",accountname);
//                        request.setAttribute("accountno",accountno);
//                        request.setAttribute("previousbalance",previousbalance);
//                        request.setAttribute("schoolfees",schoolfees);
//                        request.setAttribute("uniform",uniform);
//                        request.setAttribute("sportlevy",sportlevy);
//                        request.setAttribute("registration",registration);
//                        request.setAttribute("examlevy",examlevy);
//                        request.setAttribute("pta",pta);
//                        request.setAttribute("computerlevy",computerlevy);
//                        request.setAttribute("textbook",textbook);
//                        request.setAttribute("notebook",notebook);
//                        request.setAttribute("transport",transport);
//                        request.setAttribute("lessonfees",lessonfees);
//                        request.setAttribute("endofyearparty",endofyearparty);
//                        request.setAttribute("graduationfees",graduationfees);
//                         request.setAttribute("total",total);
//
//                        request.setAttribute("msg","Student Id "+studentId+" Does not Existt!");
//                        getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
//                }
//            }
//
//
//             else if(button.equals("Load Record")){
//
//                Vector vector = SchoolBillDAO.loadRecord(comboLoad);
//                if(!vector.isEmpty()){
//
//                    billId = vector.elementAt(0).toString().trim();
//                    studentId = vector.elementAt(1).toString().trim();
//                    sessionId = vector.elementAt(2).toString().trim();
//                    classId = vector.elementAt(3).toString().trim();
//                    termId = vector.elementAt(4).toString().trim();
//                    accountname = vector.elementAt(5).toString().trim();
//                    accountno = vector.elementAt(6).toString().trim();
//                    previousbalance = vector.elementAt(7).toString().trim();
//                    schoolfees = vector.elementAt(8).toString().trim();
//                    uniform = vector.elementAt(9).toString().trim();
//                    sportlevy = vector.elementAt(10).toString().trim();
//                    registration = vector.elementAt(11).toString().trim();
//                    examlevy = vector.elementAt(12).toString().trim();
//                    pta = vector.elementAt(13).toString().trim();
//                    computerlevy = vector.elementAt(14).toString().trim();
//                    textbook = vector.elementAt(15).toString().trim();
//                    notebook = vector.elementAt(16).toString().trim();
//                    transport = vector.elementAt(17).toString().trim();
//                    lessonfees = vector.elementAt(18).toString().trim();
//                    endofyearparty = vector.elementAt(19).toString().trim();
//                    graduationfees = vector.elementAt(20).toString().trim();
//                    total = vector.elementAt(21).toString().trim();
//
//                        request.setAttribute("billId",billId);
//                        request.setAttribute("studentId",studentId);
//                        request.setAttribute("sessionId",sessionId);
//                        request.setAttribute("classId",classId);
//                        request.setAttribute("termId",termId);
//                        request.setAttribute("accountname",accountname);
//                        request.setAttribute("accountno",accountno);
//                        request.setAttribute("previousbalance",previousbalance);
//                        request.setAttribute("schoolfees",schoolfees);
//                        request.setAttribute("uniform",uniform);
//                        request.setAttribute("sportlevy",sportlevy);
//                        request.setAttribute("registration",registration);
//                        request.setAttribute("examlevy",examlevy);
//                        request.setAttribute("pta",pta);
//                        request.setAttribute("computerlevy",computerlevy);
//                        request.setAttribute("textbook",textbook);
//                        request.setAttribute("notebook",notebook);
//                        request.setAttribute("transport",transport);
//                        request.setAttribute("lessonfees",lessonfees);
//                        request.setAttribute("endofyearparty",endofyearparty);
//                        request.setAttribute("graduationfees",graduationfees);
//                        request.setAttribute("total",total);
//
//                    getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
//
//                }else{
//                    request.setAttribute("msg","Invalid Combo Selection!");
//                    getServletContext().getRequestDispatcher("/add_schoolbill.jsp").forward(request, response);
//                }
//
//            }

                }finally {
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
