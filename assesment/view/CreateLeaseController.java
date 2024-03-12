package assesment.view;

import assesment.model.Room;
import assesment.model.Lease;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Random;

public class CreateLeaseController {

    @FXML
    private TextField txtFirstName;
    
    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtStudentNumber;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtLeaseNumber;

    private FirstPageController firstPageController;
    
    public String getLeaseNumber() {
        return txtLeaseNumber.getText();
    }

    public void setFirstPageController(FirstPageController firstPageController) {
        this.firstPageController = firstPageController;
    }
       
    @FXML
    private void initialize() {
        // Generate a unique lease number when the controller is initialized
        generateUniqueLeaseNumber();
    }

    private void generateUniqueLeaseNumber() {
        // Generate a random lease number between 1000 and 9999
        Random random = new Random();
        int leaseNumber = random.nextInt(9000) + 1000; // Range: [1000, 9999]

        // Set the lease number in the text field
        txtLeaseNumber.setText(String.valueOf(leaseNumber));
    }

    @FXML
    private void createLease(ActionEvent event) {
        Room selectedRoom = firstPageController.getSelectedRoom();
        if (selectedRoom != null) {
            // Check if any of the text fields are empty
            if (txtFirstName.getText().isEmpty() || 
                txtLastName.getText().isEmpty() ||
                txtStudentNumber.getText().isEmpty() || 
                txtPhoneNumber.getText().isEmpty() || 
                txtLeaseNumber.getText().isEmpty()) {
                // Display an error message if any field is empty
                showAlert("Please fill in all fields.");
                return; // Exit the method to prevent further processing
            }
            
            switch (selectedRoom.getRoomAvailability()) {
                case "Available":
                    // Check if the room is clean
                    if (selectedRoom.getRoomStatus().equals("Clean")) {
                        // Change room availability to Unavailable
                        selectedRoom.setRoomAvailability("Unavailable");

                        // Show success message
                        showSuccessMessage("Rental agreement created successfully.");

                        // Proceed with creating the lease
                        firstPageController.updateLeaseInfo(
                                txtFirstName.getText(),
                                txtLastName.getText(),
                                txtStudentNumber.getText(),
                                txtPhoneNumber.getText(),
                                txtLeaseNumber.getText());
                    } else {
                        // Display an error message if the room is not clean
                        showAlert("Accommodation is not clean and cannot be rented.");
                    }
                    break;
                case "Unavailable":
                    if (selectedRoom.getRoomStatus().equals("Offline")) {
                        // Display an error message if the room is unavailable and offline
                        showAlert("Accommodation is offline and cannot be rented.");
                    } else if (selectedRoom.getRoomStatus().equals("Dirty")) {
                        // Display an error message if the room is unavailable and dirty
                        showAlert("Accommodation is dirty and cannot be rented.");
                    } else {
                        // Display a generic error message if the room is unavailable for other reasons
                        showAlert("Accommodation is unavailable and cannot be rented.");
                    }
                    break;
            }
        } else {
            // Display an error message if no room is selected
            showAlert("No room selected.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccessMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Add event handler to close the window when the OK button is clicked
        alert.setOnCloseRequest(event -> {
            // Get the stage and close it
            Stage stage = (Stage) txtFirstName.getScene().getWindow();
            stage.close();
        });

        // Show the alert and wait for user response
        alert.showAndWait();
    }
}
