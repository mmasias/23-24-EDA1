package modelo.arbol;

import java.util.ArrayList;
import java.util.List;

public class NodoArbol<T extends DatosArbol> implements Comparable<NodoArbol<T>> {
    private T valor;
    private List<NodoArbol<T>> hijos;

    public NodoArbol(T valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    @Override
    public int compareTo(NodoArbol<T> o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

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

    public void insertarHijos(List<NodoArbol<T>> hijos) {
        this.hijos.addAll(hijos);
    }

}
