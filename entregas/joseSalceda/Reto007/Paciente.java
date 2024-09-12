import java.util.ArrayList;
import java.util.List;

class Paciente {
    private String nombre;
    private List<Encuesta> encuestas;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.encuestas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEncuesta(Encuesta encuesta) {
        encuestas.add(encuesta);
    }

    public Encuesta obtenerEncuestaPorDia(int dia) {
        for (Encuesta encuesta : encuestas) {
            if (encuesta.getDia() == dia) {
                return encuesta;
            }
        }
        return null;
    }
}