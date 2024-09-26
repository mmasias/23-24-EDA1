package src;

public class Alimento implements Comparable<Alimento> {
    private String nombre;
    private int gramos;

    public Alimento(String nombre, int gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGramos() {
        return gramos;
    }

    @Override
    public int compareTo(Alimento o) {
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return "[nombre=" + nombre + ", gramos=" + gramos + "]";
    }
}
