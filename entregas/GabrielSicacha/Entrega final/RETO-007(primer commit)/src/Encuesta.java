import java.util.ArrayList;
import java.util.List;

public class Encuesta {
    private final String fechaDeToma;
    private final int diasTotales;
    private List<Dia> dias;

    public Encuesta(String fechaDeToma, int diasTotales) {
        this.fechaDeToma = fechaDeToma;
        this.diasTotales = diasTotales;

        this.dias=new ArrayList<>();
        for(int i=0; i<diasTotales;i++){
            dias.add(new Dia(i+1));
        }
    }

    public Dia getDia(int i){
        return dias.get(i);
    }

    public String getFechaDeToma() {
        return fechaDeToma;
    }

    public int getDiasTotales() {
        return diasTotales;
    }

    public void listarDias(){
        int i = 0;
        for (Dia dias : dias) {
            System.out.print("        ");
            System.out.println("Dia "+dias.getNumDia());
            dias.listarIngestas();
            i++;
        }
    }


}
