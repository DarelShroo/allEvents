package dad.allevents.controller;

import dad.allevents.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllEventsController implements Initializable {
    @FXML
    private Button btnAlerts;

    @FXML
    private Button btnListColumns;

    @FXML
    private Button btnViewBindBidirectional;

    @FXML
    private Button btnViewBinds;

    @FXML
    private Button btnViewBinds1;

    @FXML
    private Button multipleViews;

    @FXML
    private GridPane root;

    public AllEventsController() throws IOException {
        //El getResource dependerá de donde este situada la clase a la se le solicita.
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/allEventsDADView.fxml"));
        //fx:controller="dad.allevents.controller.AllEventsController" DEBE DE EVITARSE para hacerlo "modular"
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/allEventsDADView.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    @FXML
    void onActionViewAlerts(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("No se pudo enviar el email");
        alert.setTitle("Error");
        alert.setContentText("Invalid message supplied");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        //Modificando el icono
        ImageView icon = new ImageView(String.valueOf(App.class.getResource("images/groot.png")));
        //Dando tamaño al icono
        icon.setFitHeight(48);
        icon.setFitWidth(48);

        alert.getDialogPane().setGraphic(icon);
        //stage.getIcons().add(new Image(this.getClass().getResource("images/email-send-icon-32x32.png").toString()));
        alert.showAndWait();
    }


    @FXML
    void onActionViewBindBidirectional(ActionEvent event) {

    }

    @FXML
    void onActionViewBinds(ActionEvent event) {

    }

    @FXML
    void onActionMultipleViews(ActionEvent event) throws IOException {
        //Hay que decirle el controlador en el fxml (fx:controller="")

        // Cargo la vista
        FXMLLoader loader = new FXMLLoader(App.class.getResource("fxml/multipleView/viewMultiple.fxml"));

        // Cargo la ventana
        Parent root = loader.load();

        // Cojo el controlador
        ControllerTabla controlador = loader.getController();
        //controlador.initAttributtes(personas);

        // Creo el Scene
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        //stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    void onActionViewListColumns(ActionEvent event) throws IOException {
        //Hay que decirle el controlador en el fxml (fx:controller="")

        // Cargo la vista
        FXMLLoader loader = new FXMLLoader(App.class.getResource("fxml/listColumns.fxml"));

        // Cargo la ventana
        Parent root = loader.load();

        // Cojo el controlador
        ControllerTabla controlador = loader.getController();
        //controlador.initAttributtes(personas);

        // Creo el Scene
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        //stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.showAndWait();

    }

    public GridPane getView() {
        return this.root;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
