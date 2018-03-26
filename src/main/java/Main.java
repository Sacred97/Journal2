import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListJournal.fxml"));
        loader.setController(new ListJournal());
        primaryStage.setTitle("Журнал");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }
}
