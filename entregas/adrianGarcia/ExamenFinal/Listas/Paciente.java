import java.time.LocalDate;

public class Paciente {
    private String nombre;
    private double peso;
    private int altura;
    private int edad;
    private char sexo;
    private String dni;
    private LocalDate fechaAlta;
    private GenericList<Encuesta> encuestas;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.encuestas = new GenericList<>();
    }

    public double calcularIMC() {
        double alturaEnMetros = altura / 100.0;
        return peso / (alturaEnMetros * alturaEnMetros);
    }

    public void agregarEncuesta(Encuesta encuesta) {
        encuestas.insertEnd(encuesta);
    }

    public Encuesta buscarEncuesta(LocalDate fecha) {
        GenericNode<Encuesta> node = encuestas.getFirst();
        while (node != null) {
            if (node.getValue().getFechaEncuesta().equals(fecha)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente: ").append(nombre).append("\n")
          .append("Peso: ").append(peso).append(" kg\n")
          .append("Altura: ").append(altura).append(" cm\n")
          .append("Edad: ").append(edad).append("\n")
          .append("Sexo: ").append(sexo).append("\n")
          .append("DNI: ").append(dni).append("\n")
          .append("IMC: ").append(String.format("%.2f", calcularIMC())).append("\n")
          .append("Fecha de alta: ").append(fechaAlta).append("\n");

        GenericNode<Encuesta> node = encuestas.getFirst();
        while (node != null) {
            sb.append(node.getValue().toString()).append("\n");
            node = node.getNext();
        }
        return sb.toString();
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public GenericList<Encuesta> getEncuestas() {
        return encuestas;
    }
}

