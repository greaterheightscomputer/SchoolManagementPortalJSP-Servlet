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
public class ClassSubjectDAO {
    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }
     public static int insertRecord(String classId,String subjectId){
        int status = -1;
        String query = "INSERT INTO ClassSubjects VALUES (0,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, classId);
            ps.setString(2, subjectId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int updateRecord(String classSubjectId,String classId,String subjectId){
        int status = -1;
        String query = "UPDATE ClassSubjects SET cClassId=?,cSubjectId=? WHERE cClassSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(3, classSubjectId);
            ps.setString(1, classId);
            ps.setString(2, subjectId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int deleteRecord(String classSubjectId){
        int status = -1;
        String query = "DELETE FROM ClassSubjects WHERE cClassSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, classSubjectId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM ClassSubjects WHERE cClassSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int checkSubjectId(String classId,String subjectId){
        int status = -1;
        String query = "SELECT * FROM ClassSubjects WHERE cClassId=? AND cSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, classId);
            ps.setString(2, subjectId);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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

//    public static int checkName(String name){
//        int status = -1;
//        String query = "SELECT * FROM Classes WHERE vClassName=?";
//        try {
//            ps = getConnection().prepareStatement(query);
//            ps.setString(1, name);
//
//            rs = ps.executeQuery();
//            if(rs.next()){
//                status = 0;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ClassSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try{
//                if(rs != null){
//                    rs.close();
//                }
//                if(ps != null){
//                    ps.close();
//                }
//                if(connect != null){
//                    connect.close();
//                }
//            }catch(Exception ex){
//
//            }
//        }
//
//        return status;
//    }
    public static Vector loadRecord(String classSubjectId){
        Vector vector = new Vector();
        String query = "SELECT * FROM ClassSubjects WHERE cClassSubjectId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, classSubjectId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cClassSubjectId").trim());
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("cSubjectId").trim());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM ClassSubjects";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){

                String id = rs.getString("cClassSubjectId").trim();
                String name = rs.getString("cClassId").trim();
                status.put(id, name);
            }


        } catch (SQLException ex) {
            Logger.getLogger(ClassSubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
