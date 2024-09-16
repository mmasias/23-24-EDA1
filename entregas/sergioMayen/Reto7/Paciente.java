package entregas.sergioMayen.Reto7;

public class Paciente {
    String nombre;
    String fechaAlta;

    public Paciente(String nombre, String fechaAlta) {
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + "\nFecha de Alta: " + fechaAlta;
    }
}
