import java.util.ArrayList;
import java.util.List;

public class Ingesta {
    private List<Alimento> alimentos = new ArrayList<>();

    public void agregarAlimento(Alimento alimento) {
        alimentos.add(alimento);
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }
}