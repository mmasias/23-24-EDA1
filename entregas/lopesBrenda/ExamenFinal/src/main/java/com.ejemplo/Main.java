import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el nombre del paciente: ");
    String nombrePaciente = scanner.nextLine();
    System.out.println("Bienvenido al Sistema de Gestión de Encuestas de 24 Horas, " + nombrePaciente + "!");

    EncuestaNutricional encuesta = new EncuestaNutricional(nombrePaciente);

    while (true) {
      System.out.println("\nMenú:");
      System.out.println("1. Agregar día");
      System.out.println("2. Registrar alimento");
      System.out.println("3. Mostrar encuesta");
      System.out.println("4. Salir");

      System.out.print("Seleccione una opción: ");
      int opcion = scanner.nextInt();
      scanner.nextLine();  // Consumir la nueva línea después de nextInt()

      switch (opcion) {
        case 1:
          System.out.print("Ingrese el número del día: ");
          int numeroDia = scanner.nextInt();
          encuesta.agregarDia(numeroDia);
          System.out.println("Día " + numeroDia + " agregado correctamente.");
          break;

        case 2:
          System.out.print("Ingrese el número del día: ");
          int diaRegistro = scanner.nextInt();
          scanner.nextLine();  // Consumir la nueva línea después de nextInt()

          System.out.print("Ingrese el tipo de ingesta (Desayuno, Media mañana, Almuerzo, Merienda, Cena): ");
          String tipoIngesta = scanner.nextLine();

          System.out.print("Ingrese el nombre del alimento: ");
          String nombreAlimento = scanner.nextLine();

          encuesta.registrarAlimento(diaRegistro, tipoIngesta, nombreAlimento);
          System.out.println("Alimento registrado correctamente.");
          break;

        case 3:
          encuesta.mostrarEncuesta();
          break;

        case 4:
          System.out.println("Saliendo del programa. ¡Hasta luego!");
          System.exit(0);

        default:
          System.out.println("Opción no válida. Intente nuevamente.");
      }
    }
  }
}