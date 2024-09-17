class Encuesta {
    private int dia;
    private BinaryTree<Ingesta> ingestas;

    public Encuesta(int dia) {
        this.dia = dia;
        this.ingestas = new BinaryTree<>();
    }

    public int getDia() {
        return dia;
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.add(ingesta.getTipoIngesta(), ingesta);
    }

    public Ingesta obtenerIngesta(int tipoIngesta) {
        return ingestas.find(tipoIngesta);
    }
}
