import org.w3c.dom.Node;

public class NodoArbol<T extends DatosArbol> implements Comparable<NodoArbol<T>> {
    private T valor;
    private GenericList<NodoArbol<T>> hijos;

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

    public NodoArbol(T valor) {
        this.valor = valor;
        this.hijos = new GenericList<>();
    }

    public void insertarHijos(NodoArbol<T> hijo) {
        hijos.insertEnd(hijo);
    }


    @Override
    public int compareTo(NodoArbol<T> o) {
        return 0;
    }

}
