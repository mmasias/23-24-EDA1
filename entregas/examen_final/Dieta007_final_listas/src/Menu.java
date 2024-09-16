import java.util.Scanner;

public class Menu {
    static List<Patient> patients = new List<>();
    static List<Food> alimentos = new List<>();
    static Scanner numeros = new Scanner(System.in);
    static Scanner textos = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = showMenu();
            switch (opcion) {
                case 1:
                    addPatientWithDiet();
                    break;
                case 2:
                    showAllDiets();
                    break;
                case 3:
                    findAndShowPatient();
                    break;
                case 4:
                    removePatient();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción Inválida");
                    break;
            }
        } while (opcion != 5);
    }

    private static int showMenu() {
        System.out.println("\n---DIETAS---");
        System.out.println("1 - Añadir Paciente");
        System.out.println("2 - Mostrar Dietas de Todos los Pacientes");
        System.out.println("3 - Buscar y Mostrar Datos de un Paciente");
        System.out.println("4 - Eliminar Paciente");
        System.out.println("5 - Salir");
        System.out.print("\nElige Opción: ");
        return numeros.nextInt();
    }

    private static void addPatient() {
        System.out.print("Nombre del Paciente: ");
        String nombrePaciente = textos.nextLine();
        Patient nuevoPaciente = new Patient(nombrePaciente);
        patients.insert(nuevoPaciente, -1);
        System.out.println("Paciente añadido con éxito.");
    }

    private static void addPatientWithDiet() {
        System.out.print("Paciente: ");
        String nombrePaciente = textos.nextLine();

        if (findPatientNode(nombrePaciente) != null) {
            System.out.println("\nEl paciente ya existe.");
            return;
        }

        Patient nuevoPaciente = new Patient(nombrePaciente);

        System.out.print("Seleccione día (1-5): ");
        int dia = numeros.nextInt();
        String nombreDia = "Dia " + dia;
        Day day = new Day(nombreDia);

        while (true) {
            System.out.print("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Salir): ");
            int ingesta = numeros.nextInt();
            if (ingesta == -1) {
                break;
            }

            String nombreIngesta = obtenerNombreIngesta(ingesta);
            Intakes intakes = new Intakes(nombreIngesta);

            agregarAlimentosAIngesta(intakes);
            day.addIntake(intakes);
        }

        nuevoPaciente.addDay(day);
        patients.insert(nuevoPaciente, -1);
    }


    private static String obtenerNombreIngesta(int ingesta) {
        switch (ingesta) {
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
                return "Invalido";
        }
    }


    private static void showAllDiets() {
        Node<Patient> current = patients.getFirst();
        while (current != null) {
            current.getData().showData();
            current = current.getNext();
        }
    }
    private static void findAndShowPatient() {
        System.out.print("Introduce el nombre del Paciente: ");
        String nombrePaciente = textos.nextLine();
        Node<Patient> pacienteNode = findPatientNode(nombrePaciente);
        if (pacienteNode != null) {
            pacienteNode.getData().showData();
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private static Node<Patient> findPatientNode(String nombre) {
        Node<Patient> current = patients.getFirst();
        while (current != null) {
            if (current.getData().getName().equalsIgnoreCase(nombre)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    private static void agregarAlimentosAIngesta(Intakes intakes) {
        String nombreAlimento;
        while (true) {
            System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados):");
            nombreAlimento = textos.nextLine();

            if (nombreAlimento.equals("-1")) {
                break;
            } else if (nombreAlimento.equals("-2")) {
                intakes.showMenu();
            } else {
                System.out.print("Ingrese las kcal para " + nombreAlimento + ": ");
                int kcal = numeros.nextInt();
                intakes.addFood(new Food(nombreAlimento, kcal));
            }
        }
    }

    private static void removePatient() {
        System.out.print("Nombre del paciente a eliminar: ");
        String nombrePaciente = textos.nextLine();
        boolean eliminado = removePatientFromList(nombrePaciente);
        if (eliminado) {
            System.out.println("Paciente eliminado con éxito.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private static boolean removePatientFromList(String nombrePaciente) {
        if (patients.getFirst() == null) {
            return false;
        }

        if (patients.getFirst().getData().getName().equalsIgnoreCase(nombrePaciente)) {
            patients.removeFirst();
            return true;
        }

        Node<Patient> current = patients.getFirst();
        while (current.getNext() != null) {
            if (current.getNext().getData().getName().equalsIgnoreCase(nombrePaciente)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }

        return false;
    }
}
