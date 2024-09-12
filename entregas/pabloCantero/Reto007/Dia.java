import java.time.LocalDate;

public class Dia implements DatosArbol {
    private int fecha;
    private GenericList<Ingesta> ingestas;
    public Dia(int fecha) {
        this.fecha = fecha;
        this.ingestas = new GenericList<Ingesta>();
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public GenericList<Ingesta> getIngestas() {
        return ingestas;
    }
    public void setIngestas(GenericList<Ingesta> ingestas) {
        this.ingestas = ingestas;
    }

    @Override
    public String getInformacion() {
        return "Dia: "+this.fecha;
    }
    
}
