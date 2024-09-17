import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

public class Gestion {
    private Arbol<Paciente> pacientes;

    public Gestion() {
        this.pacientes = new Arbol<>(Comparator.comparing(Paciente::getNombre));
    }

    public void iniciarInterfazUsuario() {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = buscarOCrearPaciente(scanner);

        LocalDate fechaAlta = null;
        while (fechaAlta == null) {
            System.out.print("Ingrese la fecha de alta del paciente (formato dd/MM/yyyy): ");
            try {
                fechaAlta = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                paciente.setFechaAlta(fechaAlta);
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Por favor, intente de nuevo.");
            }
        }

        LocalDate fechaEncuesta = null;
        while (fechaEncuesta == null || fechaEncuesta.isBefore(fechaAlta)) {
            System.out.print("Ingrese la fecha de la encuesta (formato dd/MM/yyyy): ");
            try {
                fechaEncuesta = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (fechaEncuesta.isBefore(fechaAlta)) {
                    System.out.println("La fecha de la encuesta no puede ser anterior a la fecha de alta. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Por favor, intente de nuevo.");
            }
        }
        Encuesta encuesta = buscarOCrearEncuesta(paciente, fechaEncuesta);

        System.out.print("Ingrese la hora de la encuesta (formato HH:mm): ");
        try {
            LocalTime horaEncuesta = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
            encuesta.setHoraEncuesta(horaEncuesta);
        } catch (Exception e) {
            System.out.println("Formato de hora inválido.");
        }

        int numeroDia;
        do {
            System.out.print("Seleccione un día para ingresar datos (1-5) o -1 para terminar: ");
            try {
                numeroDia = Integer.parseInt(scanner.nextLine());
                if (numeroDia != -1 && (numeroDia < 1 || numeroDia > 5)) {
                    System.out.println("Número de día inválido. Por favor, seleccione un número entre 1 y 5.");
                    continue;
                }

                if (numeroDia != -1) {
                    Dia dia = buscarOCrearDia(encuesta, numeroDia);
                    manejarIngestas(scanner, dia);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                numeroDia = 0;
            }
        } while (numeroDia != -1);

        System.out.println(paciente);
        scanner.close();
    }

    private Paciente buscarOCrearPaciente(Scanner scanner) {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();

        Paciente paciente = pacientes.buscar(new Paciente(nombre));
        if (paciente == null) {
            paciente = new Paciente(nombre);

            System.out.print("Ingrese el peso del paciente (kg): ");
            double peso = scanner.nextDouble();
            paciente.setPeso(peso);

            System.out.print("Ingrese la altura del paciente (cm): ");
            int altura = scanner.nextInt();
            paciente.setAltura(altura);

            System.out.print("Ingrese la edad del paciente: ");
            int edad = scanner.nextInt();
            paciente.setEdad(edad);

            System.out.print("Ingrese el sexo del paciente (m/f): ");
            char sexo = scanner.next().charAt(0);
            paciente.setSexo(sexo);

            System.out.print("Ingrese el DNI del paciente: ");
            String dni = scanner.next();
            paciente.setDni(dni);

            pacientes.insertar(paciente);

            scanner.nextLine();
        }
        return paciente;
    }

    private Paciente buscarOCrearPaciente(String nombre) {
        Paciente paciente = pacientes.buscar(new Paciente(nombre));
        if (paciente == null) {
            paciente = new Paciente(nombre);
            pacientes.insertar(paciente);
        }
        return paciente;
    }

    private Encuesta buscarOCrearEncuesta(Paciente paciente, LocalDate fecha) {
        Encuesta encuesta = paciente.getEncuestas().buscar(new Encuesta(fecha));
        if (encuesta == null) {
            encuesta = new Encuesta(fecha);
            paciente.agregarEncuesta(encuesta);
        }
        return encuesta;
    }

    private Dia buscarOCrearDia(Encuesta encuesta, int numeroDia) {
        Dia dia = encuesta.getDias().buscar(new Dia(numeroDia));
        if (dia == null) {
            dia = new Dia(numeroDia);
            encuesta.agregarDia(dia);
        }
        return dia;
    }

    private void manejarIngestas(Scanner scanner, Dia dia) {
        boolean continuar = true;
        while (continuar) {
            System.out.print("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú anterior): ");
            int opcion = Integer.parseInt(scanner.nextLine());

            while (!(opcion == -1 || (opcion >= 1 && opcion <= 5))) {
                System.out.println("Número inválido. Las opciones válidas son -1, 1, 2, 3, 4, 5. Intente de nuevo.");
                System.out.print("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú anterior): ");
                opcion = Integer.parseInt(scanner.nextLine());
            }

            if (opcion == -1) {
                continuar = false;
            } else {
                String tipoIngesta = tipoIngestaSegunOpcion(opcion);
                System.out.print("Ingrese la hora para el " + tipoIngesta + " (formato HH:mm): ");
                LocalTime horaIngesta = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));

                Ingesta ingesta = dia.getIngestas().buscar(new Ingesta(tipoIngesta, horaIngesta));
                if (ingesta == null) {
                    ingesta = new Ingesta(tipoIngesta, horaIngesta);
                    dia.agregarIngesta(ingesta);
                }

                manejarAlimentos(scanner, ingesta);
            }
        }
    }

    private String tipoIngestaSegunOpcion(int opcion) {
        switch (opcion) {
            case 1: return "Desayuno";
            case 2: return "Media mañana";
            case 3: return "Almuerzo";
            case 4: return "Merienda";
            case 5: return "Cena";
            default: return "Otra";
        }
    }

    private void manejarAlimentos(Scanner scanner, Ingesta ingesta) {
        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese un alimento para " + ingesta.getTipoComida() + " (-1 para terminar / -2 para listar alimentos ingresados): ");
            String nombreAlimento = scanner.nextLine();

            if ("-1".equals(nombreAlimento)) {
                continuar = false;
                break;
            } else if ("-2".equals(nombreAlimento)) {
                System.out.println(ingesta.listarAlimentos());
            } else {
                double cantidad = -1;
                while (cantidad < 0) {
                    System.out.print("Ingrese la cantidad del alimento (en gramos, solo números positivos): ");
                    try {
                        cantidad = Double.parseDouble(scanner.nextLine());
                        if (cantidad < 0) {
                            System.out.println("Por favor, ingrese un valor positivo.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    }
                }
                ingesta.agregarAlimento(new Alimento(nombreAlimento, cantidad));
            }
        }
    }

}
