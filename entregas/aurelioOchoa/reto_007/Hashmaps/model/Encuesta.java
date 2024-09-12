package Hashmaps.model;
import java.util.HashMap;
import java.util.Map;

public class Encuesta {
    public Map<Integer, Dia> dias;

    public Encuesta() {
        this.dias = new HashMap<>();
    }

    public void agregarDia(int numero, Dia dia) {
        this.dias.put(numero, dia);
    }
}