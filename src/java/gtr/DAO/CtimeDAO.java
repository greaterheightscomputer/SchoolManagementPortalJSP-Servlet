
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


public class CtimeDAO {
    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }


    public static int insertRecord(String ctimeId, String studentId, String  sessionId, String classId, String termId, String timePresentinSchool, String timeAbsentinSchool, String timePresentinSport, String timeAbsentinSport, String greenN0, String greenDeed, String redN0, String redDeed, String comments, String cleanlinessRating, String remarks){
        int status = -1;
        String query = "INSERT INTO Ctimes VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, ctimeId);
            ps.setString(2, studentId);
            ps.setString(3, sessionId);
            ps.setString(4, classId);
            ps.setString(5, termId);
            ps.setString(6, timePresentinSchool);
            ps.setString(7, timeAbsentinSchool);
            ps.setString(8, timePresentinSport);
            ps.setString(9, timeAbsentinSport);
            ps.setString(10, greenN0);
            ps.setString(11, greenDeed);
            ps.setString(12, redN0);
            ps.setString(13, redDeed);
            ps.setString(14, comments);
            ps.setString(15, cleanlinessRating);
            ps.setString(16, remarks);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
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


    public static int updateRecord(String ctimeId, String studentId, String  sessionId, String classId, String termId, String timePresentinSchool, String timeAbsentinSchool, String timePresentinSport, String timeAbsentinSport, String greenN0, String greenDeed, String redN0, String redDeed, String comments, String cleanlinessRating, String remarks){
        int status = -1;
        String query = "UPDATE Ctimes SET cStudentId=?, cSessionId=?, cClassId=?, cTermId=?, vTimePresentinSchool=?, vTimeAbsentinSchool=?, vTimePresentinSport=?, vTimeAbsentinSport=?, vGreenN0=?, vGreenDeed=?, vRedN0=?, vRedDeed=?, vComments=?, vCleanlinessRating=?, vRemarks=? WHERE cCtimeId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(16, ctimeId);
            ps.setString(1, studentId);
            ps.setString(2, sessionId);
            ps.setString(3, classId);
            ps.setString(4, termId);
            ps.setString(5, timePresentinSchool);
            ps.setString(6, timeAbsentinSchool);
            ps.setString(7, timePresentinSport);
            ps.setString(8, timeAbsentinSport);
            ps.setString(9, greenN0);
            ps.setString(10, greenDeed);
            ps.setString(11, redN0);
            ps.setString(12, redDeed);
            ps.setString(13, comments);
            ps.setString(14, cleanlinessRating);
            ps.setString(15, remarks);
            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int deleteRecord(String ctimeId){
        int status = -1;
        String query = "DELETE FROM Ctimes WHERE cCtimeId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, ctimeId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int checkId(String id){
        int status = -1;
        String query = "SELECT * FROM Ctimes WHERE cCtimeId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
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


    public static Vector loadRecord(String ctimeId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Ctimes WHERE cCtimeId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, ctimeId);
            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cCtimeId").trim());
                vector.addElement(rs.getString("cStudentId").trim());
                vector.addElement(rs.getString("cSessionId").trim());
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("cTermId").trim());
                vector.addElement(rs.getString("vTimePresentinSchool").trim());
                vector.addElement(rs.getString("vTimeAbsentinSchool").trim());
                vector.addElement(rs.getString("vTimePresentinSport").trim());
                vector.addElement(rs.getString("vTimeAbsentinSport").trim());
                vector.addElement(rs.getString("vGreenN0").trim());
                vector.addElement(rs.getString("vGreenDeed").trim());
                vector.addElement(rs.getString("vRedN0").trim());
                vector.addElement(rs.getString("vRedDeed").trim());
                vector.addElement(rs.getString("vComments").trim());
                vector.addElement(rs.getString("vCleanlinessRating").trim());
                vector.addElement(rs.getString("vRemarks").trim());
                  }

        } catch (SQLException ex) {
            Logger.getLogger(CtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return vector;
    }

    public static LinkedHashMap loadCombo(){
        LinkedHashMap map = new LinkedHashMap();
        String query = "SELECT * FROM Ctimes ORDER BY cCtimeId";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
               String id = rs.getString("cCtimeId").trim();
               String studentId = rs.getString("cStudentId").trim();
               String sessionId = rs.getString("cSessionId").trim();
               String classId = rs.getString("cClassId").trim();
               String termId = rs.getString("cTermId").trim();
               String name = StudentsDAO.getName(studentId)+" "+SessionDAO.getSessionName(sessionId)+" "+ClassDAO.getClassName(classId)+" "+ClassDAO.getTermName(termId);
               map.put(id,name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtimeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(st != null){
                    st.close();
                }
                if(connect != null){
                    connect.close();
                }
            }catch(Exception ex){

            }
        }

        return map;
    }

//   public static void main(String et[]){
//
//getConnection();
////updateRecord("1", "1", "STU00001", "60times", "5times", "40times", "5times");
//
//insertRecord("CT00001","STU00001", "60times", "15times", "50times", "10times", "85times", "Punctual", "", "", "She is alway punctual", "Good", "She is good");
//insertRecord("CT00002","STU00002", "60times", "15times", "50times", "10times", "85times", "Punctual", "", "", "She is punctual", "Good", "She is good");
//insertRecord("CT0003","STU0003", "60times", "15times", "50times", "10times", "85times", "Punctual", "", "", "He is alway neat", "Good", "He is good");
//    }

  

}
