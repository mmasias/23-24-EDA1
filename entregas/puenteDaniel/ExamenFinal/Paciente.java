package entregas.puenteDaniel.ExamenFinal;

import java.time.LocalDate;

public class Paciente{
    private LocalDate fechaDeAlta;
    private String nombre;
    public Paciente(LocalDate fechaDeAlta, String nombre) {
        this.fechaDeAlta = fechaDeAlta;
        this.nombre = nombre;
    }
    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }
    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }
    public String getNombre() {
        return nombre;
    }
    public String getInformacion() {
        return "fecha de alta: "+fechaDeAlta+ "Nombre "+nombre;
    }
    
}