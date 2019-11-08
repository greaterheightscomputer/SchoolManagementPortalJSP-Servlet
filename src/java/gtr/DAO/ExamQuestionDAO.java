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
public class ExamQuestionDAO {

    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        
        return connect;
    }

    public static int insertRecord(String examQuestion,String answer01,String answer02,String answer03, String answer04,String correctAnswer,String mark,String examId){
        int response = -1;
        String query = "INSERT INTO ExamQuestions VALUES (0,?,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examQuestion);
            ps.setString(2,answer01);
            ps.setString(3,answer02);
            ps.setString(4,answer03);
            ps.setString(5,answer04);
            ps.setString(6,correctAnswer);
            ps.setInt(7,Integer.parseInt(mark));
            ps.setString(8,examId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int updateRecord(String examQuestionId,String examQuestion,String answer01,String answer02,String answer03, String answer04,String correctAnswer,String mark,String examId){
        int response = -1;
        String query = "UPDATE ExamQuestions SET vExamQuestion=?,vAnswer01=?,vAnswer02=?,vAnswer03=?,vAnswer04=?,vCorrectAnswer=?,iMark=?,iExamId=? WHERE iExamQuestionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(9,examQuestionId);
            ps.setString(1,examQuestion);
            ps.setString(2,answer01);
            ps.setString(3,answer02);
            ps.setString(4,answer03);
            ps.setString(5,answer04);
            ps.setString(6,correctAnswer);
            ps.setInt(7,Integer.parseInt(mark));
            ps.setString(8,examId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
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


    public static int deleteRecord(String examQuestionId){
        int response = -1;
        String query = "DELETE FROM ExamQuestions WHERE iExamQuestionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examQuestionId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadRecord(String examQuestionId){
        Vector vector = new Vector();
        String query = "SELECT * FROM ExamQuestions WHERE iExamQuestionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examQuestionId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("iExamQuestionId").trim());
                vector.addElement(rs.getString("vExamQuestion").trim());
                vector.addElement(rs.getString("vAnswer01").trim());
                vector.addElement(rs.getString("vAnswer02").trim());
                vector.addElement(rs.getString("vAnswer03").trim());
                vector.addElement(rs.getString("vAnswer04").trim());
                vector.addElement(rs.getString("vCorrectAnswer").trim());
                vector.addElement(rs.getString("iMark").trim());
                vector.addElement(rs.getString("iExamId").trim());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static ResultSet loadExam(String examId){
//        Vector vector = new Vector();
        String query = "SELECT * FROM ExamQuestions WHERE iExamId='"+examId.trim()+"'";
        try {
            st = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            rs = st.executeQuery(query);
//            if(rs.next()){
//                vector.addElement(rs.getString("cExamQuestionId").trim());
//                vector.addElement(rs.getString("vExamQuestion").trim());
//                vector.addElement(rs.getString("vAnswer01").trim());
//                vector.addElement(rs.getString("vAnswer02").trim());
//                vector.addElement(rs.getString("vAnswer03").trim());
//                vector.addElement(rs.getString("vAnswer04").trim());
//                vector.addElement(rs.getString("vCorrectAnswer").trim());
//                vector.addElement(rs.getString("iMark").trim());
//                vector.addElement(rs.getString("cExamId").trim());
//            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static int checkId(String examQuestionId){
        int response = -1;
        String query = "SELECT * FROM ExamQuestions WHERE iExamQuestionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examQuestionId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String getCorrectAnswer(String questionId,String examId){
        String response = null;
        String query = "SELECT * FROM ExamQuestions WHERE iExamQuestionId=? AND iExamId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,questionId);
            ps.setString(2,examId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getString("vCorrectAnswer").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM ExamQuestions";
        try {
            st = getConnection().createStatement();

            rs = st.executeQuery(query);
            while(rs.next()){
               String id = rs.getString("iExamQuestionId").trim();
               String name = rs.getString("vExamQuestion").trim();
               map.put(id,name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return map;
    }

}
