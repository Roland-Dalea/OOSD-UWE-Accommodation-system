 package assesment.view;

import assesment.model.Lease;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class ViewLeaseController implements Initializable {

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

    // Method to set the lease information
    public void setLease(Lease lease) {
        leaseNumberTextArea.setText(lease.getLeaseNumber());
        firstNameTextArea.setText(lease.getFirstName());
        secondNameTextArea.setText(lease.getLastName());
        studentNumberTextArea.setText(lease.getStudentNumber());
        phoneNumberTextArea.setText(lease.getPhoneNumber());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization code, if any
    }
}