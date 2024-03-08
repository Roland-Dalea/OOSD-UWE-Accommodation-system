  package assesment.view;

import assesment.model.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.Random;

public class CreateLeaseController {

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtStudentNumber;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtLeaseNumber;

    private FirstPageController firstPageController;

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
            switch (selectedRoom.getRoomAvailability()) {
                case "Available":
                    // Check if the room is clean
                    if (selectedRoom.getRoomStatus().equals("Clean")) {
                        
                        // Change room availability to Occupied
                        selectedRoom.setRoomAvailability("Occupied");

                        // Show success message
                        // Show success message
                    showSuccessMessage("Rental agreement created successfully.");


                        // Proceed with creating the lease
                        firstPageController.updateLeaseInfo(
                                txtFullName.getText(),
                                txtStudentNumber.getText(),
                                txtPhoneNumber.getText(),
                                txtLeaseNumber.getText());
                    } else {
                        // Display an error message if the room is not clean
                        showAlert("Accommodation is not in a Clean state and cannot be rented.");
                    }
                    break;
                case "Occupied":
                    // Display an error message if the room is already occupied
                    showAlert("Accommodation is already occupied and cannot be rented.");
                    break;
                case "Offline":
                case "Dirty":
                    // Display an error message if the room is offline or dirty
                    showAlert("Accommodation is not available for rent.");
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
    alert.showAndWait();
}
}
