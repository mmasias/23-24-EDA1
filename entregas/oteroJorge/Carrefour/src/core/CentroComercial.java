package core;
import generica.GenericList;
import generica.GenericNode;

public class CentroComercial {
    private ColaClientes<Cliente> clientes;
    private GenericList<Caja> cajas;
    private GenerarCliente generadorClientes;

    // Agrega variables para realizar un seguimiento de estadísticas
    private int minutosColaCero = 0;
    private int personasEnCola = 0;
    private int personasAtendidas = 0;
    private int articulosVendidos = 0;

    public CentroComercial(int numCajas) {
        clientes = new ColaClientes<>();
        cajas = new GenericList<>();
        generadorClientes = new GenerarCliente();
        for (int i = 0; i < numCajas; i++) {
            cajas.insertEnd(new Caja());
        }
    }

    public void iniciarSimulacion(int duracionSimulacion) {
        for (int i = 1; i <= duracionSimulacion; i++) {
            avanzarTiempo();
            if(Math.random() <= 0.4){
                Cliente nuevoCliente = generadorClientes.generarCliente();
                agregarClienteACola(nuevoCliente);
                atenderClientes();
                System.out.println("MINUTO " + i + " - " + "LLega un cliente nuevo" + " - " + "En Cola: " + clientes.size());
                imprimirEstadoCajas();
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            } else {
                System.out.println("MINUTO " + i + " - " + "No llega nadie" + " - " + "En Cola: " + clientes.size());
                imprimirEstadoCajas();
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            }

            // Realiza un seguimiento de las estadísticas
            if (clientes.estaVacia()) {
                minutosColaCero++;
            } else {
                personasEnCola = clientes.size();
            }
        }

        // Genera el resumen
        generarResumen();
    }

    public void avanzarTiempo() {
        GenericNode<Caja> cajaNode = cajas.getFirst();
        while (cajaNode != null) {
            Caja caja = cajaNode.getValue();
            caja.avanzarTiempo();
            cajaNode = cajaNode.getNext();
        }
    }

    public void agregarClienteACola(Cliente cliente) {
        clientes.agregarCliente(cliente);
    }

    public void atenderClientes() {
        GenericNode<Caja> cajaNode = cajas.getFirst();
        while (cajaNode != null) {
            Caja caja = cajaNode.getValue();
            if (caja.estaLibre() && !clientes.estaVacia()) {
                Cliente cliente = clientes.obtenerSiguienteCliente();
                caja.atenderCliente(cliente);
                personasAtendidas++;
                articulosVendidos += cliente.getNumPacks();
            }
            cajaNode = cajaNode.getNext();
        }
    }
    public void generarResumen() {
        System.out.println("RESUMEN");
        System.out.println("============================================================");
        System.out.println("Minutos con cola en cero      : " + minutosColaCero);
        System.out.println("Personas en la cola al cierre : " + personasEnCola);
        System.out.println("Personas atendidas en el dia  : " + personasAtendidas);
        System.out.println("Articulos vendidos en el dia  : " + articulosVendidos);
    }

    public void imprimirEstadoCajas() {
        System.out.println("Estado de las Cajas:");
        GenericNode<Caja> cajaNode = cajas.getFirst();
        int index = 1; // Inicializa el contador en 1
        while (cajaNode != null) {
            Caja caja = cajaNode.getValue();
            System.out.println("Caja" + index + ": " + caja.getPacksPorAtender());
            cajaNode = cajaNode.getNext();
            index++; // Incrementa el contador
        }
    }
}