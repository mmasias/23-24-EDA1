public class Alimento {
    private String descripcion;

    private Alimento siguiente;

    public Alimento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //en caso de necesitar una correcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Alimento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Alimento siguiente) {
        this.siguiente = siguiente;
    }
}
