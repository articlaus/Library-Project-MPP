import dataaccess.DataStorageFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DataStorageFactory.createInitialData();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ui/Login.fxml"));
        primaryStage.setTitle("Library Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
