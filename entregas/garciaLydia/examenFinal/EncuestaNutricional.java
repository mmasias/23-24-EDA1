package entregas.garciaLydia.examenFinal;

import java.util.ArrayList;
import java.util.List;

public class EncuestaNutricional {
    private String nombrePaciente;
    private String fechaAlta;
    private List<Dia> dias;

    public EncuestaNutricional(String nombrePaciente, String fechaAlta) {
        this.nombrePaciente = nombrePaciente;
        this.fechaAlta = fechaAlta;
        this.dias = new ArrayList<>();
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public List<Dia> getDias() {
        return dias;
    }

    public void agregarDia(Dia dia) {
        dias.add(dia);
    }
}