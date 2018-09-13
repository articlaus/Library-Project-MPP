package business;

import dataaccess.Address;
import dataaccess.Author;
import dataaccess.Memory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAuthorController {

    @FXML
    private TextField txtCredentials;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtZip;

    @FXML
    private Button buttonClear;

    @FXML
    private TextField txtBio;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtTelephone;

    @FXML
    private TextField txtStreet;

    @FXML
    private TextField txtState;

    @FXML
    private Button buttonAdd;

    @FXML
    public void addAuthor(ActionEvent event) {
    	Author author = new Author();
    	author.setFirstName(txtFirstName.getText());
    	author.setLastName(txtLastName.getText());
    	author.setPhoneNumber(txtTelephone.getText());
    	author.setCredentials(txtCredentials.getText());
    	author.setShortBio(txtBio.getText());
    	
    	Address address = new Address();
    	address.setStreet(txtStreet.getText());
    	address.setCity(txtCity.getText());
    	address.setState(txtState.getText());
    	address.setZip(txtZip.getText());
    	
    	author.setAddress(address);
    	
    	Memory.addObjectToMem(author);
    	Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    public void clear(ActionEvent event) {
    	txtFirstName.setText("");
    	txtLastName.setText("");
    	txtStreet.setText("");
    	txtCity.setText("");
    	txtState.setText("");
    	txtZip.setText("");
    	txtCredentials.setText("");
    	txtBio.setText("");
    }

}
