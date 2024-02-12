/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assesment.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Node;

public class FirstPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;




    public void switchToViewLease(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewLease.fxml"));
        Parent root = loader.load();
    
    Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Current Lease"); // Set title for the new stage
        newStage.show();
}
    
}

