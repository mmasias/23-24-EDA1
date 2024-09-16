import java.util.ArrayList;
import java.util.List;

public class Encuesta {
    private List<Dia> dias = new ArrayList<>();

    public void agregarDia(Dia dia) {
        dias.add(dia);
    }

    public List<Dia> getDias() {
        return dias;
    }
}
