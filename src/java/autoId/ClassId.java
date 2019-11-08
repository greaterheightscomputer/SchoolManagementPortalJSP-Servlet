package autoId;

import gtr.connection.GTRConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JamesCal.Java
 */
public class ClassId {

    private static Connection connect;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static Connection getConnection(){
       connect = GTRConnection.getConnection();
       return connect;
    }

    public static int updateId(){
        int status = -1;
        String query = "UPDATE AutoId SET iStatus = iStatus + 1 WHERE cId = 'ID002'";
        try {
            st = getConnection().createStatement();
            status = st.executeUpdate(query);
            if(status > -1){
                status = 0;
            }

        } catch (SQLException ex) {
            return status;
        }
        finally{
            try{
                if(st != null){
                    st.close();
                }
                if(connect != null){
                    connect.close();
                }
            }catch(SQLException sql){
            }
        }

        return status;
    }

    public static int Id(){
        int status = -1;
        String query = "SELECT iStatus FROM AutoId WHERE cId = 'ID002'";
        try {
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                status = rs.getInt("iStatus");
            }

        } catch (SQLException ex) {
            return status;
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
            }catch(SQLException sql){
            }
        }

        return status;
    }

    public static String getId(){
        String returnedId = "";
        int id = Id();

        if(id >= 0 && id <= 9){
            returnedId = "CL0000"+id;
        }
        else if(id >= 10 && id <= 99){
            returnedId = "CL000"+id;
        }
        else if(id >= 100 && id <= 999){
            returnedId = "CL00"+id;
        }
        else if(id >= 1000 && id <= 9999){
            returnedId = "CL0"+id;
        }
        else if(id >= 10000 && id <= 99999){
            returnedId = "CL"+id;
        }
        else if(id > 99999){
            returnedId = "CL"+id;
        }

        return returnedId;
    }

    
}
