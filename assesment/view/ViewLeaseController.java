 package assesment.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewLeaseController implements Initializable {

    @FXML
    private TextArea leaseNumberTextArea;

    @FXML
    private TextArea firstNameTextArea;

    @FXML
    private TextArea lastNameTextArea;

    @FXML
    private TextArea studentNumberTextArea;

    @FXML
    private TextArea phoneNumberTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }

    // Method to set text areas editable or not
    public void setTextAreasEditable(boolean editable) {
        leaseNumberTextArea.setEditable(editable);
        firstNameTextArea.setEditable(editable);
        lastNameTextArea.setEditable(editable);
        studentNumberTextArea.setEditable(editable);
        phoneNumberTextArea.setEditable(editable);
    }

     
}
