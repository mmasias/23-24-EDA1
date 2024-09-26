class Paciente {
    private String nombre;
    private BinaryTree<Encuesta> encuestas;


    public Paciente(String nombre) {
        this.nombre = nombre;
        this.encuestas = new BinaryTree<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEncuesta(Encuesta encuesta) {
        encuestas.add(encuesta.getDia(), encuesta);
    }

    public Encuesta obtenerEncuestaPorDia(int dia) {
        return encuestas.find(dia);
    }
}