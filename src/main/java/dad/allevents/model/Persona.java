package dad.allevents.model;

import javafx.beans.property.*;

public class Persona {
    private StringProperty nombre;
    private BooleanProperty mayor;
    private StringProperty edad;

    public Persona(String nombre, String edad, Boolean mayor) {
        this.nombre = new SimpleStringProperty(nombre);
        this.edad = new SimpleStringProperty(edad);
        this.mayor = new SimpleBooleanProperty(mayor);
    }
    public Persona() {
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public boolean isMayor() {
        return mayor.get();
    }

    public BooleanProperty mayorProperty() {
        return mayor;
    }

    public void setMayor(boolean mayor) {
        this.mayor.set(mayor);
    }

    public int getEdad() {
        return Integer.parseInt(edad.get());
    }

    public StringProperty edadProperty() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad.set(String.valueOf(edad));
    }
}
