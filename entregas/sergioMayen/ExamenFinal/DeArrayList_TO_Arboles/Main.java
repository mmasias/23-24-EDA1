package entregas.sergioMayen.ExamenFinal.DeArrayList_TO_Arboles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del paciente:");
        String nombrePaciente = scanner.nextLine();

        System.out.println("Ingrese la fecha de alta del paciente:");
        String fechaAltaPaciente = scanner.nextLine();

        System.out.println("Ingrese la cantidad de días para la encuesta:");
        int numDiasEncuesta = Integer.parseInt(scanner.nextLine());

        Paciente paciente = new Paciente(nombrePaciente, fechaAltaPaciente, numDiasEncuesta);
        paciente.realizarEncuesta();

        System.out.println(paciente);
    }
}