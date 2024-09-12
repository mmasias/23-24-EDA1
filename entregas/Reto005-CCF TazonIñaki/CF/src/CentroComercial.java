import java.util.*;

public class CentroComercial {
    private static final int HORAS_DE_APERTURA = 12;
    private static final int MINUTOS_POR_HORA = 60;
    private static final int NUMERO_DE_CAJAS = 4;
    private static final double PROBABILIDAD_DE_LLEGADA = 0.6;
    private static final int MIN_PACKS = 5;
    private static final int MAX_PACKS = 15;
    private static final int LIMITE_DE_COLA = 15;
    private static final int MAX_CAJAS = 6;

    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        List<Integer> cajas = new ArrayList<>(Collections.nCopies(MAX_CAJAS, 0));
        int minutosSinCola = 0;
        int personasAtendidas = 0;
        int itemsVendidos = 0;
        int cajasAbiertas = NUMERO_DE_CAJAS;

        for (int minuto = 0; minuto < HORAS_DE_APERTURA * MINUTOS_POR_HORA; minuto++) {
            System.out.println("Minuto " + minuto + ":");

            if (Math.random() < PROBABILIDAD_DE_LLEGADA) {
                int packs = MIN_PACKS + (int) (Math.random() * (MAX_PACKS - MIN_PACKS + 1));
                cola.add(packs);
                System.out.println("Llega un cliente con " + packs + " packs de items.");
            }

            if (cola.isEmpty()) {
                minutosSinCola++;
            }

            if (cola.size() > LIMITE_DE_COLA && cajasAbiertas < MAX_CAJAS) {
                cajasAbiertas++;
                System.out.println("Se abre una nueva caja. Ahora hay " + cajasAbiertas + " cajas abiertas.");
            }

            for (int i = 0; i < cajasAbiertas; i++) {
                if (cajas.get(i) > 0) {
                    cajas.set(i, cajas.get(i) - 1);
                    itemsVendidos++;
                    System.out.println("Caja " + (i+1) + " atiende a un cliente. Quedan " + cajas.get(i) + " packs por atender.");
                } else if (!cola.isEmpty()) {
                    cajas.set(i, cola.poll());
                    personasAtendidas++;
                    System.out.println("Caja " + (i+1) + " empieza a atender a un nuevo cliente con " + cajas.get(i) + " packs.");
                }
            }

            System.out.println("Hay " + cola.size() + " clientes en cola.\n");
        }

        System.out.println("Resumen del día:");
        System.out.println("Número de minutos en que no hubo nadie en cola: " + minutosSinCola);
        System.out.println("Número de personas que estaban en cola al finalizar el día: " + cola.size());
        System.out.println("Número de personas atendidas durante el día: " + personasAtendidas);
        System.out.println("Número de items vendidos en el día: " + itemsVendidos);
    }
}
