package Reto005;

import java.util.ArrayList;

public class CCF {
    public static void main(String[] args) {
        int tiempoTotal = 1 * 60;
        double probabilidadLlegada;
        int personasCola = 0;
        int personasAtendidas = 0;
        int itemsRestantes = 0;
        int itemsVendidos = 0;

        ArrayList<Integer> cajas = new ArrayList<Integer>();
        cajas.add(0);
        cajas.add(0);
        cajas.add(0);
        cajas.add(0);

        for (int minuto = 1; minuto <= tiempoTotal; minuto++) {
            System.out.print("Minuto " + minuto);
            probabilidadLlegada = Math.random();
            if (probabilidadLlegada <= 0.4) {
                System.out.println(" - Llego una persona");
                personasCola++;
                personasAtendidas++;
            } else {
                System.out.println("");
            }
            System.out.println("> Persona en cola: " + personasCola);

            for (int i = 0; i < cajas.size(); i++) {
                int itemsEnCaja = cajas.get(i);
                if (itemsEnCaja > 0) {
                    cajas.set(i, itemsEnCaja - 1);
                    System.out.println(" > La caja " + (i + 1) + " atiende un item, le quedan " + (itemsEnCaja - 1));
                }
            }

            for (int i = 0; i < cajas.size(); i++) {
                int itemsEnCaja = cajas.get(i);
                if (itemsEnCaja <= 0 && personasCola > 0) {
                    personasCola--;
                    int items = (int) (Math.random() * 11) + 5;
                    cajas.set(i, items);
                    itemsVendidos += items;
                    itemsRestantes = items;
                    System.out.println(" > Pasa una persona a la caja " + (i + 1) + " llevando [" + items + "] items");
                }
            }
        }

        int itemsTotales = itemsVendidos - itemsRestantes;
        int personasAtendidasTotales = personasAtendidas - personasCola;

        System.out.println(" ");
        System.out.println("-----------------");
        System.out.println("Resumen");
        System.out.println("Personas en cola al final de la jornada:" + personasCola);
        System.out.println("Personas atendidas al final de la jornada:" + personasAtendidasTotales);
        System.out.println("Items vendidos al final de la jornada:" + itemsTotales);
        System.out.println("-----------------");
        System.out.println(" ");

        System.out.println("Fin de la simulacion");
    }
}
