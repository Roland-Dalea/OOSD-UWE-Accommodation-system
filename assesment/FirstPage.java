 package assesment;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstPage extends Application {
   
    @Override
    public void start(Stage stage) {
        try {
            // Adjusted resource path to reflect the package structure
            Parent root = FXMLLoader.load(getClass().getResource("/assesment/view/FirstPage.fxml"));

             Scene firstPageScene = new Scene(root);
            stage.setScene(firstPageScene);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging purposes
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
