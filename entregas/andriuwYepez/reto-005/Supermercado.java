import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Supermercado {
    private Queue<Persona> cola;
    private Caja[] cajas;
    private int colaEnCero;
    private int personasAtendidas;
    private int itemsVendidos;

    public Supermercado() {
        this.cola = new LinkedList<>();
        this.cajas = new Caja[4];
        for (int i = 0; i < 4; i++) {
            this.cajas[i] = new Caja();
        }
        this.colaEnCero = 0;
        this.personasAtendidas = 0;
        this.itemsVendidos = 0;
    }

    public void simularDia(int tiempoTotal) {
         for (int minuto = 1; minuto <= tiempoTotal; minuto++) {
            System.out.print("Minuto " + minuto);

            double probabilidadLlegada = Math.random();
            if (probabilidadLlegada <= 0.4) {
                System.out.println(" - Llego una persona");
                Persona persona = new Persona();
                cola.add(persona);
            } else {
                System.out.println("No llego nadie");
            }

            System.out.println("> Personas en cola: " + cola.size());

            if (cola.isEmpty()) {
                colaEnCero++;
            }

            for (Caja caja : cajas) {
                if (caja.estaDisponible() && !cola.isEmpty()) {
                    Persona personaAtendida = cola.poll();
                    caja.asignarPersona(personaAtendida);
                    personasAtendidas++;
                    itemsVendidos += personaAtendida.getItems();
                }
                caja.atenderItem();
            }

            mostrarEstadoCajas();
            System.out.println("----------------------------------------");
        }

        mostrarResumen();
    }

    private void mostrarEstadoCajas() {
        for (int i = 0; i < cajas.length; i++) {
            System.out.print("  Caja " + (i + 1) + ":[" + (cajas[i].estaDisponible() ? "0" : "X") + "]");
        }
        System.out.println();
    }

    private void mostrarResumen() {
        System.out.println("Resumen:");
        System.out.println("========================================");
        System.out.println("Minutos con cola en cero      : " + colaEnCero);
        System.out.println("Personas en la cola al cierre : " + cola.size());
        System.out.println("Personas atendidas en el dia  : " + personasAtendidas);
        System.out.println("Articulos vendidos en el dia  : " + itemsVendidos);
        System.out.println("Fin de la simulacion");
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese la duracion de la simulacion en minutos: ");
        int tiempoTotal = entrada.nextInt();

        Supermercado supermercado = new Supermercado();
        supermercado.simularDia(tiempoTotal);
    }
}
