public class Person implements Comparable<Person> {
    private int edad;
    private String nombre;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Person(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona [edad=" + edad + ", nombre=" + nombre + "]";
    }

    @Override
    public int compareTo(Person o) {
        if (this.getEdad() < o.getEdad()) {
            return -1;
        } else if (this.getEdad() > o.getEdad()) {
            return 1;
        } else {
            return 0;
        }
    }
}

