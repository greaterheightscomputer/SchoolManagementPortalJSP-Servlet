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

/**
 *
 * @author Bin Sunusi
 */
public class UserDAO {

    private static Connection connect;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static Connection getNewConnection(){
       connect = GTRConnection.getConnection();
       return connect;
    }
     public static int insertRecord(String username,String password,String staffId,String profileId){
        int respones = -1;

        String query = "INSERT INTO Users values (?,?,?,?,1)";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, staffId);
            ps.setString(4, profileId);
            respones = ps.executeUpdate();

            if(respones > -1){
                 respones = 0;
            }
        } catch (SQLException ex) {
            return respones;
        }  finally{
            try {
                if(ps != null){
                    ps.close();
                }
                if(connect != null){
                    connect.close();
                }
            } catch (SQLException ex) {

            }
        }
        return respones;
    }

    public static int deleteRecord(String username){
        int respones = -1;

        String query = "DELETE FROM Users WHERE cUsername=?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(1, username);
            respones = ps.executeUpdate();

            if(respones > -1){
                 respones = 0;
            }
        } catch (SQLException ex) {
            return respones;
        }  finally{
            try {
                if(ps != null){
                    ps.close();
                }
                if(connect != null){
                    connect.close();
                }
            } catch (SQLException ex) {

            }
        }
        return respones;
    }

    public static int checkId(String id){
        int respones = -1;
        String query = "SELECT * FROM Users where cUsername = ?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                respones = 0;
            }
        } catch (SQLException ex) {
            return respones;
        }finally{
            try {
                if(rs != null){
                   rs.close();
                }
                if(ps != null){
                   ps.close();
                }
                if(connect != null){
                   connect.close();
                }
            } catch (SQLException ex) {
            }
        }
        return respones;
    }

   public static Vector authenticateUser(String username,String password){
            Vector vector = new Vector();

            String query = "Select * from Users where cUsername=? AND cPassword=?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cUsername").trim());
                vector.addElement(rs.getString("cStaffId").trim());
                vector.addElement(rs.getString("cProfileId").trim());
                vector.addElement(rs.getString("iStatus").trim());
            }
        } catch (SQLException ex) {
        }finally{
            try {
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(connect != null){
                    connect.close();
                }
            } catch (SQLException ex) {
            }
        }
            return vector;
        }

   public static int getProfileStatus(String id){
        int respones = -1;
        String query = "SELECT * FROM Profiles WHERE cProfileId = ?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                respones = rs.getInt("iStatus");
            }
        } catch (SQLException ex) {
            return respones;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return respones;
    }
    public static int checkOldPassword(String username,String password){
        int respones = -1;
        String query = "SELECT * FROM Users WHERE cUsername=? AND cPassword=?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                respones = 0;
            }

        } catch (SQLException ex) {
            return respones;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return respones;
    }

    public static int changeDefaultPassword(String username,String password){
        int respones = -1;
        String query = "UPDATE Users SET cPassword=?,iStatus=0 WHERE cUsername=?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(2, username);
            ps.setString(1, password);
            respones = ps.executeUpdate();
            if(respones > -1){
                respones = 0;
            }

        } catch (SQLException ex) {
            return respones;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return respones;
    }
    public static int updateStatus(String username,String status){
        int respones = -1;
        String query = "UPDATE Users SET iStatus=? WHERE cUsername = ?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(2, username);
            ps.setInt(1, Integer.parseInt(status));
            respones = ps.executeUpdate();
            if(respones > -1){
                respones = 0;
            }

        } catch (SQLException ex) {
            return respones;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return respones;
    }
    public static int updateProfileStatus(String profileId,String status){
        int respones = -1;
        String query = "UPDATE Profiles SET iStatus=? WHERE cProfileId = ?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(2, profileId);
            ps.setInt(1, Integer.parseInt(status));
            respones = ps.executeUpdate();
            if(respones > -1){
                respones = 0;
            }

        } catch (SQLException ex) {
            return respones;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return respones;
    }
    public static int changePassword(String username,String password){
        int respones = -1;
        String query = "UPDATE Users SET cPassword=? WHERE cUsername = ?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(2, username);
            ps.setString(1, password);
            respones = ps.executeUpdate();
            if(respones > -1){
                respones = 0;
            }

        } catch (SQLException ex) {
            return respones;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return respones;
    }
    public static int resetPassword(String username,String password){
        int respones = -1;
        String query = "UPDATE Users SET cPassword=?,iStatus=1 WHERE cUsername = ?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(2, username);
            ps.setString(1, password);
            respones = ps.executeUpdate();
            if(respones > -1){
                respones = 0;
            }

        } catch (SQLException ex) {
            return respones;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return respones;
    }

    public static String getProfileName(String id){
        String respones = "";
        String query = "SELECT * FROM Profiles WHERE cProfileId = ?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                respones = rs.getString("vProfile").trim();
            }

        } catch (SQLException ex) {
            return respones;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return respones;
    }

    public static LinkedHashMap loadCombo(){
        LinkedHashMap map = new LinkedHashMap();
        String query = "SELECT * FROM Users";

        try {
            st = getNewConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("cUsername").trim();
                String name = StaffDAO.getName(rs.getString("cStaffId").trim());
                map.put(id,name);
            }

        } catch (SQLException ex) {
            return map;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return map;
    }

    public static String setMenu(String profileId){
        String menu = "";
        if(profileId.trim().equals("UP0001")){
            menu = "navigation";
        }
        else if(profileId.trim().equals("UP0002")){
            menu = "teacher_navigation";
        }
        else{
            menu = "navigation";
        }

        return menu;
    }

    public static Vector loadRecord(String username){
        Vector vector = new Vector();
        String query = "SELECT * FROM Users WHERE cUsername=?";
        try {
            ps = getNewConnection().prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){

                vector.addElement(rs.getString("cUsername").trim());
                vector.addElement(rs.getString("cStaffId").trim());
                vector.addElement(rs.getString("cProfileId").trim());
                vector.addElement(rs.getString("iStatus").trim());
            }

        } catch (SQLException ex) {
            return vector;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return vector;
    }

     public static LinkedHashMap loadProfile(String profileId){
        LinkedHashMap map = new LinkedHashMap();
        String query = "SELECT * FROM Profiles";

        try {
            st = getNewConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String id = rs.getString("cProfileId").trim();
                String name = rs.getString("vProfile").trim();
                map.put(id,name);
            }

        } catch (SQLException ex) {
            return map;
        }
        finally{
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
            }catch(SQLException sql){
            }
        }

        return map;
    }

}
