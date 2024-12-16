public class Dia implements Comparable<Dia>{
    private int fecha;
    private List<Ingesta> ingestas;
    public Dia(int fecha) {
        this.fecha = fecha;
        this.ingestas = new List<>();
    }
    public int getFecha() {
        return fecha;
    }
    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public int compareTo(Dia o) {
        if (this.fecha>o.fecha) {
            return 1;
        }else if (this.fecha<o.fecha) {
            return -1;
        }else {
            return 0;
        }
    }
    public List<Ingesta> getIngestas() {
        return this.ingestas;
    }
    public void setIngestas(List<Ingesta> ingestas) {
        this.ingestas = ingestas;
    }
    public void addIngesta(Ingesta ingesta) {
        this.ingestas.insertEnd(ingesta);
    }
    public String getInformacion() {
        String texto = "";
        for (int i = 0; i < ingestas.size(); i++) {
            Ingesta ingesta = ingestas.getValorPorPosicion(i);
            texto += ingesta.getInformacion() + "\n";
        }
        return texto;
    }
    
}
