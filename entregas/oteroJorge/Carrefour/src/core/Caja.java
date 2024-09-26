package core;

class Caja {
    private int tiempoAtencion;
    private int packsPorAtender; // Agregar este campo

    public Caja() {
        tiempoAtencion = 0;
        packsPorAtender = 0; // Inicialmente no atiende ningún pack
    }

    public boolean estaLibre() {
        return tiempoAtencion == 0 && packsPorAtender == 0;
    }

    public void atenderCliente(Cliente cliente) {
        int tiempoAtencion = cliente.calcularTiempoAtencion();
        this.tiempoAtencion = tiempoAtencion;
        this.packsPorAtender = cliente.getNumPacks(); // Actualiza el número de packs por atender
    }

    public void avanzarTiempo() {
        if (tiempoAtencion > 0) {
            tiempoAtencion--;
        }
        if (packsPorAtender > 0) {
            packsPorAtender--;
        }
    }

    public int getPacksPorAtender() {
        return packsPorAtender;
    }
}
