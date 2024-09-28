public class Dia {
    private Ingesta desayuno;
    private Ingesta mediaManana;
    private Ingesta almuerzo;
    private Ingesta merienda;
    private Ingesta cena;

    public Dia() {
        this.desayuno = new Ingesta();
        this.mediaManana = new Ingesta();
        this.almuerzo = new Ingesta();
        this.merienda = new Ingesta();
        this.cena = new Ingesta();
    }

    public Ingesta getDesayuno() {
        return desayuno;
    }

    public Ingesta getMediaManana() {
        return mediaManana;
    }

    public Ingesta getAlmuerzo() {
        return almuerzo;
    }

    public Ingesta getMerienda() {
        return merienda;
    }

    public Ingesta getCena() {
        return cena;
    }

    public void agregarIngesta(Ingesta ingesta) {
        // Este método se encarga de agregar una ingesta específica al día.
    }
}