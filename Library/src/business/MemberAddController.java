package business;

import java.io.IOException;

import dataaccess.Address;
import dataaccess.DataStorageFactory;
import dataaccess.LibraryMember;
import dataaccess.Memory;
import dataaccess.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MemberAddController {

    @FXML
    private TextField txtID;
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
    public void createMember(ActionEvent event) {
        LibraryMember member = new LibraryMember();
        
        String id = txtID.getText();
        LibraryMember duplicate = DataStorageFactory.readMember(id);
        if (duplicate != null) {
        	EventHandler.displayErrorMessage("Duplicate ID", "The member ID is already being used. Please specify a different ID");
        	return;
        }
        // set member info
        member.setMemberId(txtID.getText());
        member.setFirstName(txtFirstName.getText());
        member.setLastName(txtLastName.getText());
        member.setPhoneNumber(txtTelephone.getText());

        // create address and add to member info
        Address address = new Address();
        address.setCity(txtCity.getText());
        address.setState(txtState.getText());
        address.setStreet(txtStreet.getText());
        address.setZip(txtZip.getText());
        member.setAddress(address);
        
        // write member to file
        DataStorageFactory.saveMember(member);
    }
    
    @FXML
    public void clear(ActionEvent event) {
    	System.out.println("Clearing fields");
    	txtID.setText("");
    	txtFirstName.setText("");
    	txtLastName.setText("");
    	txtStreet.setText("");
    	txtCity.setText("");
    	txtState.setText("");
    	txtZip.setText("");
    }
    
    @FXML
    public void back(ActionEvent event) throws IOException {
    	switch(Memory.getRole()) {
    	case LIBRARIAN:
    		// this should be unreachable
    		break;
    	case BOTH:
    		EventHandler.login(event, this, Role.BOTH);
    		break;
    	case ADMIN:
    		EventHandler.login(event, this, Role.ADMIN);
    		break;	
    	}
    }


}
