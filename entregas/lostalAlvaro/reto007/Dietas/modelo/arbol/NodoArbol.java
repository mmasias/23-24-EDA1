package modelo.arbol;

import modelo.estructuras.GenericList;

public class NodoArbol<T extends DatosArbol> implements Comparable<NodoArbol<T>> {
    private T valor;
    private GenericList<NodoArbol<T>> hijos;

    public NodoArbol(T valor) {
        this.valor = valor;
        this.hijos = new GenericList<>();
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

    public GenericList<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void setHijos(GenericList<NodoArbol<T>> hijos) {
        this.hijos = hijos;
    }

    public void insertarHijos(NodoArbol<T> hijo) {
        hijos.insertEnd(hijo);
    }

}
