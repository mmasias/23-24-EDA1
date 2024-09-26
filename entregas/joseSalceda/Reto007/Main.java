import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = new Paciente("Jose Manuel R.");

        System.out.println("Paciente: " + paciente.getNombre());

        while (true) {
            System.out.print("Seleccione día (1-5) o -1 para salir: ");
            int dia = scanner.nextInt();
            if (dia == -1) break;

            Encuesta encuesta = paciente.obtenerEncuestaPorDia(dia);
            if (encuesta == null) {
                encuesta = new Encuesta(dia);
                paciente.agregarEncuesta(encuesta);
            }

            while (true) {
                System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
                int ingestaSeleccionada = scanner.nextInt();
                scanner.nextLine();

                if (ingestaSeleccionada == -1) break;

                Ingesta ingesta = encuesta.obtenerIngesta(ingestaSeleccionada);
                if (ingesta == null) {
                    ingesta = new Ingesta(ingestaSeleccionada);
                    encuesta.agregarIngesta(ingesta);
                }

                while (true) {
                    System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados): ");
                    String alimento = scanner.nextLine();

                    if (alimento.equals("-1")) break;
                    if (alimento.equals("-2")) {
                        ingesta.listarAlimentos();
                        continue;
                    }

                    ingesta.agregarAlimento(alimento);
                }
            }
        }
    }
}