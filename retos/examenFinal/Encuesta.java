import java.time.LocalDate;

public class Encuesta implements DatosLista{
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
    public String getInfo() {
        return "fecha de encuesta: "+this.fecha.toString();
    }

}
