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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Bin Sunusi
 */
public class StaffDAO {
    private static Connection connect;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    private static Connection getConnection(){
        connect = GTRConnection.getConnection();
        return connect;
    }

    public static int insertRecord(String staffId,String surname,String firstName,String gender,String dob,String address,String phone,String email,String qualification,String category,String employmentDate,String salary){
        int status = -1;
        String query = "INSERT INTO Staffs VALUES (?,?,?,?,?,?,?,?,?,?,?,?,0)";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, staffId);
            ps.setString(2, surname);
            ps.setString(3, firstName);
            ps.setString(4, gender);
            ps.setString(5, dob);
            ps.setString(6, address);
            ps.setString(7, phone);
            ps.setString(8, email);
            ps.setString(9, qualification);
            ps.setString(10, category);
            ps.setString(11, employmentDate);
            ps.setDouble(12, Double.parseDouble(salary));

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

    public static int updateRecord(String staffId,String surname,String firstName,String gender,String dob,String address,String phone,String email,String qualification,String category,String employmentDate,String salary){
        int status = -1;
        String query = "UPDATE Staffs SET vSurName=?,vFirstName=?,cGender=?,dDateOfBirth=?,vAddress=?,cPhoneNumber=?,vEmailId=?,vQualification=?,vCategory=?,dDateOfEmployment=?,mSalary=? WHERE cStaffId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(12, staffId);
            ps.setString(1, surname);
            ps.setString(2, firstName);
            ps.setString(3, gender);
            ps.setString(4, dob);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, email);
            ps.setString(8, qualification);
            ps.setString(9, category);
            ps.setString(10, employmentDate);
            ps.setDouble(11, Double.parseDouble(salary));

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

    public static int deleteRecord(String staffId){
        int status = -1;
        String query = "DELETE FROM Staffs WHERE cStaffId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, staffId);

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
        String query = "SELECT * FROM Staffs WHERE cStaffId=?";
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

  

    public static String getName(String id){
        String status = "";
        String query = "SELECT * FROM Staffs WHERE cStaffId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                status = rs.getString("vSurName").trim()+" "+rs.getString("vFirstName").trim();
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
    public static Vector loadRecord(String staffId){
        Vector vector = new Vector();
        String query = "SELECT * FROM Staffs WHERE cStaffId=?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, staffId);

            rs = ps.executeQuery();
            if(rs.next()){
                vector.addElement(rs.getString("cStaffId").trim());
                vector.addElement(rs.getString("vSurName").trim());
                vector.addElement(rs.getString("vFirstName").trim());
                vector.addElement(rs.getString("cGender").trim());
                vector.addElement(rs.getString("dDateOfBirth").trim());
                vector.addElement(rs.getString("vAddress").trim());
                vector.addElement(rs.getString("cPhoneNumber").trim());
                vector.addElement(rs.getString("vEmailId").trim());
                vector.addElement(rs.getString("vQualification").trim());
                vector.addElement(rs.getString("vCategory").trim());
                vector.addElement(rs.getString("dDateOfEmployment").trim());
                vector.addElement(rs.getString("mSalary").trim());
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

    public static LinkedHashMap loadCombo(){
        LinkedHashMap status = new LinkedHashMap();
        String query = "SELECT * FROM Staffs";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){

                String id = rs.getString("cStaffId").trim();
                String name = rs.getString("vSurName").trim()+" "+rs.getString("vFirstName").trim();
                status.put(id, name);
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

        return status;
    }
//public static void main(String et[]){
//
//          getConnection();
////      LinkedHashMap map = StaffDAO.loadCombo();
//              if (map.isEmpty()) {
//                } else {
//                    Set keys = map.keySet();
//                    Iterator itr = keys.iterator();
//                    for (int i = 0; i < keys.size(); i++) {
//                        String selectedId = itr.next().toString();
//                        String Name = map.get(selectedId).toString();
//                        System.out.print("<OPTION value='" + selectedId + "'>" + Name + "</OPTION>");
//                    }
//                }
//insertRecord("ST00001", "Adebara", "Khadijat", "Female", "2010-02-28", "24B, Pike Street, Off Okesuna Street, Lagos Island, Lagos", "080378325540", "adebarakhadijatabimbola@yahoo.com", "Phd", "Teachering Staff", "2011-09-10", "200000");
//}
}
