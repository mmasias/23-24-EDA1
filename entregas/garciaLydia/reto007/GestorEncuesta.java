package entregas.garciaLydia.reto007;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GestorEncuesta {
    private Scanner scanner;
    private EncuestaNutricional encuesta;

    public GestorEncuesta() {
        this.scanner = new Scanner(System.in);
    }

    public void simular() {
        scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        System.out.print("Ingrese la fecha de alta (dd/MM/yyyy): ");
        String fechaAlta = scanner.nextLine();

        encuesta = new EncuestaNutricional(nombrePaciente, fechaAlta);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarDia();
                    break;
                case 2:
                    registrarAlimento();
                    break;
                case 3:
                    mostrarEncuesta();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar día");
        System.out.println("2. Registrar alimento");
        System.out.println("3. Mostrar encuesta");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarDia() {
        System.out.print("Ingrese el número del día: ");
        int numeroDia = scanner.nextInt();
        scanner.nextLine();

        Dia dia = new Dia(numeroDia);
        encuesta.agregarDia(dia);

        System.out.println("Día " + numeroDia + " agregado correctamente.");
    }

    private void registrarAlimento() {
        System.out.print("Ingrese el número del día: ");
        int numeroDia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el tipo de ingesta (Desayuno, Media mañana, Almuerzo, Merienda, Cena): ");
        String tipoIngesta = scanner.nextLine();

        System.out.print("Ingrese el nombre del alimento: ");
        String nombreAlimento = scanner.nextLine();

        Alimento alimento = new Alimento(nombreAlimento);

        Optional<Dia> diaOptional = encuesta.getDias().stream()
                .filter(d -> d.getNumero() == numeroDia)
                .findFirst();

        if (diaOptional.isPresent()) {
            diaOptional.get().agregarAlimento(tipoIngesta, alimento);
            System.out.println("Alimento registrado correctamente.");
        } else {
            System.out.println("Día no encontrado. Registre el día primero.");
        }
    }

    private void mostrarEncuesta() {
        System.out.println("Encuesta Nutricional para " + encuesta.getNombrePaciente() + " (Fecha de alta: " +
                encuesta.getFechaAlta() + "):\n");

        for (Dia dia : encuesta.getDias()) {
            System.out.println("Día " + dia.getNumero() + ":");

            List<String> tiposIngesta = dia.getTiposIngesta();
            List<List<Alimento>> alimentosPorTipo = dia.getAlimentosPorTipo();

            for (int i = 0; i < tiposIngesta.size(); i++) {
                String tipoIngesta = tiposIngesta.get(i);
                List<Alimento> alimentos = alimentosPorTipo.get(i);

                System.out.println("  " + tipoIngesta + ":");
                for (Alimento alimento : alimentos) {
                    System.out.println("      " + alimento.getNombre());
                }
            }

            System.out.println();
        }
    }
}