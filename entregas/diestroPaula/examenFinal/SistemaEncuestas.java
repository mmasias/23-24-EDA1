import java.util.Scanner;

public class SistemaEncuestas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombrePaciente = scanner.nextLine();

        Paciente paciente = new Paciente(nombrePaciente);
        MenuInteractivo menu = new MenuInteractivo(paciente);

        System.out.println("Bienvenido " + nombrePaciente);
        menu.mostrarMenuPrincipal();

        scanner.close();
    }
}