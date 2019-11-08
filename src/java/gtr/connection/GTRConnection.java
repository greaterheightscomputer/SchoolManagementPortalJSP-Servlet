package gtr.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GTRConnection {

//    public static String SMS_HOST;
//    public static String CONNECT_DRIVER;
//    public static String CONNECT_USERNAME;
//    public static String CONNECT_PASSWORD;
//    public static String CONNECT_URL;
//
//    public static String initParam() {
//
//        Properties prop = new Properties();
//        try {
//            prop.load(new FileInputStream("config\\config.properties"));
//            CONNECT_DRIVER = prop.getProperty("driver").trim();
//            CONNECT_URL = prop.getProperty("url").trim();
//            CONNECT_USERNAME = prop.getProperty("username").trim();
//            CONNECT_PASSWORD = prop.getProperty("password").trim();
//
//            SMS_HOST = prop.getProperty("host").trim();
//        } catch (IOException ex) {
//            Logger.getLogger(GTRConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return SMS_HOST;
//    }
//
//    public static Connection getConnection() {
//        initParam();
//        Connection con = null;
//        try {
//            Class.forName(CONNECT_DRIVER);
//            con = DriverManager.getConnection(CONNECT_URL, CONNECT_USERNAME, CONNECT_PASSWORD);
//        } catch (SQLException ex) {
//            Logger.getLogger(GTRConnection.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(GTRConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return con;
//    }
//
//
//    public static void main(String[] ee) {
//        Connection con = getConnection();
//
//        System.out.println(con);
//    }
//
//     }





    private static Connection connect;

    public static Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/schportaldb";
        String username = "root";
        String password = "root";
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(GTRConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GTRConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }
    //public static void main(String al[]){
      //  System.out.println("Connection:"+getConnection());

   // }
}



