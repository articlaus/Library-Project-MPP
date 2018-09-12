package business;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
	
	@FXML Button loginButton;
	@FXML TextField usernameField;
	@FXML PasswordField passwordField;
	@FXML Label loginErrorMessage;
	
	@FXML
	public void clickLogin (ActionEvent event) {
		
		// ensure username field is not blank
		if (usernameField.getText() == null || usernameField.getText().equals(""))
			loginErrorMessage.setText("Username should not be blank!");
		else
			loginErrorMessage.setText("The username password combination is not correct (Unimplemented login)");
		
	}
	
}
