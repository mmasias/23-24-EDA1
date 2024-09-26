package entregas.puenteDaniel.ExamenFinal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dia {
    private LocalDate fecha;
    private List<Ingesta> ingestas;

    public Dia(LocalDate i) {
        this.fecha = i;
        this.ingestas = new ArrayList<>();
    }

    public Dia(int i) {
        //TODO Auto-generated constructor stub
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Ingesta> getIngestas() {
        return ingestas;
    }

    public void setIngestas(List<Ingesta> ingestas) {
        this.ingestas = ingestas;
    }

    public String getInformacion() {
        return "Día: " + this.fecha;
    }

    public static void main(String[] args) {
        LocalDate fechaHoy = LocalDate.now();
        Dia dia = new Dia(fechaHoy);

        Alimento alimento1 = new Alimento("Cereal", 200);
        Alimento alimento2 = new Alimento("Pollo", 300);

        Ingesta ingesta1 = new Ingesta(Horario.DESAYUNO);
        ingesta1.agregarAlimento(alimento1);

        Ingesta ingesta2 = new Ingesta(Horario.ALMUERZO);
        ingesta2.agregarAlimento(alimento2);

        dia.getIngestas().add(ingesta1);
        dia.getIngestas().add(ingesta2);

        System.out.println(dia.getInformacion());
        for (Ingesta ingesta : dia.getIngestas()) {
            System.out.println(ingesta.getInformacion());
        }
    }

    public void insertarIngesta(Ingesta ing) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertarIngesta'");
    }
}