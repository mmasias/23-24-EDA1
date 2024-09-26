package entregas.garciaLydia.reto007;

import java.util.ArrayList;
import java.util.List;

public class Dia {
    private int numero;
    private List<String> tiposIngesta;
    private List<List<Alimento>> alimentosPorTipo;

    public Dia(int numero) {
        this.numero = numero;
        this.tiposIngesta = new ArrayList<>();
        this.alimentosPorTipo = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void agregarAlimento(String tipoIngesta, Alimento alimento) {
        int index = tiposIngesta.indexOf(tipoIngesta);
        if (index == -1) {
            tiposIngesta.add(tipoIngesta);
            List<Alimento> nuevaLista = new ArrayList<>();
            nuevaLista.add(alimento);
            alimentosPorTipo.add(nuevaLista);
        } else {
            alimentosPorTipo.get(index).add(alimento);
        }
    }

    public List<String> getTiposIngesta() {
        return tiposIngesta;
    }

    public List<List<Alimento>> getAlimentosPorTipo() {
        return alimentosPorTipo;
    }
}