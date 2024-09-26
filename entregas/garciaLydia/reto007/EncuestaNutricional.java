package entregas.garciaLydia.reto007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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