package business;

import dataaccess.Address;
import dataaccess.DataStorageFactory;
import dataaccess.LibraryMember;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private TextField txtZip;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnClear;

    @FXML
    public void createMember(Event e) {
        LibraryMember member = new LibraryMember();
        member.setMemberId(Long.valueOf(txtId.getText()));
        member.setFirstName(txtFirstName.getText());
        member.setLastName(txtLastName.getText());
        member.setPhoneNumber(txtTelephone.getText());

        Address address = new Address();
        address.setCity(txtCity.getText());
        address.setState(txtState.getText());
        address.setStreet(txtStreet.getText());
        address.setZip(txtZip.getText());
        member.setAddress(address);
        DataStorageFactory.saveMember(member);

        ((Node) (e.getSource())).getScene().getWindow().hide();
    }


}
