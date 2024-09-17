package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class SimulacionCajas {
    public static void main(String[] args) {
        int tiempoTotal = 12 * 60;
        int totalPersonas = 0;
        int totalItemsVendidos = 0;
        int minutosColaVacia = 0;

        Queue<Persona> cola = new LinkedList<>();
        List<Caja> cajas = new ArrayList<>();
        cajas.add(new Caja());
        cajas.add(new Caja());
        cajas.add(new Caja());
        cajas.add(new Caja());

        for (int minuto = 1; minuto <= tiempoTotal; minuto++) {
            System.out.println("Minuto " + minuto);

            if (Math.random() <= 0.4) {
                System.out.println(" - Llegó una persona");
                Persona persona = new Persona();
                cola.offer(persona);
                totalPersonas++;
            }

            for (Caja caja : cajas) {
                if (caja.estaDisponible() && !cola.isEmpty()) {
                    Persona persona = cola.poll();
                    caja.agregarCliente(persona);
                    totalPersonas++;
                    System.out.println("  > Persona pasa a una caja llevando [" + persona.getItems() + "] items");
                }

                caja.atenderCliente();
                if (!caja.estaDisponible()) {
                    totalItemsVendidos++;
                }
            }

            if (cajas.stream().allMatch(Caja::estaDisponible)) {
                minutosColaVacia++;
            }
        }

        System.out.println("En total se atendieron: " + totalPersonas + " personas en total");
        System.out.println("En total se vendieron: " + totalItemsVendidos + " items");
        System.out.println("Quedaron " + cola.size() + " personas en la cola");
        System.out.println("Pasaron " + minutosColaVacia + " minutos donde alguna cola estuvo vacía");
        System.out.println("Fin de la simulación");
    }
}
