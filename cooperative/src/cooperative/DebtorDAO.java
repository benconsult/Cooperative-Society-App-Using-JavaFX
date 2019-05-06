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
public class DebtorDAO {
    public static void insertDebtor(int mem,int act,int ref,int bal ) throws SQLException, ClassNotFoundException{
    String sql = "insert into debtor(memberid,actualdebt,amountrefunded,balance) values( '"+mem+"', '"+act+"','"+ref+"','"+bal+"');";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    
    
    }

    public static void updateDebtor(int mem,int act, int ref,int bal)throws ClassNotFoundException,SQLException{
    String sql = "update debtor set actualdebt= '"+act+"', amountrefunded= '"+ref+"', balance= '"+bal+"' where memberid= '"+mem+"' ";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    
    }
    
public static void deleteDebtor(int mem)throws ClassNotFoundException,SQLException{
String sql="delete from debtor where memberid= '"+mem+"' ";
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
    public static ObservableList<Debtor> getAllRecords() throws ClassNotFoundException,SQLException{
    String sql = "select* from debtor";
    
    try{
        ResultSet rsSet = Connecting.dbQuery(sql);
        ObservableList<Debtor> debtorList = getDebtorObjects(rsSet);//create getDepositObjects Method
        return debtorList;
    }catch(SQLException e){
        System.out.println("Error occurred while fetching the records from db"+e);
        e.printStackTrace();
        throw e;
    }
    
    }
//getDepositObjects Method
    private static ObservableList<Debtor> getDebtorObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException {
        try{
         ObservableList<Debtor> debtorlist= FXCollections.observableArrayList();
       while(rsSet.next()){
       Debtor deb = new Debtor();
      deb.setMemId(rsSet.getInt("memberid"));//columname of sqlite table
      deb.setAct(rsSet.getInt("actualdebt"));
      deb.setRefund(rsSet.getInt("amountrefunded"));
      deb.setBalance(rsSet.getInt("balance"));
      
      debtorlist.add(deb);
       }
       return debtorlist;
        }catch(SQLException e){
            System.out.println("Error occurred while fetching record fro the Db"+e);
            e.printStackTrace();
            throw e;
        }
    }
   //method to search record from tableview
public static ObservableList<Debtor> searchDeposit(String memID) throws ClassNotFoundException,SQLException{
    String sql = "select* from debtor where memberid = "+memID;
    try{
    ResultSet rsSet = Connecting.dbQuery(sql);
    ObservableList<Debtor> list = getDebtorObjects(rsSet);
    return list;
    
    }catch(SQLException e){
        System.out.println("Error occurred while searching the record"+e);
    e.printStackTrace();
    throw e;}
    
    }


}
