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
public class LoanController implements Initializable {

    @FXML
    private JFXTextField collection;
    @FXML
    private JFXTextField memId;
    @FXML
    private JFXTextField amount;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private JFXTextField expiry;
    @FXML
    private TextField console;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton clear;
    @FXML
    private JFXButton exit;
    @FXML
    private JFXButton refresh;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton update;
    @FXML
    private TableColumn<Loan, Integer> colID;
    @FXML
    private TableColumn<Loan, Integer> colAmm;
    @FXML
    private TableColumn<Loan, String> colCollect;
    @FXML
    private TableColumn<Loan, String> colExp;
    @FXML
    private JFXButton searchBtn;
    @FXML
    private TableView<Loan> table;

ObservableList<Loan> loanList;
    @FXML
    private JFXButton memberBtn;
    @FXML
    private JFXButton depoBtn;
    @FXML
    private JFXButton debtBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colID.setCellValueFactory(cellData -> cellData.getValue().getMemberId().asObject());//becos of integer return type(asObject) method
        colAmm.setCellValueFactory(cellData -> cellData.getValue().getLoanAmount().asObject());
        colCollect.setCellValueFactory(cellData -> cellData.getValue().getLoanCollection());
        colExp.setCellValueFactory(cellData -> cellData.getValue().getLoanExpiry());
        
        ObservableList<Loan> loanList = null;
        
    try {
        loanList = LoanDAO.getAllRecords();
        populateTable(loanList);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        
   
        
    }    

    @FXML
    private void handleDelete(ActionEvent event) throws ClassNotFoundException,SQLException {
        
        try{
        LoanDAO.deleteLoan(Integer.parseInt(memId.getText()));
        console.setText("Record Deleted Successfully");
        ObservableList<Loan> loanList = LoanDAO.getAllRecords();
        populateTable(loanList);}
        catch(SQLException e){System.out.println("Exception Occured while performing query"+e);
        e.printStackTrace();
        throw e;
        }
    }

    @FXML
    private void handleClear(ActionEvent event) {
        memId.getText();
        amount.getText();
        collection.getText();
        expiry.getText();
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
    private void handleRefresh(ActionEvent event) throws ClassNotFoundException,SQLException {
         ObservableList<Loan> loanList = LoanDAO.getAllRecords();
        populateTable(loanList);
        console.setText("Records Has Been Refreshed");
    
    }
private void populateTable(ObservableList<Loan> loanList) {
        table.setItems(loanList);
    }

    @FXML
    private void handleSave(ActionEvent event)  throws ClassNotFoundException,SQLException {
        try{
        LoanDAO.insertLoan(Integer.parseInt(memId.getText()), Integer.parseInt(amount.getText()), collection.getText(), expiry.getText());
        console.setText("Record Added Successfully");
        ObservableList<Loan> loanList = LoanDAO.getAllRecords();
        populateTable(loanList);}
        catch(SQLException e){
            System.out.println("Error Occured while performing query"+e);
        e.printStackTrace();
        }
    }

    @FXML
    private void handleUpdate(ActionEvent event) throws ClassNotFoundException,SQLException {
        try{
        LoanDAO.updateLoan(Integer.parseInt(memId.getText()), Integer.parseInt(amount.getText()), collection.getText(), expiry.getText());
   console.setText("Recorded Updated Successfully");
   ObservableList<Loan> loanList = LoanDAO.getAllRecords();
        populateTable(loanList);}
        catch(SQLException e){
            System.out.println("Exception Occured while performing query"+e);
        }
    
    }

    @FXML
    private void handleSearch(ActionEvent event) throws ClassNotFoundException,SQLException {
        ObservableList<Loan> list = LoanDAO.searchLoan(txtSearch.getText());
        if(list.size()>0){
        populateTable(list);
        console.setText("Record has been found");
        
        }else{
        console.setText("Record not found");
        }
   
    }

    @FXML
    private void handleViewMember(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Member.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Members Registration Portal");
 
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
    private void handleViewDebt(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Debtor.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Debtors Portal");
 
    }
    
}
