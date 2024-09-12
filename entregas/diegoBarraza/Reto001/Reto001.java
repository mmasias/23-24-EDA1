package Reto001;

import java.util.Scanner;

public class Reto001 {
    public static void main(String[] args) {

        int filas = 15;
        int columnas = 10;
        int posicionactualx = 0;
        int posicionactualy = 0;

        String[][] matriz = new String[filas][columnas];
        String[][] valores = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = "       ";
                valores[i][j] = "       ";
            }
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMatriz(matriz);

            System.out.println("Posición actual: " + (posicionactualx + 1) + "," + (posicionactualy + 1));
            System.out.println("Bienvenido al sistema de control, ingrese la opción que desea realizar.");
            System.out.println("W para moverse arriba, S para moverse abajo, A para moverse a la izquierda, D para moverse a la derecha,");
            System.out.println("E para ingresar un valor y Q para salir");

            String opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
                case "W":
                    if (posicionactualx > 0) {
                        matriz[posicionactualx][posicionactualy] = valores[posicionactualx][posicionactualy];
                        posicionactualx--;
                        matriz[posicionactualx][posicionactualy] = "[     ]";
                    }
                    break;
                case "S":
                    if (posicionactualx < filas - 1) {
                        matriz[posicionactualx][posicionactualy] = valores[posicionactualx][posicionactualy];
                        posicionactualx++;
                        matriz[posicionactualx][posicionactualy] = "[     ]";
                    }
                    break;
                case "A":
                    if (posicionactualy > 0) {
                        matriz[posicionactualx][posicionactualy] = valores[posicionactualx][posicionactualy];
                        posicionactualy--;
                        matriz[posicionactualx][posicionactualy] = "[     ]";
                    }
                    break;
                case "D":
                    if (posicionactualy < columnas - 1) {
                        matriz[posicionactualx][posicionactualy] = valores[posicionactualx][posicionactualy];
                        posicionactualy++;
                        matriz[posicionactualx][posicionactualy] = "[     ]";
                    }
                    break;
                case "E":
                    System.out.println("Ingrese el valor que desea ingresar:");
                    String valor = scanner.nextLine();
                    if (valor.length() > 7) {
                        valor = valor.substring(0, 7);
                        System.out.println("El valor ingresado es mayor a 7 caracteres.");
                    }
                    valores[posicionactualx][posicionactualy] = String.format("%7s", valor);
                    matriz[posicionactualx][posicionactualy] = valores[posicionactualx][posicionactualy];
                    break;
                case "Q":
                    System.out.println("Gracias por usar el sistema de control");
                    System.exit(0);
                default:
                    System.out.println("Comando no válido.");
            }
        }
    }

    static void mostrarMatriz(String[][] matriz) {
        System.out.println("    A       B       C       D       E       F       G       H       I       J");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
    }
}
