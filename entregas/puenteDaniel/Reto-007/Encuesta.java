import java.time.LocalDate;

public class Encuesta implements DatosArbol {
    private LocalDate fecha;
    public Encuesta(LocalDate fecha){
        this.fecha= fecha;
    }
    public LocalDate getFecha() {
        return this.fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String getInformacion() {
        return "fecha de la encuesta: "+fecha.toString();
    }
    
}
