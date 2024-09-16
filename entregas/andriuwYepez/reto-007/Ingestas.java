import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ingestas {
    private int numeroIngesta;
    private List<Alimentos> alimentos;

    public Ingestas(int numeroIngesta) {
        this.numeroIngesta = numeroIngesta;
        this.alimentos = new ArrayList<>();
    }

    public void agregarAlimento(Alimentos alimento) {
        alimentos.add(alimento);
    }

    public int getNumeroIngesta() {
        return numeroIngesta;
    }

    public List<Alimentos> getAlimentos() {
        return alimentos;
    }
}