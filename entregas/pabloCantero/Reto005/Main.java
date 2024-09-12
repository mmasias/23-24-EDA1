package Reto005;

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
    }

    System.out.println("Ha habido " + minutosEnCero + " minutos donde la cola estaba en 0");
    System.out.println("Al final del día había " + cola.size() + " personas en la cola");
    System.out.println("El número de personas atendidas durante el día es " + personasDuranteElDia);
    System.out.println("Los artículos vendidos durante el día son " + articulosTotales);
}