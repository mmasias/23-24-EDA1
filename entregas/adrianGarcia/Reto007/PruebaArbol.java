import java.util.function.Consumer;

public class PruebaArbol {
    public static void main(String[] args) {
        Arbol<Integer> arbol = new Arbol<>();
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(2);
        arbol.insertar(4);

        arbol.recorrerInOrden(System.out::println);
    }

    static class Arbol<T extends Comparable<T>> {
        private Nodo<T> raiz;

        public void insertar(T valor) {
            raiz = insertarRecursivo(raiz, valor);
        }

        private Nodo<T> insertarRecursivo(Nodo<T> actual, T valor) {
            if (actual == null) {
                return new Nodo<>(valor);
            }

            if (valor.compareTo(actual.valor) < 0) {
                actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
            } else if (valor.compareTo(actual.valor) > 0) {
                actual.derecho = insertarRecursivo(actual.derecho, valor);
            }

            return actual;
        }

        public void recorrerInOrden(Consumer<T> accion) {
            recorrerInOrdenRecursivo(raiz, accion);
        }

        private void recorrerInOrdenRecursivo(Nodo<T> actual, Consumer<T> accion) {
            if (actual != null) {
                recorrerInOrdenRecursivo(actual.izquierdo, accion);
                accion.accept(actual.valor);
                recorrerInOrdenRecursivo(actual.derecho, accion);
            }
        }

        static class Nodo<T> {
            T valor;
            Nodo<T> izquierdo;
            Nodo<T> derecho;

            Nodo(T valor) {
                this.valor = valor;
                izquierdo = null;
                derecho = null;
            }
        }
    }
}
