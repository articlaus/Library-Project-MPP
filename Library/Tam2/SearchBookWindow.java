

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SearchBookWindow extends Application {
		@Override
		public void start(Stage primaryStage) {
			try {
				primaryStage.setTitle("Search Book Form");
				Parent root = FXMLLoader.load(getClass().getResource("/application/SearchBookWindow.fxml"));
				Scene scene = new Scene(root,700,500);
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

