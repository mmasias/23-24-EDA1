package Reto007;

public class Cliente {
    private String nombre;
    private Encuesta encuesta;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.encuesta = new Encuesta();
    }

    public String getNombre() {
        return nombre;
    }
}