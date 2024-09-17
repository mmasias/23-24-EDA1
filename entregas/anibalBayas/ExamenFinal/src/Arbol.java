import java.util.List;

public class Arbol<T extends DatosArbol> {
    private NodoArbol<T> raiz;

    public Arbol(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public void preOrden(NodoArbol<T> raiz, String nivel) {
        if (raiz != null) {
            System.out.println(nivel + raiz.getValor().getInfo());
            List<NodoArbol<T>> hijos = raiz.getHijos();
            for (NodoArbol<T> hijo : hijos) {
                preOrden(hijo, nivel + "    ");
            }
        }
    }

    public void postOrden(NodoArbol<T> nodo) {
        if (nodo != null) {
            List<NodoArbol<T>> hijos = nodo.getHijos();
            for (NodoArbol<T> hijo : hijos) {
                postOrden(hijo);
            }
            System.out.println(nodo.getValor().getInfo());
        }
    }
}