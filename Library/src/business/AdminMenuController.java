package business;

import java.io.IOException;

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
    }
    
    @FXML
    public void clickAddBookButton(ActionEvent event) throws IOException {
    	EventHandler.addBook(event, this);
    }
    
    @FXML
    public void clickAddMemberButton(ActionEvent event) throws IOException {
    	
    }
    
    @FXML
    public void clickSearchMemberButton(ActionEvent event) throws IOException {
    	
    }

}
