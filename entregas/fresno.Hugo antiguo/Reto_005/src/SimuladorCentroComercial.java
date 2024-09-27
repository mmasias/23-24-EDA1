import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SimuladorCentroComercial {
    private static final int MAX_CAJAS = 4;
    private static final int MIN_PACKS = 5;
    private static final int MAX_PACKS = 15;
    private static final int MINUTOS_APERTURA = 12 * 60; // 12 horas * 60 minutos
    private static final double PROBABILIDAD_LLEGADA = 0.6;
    private static final int UMBRAL_PERSONAS_EXTRA_CAJA = 15;

    private Caja[] cajas = new Caja[MAX_CAJAS];
    private Queue<Cliente> colaClientes = new LinkedList<>();
    private Random random = new Random();
    private int minutosSinCola = 0;
    private int totalClientesAtendidos = 0;
    private int totalItemsVendidos = 0;

    public SimuladorCentroComercial() {
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja();
        }
    }

    public void iniciarSimulacion() {
        for (int minuto = 1; minuto <= MINUTOS_APERTURA; minuto++) {
            if (random.nextDouble() < PROBABILIDAD_LLEGADA) {
                int itemsCliente = MIN_PACKS + random.nextInt(MAX_PACKS - MIN_PACKS + 1);
                colaClientes.add(new Cliente(itemsCliente));
            }

            for (Caja caja : cajas) {
                if (!caja.estaOcupada()) {
                    if (!colaClientes.isEmpty()) {
                        Cliente clienteActual = colaClientes.poll();
                        caja.atenderCliente(clienteActual);
                        totalClientesAtendidos++;
                        totalItemsVendidos += clienteActual.getItems();
                    }
                }
                caja.procesar();
            }

            // Registro de minutos sin cola
            if (colaClientes.isEmpty()) {
                minutosSinCola++;
            }

            imprimirEstado(minuto);
        }

        imprimirResumen();
    }

    private void imprimirEstado(int minuto) {
        System.out.printf("MINUTO %d - Llega %s persona - En Cola: %d\n",
                minuto,
                (colaClientes.size() > 0 ? "1" : "nadie"),
                colaClientes.size());

        for (int i = 0; i < cajas.length; i++) {
            System.out.printf("Caja%d:[%d] | ", i + 1, cajas[i].getItemsPendientes());
        }
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    private void imprimirResumen() {
        System.out.println("RESUMEN");
        System.out.println("============================================================");
        System.out.printf("Minutos con cola en cero      : %d\n", minutosSinCola);
        System.out.printf("Personas en la cola al cierre : %d\n", colaClientes.size());
        System.out.printf("Personas atendidas en el dia  : %d\n", totalClientesAtendidos);
        System.out.printf("Articulos vendidos en el dia  : %d\n", totalItemsVendidos);
        System.out.println("============================================================");
    }


}
