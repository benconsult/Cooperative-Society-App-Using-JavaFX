/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cooperative;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rebecca
 */
public class DashboardController implements Initializable {

    @FXML
    private JFXButton member;
    @FXML
    private JFXButton deposit;
    @FXML
    private JFXButton debtors;
    @FXML
    private JFXButton loan;
    @FXML
    private JFXButton home;
    @FXML
    private JFXButton about;
    @FXML
    private JFXButton exit;
public static Boolean isSplash=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleMembers(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Member.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Members Portal");
 
    }

    @FXML
    private void handleDeposit(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Deposit.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Deposit Portal");
 
    }

    @FXML
    private void handleDebtors(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Debtor.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Debtors Portal");
 
    }

    @FXML
    private void handleLoan(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("Loan.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Loan Acquisition Portal");
 
    }

    @FXML
    private void handleHome(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("Admin Portal");
 
    }

    @FXML
    private void handleAbout(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("About.fxml"));
            Scene first_scene = new Scene(dashboard);
            Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app.setScene(first_scene);
            app.show();
      app.setTitle("About Us");
 
    }

    @FXML
    private void handleExit(ActionEvent event) {
        System.exit(0);
    }
    
}
