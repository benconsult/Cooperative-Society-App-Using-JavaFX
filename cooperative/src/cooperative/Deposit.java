/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Rebecca
 */
public class Deposit {
    
    private IntegerProperty idproperty;
    private IntegerProperty pastproperty;
    private IntegerProperty currentproperty;
private IntegerProperty totalproperty;



   public Deposit(){
   this.idproperty= new SimpleIntegerProperty();
   this.pastproperty=new SimpleIntegerProperty();
   this.currentproperty=new SimpleIntegerProperty();
   this.totalproperty=new SimpleIntegerProperty();
   
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

//for pastdeposit
public int getPast(){
   return pastproperty.get();
   }
public void setPast(int past){
this.pastproperty.set(past);
}
public IntegerProperty getDepositPast(){
return pastproperty;
}
//for current
public int getCurrent(){
   return currentproperty.get();
   }
public void setCurrent(int cur){
this.currentproperty.set(cur);
}
public IntegerProperty getDepositCurrent(){
return currentproperty;
}
//for total
public int getTotal(){
   return totalproperty.get();
   }
public void setTotal(int total){
this.totalproperty.set(total);
}
public IntegerProperty getDepositTotal(){
return totalproperty;
}
}

    
    
    
