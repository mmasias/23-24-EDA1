package Arboles.model;

public class Ingesta {
    public Alimento alimento;
    public Ingesta siguiente;

    public Ingesta(Alimento alimento) {
        this.alimento = alimento;
        this.siguiente = null;
    }
}