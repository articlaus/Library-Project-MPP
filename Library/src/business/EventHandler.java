package business;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import dataaccess.DataStorageFactory;
import dataaccess.LibraryMember;
import dataaccess.Memory;
import dataaccess.Role;

public class EventHandler {

    public static void addCheckoutEntry(ActionEvent event, Object caller) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/CheckoutRecordWindow.fxml"));
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	public static void addBook (ActionEvent event, Object caller) throws IOException{
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/AddBookWindow.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void addMember (ActionEvent event, Object caller) throws IOException{
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/MemberAddWindow.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void addCopy (ActionEvent event, Object caller) throws IOException {
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/AddCopyWindow.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void addAuthor(ActionEvent event, Object caller) throws IOException {
		Window owner = ((Node)event.getSource()).getScene().getWindow();
		Stage secondStage = new Stage();
    	secondStage.initOwner(owner);
    	AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/AddAuthorWindow.fxml"));
    	Scene scene = new Scene(root);
		secondStage.setResizable(false);
		secondStage.setScene(scene);
		secondStage.showAndWait();
	}
	
	public static void login(ActionEvent event, Object caller, Role role)  throws IOException{
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	AnchorPane root = null;
    	
    	// Build scene based on which role is associated with the login event
    	switch (role) {
			case LIBRARIAN:
				root = FXMLLoader.load(caller.getClass().getResource("../ui/LibrarianMenu.fxml"));
				break;
			case ADMIN:
				root = FXMLLoader.load(caller.getClass().getResource("../ui/AdminMenu.fxml"));
				break;
			case BOTH:
				root = FXMLLoader.load(caller.getClass().getResource("../ui/BothMenu.fxml"));
				break;
    	}
		Scene scene = new Scene(root);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void logout (ActionEvent event, Object caller) throws IOException{
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void checkoutBook (ActionEvent event, Object caller) throws IOException{
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/CheckoutWindow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void searchMember(ActionEvent event, Object caller) throws IOException{
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/SearchMemberWindow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void searchBook(ActionEvent event, Object caller) throws IOException{
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	AnchorPane root = FXMLLoader.load(caller.getClass().getResource("../ui/SearchBookWindow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void displayErrorMessage(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(message);
		alert.show();
	}
}
