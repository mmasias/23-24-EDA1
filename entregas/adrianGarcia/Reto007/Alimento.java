public class Alimento {
    private String nombre;
    private double cantidad;

    public Alimento(String nombre, double cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return nombre + " - " + cantidad + " gramos";
    }
}
