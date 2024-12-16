public class Alimentos {
    private String nombreAlimento;
    private double cantidad;
    private String metodoPreparacion;
    private String marca;
    private String tamañoPorcion;

    public Alimentos(String nombreAlimento, double cantidad, String metodoPreparacion, String marca, String tamañoPorcion) {
        this.nombreAlimento = nombreAlimento;
        this.cantidad = cantidad;
        this.metodoPreparacion = metodoPreparacion;
        this.marca = marca;
        this.tamañoPorcion = tamañoPorcion;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getMetodoPreparacion() {
        return metodoPreparacion;
    }

    public String getMarca() {
        return marca;
    }

    public String getTamañoPorcion() {
        return tamañoPorcion;
    }
}