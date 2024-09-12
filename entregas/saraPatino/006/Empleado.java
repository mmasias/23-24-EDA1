public class Empleado implements Comparable<Empleado>{

    private int sueldo;
    private String nombre;

    public Empleado(int sueldo, String nombre) {
        this.sueldo = sueldo;
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Empleado o) {
       if (this.sueldo<o.getSueldo()){
           return -1;
       } else if (this.sueldo>o.getSueldo()) {
           return 1;

       }else {
           return 0;
       }
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "sueldo=" + sueldo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}