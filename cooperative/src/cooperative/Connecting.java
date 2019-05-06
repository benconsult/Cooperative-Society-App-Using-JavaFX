/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Rebecca
 */
public class Connecting {
    static Connection con;
    public static Connection connector(){
    
    try{
    
    Class.forName("org.sqlite.JDBC");
     con=DriverManager.getConnection("jdbc:sqlite:cooperativelimited.db");
        System.out.println("connected");
        return con;
    }
    catch(Exception e){
    e.printStackTrace();
    return null;
    }

    
    
    
    }
    //method for insert/delete/update
    public static void dbExecQuery(String sqlst) throws SQLException, ClassNotFoundException{
    Statement stmt = null;
    try{
        Connecting.connector();
        stmt=con.createStatement();
        stmt.executeUpdate(sqlst);
    }
    
    catch(SQLException e){
        System.out.println("problem occureed during query");
    throw e;
    }
  finally{
    if(stmt!=null){stmt.close();}
    }
    
    }
    
    public static ResultSet dbQuery(String sqlQuery) throws SQLException, ClassNotFoundException{
    Statement stmt = null;
    ResultSet rs=null;
        CachedRowSetImpl crs= null;
    try{
    Connecting.connector();
    stmt =con.createStatement();
    rs=stmt.executeQuery(sqlQuery);
    crs = new CachedRowSetImpl();
    crs.populate(rs);
    }catch(SQLException e){
        System.out.println("error occur during dbExecute operation"+e);
        throw e;
        
    }
    finally{
    if(rs!=null){
    rs.close();
    }
    if(stmt!=null){stmt.close();}
    }
    return crs;
    }
}