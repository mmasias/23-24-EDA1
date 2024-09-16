import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = new Paciente();

        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        StringBuilder todasLasTablas = new StringBuilder();

        StringBuilder todosLosInformes = new StringBuilder();

        for (int dia = 1; dia <= 2; dia++) {
            System.out.print("Ingrese la fecha para la encuesta del día " + dia + " con el formato (dd/mm/yyyy): ");
            String fechaEncuesta = scanner.nextLine();

            Encuesta encuesta = new Encuesta(dia, fechaEncuesta);

            StringBuilder tabla = new StringBuilder();
            tabla.append("+--------------+-----------+-----------+-----------+-----------+\n");
            tabla.append(String.format("| %-12s | %-9s | %-9s | %-9s | %-9s |\n", "Fecha", "Paciente", "Día", "Ingesta", "Alimentos"));
            tabla.append("+--------------+-----------+-----------+-----------+-----------+\n");

            StringBuilder informe = new StringBuilder();
            informe.append("+--------------+\n");
            informe.append("| Informe Día ").append(dia).append(" |").append("\n");
            informe.append("+--------------+\n");

            for (int i = 1; i <= 3; i++) {
                Ingestas ingesta = new Ingestas(i);

                System.out.println("Ingrese datos para el día " + dia + ", ingesta " + i);

                System.out.print("Nombre del alimento: ");
                String nombreAlimento = scanner.nextLine();

                double cantidad = 0;

                while (true) {
                    System.out.print("Cantidad: ");
                    if (scanner.hasNextDouble()) {
                        cantidad = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Error: ¡Ingresa un valor numérico válido!");
                        scanner.nextLine();
                    }
                }

                System.out.print("Método de preparación: ");
                String metodoPreparacion = scanner.nextLine();

                System.out.print("Marca: ");
                String marca = scanner.nextLine();

                System.out.print("Tamaño de porción: ");
                String tamañoPorcion = scanner.nextLine();

                Alimentos alimento = new Alimentos(nombreAlimento, cantidad, metodoPreparacion, marca, tamañoPorcion);

                List<Dias> dias = encuesta.getDias();

                boolean existeDia = false;
                for (Dias diaObj : dias) {
                    if (diaObj.getNumeroDia() == dia && diaObj.getFecha().equals(fechaEncuesta)) {
                        diaObj.agregarIngesta(ingesta);
                        existeDia = true;
                        break;
                    }
                }

                if (!existeDia) {
                    Dias nuevoDia = new Dias(dia, fechaEncuesta);
                    nuevoDia.agregarIngesta(ingesta);
                    encuesta.agregarDia(nuevoDia);
                }

                tabla.append(String.format("| %-12s | %-9s | %-9s | %-9s | %-9s |\n",
                        fechaEncuesta, nombrePaciente, dia, i, alimento.getNombreAlimento()));
                tabla.append("+--------------+-----------+-----------+-----------+-----------+\n");

                informe.append("INGESTA NUMERO ").append(i).append("\n");
                informe.append("Fecha: ").append(fechaEncuesta).append("\n");
                informe.append("Nombre del alimento: ").append(alimento.getNombreAlimento()).append("\n");
                informe.append("Cantidad: ").append(alimento.getCantidad()).append("\n");
                informe.append("Método de preparación: ").append(alimento.getMetodoPreparacion()).append("\n");
                informe.append("Marca: ").append(alimento.getMarca()).append("\n");
                informe.append("Tamaño de porción: ").append(alimento.getTamañoPorcion()).append("\n\n");
            }

            todasLasTablas.append(tabla.toString());

            todosLosInformes.append(informe.toString());

            paciente.agregarEncuesta(encuesta);
        }

        System.out.println(todasLasTablas.toString());

        System.out.println(todosLosInformes.toString());

    }
}