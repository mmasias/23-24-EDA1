package entregas.sergioMayen.ExamenFinal.DeArrayList_TO_Arboles;

public class ComidaNode {
    String nombre;
    Alimento alimento;
    ComidaNode siguiente;

    public ComidaNode(String nombre, Alimento alimento) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.siguiente = null;
    }
}
