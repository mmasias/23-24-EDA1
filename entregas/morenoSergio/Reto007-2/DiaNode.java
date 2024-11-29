public class DiaNode {
    int numeroDia;
    ComidaNode desayuno;
    ComidaNode mediodia;
    ComidaNode merienda;
    ComidaNode cena;
    DiaNode siguiente;

    public DiaNode(int numeroDia) {
        this.numeroDia = numeroDia;
        this.desayuno = null;
        this.mediodia = null;
        this.merienda = null;
        this.cena = null;
        this.siguiente = null;
    }
}
