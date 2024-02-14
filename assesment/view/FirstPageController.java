/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assesment.view;

import assesment.Accommodation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class FirstPageController implements Initializable {

    @FXML
    private ChoiceBox<String> hallChoiceBox;

    private Map<String, String[]> hallDetails = new HashMap<>();

    @FXML
    private TextArea managerLabel;

    @FXML
    private TextArea telNum;

    @FXML
    private TextArea accTotal;

    @FXML
    private TextArea accAvailable;

    @FXML
    private TextArea accOffline;

    @FXML
    private TextArea accReqClean;

    @FXML
    private TableView<Accommodation> table;

    @FXML
    private TableColumn<Accommodation, String> accNumT;

    @FXML
    private TableColumn<Accommodation, String> accTypeT;

    @FXML
    private TableColumn<Accommodation, String> accPriceT;

    @FXML
    private TableColumn<Accommodation, String> accAvailabilityT;

    @FXML
    private TableColumn<Accommodation, String> accStatusT;
    
    private ObservableList<Accommodation> data; // Declare the data list

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hallChoiceBox.getItems().addAll("Brecon", "Cotswold", "Mendip", "Quantock");
        initializeHallDetails();
        hallChoiceBox.setOnAction(this::updateHallDetails);

        accNumT.setCellValueFactory(data -> data.getValue().numberProperty());
        accTypeT.setCellValueFactory(data -> data.getValue().typeProperty());
        accPriceT.setCellValueFactory(data -> data.getValue().priceProperty());
        accAvailabilityT.setCellValueFactory(data -> data.getValue().availabilityProperty());
        accStatusT.setCellValueFactory(data -> data.getValue().statusProperty());

        // Initialize the data list
        data = FXCollections.observableArrayList();
        table.setItems(data); // Set the table's data
    }

    private void initializeHallDetails() {
        hallDetails.put("Brecon", new String[]{"James", "12345", "100", "80", "10", "5"});
        hallDetails.put("Cotswold", new String[]{"Roland", "34567", "120", "90", "15", "5"});
        hallDetails.put("Mendip", new String[]{"Michelle", "56783", "150", "110", "20", "10"});
        hallDetails.put("Quantock", new String[]{"Udula", "6578953", "200", "150", "30", "20"});
    }

public void updateHallDetails(ActionEvent event) {
    String selectedHall = hallChoiceBox.getValue();
    String[] details = hallDetails.get(selectedHall);
    if (details != null) {
        managerLabel.setText(details[0]);
        telNum.setText(details[1]);
        accTotal.setText(details[2]);
  

        // data based on selected hall
        data.clear(); // Clear existing data

        // accommodations based on the selected hall
        if (selectedHall.equals("Brecon")) {
            data.addAll(
                new Accommodation("1", "Regular", "700", "Occupied", "Clean"),
                new Accommodation("2", "Regular", "750", "Available", "Dirty"),
                new Accommodation("3", "Regular", "770", "Available", "Offline"),
                new Accommodation("4", "Regular", "730", "Occupied", "Clean"),
                new Accommodation("5", "Regular", "700", "Available", "Clean"),
                new Accommodation("6", "Regular", "560", "Occupied", "Dirty"),
                new Accommodation("7", "Regular", "730", "Available", "Offline"),
                new Accommodation("8", "Regular", "750", "Available", "Clean")
            );
        } else if (selectedHall.equals("Cotswold")) {
            data.addAll(
                new Accommodation("1", "Suprime", "730", "Available", "Clean"),
                new Accommodation("2", "Regular", "740", "Occupied", "Offline"),
                new Accommodation("3", "Regular", "760", "Available", "Clean"),
                new Accommodation("4", "Regular", "750", "Available", "Dirty"),
                new Accommodation("5", "Regular", "780", "Occupied", "Offline"),
                new Accommodation("6", "Regular", "790", "Occupied", "Clean"),
                new Accommodation("7", "Regular", "710", "Available", "Offline"),
                new Accommodation("8", "Regular", "720", "Available", "Clean")
            );
        }
            
            else if (selectedHall.equals("Mendip")) {
            data.addAll(
                new Accommodation("1", "Suprime", "730", "Available", "Dirty"),
                new Accommodation("2", "Regular", "740", "Occupied", "Clean"),
                new Accommodation("3", "Regular", "760", "Occupied", "Clean"),
                new Accommodation("4", "Regular", "750", "Occupied", "Dirty"),
                new Accommodation("5", "Regular", "780", "Available", "Offline"),
                new Accommodation("6", "Regular", "790", "Occupied", "Clean"),
                new Accommodation("7", "Regular", "710", "Available", "Offline"),
                new Accommodation("8", "Regular", "720", "Occupied", "Offline")
            );
            }
            else if (selectedHall.equals("Quantock")) {
            data.addAll(
                new Accommodation("1", "Superior", "730", "Available", "Clean"),
                new Accommodation("2", "Regular", "670", "Available", "Clean"),
                new Accommodation("3", "Regular", "560", "Available", "Clean"),
                new Accommodation("4", "Superior", "750", "Available", "Dirty"),
                new Accommodation("5", "Regular", "680", "Available", "Offline"),
                new Accommodation("6", "Regular", "590", "Available", "Clean"),
                new Accommodation("7", "Superior", "710", "Available", "Offline"),
                new Accommodation("8", "Regular", "620", "Available", "Clean")
            );
        } 
        
   

        // Calculate counts based on data
        int totalAccommodations = data.size();
        int availableCount = (int) data.stream().filter(a -> a.getAvailability().equals("Available") && !a.getStatus().equals("Offline")).count();
        int offlineCount = (int) data.stream().filter(a -> a.getAvailability().equals("Offline") || a.getStatus().equals("Offline")).count();
        int reqCleanCount = (int) data.stream().filter(a -> a.getStatus().equals("Dirty") || a.getStatus().equals("Offline")).count();

        accTotal.setText(Integer.toString(totalAccommodations)); // Total accommodations
        accAvailable.setText(Integer.toString(availableCount)); // Available accommodations
        accOffline.setText(Integer.toString(offlineCount)); // Offline accommodations
        accReqClean.setText(Integer.toString(reqCleanCount));//Require Cleaning
    } else {
        managerLabel.setText("Unknown");
        telNum.setText("Unknown");
        accTotal.setText("Unknown");
        accAvailable.setText("Unknown");
        accOffline.setText("Unknown");
        accReqClean.setText("Unknown");
    }
}
        
    public void switchToViewLease(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewLease.fxml"));
        Parent root = loader.load();
    
    Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Current Lease"); // Set title for the new stage
        newStage.show();
}
    
    public void switchToCreateLease(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateLease.fxml"));
        Parent root = loader.load();
    
    Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Create New Lease"); // Set title for the new stage
        newStage.show();
}





    
}

