package business;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.event.*;

public class MemberAddController {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtStreet;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtState;
    @FXML
    private TextField txtTelephone;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnClear;

    @FXML
    public void createMember(Event e) {
        System.out.println(txtId.getText());
    }


}
