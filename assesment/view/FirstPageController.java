/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import assesment.Accommodation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstPageController implements Initializable {

    // Halls Dropdown Button
    @FXML
    private ChoiceBox<String> hallChoiceBox;

    // Map to store hall details
    private Map<String, String[]> hallDetails = new HashMap<>();

    // Managers' name, phone number, and hall information text areas
    @FXML
    private TextArea managerLabel;

    @FXML
    private TextArea telNum;

    // Hall information text areas
    @FXML
    private TextArea accTotal;

    @FXML
    private TextArea accAvailable;

    @FXML
    private TextArea accOffline;

    @FXML
    private TextArea accReqClean;

    // Table and table columns
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

    // Accommodation's information Area Under Table
    @FXML
    private TextArea accNum;

    @FXML
    private TextArea accType;

    @FXML
    private TextArea accPrice;

    @FXML
    private TextArea accOccupancy;

    // Initialize method called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Add hall choices to the choice box
        hallChoiceBox.getItems().addAll("Brecon", "Cotswold", "Mendip", "Quantock");
        // Initialize hall details
        initializeHallDetails();
        // Set action for hall choice box selection
        hallChoiceBox.setOnAction(this::updateHallDetails);

        // Initialize table columns
        accNumT.setCellValueFactory(data -> data.getValue().numberProperty());
        accTypeT.setCellValueFactory(data -> data.getValue().typeProperty());
        accPriceT.setCellValueFactory(data -> data.getValue().priceProperty());
        accAvailabilityT.setCellValueFactory(data -> data.getValue().availabilityProperty());
        accStatusT.setCellValueFactory(data -> data.getValue().statusProperty());

        // Initialize the data list
        data = FXCollections.observableArrayList();
        table.setItems(data); // Set the table's data
    }



    // Click specific accommodation on the table to get accommodation information
    @FXML
    void GetItems(MouseEvent event) {
        // Get the selected item from the table
        Accommodation selectedAccommodation = table.getSelectionModel().getSelectedItem();

        // Check if an item is selected
        if (selectedAccommodation != null) {
            // Update the text areas with the selected accommodation information
            accNum.setText(selectedAccommodation.getnumber());
            accType.setText(selectedAccommodation.getType());
            accPrice.setText(selectedAccommodation.getPrice());
            accOccupancy.setText(selectedAccommodation.getAvailability());
        }
    }

    // Update hall details based on selected hall
    public void updateHallDetails(ActionEvent event) {
        String selectedHall = hallChoiceBox.getValue();
        String[] details = hallDetails.get(selectedHall);
        if (details != null) {
            managerLabel.setText(details[0]);
            telNum.setText(details[1]);
            accTotal.setText(details[2]);

            // Clear existing data
            data.clear();

            // Add accommodations based on the selected hall
            switch (selectedHall) {
                case "Brecon" -> data.addAll(
                            new Accommodation("1", "Regular", "700", "Occupied", "Clean"),
                            new Accommodation("2", "Regular", "750", "Available", "Dirty"),
                            new Accommodation("3", "Regular", "770", "Available", "Offline"),
                            new Accommodation("4", "Regular", "730", "Occupied", "Clean"),
                            new Accommodation("5", "Regular", "700", "Available", "Clean"),
                            new Accommodation("6", "Regular", "560", "Occupied", "Dirty"),
                            new Accommodation("7", "Regular", "730", "Available", "Offline"),
                            new Accommodation("8", "Regular", "750", "Available", "Clean")
                    );
                case "Cotswold" -> data.addAll(
                            new Accommodation("1", "Suprime", "730", "Available", "Clean"),
                            new Accommodation("2", "Regular", "740", "Occupied", "Offline"),
                            new Accommodation("3", "Regular", "760", "Available", "Clean"),
                            new Accommodation("4", "Regular", "750", "Available", "Dirty"),
                            new Accommodation("5", "Regular", "780", "Occupied", "Offline"),
                            new Accommodation("6", "Regular", "790", "Occupied", "Clean"),
                            new Accommodation("7", "Regular", "710", "Available", "Offline"),
                            new Accommodation("8", "Regular", "720", "Available", "Clean")
                    );
                case "Mendip" -> data.addAll(
                            new Accommodation("1", "Suprime", "730", "Available", "Dirty"),
                            new Accommodation("2", "Regular", "740", "Occupied", "Clean"),
                            new Accommodation("3", "Regular", "760", "Occupied", "Clean"),
                            new Accommodation("4", "Regular", "750", "Occupied", "Dirty"),
                            new Accommodation("5", "Regular", "780", "Available", "Offline"),
                            new Accommodation("6", "Regular", "790", "Occupied", "Clean"),
                            new Accommodation("7", "Regular", "710", "Available", "Offline"),
                            new Accommodation("8", "Regular", "720", "Occupied", "Offline")
                    );
                case "Quantock" -> data.addAll(
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

            // Update text areas with counts
            accTotal.setText(Integer.toString(totalAccommodations)); // Total accommodations
            accAvailable.setText(Integer.toString(availableCount)); // Available accommodations
            accOffline.setText(Integer.toString(offlineCount)); // Offline accommodations
            accReqClean.setText(Integer.toString(reqCleanCount)); // Require Cleaning
        } else {
            // If selected hall details are not found, display "Unknown"
            managerLabel.setText("Unknown");
            telNum.setText("Unknown");
            accTotal.setText("Unknown");
            accAvailable.setText("Unknown");
            accOffline.setText("Unknown");
            accReqClean.setText("Unknown");
        }
    }

    // Method to switch to the view lease page
    public void switchToViewLease(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewLease.fxml"));
        Parent root = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Current Lease"); // Set title for the new stage
        newStage.show();
    }

    // Method to switch to the create lease page
    public void switchToCreateLease(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateLease.fxml"));
        Parent root = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Create New Lease"); // Set title for the new stage
        newStage.show();
    }

    private void initializeHallDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}