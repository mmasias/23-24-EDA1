public class Alimento {
    private final String descripcion;
    private Alimento siguiente;

    public Alimento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Alimento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Alimento siguiente) {
        this.siguiente = siguiente;
    }
}
