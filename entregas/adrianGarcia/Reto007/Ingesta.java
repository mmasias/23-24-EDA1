import java.time.LocalTime;
import java.util.Comparator;
import java.util.StringJoiner;

public class Ingesta {
    private String tipoComida;
    private LocalTime horario;
    private DatosArbol<Alimento> alimentos;

    public Ingesta(String tipoComida, LocalTime horario) {
        this.tipoComida = tipoComida;
        this.horario = horario;
        this.alimentos = new DatosArbol<>(Comparator.comparing(Alimento::getNombre));
    }

    public void agregarAlimento(Alimento alimento) {
        alimentos.insertar(alimento);
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String listarAlimentos() {
        StringJoiner joiner = new StringJoiner("\n");
        alimentos.recorrerInOrden(a -> joiner.add("                " + a.toString()));
        return joiner.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("            ").append(tipoComida);
        if (horario != null) {
            sb.append(" a las ").append(horario);
        }
        sb.append("\n").append(listarAlimentos());

        sb.append("\n");

        return sb.toString();
    }
}
