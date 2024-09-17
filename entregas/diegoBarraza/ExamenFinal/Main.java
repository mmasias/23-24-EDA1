package ExamenFinal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombreCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nombreCliente);
        MenuInteractivo menu = new MenuInteractivo(cliente);

        System.out.println("Bienvenido " + nombreCliente);
        menu.mostrarMenuPrincipal();

        scanner.close();
    }
}
