//package config;
//
//
//import gtr.DAO.StudentsDAO;
//import gtr.connection.GTRConnection;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class SMSConfig {
//
//    public static String SMS_HOST = GTRConnection.SMS_HOST;
//    public static String CONNECT_DRIVER = GTRConnection.CONNECT_DRIVER;
//    public static String CONNECT_USERNAME = GTRConnection.CONNECT_USERNAME;
//    public static String CONNECT_PASSWORD = GTRConnection.CONNECT_PASSWORD;
//    public static String CONNECT_URL = GTRConnection.CONNECT_URL;
//    public static Vector vector = new Vector();
//
//    public static Connection connect;
//
//    public static void setHost(String host){
//        SMS_HOST = host;
//    }
//    public static String getHost(){
//        return SMS_HOST;
//    }
//
//    public static void setDriver(String driver){
//        CONNECT_DRIVER = driver;
//    }
//    public static String getDriver(){
//        return CONNECT_DRIVER;
//    }
//
//    public static void setURL(String URL){
//        CONNECT_URL = URL;
//    }
//    public static String getURL(){
//        return CONNECT_URL;
//    }
//
//    public static void setUsername(String username){
//        CONNECT_USERNAME = username;
//    }
//    public static String getUsername(){
//        return CONNECT_USERNAME;
//    }
//
//    public static void setPassword(String password){
//        CONNECT_PASSWORD = password;
//    }
//    public static String getPassword(){
//        return CONNECT_PASSWORD;
//    }
//
//    public static void setStudentsNumber(Vector vector){
//        SMSConfig.vector = vector;
//    }
//    public static Vector getStudentsNumber(){
//        return StudentsDAO.loadStudentsNumbers();
//    }
//
//    public static Connection getConnection(){
//        try {
//            Class.forName(CONNECT_DRIVER);
//            connect = DriverManager.getConnection(CONNECT_URL, CONNECT_USERNAME, CONNECT_PASSWORD);
//        } catch (SQLException ex) {
//            Logger.getLogger(SMSConfig.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SMSConfig.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return connect;
//    }
//
//
//}
