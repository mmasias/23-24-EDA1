package ProyectoFinal;

public class Paciente {
    private String nombre;
    private Tree<DiaAlimentacion> diasAlimentacion;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.diasAlimentacion = new Tree<>();
    }

    public void agregarDiaAlimentacion(DiaAlimentacion dia) {
        diasAlimentacion.add(dia);
    }

    public DiaAlimentacion buscarDiaAlimentacion(int numeroDia) {
        return diasAlimentacion.find(new DiaAlimentacion(numeroDia));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tree<DiaAlimentacion> getDiasAlimentacion() {
        return diasAlimentacion;
    }

}
