import java.util.ArrayList;
import java.util.List;

public class Dia {
    private int numDia;
    private List<Ingesta> ingestas;

    public Dia(int numDia) {
        this.numDia = numDia;
        this.ingestas = new ArrayList<>();
        this.ingestas.add(new Ingesta("Desayuno"));
        this.ingestas.add(new Ingesta("Media mañana"));
        this.ingestas.add(new Ingesta("Almuerzo"));
        this.ingestas.add(new Ingesta("Merienda"));
        this.ingestas.add(new Ingesta("Cena"));
    }

    public int getNumDia() {
        return numDia;
    }

    public Ingesta getIngestas(int i) {
       return ingestas.get(i);
    }

    public void listarIngestas(){
        int i = 0;
        for (Ingesta ingestas : ingestas) {
            System.out.print("            ");
            System.out.println(ingestas.getTiempoIngesta());
            ingestas.listarAlimentos();
            i++;
        }
    }


}
