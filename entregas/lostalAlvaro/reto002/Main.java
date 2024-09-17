package reto002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Spreadsheet hoja = new Spreadsheet(15, 10); // Crear una hoja de 15 filas y 10 columnas

        boolean terminar = false;

        do {
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("| |   A  |   B  |   C  |   D  |   E  |   F  |   G  |   H  |   I  |   J  |");
            System.out.println("+------------------------------------------------------------------------+");
            hoja.imprimir();
            System.out.println("CMDs: [W] Arriba | [S] Abajo | [A] Izquierda | [D] Derecha | [E] Editar | [F] Salir");
            System.out.print("Ingrese un comando: ");

            char inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S':
                    hoja.moverAbajo();
                    break;
                case 'w', 'W':
                    hoja.moverArriba();
                    break;
                case 'a', 'A':
                    hoja.moverIzquierda();
                    break;
                case 'd', 'D':
                    hoja.moverDerecha();
                    break;
                case 'E', 'e':
                    hoja.editarCelda();
                    break;
                case 'f', 'F':
                    terminar = true;
            }
        } while (!terminar);
    }
}