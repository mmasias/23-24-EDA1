public class Alimento implements Comparable<Alimento>{
    private String nombre;
    private int gramos;
    private List<Alimento> alimentos;

    public Alimento(String nombre, int gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
        this.alimentos = new List<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getGramos() {
        return this.gramos;
    }

    public List<Alimento> getAlimentos() {
        return this.alimentos;
    }

    public void addAlimento(Alimento alimento) {
        this.alimentos.insertarOrdenado(alimento);
    }

    @Override
    public String toString() {
        return "[nombre=" + nombre + ", gramos=" + gramos + "]";
    }

    @Override
    public int compareTo(Alimento o) {
        if (this.getNombre().compareTo(o.getNombre())>0) {
            return 1;
        } else if (this.getNombre().compareTo(o.getNombre())<0) {
            return -1;
        } else {
            return 0;
        }
    }
}