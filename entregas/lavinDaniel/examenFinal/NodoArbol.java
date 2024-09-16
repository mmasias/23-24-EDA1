class NodoArbol {
    Alimento alimento;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(Alimento alimento) {
        this.alimento = alimento;
        this.izquierdo = null;
        this.derecho = null;
    }
}
