class IngestaTipo {
    private String tipo;
    private Ingestas ingestas;

    public IngestaTipo(String tipo, Ingestas ingestas) {
        this.tipo = tipo;
        this.ingestas = ingestas;
    }

    public String getTipo() {
        return tipo;
    }

    public Ingestas getIngestas() {
        return ingestas;
    }

    public String toString() {
        return "Ingesta " + tipo + ": " + ingestas.toString();
    }
   
}