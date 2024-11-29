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
