public class ArbolEncuestas {
    private NodoEncuesta raiz;

    public ArbolEncuestas() {
        this.raiz = new NodoEncuesta(null);
    }

    public void agregarEncuesta(Encuesta encuesta) {
        NodoEncuesta nuevoNodo = new NodoEncuesta(encuesta);
        raiz.agregarHijo(nuevoNodo);
    }

    public NodoEncuesta getRaiz() {
        return raiz;
    }
}