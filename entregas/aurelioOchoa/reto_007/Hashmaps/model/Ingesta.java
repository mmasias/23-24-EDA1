package Hashmaps.model;
import java.util.ArrayList;
import java.util.List;

public class Ingesta {
    public List<Alimento> alimentos;

    public Ingesta() {
        this.alimentos = new ArrayList<>();
    }

    public void agregarAlimento(String nombre) {
        this.alimentos.add(new Alimento(nombre));
    }
}

