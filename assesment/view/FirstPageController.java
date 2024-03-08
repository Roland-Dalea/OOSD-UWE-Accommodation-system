package assesment.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import assesment.model.Hall;
import assesment.model.Room;
import assesment.model.AccommodationSystem;
import assesment.model.Lease;
import assesment.model.RoomCleaningStatus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class FirstPageController implements Initializable {
    

    @FXML
    private ChoiceBox<String> hallChoiceBox;

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
    private TableView<Room> table;

    @FXML
    private TableColumn<Room, String> accNumT;

    @FXML
    private TableColumn<Room, String> accTypeT;

    @FXML
    private TableColumn<Room, String> accPriceT;

    @FXML
    private TableColumn<Room, String> accAvailabilityT;

    @FXML
    private TableColumn<Room, String> accStatusT;

    @FXML
    private TextArea accNum;

    @FXML
    private TextArea accType;

    @FXML
    private TextArea accPrice;

    @FXML
    private TextArea accOccupancy;

    private ObservableList<Room> data;

    private AccommodationSystem accommodationSystem;
    
    @FXML
    private ChoiceBox<String> CleanButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accommodationSystem = new AccommodationSystem();
        
        // Get the constant values from the RoomCleaningStatus enum
        RoomCleaningStatus[] cleaningStatusValues = RoomCleaningStatus.values();
        
        // Convert the constant values into a list of strings
        String[] cleaningStatusStrings = Arrays.stream(cleaningStatusValues)
                .map(Enum::name)
                .toArray(String[]::new);
        
        // Set the items of the ChoiceBox
        CleanButton.getItems().addAll(cleaningStatusStrings);
        
        // Set action for row selection
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Set the cleaning status of the selected room to the CleanButton ChoiceBox
                CleanButton.setValue(newSelection.getRoomStatus());
            }
        });

        // Set action for CleanButton ChoiceBox selection
        CleanButton.setOnAction(this::updateCleaningStatus);

        // Initialize UI components
        initializeUI();

        // Initialize halls
        initializeHalls();
        
        // Set action for hall choice box selection
        hallChoiceBox.setOnAction(this::updateHall);

        // Set action for row selection
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                accNum.setText(newSelection.getRoomNumber());
                accType.setText(newSelection.getRoomDescription());
                accPrice.setText(newSelection.getRoomPrice());
                accOccupancy.setText(newSelection.getRoomAvailability());
            }
        });
    }
    
    // Method to update the cleaning status of the selected room in the table
    @FXML
    void updateCleaningStatus(ActionEvent event) {
        Room selectedRoom = table.getSelectionModel().getSelectedItem();
        if (selectedRoom != null) {
            String newCleaningStatus = CleanButton.getValue(); // Get the selected cleaning status
            String oldCleaningStatus = selectedRoom.getRoomStatus(); // Get the old cleaning status

            // Update the cleaning status of the selected room
            selectedRoom.setRoomStatus(newCleaningStatus);
            table.refresh(); // Refresh the table to reflect the changes

            // Handle updating available, offline, and dirty room counts
            if (oldCleaningStatus.equals("Clean")) {
                decrementAvailableCount();
            } else if (oldCleaningStatus.equals("Offline")) {
                decrementOfflineCount();
            } else if (oldCleaningStatus.equals("Dirty")) {
                decrementDirtyCount();
            }

            if (newCleaningStatus.equals("Clean")) {
                incrementAvailableCount();
            } else if (newCleaningStatus.equals("Offline")) {
                incrementOfflineCount();
            } else if (newCleaningStatus.equals("Dirty")) {
                incrementDirtyCount();
            }

            // Update UI to display the new counts
            updateRoomCountsUI();
        }
    }

    private void incrementAvailableCount() {
        // Increment the available room count
        accAvailable.setText(String.valueOf(Integer.parseInt(accAvailable.getText()) + 1));
    }

    private void decrementAvailableCount() {
        // Decrement the available room count
        accAvailable.setText(String.valueOf(Integer.parseInt(accAvailable.getText()) - 1));
    }

    private void incrementOfflineCount() {
        // Increment the offline room count
        accOffline.setText(String.valueOf(Integer.parseInt(accOffline.getText()) + 1));
    }

    private void decrementOfflineCount() {
        // Decrement the offline room count
        accOffline.setText(String.valueOf(Integer.parseInt(accOffline.getText()) - 1));
    }

    private void incrementDirtyCount() {
        // Increment the dirty room count
        accReqClean.setText(String.valueOf(Integer.parseInt(accReqClean.getText()) + 1));
    }

    private void decrementDirtyCount() {
        // Decrement the dirty room count
        accReqClean.setText(String.valueOf(Integer.parseInt(accReqClean.getText()) - 1));
    }

    private void updateRoomCountsUI() {
        // Update UI to display the new room counts
        // ...
    }

    
    private void initializeUI() {
        // Set up table columns
        accNumT.setCellValueFactory(data -> data.getValue().roomNumberProperty());
        accTypeT.setCellValueFactory(data -> data.getValue().roomDescriptionProperty());
        accPriceT.setCellValueFactory(data -> data.getValue().roomPriceProperty());
        accAvailabilityT.setCellValueFactory(data -> data.getValue().roomAvailabilityProperty());
        accStatusT.setCellValueFactory(data -> data.getValue().roomStatusProperty());

        // Initialize data list for table
        data = FXCollections.observableArrayList();
        table.setItems(data);
    }

    // Initialize halls with rooms
    private void initializeHalls() {
        accommodationSystem.initializeHalls();
        // Add hall names to choice box
        hallChoiceBox.getItems().addAll(accommodationSystem.getHallNames());
    }

    // Update hall details when a hall is selected
    public void updateHall(ActionEvent event) {
        String selectedHall = hallChoiceBox.getValue();
        Hall hall = accommodationSystem.getHall(selectedHall);
        if (hall != null) {
            managerLabel.setText(hall.getManagerName());
            telNum.setText(hall.getTelNumber());
            accTotal.setText(Integer.toString(hall.getTotalRooms()));

            // Clear existing data
            data.clear();
            // Add rooms to data list
            data.addAll(hall.getRooms());
            
            // Status logics

            // Calculate counts based on data
            int totalRooms = hall.getTotalRooms();
            int availableCount = (int) hall.getRooms().stream().filter(room -> room.getRoomAvailability().equals("Available") && !room.getRoomStatus().equals("Offline")).count();
            int offlineCount = (int) hall.getRooms().stream().filter(room -> room.getRoomAvailability().equals("Offline") || room.getRoomStatus().equals("Offline")).count();
            int reqCleanCount = (int) hall.getRooms().stream().filter(room -> room.getRoomStatus().equals("Dirty") || room.getRoomStatus().equals("Offline")).count();

            // Update text areas with counts
            accTotal.setText(Integer.toString(totalRooms)); // Total rooms
            accAvailable.setText(Integer.toString(availableCount)); // Available rooms
            accOffline.setText(Integer.toString(offlineCount)); // Offline rooms
            accReqClean.setText(Integer.toString(reqCleanCount)); // Rooms requiring cleaning

            
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
   // when clicked on the row in the table (specific room) display the accommodation information
    @FXML
    void GetItems(MouseEvent event) {
        Room selectedRoom = table.getSelectionModel().getSelectedItem();
        if (selectedRoom != null) {
            accNum.setText(selectedRoom.getRoomNumber());
            accType.setText(selectedRoom.getRoomDescription());
            accPrice.setText(selectedRoom.getRoomPrice());
            accOccupancy.setText(selectedRoom.getRoomAvailability());
        }
    }

    // when row (room) selected and ViewLease Button clicked, View Lease Information
@FXML
void switchToViewLease(ActionEvent event) {
    Room selectedRoom = table.getSelectionModel().getSelectedItem();
    if (selectedRoom != null && selectedRoom.getLease() != null) {
        try {
            // Load the ViewLease.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewLease.fxml"));
            Parent root = loader.load();

            // Access the controller of the ViewLease.fxml
            ViewLeaseController controller = loader.getController();
            if (controller != null) {
                // Pass the lease information to the controller
                controller.setLease(selectedRoom.getLease());

                // Create a new stage to display the ViewLease.fxml
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.setTitle("Current Lease");
                newStage.show();
            } else {
                System.err.println("Error: Controller is null.");
            }
        } catch (IOException e) {
            System.err.println("Error loading ViewLease.fxml: " + e.getMessage());
        }
    } else {
        // If no lease is associated with the selected room, display a message
        System.out.println("No lease information available for selected room.");
    }
}

// when Create New button clicked, open Create Lease window
    @FXML
    public void switchToCreateLease(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateLease.fxml"));
        Parent root = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Create New Lease");
        newStage.show();
    }

   
    public void updateLeaseInfo(String firstName, String lastName, String studentNumber, String phoneNumber, String leaseNumber) {
        // Implement logic to update lease information in FirstPage
    }
    
}