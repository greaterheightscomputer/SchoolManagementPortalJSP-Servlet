/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

public class StudentDiaryDAO {
    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection() {
        connect = GTRConnection.getConnection();

        return connect;
    }

    public static int insertRecord(String certificateId, String studentId, String dateofAdmission, String classonAdmission, String dateofLeaving, String classonLeaving, String reasonforLeaving, String award, String grade, String subject1, String subject2, String subject3, String subject4, String subject5, String subject6, String subject7, String subject8, String picture, String date) {
        int response = -1;
        String query = "INSERT INTO Certificates VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, certificateId);
            ps.setString(2, studentId);
            ps.setString(3, dateofAdmission);
            ps.setString(4, classonAdmission);
            ps.setString(5, dateofLeaving);
            ps.setString(6, classonLeaving);
            ps.setString(7, reasonforLeaving);
            ps.setString(8, award);
            ps.setString(9, grade);
            ps.setString(10, subject1);
            ps.setString(11, subject2);
            ps.setString(12, subject3);
            ps.setString(13, subject4);
            ps.setString(14, subject5);
            ps.setString(15, subject6);
            ps.setString(16, subject7);
            ps.setString(17, subject8);
            ps.setString(18, picture);
            ps.setString(19, date);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAO.class.getName()).log(Level.SEVERE, null, ex);
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


    public static int updateRecord(String certificateId, String studentId, String dateofAdmission, String classonAdmission, String dateofLeaving, String classonLeaving, String reasonforLeaving, String award, String grade, String subject1, String subject2, String subject3, String subject4, String subject5, String subject6, String subject7, String subject8, String picture, String date){
        int status = -1;
        String query = "UPDATE Certificates SET cStudentId=?, vDateofAdmission=?, VclassonAdmission=?, vDateofLeaving=?, vClassonLeaving=?, vReasonforLeaving=?, vAward=?, vGrade=?, vSubject1=?, vSubject2=?, vSubject3=?, vSubject4=?, vSubject5=?, vSubject6=?, vSubject7=?, vSubject8=?, vImage=?, vDate=? WHERE cCertificateId=?";
        try {
             ps = getConnection().prepareStatement(query);
            ps.setString(1, certificateId);
            ps.setString(2, studentId);
            ps.setString(3, dateofAdmission);
            ps.setString(4, classonAdmission);
            ps.setString(5, dateofLeaving);
            ps.setString(6, classonLeaving);
            ps.setString(7, reasonforLeaving);
            ps.setString(8, award);
            ps.setString(9, grade);
            ps.setString(10, subject1);
            ps.setString(11, subject2);
            ps.setString(12, subject3);
            ps.setString(13, subject4);
            ps.setString(14, subject5);
            ps.setString(15, subject6);
            ps.setString(16, subject7);
            ps.setString(17, subject8);
            ps.setString(18, picture);
            ps.setString(19, date);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return status;
    }

    public static int deleteRecord(String certificateId) {
        int response = -1;
        String query = "DELETE FROM Certificates WHERE cCertificateId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, certificateId);

            response = ps.executeUpdate();
            if (response > -1) {
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int chagePicture(String certificateId, String picture) {
        int respones = -1;
        String query = "UPDATE Certificates SET vImage=? WHERE cCertificateId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(2, certificateId);
            ps.setString(1, picture);
            respones = ps.executeUpdate();
            if (respones > -1) {
                respones = 0;
            }

        } catch (SQLException ex) {
            return respones;
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
            } catch (SQLException sql) {
            }
        }

        return respones;
    }

    public static Vector loadRecord(String certificateId) {
        Vector vector = new Vector();
        String query = "SELECT * FROM Certificates WHERE cCertificateId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, certificateId);

            rs = ps.executeQuery();
            if (rs.next()) {
                vector.addElement(rs.getString("cCertificateId").trim());
                vector.addElement(rs.getString("cStudentId").trim());
                vector.addElement(rs.getString("vDateofAdmission").trim());
                vector.addElement(rs.getString("VclassonAdmission").trim());
                vector.addElement(rs.getString("vDateofLeaving").trim());
                vector.addElement(rs.getString("vClassonLeaving").trim());
                vector.addElement(rs.getString("vReasonforLeaving").trim());
                vector.addElement(rs.getString("vAward").trim());
                vector.addElement(rs.getString("vGrade").trim());
                vector.addElement(rs.getString("vSubject1").trim());
                vector.addElement(rs.getString("vSubject2").trim());
                vector.addElement(rs.getString("vSubject3").trim());
                vector.addElement(rs.getString("vSubject4").trim());
                vector.addElement(rs.getString("vSubject5").trim());
                vector.addElement(rs.getString("vSubject6").trim());
                vector.addElement(rs.getString("vSubject7").trim());
                vector.addElement(rs.getString("vSubject8").trim());
                vector.addElement(rs.getString("vImage").trim());
                vector.addElement(rs.getString("vDate").trim());

            }
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Certificates";
        try {
            st = getConnection().createStatement();

            rs = st.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("cCertificateId").trim();
                String studentId = rs.getString("cStudentId").trim();
                String name = StudentsDAO.getName(studentId);
                map.put(id, name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CertificateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return map;
    }

//    public static void main(String et[]) {
//
//        getConnection();
//
////insertRecord("C01/011", "STU00001", "2008/2009", "Basic 1", "2011/2012", "Basic 6", "Having graduated from school", "Satisfactory", "Sign.jpg", "August 10, 2011");
////updateRecord("C01/011", "STU00001", "2008/2009", "Basic 2", "2011/2012", "Basic 7", "Having graduated from school", "Satisfactory", "Sign.jpg", "2nd May, 2011");
//loadRecord("9");
//
//    }
}




