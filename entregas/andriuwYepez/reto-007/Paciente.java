import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paciente {
    private List<Encuesta> encuestas;

    public Paciente() {
        this.encuestas = new ArrayList<>();
    }

    public void agregarEncuesta(Encuesta encuesta) {
        this.encuestas.add(encuesta);
    }

    public List<Encuesta> getEncuestas() {
        return this.encuestas;
    }
}