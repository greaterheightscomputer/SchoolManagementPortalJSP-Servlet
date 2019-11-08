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
public class AssessmentDAO {

    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        
        return connect;
    }


    public static int insertRecord(String studentId,String subjectId,String sessionId, String classId,String termId,String test1,String test2,String examscore, String developmentId, String sportId, String ctimeId, String certificateId, String staffId){
        int response = -1;
        String query = "INSERT INTO Assessments VALUES (0,?,?,?,?,?,?,0,0,?,'',?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,studentId);
            ps.setString(2,subjectId);
            ps.setString(3,sessionId);
            ps.setString(4,classId);
            ps.setString(5,termId);
            ps.setInt(6,Integer.parseInt(test1));
            ps.setInt(7,Integer.parseInt(test1));
            ps.setString(8,developmentId);
            ps.setString(9,sportId);
            ps.setString(10,ctimeId);            
            ps.setString(11,certificateId);
            ps.setString(12,staffId);
            
            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int addTest2(String studentId,String subjectId, String classId, String termId,String test2, String developmentId, String sportId, String ctimeId, String certificateId, String staffId){
        int response = -1;
        String query = "UPDATE Assessments SET iTest2=?, iTotal=iTotal+?, cDevelopmentId=?, cSportId=?, cCtimeId=?, cCertificateId=?, cStaffId=? WHERE cStudentId=? AND cSubjectId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1,Integer.parseInt(test2));
            ps.setInt(2,Integer.parseInt(test2));
            ps.setString(3, developmentId);
            ps.setString(4, sportId);
            ps.setString(5, ctimeId);
            ps.setString(6,certificateId);
            ps.setString(7,staffId);
            ps.setString(8, studentId);
            ps.setString(9, subjectId);
            ps.setString(10, classId);
            ps.setString(11, termId);
            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int addExamScore(String studentId,String subjectId, String classId,String termId,String examscore){
        int response = -1;
        String query = "UPDATE Assessments SET iExam=?, iTotal=iTotal+? WHERE cStudentId=? AND cSubjectId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setInt(1,Integer.parseInt(examscore));
            ps.setInt(2,Integer.parseInt(examscore));
            ps.setString(3,studentId);
            ps.setString(4,subjectId);           
            ps.setString(5,classId);
            ps.setString(6,termId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static int updateRemark(String studentId,String subjectId,String classId,String termId,String remark){
        int response = -1;
        String query = "UPDATE Assessments SET vRemark=?, iStatus=1 WHERE cStudentId=? AND cSubjectId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,remark);
            ps.setString(2,studentId);
            ps.setString(3,subjectId);
            ps.setString(4,classId);
            ps.setString(5,termId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int getTotal(String studentId,String subjectId,String classId,String termId){
        int response = -1;
        String query = "SELECT * FROM Assessments WHERE cStudentId=? AND cSubjectId=? AND cClassId=? AND cTermId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,studentId);
            ps.setString(2,subjectId);           
            ps.setString(3,classId);
            ps.setString(4,termId);

            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getInt("iTotal");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static int deleteRecord(String assessmentId){
        int response = -1;
        String query = "DELETE FROM Assessments WHERE iAssessmentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,assessmentId);

            response = ps.executeUpdate();
            if(response > -1){
                response = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    
    public static Vector loadRecord(String assessmentId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Assessments WHERE iAssessmentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1,assessmentId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("iAssessmentId").trim());
                vector.addElement(rs.getString("cStudentId").trim());
                vector.addElement(rs.getString("cSubjectId").trim());
                vector.addElement(rs.getString("cSessionId").trim());
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("cTermId").trim());
                vector.addElement(rs.getString("iTest1").trim());
                vector.addElement(rs.getString("iTest2").trim());
                vector.addElement(rs.getString("iExam").trim());
                vector.addElement(rs.getString("cDevelopmentId").trim());
                vector.addElement(rs.getString("cSportId").trim());
                vector.addElement(rs.getString("cCtimeId").trim());
                vector.addElement(rs.getString("cCertificateId").trim());
                vector.addElement(rs.getString("iBillId").trim());
              
                         }

        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Assessments";
        try {
            st = getConnection().createStatement();

            rs = st.executeQuery(query);
            while(rs.next()){
               String id = rs.getString("iAssessmentId").trim();
               String studentId = rs.getString("cStudentId").trim();
               String subjectId = rs.getString("cSubjectId").trim();
               String classId = rs.getString("cClassId").trim();
               String termId = rs.getString("cTermId").trim();
               String name = StudentsDAO.getName(studentId)+" "+SubjectDAO.getName(subjectId)+" "+ClassDAO.getClassName(classId)+" "+ClassDAO.getTermName(termId);
               map.put(id,name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssessmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return map;
    }

//       public static void main(String et[]){
//
//getConnection();
//insertRecord("STU00001", "SUB00007", "SE00001", "CL00001", "Term01", "16", "", "", "DE00001", "SP00001", "CT00001", "0001/011");
//
//
//
//////deleteRecord("4");
////
//   }

}



