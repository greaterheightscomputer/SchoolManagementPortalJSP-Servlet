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
/**
 *
 * @author Bin Sunusi
 */
public class ClassDAO {
    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }

    public static int insertRecord(String classId,String className,String description){
        int status = -1;
        String query = "INSERT INTO Classes VALUES (?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, classId);
            ps.setString(2, className);
            ps.setString(3, description);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int updateRecord(String classId,String className,String description){
        int status = -1;
        String query = "UPDATE Classes SET vClassName=?,vDescription=? WHERE cClassId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(3, classId);
            ps.setString(1, className);
            ps.setString(2, description);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int deleteRecord(String classId){
        int status = -1;
        String query = "DELETE FROM Classes WHERE cClassId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, classId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Classes WHERE cClassId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String getClassName(String id){
        String status = "";
        String query = "SELECT * FROM Classes WHERE cClassId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = rs.getString("vClassName").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String getTermName(String id){
        String status = "";
        String query = "SELECT * FROM Terms WHERE cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = rs.getString("vTermName").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int checkName(String name){
        int status = -1;
        String query = "SELECT * FROM Classes WHERE vClassName=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadRecord(String classId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Classes WHERE cClassId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, classId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("vClassName").trim());
                vector.addElement(rs.getString("vDescription").trim());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        LinkedHashMap status = new LinkedHashMap();
        String query = "SELECT * FROM Classes";
        try {
            st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
             while(rs1.next()){

                String id = rs1.getString("cClassId").trim();
                String name = rs1.getString("vClassName").trim();
                status.put(id, name);
            }


        } catch (SQLException ex) {
            Logger.getLogger(ClassDAO.class.getName()).log(Level.SEVERE, null, ex);
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

//    public static void main(String et[]){
//
//          getConnection();
//
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
//insertRecord("CL00003", "Basic 3 ", "Basic 3", "55times", "2times", "58times", "5times", "72times", "He is punctual at school", "", "", "punctual always", "Good", "He good");
//}
}
