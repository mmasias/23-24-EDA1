package Hashmaps.model;
import java.util.HashMap;
import java.util.Map;

public class Dia {
    public Map<String, Ingesta> ingestas;

    public Dia() {
        this.ingestas = new HashMap<>();
    }

    public void agregarIngesta(String tipo, Ingesta ingesta) {
        this.ingestas.put(tipo, ingesta);
    }
}
