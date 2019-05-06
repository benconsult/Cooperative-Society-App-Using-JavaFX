/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rebecca
 */
public class Loan {
     private IntegerProperty idproperty;
    private IntegerProperty amtproperty;
    private StringProperty collproperty;
private StringProperty exproperty;



   public Loan(){
   this.idproperty= new SimpleIntegerProperty();
   this.amtproperty=new SimpleIntegerProperty();
   this.collproperty=new SimpleStringProperty();
   this.exproperty=new SimpleStringProperty();
   
   }
   public int getMemId(){
   return idproperty.get();
   }
public void setMemId(int id){
this.idproperty.set(id);
}
public IntegerProperty getMemberId(){
return idproperty;
}

//for amount
public int getAmount(){
   return amtproperty.get();
   }
public void setAmount(int amt){
this.amtproperty.set(amt);
}
public IntegerProperty getLoanAmount(){
return amtproperty;
}
//for collection date
public String getColl(){
   return collproperty.get();
   }
public void setColl(String coll){
this.collproperty.set(coll);
}
public StringProperty getLoanCollection(){
return collproperty;
}
//for expiry date
public String getExp(){
   return exproperty.get();
   }
public void setExp(String exp){
this.exproperty.set(exp);
}
public StringProperty getLoanExpiry(){
return exproperty;
}
}
