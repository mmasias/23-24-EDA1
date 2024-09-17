package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private LocalDate fechaDeAlta;
    private List<Encuesta> encuestas;
    private List<Dia> dias;

    public Paciente(String nombre, LocalDate fechaDeAlta) {
        this.nombre = nombre;
        this.fechaDeAlta = fechaDeAlta;
        this.encuestas = new ArrayList<>();
        this.dias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void agregarEncuesta(Encuesta encuesta) {
        encuestas.add(encuesta);
    }

    public void agregarDia(Dia dia) {
        dias.add(dia);
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }

    public List<Dia> getDias() {
        return dias;
    }

    @Override
    public int compareTo(Paciente o) {
        return this.nombre.compareTo(o.nombre);
    }

    public String getInformacion() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nombre: " + nombre + ", Fecha de Alta: " + fechaDeAlta.format(formatter) +
                ", Encuestas: " + encuestas.size() + ", Días: " + dias.size();
    }

    @Override
    public String toString() {
        return getInformacion();
    }
}
