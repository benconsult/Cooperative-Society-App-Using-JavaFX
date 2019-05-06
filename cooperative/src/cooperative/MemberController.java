/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.rowset.CachedRowSetImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class MemberController implements Initializable {
public ConTest contest = new ConTest();
    @FXML
    private JFXTextField surnam;
    @FXML
    private JFXTextField fname;
    @FXML
    private JFXTextField mid;
    @FXML
    private JFXTextField sex;
    @FXML
    private JFXTextField occupation;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField enroldate;
    @FXML
    private JFXButton addMember;
    @FXML
    private Label sta;
    @FXML
    private JFXButton updateBtn;
    @FXML
    private JFXButton deletebtn;
    @FXML
    private JFXButton clear;
    @FXML
    private TableView<Member> tab;
    @FXML
    private TableColumn<Member, Integer> tamemid;
    @FXML
    private TableColumn<Member, String> tabfname;
    @FXML
    private TableColumn<Member, String> tabname;
    @FXML
    private TableColumn<Member, String> tabsex;
    @FXML
    private TableColumn<Member, String> taboccup;
    @FXML
    private TableColumn<Member, String> tabadd;
    @FXML
    private TableColumn<Member, String> tabenroll;
ObservableList<Member> memList;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton searchBtn;
    @FXML
    private TextField console;
    @FXML
    private JFXButton refresh;
    @FXML
    private Button exit;
    @FXML
    private JFXButton loanView;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        tamemid.setCellValueFactory(cellData -> cellData.getValue().getMemberId().asObject());
        tabfname.setCellValueFactory(cellData -> cellData.getValue().getMemberFirstname());
        tabname.setCellValueFactory(cellData -> cellData.getValue().getMemberSurname());
        tabsex.setCellValueFactory(cellData -> cellData.getValue().getMemberSex());
        taboccup.setCellValueFactory(cellData -> cellData.getValue().getMemberOccupation());
        tabadd.setCellValueFactory(cellData -> cellData.getValue().getMemberAddress());
        tabenroll.setCellValueFactory(cellData -> cellData.getValue().getMemberEnroll());
        ObservableList<Member> memList = null;
        
    try {
        memList = MemberDAO.getAllRecords();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    }
        populateTable(memList);
    
        
        // TODO
        if(contest.isDbconnected()){
            sta.setText("Database Connected");
        }
        else{
            sta.setText("Database Not conncted");
        }
    }    

    @FXML
    private void handleAddMember(ActionEvent event) throws ClassNotFoundException,SQLException{
         
    MemberDAO.insertMember(Integer.parseInt(mid.getText()), fname.getText(), surnam.getText(), sex.getText(), occupation.getText(), enroldate.getText(), address.getText());
    
        console.setText("Record Added Successfully!!!");
        System.out.println("Insert Success");
        ObservableList<Member> memList = MemberDAO.getAllRecords();
     populateTable(memList);
    }

    @FXML
    private void handleUpdate(ActionEvent event) throws ClassNotFoundException,SQLException {
        try{
       MemberDAO.updateMember(Integer.parseInt(mid.getText()), fname.getText(), surnam.getText(), sex.getText(), occupation.getText(), enroldate.getText(), address.getText());
            System.out.println("update success");ObservableList<Member> memList = MemberDAO.getAllRecords();
            populateTable(memList);
            console.setText("Record Updated Successfully!!!");
        }catch(SQLException e){
            System.out.println("Exception occured while updating the data"+e);
        e.printStackTrace();
        throw e;
        }
    }

    @FXML
    private void handleDelete(ActionEvent event) throws ClassNotFoundException,SQLException {
        try{
        MemberDAO.deleteMember(Integer.parseInt(mid.getText()));
            System.out.println("Delete success");
            console.setText("Record Successfully Deleted!!!");
            ObservableList<Member> memList = MemberDAO.getAllRecords();
            populateTable(memList);
        }catch(SQLDataException e){
            console.setText("Exception Occured During Delete Operation!!!");
            System.out.println("Exception occured while deleting"+e);
            e.printStackTrace();
            throw e;
        }
        
    }

    @FXML
    private void handleClear(ActionEvent event) throws ClassNotFoundException,SQLException {
        
        mid.clear();
        fname.clear();
        surnam.clear();
        sex.clear();
        occupation.clear();
        address.clear();
        enroldate.clear();
       console.clear();
        
        
        
    }
    private void initialize() throws Exception{
    
    tamemid.setCellValueFactory(cellData -> cellData.getValue().getMemberId().asObject());
        tabfname.setCellValueFactory(cellData -> cellData.getValue().getMemberFirstname());
        tabname.setCellValueFactory(cellData -> cellData.getValue().getMemberSurname());
        tabsex.setCellValueFactory(cellData -> cellData.getValue().getMemberSex());
        taboccup.setCellValueFactory(cellData -> cellData.getValue().getMemberOccupation());
        tabadd.setCellValueFactory(cellData -> cellData.getValue().getMemberAddress());
        tabenroll.setCellValueFactory(cellData -> cellData.getValue().getMemberEnroll());
        ObservableList<Member> memList = MemberDAO.getAllRecords();
       populateTable(memList);
        
    
    }
    private void populateTable(ObservableList<Member> memList) {
        tab.setItems(memList);
    }

    @FXML
    private void handleSearch(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<Member> list = MemberDAO.searchMember(search.getText());
        if(list.size()>0){
        populateTable(list);
        console.setText("Record has been found");
        
        }else{
        console.setText("Record not found");
        }
        
        
        
        
    }

    @FXML
    private void HandleRefresh(ActionEvent event) throws ClassNotFoundException,SQLException {
        ObservableList<Member> memList = MemberDAO.getAllRecords();
        populateTable(memList);
        console.setText("Records Has Been Refreshed");
    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Dashboard");
 
        
    }

    @FXML
    private void handleLoanView(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Loan.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Loan Acquisition Portal");
 
    }
}
