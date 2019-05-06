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
public class LoanDAO {
    public static void insertLoan(int mem,int amt,String coll,String exp ) throws SQLException, ClassNotFoundException{
    String sql = "insert into loan(memberid,amount,collectiondate,expirydate) values( '"+mem+"', '"+amt+"','"+coll+"','"+exp+"');";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    
    
    }

    public static void updateLoan(int mem,int amt, String coll,String exp)throws ClassNotFoundException,SQLException{
    String sql = "update loan set amount= '"+amt+"', collectiondate= '"+coll+"', expirydate= '"+exp+"' where memberid= '"+mem+"' ";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    
    }
    
public static void deleteLoan(int mem)throws ClassNotFoundException,SQLException{
String sql="delete from loan where memberid= '"+mem+"' ";
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
    public static ObservableList<Loan> getAllRecords() throws ClassNotFoundException,SQLException{
    String sql = "select* from Loan";
    
    try{
        ResultSet rsSet = Connecting.dbQuery(sql);
        ObservableList<Loan> loanList = getLoanObjects(rsSet);//create getDepositObjects Method
        return loanList;
    }catch(SQLException e){
        System.out.println("Error occurred while fetching the records from db"+e);
        e.printStackTrace();
        throw e;
    }
    
    }
//getDepositObjects Method
    private static ObservableList<Loan> getLoanObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException {
        try{
         ObservableList<Loan> loanlist= FXCollections.observableArrayList();
       while(rsSet.next()){
       Loan loan = new Loan();
      loan.setMemId(rsSet.getInt("memberid"));//columname of sqlite table
      loan.setAmount(rsSet.getInt("amount"));
      loan.setColl(rsSet.getString("collectiondate"));
      loan.setExp(rsSet.getString("expirydate"));
      
      loanlist.add(loan);
       }
       return loanlist;
        }catch(SQLException e){
            System.out.println("Error occurred while fetching record fro the Db"+e);
            e.printStackTrace();
            throw e;
        }
    }
   //method to search record from tableview
public static ObservableList<Loan> searchLoan(String memID) throws ClassNotFoundException,SQLException{
    String sql = "select* from loan where memberid = "+memID;
    try{
    ResultSet rsSet = Connecting.dbQuery(sql);
    ObservableList<Loan> list = getLoanObjects(rsSet);
    return list;
    
    }catch(SQLException e){
        System.out.println("Error occurred while searching the record"+e);
    e.printStackTrace();
    throw e;}
    
    }


}
