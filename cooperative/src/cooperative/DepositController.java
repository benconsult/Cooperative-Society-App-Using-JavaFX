/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class DepositController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField memid;
    @FXML
    private TextField pastDepo;
    @FXML
    private TextField current;
    @FXML
    private TextField total;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton clear;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;
    @FXML
    private TableColumn<Deposit, Integer> colId;
    @FXML
    private TableColumn<Deposit, Integer> colPast;
    @FXML
    private TableColumn<Deposit, Integer> colCurrent;
    @FXML
    private TableColumn<Deposit, Integer> colTotal;
    @FXML
    private TextField console;
    @FXML
    private TableView<Deposit> tabDepo;
    @FXML
    private TextField search;
    @FXML
    private JFXButton searchButton;
    @FXML
    private JFXButton refresh;
    @FXML
    private JFXButton exit;
    ObservableList<Deposit> depoList;
    @FXML
    private JFXButton viewDebtor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try{
        colId.setCellValueFactory(cellData -> cellData.getValue().getMemberId().asObject());//becos of integer return type(asObject) method
        colPast.setCellValueFactory(cellData -> cellData.getValue().getDepositPast().asObject());
        colCurrent.setCellValueFactory(cellData -> cellData.getValue().getDepositCurrent().asObject());
        colTotal.setCellValueFactory(cellData -> cellData.getValue().getDepositTotal().asObject());
        
        ObservableList<Deposit> depoList = null;
        
    
        depoList = DepositDAO.getAllRecords();
        populateTable(depoList);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        
   
        
    }    
private void populateTable(ObservableList<Deposit> depoList) {
        tabDepo.setItems(depoList);
    }
    @FXML
    private void handleSave(ActionEvent event) throws ClassNotFoundException,SQLException {
        
        DepositDAO.insertDeposit(Integer.parseInt(memid.getText()), Integer.parseInt(pastDepo.getText()), Integer.parseInt(current.getText()), Integer.parseInt(total.getText()));
        console.setText("Record Added Successfully");
        ObservableList<Deposit> depoList = DepositDAO.getAllRecords();
        populateTable(depoList);
    
        }

    @FXML
    private void handleClear(ActionEvent event) {
        memid.clear();
        pastDepo.clear();
        current.clear();
        total.clear();
    }

    @FXML
    private void handleUpdate(ActionEvent event) throws ClassNotFoundException,SQLException {
        try{
        DepositDAO.updateDeposit(Integer.parseInt(memid.getText()), Integer.parseInt(pastDepo.getText()), Integer.parseInt(current.getText()), Integer.parseInt(total.getText()));
   console.setText("Recorded Updated Successfully");
   ObservableList<Deposit> depoList = DepositDAO.getAllRecords();
            populateTable(depoList);}
        catch(SQLException e){
        e.printStackTrace();
        throw e;
        }
    }

    @FXML
    private void handleDelete(ActionEvent event) throws ClassNotFoundException,SQLException {
        try{
        DepositDAO.deleteDeposit(Integer.parseInt(memid.getText()));
        console.setText("Record Deleted Successfully");
        ObservableList<Deposit> depoList = DepositDAO.getAllRecords();
            populateTable(depoList);
        }
        catch(SQLException e){
        e.printStackTrace();
        throw e;
        }
    }


    @FXML
    private void handleDepositSearch(ActionEvent event) throws ClassNotFoundException,SQLException {
        
        ObservableList<Deposit> list = DepositDAO.searchDeposit(search.getText());
        if(list.size()>0){
        populateTable(list);
        console.setText("Record has been found");
        
        }else{
        console.setText("Record not found");
        }
   
        
    }

    @FXML
    private void handleRefresh(ActionEvent event) throws ClassNotFoundException,SQLException {
         ObservableList<Deposit> depoList = DepositDAO.getAllRecords();
        populateTable(depoList);
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
    private void handleViewDebtors(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Debtor.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Debtors Portal");
 
    }
    
}
