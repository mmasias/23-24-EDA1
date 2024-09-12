import java.time.LocalTime;

public class Evento {
    private LocalTime hora;
    private String descripcion;

    public Evento(LocalTime hora, String descripcion) {
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
