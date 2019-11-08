package gtr.DAO;

import gtr.connection.GTRConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchoolBillDAO {

    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection() {
        connect = GTRConnection.getConnection();

        return connect;
    }

    public static int insertRecord(String studentId, String sessionId, String classId, String termId, String accountname, String accountno, String previousbalance, String schoolfees, String uniform, String sportlevy, String registration, String examlevy, String pta, String computerlevy, String textbook, String notebook, String transport, String lessonfees, String endofyearparty, String graduationfees,String total) {
        int response = -1;
        String query = "INSERT INTO SchoolBill VALUES (0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, studentId);
            ps.setString(2, sessionId);
            ps.setString(3, classId);
            ps.setString(4, termId);
            ps.setString(5, accountname);
            ps.setString(6, accountno);
            ps.setDouble(7, Double.parseDouble(previousbalance));
            ps.setDouble(8, Double.parseDouble(schoolfees));
            ps.setDouble(9, Double.parseDouble(uniform));
            ps.setDouble(10, Double.parseDouble(sportlevy));
            ps.setDouble(11, Double.parseDouble(registration));
            ps.setDouble(12, Double.parseDouble(examlevy));
            ps.setDouble(13, Double.parseDouble(pta));
            ps.setDouble(14, Double.parseDouble(computerlevy));
            ps.setDouble(15, Double.parseDouble(textbook));
            ps.setDouble(16, Double.parseDouble(notebook));
            ps.setDouble(17, Double.parseDouble(transport));
            ps.setDouble(18, Double.parseDouble(lessonfees));
            ps.setDouble(19, Double.parseDouble(endofyearparty));
            ps.setDouble(20, Double.parseDouble(graduationfees));
            ps.setDouble(21, Double.parseDouble(total));

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }


    public static int updateRecord(String billId, String studentId, String sessionId, String classId, String termId, String accountname, String accountno, String previousbalance, String schoolfees, String uniform, String sportlevy, String registration, String examlevy, String pta, String computerlevy, String textbook, String notebook, String transport, String lessonfees, String endofyearparty, String graduationfees, String total){
        int response = -1;
        String query = "UPDATE SchoolBill SET cStudentId=?, cSessionId=?, cClassId=?, cTermId=?, vAccountname=?, vAccountno=?, mPreviousbalance=?, mSchoolfees=?, mUniform=?, mSportlevy=?, mRegistration=?,  mExamlevy=?, mPTA=?, mComputerlevy=?, mTextbook=?, mNotebook=?, mTransport=?, mLessonfees=?, mEndofyearparty=?, mGraduationfees=?, mTotal=? WHERE iBillId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(22,Integer.parseInt(billId));
            ps.setString(1, studentId);
            ps.setString(2, sessionId);
            ps.setString(3, classId);
            ps.setString(4, termId);
            ps.setString(5, accountname);
            ps.setString(6, accountno);
            ps.setDouble(7, Double.parseDouble(previousbalance));
            ps.setDouble(8, Double.parseDouble(schoolfees));
            ps.setDouble(9, Double.parseDouble(uniform));
            ps.setDouble(10, Double.parseDouble(sportlevy));
            ps.setDouble(11, Double.parseDouble(registration));
            ps.setDouble(12, Double.parseDouble(examlevy));
            ps.setDouble(13, Double.parseDouble(pta));
            ps.setDouble(14, Double.parseDouble(computerlevy));
            ps.setDouble(15, Double.parseDouble(textbook));
            ps.setDouble(16, Double.parseDouble(notebook));
            ps.setDouble(17, Double.parseDouble(transport));
            ps.setDouble(18, Double.parseDouble(lessonfees));
            ps.setDouble(19, Double.parseDouble(endofyearparty));
            ps.setDouble(20, Double.parseDouble(graduationfees));
            ps.setDouble(21, Double.parseDouble(total));

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(connect != null){
                    connect.close();
                }

            }catch(Exception ex){

            }
        }

        return response;
    }

     public static int updatePreviousBal(String studentId, String sessionId, String classId, String termId, String previousbalance) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mPreviousbalance=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";

        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(previousbalance));
            ps.setDouble(2,Double.parseDouble(previousbalance));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateSchoolfees(String studentId, String sessionId, String classId, String termId, String schoolfees) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mSchoolfees=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(schoolfees));
            ps.setDouble(2, Double.parseDouble(schoolfees));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateUniform(String studentId, String sessionId, String classId, String termId, String uniform) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mUniform=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(uniform));
            ps.setDouble(2, Double.parseDouble(uniform));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateSportlevy(String studentId, String sessionId, String classId, String termId, String sportlevy) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mSportlevy=?, mTotal=mTotal+?, WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(sportlevy));
            ps.setDouble(2, Double.parseDouble(sportlevy));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateRegistration(String studentId, String sessionId, String classId, String termId, String registration) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mRegistration=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(registration));
            ps.setDouble(2, Double.parseDouble(registration));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateExamlevy(String studentId, String sessionId, String classId, String termId, String examlevy) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mExamlevy=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(examlevy));
            ps.setDouble(2, Double.parseDouble(examlevy));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updatePTA(String studentId, String sessionId, String classId, String termId, String pta) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mPTA=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(pta));
            ps.setDouble(2, Double.parseDouble(pta));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateComputerlevy(String studentId, String sessionId, String classId, String termId, String computerlevy) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mComputerlevy=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(computerlevy));
            ps.setDouble(2, Double.parseDouble(computerlevy));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateTextbook(String studentId, String sessionId, String classId, String termId, String textbook) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mTextbook=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(textbook));
            ps.setDouble(2, Double.parseDouble(textbook));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateNotebook(String studentId, String sessionId, String classId, String termId, String notebook) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mNotebook=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(notebook));
            ps.setDouble(2, Double.parseDouble(notebook));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateTransport(String studentId, String sessionId, String classId, String termId, String transport) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mTransport=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(transport));
            ps.setDouble(2, Double.parseDouble(transport));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateLessonfees(String studentId, String sessionId, String classId, String termId, String lessonfees) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mLessonfees=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(lessonfees));
            ps.setDouble(2, Double.parseDouble(lessonfees));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int updateEndyear(String studentId, String sessionId, String classId, String termId, String endyear) {
        int response = -1;
        String query = "UPDATE SchoolBill SET mEndofyearparty=?, mTotal=mTotal+? WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setDouble(1, Double.parseDouble(endyear));
            ps.setDouble(2, Double.parseDouble(endyear));
            ps.setString(3, studentId);
            ps.setString(4, sessionId);
            ps.setString(5, classId);
            ps.setString(6, termId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        return response;
    }

    public static int getTotal(String studentId, String sessionId, String classId, String termId) {
        int response = -1;
        String query = "SELECT * FROM SchoolBill WHERE cStudentId=? AND cSessionId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, studentId);
            ps.setString(2, sessionId);
            ps.setString(3, classId);
            ps.setString(4, termId);

            rs = ps.executeQuery();
            if (rs.next()) {
                response = rs.getInt("iTotal");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }

            } catch (Exception ex) {
            }
        }

        return response;
    }

    public static int deleteRecord(String billId) {
        int response = -1;
        String query = "DELETE FROM SchoolBill WHERE iBillId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, billId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }

            } catch (Exception ex) {
            }
        }

        return response;
    }

    public static int checkId(String id){
        int status = -1;
        String query = "SELECT * FROM SchoolBill WHERE iBillId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(connect != null){
                    connect.close();
                }
            }catch(Exception ex){

            }
        }

        return status;
    }

    public static Vector loadRecord(String billId) {
        Vector vector = new Vector();
        String query = "SELECT * FROM SchoolBill WHERE iBillId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, billId);

            rs = ps.executeQuery();
            if (rs.next()) {
                vector.addElement(rs.getString("iBillId").trim());
                vector.addElement(rs.getString("cStudentId").trim());
                vector.addElement(rs.getString("cSessionId").trim());
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("cTermId").trim());
                vector.addElement(rs.getString("vAccountname").trim());
                vector.addElement(rs.getString("vAccountno").trim());
                vector.addElement(rs.getString("mPreviousbalance").trim());
                vector.addElement(rs.getString("mSchoolfees").trim());
                vector.addElement(rs.getString("mUniform").trim());
                vector.addElement(rs.getString("mSportlevy").trim());
                vector.addElement(rs.getString("mRegistration").trim());
                vector.addElement(rs.getString("mExamlevy").trim());
                vector.addElement(rs.getString("mPTA").trim());
                vector.addElement(rs.getString("mComputerlevy").trim());
                vector.addElement(rs.getString("mTextbook").trim());
                vector.addElement(rs.getString("mNotebook").trim());
                vector.addElement(rs.getString("mTransport").trim());
                vector.addElement(rs.getString("mLessonfees").trim());
                vector.addElement(rs.getString("mEndofyearparty").trim());
                vector.addElement(rs.getString("mGraduationfees").trim());
                vector.addElement(rs.getString("mTotal").trim());

            }
        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connect != null) {
                    connect.close();
                }

            } catch (Exception ex) {
            }
        }

        return vector;
    }

    public static LinkedHashMap loadCombo() {
        LinkedHashMap map = new LinkedHashMap();
        String query = "SELECT * FROM SchoolBill";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("iBillId").trim();
                String studentId = rs.getString("cStudentId").trim();
                String sessionId = rs.getString("cSessionId").trim();
                String classId = rs.getString("cClassId").trim();
                String termId = rs.getString("cTermId").trim();
                String name = StudentsDAO.getName(studentId) + " " + SessionDAO.getSessionName(sessionId) + " " + ClassDAO.getClassName(classId) + " " + ClassDAO.getTermName(termId);
                map.put(id, name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SchoolBillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return map;
    }

    public static void main(String et[]) {

        getConnection();
//insertRecord("STU00001", "SE00001", "CL00001", "Term01", "Greater Heights School", "124555000099", "5000", "10000", "2000", "600", "200", "520", "200", "500", "5000", "1500", "700", "1000", "500","900","200");
updatePreviousBal("STU00001", "SE00001", "CL00001", "Term01", "20000");

    }
}

