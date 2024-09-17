import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escriba el nombre del paciente:");
        String nombrePaciente = scanner.nextLine();

        System.out.println("Escriba la fecha de alta del paciente:");
        String fechaAltaPaciente = scanner.nextLine();

        System.out.println("Escriba el número de días que dura la encuesta:");
        int numDiasEncuesta = Integer.parseInt(scanner.nextLine());

        Paciente paciente = new Paciente(nombrePaciente, fechaAltaPaciente, numDiasEncuesta);
        paciente.realizarEncuesta();

        System.out.println(paciente);
    }
}