import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nombre;
    private List<Encuesta> encuestas = new ArrayList<>();

    public Paciente(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEncuesta(Encuesta encuesta) {
        encuestas.add(encuesta);
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }
}
