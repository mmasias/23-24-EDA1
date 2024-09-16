public class Caja {
    private Cliente clienteActual = null;

    public void atenderCliente(Cliente cliente) {
        this.clienteActual = cliente;
    }

    public void procesar() {
        if (clienteActual != null) {
            clienteActual.atenderUnItem();
            if (clienteActual.terminado()) {
                clienteActual = null;
            }
        }
    }

    public boolean estaOcupada() {
        return clienteActual != null && !clienteActual.terminado();
    }

    public int getItemsPendientes() {
        return clienteActual != null ? clienteActual.getItems() : 0;
    }
}
