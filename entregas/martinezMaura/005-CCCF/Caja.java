public class Caja {
    private int tiempoAtencion;
    private int packsPorAtender;
    private boolean estaLibre;

    public Caja() {
        this.tiempoAtencion = 0;
        this.packsPorAtender = 0;
        this.estaLibre = true;
    }

    public void atenderCliente() {
        if (!estaLibre) {
            System.out.println("La caja no está libre. No se puede atender al cliente.");
        } else {
            estaLibre = false;
            tiempoAtencion = 0;
        }
    }

    public void avanzarTiempo() {
        if (!estaLibre) {
            if (tiempoAtencion > 0) {
                tiempoAtencion--;
            }
            if (packsPorAtender > 0) {
                packsPorAtender--;
            }

            if (tiempoAtencion == 0 && packsPorAtender == 0) {
                estaLibre = true;
            }
        }
    }

    public int obtenerPacksPorAtender() {
        return packsPorAtender;
    }

    public void agregarPacks(int numPacks) {
        packsPorAtender += numPacks;
    }

    public boolean isEmpty() {
        return packsPorAtender == 0;
    }

    public void chargeItem() {
        if (!isEmpty() && tiempoAtencion > 0) {
            tiempoAtencion--;
        }
    }

    public void printRemainingItems() {
        System.out.println("Packs por atender: " + packsPorAtender);
    }
}
