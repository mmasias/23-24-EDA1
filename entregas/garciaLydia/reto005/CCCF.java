package entregas.garciaLydia.reto005;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CCCF {

    public static void main(String[] args) {
        List<Integer> cola = new ArrayList<>();
        List<Integer> cajas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            cajas.add(0);
        }

        int minutosSinCola = 0;
        int personasAtendidas = 0;
        int itemsVendidos = 0;

        for (int minuto = 1; minuto <= 720; minuto++) {
            if (random.nextDouble() <= 0.4) {
                int itemsCompra = random.nextInt(11) + 5;
                cola.add(itemsCompra);
                System.out.println("MINUTO " + minuto + " - Llega 1 persona - En Cola: " + cola.size());
            } else {
                System.out.println("MINUTO " + minuto + " - No llega nadie  - En Cola: " + cola.size());
            }

            for (int i = 0; i < cajas.size(); i++) {
                if (cajas.get(i) == 0 && !cola.isEmpty()) {
                    int itemsAtender = Math.min(15, cola.get(0));
                    cajas.set(i, itemsAtender);
                    personasAtendidas++;
                    itemsVendidos += itemsAtender;

                    cola.remove(0);
                    break;
                }
                if (cajas.get(i) > 0) {
                    cajas.set(i, cajas.get(i) - 1);
                }
            }

            System.out.print("Caja1:[" + cajas.get(0) + "] | Caja2:[" + cajas.get(1) + "] | Caja3:[" + cajas.get(2) + "] | Caja4:[" + cajas.get(3) + "]\n");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            if (cola.isEmpty()) {
                minutosSinCola++;
            }
        }

        System.out.println("RESUMEN");
        System.out.println("============================================================");
        System.out.println("Minutos con cola en cero      : " + minutosSinCola);
        System.out.println("Personas en la cola al cierre : " + cola.size());
        System.out.println("Personas atendidas en el dia   : " + personasAtendidas);
        System.out.println("Articulos vendidos en el dia   : " + itemsVendidos);
        System.out.println("============================================================");
    }
}