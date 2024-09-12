import java.time.LocalDate;

public class Paciente {
    
    private LocalDate fechaDeAlta;
    private String nombre;
    private List<Encuesta> encuesta;

    public Paciente(String nombre, LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
        this.nombre = nombre;
        this.encuesta = new List<>();
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

    public List<Encuesta> getEncuestas() {
        return encuesta;
    }

    public void setEncuestas(List<Encuesta> encuesta) {
        this.encuesta = encuesta;
    }

    public void addEncuesta(Encuesta encuesta) {
        this.encuesta.insertEnd(encuesta);
    }

    public String getInformacion() {
        String texto = "";
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de alta: " + this.fechaDeAlta);
        return texto;
    }
}
