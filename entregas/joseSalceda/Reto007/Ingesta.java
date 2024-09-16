import java.util.ArrayList;
import java.util.List;

class Ingesta {
    private int tipoIngesta; // 1: Desayuno, 2: Media mañana, etc.
    private List<String> alimentos;

    public Ingesta(int tipoIngesta) {
        this.tipoIngesta = tipoIngesta;
        this.alimentos = new ArrayList<>();
    }

    public int getTipoIngesta() {
        return tipoIngesta;
    }

    public void agregarAlimento(String alimento) {
        alimentos.add(alimento);
    }

    public void listarAlimentos() {
        System.out.println("Alimentos para la ingesta " + tipoIngesta + ":");
        for (String alimento : alimentos) {
            System.out.println(alimento);
        }
    }
}