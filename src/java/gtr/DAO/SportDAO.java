
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


public class SportDAO {
    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }

    public static int insertRecord(String sportId, String studentId,String  sessionId, String classId, String termId, String events, String levelAttained, String comments){
        int status = -1;
        String query = "INSERT INTO Sports VALUES (?,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, sportId);
            ps.setString(2, studentId);
            ps.setString(3, sessionId);
            ps.setString(4, classId);
            ps.setString(5, termId);
            ps.setString(6, events);
            ps.setString(7, levelAttained);
            ps.setString(8, comments);
          
            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
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


    public static int updateRecord(String sportId, String studentId, String  sessionId, String classId, String termId, String events, String levelAttained, String comments){
        int status = -1;
        String query = "UPDATE Sports SET cStudentId=?, cSessionId=?, cClassId=?, cTermId=?, vEvents=?, vLevelAttained=?, vComments=? WHERE cSportId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(8, sportId);
            ps.setString(1, studentId);
            ps.setString(2, sessionId);
            ps.setString(3, classId);
            ps.setString(4, termId);
            ps.setString(5, events);
            ps.setString(6, levelAttained);
            ps.setString(7, comments);
           
            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int deleteRecord(String sportId){
        int status = -1;
        String query = "DELETE FROM Sports WHERE cSportId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, sportId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Sports WHERE cSportId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
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


    public static Vector loadRecord(String sportId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Sports WHERE cSportId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, sportId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cSportId").trim());
                vector.addElement(rs.getString("cStudentId").trim());
                vector.addElement(rs.getString("cSessionId").trim());
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("cTermId").trim());
                vector.addElement(rs.getString("vEvents").trim());
                vector.addElement(rs.getString("vLevelAttained").trim());
                vector.addElement(rs.getString("vComments").trim());
                    }

        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Sports ORDER BY cSportId";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
               String id = rs.getString("cSportId").trim();
               String studentId = rs.getString("cStudentId").trim();
               String sessionId = rs.getString("cSessionId").trim();
               String classId = rs.getString("cClassId").trim();
               String termId = rs.getString("cTermId").trim();
               String name = StudentsDAO.getName(studentId)+" "+SessionDAO.getSessionName(sessionId)+" "+ClassDAO.getClassName(classId)+" "+ClassDAO.getTermName(termId);
               map.put(id,name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
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
////////////updateRecord("1", "1", "STU00001", "60times", "5times", "40times", "5times");
////////////
//insertRecord("SP00004", "STU00002", "Ball games", "50times", "good at the game");
//insertRecord("SP00005", "STU00002", "Jumps", "60times", "good at jumping");
//insertRecord("SP00006", "STU00002", "Throws", "75times", "good at throwing");
//
//   }


}
