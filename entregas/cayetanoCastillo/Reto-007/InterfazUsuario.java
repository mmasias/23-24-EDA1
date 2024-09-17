package ProyectoFinal;

import java.util.Scanner;

public class InterfazUsuario {
    private Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarInstrucciones() {
        System.out.println("Instrucciones:");
        System.out.println("1. Ingresará el nombre del paciente.");
        System.out.println(
                "2. Proporcionará datos básicos del paciente como altura, peso, sexo, edad y frecuencia de ejercicio.");
        System.out.println("3. Completará una encuesta alimentaria detallada.");
        System.out.println(
                "4. No podrá añadir alimentos conformados por más de una palabra, se recomienda ingresarlos con camel case... (TortillaDePatata)");
        System.out.println(
                "5. Al finalizar el programa se mostrará un resumen de las ingestas del paciente, junto a sus datos.");
        // Agrega más instrucciones según sea necesario
    }

    public boolean pedirConfirmacionInstrucciones() {
        System.out.println("¿Desea ver las instrucciones? (si/no)");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        while (!respuesta.equals("si") && !respuesta.equals("no")) {
            System.out.println("Respuesta inválida. Por favor, ingrese 'si' o 'no':");
            respuesta = scanner.nextLine().trim().toLowerCase();
        }
        return respuesta.equals("si");
    }

    public String solicitarNombrePaciente() {
        System.out.println("Ingrese el nombre del paciente:");
        String nombrePaciente = scanner.nextLine();
        while (!nombrePaciente.matches("[a-zA-Z ]+")) {
            System.out.println("Por favor, ingrese solo letras para el nombre:");
            nombrePaciente = scanner.nextLine();
        }
        return nombrePaciente;
    }

    public double solicitarAlturaPaciente() {
        System.out.println("Ingrese la altura del paciente (en cm):");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número válido para la altura:");
            scanner.next(); // Limpiar entrada incorrecta
        }
        double altura = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del escáner
        return altura;
    }

    public double solicitarPesoPaciente() {
        System.out.println("Ingrese el peso del paciente (en kg):");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número válido para el peso:");
            scanner.next(); // Limpiar entrada incorrecta
        }
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del escáner
        return peso;
    }

    public String solicitarSexoPaciente() {
        System.out.println("Ingrese el sexo del paciente (masculino/femenino):");
        String sexo = scanner.nextLine();
        while (!sexo.equalsIgnoreCase("masculino") && !sexo.equalsIgnoreCase("femenino")) {
            System.out.println("Por favor, ingrese 'masculino' o 'femenino' para el sexo:");
            sexo = scanner.nextLine();
        }
        return sexo;
    }

    public int solicitarEdadPaciente() {
        System.out.println("Ingrese la edad del paciente:");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido para la edad:");
            scanner.next(); // Limpiar entrada incorrecta
        }
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del escáner
        return edad;
    }

    public String solicitarFrecuenciaEjercicio() {
        System.out.println("Ingrese la frecuencia de ejercicio semanal (baja/media/alta):");
        String frecuenciaEjercicio = scanner.nextLine();
        while (!frecuenciaEjercicio.equalsIgnoreCase("baja") && !frecuenciaEjercicio.equalsIgnoreCase("media")
                && !frecuenciaEjercicio.equalsIgnoreCase("alta")) {
            System.out.println("Por favor, ingrese 'baja', 'media' o 'alta' para la frecuencia de ejercicio:");
            frecuenciaEjercicio = scanner.nextLine();
        }
        return frecuenciaEjercicio;
    }
}