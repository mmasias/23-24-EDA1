package Reto005;  
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Supermercado {
    public static void main(String[] args) {
        int horarioLaboral = 720;
        int minutosEnCero = 0;
        int personasDuranteElDia = 0;
        int articulosTotales = 0;

        List<Cliente> cola = new ArrayList<>();
        List<Caja> cajas = new ArrayList<>();
        cajas.add(new Caja());
        cajas.add(new Caja());
        cajas.add(new Caja());
        cajas.add(new Caja());

        for (int minuto = 1; minuto <= horarioLaboral; minuto++) {
            double probabilidadClienteNuevo = Math.random();
            if (probabilidadClienteNuevo <= 0.4) {
                Cliente nuevoCliente = new Cliente();
                cola.add(nuevoCliente);
                personasDuranteElDia++;
            }

            for (Caja caja : cajas) {
                if (!caja.estaOcupada() && !cola.isEmpty()) {
                    Cliente clienteAtendido = cola.remove(0);
                    caja.atenderCliente(clienteAtendido);
                    articulosTotales += clienteAtendido.getItems();
                }
                caja.reducirTiempo();
            }

            if (cola.isEmpty()) {
                minutosEnCero++;
            }

            if (minuto == 720) {
                cola.clear();
            }

            System.out.println("Minuto " + minuto + " - En cola: " + cola.size());
            for (int i = 0; i < cajas.size(); i++) {
                System.out.println("Caja" + (i + 1) + " [" + (cajas.get(i).estaOcupada() ? "Ocupada" : "Libre") + "]");
            }
            System.out.println("----------------------------------------------------------------");
        }

        System.out.println("Ha habido " + minutosEnCero + " minutos donde la cola estaba en 0");
        System.out.println("Al final del día había " + cola.size() + " personas en la cola");
        System.out.println("El número de personas atendidas durante el día es " + personasDuranteElDia);
        System.out.println("Los artículos vendidos durante el día son " + articulosTotales);

}
}
