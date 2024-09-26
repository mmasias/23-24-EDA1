package core;

class Cliente {
    private int numPacks;

    public Cliente(int numPacks) {
        this.numPacks = numPacks;
    }

    public int calcularTiempoAtencion() {
        return numPacks; // 1 minuto por pack
    }

    public int getNumPacks() {
        return numPacks;
    }
}
