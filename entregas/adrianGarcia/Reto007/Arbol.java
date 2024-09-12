import java.util.Comparator;
import java.util.function.Consumer;

public class Arbol<T> {
    private NodoArbol<T> raiz;
    private Comparator<T> comparador;

    public Arbol(Comparator<T> comparador) {
        this.raiz = null;
        this.comparador = comparador;
    }

    public void insertar(T valor) {
        if (raiz == null) {
            raiz = new NodoArbol<>(valor);
        } else {
            insertar(raiz, valor);
        }
    }

    private void insertar(NodoArbol<T> nodo, T valor) {
        if (comparador.compare(valor, nodo.valor) < 0) {
            if (nodo.izquierdo == null) {
                nodo.izquierdo = new NodoArbol<>(valor);
            } else {
                insertar(nodo.izquierdo, valor);
            }
        } else if (comparador.compare(valor, nodo.valor) > 0) {
            if (nodo.derecho == null) {
                nodo.derecho = new NodoArbol<>(valor);
            } else {
                insertar(nodo.derecho, valor);
            }
        }
    }

    public T buscar(T valor) {
        return buscar(raiz, valor);
    }

    private T buscar(NodoArbol<T> nodo, T valor) {
        if (nodo == null) {
            return null;
        }

        int comparacion = comparador.compare(valor, nodo.valor);
        if (comparacion == 0) {
            return nodo.valor;
        } else if (comparacion < 0) {
            return buscar(nodo.izquierdo, valor);
        } else {
            return buscar(nodo.derecho, valor);
        }
    }

    public void recorrerInOrden(Consumer<T> accion) {
        recorrerInOrden(raiz, accion);
    }

    private void recorrerInOrden(NodoArbol<T> nodo, Consumer<T> accion) {
        if (nodo != null) {
            recorrerInOrden(nodo.izquierdo, accion);
            accion.accept(nodo.valor);
            recorrerInOrden(nodo.derecho, accion);
        }
    }

    private static class NodoArbol<T> {
        T valor;
        NodoArbol<T> izquierdo, derecho;

        NodoArbol(T valor) {
            this.valor = valor;
            izquierdo = null;
            derecho = null;
        }
    }
}
