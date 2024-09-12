import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gestion {
    private GenericList<Paciente> pacientes;

    public Gestion() {
        pacientes = new GenericList<>();
    }

    public void iniciarInterfazUsuario() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese el nombre del paciente o 'salir' para terminar: ");
            String input = scanner.nextLine();
            if ("salir".equalsIgnoreCase(input)) break;

            Paciente paciente = buscarOCrearPaciente(scanner, input);

            LocalDate fechaEncuesta;
            while (true) {
                System.out.print("Ingrese la fecha de la encuesta (formato dd/MM/yyyy) o 'salir' para terminar: ");
                String fechaInput = scanner.nextLine();
                if ("salir".equalsIgnoreCase(fechaInput)) break;

                try {
                    fechaEncuesta = LocalDate.parse(fechaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Encuesta encuesta = buscarOCrearEncuesta(paciente, fechaEncuesta);
                    manejarDias(scanner, encuesta);
                } catch (Exception e) {
                    System.out.println("Formato de fecha inválido. Por favor, intente de nuevo.");
                }
            }
        }
        scanner.close();
    }

    private Paciente buscarOCrearPaciente(Scanner scanner, String nombre) {
        GenericNode<Paciente> current = pacientes.getFirst();
        while (current != null) {
            Paciente p = current.getValue();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
            current = current.getNext();
        }

        Paciente nuevoPaciente = new Paciente(nombre);
        System.out.print("Ingrese el peso del paciente (kg): ");
        nuevoPaciente.setPeso(scanner.nextDouble());
        System.out.print("Ingrese la altura del paciente (cm): ");
        nuevoPaciente.setAltura(scanner.nextInt());
        System.out.print("Ingrese la edad del paciente: ");
        nuevoPaciente.setEdad(scanner.nextInt());
        System.out.print("Ingrese el sexo del paciente (m/f): ");
        nuevoPaciente.setSexo(scanner.next().charAt(0));
        System.out.print("Ingrese el DNI del paciente: ");
        nuevoPaciente.setDni(scanner.next());
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese la fecha de alta del paciente (formato dd/MM/yyyy): ");
        try {
            LocalDate fechaAlta = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            nuevoPaciente.setFechaAlta(fechaAlta);
        } catch (Exception e) {
            System.out.println("Formato de fecha de alta inválido. Se usará la fecha actual.");
            nuevoPaciente.setFechaAlta(LocalDate.now());
        }

        pacientes.insertEnd(nuevoPaciente);
        return nuevoPaciente;
    }

    private Encuesta buscarOCrearEncuesta(Paciente paciente, LocalDate fecha) {
        GenericList<Encuesta> encuestas = paciente.getEncuestas();
        GenericNode<Encuesta> current = encuestas.getFirst();
        while (current != null) {
            Encuesta encuesta = current.getValue();
            if (encuesta.getFechaEncuesta().equals(fecha)) {
                return encuesta;
            }
            current = current.getNext();
        }

        Encuesta nuevaEncuesta = new Encuesta(fecha);
        paciente.agregarEncuesta(nuevaEncuesta);
        return nuevaEncuesta;
    }
    
    private void manejarDias(Scanner scanner, Encuesta encuesta) {
        System.out.println("Manejando días para la encuesta.");
        while (true) {
            System.out.print("Ingrese el número del día para añadir datos (1-7), o 0 para finalizar: ");
            int numeroDia = scanner.nextInt();
            if (numeroDia == 0) {
                break;
            }
            if (numeroDia < 1 || numeroDia > 7) {
                System.out.println("Número de día inválido. Por favor, ingrese un número entre 1 y 7.");
                continue;
            }
    
            Dia dia = encuesta.buscarDia(numeroDia);
            if (dia == null) {
                dia = new Dia(numeroDia);
                encuesta.agregarDia(dia);
            }
            manejarIngestas(scanner, dia);
        }
    }
    
    private void manejarIngestas(Scanner scanner, Dia dia) {
        System.out.println("Manejando ingestas para el día: " + dia.getNumeroDia());
        scanner.nextLine(); // Limpiar buffer después de leer números
        while (true) {
            System.out.print("Ingrese el tipo de ingesta (Desayuno, Almuerzo, etc.), o 'salir' para finalizar: ");
            String tipoIngesta = scanner.nextLine();
            if ("salir".equalsIgnoreCase(tipoIngesta)) {
                break;
            }
    
            System.out.print("Ingrese la hora de la ingesta (HH:mm): ");
            String horaIngestaStr = scanner.nextLine();
            LocalTime horaIngesta = LocalTime.parse(horaIngestaStr, DateTimeFormatter.ofPattern("HH:mm"));
    
            Ingesta ingesta = dia.buscarIngesta(tipoIngesta);
            if (ingesta == null) {
                ingesta = new Ingesta(tipoIngesta, horaIngesta);
                dia.agregarIngesta(ingesta);
            } else {
                ingesta.setHorario(horaIngesta); // Actualizar la hora si la ingesta ya existe
            }
    
            manejarAlimentos(scanner, ingesta);
        }
    }
    
    private void manejarAlimentos(Scanner scanner, Ingesta ingesta) {
        System.out.println("Añadiendo alimentos a " + ingesta.getTipoComida());
        while (true) {
            System.out.print("Ingrese el nombre del alimento (o 'salir' para terminar): ");
            String nombreAlimento = scanner.nextLine();
            if ("salir".equalsIgnoreCase(nombreAlimento)) {
                break;
            }
    
            System.out.print("Ingrese la cantidad de " + nombreAlimento + " en gramos: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer después de leer números
    
            Alimento alimento = new Alimento(nombreAlimento, cantidad);
            ingesta.agregarAlimento(alimento);
        }


    }

    public void mostrarPacientes() {
        System.out.println("Pacientes registrados:");
        GenericNode<Paciente> current = pacientes.getFirst();
        while (current != null) {
            Paciente paciente = current.getValue();
            System.out.println(paciente.toString());
            current = current.getNext();
        }
    }
    // Suponiendo que esta es la estructura de tus clases Dia, Ingesta, y Alimento.
    // Las clases Paciente y Encuesta deben tener métodos como agregarEncuesta(), buscarDia(), agregarDia(), buscarIngesta() y agregarIngesta() adecuadamente implementados.
    
    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        gestion.iniciarInterfazUsuario();
        gestion.mostrarPacientes();
    }
}