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
public class Member {
    private IntegerProperty idproperty;
    private StringProperty firstproperty;
    private StringProperty surnproperty;
private StringProperty sexproperty;
private StringProperty occupproperty;
private StringProperty addressproperty;
private StringProperty enrollproperty;


   public Member(){
   this.idproperty= new SimpleIntegerProperty();
   this.firstproperty=new SimpleStringProperty();
   this.surnproperty=new SimpleStringProperty();
   this.sexproperty=new SimpleStringProperty();
   this.occupproperty=new SimpleStringProperty();
   this.addressproperty=new SimpleStringProperty();
   this.enrollproperty=new SimpleStringProperty();
   
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

//for firtname
public String getFirstname(){
   return firstproperty.get();
   }
public void setFirstname(String firstname){
this.firstproperty.set(firstname);
}
public StringProperty getMemberFirstname(){
return firstproperty;
}
//for lastname
public String getSurname(){
   return surnproperty.get();
   }
public void setSurname(String surname){
this.surnproperty.set(surname);
}
public StringProperty getMemberSurname(){
return surnproperty;
}
//for email
public String getSex(){
   return sexproperty.get();
   }
public void setSex(String sex){
this.sexproperty.set(sex);
}
public StringProperty getMemberSex(){
return sexproperty;
}
//occupation
public String getOccupation(){
   return occupproperty.get();
   }
public void setOccupation(String occup){
this.occupproperty.set(occup);
}
public StringProperty getMemberOccupation(){
return occupproperty;
}
//address
public String getAddress(){
   return addressproperty.get();
   }
public void setAddress(String address){
this.addressproperty.set(address);
}
public StringProperty getMemberAddress(){
return addressproperty;
}
//enroll
public String getEnroll(){
   return enrollproperty.get();
   }
public void setEnroll(String enroll){
this.enrollproperty.set(enroll);
}
public StringProperty getMemberEnroll(){
return enrollproperty;
}

}
