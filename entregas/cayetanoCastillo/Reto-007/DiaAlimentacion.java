package ProyectoFinal;

public class DiaAlimentacion {
    private int numeroDia;
    private Tree<Ingesta> ingestas;

    public DiaAlimentacion(int numeroDia) {
        this.numeroDia = numeroDia;
        this.ingestas = new Tree<>();
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.add(ingesta);
    }

    public Ingesta buscarIngesta(int tipoIngesta) {
        return ingestas.find(new Ingesta(tipoIngesta));
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(int numeroDia) {
        this.numeroDia = numeroDia;
    }

    public Tree<Ingesta> getIngestas() {
        return ingestas;
    }

    // Métodos para manejar ingestas
}
