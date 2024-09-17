import java.util.HashMap;
import java.util.Map;

class Encuesta {
    private int dia;
    private Map<Integer, Ingesta> ingestas;

    public Encuesta(int dia) {
        this.dia = dia;
        this.ingestas = new HashMap<>();
    }

    public int getDia() {
        return dia;
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.put(ingesta.getTipoIngesta(), ingesta);
    }

    public Ingesta obtenerIngesta(int tipoIngesta) {
        return ingestas.get(tipoIngesta);
    }
}
