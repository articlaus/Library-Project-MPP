import dataaccess.DataStorageFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DataStorageFactory.createInitialData();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ui/AddBookWindow.fxml"));
        primaryStage.setTitle("Testing");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
