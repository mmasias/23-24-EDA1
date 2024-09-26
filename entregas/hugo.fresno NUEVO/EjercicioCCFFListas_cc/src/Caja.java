
public class Caja {
    Cliente clienteActual = null;

    public void atenderCliente(Cliente cliente) {
        this.clienteActual = cliente;
    }

    public void actualizar() {
        if (clienteActual != null) {
            clienteActual.packs--;
            if (clienteActual.packs == 0) {
                clienteActual = null;
            }
        }
    }

    public boolean estaLibre() {

        if(clienteActual==null){
            return true;
        }else{
            return false;
        }
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }
}
