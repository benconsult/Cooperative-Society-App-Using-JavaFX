/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Rebecca
 */
public class Debtor {
     private IntegerProperty idproperty;
    private IntegerProperty actproperty;
    private IntegerProperty refproperty;
private IntegerProperty balproperty;



   public Debtor(){
   this.idproperty= new SimpleIntegerProperty();
   this.actproperty=new SimpleIntegerProperty();
   this.refproperty=new SimpleIntegerProperty();
   this.balproperty=new SimpleIntegerProperty();
   
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

//for actual debt
public int getAct(){
   return actproperty.get();
   }
public void setAct(int act){
this.actproperty.set(act);
}
public IntegerProperty getActualDebt(){
return actproperty;
}
//for current
public int getRefund(){
   return refproperty.get();
   }
public void setRefund(int ref){
this.refproperty.set(ref);
}
public IntegerProperty getRefundedAmount(){
return refproperty;
}
//for balance
public int getBalance(){
   return balproperty.get();
   }
public void setBalance(int bal){
this.balproperty.set(bal);
}
public IntegerProperty getBalanceLeft(){
return balproperty;
}
}
