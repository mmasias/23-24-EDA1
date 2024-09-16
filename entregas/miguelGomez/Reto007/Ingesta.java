import java.util.ArrayList;
import java.util.List;

class Ingesta {
    private String tipo;
    private List<Alimento> alimentos;

    public Ingesta(String tipo) {
        this.tipo = tipo;
        this.alimentos = new ArrayList<>();
    }

    public void agregarAlimento(Alimento alimento) {
        alimentos.add(alimento);
    }

    public String getTipo() {
        return tipo;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }
}
