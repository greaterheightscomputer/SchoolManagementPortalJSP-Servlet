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
public class SessionDAO {
      private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }

    public static int insertRecord(String sessionId,String sessionName,String description){
        int status = -1;
        String query = "INSERT INTO Sessions VALUES (?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, sessionId);
            ps.setString(2, sessionName);
            ps.setString(3, description);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int updateRecord(String sessionId,String sessionName,String description){
        int status = -1;
        String query = "UPDATE Sessions SET vSessionName=?,vDescription=? WHERE cSessionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(3, sessionId);
            ps.setString(1, sessionName);
            ps.setString(2, description);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int deleteRecord(String sessionId){
        int status = -1;
        String query = "DELETE FROM Sessions WHERE cSessionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, sessionId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Sessions WHERE cSessionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String getSessionName(String id){
        String status = "";
        String query = "SELECT * FROM Sessions WHERE cSessionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = rs.getString("vSessionName").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Sessions WHERE vSessionName=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadRecord(String sessionId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Sessions WHERE cSessionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, sessionId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cSessionId").trim());
                vector.addElement(rs.getString("vSessionName").trim());
                vector.addElement(rs.getString("vDescription").trim());
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Sessions";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){

                String id = rs.getString("cSessionId").trim();
                String name = rs.getString("vSessionName").trim();
                status.put(id, name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

}
