public class NodoArbol<T extends DatosLista> implements Comparable<NodoArbol<T>> {
    private T valor;
    private GenericList<NodoArbol<T>> hijos;

    public NodoArbol() {
    }

    public NodoArbol(T valor, GenericList<NodoArbol<T>> hijos) {
        this.valor = valor;
        this.hijos = new GenericList<NodoArbol<T>>();
    }

    @Override
    public int compareTo(NodoArbol<T> o) {
        return 0;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public GenericList<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void setHijos(GenericList<NodoArbol<T>> hijos) {
        this.hijos = hijos;
    }

    public void insertarHijos(NodoArbol<T> hijo) {
        hijos.insertarEnOrden(hijo);
    }

    public NodoArbol(T valor) {
        this.valor = valor;
        this.hijos = new GenericList<NodoArbol<T>>();
    }

}
