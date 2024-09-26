public class Alimento {
    String nombre;

    public Alimento(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
