/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gtr.DAO;
//import config.SMSConfig;
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
public class StudentsDAO {
    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }                                                           


    public static int insertRecord(String studentId, String firstName, String lastName, String otherNames, String gender, String dateOfBirth, String admissionDate, String sessionId, String classId , String termId, String address, String parentName, String occupation, String phoneNumber, String mobileNumber, String staffId, String picture, String billId){
        int status = -1;
        String query = "INSERT INTO Students VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, studentId);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, otherNames);
            ps.setString(5, gender);
            ps.setString(6, dateOfBirth);
            ps.setString(7, admissionDate);
            ps.setString(8, sessionId);
            ps.setString(9, classId);
            ps.setString(10, termId);
            ps.setString(11, address);
            ps.setString(12, parentName);
            ps.setString(13, occupation);
            ps.setString(14, phoneNumber);
            ps.setString(15, mobileNumber);
            ps.setString(16, staffId);
            ps.setString(17, picture);
            ps.setString(18, billId);
          
            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    

    public static int updateRecord(String studentId, String firstName, String lastName, String otherNames, String gender, String dateOfBirth, String admissionDate, String sessionId, String classId , String termId, String address, String parentName, String occupation, String phoneNumber, String mobileNumber, String staffId, String picture, String billId){
        int status = -1;
        String query = "UPDATE Students SET vFirstName=?, vLastName=?, vOtherNames=?, cGender=?, dDateOfBirth=?, dAdmissionDate=?, cSessionId=?, cClassId=?, cTermId=?, vAddress=?, vParentName=?, vOccupation=?, cPhoneNumber=?, cMobileNumber=?, cStaffId=?, vImage=?, iBillId=? WHERE cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(18, studentId);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, otherNames);
            ps.setString(4, gender);
            ps.setString(5, dateOfBirth);
            ps.setString(6, admissionDate);
            ps.setString(7, sessionId);
            ps.setString(8, classId);
            ps.setString(9, termId);
            ps.setString(10, address);
            ps.setString(11, parentName);
            ps.setString(12, occupation);
            ps.setString(13, phoneNumber);
            ps.setString(14, mobileNumber);
            ps.setString(15, staffId);
            ps.setString(16, picture);
            ps.setString(17, billId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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
  
    public static int deleteRecord(String studentId){
        int status = -1;
        String query = "DELETE FROM Students WHERE cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, studentId);

            status = ps.executeUpdate();
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        String query = "SELECT * FROM Students WHERE cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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

public static int chagePicture(String studentId,String picture){
        int respones = -1;
        String query = "UPDATE Students SET vImage=? WHERE cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(2, studentId);
            ps.setString(1, picture);
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

    public static String getName(String id){
        String status = "";
        String query = "SELECT * FROM Students WHERE cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = rs.getString("vFirstName").trim()+" "+rs.getString("vLastName").trim();
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadRecord(String studentId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Students WHERE cStudentId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, studentId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cStudentId").trim());
                vector.addElement(rs.getString("vFirstName").trim());
                vector.addElement(rs.getString("vLastName").trim());
                vector.addElement(rs.getString("vOtherNames").trim());
                vector.addElement(rs.getString("cGender").trim());
                vector.addElement(rs.getString("dDateOfBirth").trim());
                vector.addElement(rs.getString("dAdmissionDate").trim());
                vector.addElement(rs.getString("cSessionId").trim());
                vector.addElement(rs.getString("cClassId").trim());
                vector.addElement(rs.getString("cTermId").trim());
                vector.addElement(rs.getString("vAddress").trim());
                vector.addElement(rs.getString("vParentName").trim());
                vector.addElement(rs.getString("vOccupation").trim());
                vector.addElement(rs.getString("cPhoneNumber").trim());
                vector.addElement(rs.getString("cMobileNumber").trim());
                vector.addElement(rs.getString("cStaffId").trim());
                vector.addElement(rs.getString("vImage").trim());                
                vector.addElement(rs.getString("iBillId").trim());
            }

        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Vector loadStudentsNumbers(){
        Vector vector = new Vector();
        String query = "SELECT * FROM Students";
        try {
            st = getConnection().createStatement();

            rs = st.executeQuery(query);
            while(rs.next()){
                vector.addElement(rs.getString("cMobileNumber").trim());
            }
        } catch (SQLException ex) {
            return vector;
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
            }catch(Exception ex){
            }
        }

        return vector;
    }

//     public static String getPhoneNumbers(){
//        String numbers = "";
//        Vector vector = new Vector();
//        vector = SMSConfig.getStudentsNumber();
//
//        for(Enumeration e = vector.elements();e.hasMoreElements();){
//            numbers = numbers+"234"+e.nextElement().toString().trim().substring(1);
//            if(e.hasMoreElements()){
//                numbers = numbers + ",";
//            }
//
//        }
//
//        return numbers;
//
//    }

    public static LinkedHashMap loadCombo(){
        LinkedHashMap map = new LinkedHashMap();
        String query = "SELECT * FROM Students ORDER BY cStudentId";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){

                String id = rs.getString("cStudentId").trim();
                String name = rs.getString("vFirstName").trim()+" "+rs.getString("vLastName").trim();
                map.put(id, name);
            }


        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
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




//public static void main(String et[]){
//
//          getConnection();
//
//          updateRecord("STU00001", "Ameedah", "Orimadegun", "Oyindamola", "Female", "2007-04-18", "2010-05-19", "SE00001", "CL00001", "Term01", "24B, Pike Street, Lagos Island", "Mr. Adebara", "Trading", "08037832554", "08037832554", "ST00001", "oris7.jpg","1");
////          insertRecord("0003", "Ola", "Wale", null, null, null, null, null, null, null, null, null, null, null, null);
////          deleteRecord("0003");
//
//
////          loadRecord("STU00005");
////      LinkedHashMap map = StudentsDAO.loadCombo();
////
////              if (map.isEmpty()) {
////
////                } else {
////
////                    Set keys = map.keySet();
////                    Iterator itr = keys.iterator();
////                    for (int i = 0; i < keys.size(); i++) {
////                        String selectedId = itr.next().toString();
////                        String Name = map.get(selectedId).toString();
////                        System.out.print("<OPTION value='" + selectedId + "'>" + Name + "</OPTION>");
////                    }
//                }
}




