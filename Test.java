import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("idkyet.fxml"));
        
        Scene scene = new Scene(root, 300, 275);
        
        primaryStage.setTitle("FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}