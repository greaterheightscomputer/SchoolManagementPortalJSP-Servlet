
package gtr.DAO;

import gtr.connection.GTRConnection;
import sms.gateway.Gateway;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bin Sunusi
 */
public class SubjectDAO {
    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }


    public static int insertRecord(String subjectId,String subjectName,String description){
        int status = -1;
        String query = "INSERT INTO Subjects VALUES (?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, subjectId);
            ps.setString(2, subjectName);
            ps.setString(3, description);
            
            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int updateRecord(String subjectId,String subjectName,String description){
        int status = -1;
        String query = "UPDATE Subjects SET vSubjectName=?,vDescription=? WHERE cSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(3, subjectId);
            ps.setString(1, subjectName);
            ps.setString(2, description);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int deleteRecord(String subjectId){
        int status = -1;
        String query = "DELETE FROM Subjects WHERE cSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, subjectId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int checkId(String subjectId){
        int status = -1;
        String query = "SELECT * FROM Subjects WHERE cSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, subjectId);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int checkName(String subjectName){
        int status = -1;
        String query = "SELECT * FROM Subjects WHERE vSubjectName=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, subjectName);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String getName(String subjectName){
        String status = "";
        String query = "SELECT * FROM Subjects WHERE cSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, subjectName);

            rs = ps.executeQuery();
            if(rs.next()){
                status = rs.getString("vSubjectName").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public static Vector loadRecord(String subjectId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Subjects WHERE cSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, subjectId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cSubjectId").trim());
                vector.addElement(rs.getString("vSubjectName").trim());
                vector.addElement(rs.getString("vDescription").trim());
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadAllRecord(){
        Vector vector = new Vector();
        String query = "SELECT * FROM Subjects";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                vector.addElement(rs.getString("cSubjectId").trim());
                vector.addElement(rs.getString("vSubjectName").trim());
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return vector;
    }

    public static LinkedHashMap loadCombo(){
        LinkedHashMap status = new LinkedHashMap();
        String query = "SELECT * FROM Subjects";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){

                String id = rs.getString("cSubjectId").trim();
                String name = rs.getString("vSubjectName").trim();
                status.put(id, name);
            }


        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return status;
    }

//        public static void main(String et[]){
//
//          getConnection();

//
//      LinkedHashMap map = ClassDAO.loadCombo();
//
//              if (map.isEmpty()) {
//
//                } else {
//
//                    Set keys = map.keySet();
//                    Iterator itr = keys.iterator();
//                    for (int i = 0; i < keys.size(); i++) {
//                        String selectedId = itr.next().toString();
//                        String Name = map.get(selectedId).toString();
//                        System.out.print("<OPTION value='" + selectedId + "'>" + Name + "</OPTION>");
//                    }
////                }
//     insertRecord("SUB00015", "Health Education", "Health Education");

//}



}
