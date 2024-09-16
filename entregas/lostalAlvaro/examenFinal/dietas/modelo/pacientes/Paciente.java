package modelo.pacientes;

import java.time.LocalDate;

import modelo.arbol.DatosArbol;

public class Paciente implements DatosArbol {
    private String nombre;
    private LocalDate fecha;

    public Paciente(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String getInformacion() {
        return "Nombre del paciente: " + this.nombre + " / Fecha del paciente: " + this.fecha.toString();
    }
}
