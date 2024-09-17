import java.util.ArrayList;
import java.util.List;

public class NodoArbol<T extends DatosArbol> {
    private T valor;
    private List<NodoArbol<T>> hijos;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public List<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoArbol<T>> hijos) {
        this.hijos = hijos;
    }

    public NodoArbol(T valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    public void insertarHijos(NodoArbol<T> hijo) {
        hijos.add(hijo);
    }
}