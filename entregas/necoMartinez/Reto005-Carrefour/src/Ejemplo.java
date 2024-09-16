public class Ejemplo {

    private int Jornada;
    private double probabilidadLlegada;
    private int cola;
    private int caja1;
    private int caja2;
    private int caja3;
    private int caja4;
    private int items;
    private int atencion;
    private int MinutosSinCola;

    public Ejemplo() {
        this.Jornada = 12 * 60;
        this.cola = 0;
        this.caja1 = 0;
        this.caja2 = 0;
        this.caja3 = 0;
        this.caja4 = 0;
        this.items = 0;
        this.atencion = 0;
        this.MinutosSinCola = 0;
    }

    public void simularJornada() {
        for (int minuto = 1; minuto <= Jornada; minuto++) {
            int horasTranscurridas = (minuto-1) / 60;
            int minutosTranscurridos = (minuto-1) % 60;

            System.out.println(String.format(" >> HORA %d:%02d", horasTranscurridas, minutosTranscurridos));

            probabilidadLlegada = Math.random();

            if (probabilidadLlegada <= 0.4) {
                System.out.println(" - Llegó una persona");
                cola++;
            } else {
                System.out.println(" - No llegó nadie");
            }

            System.out.println("> Personas en cola: " + cola);

            atenderClientes();

            if (cola <= 0) {
                MinutosSinCola++;
            }

            procesarItemsCajas();
        }

        mostrarResultados();
    }


    private void atenderClientes() {
        if (caja1 <= 0 && cola > 0) {
            atenderEnCaja(1);
        } else if (caja2 <= 0 && cola > 0) {
            atenderEnCaja(2);
        } else if (caja3 <= 0 && cola > 0) {
            atenderEnCaja(3);
        } else if (caja4 <= 0 && cola > 0) {
            atenderEnCaja(4);
        }
    }

    private void atenderEnCaja(int cajaNumero) {
        cola--;
        int itemsCaja = (int) (Math.random() * 11) + 5;
        atencion++;
        System.out.println("Pasa una persona a la caja " + cajaNumero + " llevando " + itemsCaja + (" items"));

        switch (cajaNumero) {
            case 1:
                caja1 = itemsCaja;
                break;
            case 2:
                caja2 = itemsCaja;
                break;
            case 3:
                caja3 = itemsCaja;
                break;
            case 4:
                caja4 = itemsCaja;
                break;
        }
    }

    private void procesarItemsCajas() {
        if (caja1 > 0) {
            caja1--;
            items++;
            System.out.println("> La caja 1 atiende un item, le quedan " + caja1 + " items");
        }

        if (caja2 > 0) {
            caja2--;
            items++;
            System.out.println("> La caja 2 atiende un item, le quedan " + caja2 + " items");
        }

        if (caja3 > 0) {
            caja3--;
            items++;
            System.out.println("> La caja 3 atiende un item, le quedan " + caja3 + " items");
        }

        if (caja4 > 0) {
            caja4--;
            items++;
            System.out.println("> La caja 4 atiende un item, le quedan " + caja4 + " items");
        }
    }

    private void mostrarResultados() {
        int horasSinCola = MinutosSinCola / 60;
        int minutosSinCola = MinutosSinCola % 60;

        System.out.println(String.format("Tiempo total sin cola: %d horas y %d minutos", horasSinCola, minutosSinCola));
        System.out.println("Al final del día se vendieron un total de " + items + " items");
        System.out.println("Personas atendidas durante la jornada: " + atencion);
    }


    public static void main(String[] args) {
        Ejemplo ejemplo = new Ejemplo();
        ejemplo.simularJornada();
    }
}
