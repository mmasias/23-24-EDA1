package ExamenFinal;

import java.util.Scanner;

public class Main {
    static List<User> patients = new List<>();
    static List<Food> alimentos = new List<>();
    static Scanner numeros = new Scanner(System.in);
    static Scanner textos = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = showMenu();
            switch (opcion) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción Inválida");
                    break;
            }
        } while (opcion != 5 && opcion != 3);
    }

    private static int showMenu() {
        System.out.println("\n---Menu---");
        System.out.println("1 - Añadir Dieta");
        System.out.println("2 - Mostrar Dieta");
        System.out.println("3 - Salir");
        System.out.print("\nElige Opción: ");
        return numeros.nextInt();
    }


    private static void addPatient() {
        System.out.print("Paciente: ");
        String nombrePaciente = textos.nextLine();


        User paciente = new User(nombrePaciente);

        System.out.print("Seleccione día (1-5): ");
        int dia = numeros.nextInt();
        String nombreDia = "Dia " + dia;
        Day day = new Day(nombreDia);

        while (true) {
            System.out.print("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Salir): ");
            int ingestaNumero = numeros.nextInt();
            if (ingestaNumero == -1) {
                break;
            }

            String nombreIngesta = obtenerNombreIngesta(ingestaNumero);
            Ingesta ingesta = new Ingesta(nombreIngesta);

            agregarAlimentosAIngesta(ingesta);
            day.addIngesta(ingesta);
        }

        paciente.addDay(day);
        patients.insert(paciente, -1);
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


    private static void showData() {
        Node<User> current = patients.getFirst();
        while (current != null) {
            current.getData().showData();
            current = current.getNext();
        }
    }

    private static void agregarAlimentosAIngesta(Ingesta ingesta) {
        String nombreAlimento;
        while (true) {
            System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados):");
            nombreAlimento = textos.nextLine();

            if (nombreAlimento.equals("-1")) {
                break;
            } else if (nombreAlimento.equals("-2")) {
                ingesta.showMenu();
            } else {
                ingesta.addFood(new Food(nombreAlimento));
            }
        }
    }

}
