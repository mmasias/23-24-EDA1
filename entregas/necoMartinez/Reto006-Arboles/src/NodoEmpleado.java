package src;

import java.util.ArrayList;
import java.util.List;

class NodoEmpleado {
    Empleado empleado;
    List<NodoEmpleado> subordinados;

    public NodoEmpleado(Empleado empleado) {
        this.empleado = empleado;
        this.subordinados = new ArrayList<>();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void agregarSubordinado(NodoEmpleado subordinado) {
        this.subordinados.add(subordinado);
    }

    public List<NodoEmpleado> getSubordinados() {
        return subordinados;
    }
}