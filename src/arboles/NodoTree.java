public class NodoTree<T> {

    private T dato;
    private NodoTree<T> izquierdo;
    private NodoTree<T> derecho;

    public NodoTree(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;

    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoTree<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoTree<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoTree<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoTree<T> derecho) {
        this.derecho = derecho;
    }
}
