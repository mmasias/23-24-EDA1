import java.util.Scanner;

public class SistemaEncuestas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el árbol de encuestas
        ArbolEncuestas arbolEncuestas = new ArbolEncuestas();

        // Pedir el nombre del paciente
        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        // Menú principal
        int opcion;
        do {
            System.out.println("Paciente: " + nombrePaciente);
            System.out.println("Seleccione opción:");
            System.out.println("1. Ingresar encuesta");
            System.out.println("2. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarEncuesta(scanner, arbolEncuestas, nombrePaciente);
                    break;
                case 2:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 2);
    }

    private static void ingresarEncuesta(Scanner scanner, ArbolEncuestas arbolEncuestas, String nombrePaciente) {
        // Crear una nueva encuesta
        Encuesta encuesta = new Encuesta();

        // Ingresar datos para un día específico
        System.out.print("Seleccione el día (1-5): ");
        int numeroDia = scanner.nextInt();

        // Validar el rango del día
        if (numeroDia < 1 || numeroDia > 5) {
            System.out.println("Número de día no válido.");
            return;
        }

        Dia dia = new Dia();
        System.out.println("Ingrese datos para el día " + numeroDia);

        // Ingresar datos para una ingesta específica
        int numeroIngesta;
        do {
            System.out.println("Seleccione ingesta:");
            System.out.println("1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
            numeroIngesta = scanner.nextInt();

            // Validar el rango de la ingesta
            if (numeroIngesta < 1 || numeroIngesta > 5) {
                System.out.println("Número de ingesta no válido.");
            } else {
                Ingesta ingesta = obtenerIngestaPorNumero(dia, numeroIngesta);
                System.out.println("Ingrese alimentos para " + obtenerNombreIngesta(numeroIngesta) + " del día " + numeroDia);

                // Ingresar alimentos
                ingresarAlimentos(scanner, ingesta);

                // Luego de ingresar los alimentos, agregamos la ingesta al día
                dia.agregarIngesta(ingesta);

                System.out.println("Ingesta ingresada exitosamente.");
            }
        } while (numeroIngesta != -1);
        
        // Agregar el día a la encuesta
        encuesta.agregarDia(dia);

        // Agregar la encuesta al árbol
        arbolEncuestas.agregarEncuesta(encuesta);

        System.out.println("Encuesta ingresada exitosamente.");
    }

    private static String obtenerNombreIngesta(int numeroIngesta) {
        switch (numeroIngesta) {
            case 1:
                return "Desayuno";
            case 2:
                return "Media mañana";
            case 3:
                return "Almuerzo";
            case 4:
                return "Merienda";
            case 5:
                return "Cena";
            default:
                return "Desconocido";
        }
    }

    private static Ingesta obtenerIngestaPorNumero(Dia dia, int numeroIngesta) {
        switch (numeroIngesta) {
            case 1:
                return dia.getDesayuno();
            case 2:
                return dia.getMediaManana();
            case 3:
                return dia.getAlmuerzo();
            case 4:
                return dia.getMerienda();
            case 5:
                return dia.getCena();
            default:
                return null;
        }
    }

    private static void ingresarAlimentos(Scanner scanner, Ingesta ingesta) {
        int opcion;
        do {
            System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados):");
            String nombreAlimento = scanner.next();

            if ("-1".equals(nombreAlimento)) {
                break;
            } else if ("-2".equals(nombreAlimento)) {
                listarAlimentos(ingesta);
            } else {
                ingesta.agregarAlimento(new Alimento(nombreAlimento));
            }
        } while (true);
    }

    private static void listarAlimentos(Ingesta ingesta) {
        System.out.println("Alimentos ingresados:");
        for (Alimento alimento : ingesta.getAlimentos()) {
            System.out.println(alimento.getNombre());
        }
    }
}