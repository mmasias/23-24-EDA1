package entregas.garciaLydia.reto007;

public class Ingesta {
    private String tipo;
    private Alimento alimento;

    public Ingesta(String tipo, Alimento alimento) {
        this.tipo = tipo;
        this.alimento = alimento;
    }

    public String getTipo() {
        return tipo;
    }

    public Alimento getAlimento() {
        return alimento;
    }
}

