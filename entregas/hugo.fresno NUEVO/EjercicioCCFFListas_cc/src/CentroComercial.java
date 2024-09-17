import java.util.Random;

public class CentroComercial {
    static final int minItems = 5;
    static final int maxItems = 15;
    static final double probLlegada = 0.6;

    List<Caja> cajas;
    List<Cliente> colaClientes;
    Random random;

    public CentroComercial(int numeroDeCajas) {
        //Se pasa número de cajas en el constructor al iniciar en la main, se hizo para ver que se podia hacer bien
        cajas = new List<>();
        colaClientes = new List<>();
        random = new Random();

        for (int i = 0; i < numeroDeCajas; i++) {
            cajas.insert(new Caja(), -1);
        }
    }

    public void simularMinuto() {
        llegadaDeClientes();
        procesarCajas();
        mostrarEstado();
    }

    private void llegadaDeClientes() {
        if (random.nextDouble() < probLlegada) {
            int items = random.nextInt(maxItems - minItems + 1) + minItems;
            colaClientes.insert(new Cliente(items), -1);
        }
    }

    private void procesarCajas() {
        Node<Caja> cajaNode = cajas.getFirst();
        for (int i = 0; i < cajas.size(); i++) {
            if (cajaNode == null) {
                break;
            }
            Caja caja = cajaNode.getData();
            if (caja.estaLibre() && !colaClientes.isEmpty()) {
                Cliente cliente = colaClientes.getFirst().getData();
                caja.atenderCliente(cliente);
                colaClientes.remove(0);
            }
            caja.actualizar();
            cajaNode = cajaNode.getNext();
        }
    }

    private void mostrarEstado() {
        System.out.println("Clientes en cola: " + colaClientes.size());
        Node<Caja> cajaNode = cajas.getFirst();
        for (int i = 0; i < cajas.size(); i++) {
            if (cajaNode == null) {
                break;
            }
            Caja caja = cajaNode.getData();
            System.out.println("Caja " + (i + 1) + ": " +
                    (caja.estaLibre() ? "Libre" : "Ocupada - Items restantes: " + caja.getClienteActual().getPacks()));
            cajaNode = cajaNode.getNext();
        }
    }
}
