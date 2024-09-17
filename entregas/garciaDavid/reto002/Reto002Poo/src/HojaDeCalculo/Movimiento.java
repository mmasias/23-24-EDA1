package HojaDeCalculo;

import java.util.Scanner;

public class Movimiento {
    Scanner scanner = new Scanner(System.in);
    public void imprimirOpciones() {
        System.out.println("\nOpciones:");
        System.out.println("W - Mover arriba");
        System.out.println("A - Mover izquierda");
        System.out.println("S - Mover abajo");
        System.out.println("D - Mover derecha");
        System.out.println("E - Editar celda");
        System.out.println("Q - Salir");

    }
    public void moverse(Tabla tabla, String direccion, String texto) {
        switch (direccion) {
            case "W":
                tabla.moverArriba();
                break;
            case "A":
                tabla.moverIzquierda();
                break;
            case "S":
                tabla.moverAbajo();
                break;
            case "D":
                tabla.moverDerecha();
                break;
            case "E":
                tabla.agregarTexto(texto);
                break;
            case "Q":
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public String leerDireccion() {
        return scanner.nextLine().toUpperCase();
    }
}
