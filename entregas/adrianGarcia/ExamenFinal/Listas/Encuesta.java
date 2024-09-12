import java.time.LocalDate;

public class Encuesta {
    private LocalDate fechaEncuesta;
    private GenericList<Dia> dias;

    public Encuesta(LocalDate fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
        this.dias = new GenericList<>();
    }

    public void agregarDia(Dia dia) {
        dias.insertEnd(dia);
    }

    public Dia buscarDia(int numeroDia) {
        GenericNode<Dia> current = dias.getFirst();
        while (current != null) {
            Dia dia = current.getValue();
            if (dia.getNumeroDia() == numeroDia) {
                return dia;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encuesta realizada el ").append(fechaEncuesta).append("\n");

        GenericNode<Dia> current = dias.getFirst();
        while (current != null) {
            Dia dia = current.getValue();
            if (dia != null) {
                sb.append(dia.toString()).append("\n");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    // Getters and Setters
    public LocalDate getFechaEncuesta() {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(LocalDate fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
    }

    public GenericList<Dia> getDias() {
        return dias;
    }

    public void setDias(GenericList<Dia> dias) {
        this.dias = dias;
    }
}



