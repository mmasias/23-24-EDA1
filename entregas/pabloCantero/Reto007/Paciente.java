import java.time.LocalDate;

public class Paciente implements DatosArbol{
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String getInformacion() {
        return "Paciente: "+nombre+ "\nFecha de alta: "+fechaDeAlta;

        
    }
    
}