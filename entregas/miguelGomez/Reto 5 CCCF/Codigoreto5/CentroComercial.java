package Codigoreto5;

import java.util.ArrayList;
import java.util.List;

public class CentroComercial {
    private int jornada;
    private int cola;
    private List<Caja> cajas;
    private int items;
    private int atencion;
    private int minutosSinCola;

    public CentroComercial(int jornada, int numCajas) {
        this.jornada = jornada;
        this.cola = 0;
        this.cajas = new ArrayList<>();
        for (int i = 0; i < numCajas; i++) {
            cajas.add(new Caja());
        }
        this.items = 0;
        this.atencion = 0;
        this.minutosSinCola = 0;
    }

    public void simularDia() {
        for (int minuto = 1; minuto <= jornada; minuto++) {
            System.out.println("MINUTO " + minuto);

            if (Math.random() <= 0.4) {
                System.out.println("Llega 1 persona - En Cola: " + cola);
                cola++;
            } else {
                System.out.println("No llega nadie - En Cola: " + cola);
            }

            for (int caja = 0; caja < cajas.size(); caja++) {
                if (cajas.get(caja).estaDisponible()) {
                    if (cola > 0) {
                        cola--;
                        cajas.get(caja).agregarCliente();
                        atencion++;
                        System.out.println("Caja" + (caja + 1) + ":[" + cajas.get(caja).getItems() + "]");
                    } else {
                        System.out.println("Caja" + (caja + 1) + ":[0]");
                    }
                } else {
                    cajas.get(caja).atenderCliente();
                    items++;
                    System.out.println("Caja" + (caja + 1) + ":[" + cajas.get(caja).getItems() + "]");
                }
            }

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        }

        for (Caja caja : cajas) {
            if (caja.estaDisponible()) {
                minutosSinCola++;
            }
        }

        System.out.println("Minutos totales sin cola: " + minutosSinCola);
        System.out.println("Al final del día se vendieron un total de " + items + " items");
        System.out.println("Personas atendidas durante la jornada: " + atencion);
        System.out.println("Personas que se quedaron en la cola al final del día: " + cola);
    }
}

