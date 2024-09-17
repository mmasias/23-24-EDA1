import java.time.LocalDate;

public class Paciente implements DatosLista{
    private LocalDate fechaDeAlta;
    private String nombre;
    private Encuesta encuesta;
    public Paciente(LocalDate fechaDeAlta, String nombre, Encuesta encuesta) {
        this.fechaDeAlta = fechaDeAlta;
        this.nombre = nombre;
        this.encuesta = encuesta;
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String getInformacion() {
        return "Paciente: "+nombre+ "\nFecha de alta: "+fechaDeAlta;

        
    }
    public Encuesta getEncuesta() {
        return encuesta;
    }
    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
    
}