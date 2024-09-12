import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;

public class Encuesta {
    private LocalDate fechaEncuesta;
    private LocalTime horaEncuesta;
    private DatosArbol<Dia> dias;

    public Encuesta(LocalDate fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
        this.dias = new DatosArbol<>(Comparator.comparing(Dia::getNumeroDia));
    }

    public void setHoraEncuesta(LocalTime horaEncuesta) {
        this.horaEncuesta = horaEncuesta;
    }

    public LocalDate getFechaEncuesta() {
        return fechaEncuesta;
    }

    public LocalTime getHoraEncuesta() {
        return horaEncuesta;
    }

    public void agregarDia(Dia dia) {
        dias.insertar(dia);
    }

    public Dia buscarDia(int numeroDia) {
        return dias.buscar(new Dia(numeroDia));
    }

    public DatosArbol<Dia> getDias() {
        return dias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    Encuesta realizada el ").append(fechaEncuesta).append(" a las ").append(horaEncuesta).append("\n");
        for (int i = 1; i <= 5; i++) {
            Dia dia = dias.buscar(new Dia(i));
            if (dia == null) {
                dia = new Dia(i);
            }
            sb.append(dia.toString());
        }
        return sb.toString();
    }
}
