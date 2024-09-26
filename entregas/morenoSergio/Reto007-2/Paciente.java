import java.util.Scanner;

public class Paciente {
    String nombre;
    String fechaAlta;
    EncuestaNutricional encuesta;

    public Paciente(String nombre, String fechaAlta, int numDiasEncuesta) {
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.encuesta = new EncuestaNutricional(numDiasEncuesta);
    }

    public void realizarEncuesta() {
        Scanner scanner = new Scanner(System.in);

        for (int dia = 1; dia <= encuesta.raiz.numeroDia; dia++) {
            System.out.println("Día " + dia);

            agregarAlimentosEnComida(dia, "Desayuno", scanner);
            agregarAlimentosEnComida(dia, "Medio día", scanner);
            agregarAlimentosEnComida(dia, "Merienda", scanner);
            agregarAlimentosEnComida(dia, "Cena", scanner);
        }
    }

    private void agregarAlimentosEnComida(int dia, String comida, Scanner scanner) {
        boolean agregarMasAlimentos = true;

        while (agregarMasAlimentos == true) {
            System.out.println(comida + ": ");
            System.out.println("Ingrese el nombre del alimento:");
            String nombreAlimento = scanner.nextLine();
            encuesta.agregarAlimento(dia, comida, new Alimento(nombreAlimento));

            System.out.println("¿Quieres añadir más? (s/n):");
            String seguir = scanner.nextLine().toLowerCase();
            if (!seguir.equals("s")) {
                agregarMasAlimentos = false;
            }
        }
    
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", encuesta=\n" + encuesta +
                '}';
    }
}
