import java.time.LocalDate;
import java.util.Comparator;

public class Paciente {
    private String nombre;
    private double peso;
    private int altura;
    private int edad;
    private char sexo;
    private String dni;
    private LocalDate fechaAlta;
    private DatosArbol<Encuesta> encuestas;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.encuestas = new DatosArbol<>(Comparator.comparing(Encuesta::getFechaEncuesta));
    }

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

    public DatosArbol<Encuesta> getEncuestas() {
        return encuestas;
    }

    public void agregarEncuesta(Encuesta encuesta) {
        encuestas.insertar(encuesta);
    }

    public double calcularIMC() {
        double alturaEnMetros = altura / 100.0;
        return peso / (alturaEnMetros * alturaEnMetros);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente: ").append(nombre).append("\n");
        sb.append("Peso: ").append(peso).append(" kg\n");
        sb.append("Altura: ").append(altura).append(" cm\n");
        sb.append("Edad: ").append(edad).append("\n");
        sb.append("Sexo: ").append(sexo).append("\n");
        sb.append("DNI: ").append(dni).append("\n");
        sb.append("IMC: ").append(String.format("%.2f", calcularIMC())).append("\n");
        sb.append("Fecha de alta: ").append(fechaAlta).append("\n");
        encuestas.recorrerInOrden(e -> sb.append(e.toString()).append("\n"));
        return sb.toString();
    }
}
