package modelo.encuestas;

import java.time.LocalDate;

import modelo.arbol.DatosArbol;

public class Encuesta implements DatosArbol {
    private LocalDate fecha;

    public Encuesta(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String getInformacion() {
        return "La fecha en la que empieza la encuesta es: " + this.fecha.toString();
    }
    
    
}
