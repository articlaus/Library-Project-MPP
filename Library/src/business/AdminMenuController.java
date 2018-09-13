package business;

import java.io.IOException;

import dataaccess.Memory;
import dataaccess.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class AdminMenuController {

    @FXML
    private Button logout;

    @FXML
    private Button addBookButton;

    @FXML
    private Button addMemberButton;

    @FXML
    private Button checkoutBookButton;

    @FXML
    private Button searchMemberButton;

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
    	EventHandler.logout(event, this);
    	Memory.setRole(null);
    }
    
    @FXML
    public void clickAddBookButton(ActionEvent event) throws IOException {
    	EventHandler.addBook(event, this);
    	Memory.setRole(Role.ADMIN);
    }
    
    @FXML
    public void clickAddMemberButton(ActionEvent event) throws IOException {
    	EventHandler.addMember(event, this);
    	Memory.setRole(Role.ADMIN);
    }
    
    @FXML
    public void clickSearchMemberButton(ActionEvent event) throws IOException {
    	EventHandler.searchMember(event, this);
    	Memory.setRole(Role.ADMIN);
    }
    
    @FXML
    public void clickAddCopyButton(ActionEvent event) throws IOException {
    	EventHandler.addCopy(event, this);
    	Memory.setRole(Role.ADMIN);
    }

}
