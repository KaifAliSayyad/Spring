package emp.storage;

import javax.sql.*;
import javax.sql.rowset.*;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con = null;
    public static JdbcRowSet rs = null;
    private static final String url = "jdbc:postgresql://localhost:5432/empdb";
    private static final String uname = "postgres";
    private static final String password = "tiger";

    private DBConnection(){
        
    }

    static{
        try{
        	con = DriverManager.getConnection(url, uname, password);
            rs = RowSetProvider.newFactory().createJdbcRowSet();
            rs.setUrl(url);
            rs.setUsername(uname);
            rs.setPassword(password);
        }catch(Exception e){
            System.out.println("Error occured while establishing connection. ERROR : "+e);
        }
    }

    public static boolean closeConnection(){
        try{
            rs.close();
            return true;
        }catch(Exception e){
            System.out.println("Error occured while closing connections. ERROR : "+e);
            return false;
        }
    }
}
