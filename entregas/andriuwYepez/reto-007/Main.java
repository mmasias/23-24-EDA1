import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = new Paciente();

        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        // Acumulador para todas las tablas
        StringBuilder todasLasTablas = new StringBuilder();

        // Acumulador para todos los informes
        StringBuilder todosLosInformes = new StringBuilder();

        for (int dia = 1; dia <= 2; dia++) {
            System.out.print("Ingrese la fecha para la encuesta del día " + dia + " con el formato (dd/mm/yyyy): ");
            String fechaEncuesta = scanner.nextLine();

            Encuesta encuesta = new Encuesta(dia, fechaEncuesta);

            StringBuilder tabla = new StringBuilder();
            tabla.append("+--------------+-----------+-----------+-----------+-----------+\n");
            tabla.append(String.format("| %-12s | %-9s | %-9s | %-9s | %-9s |\n", "Fecha", "Paciente", "Día", "Ingesta", "Alimentos"));
            tabla.append("+--------------+-----------+-----------+-----------+-----------+\n");

            // Acumulador para el informe
            StringBuilder informe = new StringBuilder();
            informe.append("+--------------+\n");
            informe.append("| Informe Día ").append(dia).append(" |").append("\n");
            informe.append("+--------------+\n");

            for (int i = 1; i <= 3; i++) {
                Ingestas ingesta = new Ingestas(i);

                System.out.println("Ingrese datos para el día " + dia + ", ingesta " + i);

                System.out.print("Nombre del alimento: ");
                String nombreAlimento = scanner.nextLine();

                System.out.print("Cantidad: ");
                double cantidad = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea pendiente

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

                // Acumular las líneas en la variable tabla
                tabla.append(String.format("| %-12s | %-9s | %-9s | %-9s | %-9s |\n",
                        fechaEncuesta, nombrePaciente, dia, i, alimento.getNombreAlimento()));
                tabla.append("+--------------+-----------+-----------+-----------+-----------+\n");

                // Acumular las líneas en la variable informe
                informe.append("INGESTA NUMERO ").append(i).append("\n");
                informe.append("Fecha: ").append(fechaEncuesta).append("\n");
                informe.append("Nombre del alimento: ").append(alimento.getNombreAlimento()).append("\n");
                informe.append("Cantidad: ").append(alimento.getCantidad()).append("\n");
                informe.append("Método de preparación: ").append(alimento.getMetodoPreparacion()).append("\n");
                informe.append("Marca: ").append(alimento.getMarca()).append("\n");
                informe.append("Tamaño de porción: ").append(alimento.getTamañoPorcion()).append("\n\n");
            }

            // Acumular las líneas de la tabla en todasLasTablas
            todasLasTablas.append(tabla.toString());

            // Acumular las líneas del informe en todosLosInformes
            todosLosInformes.append(informe.toString());

            paciente.agregarEncuesta(encuesta);
        }

        // Mostrar todas las tablas al final
        System.out.println(todasLasTablas.toString());

        // Mostrar todos los informes al final
        System.out.println(todosLosInformes.toString());

        // Resto del código para acceder y mostrar los datos
    }
}
