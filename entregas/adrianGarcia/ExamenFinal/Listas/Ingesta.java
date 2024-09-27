import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ingesta {
    private String tipoComida;
    private LocalTime horario;
    private GenericList<Alimento> alimentos;

    public Ingesta(String tipoComida, LocalTime horario) {
        this.tipoComida = tipoComida;
        this.horario = horario;
        this.alimentos = new GenericList<>();
    }

    public void agregarAlimento(Alimento alimento) {
        alimentos.insertEnd(alimento);
    }

    public String listarAlimentos() {
        StringBuilder sb = new StringBuilder();
        // Aquí cambiamos el enfoque para iterar directamente sobre la lista
        GenericNode<Alimento> current = alimentos.getFirst();
        while (current != null) {
            sb.append(current.getValue().toString()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(tipoComida);
        if (horario != null) {
            sb.append(" a las ").append(horario.format(DateTimeFormatter.ofPattern("HH:mm")));
        }
        sb.append("\n").append(listarAlimentos());
        return sb.toString().trim(); // Trim para eliminar espacio extra al final
    }

    // Getters and Setters
    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public GenericList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(GenericList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
}






