class ArbolBinarioBusqueda {
    private NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void insertar(Alimento alimento) {
        raiz = insertarRec(raiz, alimento);
    }

    private NodoArbol insertarRec(NodoArbol nodo, Alimento alimento) {
        if (nodo == null) {
            return new NodoArbol(alimento);
        }

        if (alimento.nombre.compareToIgnoreCase(nodo.alimento.nombre) < 0) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, alimento);
        } else if (alimento.nombre.compareToIgnoreCase(nodo.alimento.nombre) > 0) {
            nodo.derecho = insertarRec(nodo.derecho, alimento);
        }

        return nodo;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo);
            System.out.println("- " + nodo.alimento.nombre + ": " + nodo.alimento.cantidad + " " + nodo.alimento.unidad);
            inOrdenRec(nodo.derecho);
        }
    }
}
