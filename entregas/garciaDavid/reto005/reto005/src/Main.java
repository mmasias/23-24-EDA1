import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int tiempoTotal = 12 * 60;
        double probabilidadLlegada;
        int unaCola = 0;
        int[] cajas = new int[4];
        Random random = new Random();

        for (int minuto = 1; minuto <= tiempoTotal; minuto++) {

            System.out.print("Minuto " + minuto);

            probabilidadLlegada = Math.random();
            if (probabilidadLlegada <= 0.4) {
                System.out.print(" : Llega una persona");
                unaCola++;
            } else {
                System.out.print(" : No hay nadie");
            }
            System.out.println(" : En cola: " + unaCola);

            for (int i = 0; i < cajas.length; i++) {
                if (cajas[i] <= 0 && unaCola > 0) {
                    unaCola--;
                    cajas[i] = random.nextInt(11) + 5;
                }

                if (cajas[i] > 0) {
                    cajas[i] = cajas[i] - 1;
                }

                System.out.print(" Caja" + (i + 1) + " : [" + cajas[i] + "] |");
            }

            System.out.println();
            System.out.println("----------------------------------------------------");
        }
        System.out.println("");
        System.out.println("Fin de la simulación");
    }
}