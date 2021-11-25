package dad.allevents.controller.viewmultiple;

import dad.allevents.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Right implements Initializable {

    @FXML
    private Label labelSeleccionado;

    @FXML
    private TextField textSeleccionado;

    @FXML
    private VBox vbox;

    public Right() {
    }

    public Label getLabelSeleccionado() {
        return labelSeleccionado;
    }

    public void setLabelSeleccionado(Label labelSeleccionado) {
        this.labelSeleccionado = labelSeleccionado;
    }

    public TextField getTextSeleccionado() {
        return textSeleccionado;
    }

    public void setTextSeleccionado(TextField textSeleccionado) {
        this.textSeleccionado = textSeleccionado;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/multipleView/right.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
