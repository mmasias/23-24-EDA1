public class Cola<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        public Nodo(T valor) {
            this.valor = valor;
        }
    }

    public Cola() {
        primero = null;
        ultimo = null;
    }

    public void newClient(T cliente) {
        Nodo<T> nuevoNodo = new Nodo<>(cliente);
        if (isEmpty()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
    }

    public T obtenerSiguienteCliente() {
        if (!isEmpty()) {
            T cliente = primero.valor;
            primero = primero.siguiente;
            if (primero == null) {
                ultimo = null;
            }
            return cliente;
        }
        return null;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {
        int count = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

}
