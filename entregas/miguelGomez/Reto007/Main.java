import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del paciente: ");
        String pacienteNombre = scanner.nextLine();
        System.out.print("Fecha de toma de la encuesta: ");
        String fechaToma = scanner.nextLine();

        Encuesta encuesta = new Encuesta(pacienteNombre, fechaToma);

        while (true) {
            try {
                System.out.print("Seleccione día (1-5) o -1 para salir: ");
                int diaNumero = Integer.parseInt(scanner.nextLine());
                if (diaNumero == -1) {
                    break;
                }

                Dia dia = new Dia(diaNumero);

                while (true) {
                    System.out.print("Seleccione ingesta (1-5 Desayuno-Almuerzo-Comida-Merienda-Cena ) o -1 para volver al menú anterior: ");
                    int ingestaTipo = Integer.parseInt(scanner.nextLine());
                    if (ingestaTipo == -1) {
                        break;
                    }

                    Ingesta ingesta = dia.getIngestas().get(ingestaTipo - 1);

                    while (true) {
                        System.out.print("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados): ");
                        String alimentoNombre = scanner.nextLine();
                        if (alimentoNombre.equals("-1")) {
                            break;
                        } else if (alimentoNombre.equals("-2")) {
                            System.out.println("Alimentos ingresados:");
                            for (Alimento alimento : ingesta.getAlimentos()) {
                                System.out.println(alimento.getNombre());
                            }
                        } else {
                            Alimento alimento = new Alimento(alimentoNombre);
                            ingesta.agregarAlimento(alimento);
                        }
                    }
                }

                encuesta.agregarDia(dia);

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }

       
        System.out.println("\nEncuesta completada:");
        System.out.println("Paciente: " + encuesta.getPaciente());
        System.out.println("Fecha de toma: " + encuesta.getFechaToma());

        for (Dia dia : encuesta.getDias()) {
            System.out.println("\nDia " + dia.getNumero() + ":");
            for (Ingesta ingesta : dia.getIngestas()) {
                System.out.println("  " + ingesta.getTipo() + ":");
                for (Alimento alimento : ingesta.getAlimentos()) {
                    System.out.println("    " + alimento.getNombre());
                }
            }
        }
    }
}