package src;

public class NodoArbol<T extends DatosArbol> implements Comparable <NodoArbol<T>> {
    private T value;
    private GenericList<NodoArbol<T>> hijos;
    public NodoArbol(T value) {
        this.value = value;
        this.hijos = new GenericList<NodoArbol<T>>();
    }
    @Override
    public int compareTo(NodoArbol<T> o) {
        return 0;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public GenericList<NodoArbol<T>> getHijos() {
        return hijos;
    }
    public void setHijos(GenericList<NodoArbol<T>> hijos) {
        this.hijos = hijos;
    }
    public void insertarHijo(NodoArbol<T> hijo){

        hijos.insertEnd(hijo);
    }


}
