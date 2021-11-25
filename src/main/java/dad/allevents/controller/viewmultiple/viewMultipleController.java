package dad.allevents.controller.viewmultiple;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class viewMultipleController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Label labelMcFly;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        borderPane = new BorderPane();
        Left left = new Left();
        Right right = new Right();
        borderPane.setLeft(left.getTableNombres());
        borderPane.setRight(right.getVbox());
        Button btn = new Button();
        borderPane.setBottom(btn);
        Scene scene = new Scene(borderPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
