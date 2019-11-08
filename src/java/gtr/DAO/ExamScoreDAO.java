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
public class ExamScoreDAO {

    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        
        return connect;
    }


    public static int insertRecord(String examId,String studentId,String questionId,String score,String date){
        int response = -1;
        String query = "INSERT INTO ExamScores VALUES (0,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);
            ps.setString(2,studentId);
            ps.setString(3,questionId);
            ps.setInt(4,Integer.parseInt(score));
            ps.setString(5,date);
            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int updateScore(String examId,String studentId,String questionId,String score){
        int response = -1;
        String query = "UPDATE ExamScores SET iScore=? WHERE iExamId=? AND cStudentId=? AND iExamQuestionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1,Integer.parseInt(score));
            ps.setString(2,examId);
            ps.setString(3,studentId);
            ps.setString(4,questionId);            

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static int deleteRecord(String examScoreId){
        int response = -1;
        String query = "DELETE FROM ExamScores WHERE iExamScoreId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examScoreId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadRecord(String examScoreId){
        Vector vector = new Vector();
        String query = "SELECT * FROM ExamScores WHERE iExamScoreId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examScoreId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("iExamScoreId").trim());
                vector.addElement(rs.getString("iExamId").trim());
                vector.addElement(rs.getString("cStudentId").trim());
                vector.addElement(rs.getString("vRemark").trim());
                vector.addElement(rs.getString("iScore").trim());
                vector.addElement(rs.getString("dDate").trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int checkId(String examId, String studentId, String questionId){
        int response = -1;
        String query = "SELECT * FROM ExamScores WHERE iExamId=? AND cStudentId=? AND iExamQuestionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);
            ps.setString(2,studentId);
            ps.setString(3,questionId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int getTotalScore(String examId,String studentId){
        int response = -1;
        String query = "SELECT SUM(iScore) FROM ExamScores WHERE iExamId=? AND cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examId);
            ps.setString(2,studentId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM ExamScores";
        try {
            st = getConnection().createStatement();

            rs = st.executeQuery(query);
            while(rs.next()){
               String id = rs.getString("iExamScoreId").trim();
               String name = rs.getString("iExamId").trim();
               map.put(id,name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

}
