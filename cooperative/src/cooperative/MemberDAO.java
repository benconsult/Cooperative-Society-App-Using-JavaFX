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
public class MemberDAO {
    public static void insertMember(int mem,String first,String sur,String sx,String occup,String enroll,String addr ) throws SQLException, ClassNotFoundException{
    String sql = "insert into members(memberid,firstname,surname,sex,occupation,enrollmentdate,address) values( '"+mem+"', '"+first+"','"+sur+"','"+sx+"', '"+occup+"', '"+enroll+"', '"+addr+"');";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    }
    public static void updateMember(int mem,String first,String sur,String sx,String occup,String enroll,String addr) throws SQLException,ClassNotFoundException{
    String sql = "update members set firstname= '"+first+"', surname= '"+sur+"', sex= '"+sx+"', occupation= '"+occup+"', enrollmentdate= '"+enroll+"', address= '"+addr+"' where memberid= '"+mem+"' ";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    
    }
    public static void deleteMember(int mem) throws SQLException,ClassNotFoundException{
    String sql="delete from members where memberid= '"+mem+"' ";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    }
    //unused method
    public static void display(int mem,String first,String sur,String sx,String occup,String enroll,String addr)throws SQLException,ClassNotFoundException{
    String sql="select* from members where memberid= ' "+mem+"' ";
    try{
    Connecting.dbExecQuery(sql);
    
    
    }catch(SQLException e){
        System.out.println("Exception occurred while performing db query"+e);
    e.printStackTrace();
    throw e;
    
    }
    
    
    }
    //method to get record from the database
    public static ObservableList<Member> getAllRecords() throws ClassNotFoundException,SQLException{
    String sql = "select* from members";
    
    try{
        ResultSet rsSet = Connecting.dbQuery(sql);
        ObservableList<Member> memList = getMemberObjects(rsSet);//create getMemberObjects Method
        return memList;
    }catch(SQLException e){
        System.out.println("Error occurred while fetching the records from db"+e);
        e.printStackTrace();
        throw e;
    }
    
    }
//getMemberObjects Method
    private static ObservableList<Member> getMemberObjects(ResultSet rsSet) throws ClassNotFoundException,SQLException {
        try{
         ObservableList<Member> memlist= FXCollections.observableArrayList();
       while(rsSet.next()){
       Member mem = new Member();
      mem.setMemId(rsSet.getInt("memberid"));//columname of sqlite table
      mem.setFirstname(rsSet.getString("firstname"));
      mem.setSurname(rsSet.getString("surname"));
      mem.setSex(rsSet.getString("sex"));
      mem.setOccupation(rsSet.getString("occupation"));
      mem.setAddress(rsSet.getString("address"));
      mem.setEnroll(rsSet.getString("enrollmentdate"));
      memlist.add(mem);
       }
       return memlist;
        }catch(SQLException e){
            System.out.println("Error occurred while fetching record fro the Db"+e);
            e.printStackTrace();
            throw e;
        }
    }
    public static ObservableList<Member> searchMember(String memID) throws ClassNotFoundException,SQLException{
    String sql = "select* from members where memberid = "+memID;
    try{
    ResultSet rsSet = Connecting.dbQuery(sql);
    ObservableList<Member> list = getMemberObjects(rsSet);
    return list;
    
    }catch(SQLException e){
        System.out.println("Error occurred while searching the record"+e);
    e.printStackTrace();
    throw e;}
    
    }
}
