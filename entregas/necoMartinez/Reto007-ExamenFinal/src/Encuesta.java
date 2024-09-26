package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encuesta {
    private LocalDate fecha;
    private List<Dia> dias;

    public Encuesta(LocalDate fecha) {
        this.fecha = fecha;
        this.dias = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Dia> getDias() {
        return dias;
    }

    public void agregarDia(Dia dia) {
        dias.add(dia);
    }

    @Override
    public String toString() {
        return "Fecha de la encuesta: " + fecha.toString();
    }
}
