package business;

import java.io.IOException;
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
    }
    
    @FXML
    void clickSearchMemberButton(ActionEvent event) {

    }
    
    @FXML
    void clickChekoutBookButton(ActionEvent event) {

    }

}
