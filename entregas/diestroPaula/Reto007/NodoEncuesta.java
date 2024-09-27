import java.util.ArrayList;
import java.util.List;

public class NodoEncuesta {
    private Encuesta encuesta;
    private List<NodoEncuesta> hijos;

    public NodoEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
        this.hijos = new ArrayList<>();
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public List<NodoEncuesta> getHijos() {
        return hijos;
    }

    public void agregarHijo(NodoEncuesta hijo) {
        hijos.add(hijo);
    }
}
