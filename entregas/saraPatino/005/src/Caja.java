package src;

import java.util.LinkedList;
import java.util.Queue;

public class Caja {
    private Queue<Persona> clientes;

    public Caja() {
        clientes = new LinkedList<>();
    }

    public boolean estaDisponible() {
        return clientes.isEmpty();
    }

    public void atenderCliente() {
        if (!clientes.isEmpty()) {
            Persona cliente = clientes.poll();
            cliente.atenderItem();
        }
    }

    public void agregarCliente(Persona cliente) {
        clientes.offer(cliente);
    }
}