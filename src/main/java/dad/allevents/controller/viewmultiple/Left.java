package dad.allevents.controller.viewmultiple;

import dad.allevents.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Left implements Initializable {
    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableView<?> tableNombres;

    public Left() {

    }

    public TableColumn<?, ?> getColNombre() {
        return colNombre;
    }

    public void setColNombre(TableColumn<?, ?> colNombre) {
        this.colNombre = colNombre;
    }

    public TableView<?> getTableNombres() {
        return tableNombres;
    }

    public void setTableNombres(TableView<?> tableNombres) {
        this.tableNombres = tableNombres;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/multipleView/leftView.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
