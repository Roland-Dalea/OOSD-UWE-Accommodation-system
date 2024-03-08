/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assesment;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author miche
 */
public class FirstPage extends Application {
   
@Override
public void start(Stage stage){
    try{
        Parent root = FXMLLoader.load(getClass().getResource("view/FirstPage.fxml"));
        Scene FirstPage = new Scene(root);
        stage.setScene(FirstPage);
        stage.show();
    
    }catch(IOException e){
    }

    
}

}