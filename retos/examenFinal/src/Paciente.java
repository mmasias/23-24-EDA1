import java.time.LocalDate;

public class Paciente implements DatosArbol {
    private String nombre;
    private LocalDate fechaDeAlta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Paciente(String nombre, LocalDate fechaDeAlta) {
        this.nombre = nombre;
        this.fechaDeAlta = fechaDeAlta;
    }

    @Override
    public String getInfo() {
        return "Fecha y nombre del paciente: " + this.nombre + " " + this.fechaDeAlta.toString();
    }
}
