public class Empleado implements Comparable<Empleado> {
    private int salario;
    private String nombre;

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(int salario, String nombre) {
        this.salario = salario;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado [salario=" + salario + ", nombre=" + nombre + "]";
    }

    @Override
    public int compareTo(Empleado o) {
        if (this.getSalario() < o.getSalario()) {
            return -1;
        } else if (this.getSalario() > o.getSalario()) {
            return 1;
        } else {
            return 0;
        }
    }
}
