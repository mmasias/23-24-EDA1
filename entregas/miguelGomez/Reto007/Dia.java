import java.util.ArrayList;
import java.util.List;
class Dia {
    private int numero;
    private List<Ingesta> ingestas;

    public Dia(int numero) {
        this.numero = numero;
        this.ingestas = new ArrayList<>();
        inicializarIngestas();
    }

    private void inicializarIngestas() {
        for (int i = 1; i <= 5; i++) {
            ingestas.add(new Ingesta(obtenerTipoIngesta(i)));
        }
    }

    private String obtenerTipoIngesta(int numero) {
        switch (numero) {
            case 1: return "Desayuno";
            case 2: return "Media mañana";
            case 3: return "Almuerzo";
            case 4: return "Merienda";
            case 5: return "Cena";
            default: return "";
        }
    }

    public int getNumero() {
        return numero;
    }

    public List<Ingesta> getIngestas() {
        return ingestas;
    }
}
