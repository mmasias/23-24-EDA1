package core;
import generica.GenericList;
import generica.GenericNode;

public class ColaClientes<T> {
    private GenericList<T> clientes;

    public ColaClientes() {
        clientes = new GenericList<T>();
    }

    public void agregarCliente(T cliente) {
        clientes.insertEnd(cliente);
    }

    public T obtenerSiguienteCliente() {
        if (!clientes.isEmpty()) {
            GenericNode<T> next = clientes.getFirst();
            T cliente = next.getValue();
            clientes.deleteFront();
            return cliente;
        }
        return null;
    }

    public boolean estaVacia() {
        return clientes.isEmpty();
    }

    public int size() {
        return clientes.size();
    }
}
