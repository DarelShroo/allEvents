package dad.allevents.controller;

import dad.allevents.App;
import dad.allevents.model.Persona;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTabla implements Initializable {
    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnInsertar;

    @FXML
    private Button btnMod;

    @FXML
    private Button btnSalir;

    @FXML
    private CheckBox checkMayor;

    @FXML
    private Label labelEdad;

    @FXML
    private Label labelMayor;

    @FXML
    private Label labelNombre;

    @FXML
    private TextField textEdad;

    @FXML
    private TextField textNombre;

    @FXML
    private GridPane viewListColumns;

    @FXML
    private TableView<Persona> tableView;

    @FXML
    private TableColumn<Persona, String> colNombre;

    @FXML
    private TableColumn<Persona, Boolean> colMayor;

    @FXML
    private TableColumn<Persona, String> colEdad;

    @FXML
    private ListProperty<Persona> listaPersonas;
    @FXML
    private ListProperty<Persona> filtroPersonas;

    private Persona persona;

    public ControllerTabla() {
    }
    public void initAttributtes(ListProperty<Persona> personas) {
        this.listaPersonas = personas;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaPersonas = new SimpleListProperty<>(FXCollections.observableArrayList());
        filtroPersonas = new SimpleListProperty<>(FXCollections.observableArrayList());

        this.tableView.setItems(listaPersonas);

        this.colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        this.colEdad.setCellValueFactory(cellData -> cellData.getValue().edadProperty());
        this.colMayor.setCellValueFactory(cellData -> cellData.getValue().mayorProperty());

        //Le decimos el tipo de celda
        this.colMayor.setCellFactory(CheckBoxTableCell.forTableColumn(this.colMayor));

    }

    public void initAttributes(ListProperty<Persona> personas) {
        this.listaPersonas = personas;
    }


    @FXML
    void onActionBorrar(ActionEvent event) {

    }

    @FXML
    void onActionInsertar(ActionEvent event) {
        //Cojo los datos
        Persona p = new Persona("","0",false);
         p.setNombre(textNombre.getText());
         try{
             p.setEdad(Integer.parseInt(textEdad.getText()));
         }catch (NumberFormatException e){
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText("Hey chaval debe de ser un numero");
             alert.setTitle("Error");
             alert.setContentText("Inserta un numero");
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
         if(p.getEdad()>=18){
             p.setMayor(true);
         }else {
             p.setMayor(false);
         }
         if(p.getEdad()>0 || p.getNombre().length()>0 || p.isMayor() || !this.listaPersonas.contains(p)){
             //this.listaPersonas = new SimpleListProperty<>();
             this.initAttributes(this.listaPersonas);
             this.listaPersonas.add(p);
             this.textEdad.clear();
             this.textNombre.clear();
             this.checkMayor.setSelected(false);
             this.tableView.refresh();
         }

        System.out.println(p.getNombre());

        }


    @FXML
    void onActionMod(ActionEvent event) {
        Persona p = this.tableView.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();

        } else {
            try {
                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(App.class.getResource("fxml/PersonaDialogVista.fxml"));

                // Cargo la ventana
                Parent root = loader.load();

                //Obtenmos su controlador
                PersonasDialogControlador controlador = loader.getController();

                //Llamamos a personas para inicializar ese atributo
                controlador.initAttributes(listaPersonas, p);

                //Creamos la scena
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL); //Utilizamos Modality.APPLICATION_MODAL
                stage.setScene(scene);
                stage.showAndWait();


                Persona pSeleccionado = controlador.getPersona();

                // cojo la persona devuelta
                if (pSeleccionado != null) {
                    if(!listaPersonas.contains(pSeleccionado)){
                        //Si no lo contiene debe eliminarse del filtro.
                        this.filtroPersonas.remove(pSeleccionado);
                        //Si el objeto se modifica mientras se filtra, debe eliminarse del filtro
                    }
                    this.tableView.refresh();
                }
            } catch (IOException ioException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(
                        "hola"
                );
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onActionSalir(ActionEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }


    public GridPane getView() {
        return viewListColumns;
    }


}
