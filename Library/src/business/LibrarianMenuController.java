package business;

import java.io.IOException;

import dataaccess.Memory;
import dataaccess.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class LibrarianMenuController {

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
    void clickLogout(ActionEvent event) throws IOException {
    	EventHandler.logout(event, this);
    	Memory.setRole(null);
    }
    
    @FXML
    void clickSearchMemberButton(ActionEvent event) throws IOException {
    	EventHandler.searchMember(event, this);
    	Memory.setRole(Role.LIBRARIAN);
    }
    
    @FXML
    void clickChekoutBookButton(ActionEvent event) throws IOException {
    	EventHandler.checkoutBook(event, this);
    	Memory.setRole(Role.LIBRARIAN);

    }

}
