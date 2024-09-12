package entregas.sergioMayen.ExamenFinal.DeArrayList_TO_Arboles;

public class DiaNode {
    int numeroDia;
    ComidaNode desayuno;
    ComidaNode mediaManana;
    ComidaNode almuerzo;
    ComidaNode merienda;
    ComidaNode cena;
    DiaNode siguiente;

    public DiaNode(int numeroDia) {
        this.numeroDia = numeroDia;
        this.desayuno = null;
        this.mediaManana = null;
        this.almuerzo = null;
        this.merienda = null;
        this.cena = null;
        this.siguiente = null;
    }
}
