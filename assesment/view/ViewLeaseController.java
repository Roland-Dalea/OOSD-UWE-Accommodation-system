package assesment.view;

import assesment.model.Lease;
import assesment.model.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.Optional;

public class ViewLeaseController {

    @FXML
    private TextArea leaseNumberTextArea;

    @FXML
    private TextArea firstNameTextArea;

    @FXML
    private TextArea secondNameTextArea;

    @FXML
    private TextArea studentNumberTextArea;

    @FXML
    private TextArea phoneNumberTextArea;

    private Lease lease;
    private Room room;

    public void setLease(Lease lease) {
        this.lease = lease;
        displayLeaseInfo();
    
    }
         public void setRoom(Room room) {
        this.room = room;
         }

    public void displayLeaseInfo() {
        // Display lease information in the text areas
        if (lease != null) {
            leaseNumberTextArea.setText(lease.getLeaseNumber());
            firstNameTextArea.setText(lease.getFirstName());
            secondNameTextArea.setText(lease.getLastName());
            studentNumberTextArea.setText(lease.getStudentNumber());
            phoneNumberTextArea.setText(lease.getPhoneNumber());
        }
    }

    @FXML
    private void deleteLease() {
        // Display confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Deletion");
        alert.setHeaderText("Are you sure you want to delete this lease?");
        alert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            
            room.deleteLease();
            room.setRoomAvailability("Available");
            // Perform deletion logic
           // if (lease != null) {
                // Delete the lease information
                //lease = null;

                // Clear the text areas
                leaseNumberTextArea.clear();
                firstNameTextArea.clear();
                secondNameTextArea.clear();
                studentNumberTextArea.clear();
                phoneNumberTextArea.clear();

                // Close the "View Lease" window
                Stage stage = (Stage) leaseNumberTextArea.getScene().getWindow();
                stage.close();
            } else {
                System.out.println("No lease information available.");
            }
        }
    

    @FXML
    private void closeWindow() {
        // Get the reference to the stage and close it
        Stage stage = (Stage) leaseNumberTextArea.getScene().getWindow();
        stage.close();
    }
}

