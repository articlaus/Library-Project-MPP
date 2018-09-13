package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckoutWindow extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Checkout Form");
			Parent root = FXMLLoader.load(getClass().getResource("/application/CheckoutWindow.fxml"));
			Scene scene = new Scene(root,390,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
