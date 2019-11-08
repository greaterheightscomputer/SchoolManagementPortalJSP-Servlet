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
 * @author JamesCal.Java
 */
public class ExamDAO {

    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        
        return connect;
    }

    public static int insertRecord(String examName,String numberOfQuestion,String passMark,String sessionId, String classId,String subjectId,String termId){
        int response = -1;
        String query = "INSERT INTO Exams VALUES (0,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examName);
            ps.setInt(2,Integer.parseInt(numberOfQuestion));
            ps.setInt(3,Integer.parseInt(passMark));
            ps.setString(4,sessionId);
            ps.setString(5,classId);
            ps.setString(6,subjectId);
            ps.setString(7,termId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

   
    public static int updateRecord(String examId,String examName,String numberOfQuestion,String passMark,String sessionId, String classId,String subjectId,String termId){
        int response = -1;
        String query = "UPDATE Exams SET vExamName=?, iExamQuestion=?, iPassMark=?, cSessionId=?, cClassId=?, cSubjectId=?, cTermId=? WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examName);
            ps.setInt(2,Integer.parseInt(numberOfQuestion));
            ps.setInt(3,Integer.parseInt(passMark));
            ps.setString(4,sessionId);
            ps.setString(5,classId);
            ps.setString(6,subjectId);
            ps.setString(7,termId);
            ps.setInt(8,Integer.parseInt(examId));

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static int deleteRecord(String examId){
        int response = -1;
        String query = "DELETE FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadRecord(String examId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("iExamId").trim());
                vector.addElement(rs.getString("vExamName").trim());
                vector.addElement(rs.getString("iExamQuestion").trim());
                vector.addElement(rs.getString("iPassMark").trim());
                vector.addElement(rs.getString("cSessionId").trim());
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("cSubjectId").trim());
                vector.addElement(rs.getString("cTermId").trim());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int checkId(String examId){
        int response = -1;
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int getNumberOfQuestion(String examId){
        int response = -1;
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getInt("iExamQuestion");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String getExamName(String examId){
        String response = "";
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getString("vExamName").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String getSesionId(String examId){
        String response = "";
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getString("cSessionId").trim();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public static String getClassId(String examId){
        String response = "";
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getString("cClassId").trim();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String getSubjectId(String examId){
        String response = "";
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getString("cSubjectId").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    public static String getTermId(String examId){
        String response = "";
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getString("cTermId").trim();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int getPassMark(String examId){
        int response = -1;
        String query = "SELECT * FROM Exams WHERE iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getInt("iPassMark");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return response;
    }

    public static LinkedHashMap loadCombo(){
        LinkedHashMap map = new LinkedHashMap();
        String query = "SELECT * FROM Exams";
        try {
            st = getConnection().createStatement();
            ResultSet rs1 = st.executeQuery(query);
            while(rs1.next()){
               String id = rs1.getString("iExamId").trim();
               String cid = rs1.getString("cClassId").trim();
               String sid = rs1.getString("cSubjectId").trim();
               String name = SubjectDAO.getName(sid)+" : "+getExamName(id)+" : "+ClassDAO.getClassName(cid);
               map.put(id,name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static LinkedHashMap loadComboById(String examId){
        LinkedHashMap map = new LinkedHashMap();
        String query = "SELECT * FROM Exams WHERE iExamId="+Integer.parseInt(examId);
        try {
            st = getConnection().createStatement();

            rs = st.executeQuery(query);
            while(rs.next()){
               String id = rs.getString("iExamId").trim();
               String cid = rs.getString("cClassId").trim();
               String sid = rs.getString("cSubjectId").trim();
               String name = SubjectDAO.getName(sid)+" : "+getExamName(id)+" : "+ClassDAO.getClassName(cid);
               map.put(id,name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
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

//    public static void main(String et[]){
//        LinkedHashMap map = ExamDAO.loadCombo();
//                                             if (map.isEmpty()) {
//                                             } else {
//                                                 Set keys = map.keySet();
//                                                 Iterator itr = keys.iterator();
//                                                 for (int i = 0; i < keys.size(); i++) {
//                                                     String selectedId = itr.next().toString();
//                                                     String Name = map.get(selectedId).toString();
//
//                                                     System.out.println("\n"+selectedId + "     "+Name);
//
//                                                 }
//
//                                             }
//    }

}
