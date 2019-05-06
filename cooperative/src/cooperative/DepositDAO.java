/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rebecca
 */
public class DepositDAO {
    public static void insertDeposit(int mem,int past,int curr,int total ) throws SQLException, ClassNotFoundException{
    String sql = "insert into deposit(memberid,pastdeposit,currentdeposit,totaldeposit) values( '"+mem+"', '"+past+"','"+curr+"','"+total+"');";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    
    
    }

    public static void updateDeposit(int mem,int past, int curr,int total)throws ClassNotFoundException,SQLException{
    String sql = "update deposit set pastdeposit= '"+past+"', currentdeposit= '"+curr+"', totaldeposit= '"+total+"' where memberid= '"+mem+"' ";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    
    }
    
public static void deleteDeposit(int mem)throws ClassNotFoundException,SQLException{
String sql="delete from deposit where memberid= '"+mem+"' ";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    

}

//
//method to get record from the database
    public static ObservableList<Deposit> getAllRecords() throws ClassNotFoundException,SQLException{
    String sql = "select* from deposit";
    
    try{
        ResultSet rsSet = Connecting.dbQuery(sql);
        ObservableList<Deposit> depoList = getDepositObjects(rsSet);//create getDepositObjects Method
        return depoList;
    }catch(SQLException e){
        System.out.println("Error occurred while fetching the records from db"+e);
        e.printStackTrace();
        throw e;
    }
    
    }
//getDepositObjects Method
    private static ObservableList<Deposit> getDepositObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException {
        try{
         ObservableList<Deposit> depolist= FXCollections.observableArrayList();
       while(rsSet.next()){
       Deposit dep = new Deposit();
      dep.setMemId(rsSet.getInt("memberid"));//columname of sqlite table
      dep.setPast(rsSet.getInt("pastdeposit"));
      dep.setCurrent(rsSet.getInt("currentdeposit"));
      dep.setTotal(rsSet.getInt("totaldeposit"));
      
      depolist.add(dep);
       }
       return depolist;
        }catch(SQLException e){
            System.out.println("Error occurred while fetching record fro the Db"+e);
            e.printStackTrace();
            throw e;
        }
    }
   //method to search record from tableview
public static ObservableList<Deposit> searchDeposit(String memID) throws ClassNotFoundException,SQLException{
    String sql = "select* from deposit where memberid = "+memID;
    try{
    ResultSet rsSet = Connecting.dbQuery(sql);
    ObservableList<Deposit> list = getDepositObjects(rsSet);
    return list;
    
    }catch(SQLException e){
        System.out.println("Error occurred while searching the record"+e);
    e.printStackTrace();
    throw e;}
    
    }


}
