import java.util.LinkedList;

public class Supermarket {
    private LinkedList<String> cola;
    private int[] cajas;
    private int items;
    private int atencion;
    private int minutos;
    private int minutosSinCola;

    public Supermarket() {
        cola = new LinkedList<>();
        cajas = new int[4];
        items = 0;
        atencion = 0;
        minutos = 0;
        minutosSinCola = 0;
    }

    public void llegadaCliente() {
        double probabilidadLlegada = Math.random();
        if (probabilidadLlegada <= 0.4) {
            System.out.println(" - Llegó una persona");
            cola.add("Persona");
        } else {
            System.out.println(" - No llegó nadie");
        }
    }

    public void simularJornada() {
        int Jornada = 12 * 60;
        while (minutos <= Jornada) {
            System.out.println(" >> HORA: " + formatHora(minutos));
            llegadaCliente();
            System.out.println("> Personas en cola: " + cola.size());
            for (int i = 0; i < 4; i++) {
                if (cajas[i] <= 0 && cola.size() > 0) {
                    cola.remove();
                    cajas[i] = (int) (Math.random() * 11) + 5;
                    atencion++;
                    System.out.println("Pasa una persona a la caja " + (i + 1) + " llevando " + cajas[i] + " items");
                }
                if (cajas[i] > 0) {
                    cajas[i]--;
                    items++;
                    System.out.println("> La caja " + (i + 1) + " atiende un item, le quedan " + cajas[i] + " items");
                }
            }
            if (cola.isEmpty()) {
                minutosSinCola++;
            }
            minutos++;
        }
    }

    public void imprimirResultados() {
        System.out.println("----------------------------------------------------");
        System.out.println("Minutos totales sin cola: " + minutosSinCola);
        System.out.println("Al final del día se vendieron un total de " + items + " items");
        System.out.println("Personas atendidas durante la jornada: " + atencion);
    }

    private String formatHora(int minutos) {
        int hora = 9 + minutos / 60;
        int minuto = minutos % 60;
        return String.format("%02d:%02d", hora, minuto);
    }

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        supermarket.simularJornada();
        supermarket.imprimirResultados();
    }
}
