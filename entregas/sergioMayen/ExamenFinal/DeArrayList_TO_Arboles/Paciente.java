package entregas.sergioMayen.ExamenFinal.DeArrayList_TO_Arboles;

import java.util.Scanner;

public class Paciente {
    String nombre;
    String fechaAlta;
    EncuestaTree encuesta;

    public Paciente(String nombre, String fechaAlta, int numDiasEncuesta) {
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.encuesta = new EncuestaTree(numDiasEncuesta);
    }

    public void realizarEncuesta() {
        Scanner scanner = new Scanner(System.in);

        for (int dia = 1; dia <= encuesta.raiz.numeroDia; dia++) {
            System.out.println("Día " + dia);

            agregarAlimentosEnComida(dia, "Desayuno", scanner);
            agregarAlimentosEnComida(dia, "Media mañana", scanner);
            agregarAlimentosEnComida(dia, "Almuerzo", scanner);
            agregarAlimentosEnComida(dia, "Merienda", scanner);
            agregarAlimentosEnComida(dia, "Cena", scanner);
        }
    }

    private void agregarAlimentosEnComida(int dia, String comida, Scanner scanner) {
        boolean agregarMasAlimentos = true;

        while (agregarMasAlimentos) {
            System.out.println(comida + ": ");
            System.out.println("Ingrese el nombre del alimento:");
            String nombreAlimento = scanner.nextLine();
            encuesta.agregarAlimento(dia, comida, new Alimento(nombreAlimento));

            System.out.println("¿Desea agregar más alimentos? (si/no):");
            String respuesta = scanner.nextLine().toLowerCase();

            if (!respuesta.equals("si")) {
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
