import java.util.ArrayList;
import java.util.List;

class Encuesta {
    private String paciente;
    private String fechaToma;
    private List<Dia> dias;

    public Encuesta(String paciente, String fechaToma) {
        this.paciente = paciente;
        this.fechaToma = fechaToma;
        this.dias = new ArrayList<>();
    }

    public void agregarDia(Dia dia) {
        dias.add(dia);
    }

    public String getPaciente() {
        return paciente;
    }

    public String getFechaToma() {
        return fechaToma;
    }

    public List<Dia> getDias() {
        return dias;
    }

    public Dia agregarDia(int numero) {
        Dia dia = new Dia(numero);
        dias.add(dia);
        return dia;
    }
}
