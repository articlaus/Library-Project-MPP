package business;

import dataaccess.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
	
	@FXML Button loginButton;
	@FXML TextField usernameField;
	@FXML PasswordField passwordField;
	@FXML Label loginErrorMessage;
	
	@FXML
	public void clickLogin (ActionEvent event) throws IOException{

		// get user name and password from user
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		// find role of user
		Role r = getRole(username, password);
		// ***********
		
		
		if (username == null || username.equals("")) {						
			loginErrorMessage.setText("Please supply your username");
			loginErrorMessage.setOpacity(1);
			return;
		} else if (r == null) {												
			loginErrorMessage.setText("Invalid username/password");
			loginErrorMessage.setOpacity(1);
			return;
		}
		
		// Build next window
		EventHandler.login(event, this, r);
	}
	
	// Find role of user with credential username/password
	private Role getRole(String username, String password) {
		for(Employee e : DataStorageFactory.getEmployees()) {
			if (e.getUsername().equals(username) && e.getPassword().equals(password)) {
				 return e.getRole();
			}
		}
		return null;
	}
	
}
