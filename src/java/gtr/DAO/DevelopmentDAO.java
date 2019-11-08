

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

 
public class DevelopmentDAO {
      private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }

    public static int insertRecord(String developmentId, String studentId, String  sessionId, String classId, String termId, String hieghtBegin, String hieghtEnd, String weightBegin, String weightEnd, String daysAbsent, String nature, String organization, String officeHeld, String contribution, String principal, String teacher, String vacation, String  resumption){
        int status = -1;
        String query = "INSERT INTO Developments VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, developmentId);
            ps.setString(2, studentId);
            ps.setString(3, sessionId);
            ps.setString(4, classId);
            ps.setString(5, termId);
            ps.setString(6, hieghtBegin);
            ps.setString(7, hieghtEnd);
            ps.setString(8, weightBegin);
            ps.setString(9, weightEnd);
            ps.setString(10, daysAbsent);
            ps.setString(11, nature);
            ps.setString(12, organization);
            ps.setString(13, officeHeld);
            ps.setString(14, contribution);
            ps.setString(15, principal);
            ps.setString(16, teacher);
            ps.setString(17, vacation);
            ps.setString(18, resumption);
            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DevelopmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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

 
    public static int updateRecord(String developmentId, String studentId, String  sessionId, String classId, String termId, String hieghtBegin, String hieghtEnd, String weightBegin, String weightEnd, String daysAbsent, String nature, String organization, String officeHeld, String contribution, String principal, String teacher, String vacation, String  resumption){
        int status = -1;
        String query = "UPDATE Developments SET cStudentId=?, cSessionId=?, cClassId=?, cTermId=?, vHieghtBegin=?, vHieghtEnd=?, vWeightBegin=?, vWeightEnd=?, vDaysAbsent=?, VNature=?, vOrganization=?, vOfficeHeld=?, vContribution=?, vPrincipal=?, vTeacher=?, dVacation=?, dResumption=? WHERE cDevelopmentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(18, developmentId);
            ps.setString(1, studentId);
            ps.setString(2, sessionId);
            ps.setString(3, classId);
            ps.setString(4, termId);
            ps.setString(5, hieghtBegin);
            ps.setString(6, hieghtEnd);
            ps.setString(7, weightBegin);
            ps.setString(8, weightEnd);
            ps.setString(9, daysAbsent);
            ps.setString(10, nature);
            ps.setString(11, organization);
            ps.setString(12, officeHeld);
            ps.setString(13, contribution);
            ps.setString(14, principal);
            ps.setString(15, teacher);
            ps.setString(16, vacation);
            ps.setString(17, resumption);
            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DevelopmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int deleteRecord(String developmentId){
        int status = -1;
        String query = "DELETE FROM Developments WHERE cDevelopmentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, developmentId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DevelopmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Developments WHERE cDevelopmentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DevelopmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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


    public static Vector loadRecord(String developmentId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Developments WHERE cDevelopmentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, developmentId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cDevelopmentId").trim());
                vector.addElement(rs.getString("cStudentId").trim());
                vector.addElement(rs.getString("cSessionId").trim());
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("cTermId").trim());
                vector.addElement(rs.getString("vHieghtBegin").trim());
                vector.addElement(rs.getString("vHieghtEnd").trim());
                vector.addElement(rs.getString("vWeightBegin").trim());
                vector.addElement(rs.getString("vWeightEnd").trim());
                vector.addElement(rs.getString("vDaysAbsent").trim());
                vector.addElement(rs.getString("VNature").trim());
                vector.addElement(rs.getString("vOrganization").trim());
                vector.addElement(rs.getString("vOfficeHeld").trim());
                vector.addElement(rs.getString("vContribution").trim());
                vector.addElement(rs.getString("vPrincipal").trim());
                vector.addElement(rs.getString("vTeacher").trim());
                vector.addElement(rs.getString("dVacation").trim());
                vector.addElement(rs.getString("dResumption").trim());
                     }

        } catch (SQLException ex) {
            Logger.getLogger(DevelopmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Developments ORDER BY cDevelopmentId";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
               String id = rs.getString("cDevelopmentId").trim();
               String studentId = rs.getString("cStudentId").trim();
               String sessionId = rs.getString("cSessionId").trim();
               String classId = rs.getString("cClassId").trim();
               String termId = rs.getString("cTermId").trim();
               String name = StudentsDAO.getName(studentId)+" "+SessionDAO.getSessionName(sessionId)+" "+ClassDAO.getClassName(classId)+" "+ClassDAO.getTermName(termId);
               map.put(id,name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DevelopmentDAO.class.getName()).log(Level.SEVERE, null, ex);
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

//   public static void main(String et[]){
//
//getConnection();
//////////updateRecord("1", "1", "STU00001", "60times", "5times", "40times", "5times");
//////////
//insertRecord("DE00001","STU00001", "40m", "30m", "35kg", "405kg", "8times", "Fever", "Debt Club", "Member", "Immobilization of member", "She is a good student", "She is good", "2010-03-09", "2010-04-09");
//insertRecord("DE00002","STU00002", "40m", "30m", "35kg", "405kg", "8times", "Fever", "Jeb Club", "Member", "Financial contribution", "She is a good student", "She is good", "2011-01-19", "2011-02-09");
//insertRecord("DE00003","STU0003", "40m", "30m", "35kg", "405kg", "8times", "Fever", "Science Club", "Member", "Moral contribution", "he is a good", "he is good", "2011-05-10", "2011-06-09");
//
//   }

	
}
