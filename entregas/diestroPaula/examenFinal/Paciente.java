public class Paciente {
    private String nombre;
    public Paciente(String nombre) {
        this.nombre = nombre;
        new Encuesta();
    }

    public String getNombre() {
        return nombre;
    }   
}