package src;

import java.util.ArrayList;
import java.util.List;

public class Dia {
    private int fecha;
    private List<Ingesta> ingestas;

    public Dia(int fecha) {
        this.fecha = fecha;
        this.ingestas = new ArrayList<>();
    }

    public int getFecha() {
        return fecha;
    }

    public List<Ingesta> getIngestas() {
        return ingestas;
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.add(ingesta);
    }

    public Ingesta obtenerIngesta(Horario horario) {
        for (Ingesta ingesta : ingestas) {
            if (ingesta.getHorario() == horario) {
                return ingesta;
            }
        }
        return null;
    }
}
