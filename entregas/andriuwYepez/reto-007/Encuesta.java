import java.util.ArrayList;
import java.util.List;

public class Encuesta {
    private int dia;
    private String fechaEncuesta;
    private List<Dias> dias;

    public Encuesta(int dia, String fechaEncuesta) {
        this.dia = dia;
        this.fechaEncuesta = fechaEncuesta;
        this.dias = new ArrayList<>();
    }

    public void agregarDia(Dias dia) {
        dias.add(dia);
    }

    public int getDia() {
        return dia;
    }

    public String getFechaEncuesta() {
        return fechaEncuesta;
    }

    public List<Dias> getDias() {
        return dias;
    }
}