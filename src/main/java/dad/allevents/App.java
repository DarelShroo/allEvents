package dad.allevents;

import dad.allevents.controller.AllEventsController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private AllEventsController allEventsController;
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        App.primaryStage = new Stage();
        allEventsController = new AllEventsController();

        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/allEventsDADView.fxml"));

        //Para mostrar la vista se carga en App la escena y en el controlador el fxml
        Scene scene = new Scene(allEventsController.getView());
        primaryStage.setTitle("AllEventsController");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}