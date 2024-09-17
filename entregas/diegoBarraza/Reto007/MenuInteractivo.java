package Reto007;

import java.util.Scanner;

public class MenuInteractivo {
    private Scanner scanner;
    private Cliente cliente;
    private Encuesta encuesta;

    public MenuInteractivo(Cliente cliente) {
        this.scanner = new Scanner(System.in);
        this.cliente = cliente;
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            imprimirMenu();
            opcion = obtenerOpcionValida();

            switch (opcion) {
                case 1:
                    registrarNuevoCliente();
                    break;
                case 2:
                    crearNuevaEncuesta();
                    break;
                case 3:
                    abrirEncuestaExistente();
                    break;
                case 4:
                    mostrarResultados();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    private void registrarNuevoCliente() {
        System.out.print("Ingrese el nombre del nuevo cliente: ");
        String nuevoNombreCliente = scanner.nextLine();
        cliente = new Cliente(nuevoNombreCliente);
        System.out.println("Cliente " + nuevoNombreCliente + " registrado exitosamente.");
    }

    private void crearNuevaEncuesta() {
        cliente = new Cliente(cliente.getNombre()); 
        encuesta = new Encuesta();
        ingresarAlimentos();
        System.out.println("Encuesta creada exitosamente para el cliente " + cliente.getNombre() + ".");
    }

    private void abrirEncuestaExistente() {
        ingresarAlimentos();
        System.out.println("Encuesta para el cliente " + cliente.getNombre() + " abierta exitosamente.");
    }

    private void mostrarResultados() {
        System.out.println("Resultados para " + cliente.getNombre() + ":");
        encuesta.obtenerInfoDieta();
    }

    private void imprimirMenu() {
        System.out.println("Menú:");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Crear nueva encuesta");
        System.out.println("3. Editar encuesta existente");
        System.out.println("4. Mostrar resultados");
        System.out.println("0. Salir");
    }

    private int obtenerOpcionValida() {
        int opcion;
        while (true) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        return opcion;
    }

    private void ingresarAlimentos() {
        System.out.println("Ingrese alimentos (escriba '-1' para finalizar):");

        int dia;
        String tipoIngesta;

        do {
            System.out.print("Seleccione día (1.Lunes 2.Martes 3.Miercoles 4.Jueves 5.Viernes, -1 para finalizar / -2 para listar alimentos): ");
            dia = obtenerNumeroValido();

            if (dia == -1) {
                break;
            }

            if (dia == -2) {
                System.out.println("Alimentos ingresados:");
                encuesta.obtenerInfoDieta();
                continue;
            }

            if (dia < 1 || dia > 5) {
                System.out.println("Día no válido. Inténtelo de nuevo.");
                continue;
            }

            int opcionIngesta;
            do {
                imprimirOpcionesIngesta();
                opcionIngesta = obtenerNumeroValido();

                if (opcionIngesta == -1) {
                    break;
                }

                if (opcionIngesta < 1 || opcionIngesta > 5) {
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    continue;
                }

                tipoIngesta = obtenerTipoIngesta(opcionIngesta);
                System.out.println("Ingrese alimentos para " + tipoIngesta + " del día " + dia + " (-1 para terminar):");

                while (true) {
                    System.out.print("Ingrese un alimento: ");
                    String nombreAlimento = scanner.nextLine().trim();

                    if (nombreAlimento.equalsIgnoreCase("-1")) {
                        break;
                    }

                    Alimentos alimento = new Alimentos(nombreAlimento);
                    encuesta.agregarAlimento(alimento, dia, tipoIngesta);
                }
            } while (true);

        } while (true);
    }

    private void imprimirOpcionesIngesta() {
        System.out.println("Seleccione la ingesta que quiere editar:");
        System.out.println("1. Desayuno");
        System.out.println("2. Media Mañana");
        System.out.println("3. Almuerzo");
        System.out.println("4. Merienda");
        System.out.println("5. Cena");
        System.out.println("-1. Salir");
    }

    private String obtenerTipoIngesta(int opcion) {
        switch (opcion) {
            case 1:
                return "Desayuno";
            case 2:
                return "Media Mañana";
            case 3:
                return "Almuerzo";
            case 4:
                return "Merienda";
            case 5:
                return "Cena";
            default:
                return "";
        }
    }

    private int obtenerNumeroValido() {
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        return numero;
    }
}