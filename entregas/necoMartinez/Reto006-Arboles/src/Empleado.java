package src;

import java.util.ArrayList;
import java.util.List;

class Empleado {
    String nombre;
    String cargo;

    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }
}