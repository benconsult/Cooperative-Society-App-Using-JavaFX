/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import java.sql.*;

/**
 *
 * @author Rebecca
 */
public class ConTest {
    Connection cont;
    public ConTest(){
    cont = Connecting.connector();
    if(cont==null){
        System.out.println("connection not successful");
        System.exit(1);}
    }

public boolean isDbconnected(){
try{
return !cont.isClosed();
}
catch(SQLException e){
e.printStackTrace();
return false;}
}
}