/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class DebtorController implements Initializable {

    @FXML
    private JFXButton update;
    @FXML
    private JFXButton exit;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton clear;
    @FXML
    private JFXButton save;
    @FXML
    private JFXTextField txtRef;
    @FXML
    private JFXTextField txtDebt;
    @FXML
    private JFXTextField txtMem;
    @FXML
    private JFXTextField txtBal;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private JFXButton viewDepoBtn;
    @FXML
    private JFXButton refresh;
    @FXML
    private TextField console;
    @FXML
    private JFXButton search;
ObservableList<Debtor> debtorList;
    @FXML
    private TableView<Debtor> table;
    @FXML
    private TableColumn<Debtor, Integer> colId;
    @FXML
    private TableColumn<Debtor, Integer> colAct;
    @FXML
    private TableColumn<Debtor, Integer> colRef;
    @FXML
    private TableColumn<Debtor, Integer> colBal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        colId.setCellValueFactory(cellData -> cellData.getValue().getMemberId().asObject());//becos of integer return type(asObject) method
        colAct.setCellValueFactory(cellData -> cellData.getValue().getActualDebt().asObject());
        colRef.setCellValueFactory(cellData -> cellData.getValue().getRefundedAmount().asObject());
        colBal.setCellValueFactory(cellData -> cellData.getValue().getBalanceLeft().asObject());
        
        ObservableList<Debtor> debtorList = null;
        
    
        debtorList = DebtorDAO.getAllRecords();
        populateTable(debtorList);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    

    @FXML
    private void handleUpdate(ActionEvent event) throws ClassNotFoundException,SQLException {
        try{
        DebtorDAO.updateDebtor(Integer.parseInt(txtMem.getText()), Integer.parseInt(txtDebt.getText()), Integer.parseInt(txtRef.getText()), Integer.parseInt(txtBal.getText()));
   console.setText("Recorded Updated Successfully");
   ObservableList<Debtor> debtorList = DebtorDAO.getAllRecords();
            populateTable(debtorList);}
        catch(SQLException e){
        e.printStackTrace();
        throw e;
        }
   
    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Dashboard Portal");
 
    }

    @FXML
    private void handleDelete(ActionEvent event) throws ClassNotFoundException,SQLException{
        try{
        DebtorDAO.deleteDebtor(Integer.parseInt(txtMem.getText()));
        console.setText("Record Deleted Successfully");
        ObservableList<Debtor> debtorList = DebtorDAO.getAllRecords();
            populateTable(debtorList);
        }
        catch(SQLException e){
        e.printStackTrace();
        throw e;
        }
    
    }

    @FXML
    private void handleClear(ActionEvent event) {
        txtMem.clear();
        txtBal.clear();
        txtRef.clear();
        txtDebt.clear();
    }

    @FXML
    private void handleSave(ActionEvent event) throws ClassNotFoundException,SQLException {
        DebtorDAO.insertDebtor(Integer.parseInt(txtMem.getText()), Integer.parseInt(txtDebt.getText()), Integer.parseInt(txtRef.getText()), Integer.parseInt(txtBal.getText()));
        console.setText("Record Added Successfully");
        ObservableList<Debtor> debtorList = DebtorDAO.getAllRecords();
        populateTable(debtorList);
    
    }

    @FXML
    private void handleViewDepo(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Deposit.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Deposit Portal");
 
    }

    @FXML
    private void handleRefresh(ActionEvent event) throws ClassNotFoundException,SQLException {
        ObservableList<Debtor> debtorList = DebtorDAO.getAllRecords();
        populateTable(debtorList);
        console.setText("Records Has Been Refreshed");
    
    }

    @FXML
    private void handleSearch(ActionEvent event) throws ClassNotFoundException,SQLException {
        ObservableList<Debtor> list = DebtorDAO.searchDeposit(txtSearch.getText());
        if(list.size()>0){
        populateTable(list);
        console.setText("Record has been found");
        
        }else{
        console.setText("Record not found");
        }
   
    }
    private void populateTable(ObservableList<Debtor> debtorList) {
        table.setItems(debtorList);
    }

}
