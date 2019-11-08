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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bin Sunusi
 */
public class AnswerDAO {
     private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();

        return connect;
    }


    public static int insertRecord(String examQuestionId,String examId,String studentId,String examQuestion,String answer){
        int response = -1;
        String query = "INSERT INTO Answers VALUES (?,?,?,?,?)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examQuestionId);
            ps.setString(2,examId);
            ps.setString(3,studentId);
            ps.setString(4,examQuestion);
            ps.setString(5,answer);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    public static int updateRecord(String examQuestionId,String answer){
        int response = -1;
        String query = "UPDATE Answers SET vAnswer=? WHERE iExamQuestionId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(2,examQuestionId);
            ps.setString(1,answer);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    public static int deleteRecord(String studentId){
        int response = -1;
        String query = "DELETE FROM Answers WHERE cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,studentId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

    public static String loadQuestion(String studentId,String questionId,String question){
        String value = "";
        String query = "SELECT * FROM Answers WHERE iExamQuestionId=? AND cStudentId=? AND vExamQuestion=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,questionId);
            ps.setString(2,studentId);
            ps.setString(3,question);

            rs = ps.executeQuery();
            if(rs.next()){
                value = rs.getString("vAnswer").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }

    public static int checkId(String examQuestionId,String examId,String studentId){
        int response = -1;
        String query = "SELECT * FROM Answers WHERE iExamQuestionId=? AND iExamId AND cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,examQuestionId);
            ps.setString(2,examId);
            ps.setString(3,studentId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

}
