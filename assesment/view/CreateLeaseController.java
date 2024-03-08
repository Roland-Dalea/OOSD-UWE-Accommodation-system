/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package assesment.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
 
import javafx.scene.control.Button;
 
import javafx.stage.Stage;

 
 

  

public class CreateLeaseController {

    @FXML
    private TextField txtLeaseNumber;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtSecondName;

    @FXML
    private TextField txtStudentNumber;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private Button btCreateNew;

    private FirstPageController firstPageController;

    public void setFirstPageController(FirstPageController firstPageController) {
        this.firstPageController = firstPageController;
    }

    @FXML
    void createNewLease() {
        String leaseNumber = txtLeaseNumber.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtSecondName.getText();
        String studentNumber = txtStudentNumber.getText();
        String phoneNumber = txtPhoneNumber.getText();
        
        // Update lease information in FirstPageController
        firstPageController.updateLeaseInfo(firstName, lastName, studentNumber, phoneNumber, leaseNumber);
        
        // Close the CreateLease window
        Stage stage = (Stage) btCreateNew.getScene().getWindow();
        stage.close();
    }
}
