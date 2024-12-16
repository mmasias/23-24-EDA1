import java.util.ArrayList;
import java.util.List;

public class Dias {
    private int numeroDia;
    private String fecha;
    private List<Ingestas> ingestas;

    public Dias(int numeroDia, String fecha) {
        this.numeroDia = numeroDia;
        this.fecha = fecha;
        this.ingestas = new ArrayList<>();
    }

    public void agregarIngesta(Ingestas ingesta) {
        ingestas.add(ingesta);
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public String getFecha() {
        return fecha;
    }

    public List<Ingestas> getIngestas() {
        return ingestas;
    }
}