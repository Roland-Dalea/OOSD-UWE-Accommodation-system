 package assesment.view;

import assesment.model.Hall;
import assesment.model.Room;
import assesment.model.AccommodationSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
    
    @FXML
    private TextArea LeaseNumberTextArea;

    @FXML
    private TextArea FirstNameTextArea;

    @FXML
    private TextArea SecondNameTextArea;

    @FXML
    private TextArea StudentNumberTextArea;

    @FXML
    private TextArea PhoneNumberTextArea;

    private ObservableList<Room> data;

    private AccommodationSystem accommodationSystem;

    private CreateLeaseController CreateLeaseController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accommodationSystem = new AccommodationSystem();

        // Initialize UI components
        initializeUI();

        // Initialize halls
        initializeHalls();

        // Set action for hall choice box selection
        hallChoiceBox.setOnAction(this::updateHall);
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

    public void switchToViewLease(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewLease.fxml"));
        Parent root = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Current Lease");
        newStage.show();
    }

    public void switchToCreateLease(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateLease.fxml"));
        Parent root = loader.load();

        // Get the controller of the CreateLease window
        CreateLeaseController = loader.getController();

        // Pass the FirstPageController to the CreateLeaseController
       // CreateLeaseController.setFirstPageController(this);

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Create New Lease");
        newStage.show();
    }

    // Method to update UI with the created lease information
    public void updateLeaseInfo(String firstName, String lastName, String studentNumber, String phoneNumber, String leaseNumber) {
        // Update UI with the created lease information
        // For example, you can set text fields or labels with the passed information
        // Assuming you have corresponding text fields or labels in your FXML file
        LeaseNumberTextArea.setText(leaseNumber);
        FirstNameTextArea.setText(firstName);
        SecondNameTextArea.setText(lastName);
        StudentNumberTextArea.setText(studentNumber);
        PhoneNumberTextArea.setText(phoneNumber);
    }
}
