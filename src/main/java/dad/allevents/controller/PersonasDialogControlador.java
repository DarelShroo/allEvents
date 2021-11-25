package dad.allevents.controller;

import dad.allevents.model.Persona;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonasDialogControlador implements Initializable {
    @FXML
    public TextField textNombre;
    @FXML
    public CheckBox checkMayor;
    @FXML
    public TextField textEdad;
    @FXML
    public Button btnDialogSalir;
    @FXML
    public Button btnDialogGuardar;

    @FXML
    public Label labelNombre;
    @FXML
    public Label labelEsMayor;
    @FXML
    public Label labelEdad;


    private Persona persona;

    private ObservableList<Persona> personas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initAttributes(ObservableList<Persona> personas) {
        this.personas = personas;

    }

    public void initAttributes(ObservableList<Persona> personas, Persona p) {
        this.personas = personas;
        this.persona = p;

        //cargamos los datos de la persona
        this.textNombre.setText(p.getNombre());
        this.textEdad.setText(String.valueOf(p.getEdad()));
        this.checkMayor.setSelected(p.isMayor());
    }

    @FXML
    public void onActionDialogGuardar(ActionEvent actionEvent) {
        //Cojo los datos
        Persona p = null;
        String nombre = this.textNombre.getText();
        String mayor = checkMayor.getText();
        int edad = 0;
        try {
            edad = Integer.parseInt(this.textEdad.getText());
            //Creo la persona
            p = new Persona(nombre, String.valueOf(edad), Boolean.valueOf(mayor));
        } catch (Exception e) {

        }
        // Compruebo si la persona existe
        if (!personas.contains(p)) {

            // Modificar
            if (this.persona != null) {

                // Modifico el objeto
                this.persona.setNombre(nombre);
                this.persona.setMayor(Boolean.parseBoolean(mayor));
                this.persona.setEdad(edad);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Se ha modificado correctamente");
                alert.showAndWait();

            } else {
                // insertando
                this.persona = p;
                if(this.personas.contains(p)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Informacion");
                    alert.setContentText("Se ha añadido correctamente");
                    alert.showAndWait();
                }
            }

            // Cerrar la ventana
            Stage stage = (Stage) this.btnDialogGuardar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }

        //Cerramos la ventana
        Stage stage = (Stage) this.btnDialogGuardar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onActionDialogSalir(ActionEvent actionEvent) {
        this.persona = null;
        Stage stage = (Stage) this.btnDialogSalir.getScene().getWindow();
        stage.close();
    }


    public Persona getPersona() {
        return this.persona;
    }
}
