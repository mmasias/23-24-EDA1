import java.time.LocalTime;

public class Evento {
    private LocalTime hora;
    private String descripcion;

    public Evento(LocalTime hora, String descripcion) {
        this.hora = hora;
        this.descripcion = descripcion;
    }

    // Getters
    public LocalTime getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "hora=" + hora +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
